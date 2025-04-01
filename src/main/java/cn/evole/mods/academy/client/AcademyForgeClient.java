package cn.evole.mods.academy.client;

import cn.evole.mods.academy.AcademyCraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2025/4/1 13:42
 * @Description:
 */
@Mod.EventBusSubscriber(modid = AcademyCraft.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AcademyForgeClient {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

    }
}
