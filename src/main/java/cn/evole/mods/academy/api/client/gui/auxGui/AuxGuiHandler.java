package cn.evole.mods.academy.api.client.gui.auxGui;

import cn.evole.mods.academy.utils.game.GameTimer;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderGuiOverlayEvent;
import net.neoforged.neoforge.client.gui.overlay.NamedGuiOverlay;
import net.neoforged.neoforge.client.gui.overlay.VanillaGuiOverlay;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.GameShuttingDownEvent;
import net.neoforged.neoforge.event.TickEvent;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL33;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2023/12/24 16:41
 * @Description:
 */

@OnlyIn(Dist.CLIENT)
public class AuxGuiHandler {

    private static AuxGuiHandler instance = new AuxGuiHandler();

    private AuxGuiHandler() {
        NeoForge.EVENT_BUS.register(this);
    }

    private static boolean iterating;
    private static List<AuxGui> auxGuiList = new LinkedList<>();
    private static List<AuxGui> toAddList = new ArrayList<>();

    public static void register(AuxGui gui) {
        if(!iterating)
            doAdd(gui);
        else
            toAddList.add(gui);
    }

    public static List<AuxGui> active() {
        return ImmutableList.copyOf(auxGuiList);
    }

    public static boolean hasForegroundGui() {
        return auxGuiList.stream().anyMatch(gui -> !gui.disposed && gui.foreground);
    }

    private static void doAdd(AuxGui gui) {
        auxGuiList.add(gui);
        NeoForge.EVENT_BUS.post(new OpenAuxGuiEvent(gui));
        gui.onEnable();
    }

    private static void startIterating() {
        iterating = true;
    }

    private static void endIterating() {
        iterating = false;
    }

    @SubscribeEvent(receiveCanceled = true)
    public void drawHudEvent(RenderGuiOverlayEvent event) {
        if(event.getOverlay() == VanillaGuiOverlay.EXPERIENCE_BAR.type()) {
            doRender(event);
        }
    }

    private void doRender(RenderGuiOverlayEvent event) {
        GL33.glDepthFunc(GL33.GL_ALWAYS);
        GL33.glDepthMask(false);
        GL33.glDisable(GL33.GL_ALPHA_TEST);
        GL33.glEnable(GL33.GL_BLEND);
        GL33.glBlendFunc(GL33.GL_SRC_ALPHA, GL33.GL_ONE_MINUS_SRC_ALPHA);
        event.getGuiGraphics().pose().pushPose();

        Iterator<AuxGui> iter = auxGuiList.iterator();
        startIterating();
        while(iter.hasNext()) {
            AuxGui gui = iter.next();
            if(!gui.disposed) {
                if(!gui.lastFrameActive)
                    gui.lastActivateTime = GameTimer.getTime();
                gui.draw();
                gui.lastFrameActive = true;
            }
        }
        endIterating();

        event.getGuiGraphics().pose().popPose();
        GL33.glEnable(GL33.GL_ALPHA_TEST);
        GL33.glDepthMask(true);
        GL33.glDepthFunc(GL33.GL_LEQUAL);
        GL33.glColor4f(1,1,1,1);
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event) {
        if(!Minecraft.getInstance().isPaused()) {
            for(AuxGui gui : toAddList)
                doAdd(gui);
            toAddList.clear();

            Iterator<AuxGui> iter = auxGuiList.iterator();
            startIterating();
            while(iter.hasNext()) {
                AuxGui gui = iter.next();

                if(gui.disposed) {
                    gui.onDisposed();
                    gui.lastFrameActive = false;
                    iter.remove();
                } else if(gui.requireTicking) {
                    if(!gui.lastFrameActive)
                        gui.lastActivateTime = GameTimer.getTime();
                    gui.onTick();
                    gui.lastFrameActive = true;
                }
            }
            endIterating();
        }
    }

    @SubscribeEvent
    public void disconnected(GameShuttingDownEvent event) {
        startIterating();
        Iterator<AuxGui> iter = auxGuiList.iterator();
        while(iter.hasNext()) {
            AuxGui gui = iter.next();
            if(!gui.consistent) {
                gui.onDisposed();
                iter.remove();
            }
        }
        endIterating();
    }


}
