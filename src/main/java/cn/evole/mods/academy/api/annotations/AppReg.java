package cn.evole.mods.academy.api.annotations;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 2:49
 * Name RegApp
 * Description
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AppReg {
    int priority() default 0;
}

