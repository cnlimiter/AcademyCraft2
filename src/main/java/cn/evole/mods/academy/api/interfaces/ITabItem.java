package cn.evole.mods.academy.api.interfaces;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;
import java.util.Set;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 2:48
 * Name ITabItem
 * Description
 */

public interface ITabItem
{
    default boolean allowedIn(CreativeModeTab tab)
    {
        if(getCreativeTabs().stream().anyMatch(t -> t == tab)) return true;
        CreativeModeTab creativemodetab = this.getItemCategory();
        return creativemodetab != null && (tab == CreativeModeTabs.searchTab() || tab == creativemodetab);
    }

    CreativeModeTab getItemCategory();

    default Set<CreativeModeTab> getCreativeTabs()
    {
        var c = getItemCategory();
        return c != null ? Collections.singleton(c) : Collections.emptySet();
    }

    default void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> items)
    {
        if(allowedIn(tab))
        {
            items.add(((Item) this).getDefaultInstance());
        }
    }
}
