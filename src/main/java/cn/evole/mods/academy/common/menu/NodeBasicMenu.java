package cn.evole.mods.academy.common.menu;

import cn.evole.mods.academy.common.AcademyMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public class NodeBasicMenu extends BaseNodeMenu{
    public NodeBasicMenu(int windowId, Inventory inv, FriendlyByteBuf data) {
        super(AcademyMenus.NODE_BASIC.get(), windowId, inv, data, true);
    }
}
