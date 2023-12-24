package cn.evole.mods.academy.common.menu;

import cn.evole.mods.academy.constant.ModItems;
import cn.evole.mods.academy.constant.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class WindGenBaseMenu extends AcademyMenu {
    public WindGenBaseMenu(int windowId, Inventory inv, FriendlyByteBuf data) {
        super(ModMenus.WIND_BASE_MENU, windowId, inv, data, true);

        addAcademySlot(new Slot(container, 0, 44, 70) {
            @Override
            public boolean mayPlace(ItemStack item) {
                return item.is(ModItems.ENERGY_UNIT) || item.is(ModItems.DEVELOPER_PORTABLE);
            }
        });
    }


}
