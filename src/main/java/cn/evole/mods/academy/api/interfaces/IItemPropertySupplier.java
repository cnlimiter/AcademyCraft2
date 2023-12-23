package cn.evole.mods.academy.api.interfaces;

import net.minecraft.world.item.Item;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 0:02
 * Name IItemPropertySupplier
 * Description
 */

public interface IItemPropertySupplier {
    Item.Properties createItemProperties(Item.Properties props);
}
