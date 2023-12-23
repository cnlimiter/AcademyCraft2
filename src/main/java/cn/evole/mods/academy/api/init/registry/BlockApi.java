package cn.evole.mods.academy.api.init.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Name: AcademyCraft2 / BlockApi
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:48
 * Description:
 */

public class BlockApi {

    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(BlockEntityType.BlockEntitySupplier<T> generator, Block... blocks)
    {
        return BlockEntityType.Builder.of(generator, blocks).build(null);
    }

    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(DynamicBlockEntitySupplier<T> generator, Block... blocks)
    {
        AtomicReference<BlockEntityType<T>> typeRef = new AtomicReference<>();
        typeRef.set(BlockEntityType.Builder.of((pos, state) -> generator.create(typeRef.get(), pos, state), blocks)
                .build(null));
        return typeRef.get();
    }

    public static void sendBlockUpdate(Level level, BlockPos pos)
    {
        if(level == null || pos == null) return;
        Optional.ofNullable(level.getBlockEntity(pos)).ifPresent(BlockEntity::requestModelDataUpdate);
        var state = level.getBlockState(pos);
        level.sendBlockUpdated(pos, state, state, 3);
        level.blockUpdated(pos, state.getBlock());
        level.setBlockAndUpdate(pos, Block.updateFromNeighbourShapes(state, level, pos));
    }




    @FunctionalInterface
    public interface DynamicBlockEntitySupplier<T extends BlockEntity>
    {
        T create(BlockEntityType<T> type, BlockPos pos, BlockState state);
    }
}
