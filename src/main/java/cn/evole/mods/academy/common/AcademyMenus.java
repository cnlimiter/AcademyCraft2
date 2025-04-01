package cn.evole.mods.academy.common;

import cn.evole.mods.academy.AcademyCraft;
import cn.evole.mods.academy.common.menu.NodeBasicMenu;
import cn.evole.mods.academy.common.menu.WindGenBaseMenu;
import cn.evole.mods.academy.common.menu.WindGenMainMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class AcademyMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, AcademyCraft.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<?>> WIND_BASE_MENU = MENUS.register("wind_base_menu", resourceLocation -> IMenuTypeExtension.create(WindGenBaseMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<?>> WIND_MAIN_MENU = MENUS.register("wind_main_menu", resourceLocation -> IMenuTypeExtension.create(WindGenMainMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<?>> NODE_BASIC = MENUS.register("node_basic_menu", resourceLocation -> IMenuTypeExtension.create(NodeBasicMenu::new));
}
