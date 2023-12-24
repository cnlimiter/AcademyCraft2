package cn.evole.mods.academy.utils;

import cn.evole.mods.academy.api.client.gui.auxGui.AuxGuiHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2023/12/24 16:33
 * @Description:
 * Client-Side judgement helper and other stuffs.
 */
@OnlyIn(Dist.CLIENT)
public class ClientUtils {

    /**
     * @return whether the player is playing the client game and isn't opening any GUI.
     */
    public static boolean isPlayerInGame() {
        Player player = Minecraft.getInstance().player;
        return player != null && Minecraft.getInstance().screen == null && !AuxGuiHandler.hasForegroundGui();
    }

    public static boolean isInWorld() {
        return Minecraft.getInstance().player != null;
    }

    public static boolean isPlayerPlaying() {
        Minecraft mc = Minecraft.getInstance();
        return mc.player != null && !mc.isPaused();
    }

    /**
     * Quick alias for playing static sound
     * @param src
     * @param pitch
     */
    public static void playSound(ResourceLocation src, float pitch) {
        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(SoundEvent.createVariableRangeEvent(src), pitch));
    }

    public static String getClipboardContent() {
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            if(cb.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                return (String) cb.getData(DataFlavor.stringFlavor);
            }
        } catch (UnsupportedFlavorException | IOException | IllegalStateException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void setClipboardContent(String content) {
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(content);
        try {
            cb.setContents(ss, ss);
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
    }

}
