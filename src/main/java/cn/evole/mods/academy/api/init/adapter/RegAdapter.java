package cn.evole.mods.academy.api.init.adapter;

import cn.evole.mods.academy.api.init.registry.RegistryMapping;
import cn.evole.mods.academy.api.interfaces.*;
import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.api.annotations.OnlyIf;
import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.api.annotations.TileRenderer;
import cn.evole.mods.academy.constant.Debug;
import cn.evole.mods.academy.utils.ReflectionUtils;
import cn.evole.mods.academy.utils.ScanDataUtils;
import cn.evole.mods.academy.utils.java.Cast;
import cn.evole.mods.academy.utils.java.tuples.Tuple2;
import cn.evole.mods.academy.utils.java.tuples.Tuples;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;

import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Name: AcademyCraft2 / RegAdapter
 * Author: cnlimiter
 * CreateTime: 2023/12/23 22:50
 * Description:
 */

public class RegAdapter {
    public static <T> Optional<BiConsumer<ResourceLocation, T>> createRegisterer(RegisterEvent event, ResourceKey<? extends Registry<T>> registryType, String prefix)
    {
        Registry<T> reg = event.getRegistry(registryType);
        if(prefix == null) prefix = "";
        if(reg != null)
            return Optional.of(createRegisterer(reg, prefix));

        return Optional.empty();
    }

    public static <T> BiConsumer<ResourceLocation, T> createRegisterer(Registry<T> registry, String prefix)
    {
        return (name, entry) ->
        {
            name = new ResourceLocation(name.getNamespace(), prefix + name.getPath());
            IRegListener l = Cast.cast(entry, IRegListener.class);
            if(l != null) l.onPreRegistered(name);
            Registry.register(registry, name, entry);
            if(l != null) l.onPostRegistered(name);
        };
    }

    private static final Map<Class<?>, List<Tuple2<Block, ResourceLocation>>> blocks = new ConcurrentHashMap<>();


    public static void init(){
        ScanDataUtils.lookupAnnotatedObjects(Reg.class).forEach(data ->
        {
            if(data.getTargetType() == ElementType.TYPE)
                data.getOwnerMod()
                        .ifPresent(mc ->
                        {
                            Debug.log("Hooked " + data.clazz() + " from " + mc.getModId() + " to register it's stuff.");
                            mc.getEventBus()
                                    .addListener((Consumer<RegisterEvent>) event ->
                                            register(event, event.getRegistry(), data.getOwnerClass(), mc.getModId(), data.getProperty("prefix").map(Objects::toString).orElse(""))
                                    );
                        });
        });
    }


    /**
     * Registers all static fields (from source) with the matching registry type, and methods that accept Consumer<T>
     */
    public static <T> int register(RegisterEvent event, Registry<T> registry, Class<?> source, String modid, String prefix)
    {
        var superType = RegistryMapping.getSuperType(registry);
        var regKey = event.getRegistryKey();

        List<Tuple2<Block, ResourceLocation>> blockList = blocks.computeIfAbsent(source, s -> new ArrayList<>());

        BiConsumer<ResourceLocation, T> grabber = createRegisterer(registry, prefix).andThen((key, handler) ->
        {
            if(handler instanceof Block b)
                blockList.add(Tuples.immutable(b, key));
        });

        if(Item.class.equals(superType)) for(var e : blockList)
        {
            Block blk = e.a();
            if(blk instanceof INoItemBlock) continue;
            BlockItem item;
            IItemPropertySupplier gen = Cast.cast(blk, IItemPropertySupplier.class);
            if(blk instanceof ICustomBlockItem) item = ((ICustomBlockItem) blk).createBlockItem();
            else
            {
                Item.Properties props =
                        gen != null ? gen.createItemProperties(new Item.Properties()) : new Item.Properties();
                item = new BlockItem(blk, props);
//                if(blk instanceof ICreativeTabBlock t)
//                    t.getCreativeTab().add(item);
            }
            grabber.accept(e.b(), Cast.cast(item));
        }

        boolean tileRegistryOnClient = BlockEntityType.class.equals(superType) && FMLEnvironment.dist == Dist.CLIENT;
        boolean particleRegistryOnClient = ParticleType.class.equals(superType) && FMLEnvironment.dist == Dist.CLIENT;

        int prevSize = registry != null ? registry.size() : 0;

        // ICustomReg hook!
        Arrays
                .stream(source.getDeclaredFields())
                .filter(f -> ICustomReg.class.isAssignableFrom(f.getType()))
                .forEach(field ->
                {
                    if(Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))
                        try
                        {
                            field.setAccessible(true);
                            var name = field.getAnnotation(RegName.class);

                            var rl = new ResourceLocation(modid, prefix + (name.value() == null ?  field.getName().toLowerCase() :name.value()));

                            var val = field.get(null);

                            var onlyIf = field.getAnnotation(OnlyIf.class); // Bring back OnlyIf, for registries that are non-intrusive. (Mostly, for custom registry types)
                            if(!RegistryMapping.isNonIntrusive(regKey)
                                    || OnlyIfAdapter.checkCondition(onlyIf, source.toString(),
                                    superType != null ? superType.getSimpleName()
                                            : field.getType().getSimpleName(), val, rl
                            ))
                            {
                                if(val instanceof ICustomReg cr)
                                    cr.performRegister(event, rl);
                            }
                        } catch(IllegalArgumentException | IllegalAccessException e)
                        {
                            LogManager.getLogger(modid + "/" + source.getSimpleName())
                                    .error("Failed to register field {}", field.getName(), e);
                        }
                });

