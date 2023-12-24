package cn.evole.mods.academy.api.init.adapter;

import cn.evole.mods.academy.api.annotations.AppReg;
import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.core.app.App;
import cn.evole.mods.academy.core.app.AppRegistry;
import cn.evole.mods.academy.utils.ReflectionUtils;
import cn.evole.mods.academy.utils.ScanDataUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;

/**
 * Name: AcademyCraft2 / RegAppImpl
 * Author: cnlimiter
 * CreateTime: 2023/12/24 13:13
 * Description:
 */
public class AppRegAdapter {

    public static void init(){
        ScanDataUtils.lookupAnnotatedObjects(AppReg.class)
                .forEach(data -> register(data.getOwnerClass()));

    }

    private static void register(Class<?> source) {


        Arrays
                .stream(source.getDeclaredFields())
                .sorted(Comparator.comparingInt(it -> -it.getAnnotation(AppReg.class).priority()))
                .forEach(field ->{
                    field.setAccessible(true);
                    try {
                        AppRegistry.register((App) field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
