package cn.evole.mods.academy.init.proxy;

import cn.evole.mods.academy.api.client.render.IBESR;
import cn.evole.mods.academy.api.client.render.TESRBase;
import cn.evole.mods.academy.client.model.CatEngineModel;
import cn.evole.mods.academy.constant.Debug;
import cn.evole.mods.academy.utils.ReflectionUtils;
import cn.evole.mods.academy.utils.java.Cast;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.objectweb.asm.Type;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Name: AcademyCraft2 / ClientProxy
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:14
 * Description:
 */

public class ClientProxy extends CommonProxy{

    @Override
    public void construct(IEventBus modBus) {
        modBus.addListener(ClientProxy::onRegisterLayers);
    }

    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CatEngineModel.LAYER_LOCATION, CatEngineModel::createBodyLayer);
    }


    @Override
    public Consumer<FMLClientSetupEvent> addTESR(Type owner, String member, Type tesr)
    {
        return e ->
        {
            ReflectionUtils.<BlockEntityType<?>>getStaticFinalField(ReflectionUtils.fetchClass(owner), member)
                    .ifPresent(type ->
                    {
                        ResourceLocation name = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(type);

                        if(name == null)
                        {
                            Debug.log("Skipping TESR for tile " + type + " as it is not registered.");
                            return;
                        }

                        Debug.log("Registering TESR for tile " + name);

                        Class<?> anyTesr = ReflectionUtils.fetchClass(tesr);

                        Function<BlockEntityRendererProvider.Context, BlockEntityRenderer<?>> theTesr = null;

                        if(IBESR.class.isAssignableFrom(anyTesr))
                        {
                            try
                            {
                                Constructor<?> ctor = anyTesr.getDeclaredConstructor();
                                ctor.setAccessible(true);
                                TESRBase<?> base = new TESRBase<>((IBESR<?>) ctor.newInstance());
                                theTesr = ctx -> base;
                            } catch(ReflectiveOperationException err)
                            {
                                throw new ReportedException(new CrashReport(
                                        "Unable to create IBESR(no-args) for BlockEntityType " + name, err));
                            }
                        }

                        if(theTesr == null)
                        {
                            for(Constructor<?> ctr : anyTesr.getDeclaredConstructors())
                            {
                                try
                                {
                                    if(ctr.getParameterCount() == 0)
                                    {
                                        BlockEntityRenderer<?> r = (BlockEntityRenderer<?>) ctr.newInstance();
                                        theTesr = c -> r;
                                    } else if(ctr.getParameterCount() == 1 &&
                                            ctr.getParameterTypes()[0] == BlockEntityRendererProvider.Context.class)
                                    {
                                        theTesr = ctx ->
                                        {
                                            try
                                            {
                                                return Cast.cast(ctr.newInstance(ctx));
                                            } catch(ReflectiveOperationException err)
                                            {
                                                throw new ReportedException(new CrashReport(
                                                        "Unable to create BlockEntityRenderer(no-args) for BlockEntityType " +
                                                                name, err));
                                            }
                                        };
                                    }
                                } catch(ReflectiveOperationException err)
                                {
                                    throw new ReportedException(new CrashReport(
                                            "Unable to create BlockEntityRenderer(no-args) for BlockEntityType " +
                                                    name, err));
                                }
                            }
                        }

                        if(theTesr == null)
                            throw new RuntimeException(
                                    "Unable to find a valid constructor for " + name + "'s TESR " + anyTesr);

                        Function<BlockEntityRendererProvider.Context, BlockEntityRenderer<?>> finalTheTesr = theTesr;
                        BlockEntityRenderers.register(type, (BlockEntityRendererProvider<BlockEntity>) ctx -> Cast.cast(finalTheTesr.apply(ctx)));
                    });
        };
    }
}
