package cn.evole.mods.academy.common.blockentity;

import cn.evole.mods.academy.api.common.tile.BaseInventoryTileEntity;
import cn.evole.mods.academy.api.common.wrapper.ItemStackWrapper;
import cn.evole.mods.academy.api.utils.lang.Localizable;
import cn.evole.mods.academy.common.menu.NodeMenu;
import cn.evole.mods.academy.init.registry.AcademyCapability;
import cn.evole.mods.academy.init.registry.AcademyItems;
import cn.evole.mods.academy.common.capability.IFCapabilityImpl;
import cn.evole.mods.academy.common.capability.IIFCapability;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class BaseNodeBlockEntity extends BaseInventoryTileEntity {
    private final ItemStackWrapper inventory;
    public BaseNodeBlockEntity(BlockEntityType<?> entityType, BlockPos blockPos, BlockState blockState) {
        super(entityType, blockPos, blockState);
        this.inventory = new ItemStackWrapper(2, 1);
        this.inventory.setOutputSlots(0);
        this.inventory.setSlotValidator((slot, stack) -> {
            if (slot == 0) return stack.is(AcademyItems.ENERGY_UNIT.get());
            if (slot == 1) return stack.is(AcademyItems.ENERGY_UNIT.get()) || stack.is(AcademyItems.DEVELOPER_PORTABLE.get());
            return false;
        });
    }

    @Override
    public @NotNull ItemStackWrapper getInventory() {
        return inventory;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Localizable.of("container.node").build();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int windowId, @NotNull Inventory playerInventory) {
        return new NodeMenu(windowId, playerInventory, this.inventory, this.getBlockPos());
    }


    public abstract int getRange();

    public boolean isConnected() {
        //TODO: 连接/断开矩阵
        return false;
    }

    public void tick() {
        Optional<?> optional = getCapability(AcademyCapability.IF_CAPABILITY).resolve();
        if (optional.isPresent()) {
            Object cap = optional.get();
            if (cap instanceof IIFCapability ifPower) {
                updatePower(0, ifPower.getIF());
                updatePower(1, ifPower.getIF() * -1);

            }
        }


    }

    private void updatePower(int i, int i1) {
            ItemStack item = getInventory().getStackInSlot(i);
            if (item.is(AcademyItems.ENERGY_UNIT.get()) || item.is(AcademyItems.DEVELOPER_PORTABLE.get())) {
                Optional<?> optional = getCapability(AcademyCapability.IF_CAPABILITY).resolve();
                if (optional.isPresent()) {
                    Object cap = optional.get();
                    if (cap instanceof IIFCapability ifPower) {
                        item.setDamageValue(item.getDamageValue() + i1);
                        item.setTag(ifPower.serializeNBT(item.getTag()));
                    }
                }
            }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == AcademyCapability.IF_CAPABILITY) {
            return LazyOptional.of(() ->
                    new IFCapabilityImpl(1)
            ).cast();
        }
        return super.getCapability(cap, side);
    }
}
