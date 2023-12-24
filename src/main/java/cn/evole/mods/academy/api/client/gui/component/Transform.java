package cn.evole.mods.academy.api.client.gui.component;

/**
 * Name: AcademyCraft2 / Transform
 * Author: cnlimiter
 * CreateTime: 2023/12/24 13:38
 * Description:
 */

public class Transform extends Component {

    public enum WidthAlign { LEFT, CENTER, RIGHT;
        public final float factor;
        WidthAlign() {
            factor = ordinal() * 0.5f;
        }
    }

    public enum HeightAlign { TOP, CENTER, BOTTOM;
        public final float factor;
        HeightAlign() {
            factor = ordinal() * 0.5f;
        }
    }

    public float width = 0.0f, height = 0.0f;

    public float x = 0, y = 0;

    public float pivotX = 0, pivotY = 0;

    public float scale = 1.0f;

    /**
     * Whether the widget should be drawed.
     */
    public boolean doesDraw = true;

    /**
     * Whether the widget listens to key events. Note you can't listen to key events either when doesDraw=false.
     */
    public boolean doesListenKey = true;

    public WidthAlign alignWidth = WidthAlign.LEFT;

    public HeightAlign alignHeight = HeightAlign.TOP;

    public Transform() {
        super("Transform");
    }

    //Helper set methods
    public Transform setPos(float _x, float _y) {
        x = _x;
        y = _y;
        return this;
    }

    public Transform setSize(float _width, float _height) {
        width = _width;
        height = _height;
        return this;
    }

    public Transform setCenteredAlign() {
        alignWidth = WidthAlign.CENTER;
        alignHeight = HeightAlign.CENTER;
        return this;
    }

    public Transform setAlign(WidthAlign walign, HeightAlign halign) {
        alignWidth = walign;
        alignHeight = halign;
        return this;
    }

}
