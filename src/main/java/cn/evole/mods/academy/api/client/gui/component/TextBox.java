package cn.evole.mods.academy.api.client.gui.component;

import cn.evole.mods.academy.api.client.font.Fonts;
import cn.evole.mods.academy.api.client.font.IFont;
import cn.evole.mods.academy.api.client.gui.Widget;
import cn.evole.mods.academy.api.client.gui.event.FrameEvent;
import cn.evole.mods.academy.api.client.gui.event.GuiEvent;
import cn.evole.mods.academy.api.client.gui.event.KeyEvent;
import cn.evole.mods.academy.api.client.gui.event.LeftClickEvent;
import cn.evole.mods.academy.utils.ClientUtils;
import cn.evole.mods.academy.utils.game.GameTimer;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import org.apache.commons.lang3.StringUtils;
import org.joml.Vector2f;
import org.lwjgl.opengl.GL11;
import cn.evole.mods.academy.api.client.gui.component.Transform.HeightAlign;
import cn.evole.mods.academy.api.client.font.IFont.FontOption;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2023/12/24 15:50
 * @Description:
 */

public class TextBox extends Component {

    /**
     * Fired each time the TextBox's content is being edited.
     */
    public static class ChangeContentEvent implements GuiEvent {}

    /**
     * Fired each time the TextBox's input is confirmed. (a.k.a. User presses enter)
     */
    public static class ConfirmInputEvent implements GuiEvent {}

    public String content = "";

    public IFont font = Fonts.getDefault();

    public FontOption option;

    public HeightAlign heightAlign = HeightAlign.CENTER;

    /**
     * Only activated when doesn't allow edit. If activated, The display string will be
     *  <code>StatCollector.translateToLocal(content).</code>
     */
    public boolean localized = false;

    /**
     * Whether the editing is enabled.
     */
    public boolean allowEdit = false;

    /**
     * Whether this textBox doesn't draw chars that are out of bounds.
     */
    public boolean emit = true;

    public boolean doesEcho = false;
    public char echoChar = '*';

    public float zLevel = 0;

    public float xOffset, yOffset;

    private int caretPos = 0;

    private int displayOffset = 0;

    public TextBox() {
        this(new FontOption());
    }

    public TextBox(FontOption _option) {
        super("TextBox");
        this.option = _option;
    }

