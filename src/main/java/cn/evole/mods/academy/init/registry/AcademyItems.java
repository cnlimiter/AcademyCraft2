package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.Static;
import cn.evole.mods.academy.api.common.item.BaseItem;
import cn.evole.mods.academy.common.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class AcademyItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Static.MOD_ID);


    public static RegistryObject<Item> TUTORIAL = item("tutorial", Tutorial::new);
    public static RegistryObject<Item> LOGO = item("logo", Logo::new);
    public static RegistryObject<Item> CRYSTAL_LOW = item("crystal_low", CrystalLow::new);
    public static RegistryObject<Item> CRYSTAL_NORMAL = item("crystal_normal", CrystalNormal::new);
    public static RegistryObject<Item> CRYSTAL_PURE = item("crystal_pure", CrystalPure::new);
    public static RegistryObject<Item> RESO_CRYSTAL = item("reso_crystal", ResoCrystal::new);
    public static RegistryObject<Item> PHASE_BUCKET = item("imag_phase", () -> new BucketItem(AcademyFluids.PHASE_LIQUID, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)));


    public static RegistryObject<Item> APP_FREQ_TRANSMITTER = item("app_freq_transmitter", AppFreqTransmitter::new);
    public static RegistryObject<Item> APP_MEDIA_PLAYER = item("app_media_player", AppMediaPlayer::new);
    public static RegistryObject<Item> APP_SETTINGS = item("app_settings", AppSettings::new);
    public static RegistryObject<Item> APP_SKILL_TREE = item("app_skill_tree", AppSkillTree::new);
    public static RegistryObject<Item> BRAIN_COMPONENT = item("brain_component", BrainComponent::new);
    public static RegistryObject<Item> CALC_CHIP = item("calc_chip", CalcChip::new);
    public static RegistryObject<Item> COIN = item("coin", Coin::new);
    public static RegistryObject<Item> CONSTRAINT_INGOT = item("constraint_ingot", ConstraintIngot::new);
    public static RegistryObject<Item> CONSTRAINT_PLATE = item("constraint_plate", ConstraintPlate::new);
    public static RegistryObject<Item> DATA_CHIP = item("data_chip", DataChip::new);
    public static RegistryObject<Item> DEVELOPER_PORTABLE = item("developer_portable", DeveloperPortable::new);
    public static RegistryObject<Item> ENERGY_CONVERT_COMPONENT = item("energy_convert_component", EnergyConvertComponent::new);
    public static RegistryObject<Item> ENERGY_UNIT = item("energy_unit", EnergyUnit::new);
    public static RegistryObject<Item> FACTOR_ELECTROMASTER = item("factor_electromaster", FactorElectromaster::new);
    public static RegistryObject<Item> FACTOR_MELTDOWNER = item("factor_meltdowner", FactorMeltdowner::new);
    public static RegistryObject<Item> FACTOR_TELEPORTER = item("factor_teleporter", FactorTeleporter::new);
    public static RegistryObject<Item> FACTOR_VECMANIP = item("factor_vecmanip", FactorVecmanip::new);
    public static RegistryObject<Item> INFO_COMPONENT = item("info_component", InfoComponent::new);
    public static RegistryObject<Item> MAGNETIC_COIL = item("magnetic_coil", MagneticCoil::new);
    public static RegistryObject<Item> MAG_HOOK = item("mag_hook", MagHook::new);
    public static RegistryObject<Item> MATTER_UNIT = item("matter_unit", MatterUnit::new);
    public static RegistryObject<Item> MAT_CORE_0 = item("mat_core_0", MatCore0::new);
    public static RegistryObject<Item> MAT_CORE_1 = item("mat_core_1", MatCore1::new);
    public static RegistryObject<Item> MAT_CORE_2 = item("mat_core_2", MatCore2::new);
    public static RegistryObject<Item> MEDIA_LEVEL5_JUDGELIGHT = item("media_level5_judgelight", MediaLevel5Judgelight::new);
    public static RegistryObject<Item> MEDIA_ONLY_MY_RAILGUN = item("media_only_my_railgun", MediaOnlyMyRailgun::new);
    public static RegistryObject<Item> MEDIA_SISTERS_NOISE = item("media_sisters_noise", MediaSistersNoise::new);
    public static RegistryObject<Item> NEEDLE = item("needle", Needle::new);
    public static RegistryObject<Item> REINFORCED_IRON_PLATE = item("reinforced_iron_plate", ReinforcedIronPlate::new);
    public static RegistryObject<Item> RESONANCE_COMPONENT = item("resonance_component", ResonanceComponent::new);
    public static RegistryObject<Item> SILBARN = item("silbarn", Silbarn::new);
    public static RegistryObject<Item> TERMINAL_INSTALLER = item("terminal_installer", TerminalInstaller::new);
    public static RegistryObject<Item> WAFER = item("wafer", Wafer::new);
    public static RegistryObject<Item> WINDGEN_FAN = item("windgen_fan", WindgenFan::new);



    public static RegistryObject<Item> item(String name) {
        return item(name, true);
    }

    public static RegistryObject<Item> item(String name, boolean exist) {
        return item(name, (e) -> new BaseItem(), exist);
    }

    public static RegistryObject<Item> item(String name, Function<String, Item> item) {
        return item(name, item, true);
    }

    public static RegistryObject<Item> item(String name, Function<String, Item> item, boolean exist) {
        return item(name, () -> item.apply(name), exist);
    }

    public static RegistryObject<Item> item(String name, Supplier<Item> item) {
        return item(name, item, true);
    }

    public static RegistryObject<Item> item(String name, Supplier<Item> item, boolean exist) {
        var regItem = ITEMS.register(name, item);
        if (exist) AcademyTabs.ACCEPT_ITEM.add(regItem);
        return regItem;
    }
}
