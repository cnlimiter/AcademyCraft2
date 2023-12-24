package cn.evole.mods.academy.api.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

/**
 * Name: AcademyCraft2 / CGuiScreen
 * Author: cnlimiter
 * CreateTime: 2023/12/24 13:30
 * Description:
 * A simple wrapper for fast {@link CGui} deploy as GuiScreen.
 */
public class CGuiScreen extends Screen {
    protected CGui gui;

    /**
     * Whether the black background should be drawed.
     */
    protected boolean drawBack = true;

    public CGuiScreen(CGui _gui) {
        super(Component.empty());
        gui = _gui;
    }

    public CGuiScreen() {
        this(new CGui());
    }

    /**
     * Set whether the black background should be drawed.
     */
    public CGuiScreen setDrawBack(boolean flag) {
        drawBack = flag;
        return this;
    }


    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float tick) {
        gui.resize(width, height);
        if(drawBack)
            this.renderDirtBackground(guiGraphics);
        GL11.glPushMatrix(); {
            GL11.glEnable(GL11.GL_BLEND);
            gui.draw(mouseX, mouseY);
            GL11.glDisable(GL11.GL_BLEND);
        } GL11.glPopMatrix();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int btn) {
        return gui.mouseClicked((int) mouseX, (int) mouseY, btn);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int btn, double dragX, double dragY) {
        return gui.mouseClickMove((int) mouseX, (int) mouseY, btn);

    }

    @Override
    public void onClose() {
        gui.dispose();
    }


    @Override
    public boolean charTyped(char par1, int par2) {
        gui.keyTyped(par1, par2);
        return super.charTyped(par1, par2);
    }


    public CGui getGui() {
        return gui;
    }

}
