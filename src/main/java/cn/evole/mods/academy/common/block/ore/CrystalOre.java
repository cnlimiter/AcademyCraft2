package cn.evole.mods.academy.common.block.ore;

import cn.evole.mods.academy.init.registry.AcademyItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CrystalOre extends Block {

    public CrystalOre() {
        super(Properties.of()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(4.0f)
                .requiresCorrectToolForDrops()
        );

    }


    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState pState, LootParams.@NotNull Builder pParams) {
        return new ArrayList<>() {{
            add(new ItemStack(AcademyItems.CRYSTAL_LOW.get()));
        }};
    }

}
