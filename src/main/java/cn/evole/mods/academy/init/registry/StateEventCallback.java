package cn.evole.mods.academy.init.registry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 19:44
 * Name StateEventCallback
 * Description
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StateEventCallback {
    int priority() default 0;
}
