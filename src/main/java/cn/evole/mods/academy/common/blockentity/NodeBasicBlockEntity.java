package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.constant.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class NodeBasicBlockEntity extends BaseNodeBlockEntity {
    public NodeBasicBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.NODE_BASIC, p_155229_, p_155230_);
    }

    @Override
    public int getContainerSize() {
        return 2;
    }

    @Override
    public int getRange() {
        return 1;
    }



}
