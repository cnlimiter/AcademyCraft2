package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.api.annotations.RegTab;
import cn.evole.mods.academy.api.common.CreativeTab;
import cn.evole.mods.academy.common.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

/**
 * Name: AcademyCraft2 / Const
 * Author: cnlimiter
 * CreateTime: 2023/12/23 19:36
 * Description:
 */

public class Const {
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String MOD_ID = "academy";

    @RegTab
    public static final CreativeTab AC_TAB = new CreativeTab(Resources.res("root"),
            b -> b.icon(ModItems.LOGO::getDefaultInstance)
                    .title(Component.translatable("itemGroup." + MOD_ID))
                    .withTabsBefore(
                            CreativeModeTabs.BUILDING_BLOCKS,
                            CreativeModeTabs.COLORED_BLOCKS,
                            CreativeModeTabs.NATURAL_BLOCKS,
                            CreativeModeTabs.FUNCTIONAL_BLOCKS,
                            CreativeModeTabs.REDSTONE_BLOCKS,
                            CreativeModeTabs.TOOLS_AND_UTILITIES,
                            CreativeModeTabs.COMBAT,
                            CreativeModeTabs.FOOD_AND_DRINKS,
                            CreativeModeTabs.INGREDIENTS,
                            CreativeModeTabs.SPAWN_EGGS
                    )
    );
}
