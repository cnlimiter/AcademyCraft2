package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.Static;
import cn.evole.mods.academy.common.blockentity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AcademyBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Static.MOD_ID);


    public static RegistryObject<BlockEntityType<CatEngineBlockEntity>> CAT_ENGINE = blockEntity("cat_engine", CatEngineBlockEntity::new, () -> new Block[]{AcademyBlocks.CAT_ENGINE.get()});
    public static RegistryObject<BlockEntityType<DevNormalBlockEntity>> DEV_NORMAL = blockEntity("dev_normal", DevNormalBlockEntity::new, () -> new Block[]{AcademyBlocks.DEV_NORMAL.get()});
    public static RegistryObject<BlockEntityType<DevAdvancedBlockEntity>> DEV_ADVANCED = blockEntity("dev_advanced", DevAdvancedBlockEntity::new, () -> new Block[]{AcademyBlocks.DEV_NORMAL.get()});
    public static RegistryObject<BlockEntityType<DevNormalSubBlockEntity>> DEV_NORMAL_SUB = blockEntity("dev_normal_sub", DevNormalSubBlockEntity::new, () -> new Block[]{AcademyBlocks.DEV_NORMAL_SUB.get()});
    public static RegistryObject<BlockEntityType<DevAdvancedBlockEntity>> DEV_ADVANCED_SUB = blockEntity("dev_advanced_sub", DevAdvancedBlockEntity::new, () -> new Block[]{AcademyBlocks.DEV_ADVANCED_SUB.get()});
    public static RegistryObject<BlockEntityType<WindGenBaseSubBlockEntity>> WIND_GEN_BASE_SUB = blockEntity("windgen_base_sub", WindGenBaseSubBlockEntity::new, () -> new Block[]{AcademyBlocks.WIND_GEN_BASE_SUB.get()});
    public static RegistryObject<BlockEntityType<MatrixBlockEntity>> MATRIX = blockEntity("matrix", MatrixBlockEntity::new, () -> new Block[]{AcademyBlocks.MATRIX.get()});
    public static RegistryObject<BlockEntityType<MatrixSubBlockEntity>> MATRIX_SUB = blockEntity("matrix_sub", MatrixSubBlockEntity::new, () -> new Block[]{AcademyBlocks.MATRIX_SUB.get()});
    public static RegistryObject<BlockEntityType<PhaseGenBlockEntity>> PHASE_GEN = blockEntity("phase_gen", PhaseGenBlockEntity::new, () -> new Block[]{AcademyBlocks.PHASE_GEN.get()});
    public static RegistryObject<BlockEntityType<SolarGenBlockEntity>> SOLAR_GEN = blockEntity("solar_gen", SolarGenBlockEntity::new, () -> new Block[]{AcademyBlocks.SOLAR_GEN.get()});
    public static RegistryObject<BlockEntityType<WindGenBaseBlockEntity>> WINDGEN_BASE = blockEntity("windgen_base", WindGenBaseBlockEntity::new, () -> new Block[]{AcademyBlocks.WINDGEN_BASE.get()});
    public static RegistryObject<BlockEntityType<WindGenFanBlockEntity>> WINDGEN_FAN = blockEntity("windgen_fan", WindGenFanBlockEntity::new, () -> new Block[]{AcademyBlocks.WINDGEN_FAN.get()});
    public static RegistryObject<BlockEntityType<WindGenMainBlockEntity>> WINDGEN_MAIN = blockEntity("windgen_main", WindGenMainBlockEntity::new, () -> new Block[]{AcademyBlocks.WINDGEN_MAIN.get()});
    public static RegistryObject<BlockEntityType<WindGenPillarBlockEntity>> WINDGEN_PILLAR = blockEntity("windgen_pillar", WindGenPillarBlockEntity::new, () -> new Block[]{AcademyBlocks.WINDGEN_PILLAR.get()});
    public static RegistryObject<BlockEntityType<PhaseLiquidBlockEntity>> PHASE_LIQUID = blockEntity("phase_liquid", PhaseLiquidBlockEntity::new, () -> new Block[]{AcademyBlocks.PHASE_LIQUID.get()});
    public static RegistryObject<BlockEntityType<NodeBasicBlockEntity>> NODE_BASIC = blockEntity("node_basic", NodeBasicBlockEntity::new, () -> new Block[]{AcademyBlocks.NODE_BASIC.get()});




    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup() {
    }


    public static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> blockEntity(String name, BlockEntityType.BlockEntitySupplier<T> tile, Supplier<Block[]> blocks) {
        return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(tile, blocks.get()).build(null));
    }
}
