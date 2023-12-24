package cn.evole.mods.academy.api.init.registry;

import cn.evole.mods.academy.api.interfaces.IContainerTile;
import cn.evole.mods.academy.utils.java.Cast;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

/**
 * Name: AcademyCraft2 / ContainerApi
 * Author: cnlimiter
 * CreateTime: 2023/12/24 11:36
 * Description:
 */

public class ContainerApi {
    public static MenuProvider forTile(BlockEntity tile)
    {
        return new MenuProvider()
        {
            @Override
            public Component getDisplayName()
            {
                return Cast
                        .optionally(tile, IContainerTile.class)
                        .<Component> map(IContainerTile::getDisplayName)
                        .orElseGet(() -> tile.getBlockState().getBlock().getName());
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int windowId, @NotNull Inventory playerInv, @NotNull Player player)
            {
                return Cast
                        .optionally(tile, IContainerTile.class)
                        .map(ict -> ict.openContainer(player, windowId))
                        .orElse(null);
            }
        };
    }

    public static <T extends BlockEntity & IContainerTile> void openContainerTile(Player player, T tile)
    {
        if(player instanceof ServerPlayer && tile != null)
            NetworkHooks.openScreen((ServerPlayer) player, forTile(tile), buf -> buf.writeBlockPos(tile.getBlockPos()));
    }
}
