package cn.evole.mods.academy.utils;

import cn.evole.mods.academy.utils.colors.ColorHelper;
import cn.evole.mods.academy.utils.java.Cast;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL33;

public class RenderUtils {
    public static float zLevel = 0;

    public static void drawColoredModalRect(GuiGraphics pose, float x, float y, float width, float height, int rgb)
    {
        Matrix4f pose4f = pose.pose().last().pose();
        float r = ColorHelper.getRed(rgb), g = ColorHelper.getGreen(rgb), b = ColorHelper.getBlue(rgb), a = ColorHelper.getAlpha(rgb);
        Tesselator tess = Tesselator.getInstance();
        BufferBuilder vb = tess.getBuilder();
        vb.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        vb.vertex(pose4f, x, y + height, zLevel).color(r, g, b, a).endVertex();
        vb.vertex(pose4f, x + width, y + height, zLevel).color(r, g, b, a).endVertex();
        vb.vertex(pose4f, x + width, y, zLevel).color(r, g, b, a).endVertex();
        vb.vertex(pose4f, x, y, zLevel).color(r, g, b, a).endVertex();
        tess.end();
    }

    public static void drawModalRect(GuiGraphics pose, float x, float y, float width, float height)
    {
        Matrix4f pose4f = pose.pose().last().pose();
        Tesselator tess = Tesselator.getInstance();
        BufferBuilder vb = tess.getBuilder();
        vb.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        vb.vertex(pose4f, x, y + height, zLevel).endVertex();
        vb.vertex(pose4f, x + width, y + height, zLevel).endVertex();
        vb.vertex(pose4f, x + width, y, zLevel).endVertex();
        vb.vertex(pose4f, x, y, zLevel).endVertex();
        tess.end();
    }

    public static void drawRectOutline(double x, double y, double w, double h, float lineWidth) {
        GL33.glLineWidth(lineWidth);
        GL33.glDisable(GL33.GL_TEXTURE_2D);
        GL33.glBegin(GL33.GL_LINE_LOOP);
        double lw = lineWidth * 0.2;
        x -= lw;
        y -= lw;
        w += 2 * lw;
        h += 2 * lw;
        GL33.glVertex3d(x, y, zLevel);
        GL33.glVertex3d(x, y + h, zLevel);
        GL33.glVertex3d(x + w, y + h, zLevel);
        GL33.glVertex3d(x + w, y, zLevel);
        GL33.glEnd();
        GL33.glEnable(GL33.GL_TEXTURE_2D);
    }


    public static void drawRect(GuiGraphics pose, int x, int y, int width, int height, int color)
    {
        var sdr = RenderSystem.getShader();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        drawColoredModalRect(pose, x, y, width, height, color);
        RenderSystem.setShader(Cast.constant(sdr));
    }

    public static void renderCenter(int drawWidth, int drawHeight, int width, int height, GuiGraphics poseStack, ResourceLocation resource) {
        renderCenter(0, 0, drawWidth, drawHeight, width, height, poseStack, resource);
    }

    public static void renderCenter(int x, int y, int drawWidth, int drawHeight, int width, int height, GuiGraphics poseStack, ResourceLocation resource) {
        int left = (width - drawWidth) / 2;
        int top = (height - drawHeight) / 2;
        render(drawWidth, drawHeight, left + x, top + y, poseStack, resource);
    }

    public static void renderCenter(int x, int y, int drawWidth, int drawHeight,int drawTextureWidth, int drawTextureHeight, int width, int height, GuiGraphics poseStack, ResourceLocation resource, int textureStartX, int textureStartY, int textureWidth, int textureHeight) {
        int left = (width - drawWidth) / 2;
        int top = (height - drawHeight) / 2;
        render(drawWidth, drawHeight,drawTextureWidth,drawTextureHeight, left + x, top + y, poseStack, resource, textureStartX, textureStartY, textureWidth, textureHeight);
    }

    public static void renderCenterTop(int x, int y, int drawWidth, int drawHeight, int width, int top, GuiGraphics poseStack, ResourceLocation resource) {
        int left = (width - drawWidth) / 2;
        render(drawWidth, drawHeight, left + x, top + y, poseStack, resource);
    }


    public static void render(int drawWidth, int drawHeight, int left, int top, GuiGraphics guiGraphics, ResourceLocation resource) {
        //drawWidth和drawHeight名字反了，值没反
        guiGraphics.blit(resource, left, top, 0, 0, 0, drawWidth, drawHeight, drawWidth, drawHeight);
    }

    public static void render(int drawWidth, int drawHeight,int drawTextureWidth, int drawTextureHeight, int left, int top, GuiGraphics guiGraphics, ResourceLocation resource, int textureStartX, int textureStartY, int textureWidth, int textureHeight) {
        guiGraphics.blit(resource, left, top, drawWidth, drawHeight, textureStartY, textureStartX, drawTextureWidth, drawTextureHeight, textureWidth, textureHeight);
    }

    public static void renderText(GuiGraphics stack, String text, int x, int y) {
        renderText(stack, text, x, y, Style.EMPTY);
    }

    public static void renderText(GuiGraphics stack, String text, int x, int y, Style style) {
        MultiBufferSource.BufferSource source = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
        ClientTooltipComponent.create(FormattedCharSequence.forward(text,
                        style))
                .renderText(Minecraft.getInstance().font,
                        x,
                        y,
                        stack.pose().last().pose(),
                        source);
        source.endBatch();
    }


}
