package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.common.item.*;
import net.minecraft.world.item.Item;


@Reg
public class ModItems {

    @RegName
    public static final Item TUTORIAL = new  Tutorial();
    @RegName
    public static final Item LOGO = new  Logo();
    @RegName
    public static final Item CRYSTAL_LOW = new  CrystalLow();
    @RegName
    public static final Item CRYSTAL_NORMAL = new  CrystalNormal();
    @RegName
    public static final Item CRYSTAL_PURE = new  CrystalPure();
    @RegName
    public static final Item RESO_CRYSTAL = new  ResoCrystal();
//    @RegName
//    public static final Item PHASE_BUCKET =  new BucketItem(AcademyFluids.PHASE_LIQUID, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));

    @RegName
    public static final Item APP_FREQ_TRANSMITTER = new  AppFreqTransmitter();

    @RegName
    public static final Item APP_MEDIA_PLAYER = new  AppMediaPlayer();

    @RegName
    public static final Item APP_SETTINGS = new  AppSettings();

    @RegName
    public static final Item APP_SKILL_TREE = new  AppSkillTree();

    @RegName
    public static final Item BRAIN_COMPONENT = new  BrainComponent();

    @RegName
    public static final Item CALC_CHIP = new  CalcChip();

    @RegName
    public static final Item COIN = new  Coin();

    @RegName
    public static final Item CONSTRAINT_INGOT = new  ConstraintIngot();

    @RegName
    public static final Item CONSTRAINT_PLATE = new  ConstraintPlate();

    @RegName
    public static final Item DATA_CHIP = new  DataChip();

    @RegName
    public static final Item DEVELOPER_PORTABLE = new  DeveloperPortable();

    @RegName
    public static final Item ENERGY_CONVERT_COMPONENT = new  EnergyConvertComponent();

    @RegName
    public static final Item ENERGY_UNIT = new  EnergyUnit();

    @RegName
    public static final Item FACTOR_ELECTROMASTER = new  FactorElectromaster();

    @RegName
    public static final Item FACTOR_MELTDOWNER = new  FactorMeltdowner();

    @RegName
    public static final Item FACTOR_TELEPORTER = new  FactorTeleporter();

    @RegName
    public static final Item FACTOR_VECMANIP = new  FactorVecmanip();

    @RegName
    public static final Item INFO_COMPONENT = new  InfoComponent();

    @RegName
    public static final Item MAGNETIC_COIL = new  MagneticCoil();

    @RegName
    public static final Item MAG_HOOK = new  MagHook();

    @RegName
    public static final Item MATTER_UNIT = new  MatterUnit();

    @RegName
    public static final Item MAT_CORE_0 = new  MatCore0();

    @RegName
    public static final Item MAT_CORE_1 = new  MatCore1();

    @RegName
    public static final Item MAT_CORE_2 = new  MatCore2();

    @RegName
    public static final Item MEDIA_LEVEL5_JUDGELIGHT = new  MediaLevel5Judgelight();

    @RegName
    public static final Item MEDIA_ONLY_MY_RAILGUN = new  MediaOnlyMyRailgun();

    @RegName
    public static final Item MEDIA_SISTERS_NOISE = new  MediaSistersNoise();

    @RegName
    public static final Item NEEDLE = new  Needle();

    @RegName
    public static final Item REINFORCED_IRON_PLATE = new  ReinforcedIronPlate();

    @RegName
    public static final Item RESONANCE_COMPONENT = new  ResonanceComponent();

    @RegName
    public static final Item SILBARN = new  Silbarn();

    @RegName
    public static final Item TERMINAL_INSTALLER = new  TerminalInstaller();

    @RegName
    public static final Item WAFER = new  Wafer();

    @RegName
    public static final Item WINDGEN_FAN = new  WindgenFan();

}
