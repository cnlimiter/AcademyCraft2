package cn.evole.mods.academy.common.menu;

import cn.evole.mods.academy.common.blockentity.AcademyContainerBlockEntity;
import cn.evole.mods.academy.common.container.AcademyMenuContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class AcademyMenu extends AbstractContainerMenu {

    public final Inventory inv;
    public final AcademyMenuContainer container = new AcademyMenuContainer(this);
    public BlockPos pos;

    public AcademyMenu(MenuType<?> menuType, int windowId, Inventory inv, FriendlyByteBuf data, boolean hasInventory) {
        super(menuType, windowId);
        this.inv = inv;
        if (data != null)
            this.pos = data.readBlockPos();
        if (hasInventory) {
            // 背包
            for (int k = 0; k < 3; ++k) {
                for (int i1 = 0; i1 < 9; ++i1) {
                    this.addSlot(new Slot(inv, i1 + k * 9 + 9, 8 + i1 * 18, 94 + k * 18));
                }
            }

            // 快捷栏
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(inv, l, 8 + l * 18, 152));
            }
        }
        container.reloadItems();

        AcademyContainerBlockEntity blockEntity = container.getBlockEntity(this);
        if (blockEntity != null) {
            blockEntity.setMenu(this);
        }
    }

    public Slot addAcademySlot(Slot slot) {
        addSlot(slot);
        container.addSlot(slot);
        return slot;
    }


    @Override
    public boolean stillValid(Player p_38874_) {
        return container.stillValid(p_38874_);
    }

    @Override
    public void slotsChanged(@NotNull Container p_38868_) {
        AcademyContainerBlockEntity blockEntity = container.getBlockEntity(this);
        if (blockEntity != null) {
            blockEntity.setItems(container.items);
        }
        super.slotsChanged(p_38868_);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_38942_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_38942_ < 1) {
                if (!this.moveItemStackTo(itemstack1, 1, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemstack;
    }

}
