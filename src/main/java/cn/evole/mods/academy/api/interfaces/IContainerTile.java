package cn.evole.mods.academy.api.interfaces;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import javax.annotation.Nullable;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 11:36
 * Name IContainerTile
 * Description
 */

public interface IContainerTile {

    default AbstractContainerMenu openContainer(Player player, int windowId)
    {
        return null;
    }

    @Nullable
    default Component getDisplayName()
    {
        return null;
    }
}
