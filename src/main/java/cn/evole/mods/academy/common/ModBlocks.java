package cn.evole.mods.academy.common;

import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.common.block.*;
import net.minecraft.world.level.block.Block;

@Reg
public class ModBlocks {

    @RegName("cat_engine")
    public static final Block CAT_ENGINE = new CatEngine();
    @RegName("ability_interferer")
    public static final Block ABILITY_INTERFERER = new AbilityInterferer();
    @RegName("constraint_metal")
    public static final Block CONSTRAIN_METAL = new ConstraintMetal();
    @RegName("crystal_ore")
    public static final Block CRYSTAL_ORE = new CrystalOre();
    @RegName("reso_ore")
    public static final Block RESO_ORE = new ResoOre();
    @RegName("imagsil_ore")
    public static final Block IMAGSIL_ORE = new ImagsilOre();
    @RegName("imag_fusor")
    public static final Block IMAG_FUSOR = new ImagFusor();
    @RegName("machine_frame")
    public static final Block MACHINE_FRAME = new MachineFrame();
    @RegName("metal_former")
    public static final Block METAL_FORMER = new MetalFomer();
    @RegName("node_basic")
    public static final Block NODE_BASIC = new NodeBasic();
    @RegName("node_advanced")
    public static final Block NODE_ADVANCED = new NodeAdvanced();
    @RegName("node_standard")
    public static final Block NODE_STANDARD = new NodeStandard();
    @RegName("dev_normal")
    public static final Block DEV_NORMAL = new DevNormal();
    @RegName("dev_advanced")
    public static final Block DEV_ADVANCED = new DevAdvanced();
    @RegName("dev_normal_sub")
    public static final Block DEV_NORMAL_SUB = new DevNormalSubBlock();
    @RegName("dev_advanced_sub")
    public static final Block DEV_ADVANCED_SUB = new DevAdvancedSubBlock();
    @RegName("windgen_base_sub")
    public static final Block WIND_GEN_BASE_SUB = new WindGenBaseSubBlock();
    @RegName("matrix")
    public static final Block MATRIX = new Matrix();
    @RegName("matrix_sub")
    public static final Block MATRIX_SUB = new MatrixSubBlock();
    @RegName("phase_gen")
    public static final Block PHASE_GEN = new PhaseGen();
    @RegName("solar_gen")
    public static final Block SOLAR_GEN = new SolarGen();
    @RegName("windgen_base")
    public static final Block WINDGEN_BASE = new WindGenBase();
    @RegName("windgen_main")
    public static final Block WINDGEN_MAIN = new WindGenMain();
    @RegName("windgen_pillar")
    public static final Block WINDGEN_PILLAR = new WindGenPillar();
    @RegName("windgen_fan_block")
    public static final Block WINDGEN_FAN = new WindGenFan();
    @RegName("phase_liquid")
    public static final Block PHASE_LIQUID = new PhaseFluidBlock();

}
