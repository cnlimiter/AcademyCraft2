package cn.evole.mods.academy.api.client.gui.event;

/**
 * Name: AcademyCraft2 / KeyEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 14:04
 * Description: Fired on CGui and current widget focus, when player presses any key.
 */

public class KeyEvent implements GuiEvent {
    public final char inputChar;
    public final int keyCode;

    public KeyEvent(char _ch, int _key) {
        inputChar = _ch;
        keyCode = _key;
    }
}
