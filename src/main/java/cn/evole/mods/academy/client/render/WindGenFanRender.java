package cn.evole.mods.academy.client.render;

import cn.evole.mods.academy.api.client.render.IBESR;
import cn.evole.mods.academy.common.blockentity.WindGenFanBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class WindGenFanRender implements IBESR<WindGenFanBlockEntity> {

    public WindGenFanRender(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public void render(WindGenFanBlockEntity p_112307_, float p_112308_, PoseStack p_112309_, MultiBufferSource p_112310_, int p_112311_, int p_112312_) {
        //TODO: 风扇转不起来
    }
}
