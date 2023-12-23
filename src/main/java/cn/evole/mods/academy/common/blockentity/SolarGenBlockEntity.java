package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.common.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SolarGenBlockEntity extends BlockEntity {
    public SolarGenBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.SOLAR_GEN.get(), p_155229_, p_155230_);
    }

}
