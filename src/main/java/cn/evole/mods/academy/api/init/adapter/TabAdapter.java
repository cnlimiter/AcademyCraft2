package cn.evole.mods.academy.api.init.adapter;

import cn.evole.mods.academy.api.common.CreativeTab;
import cn.evole.mods.academy.api.interfaces.ITabItem;
import cn.evole.mods.academy.utils.java.Cast;
import cn.evole.mods.academy.utils.java.tuples.Tuple2;
import cn.evole.mods.academy.utils.java.tuples.Tuples;
import com.google.common.base.Suppliers;
import net.minecraft.Util;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Name: AcademyCraft2 / TabAdapter
 * Author: cnlimiter
 * CreateTime: 2023/12/24 2:47
 * Description:
 */

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TabAdapter {
    private static final List<Tuple2<ItemLike, CreativeTab[]>> REGISTRARS = new ArrayList<>();

    private static final List<CreativeTab> CUSTOM_TABS = new ArrayList<>();
    private static final Map<CreativeModeTab, CreativeTab> REGISTERED = new ConcurrentHashMap<>();
    private static final Supplier<Set<ITabItem>> CUSTOM_TAB_ITEMS = Suppliers.memoize(() ->
            BuiltInRegistries.ITEM
                    .stream()
                    .filter(ITabItem.class::isInstance)
                    .map(Cast.convertTo(ITabItem.class))
                    .collect(Collectors.toSet())
    );

    private static final Function<ItemStack, CreativeModeTab[]> TABS_BY_ITEM = Util.memoize(item ->
            CreativeModeTabs.allTabs().stream().filter(tab -> tab.contains(item)).toArray(CreativeModeTab[]::new)
    );

    public static CreativeModeTab[] getTabs(ItemStack item)
    {
        return TABS_BY_ITEM.apply(item);
    }

    @SubscribeEvent
    public static void populate(BuildCreativeModeTabContentsEvent e)
    {
        CreativeTab tab = REGISTERED.get(e.getTab());
        if(tab != null)
        {
            for(ItemLike item : tab.contents())
            {
                if(item instanceof ITabItem)
                    continue;
                e.accept(item);
            }
        }

        NonNullList<ItemStack> items = NonNullList.create();
        for(ITabItem item : CUSTOM_TAB_ITEMS.get()) item.fillItemCategory(e.getTab(), items);
        e.acceptAll(items);
    }

    public static Map<CreativeModeTab, CreativeTab> getRegistered()
    {
        return REGISTERED;
    }

    public static List<CreativeTab> getCustomTabs()
    {
        return CUSTOM_TABS;
    }

    /**
     * Assigns one or more creative tabs to an item.
     *
     * @param item
     * 		the item to assign the creative tabs to
     * @param tabs
     * 		the creative tabs to assign
     * @param <T>
     * 		the type of the item
     *
     * @return the item with the assigned creative tabs
     */
    public static <T extends ItemLike> T bindTab(T item, CreativeTab... tabs)
    {
        REGISTRARS.add(Tuples.immutable(item, tabs)); // store ItemLike(s) so that if that is a block, it would unwrap properly.
        return item;
    }

    public static void deque()
    {
        while(!REGISTRARS.isEmpty())
        {
            var tup = REGISTRARS.remove(0);
            for(var t : tup.b()) t.add(tup.a());
        }
    }
}
