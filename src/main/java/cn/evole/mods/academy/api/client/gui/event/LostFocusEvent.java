package cn.evole.mods.academy.api.client.gui.event;

import cn.evole.mods.academy.api.client.gui.Widget;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Name: AcademyCraft2 / LostFocusEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 14:04
 * Description: Fired on target widget when it has lost input focus.
 */

@OnlyIn(Dist.CLIENT)
public class LostFocusEvent implements GuiEvent {

    public Widget newFocus;

    public LostFocusEvent(Widget _newFocus) {
        newFocus = _newFocus;
    }

}
