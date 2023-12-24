package cn.evole.mods.academy.api.client.gui;

import cn.evole.mods.academy.api.client.gui.component.TextBox;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.lwjgl.opengl.GL11;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2023/12/24 15:36
 * @Description:
 */

public class CGuiContainerScreen<M extends AbstractContainerMenu> extends AbstractContainerScreen<M> {

    protected CGui gui;

    public CGuiContainerScreen(M c, Inventory inventory) {
        this(c, new CGui(), inventory);
    }


    public CGuiContainerScreen(M containerMenu, CGui _gui, Inventory inventory) {
        super(containerMenu, inventory, Component.empty());
        this.gui = _gui;
    }

    public CGui getGui() {
        return gui;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        gui.resize(width, height);
        gui.draw(mouseX, mouseY);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        if(isSlotActive()) {
            this.renderDirtBackground(guiGraphics);
            super.render(guiGraphics, mouseX, mouseY, partialTick);
            renderTooltip(guiGraphics, mouseX, mouseY);
        } else {
            gui.resize(width, height);
            this.renderDirtBackground(guiGraphics);
            GL11.glEnable(GL11.GL_BLEND);
            gui.draw(mouseX, mouseY);
            GL11.glDisable(GL11.GL_BLEND);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int btn) {
        if(isSlotActive()) return super.mouseClicked(mouseX, mouseY, btn);
        return gui.mouseClicked((int) mouseX, (int) mouseY, btn);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int btn, double dragX, double dragY) {
        if(isSlotActive()) return super.mouseDragged(mouseX, mouseY, btn, dragX, dragY);
        return gui.mouseClickMove((int) mouseX, (int) mouseY, btn);

    }

    @Override
    public void onClose() {
        gui.dispose();
    }


    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int btn) {
        if(isSlotActive()) {
           return super.mouseReleased(mouseX, mouseY, btn);
        }
        return super.mouseReleased(mouseX, mouseY, btn);
    }

    @Override
    public boolean charTyped(char ch, int key) {
        if(containerAcceptsKey(key) || key != InputConstants.KEY_ESCAPE)
            gui.keyTyped(ch, key);
        return super.charTyped(ch, key);
    }


    /**
     * @return Whether the inventory itself receives key input. (This should be disabled when you are handling some user input)
     */
    protected boolean containerAcceptsKey(int key) {
        // Don't delegate key event if current editing TextBox. Surely dirty hack, find a better route later
        TextBox temp;
        return (gui.focus == null ||
                (temp = gui.focus.getComponent(TextBox.class)) == null ||
                !temp.canEdit);
    }

    /**
     * @return Whether inventory slots should be renderered this frame.
     */
    public boolean isSlotActive() {
        return true;
    }

}
