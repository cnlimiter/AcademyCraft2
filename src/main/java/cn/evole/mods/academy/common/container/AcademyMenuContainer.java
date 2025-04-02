package cn.evole.mods.academy.common.container;

import cn.evole.mods.academy.common.blockentity.AcademyContainerBlockEntity;
import cn.evole.mods.academy.common.menu.AcademyMenu;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2025/4/2 13:11
 * @Description:
 */
public class AcademyMenuContainer implements Container, StackedContentsCompatible {

    private final AcademyMenu menu;
    public NonNullList<ItemStack> items = NonNullList.withSize(0, ItemStack.EMPTY);

    public AcademyMenuContainer(AcademyMenu menu) {
        this.menu = menu;
    }

    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public @NotNull ItemStack getItem(int p_18941_) {
        reloadItems();
        return items.size() <= p_18941_ ? ItemStack.EMPTY : items.get(p_18941_);
    }

    @Override
    public @NotNull ItemStack removeItem(int p_18942_, int p_18943_) {
        ItemStack stack = getItem(p_18942_);
        // System.out.println("移除物品: " + p_18942_);
        items.set(p_18942_, ItemStack.EMPTY);
        saveItems();
        return stack;
    }

    public void saveItems() {
        AcademyContainerBlockEntity blockEntity = getBlockEntity(this.menu);
        if (blockEntity != null) {
            blockEntity.setItems(items);

        }
    }


    public void reloadItems() {
        AcademyContainerBlockEntity blockEntity = getBlockEntity(this.menu);
        if (blockEntity != null) {
            items = blockEntity.getItems();
        }
    }

    public AcademyContainerBlockEntity getBlockEntity(AcademyMenu menu) {
        if (menu != null && menu.pos != null) {
            BlockEntity entity = menu.inv.player.level().getBlockEntity(menu.pos);
            if (entity instanceof AcademyContainerBlockEntity blockEntity && !blockEntity.isRemoved()) {
                return blockEntity;
            }
        }
        return null;
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int p_18951_) {
        return removeItem(p_18951_, 1);
    }

    @Override
    public void setItem(int p_18944_, ItemStack p_18945_) {
        if (p_18945_ == ItemStack.EMPTY) return;
        if (items.size() > p_18944_) {
            items.set(p_18944_, p_18945_);
            saveItems();
        }
    }

    @Override
    public void setChanged() {
        AcademyContainerBlockEntity blockEntity = getBlockEntity(this.menu);
        if (blockEntity != null) {
            blockEntity.setChanged();
        }
    }

    @Override
    public boolean stillValid(@NotNull Player p_18946_) {
        return getBlockEntity(this.menu) != null;
    }

    @Override
    public void clearContent() {
        items.clear();
        saveItems();
    }

    @Override
    public void fillStackedContents(@NotNull StackedContents p_40281_) {
        for (ItemStack item : items) {
            p_40281_.accountSimpleStack(item);
        }
    }

    public void addSlot(Slot slot) {
        items = NonNullList.withSize(items.size() + 1, ItemStack.EMPTY);
    }
}
