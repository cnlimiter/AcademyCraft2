package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.constant.ModCapability;
import cn.evole.mods.academy.constant.ModItems;
import cn.evole.mods.academy.common.capability.IFCapabilityImpl;
import cn.evole.mods.academy.common.capability.IIFCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class BaseNodeBlockEntity extends AcademyContainerBlockEntity {
    public BaseNodeBlockEntity(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }

    @Override
    public int getContainerSize() {
        return 2;
    }

    public abstract int getRange();

    public boolean isConnected() {
        //TODO: 连接/断开矩阵
        return false;
    }

    public void tick() {


        Optional<?> optional = getCapability(ModCapability.IF_CAPABILITY).resolve();
        if (optional.isPresent()) {
            Object cap = optional.get();
            if (cap instanceof IIFCapability ifPower) {
                updatePower(0, ifPower.getIF());
                updatePower(1, ifPower.getIF() * -1);

            }
        }


    }

    private void updatePower(int i, int i1) {
        if (getMenu() != null) {
            ItemStack item = getMenu().container.getItem(i);
            if (item.is(ModItems.ENERGY_UNIT) || item.is(ModItems.DEVELOPER_PORTABLE)) {
                Optional<?> optional = getCapability(ModCapability.IF_CAPABILITY).resolve();
                if (optional.isPresent()) {
                    Object cap = optional.get();
                    if (cap instanceof IIFCapability ifPower) {
                        item.setDamageValue(item.getDamageValue() + i1);
                        item.setTag(ifPower.serializeNBT(item.getTag()));
                    }
                }
            }
        }
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
}
