package cn.evole.mods.academy.api.annotations;

import org.jetbrains.annotations.Nullable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 23:53
 * Name RegName
 * Description
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegName
{
    @Nullable
    String value() default "";
}
