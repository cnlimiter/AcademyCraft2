package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.common.fluid.type.PhaseLiquidType;
import cn.evole.mods.academy.constant.Const;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Const.MOD_ID);

    public static final RegistryObject<FluidType> PHASE_LIQUID = FLUID_TYPES.register("phase_liquid_type", PhaseLiquidType::new);
}
