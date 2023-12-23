package cn.evole.mods.academy.api.interfaces;

import net.minecraft.resources.ResourceLocation;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 0:08
 * Name IRegListener
 * Description
 */

public interface IRegListener {
    default void onPostRegistered()
    {
    }

    default void onPreRegistered()
    {
    }

    default void onPostRegistered(ResourceLocation id)
    {
        onPostRegistered();
    }

    default void onPreRegistered(ResourceLocation id)
    {
        onPreRegistered();
    }
}
