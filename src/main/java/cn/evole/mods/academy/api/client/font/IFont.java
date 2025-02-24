package cn.evole.mods.academy.api.client.font;


import net.minecraft.client.gui.Font;
import net.minecraft.world.item.DyeColor;

import java.util.List;

/**
 * A generic font interface.
 */
public interface IFont {

    enum FontAlign {
        LEFT(0), CENTER(0.5f), RIGHT(1);

        public final float lenOffset;

        FontAlign(float _lenOffset) {
            lenOffset = _lenOffset;
        }
    }

    class Extent {
        public int linesDrawn;
        public float width;
        public float height;

        public Extent(int _lines, float _width, float _height) {
            linesDrawn = _lines;
            width = _width;
            height = _height;
        }
    }

    class FontOption {

        public float fontSize;
        public FontAlign align;

        public FontOption() {
            this(10);
        }

        public FontOption(float _fontsz) {
            this(_fontsz, FontAlign.LEFT);
        }

        public FontOption(float _fontsz, int hex) {
            this(_fontsz);
        }

        public FontOption(float _fontsz, FontAlign _align) {
            fontSize = _fontsz;
            align = _align;
        }

        public FontOption(float _fontsz, FontAlign _align, int hex) {
            this(_fontsz, _align);
        }

        @Override
        public FontOption clone() {
            FontOption ret = new FontOption();
            ret.fontSize = fontSize;
            ret.align = align;
            return ret;
        }

    }

    /**
     * Draws the string at the given position with given font option in one line. <br>
     *
     * The string is assumed to not include line-seperate characters. (\n or \r). Violating this yields undefined
     *     behaviour.
     */
    void draw(String str, float x, float y, FontOption option);

    /**
     * Get the width of given character when drawed with given FontOption.
     */
    float getCharWidth(int chr, FontOption option);

    /**
     * Get the text width that will be drawn if calls the {@link IFont#draw}.
     */
    float getTextWidth(String str, FontOption option);

    /**
     * Draws a line-seperated string at the given position.
     */
    default void drawSeperated(String str, final float x, float y, float limit, FontOption option) {
        List<String> lines = TextSplitter.split(str, provider(option), limit);
        for (int i = 0; i < lines.size(); ++i) {
            draw(lines.get(i), x, y + i * option.fontSize, option);
        }
    }

    /**
     * Simulates the {@link IFont#drawSeperated} and return the extent drawn.
     * @return A {@link Extent} describing the drawn area
     */
    default Extent drawSeperated_Sim(String str, float limit, FontOption option) {
        List<String> lines = TextSplitter.split(str, provider(option), limit);
        return new Extent(lines.size(), lines.size() == 1 ? getTextWidth(lines.get(0), option) : limit
            , lines.size() * option.fontSize);
    }

    default TextSplitter.IFontSizeProvider provider(FontOption option) {
        return new TextSplitter.IFontSizeProvider() {
            @Override
            public float getCharWidth(int chr) {
                return IFont.this.getCharWidth(chr, option);
            }

            @Override
            public float getTextWidth(String str) {
                return IFont.this.getTextWidth(str, option);
            }
        };
    }

}
