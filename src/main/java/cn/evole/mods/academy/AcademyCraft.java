package cn.evole.mods.academy;

import cn.evole.mods.academy.init.registry.*;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;


@Mod(AcademyCraft.MODID)
public class AcademyCraft {
    public static final String MODID = "academy";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AcademyCraft() {
        var modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        AcademyMenus.MENUS.register(modEventBus);
        AcademyItems.ITEMS.register(modEventBus);
        AcademyBlocks.BLOCKS.register(modEventBus);
        AcademyFluidTypes.FLUID_TYPES.register(modEventBus);
        AcademyFluids.FLUIDS.register(modEventBus);
        AcademyEntities.ENTITIES.register(modEventBus);
        AcademyBlockEntities.BLOCK_ENTITIES.register(modEventBus);

    }


}
