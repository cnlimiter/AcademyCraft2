package cn.evole.mods.academy.api.init.adapter;

import cn.evole.mods.academy.api.annotations.OnlyIf;
import cn.evole.mods.academy.api.annotations.Setup;
import cn.evole.mods.academy.constant.Debug;
import cn.evole.mods.academy.utils.ScanDataUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.moddiscovery.ModAnnotation;

import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Name: AcademyCraft2 / SetUpAdapter
 * Author: cnlimiter
 * CreateTime: 2023/12/23 22:47
 * Description:
 */

public class SetupAdapter {
    public static void init(){
        List<ModAnnotation.EnumHolder> bothSides = Stream.of(Dist.values())
                .map(dst -> new ModAnnotation.EnumHolder("Lnet/minecraftforge/itf/distmarker/Dist;", dst.name()))
                .collect(Collectors.toList());

        // Register all setups
        ScanDataUtils.lookupAnnotatedObjects(Setup.class).forEach(data ->
        {
            Object side = data.getProperty("side")
                    .orElse(bothSides);

            if(side instanceof List<?> lst && !lst.isEmpty())
            {
                for(Object o : lst)
                {
                    if(o instanceof ModAnnotation.EnumHolder h && FMLEnvironment.dist.name().equals(h.getValue()))
                    {
                        if(data.getTargetType() == ElementType.METHOD)
                        {
                            Debug.log("Injecting setup into " + data.clazz().getClassName());
                            data.getOwnerMod()
                                    .map(FMLModContainer::getEventBus)
                                    .ifPresent(b -> b.addListener((Consumer<FMLCommonSetupEvent>) event -> setup(event, data.getOwnerClass(), data.getMemberName())));
                        }

                        break;
                    }
                }
            } else
                Debug.warn("What the hell is this? " + data.parent.clazz() + "->" + data.getMemberName());
        });
    }

    private static void setup(FMLCommonSetupEvent event, Class<?> source, String memberName)
    {
        String methodName = memberName.substring(0, memberName.indexOf('('));

        Arrays
                .stream(source.getDeclaredMethods())
                .filter(m -> m.getAnnotation(Setup.class) != null && m.getName().equals(methodName))
                .forEach(method ->
                {
                    if(Modifier.isStatic(method.getModifiers()))
                        try
                        {
                            OnlyIf onlyIf = method.getAnnotation(OnlyIf.class);
                            if(!OnlyIfAdapter.checkCondition(onlyIf, source.toString(), "Setup", null, null)) return;
                            method.setAccessible(true);
                            if(method.getParameterCount() == 0)
                                method.invoke(null);
                            else if(method.getParameterCount() == 1 &&
                                    method.getParameterTypes()[0] == FMLCommonSetupEvent.class)
                                method.invoke(null, event);
                        } catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
                        {
                            RuntimeException re = null;
                            if(e instanceof InvocationTargetException && e.getCause() instanceof RuntimeException)
                                re = (RuntimeException) e.getCause();
                            if(e instanceof RuntimeException)
                                re = (RuntimeException) e;
                            if(re != null)
                                throw re;
                            e.printStackTrace();
                        }
                });
    }
}
