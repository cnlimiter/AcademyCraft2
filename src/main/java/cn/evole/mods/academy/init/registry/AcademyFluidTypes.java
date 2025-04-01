package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.Static;
import cn.evole.mods.academy.common.fluid.type.PhaseLiquidType;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class AcademyFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Static.MOD_ID);

    public static RegistryObject<FluidType> PHASE_LIQUID = FLUID_TYPES.register("phase_liquid_type", PhaseLiquidType::new);
}
