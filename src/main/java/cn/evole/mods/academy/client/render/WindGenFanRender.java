package cn.evole.mods.academy.client.render;

import cn.evole.mods.academy.common.blockentity.WindGenFanBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import org.jetbrains.annotations.NotNull;

public class WindGenFanRender implements BlockEntityRenderer<WindGenFanBlockEntity> {

    public WindGenFanRender(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(@NotNull WindGenFanBlockEntity p_112307_, float p_112308_, @NotNull PoseStack p_112309_, @NotNull MultiBufferSource p_112310_, int p_112311_, int p_112312_) {
        //TODO: 风扇转不起来
    }
}
