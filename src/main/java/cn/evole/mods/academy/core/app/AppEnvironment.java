package cn.evole.mods.academy.core.app;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Name: AcademyCraft2 / AppEnvironment
 * Author: cnlimiter
 * CreateTime: 2023/12/23 2:45
 * Description:
 */

@OnlyIn(Dist.CLIENT)
public class AppEnvironment {

    /*
     * Instances to be injected when startup
     */
    public App app;
   // public TerminalUI terminal;

    /**
     * Called just before environment is activated on client side. Load the
     * data.
     */
    public void onStart() {
    }

    protected App getApp() {
        return app;
    }

//    protected TerminalUI getTerminal() {
//        return terminal;
//    }

    protected Player getPlayer() {
        return Minecraft.getInstance().player;
    }

}
