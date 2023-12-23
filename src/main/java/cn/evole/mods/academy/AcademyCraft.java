package cn.evole.mods.academy;

import cn.evole.mods.academy.api.init.adapter.ClientSetupAdapter;
import cn.evole.mods.academy.api.init.adapter.RegAdapter;
import cn.evole.mods.academy.api.init.adapter.SetupAdapter;
import cn.evole.mods.academy.constant.Const;
import cn.evole.mods.academy.init.listener.CommonListener;
import cn.evole.mods.academy.init.proxy.ClientProxy;
import cn.evole.mods.academy.init.proxy.CommonProxy;
import cn.evole.mods.academy.utils.DistUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;


@Mod(Const.MOD_ID)
public class AcademyCraft {
    public static final CommonProxy PROXY = DistUtils.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public AcademyCraft(IEventBus modEventBus) {
        modEventBus.register(this);
        PROXY.construct(modEventBus);
        NeoForge.EVENT_BUS.register(PROXY);


        RegAdapter.init();
        SetupAdapter.init();
        ClientSetupAdapter.init();

        CommonListener listener = CommonListener.getInstance();
        listener.init();
//        AcademyMenus.MENUS.register(listener.getModEventBus());
//        AcademyItems.ITEMS.register(listener.getModEventBus());
//        AcademyBlocks.BLOCKS.register(listener.getModEventBus());
//        AcademyFluidTypes.FLUID_TYPES.register(listener.getModEventBus());
//        AcademyFluids.FLUIDS.register(listener.getModEventBus());
//        AcademyEntities.ENTITIES.register(listener.getModEventBus());
//        AcademyBlockEntities.BLOCK_ENTITIES.register(listener.getModEventBus());

    }


}
