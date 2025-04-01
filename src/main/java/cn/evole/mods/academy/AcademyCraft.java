package cn.evole.mods.academy;

import cn.evole.mods.academy.init.registry.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Static.MOD_ID)
public class AcademyCraft {

    public AcademyCraft() {
        var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        AcademyBlocks.BLOCKS.register(modEventBus);
        AcademyItems.ITEMS.register(modEventBus);
        AcademyTabs.TABS.register(modEventBus);
        AcademyBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        AcademyMenus.MENUS.register(modEventBus);
        AcademyEntities.ENTITIES.register(modEventBus);
        AcademyFluidTypes.FLUID_TYPES.register(modEventBus);
        AcademyFluids.FLUIDS.register(modEventBus);
    }


}
