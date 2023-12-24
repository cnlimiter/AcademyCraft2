package cn.evole.mods.academy.api.client.gui.event;

/**
 * Name: AcademyCraft2 / FrameEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 14:03
 * Description: Fired every frame for any widget if it is to be drawed. (i.e. <code>widget.transform.doesDraw=true</code>)
 */

public class FrameEvent implements GuiEvent {
    public final double mx, my;
    public final boolean hovering;
    public final float deltaTime;

    public FrameEvent(double _mx, double _my, boolean hov, float deltaTime) {
        mx = _mx;
        my = _my;
        hovering = hov;
        this.deltaTime = deltaTime;
    }
}
