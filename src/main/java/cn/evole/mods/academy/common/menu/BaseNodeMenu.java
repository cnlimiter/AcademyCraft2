package cn.evole.mods.academy.common.menu;

import cn.evole.mods.academy.common.ModItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public abstract class BaseNodeMenu extends AcademyMenu {
    public BaseNodeMenu(MenuType<?> menuType, int windowId, Inventory inv, FriendlyByteBuf data, boolean hasInventory) {
        super(menuType, windowId, inv, data, hasInventory);
        // IN
        addAcademySlot(new Slot(container, 0, 44, 0) {
            @Override
            public boolean mayPlace(ItemStack item) {
                return item.is(ModItems.ENERGY_UNIT.get());
            }
        });

        //OUT
        addAcademySlot(new Slot(container, 1, 44, 70) {
            @Override
            public boolean mayPlace(ItemStack item) {
                return item.is(ModItems.ENERGY_UNIT.get()) || item.is(ModItems.DEVELOPER_PORTABLE.get());
            }
        });
    }
}
