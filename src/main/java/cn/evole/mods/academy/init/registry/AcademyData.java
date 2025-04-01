package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.Static;
import cn.evole.mods.academy.init.gen.provider.AcademyBlockTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2025/4/1 14:05
 * @Description:
 */
@Mod.EventBusSubscriber(modid = Static.MOD_ID, value = Dist.DEDICATED_SERVER, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AcademyData {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> future = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new AcademyBlockTagsProvider(output, future, helper));
    }
}
