package cn.evole.mods.academy.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 21:15
 * Name CommonReg
 * Description
 */

@Retention(RUNTIME)
@Target({
        TYPE,
        METHOD
})
public @interface Reg
{
    String prefix() default "";
}
