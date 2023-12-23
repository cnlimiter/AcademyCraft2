package cn.evole.mods.academy.api.common;

import cn.evole.mods.academy.api.init.adapter.TabAdapter;
import cn.evole.mods.academy.constant.Const;
import cn.evole.mods.academy.utils.java.tuples.Tuple1;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Name: AcademyCraft2 / CreativeTab
 * Author: cnlimiter
 * CreateTime: 2023/12/24 2:47
 * Description:
 */

public class CreativeTab {
    private final Consumer<CreativeModeTab.Builder> factory;
    private final Tuple1.Mutable1<CreativeModeTab> tab = new Tuple1.Mutable1<>(null);

    protected final ResourceLocation id;
    protected final List<ItemLike> contents = new ArrayList<>();

    protected boolean addHammerLibBefores = true; // Here just in case, but should generally be left out as "true"
    protected final Set<ResourceLocation> tabsBefore = new HashSet<>(), tabsAfter = new HashSet<>();

    public CreativeTab(ResourceLocation id, Consumer<CreativeModeTab.Builder> factory)
    {
        this.id = id;
        Consumer<CreativeModeTab.Builder> factory0 = b ->
        {
            b.title(Component.translatable(Util.makeDescriptionId("creative_tab", id)));
            if(addHammerLibBefores && CreativeTab.this != Const.AC_TAB) b.withTabsBefore(Const.AC_TAB.id()); // Make all sub-tabs go after HammerLib, so it doesn't fuck up Minecraft tab ordering.
            b.withTabsBefore(tabsBefore.toArray(ResourceLocation[]::new)).withTabsAfter(tabsAfter.toArray(ResourceLocation[]::new));
        };
        this.factory = factory0.andThen(factory);
        TabAdapter.getCustomTabs().add(this);
    }

    public <T extends ItemLike> T add(T item)
    {
        contents.add(item);
        return item;
    }

    public CreativeModeTab tab()
    {
        return tab.a();
    }

    public void tab(CreativeModeTab tab)
    {
        this.tab.setA(tab);
    }

    public ResourceLocation id()
    {
        return id;
    }

    public Consumer<CreativeModeTab.Builder> factory()
    {
        return factory;
    }

    public List<ItemLike> contents()
    {
        return contents;
    }

    /**
     * Puts THIS tab after prevTab in creative menu.
     */
    public CreativeTab putAfter(CreativeTab prevTab)
    {
        tabsBefore.add(prevTab.id());
        return this;
    }

    /**
     * Puts THIS tab after prevTab in creative menu.
     */
    public CreativeTab putAfter(ResourceLocation prevTab)
    {
        tabsBefore.add(prevTab);
        return this;
    }

    /**
     * Puts THIS tab before afterTab in creative menu.
     */
    public CreativeTab putBefore(CreativeTab afterTab)
    {
        tabsAfter.add(afterTab.id());
        return this;
    }

    /**
     * Puts THIS tab before afterTab in creative menu.
     */
    public CreativeTab putBefore(ResourceLocation afterTab)
    {
        tabsAfter.add(afterTab);
        return this;
    }

    public void register(Function<CreativeTab, CreativeModeTab> e)
    {
        tab(e.apply(this));
        TabAdapter.getRegistered().put(tab(), this);
    }
}
