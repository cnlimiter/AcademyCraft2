package cn.evole.mods.academy.common.menu;

import cn.evole.mods.academy.constant.ModItems;
import cn.evole.mods.academy.constant.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class WindGenMainMenu extends AcademyMenu {
    public WindGenMainMenu(int windowId, Inventory inv, FriendlyByteBuf data) {
        super(ModMenus.WIND_MAIN_MENU, windowId, inv, data, true);

        addAcademySlot(new Slot(container, 0, 80, 0) {
            @Override
            public boolean mayPlace(ItemStack item) {
                return item.is(ModItems.WINDGEN_FAN);
            }
        });
    }


}
