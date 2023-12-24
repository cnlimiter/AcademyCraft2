package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.constant.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PhaseGenBlockEntity extends BlockEntity {
    public PhaseGenBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.PHASE_GEN, p_155229_, p_155230_);
    }

}
