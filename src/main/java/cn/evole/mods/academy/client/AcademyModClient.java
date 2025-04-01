package cn.evole.mods.academy.client;

import cn.evole.mods.academy.AcademyCraft;
import cn.evole.mods.academy.init.registry.AcademyBlockEntities;
import cn.evole.mods.academy.init.registry.AcademyEntities;
import cn.evole.mods.academy.init.registry.AcademyMenus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterShadersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2025/4/1 13:40
 * @Description:
 */
@Mod.EventBusSubscriber(modid = AcademyCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AcademyModClient {
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {

    }

    @SubscribeEvent
    public static void clientSetUp(FMLClientSetupEvent event) {
        AcademyMenus.onClientSetup();
        AcademyEntities.onClientSetup();
        AcademyBlockEntities.onClientSetup();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRegisterShaders(RegisterShadersEvent event) {
    }

    @SubscribeEvent
    public static void registerEntityLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiOverlaysEvent event) {

    }
}
