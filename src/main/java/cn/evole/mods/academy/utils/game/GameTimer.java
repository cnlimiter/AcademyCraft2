package cn.evole.mods.academy.utils.game;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.TickEvent;

/**
 * Name: AcademyCraft2 / GameTimer
 * Author: cnlimiter
 * CreateTime: 2023/12/24 13:42
 * Description:
 */
@Mod.EventBusSubscriber
public class GameTimer {
    static long storedTime, timeLag;

    static long beginTimeClient, beginTimeServer;

    public static double getTime() {
        if (isHeadless()) { // No minecraft, headless mode
            if (beginTimeClient == 0L)
                beginTimeClient = System.currentTimeMillis();
            return (System.currentTimeMillis() - beginTimeClient) / 1000.0;
        }

        boolean isClient = FMLEnvironment.dist.isClient();
        return getTime(isClient);
    }

    private static boolean isHeadless() {
        return FMLEnvironment.dist.isClient() && Minecraft.getInstance() == null;
    }

    public static double getAbsTime() {
        return getTime(false);
    }

    @SuppressWarnings("sideonly")
    private static double getTime(boolean isClient) {
        if (isClient) {
            if (beginTimeClient == 0) beginTimeClient = getRawTimeClient();
            long elapsed = getRawTimeClient() - beginTimeClient;
            return elapsed / 1000.0;
        } else {
            if (beginTimeServer == 0) beginTimeServer = getRawTimeServer();
            long elapsed = getRawTimeServer() - beginTimeServer;
            return elapsed / 1000.0;
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static long getRawTimeClient() {
        long time = Util.getMillis();
        if(Minecraft.getInstance().isPaused()) {
            timeLag = time - storedTime;
        } else {
            storedTime = time - timeLag;
        }
        return time - timeLag;
    }

    private static long getRawTimeServer() {
        return System.currentTimeMillis();
    }

    // In case GameTimer isn't queried frequently, use this to prevent huge (and incorrect) time lag.
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        getRawTimeClient();
    }
}
