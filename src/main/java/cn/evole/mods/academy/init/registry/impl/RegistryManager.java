package cn.evole.mods.academy.init.registry.impl;

import cn.evole.mods.academy.constant.Debug;
import cn.evole.mods.academy.init.registry.RegistryCallback;
import cn.evole.mods.academy.init.registry.RegistryMod;
import cn.evole.mods.academy.init.registry.StateEventCallback;
import cn.evole.mods.academy.utils.ReflectionUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.ParallelDispatchEvent;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.RegisterEvent;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 19:46
 * Name RegistryManager
 * Description
 */

public enum RegistryManager {
    INSTANCE;
    public class ModContext {
        public String packageRoot;
        public Object modObject;

        private ModContainer _modContainer;

        HashMap<Class<? extends ParallelDispatchEvent>, List<Method>> loadCallbacks;

        public ModContainer getModContainer() {
            if (_modContainer == null)  {
                _modContainer = FMLLoader.getLoadingModList().ge(modObject);
            }
            return Debug.assertNotNull(_modContainer);
        }
    }

    private Map<String, ModContext> registryMods;

    private final List<Method>
            itemRegistryCallbacks = new ArrayList<>(),
            blockRegistryCallbacks = new ArrayList<>();

    private boolean initialized = false;

    private Object activeMod;

    public Object getActiveMod() {
        return Debug.assertNotNull(activeMod, "No mod is currently being loaded");
    }

    public ModContext findMod(String classPath) {
        for (Map.Entry<String, ModContext> entry : registryMods.entrySet()) {
            if (classPath.startsWith(entry.getValue().packageRoot)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private ModContext createModContext(Class<?> type) {
        ModContext ctx = new ModContext();
        RegistryMod anno = type.getAnnotation(RegistryMod.class);
        Debug.assertNotNull(anno);
        ctx.packageRoot = anno.rootPackage();
        if (ctx.packageRoot.isEmpty()) {
            ctx.packageRoot = type.getPackage().getName();
        }
        ctx.loadCallbacks = new HashMap<>();
        return ctx;
    }

    void registerEventHandler() {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    class EventHandler {
        @SubscribeEvent
        public void onRegisterBlocks(RegisterEvent event) {
            if (event.ge().)
            Debug.log("LL2: Executing " + blockRegistryCallbacks.size() + " block registry callbacks...");
            invokeCallback(blockRegistryCallbacks, event);
        }

        @SubscribeEvent
        public void onRegisterItems(RegistryEvent.Register<Item> event) {
            Debug.log("LL2: Executing " + itemRegistryCallbacks.size() + " item registry callbacks...");
            invokeCallback(itemRegistryCallbacks, event);
        }

        private void invokeCallback(List<Method> methods, Object arg) {
            ModContainer oldContainer = Loader.instance().activeModContainer();
            for (Method m : methods) {
                ModContext ctx = Debug.assertNotNull(findMod(m.getDeclaringClass().getCanonicalName()), () -> "Mod context is null for " + m);
                Loader.instance().setActiveModContainer(ctx.getModContainer());
                try {
                    m.setAccessible(true);
                    m.invoke(null, arg);
                } catch (Exception ex){
                    throw new RuntimeException("Error when invoking registry callback " + m, ex);
                }
            }
            Loader.instance().setActiveModContainer(oldContainer);
        }
    }


    public static void asm_RegistrationEvent(Object mod, ParallelDispatchEvent event) {
        INSTANCE.onStateEvent(mod, event);
    }

    private void onStateEvent(Object mod, ParallelDispatchEvent event) {
        checkInit();

        ModContext ctx = registryMods.get(mod.getClass().getCanonicalName());
        if (ctx.modObject == null)
            ctx.modObject = mod;

        List<Method> methods = ctx.loadCallbacks.get(event.getClass());
        if (methods != null) {
            activeMod = mod;
            for (Method m : methods) {
                try {
                    m.setAccessible(true);
                    m.invoke(null, event);
                } catch (Exception ex) {
                    Debug.log("Error when calling StateEventCallback@" + event.getClass().getSimpleName() + " " + m);
                    ex.printStackTrace();
                }
            }
            activeMod = null;
        }
    }

    @SuppressWarnings("unchecked")
    private void checkInit() {
        if (!initialized) {
            HashMap<Method, Integer> priorityMap = new HashMap<>();

            registryMods = ReflectionUtils.getClasses(RegistryMod.class)
                    .stream()
                    .collect(Collectors.toMap(Class::getCanonicalName, this::createModContext));

            // Process all state event callbacks
            List<Method> allStateEventCallbacks = ReflectionUtils.getMethods(StateEventCallback.class);
            allStateEventCallbacks.forEach(method -> {
                if (!Modifier.isStatic(method.getModifiers())) {
                    throw new IllegalArgumentException("StateEventCallback method " + method + " must be static.");
                }
                if (method.getParameterCount() != 1) {
                    throw new IllegalArgumentException("StateEventCallback method " + method + " requires exactly 1 argument.");
                }

                Class<? extends ParallelDispatchEvent> eventType = ((Class<? extends ParallelDispatchEvent>) method.getParameterTypes()[0]);
                if (!ParallelDispatchEvent.class.isAssignableFrom(eventType)) {
                    throw new IllegalArgumentException("StateEventCallback method " + method + " 's first argument type must inherit FMLStateEvent");
                }

                ModContext mod = findMod(method.getDeclaringClass().getCanonicalName());
                Debug.assertNotNull(mod, method + " doesn't have associated mod");
                if (!mod.loadCallbacks.containsKey(eventType)) {
                    mod.loadCallbacks.put(eventType, new ArrayList<>());
                }

                mod.loadCallbacks.get(eventType).add(method);

                StateEventCallback anno = method.getAnnotation(StateEventCallback.class);
                priorityMap.put(method, anno.priority());
            });

            // Process all registry callbacks
            List<Method> registryCallbacks = ReflectionUtils.getMethods(RegistryCallback.class);
            registryCallbacks.forEach(method -> {
                if (!Modifier.isStatic(method.getModifiers())) {
                    throw new IllegalArgumentException("RegistryCallback method " + method + " must be static.");
                }
                if (method.getParameterCount() != 1) {
                    throw new IllegalArgumentException("RegistryCallback method " + method + " requires exactly 1 argument.");
                }

                String parTypeName = method.getGenericParameterTypes()[0].getTypeName();
                if (parTypeName.contains("Item")) {
                    itemRegistryCallbacks.add(method);
                } else if (parTypeName.contains("Block")) {
                    blockRegistryCallbacks.add(method);
                } else {
                    throw new IllegalStateException("Invalid Registry Callback " + method);
                }

                RegistryCallback anno = method.getAnnotation(RegistryCallback.class);
                priorityMap.put(method, anno.priority());
            });

            Comparator<Method> priorityCmp = (lhs, rhs) -> {
                int lp = priorityMap.get(lhs);
                int rp = priorityMap.get(rhs);
                return rp - lp;
            };

            // sort by priority
            for (ModContext ctx : registryMods.values()) {
                for (List<Method> list : ctx.loadCallbacks.values()) {
                    list.sort(priorityCmp);
                }
            }

            itemRegistryCallbacks.sort(priorityCmp);
            blockRegistryCallbacks.sort(priorityCmp);

            registerEventHandler();

            initialized = true;
        }
    }
}
