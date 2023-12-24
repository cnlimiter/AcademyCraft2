package cn.evole.mods.academy.api.client.gui.auxGui;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.Event;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2023/12/24 16:44
 * @Description:
 * Fired whenever an new AuxGui is opened.
 */

@OnlyIn(Dist.CLIENT)
public class OpenAuxGuiEvent extends Event {

    public final AuxGui gui;

    public OpenAuxGuiEvent(AuxGui _gui) {
        gui = _gui;
    }

}
