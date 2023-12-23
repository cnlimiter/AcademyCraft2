package cn.evole.mods.academy.client.gui;

import cn.evole.mods.academy.common.menu.BaseNodeMenu;
import cn.evole.mods.academy.constant.Const;
import cn.evole.mods.academy.utils.RenderUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public abstract class BaseNodeGui<T extends BaseNodeMenu> extends AcademyBaseUI<T> {

    private static final ResourceLocation UI_NODE = new ResourceLocation(Const.MOD_ID, "textures/guis/ui/ui_node.png");
    private static final ResourceLocation EFFECT_NODE = new ResourceLocation(Const.MOD_ID, "textures/guis/effect/effect_node.png");
    private boolean connected = false;

    public BaseNodeGui(T t, Inventory inv, Component p_97743_) {
        super(t, inv, p_97743_);
    }


    private long lastAnimTime = 0;
    private int animIndex = 0;

    @Override
    public void renderBackground(GuiGraphics stack, float p_97788_, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        RenderUtils.renderCenter(176, 187, this.width, this.height, stack, UI_NODE);

        this.connected = activeNode != -1;
        if (!this.connected) {
            if (System.currentTimeMillis() - lastAnimTime > 2000) {
                animIndex++;
                if (animIndex < 8 || animIndex > 9) animIndex = 8;
                lastAnimTime = System.currentTimeMillis();
            }
        } else {
            if (System.currentTimeMillis() - lastAnimTime > 1000) {
                animIndex++;
                if (animIndex > 7) animIndex = 0;
                lastAnimTime = System.currentTimeMillis();
            }
        }
        RenderUtils.renderCenter(0, -(75 / 2) - 2,
                176 / 2, 75 / 2,
                176, 75,
                this.width, this.height, stack, EFFECT_NODE,
                75 * animIndex, 0, 176, 750);
        //TODO: 检测是否链接矩阵，播放动画
        RenderSystem.disableBlend();

    }
}
