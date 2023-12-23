package cn.evole.mods.academy.api.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;

/**
 * Name: AcademyCraft2 / TESRBase
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:16
 * Description:
 */

public record TESRBase<T extends BlockEntity>(IBESR<T> wrap)
        implements BlockEntityRenderer<T>
{
    @Override
    public void render(T tile, float partial, PoseStack matrix, MultiBufferSource buf, int lighting, int overlay)
    {
        wrap.render(tile, partial, matrix, buf, lighting, overlay);
    }

    @Override
    public boolean shouldRenderOffScreen(T tile)
    {
        return wrap.shouldRenderOffScreen(tile);
    }

    @Override
    public int getViewDistance()
    {
        return wrap.getViewDistance();
    }

    @Override
    public boolean shouldRender(T entity, Vec3 pos)
    {
        return wrap.shouldRender(entity, pos);
    }
}
