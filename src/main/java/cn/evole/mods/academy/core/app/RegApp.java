package cn.evole.mods.academy.core.app;

import cn.evole.mods.academy.utils.ReflectionUtils;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 2:49
 * Name RegApp
 * Description
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegApp {
    int priority() default 0;
}

class RegAppImpl {
    private static void setup(FMLCommonSetupEvent ev) {
        ReflectionUtils.getFields(RegApp.class)
                .stream()
                .sorted(Comparator.comparingInt(it -> -it.getAnnotation(RegApp.class).priority()))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        AppRegistry.register((App) field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}