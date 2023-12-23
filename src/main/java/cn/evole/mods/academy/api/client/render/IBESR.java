package cn.evole.mods.academy.api.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;

/**
 * Name: AcademyCraft2 / IBESR
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:16
 * Description:
 */

public interface IBESR<T extends BlockEntity>
{
    void render(T entity, float partial, PoseStack matrix, MultiBufferSource buf, int lighting, int overlay);

    default boolean shouldRenderOffScreen(T tile)
    {
        return false;
    }

    default int getViewDistance()
    {
        return 64;
    }

    default boolean shouldRender(T entity, Vec3 camera)
    {
        return Vec3.atCenterOf(entity.getBlockPos()).closerThan(camera, this.getViewDistance());
    }
}
