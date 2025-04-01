package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.Static;
import cn.evole.mods.academy.common.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class AcademyBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Static.MOD_ID);

    public static RegistryObject<Block> CAT_ENGINE = itemBlock("cat_engine", CatEngine::new);
    public static RegistryObject<Block> ABILITY_INTERFERER = itemBlock("ability_interferer", AbilityInterferer::new);
    public static RegistryObject<Block> CONSTRAIN_METAL = itemBlock("constraint_metal", ConstraintMetal::new);
    public static RegistryObject<Block> CRYSTAL_ORE = itemBlock("crystal_ore", CrystalOre::new);
    public static RegistryObject<Block> RESO_ORE = itemBlock("reso_ore", ResoOre::new);
    public static RegistryObject<Block> IMAGSIL_ORE = itemBlock("imagsil_ore", ImagsilOre::new);
    public static RegistryObject<Block> IMAG_FUSOR = itemBlock("imag_fusor", ImagFusor::new);
    public static RegistryObject<Block> MACHINE_FRAME = itemBlock("machine_frame", MachineFrame::new);
    public static RegistryObject<Block> METAL_FORMER = itemBlock("metal_former", MetalFomer::new);
    public static RegistryObject<Block> NODE_BASIC = itemBlock("node_basic", NodeBasic::new);
    public static RegistryObject<Block> NODE_ADVANCED = itemBlock("node_advanced", NodeAdvanced::new);
    public static RegistryObject<Block> NODE_STANDARD = itemBlock("node_standard", NodeStandard::new);
    public static RegistryObject<Block> DEV_NORMAL = itemBlock("dev_normal", DevNormal::new);
    public static RegistryObject<Block> DEV_ADVANCED = itemBlock("dev_advanced", DevAdvanced::new);
    public static RegistryObject<Block> DEV_NORMAL_SUB = itemBlock("dev_normal_sub", DevNormalSubBlock::new, false);
    public static RegistryObject<Block> DEV_ADVANCED_SUB = itemBlock("dev_advanced_sub", DevAdvancedSubBlock::new, false);
    public static RegistryObject<Block> WIND_GEN_BASE_SUB = itemBlock("windgen_base_sub", WindGenBaseSubBlock::new, false);
    public static RegistryObject<Block> MATRIX = itemBlock("matrix", Matrix::new);
    public static RegistryObject<Block> MATRIX_SUB = itemBlock("matrix_sub", MatrixSubBlock::new, false);
    public static RegistryObject<Block> PHASE_GEN = itemBlock("phase_gen", PhaseGen::new);
    public static RegistryObject<Block> SOLAR_GEN = itemBlock("solar_gen", SolarGen::new);
    public static RegistryObject<Block> WINDGEN_BASE = itemBlock("windgen_base", WindGenBase::new);
    public static RegistryObject<Block> WINDGEN_MAIN = itemBlock("windgen_main", WindGenMain::new);
    public static RegistryObject<Block> WINDGEN_PILLAR = itemBlock("windgen_pillar", WindGenPillar::new);
    public static RegistryObject<Block> WINDGEN_FAN = itemBlock("windgen_fan_block", WindGenFan::new, false);
    public static RegistryObject<Block> PHASE_LIQUID = itemBlock("phase_liquid", PhaseFluidBlock::new, false);




    private static RegistryObject<Block> baseBlock(String name, Supplier<Block> block) {
        return itemBlock(name, block);
    }

    public static RegistryObject<Block> itemBlock(String name, Supplier<Block> block) {
        return itemBlock(name, block, true);
    }

    public static RegistryObject<Block> itemBlock(String name, Supplier<Block> block, boolean hasItem) {
        return itemBlock(name, block, hasItem, new Item.Properties());
    }

    public static RegistryObject<Block> itemBlock(String name, Supplier<Block> block, Rarity rarity) {
        return itemBlock(name, block, true, new Item.Properties().rarity(rarity));
    }

    public static RegistryObject<Block> itemBlock(String name, Supplier<Block> block, boolean hasItem, Item.Properties properties) {
        var reg = BLOCKS.register(name, block);
        if (hasItem) AcademyItems.item(name, () -> new BlockItem(reg.get(), properties));
        return reg;
    }

    public static RegistryObject<Block> itemBurnBlock(String name, Supplier<Block> block, boolean hasItem, Item.Properties properties, int burnTime) {
        var reg = BLOCKS.register(name, block);
        if (hasItem) AcademyItems.item(name, () -> new BlockItem(reg.get(), properties){
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return burnTime;
            }
        });
        return reg;
    }
}
