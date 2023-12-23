package cn.evole.mods.academy.api.init.adapter;

import cn.evole.mods.academy.api.annotations.ClientSetup;
import cn.evole.mods.academy.api.annotations.OnlyIf;
import cn.evole.mods.academy.constant.Debug;
import cn.evole.mods.academy.utils.ScanDataUtils;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLModContainer;

import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Name: AcademyCraft2 / ClientSetUpAdapter
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:28
 * Description:
 */

public class ClientSetupAdapter {

    public static void init(){
        ScanDataUtils.lookupAnnotatedObjects(ClientSetup.class).forEach(data ->
        {
            if(data.getTargetType() == ElementType.METHOD)
            {
                Debug.log("Injecting client-setup into " + data.clazz().getClassName());
                data.getOwnerMod()
                        .map(FMLModContainer::getEventBus)
                        .ifPresent(b -> b.addListener((Consumer<FMLClientSetupEvent>) event ->
                                clientSetup(event, data.getOwnerClass(), data.getMemberName())
                        ));
            }
        });
    }

    private static void clientSetup(FMLClientSetupEvent event, Class<?> source, String memberName)
    {
        String methodName = memberName.substring(0, memberName.indexOf('('));

        Arrays
                .stream(source.getDeclaredMethods())
                .filter(m -> m.getAnnotation(ClientSetup.class) != null && m.getName().equals(methodName))
                .forEach(method ->
                {
                    if(Modifier.isStatic(method.getModifiers()))
                        try
                        {
                            OnlyIf onlyIf = method.getAnnotation(OnlyIf.class);
                            if(!OnlyIfAdapter.checkCondition(onlyIf, source.toString(), "ClientSetup", null, null))
                                return;
                            method.setAccessible(true);
                            if(method.getParameterCount() == 0)
                                method.invoke(null);
                            else if(method.getParameterCount() == 1 &&
                                    method.getParameterTypes()[0] == FMLClientSetupEvent.class)
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
