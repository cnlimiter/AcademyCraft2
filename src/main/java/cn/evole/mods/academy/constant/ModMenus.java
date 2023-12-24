package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.api.annotations.ClientSetup;
import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.client.gui.NodeBasicGui;
import cn.evole.mods.academy.client.gui.WindBaseGui;
import cn.evole.mods.academy.client.gui.WindMainGui;
import cn.evole.mods.academy.common.menu.NodeBasicMenu;
import cn.evole.mods.academy.common.menu.WindGenBaseMenu;
import cn.evole.mods.academy.common.menu.WindGenMainMenu;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;


@Reg
public class ModMenus {

    @RegName
    public static final MenuType<WindGenBaseMenu> WIND_BASE_MENU = IMenuTypeExtension.create(WindGenBaseMenu::new);
    @RegName
    public static final MenuType<WindGenMainMenu> WIND_MAIN_MENU = IMenuTypeExtension.create(WindGenMainMenu::new);
    @RegName
    public static final MenuType<NodeBasicMenu> NODE_BASIC = IMenuTypeExtension.create(NodeBasicMenu::new);


    @ClientSetup
    public void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenus.WIND_BASE_MENU, WindBaseGui::new);
            MenuScreens.register(ModMenus.WIND_MAIN_MENU, WindMainGui::new);
            MenuScreens.register(ModMenus.NODE_BASIC, NodeBasicGui::new);
        });
    }
}
