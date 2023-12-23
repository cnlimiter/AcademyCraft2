package cn.evole.mods.academy.api.annotations;

import net.minecraftforge.api.distmarker.Dist;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author cnlimiter
 * CreateTime 2023/12/23 21:13
 * Name Setup
 * Description
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface Setup
{
    Dist[] side() default {
            Dist.CLIENT,
            Dist.DEDICATED_SERVER
    };
}
