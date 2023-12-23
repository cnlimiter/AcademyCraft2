package cn.evole.mods.academy.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 21:17
 * Name OnlyIf
 * Description
 */

@Retention(RUNTIME)
@Target({
        FIELD,
        METHOD
})
public @interface OnlyIf
{
    Class<?> owner();

    String member() default "";

    boolean invert() default false;
}
