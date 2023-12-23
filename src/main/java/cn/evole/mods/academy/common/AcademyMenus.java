package cn.evole.mods.academy.common;

import cn.evole.mods.academy.common.menu.NodeBasicMenu;
import cn.evole.mods.academy.common.menu.WindGenBaseMenu;
import cn.evole.mods.academy.common.menu.WindGenMainMenu;
import cn.evole.mods.academy.constant.Const;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class AcademyMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Const.MOD_ID);

    public static final RegistryObject<MenuType<WindGenBaseMenu>> WIND_BASE_MENU = MENUS.register("wind_base_menu", () -> IForgeMenuType.create(WindGenBaseMenu::new));
    public static final RegistryObject<MenuType<WindGenMainMenu>> WIND_MAIN_MENU = MENUS.register("wind_main_menu", () -> IForgeMenuType.create(WindGenMainMenu::new));
    public static final RegistryObject<MenuType<NodeBasicMenu>> NODE_BASIC = MENUS.register("node_basic_menu", () -> IForgeMenuType.create(NodeBasicMenu::new));
}
