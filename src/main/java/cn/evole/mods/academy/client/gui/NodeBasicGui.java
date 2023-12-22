package cn.evole.mods.academy.client.gui;

import cn.evole.mods.academy.common.menu.NodeBasicMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class NodeBasicGui extends BaseNodeGui<NodeBasicMenu> {
    public NodeBasicGui(NodeBasicMenu nodeBasicMenu, Inventory inv, Component p_97743_) {
        super(nodeBasicMenu, inv, p_97743_);
    }
}
