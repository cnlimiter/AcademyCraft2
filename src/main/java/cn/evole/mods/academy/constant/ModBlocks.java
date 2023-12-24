package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.common.block.*;
import net.minecraft.world.level.block.Block;

@Reg
public class ModBlocks {

    @RegName
    public static final Block CAT_ENGINE = new CatEngine();
    @RegName
    public static final Block ABILITY_INTERFERER = new AbilityInterferer();
    @RegName
    public static final Block CONSTRAIN_METAL = new ConstraintMetal();
    @RegName
    public static final Block CRYSTAL_ORE = new CrystalOre();
    @RegName
    public static final Block RESO_ORE = new ResoOre();
    @RegName
    public static final Block IMAGSIL_ORE = new ImagsilOre();
    @RegName
    public static final Block IMAG_FUSOR = new ImagFusor();
    @RegName
    public static final Block MACHINE_FRAME = new MachineFrame();
    @RegName
    public static final Block METAL_FORMER = new MetalFomer();
    @RegName
    public static final Block NODE_BASIC = new NodeBasic();
    @RegName
    public static final Block NODE_ADVANCED = new NodeAdvanced();
    @RegName
    public static final Block NODE_STANDARD = new NodeStandard();
    @RegName
    public static final Block DEV_NORMAL = new DevNormal();
    @RegName
    public static final Block DEV_ADVANCED = new DevAdvanced();
    @RegName
    public static final Block DEV_NORMAL_SUB = new DevNormalSubBlock();
    @RegName
    public static final Block DEV_ADVANCED_SUB = new DevAdvancedSubBlock();
    @RegName
    public static final Block WIND_GEN_BASE_SUB = new WindGenBaseSubBlock();
    @RegName
    public static final Block MATRIX = new Matrix();
    @RegName
    public static final Block MATRIX_SUB = new MatrixSubBlock();
    @RegName
    public static final Block PHASE_GEN = new PhaseGen();
    @RegName
    public static final Block SOLAR_GEN = new SolarGen();
    @RegName
    public static final Block WINDGEN_BASE = new WindGenBase();
    @RegName
    public static final Block WINDGEN_MAIN = new WindGenMain();
    @RegName
    public static final Block WINDGEN_PILLAR = new WindGenPillar();
    @RegName
    public static final Block WINDGEN_FAN = new WindGenFan();
    @RegName
    public static final Block PHASE_LIQUID = ModFluids.PHASE_LIQUID.getBlock();

}
