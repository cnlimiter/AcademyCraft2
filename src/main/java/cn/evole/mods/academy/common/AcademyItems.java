package cn.evole.mods.academy.common;

import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.common.item.*;
import cn.evole.mods.academy.constant.Const;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class AcademyItems {

    @RegName("tutorial")
    public static final Item TUTORIAL = ITEMS.register("tutorial", Tutorial::new);
    @RegName("logo")
    public static final Item LOGO = ITEMS.register("logo", Logo::new);
    @RegName("crystal_low")
    public static final Item CRYSTAL_LOW = ITEMS.register("crystal_low", CrystalLow::new);
    @RegName("crystal_normal")
    public static final Item CRYSTAL_NORMAL = ITEMS.register("crystal_normal", CrystalNormal::new);
    @RegName("crystal_pure")
    public static final Item CRYSTAL_PURE = ITEMS.register("crystal_pure", CrystalPure::new);
    @RegName("reso_crystal")
    public static final Item RESO_CRYSTAL = ITEMS.register("reso_crystal", ResoCrystal::new);
    @RegName("")
    public static final Item PHASE_BUCKET = ITEMS.register("imag_phase", () -> new BucketItem(AcademyFluids.PHASE_LIQUID, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));


    @RegName("")
    public static final Item APP_FREQ_TRANSMITTER = ITEMS.register("app_freq_transmitter", AppFreqTransmitter::new);

    @RegName("")
    public static final Item APP_MEDIA_PLAYER = ITEMS.register("app_media_player", AppMediaPlayer::new);

    @RegName("")
    public static final Item APP_SETTINGS = ITEMS.register("app_settings", AppSettings::new);

    @RegName("")
    public static final Item APP_SKILL_TREE = ITEMS.register("app_skill_tree", AppSkillTree::new);

    @RegName("")
    public static final Item BRAIN_COMPONENT = ITEMS.register("brain_component", BrainComponent::new);

    @RegName("")
    public static final Item CALC_CHIP = ITEMS.register("calc_chip", CalcChip::new);

    @RegName("")
    public static final Item COIN = ITEMS.register("coin", Coin::new);

    @RegName("")
    public static final Item CONSTRAINT_INGOT = ITEMS.register("constraint_ingot", ConstraintIngot::new);

    @RegName("")
    public static final Item CONSTRAINT_PLATE = ITEMS.register("constraint_plate", ConstraintPlate::new);

    @RegName("")
    public static final Item DATA_CHIP = ITEMS.register("data_chip", DataChip::new);

    @RegName("")
    public static final Item DEVELOPER_PORTABLE = ITEMS.register("developer_portable", DeveloperPortable::new);

    @RegName("")
    public static final Item ENERGY_CONVERT_COMPONENT = ITEMS.register("energy_convert_component", EnergyConvertComponent::new);

    @RegName("")
    public static final Item ENERGY_UNIT = ITEMS.register("energy_unit", EnergyUnit::new);

    @RegName("")
    public static final Item FACTOR_ELECTROMASTER = ITEMS.register("factor_electromaster", FactorElectromaster::new);

    @RegName("")
    public static final Item FACTOR_MELTDOWNER = ITEMS.register("factor_meltdowner", FactorMeltdowner::new);

    @RegName("")
    public static final Item FACTOR_TELEPORTER = ITEMS.register("factor_teleporter", FactorTeleporter::new);

    @RegName("")
    public static final Item FACTOR_VECMANIP = ITEMS.register("factor_vecmanip", FactorVecmanip::new);

    @RegName("")
    public static final Item INFO_COMPONENT = ITEMS.register("info_component", InfoComponent::new);

    @RegName("")
    public static final Item MAGNETIC_COIL = ITEMS.register("magnetic_coil", MagneticCoil::new);

    @RegName("")
    public static final Item MAG_HOOK = ITEMS.register("mag_hook", MagHook::new);

    @RegName("")
    public static final Item MATTER_UNIT = ITEMS.register("matter_unit", MatterUnit::new);

    @RegName("")
    public static final Item MAT_CORE_0 = ITEMS.register("mat_core_0", MatCore0::new);

    @RegName("")
    public static final Item MAT_CORE_1 = ITEMS.register("mat_core_1", MatCore1::new);

    @RegName("")
    public static final Item MAT_CORE_2 = ITEMS.register("mat_core_2", MatCore2::new);

    @RegName("")
    public static final Item MEDIA_LEVEL5_JUDGELIGHT = ITEMS.register("media_level5_judgelight", MediaLevel5Judgelight::new);

    @RegName("")
    public static final Item MEDIA_ONLY_MY_RAILGUN = ITEMS.register("media_only_my_railgun", MediaOnlyMyRailgun::new);

    @RegName("")
    public static final Item MEDIA_SISTERS_NOISE = ITEMS.register("media_sisters_noise", MediaSistersNoise::new);

    @RegName("")
    public static final Item NEEDLE = ITEMS.register("needle", Needle::new);

    @RegName("")
    public static final Item REINFORCED_IRON_PLATE = ITEMS.register("reinforced_iron_plate", ReinforcedIronPlate::new);

    @RegName("")
    public static final Item RESONANCE_COMPONENT = ITEMS.register("resonance_component", ResonanceComponent::new);

    @RegName("")
    public static final Item SILBARN = ITEMS.register("silbarn", Silbarn::new);

    @RegName("")
    public static final Item TERMINAL_INSTALLER = ITEMS.register("terminal_installer", TerminalInstaller::new);

    @RegName("")
    public static final Item WAFER = ITEMS.register("wafer", Wafer::new);

    @RegName("")
    public static final Item WINDGEN_FAN = ITEMS.register("windgen_fan", WindgenFan::new);

}
