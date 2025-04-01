package cn.evole.mods.academy.client.gui;

import cn.evole.mods.academy.Static;
import cn.evole.mods.academy.common.blockentity.WindGenBaseBlockEntity;
import cn.evole.mods.academy.common.menu.WindGenBaseMenu;
import cn.evole.mods.academy.utils.RenderUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class WindBaseGui extends AcademyBaseUI<WindGenBaseMenu> {

    private static final ResourceLocation UI_WIN_BASE = new ResourceLocation(Static.MOD_ID, "textures/guis/ui/ui_windbase.png");
    private static final ResourceLocation IC_WIN_BASE = new ResourceLocation(Static.MOD_ID, "textures/guis/icons/icon_wind_base.png");
    private static final ResourceLocation IC_WIN_MIDDLE = new ResourceLocation(Static.MOD_ID, "textures/guis/icons/icon_wind_middle.png");
    private static final ResourceLocation IC_WIN_MAIN = new ResourceLocation(Static.MOD_ID, "textures/guis/icons/icon_wind_main.png");
    private final Inventory inv;

    public WindBaseGui(WindGenBaseMenu menu, Inventory inv, Component p_97743_) {
        super(menu, inv, p_97743_);
        this.inv = inv;
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics graphics, int p_97809_, int p_97810_) {
        //TODO: nothing
    }

    @Override
    public void renderBackground(@NotNull GuiGraphics graphics, float p_97788_, int mouseX, int mouseY) {

        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        RenderUtils.renderCenter(graphics, 176, 187, this.width, this.height, UI_WIN_BASE);
        if (this.menu.pos != null) {
            BlockEntity entity = inv.player.level().getBlockEntity(this.menu.pos);
            if (entity instanceof WindGenBaseBlockEntity blockEntity) {
                RenderUtils.renderCenterTop(graphics, 0, 49, 24, 24, this.width, (this.height - 187) / 2, IC_WIN_BASE);// 基座
                if (blockEntity.isValidMiddle()) {
                    RenderSystem.setShaderColor(1, 1, 1, 1);
                } else {
                    RenderSystem.setShaderColor(1, 1, 1, 0.7f);
                }
                RenderUtils.renderCenterTop(graphics, 0, 31, 24, 24, this.width, (this.height - 187) / 2, IC_WIN_MIDDLE);// 中部
                if (blockEntity.isValidMain()) {
                    RenderSystem.setShaderColor(1, 1, 1, 1);
                } else {
                    RenderSystem.setShaderColor(1, 1, 1, 0.7f);
                }
                RenderUtils.renderCenterTop(graphics, 0, 13, 24, 24, this.width, (this.height - 187) / 2, IC_WIN_MAIN);// 头部
                RenderSystem.disableBlend();
                return;
            }

        }
        RenderUtils.renderCenterTop(graphics, 0, 49, 24, 24, this.width, (this.height - 187) / 2, IC_WIN_BASE);// 基座
        RenderUtils.renderCenterTop(graphics, 0, 31, 24, 24, this.width, (this.height - 187) / 2, IC_WIN_MIDDLE);// 中部
        RenderUtils.renderCenterTop(graphics, 0, 13, 24, 24, this.width, (this.height - 187) / 2, IC_WIN_MAIN);// 头部
        RenderSystem.disableBlend();
    }
}
