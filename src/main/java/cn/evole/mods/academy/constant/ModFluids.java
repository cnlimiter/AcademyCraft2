package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.api.common.FluidFactory;
import cn.evole.mods.academy.constant.Const;
import net.neoforged.neoforge.fluids.FluidType;


public class ModFluids {

    public static final FluidFactory PHASE_LIQUID = FluidFactory
            .builder(FluidType.Properties.create().descriptionId("phase_liquid"))
            .withBlock()
            .withBucket()
            .addToTab(Const.AC_TAB)
            .build();




}
