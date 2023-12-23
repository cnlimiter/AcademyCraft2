package cn.evole.mods.academy.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 0:26
 * Name ClientSetup
 * Description
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface ClientSetup
{
}
