package cn.evole.mods.academy.api.client.gui.event;

/**
 * Name: AcademyCraft2 / RightClickEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 14:05
 * Description:
 * Fired on both CGui and current focus when user presses right mouse button.
 */
public class RightClickEvent implements GuiEvent {

    public final double x, y;

    public RightClickEvent(double _x, double _y) {
        x = _x;
        y = _y;
    }

}
