package cn.evole.mods.academy.api.client.gui.event;

/**
 * Name: AcademyCraft2 / MouseClickEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 14:05
 * Description:
 * Fired on both CGui and current focus when any mouse button except for LMB and RMB is clicked.
 * (For convenience reasons, they are handled in {@link LeftClickEvent} and {@link RightClickEvent}.)
 */
public class MouseClickEvent implements GuiEvent {

    /**
     * Mouse position in local coordinate space.
     */
    public final double mx, my;

    /**
     * Pressed button id.
     */
    public final int button;

    public MouseClickEvent(double _mx, double _my, int bid) {
        mx = _mx;
        my = _my;
        button = bid;
    }

}