        if(superType == null)
            return registry == null ? 0 : registry.size() - prevSize;

        Arrays
                .stream(source.getDeclaredMethods())
                .filter(m -> m.getAnnotation(Reg.class) != null && m.getParameterCount() == 1 &&
                        BiConsumer.class.isAssignableFrom(m.getParameterTypes()[0]) &&
                        ReflectionUtils.doesParameterTypeArgsMatch(m.getParameters()[0], ResourceLocation.class, superType))
                .forEach(method ->
                {
                    final String prefix2 = Optional.ofNullable(method.getAnnotation(Reg.class))
                            .map(Reg::prefix).orElse("");

                    if(Modifier.isStatic(method.getModifiers()))
                        try
                        {
                            method.setAccessible(true);

                            BiConsumer<ResourceLocation, T> grabber2 = (id, obj) ->
                            {
                                id = new ResourceLocation(id.getNamespace(), prefix2 + id.getPath());
                                grabber.accept(id, obj);
                            };

                            method.invoke(null, grabber2);
                        } catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                        {
                            LogManager.getLogger(modid + "/" + source.getSimpleName())
                                    .error("Failed to register method {}", method.getName(), e);
                        }
                });

        Arrays
                .stream(source.getDeclaredFields())
                .filter(f -> superType.isAssignableFrom(f.getType())
                        &&
                        !ICustomReg.class.isAssignableFrom(f.getType())) // Custom registrars have been called by now.
                .forEach(field ->
                {
                    if(Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()))
                        try
                        {
                            field.setAccessible(true);
                            var name = field.getAnnotation(RegName.class);
                            var rl = new ResourceLocation(modid, (name.value() == null ?  field.getName().toLowerCase() :name.value()));

                            var val = field.get(null);

                            var onlyIf = field.getAnnotation(OnlyIf.class); // Bring back OnlyIf, for registries that are non-intrusive. (Mostly, for custom registry types)
                            if(!RegistryMapping.isNonIntrusive(regKey)
                                    ||
                                    OnlyIfAdapter.checkCondition(onlyIf, source.toString(), superType.getSimpleName(), val, rl))
                            {
                                var fval = superType.cast(val);
                                grabber.accept(rl, fval);

                                if(tileRegistryOnClient)
                                {
                                    var tesr = TileRenderer.Info.get(source, field.getName());
                                    if(tesr != null)
                                    {
                                        tesr.apply();
                                        Debug.debug(
                                                "Applied TESR registration for " + field.getType().getSimpleName() +
                                                        "[" + registry.getKey(fval) + "] " + source.getSimpleName() +
                                                        '.' + field.getName());
                                    }
                                }

//                                if(particleRegistryOnClient)
//                                {
//                                    var provider = Particles.Info.get(source, field.getName());
//                                    if(provider != null)
//                                    {
//                                        provider.apply();
//                                        HammerLib.LOG.debug(
//                                                "Applied ParticleProvider for " + field.getType().getSimpleName() +
//                                                        "[" + registry.getKey(fval) + "] " + source.getSimpleName() +
//                                                        '.' + field.getName());
//                                    }
//                                }
                            }
                        } catch(IllegalArgumentException | IllegalAccessException e)
                        {
                            LogManager.getLogger(modid + "/" + source.getSimpleName())
                                    .error("Failed to register field {}", field.getName(), e);
                        }
                });

        return registry.size() - prevSize;
    }
}
