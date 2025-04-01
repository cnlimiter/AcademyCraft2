package cn.evole.mods.academy.common.block;

import cn.evole.mods.academy.init.registry.AcademyBlocks;
import cn.evole.mods.academy.init.registry.AcademyItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AbilityInterferer extends Block {

    private static final IntegerProperty STATUS = IntegerProperty.create("status", 0, 1);

    public AbilityInterferer() {
        super(Properties.of()
                .mapColor(MapColor.STONE)
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(3.0f)
                .requiresCorrectToolForDrops());
        this.registerDefaultState(this.getStateDefinition().any().setValue(STATUS, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(STATUS);
        super.createBlockStateDefinition(p_49915_);
    }


    @Override
    public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player player, InteractionHand p_60507_, BlockHitResult p_60508_) {

        // TODO: 打开GUI
        return InteractionResult.CONSUME;

    }

    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState pState, LootParams.@NotNull Builder pParams) {
        return new ArrayList<>() {{
            add(new ItemStack(AcademyBlocks.ABILITY_INTERFERER.get()));
        }};
    }

}
