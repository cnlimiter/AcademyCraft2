package cn.evole.mods.academy.api.client.gui.event;

/**
 * Name: AcademyCraft2 / DragEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 13:41
 * Description:
 */

public class DragEvent implements GuiEvent {

    /**
     * Offset coordinates from dragging widget origin to current mouse position, in global scale level.
     */
    public final float offsetX, offsetY;

    public DragEvent(float _offsetX, float _offsetY) {
        offsetX = _offsetX;
        offsetY = _offsetY;
    }

}
