package cn.evole.mods.academy.common;

import cn.evole.mods.academy.common.fluid.PhaseFluid;
import cn.evole.mods.academy.constant.Const;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Const.MOD_ID);

    public static final RegistryObject<FlowingFluid> PHASE_LIQUID = FLUIDS.register("phase_liquid", PhaseFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_PHASE_LIQUID = FLUIDS.register("phase_liquid_flowing", PhaseFluid.Flowing::new);

}
