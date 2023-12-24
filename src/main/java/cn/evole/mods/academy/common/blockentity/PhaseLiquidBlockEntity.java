package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.constant.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PhaseLiquidBlockEntity extends TheEndPortalBlockEntity {
    public PhaseLiquidBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.PHASE_LIQUID, p_155229_, p_155230_);
    }

}
