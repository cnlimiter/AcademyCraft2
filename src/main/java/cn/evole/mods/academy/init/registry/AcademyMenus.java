package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.Static;
import cn.evole.mods.academy.client.gui.NodeBasicGui;
import cn.evole.mods.academy.client.gui.WindBaseGui;
import cn.evole.mods.academy.client.gui.WindMainGui;
import cn.evole.mods.academy.common.menu.NodeBasicMenu;
import cn.evole.mods.academy.common.menu.WindGenBaseMenu;
import cn.evole.mods.academy.common.menu.WindGenMainMenu;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class AcademyMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, Static.MOD_ID);

    public static RegistryObject<MenuType<WindGenBaseMenu>> WIND_BASE_MENU = menu("wind_base_menu", () -> IForgeMenuType.create(WindGenBaseMenu::new));
    public static RegistryObject<MenuType<WindGenMainMenu>> WIND_MAIN_MENU = menu("wind_main_menu", () -> IForgeMenuType.create(WindGenMainMenu::new));
    public static RegistryObject<MenuType<NodeBasicMenu>> NODE_BASIC = menu("node_basic_menu", () -> IForgeMenuType.create(NodeBasicMenu::new));

    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup() {
        MenuScreens.register(AcademyMenus.WIND_BASE_MENU.get(), WindBaseGui::new);
        MenuScreens.register(AcademyMenus.WIND_MAIN_MENU.get(), WindMainGui::new);
        MenuScreens.register(AcademyMenus.NODE_BASIC.get(), NodeBasicGui::new);
    }

    public static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> menu(String name, Supplier<? extends MenuType<T>> container) {
        return MENUS.register(name, container);
    }
}
