package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.common.AcademyBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WindGenPillarBlockEntity extends BlockEntity {
    public WindGenPillarBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(AcademyBlockEntities.WINDGEN_PILLAR.get(), p_155229_, p_155230_);
    }

}
