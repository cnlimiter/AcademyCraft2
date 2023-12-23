package cn.evole.mods.academy;

import cn.evole.mods.academy.common.*;
import cn.evole.mods.academy.constant.Const;
import cn.evole.mods.academy.init.listener.CommonListener;
import net.minecraftforge.fml.common.Mod;


@Mod(Const.MOD_ID)
public class AcademyCraft {

    public AcademyCraft() {

        CommonListener listener = CommonListener.getInstance();
        listener.init();
        AcademyMenus.MENUS.register(listener.getModEventBus());
        AcademyItems.ITEMS.register(listener.getModEventBus());
        AcademyBlocks.BLOCKS.register(listener.getModEventBus());
        AcademyFluidTypes.FLUID_TYPES.register(listener.getModEventBus());
        AcademyFluids.FLUIDS.register(listener.getModEventBus());
        AcademyEntities.ENTITIES.register(listener.getModEventBus());
        AcademyBlockEntities.BLOCK_ENTITIES.register(listener.getModEventBus());

    }


}
