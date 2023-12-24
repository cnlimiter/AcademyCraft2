package cn.evole.mods.academy.api.client.gui.event;

/**
 * Name: AcademyCraft2 / LeftClickEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 14:04
 * Description: Fired on CGui and current focus when user presses left mouse button.
 */

public class LeftClickEvent implements GuiEvent {

    public final float x, y;

    public LeftClickEvent(float _x, float _y) {
        x = _x;
        y = _y;
    }

}