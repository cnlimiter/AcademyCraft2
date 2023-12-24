package cn.evole.mods.academy.init.mixins;

import cn.evole.mods.academy.AcademyCraft;
import cn.evole.mods.academy.api.init.event.BuildTagsEvent;
import cn.evole.mods.academy.constant.Debug;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagLoader;
import net.minecraft.tags.TagManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Name: AcademyCraft2 / TagLoaderMixin
 * Author: cnlimiter
 * CreateTime: 2023/12/24 11:45
 * Description:
 */

@Mixin(TagLoader.class)
public class TagLoaderMixin
{
    @Shadow
    @Final
    private String directory;

    @Inject(
            method = "build(Ljava/util/Map;)Ljava/util/Map;",
            at = @At(value = "HEAD")
    )
    private void load_lib(Map<ResourceLocation, List<TagLoader.EntryWithSource>> value, CallbackInfoReturnable<Map<ResourceLocation, Collection>> cir)
    {
        var reg = BuiltInRegistries.REGISTRY
                .stream()
                .filter(t -> TagManager.getTagDir(t.key()).equals(directory))
                .findFirst()
                .orElse(null);

        if(reg != null)
        {
            AcademyCraft.EVENT_BUS.post(new BuildTagsEvent(reg, directory, value));
            Debug.log("Built tags for registry {}", reg.key().location());
        }
        else
            Debug.debug("Unable to find registry for tag directory {}.", directory);
    }
}
