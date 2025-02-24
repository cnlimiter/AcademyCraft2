package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.constant.ModCapability;
import cn.evole.mods.academy.constant.ModBlockEntities;
import cn.evole.mods.academy.constant.ModItems;
import cn.evole.mods.academy.common.capability.IFCapabilityImpl;
import cn.evole.mods.academy.common.capability.IIFCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class WindGenBaseBlockEntity extends AcademyContainerBlockEntity {
    private boolean validBlock = false;
    private boolean validMiddle = false;

    public WindGenBaseBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.WINDGEN_BASE, p_155229_, p_155230_);
    }


    public void tick(boolean validBlock, boolean validMiddle) {
        this.validBlock = validBlock;
        this.validMiddle = validMiddle;
        if (!validBlock) return;
        getItems().forEach((item) -> {
            if (item.is(ModItems.ENERGY_UNIT) || item.is(ModItems.DEVELOPER_PORTABLE)) {
                Optional<?> optional = getCapability(ModCapability.IF_CAPABILITY).resolve();
                if (optional.isPresent()) {
                    Object cap = optional.get();
                    if (cap instanceof IIFCapability ifPower) {
                        item.setDamageValue(item.getDamageValue() - ifPower.getIF());
                        item.setTag(ifPower.serializeNBT(item.getTag()));
                    }
                }
            }
        });
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ModCapability.IF_CAPABILITY) {
            return LazyOptional.of(() ->
                    new IFCapabilityImpl(1)
            ).cast();
        }
        return LazyOptional.empty();
    }

    public boolean isValidMiddle() {
        return validMiddle;
    }

    public boolean isValidMain() {
        return validBlock;
    }
}
