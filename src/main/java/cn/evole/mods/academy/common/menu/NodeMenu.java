package cn.evole.mods.academy.common.menu;

import cn.evole.mods.academy.api.common.menu.BaseTileMenu;
import cn.evole.mods.academy.api.common.slot.BaseItemStackHandlerSlot;
import cn.evole.mods.academy.api.common.slot.OutputSlot;
import cn.evole.mods.academy.api.common.wrapper.ItemStackWrapper;
import cn.evole.mods.academy.common.blockentity.BaseNodeBlockEntity;
import cn.evole.mods.academy.init.registry.AcademyItems;
import cn.evole.mods.academy.init.registry.AcademyMenus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class NodeMenu extends BaseTileMenu<BaseNodeBlockEntity> {
    public NodeMenu(int windowId, Inventory inv, FriendlyByteBuf data) {
        this(windowId, inv, new ItemStackWrapper(2), data.readBlockPos());
    }

    public NodeMenu(int windowId, Inventory inv, ItemStackWrapper inventory, BlockPos pos) {
        super(AcademyMenus.NODE_BASIC.get(), windowId, inv, pos);
        // IN
        addSlot(new BaseItemStackHandlerSlot(inventory, 1, 44, 0) {
            @Override
            public boolean mayPlace(@NotNull ItemStack item) {
                return item.is(AcademyItems.ENERGY_UNIT.get());
            }
        });

        //OUT
        addSlot(new OutputSlot(inventory, 0, 44, 70) {
            @Override
            public boolean mayPlace(@NotNull ItemStack item) {
                return item.is(AcademyItems.ENERGY_UNIT.get()) || item.is(AcademyItems.DEVELOPER_PORTABLE.get());
            }
        });
        createInventorySlots(inv, 0, 10);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int slotNumber) {
        var itemstack = ItemStack.EMPTY;
        var slot = this.slots.get(slotNumber);

        if (slot.hasItem()) {
            var itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (slotNumber == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);

            } else if (slotNumber >= 2 && slotNumber < 38) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                    if (slotNumber < 29) {
                        if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(itemstack1, 10, 29, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }
}
