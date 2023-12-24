package cn.evole.mods.academy.api.init.adapter;

import cn.evole.mods.academy.AcademyCraft;
import cn.evole.mods.academy.api.init.event.BuildTagsEvent;
import cn.evole.mods.academy.utils.java.Cast;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Name: AcademyCraft2 / TagAdapter
 * Author: cnlimiter
 * CreateTime: 2023/12/24 11:48
 * Description:
 */

public class TagAdapter
{
    static final Map<TagKey<Block>, Set<Block>> blockTags = new ConcurrentHashMap<>();
    static final Map<TagKey<Item>, Set<Item>> itemTags = new ConcurrentHashMap<>();
    static final Map<TagKey<Fluid>, Set<Fluid>> fluidTags = new ConcurrentHashMap<>();

    static final Map<ResourceKey<? extends Registry<?>>, Map<TagKey<?>, Set<?>>> staticTags = new ConcurrentHashMap<>();

    static
    {
        AcademyCraft.EVENT_BUS.addListener(TagAdapter::applyTags);
    }

    private static <T> Map<TagKey<T>, Set<T>> getTagsFor(ResourceKey<? extends Registry<T>> registry)
    {
        return Cast.cast(staticTags.computeIfAbsent(registry, r -> new ConcurrentHashMap<>()));
    }

    public static synchronized <T> void bind(TagKey<T> tag, T... values)
    {
        var tags = getTagsFor(tag.registry());
        tags.computeIfAbsent(tag, b -> new HashSet<>()).addAll(List.of(values));
    }

    @SuppressWarnings({
            "rawtypes",
            "Convert2MethodRef"
    })
    public static void applyTags(BuildTagsEvent evt)
    {
        Map<TagKey, Set> tags = getTagsFor(evt.reg.key());
        tags.forEach((tag, values) -> evt.addAllToTag(tag, values));
    }
}