    {
        // Draws the content
        listen(FrameEvent.class, (w, e) -> {
            validate();

            final Vector2f origin = origin();
            final float widthLimit = w.transform.width - xOffset;

            final String processed = processedContent().substring(displayOffset);

            final int localCaret = caretPos - displayOffset; // ∈[0, processed.length]

            float acc = 0.0f;
            int i = processed.length();
            if (emit) {
                for (i = 0; i < processed.length() && acc < widthLimit; ++i) {
                    acc += font.getCharWidth(processed.codePointAt(i), option);
                }
            }

            final String display = processed.substring(0, i);

            GL11.glPushMatrix();
            GL11.glTranslated(0, 0, zLevel);

            font.draw(display, origin.x, origin.y, option);

            if (w.isFocused() && allowEdit && GameTimer.getAbsTime() % 2 < 1) {
                font.draw("|", origin.x + sumLength(display, 0, localCaret), origin.y - 1, option);
            }

            GL11.glPopMatrix();
        });

        // Handles input
        listen(KeyEvent.class, (__, evt) -> {
            if (!allowEdit) {
                return;
            }

            final char input = evt.inputChar;
            final int keyCode = evt.keyCode;

            if (keyCode == InputConstants.KEY_RIGHT) {
                caretPos = Math.min(content.length(), caretPos + 1);
                checkCaretRegion();
            } else if (keyCode == InputConstants.KEY_LEFT) {
                caretPos = Math.max(0, caretPos - 1);
                if (caretPos < displayOffset) {
                    displayOffset = caretPos;
                }
            } else if (keyCode == InputConstants.KEY_V && InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_LCONTROL)) {
                setContent(content.substring(0, caretPos) + ClientUtils.getClipboardContent() + content.substring(caretPos));
                validate();

                widget.post(new ChangeContentEvent());
            } else if (keyCode == InputConstants.KEY_C && InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), InputConstants.KEY_LCONTROL)) {
                ClientUtils.setClipboardContent(content);
            } else if (keyCode == InputConstants.KEY_BACKSPACE) {
                if (caretPos != 0) {
                    content = content.substring(0, caretPos - 1) + content.substring(caretPos);
                    --caretPos;
                    if (displayOffset != 0) {
                        --displayOffset;
                    }
                    widget.post(new ChangeContentEvent());

                    checkCaretRegion();
                    validate();
                }
            } else if (keyCode == InputConstants.KEY_RETURN || keyCode == InputConstants.KEY_NUMPADENTER) {
                widget.post(new ConfirmInputEvent());
            } else if (keyCode == InputConstants.KEY_DELETE) {
                content = "";
                widget.post(new ChangeContentEvent());

                validate();
            } else if (isAllowedCharacter(input)) {
                content = content.substring(0, caretPos) + input + content.substring(caretPos);
                caretPos = Math.min(content.length(), caretPos + 1);
                widget.post(new ChangeContentEvent());

                checkCaretRegion();
            }
        });

        // Mouse caret pos selection
        listen(LeftClickEvent.class, (w, evt) -> {
            if (!allowEdit) {
                return;
            }

            final Vector2f origin = origin();
            final String display = processedContent().substring(displayOffset);
            final float rel_x = origin.x - font.getTextWidth(display, option) * option.align.lenOffset + evt.x;

            float acc = 0.0f;
            int ind = 0;
            for (; acc < rel_x && ind < display.length(); ++ind) {
                acc += font.getCharWidth(display.codePointAt(ind), option);
            }

            if (ind > 0 && rel_x < acc - font.getCharWidth(display.codePointAt(ind - 1), option) * 0.5) {
                ind--;
            }

            caretPos = displayOffset + ind;
            checkCaretRegion();
        });
    }

    public static boolean isAllowedCharacter(char character)
    {
        return character != 167 && character >= ' ' && character != 127;
    }

    public TextBox allowEdit() {
        allowEdit = true;
        return this;
    }

    public TextBox setContent(String str) {
        content = str;
        return this;
    }

    public TextBox setFont(IFont font) {
        this.font = font;
        return this;
    }

    public TextBox setHeightAlign(HeightAlign align) {
        heightAlign = align;
        return this;
    }

    private void validate() {
        if (!allowEdit) {
            displayOffset = caretPos = 0;
            return;
        }

        if (displayOffset >= content.length() || caretPos > content.length()) {
            displayOffset = caretPos = 0;
        }
    }

    private Vector2f origin() {
        return new Vector2f(
                (float) (widget.transform.width * option.align.lenOffset + xOffset),
                (float) (Math.max(0, widget.transform.height - option.fontSize) * heightAlign.factor + yOffset)
        );
    }

    private boolean shouldLocalize() {
        return !allowEdit && localized;
    }

    private void checkCaretRegion() {
        final float widthLimit = widthLimit();
        final String local = processedContent().substring(displayOffset);
        final int localCaret = caretPos - displayOffset;
        final float distance = sumLength(local, 0, localCaret);
        if (distance > widthLimit) {
            float acc = 0.0f;
            int mini = 0;
            for (; mini < localCaret && distance - acc > widthLimit; ++mini) {
                acc += font.getCharWidth(local.codePointAt(mini), option);
            }
            displayOffset += mini;
        }

        if (displayOffset >= caretPos) {
            displayOffset = Math.max(0, caretPos - 1);
        }

        assert caretPos == 0 || displayOffset < caretPos;
    }

    private float widthLimit() {
        return widget.transform.width - xOffset;
    }

    private String processedContent() {
        String ret = content;
        if (shouldLocalize()) {
            ret = I18n.get(ret);
        }
        if (doesEcho) {
            ret = StringUtils.repeat(echoChar, ret.length());
        }

        return ret;
    }

    private float sumLength(String str, int begin, int end) {
        return font.getTextWidth(str.substring(begin, end), option);
    }

    public static TextBox get(Widget w) {
        return w.getComponent(TextBox.class);
    }

}
