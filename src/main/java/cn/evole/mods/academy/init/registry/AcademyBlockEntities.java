package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.AcademyCraft;
import cn.evole.mods.academy.common.blockentity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AcademyBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, AcademyCraft.MODID);


    public static final RegistryObject<BlockEntityType<CatEngineBlockEntity>> CAT_ENGINE = blockEntity("cat_engine", CatEngineBlockEntity::new, AcademyBlocks.CAT_ENGINE.get());
    public static final RegistryObject<BlockEntityType<DevNormalBlockEntity>> DEV_NORMAL = blockEntity("dev_normal", DevNormalBlockEntity::new, AcademyBlocks.DEV_NORMAL.get());
    public static final RegistryObject<BlockEntityType<DevAdvancedBlockEntity>> DEV_ADVANCED = blockEntity("dev_advanced", DevAdvancedBlockEntity::new, AcademyBlocks.DEV_NORMAL.get());
    public static final RegistryObject<BlockEntityType<DevNormalSubBlockEntity>> DEV_NORMAL_SUB = blockEntity("dev_normal_sub", DevNormalSubBlockEntity::new, AcademyBlocks.DEV_NORMAL_SUB.get());
    public static final RegistryObject<BlockEntityType<DevAdvancedBlockEntity>> DEV_ADVANCED_SUB = blockEntity("dev_advanced_sub", DevAdvancedBlockEntity::new, AcademyBlocks.DEV_ADVANCED_SUB.get());
    public static final RegistryObject<BlockEntityType<WindGenBaseSubBlockEntity>> WIND_GEN_BASE_SUB = blockEntity("windgen_base_sub", WindGenBaseSubBlockEntity::new, AcademyBlocks.WIND_GEN_BASE_SUB.get());
    public static final RegistryObject<BlockEntityType<MatrixBlockEntity>> MATRIX = blockEntity("matrix", MatrixBlockEntity::new, AcademyBlocks.MATRIX.get());
    public static final RegistryObject<BlockEntityType<MatrixSubBlockEntity>> MATRIX_SUB = blockEntity("matrix_sub", MatrixSubBlockEntity::new, AcademyBlocks.MATRIX_SUB.get());
    public static final RegistryObject<BlockEntityType<PhaseGenBlockEntity>> PHASE_GEN = blockEntity("phase_gen", PhaseGenBlockEntity::new, AcademyBlocks.PHASE_GEN.get());
    public static final RegistryObject<BlockEntityType<SolarGenBlockEntity>> SOLAR_GEN = blockEntity("solar_gen", SolarGenBlockEntity::new, AcademyBlocks.SOLAR_GEN.get());
    public static final RegistryObject<BlockEntityType<WindGenBaseBlockEntity>> WINDGEN_BASE = blockEntity("windgen_base", WindGenBaseBlockEntity::new, AcademyBlocks.WINDGEN_BASE.get());
    public static final RegistryObject<BlockEntityType<WindGenFanBlockEntity>> WINDGEN_FAN = blockEntity("windgen_fan", WindGenFanBlockEntity::new, AcademyBlocks.WINDGEN_FAN.get());
    public static final RegistryObject<BlockEntityType<WindGenMainBlockEntity>> WINDGEN_MAIN = blockEntity("windgen_main", WindGenMainBlockEntity::new, AcademyBlocks.WINDGEN_MAIN.get());
    public static final RegistryObject<BlockEntityType<WindGenPillarBlockEntity>> WINDGEN_PILLAR = blockEntity("windgen_pillar", WindGenPillarBlockEntity::new, AcademyBlocks.WINDGEN_PILLAR.get());
    public static final RegistryObject<BlockEntityType<PhaseLiquidBlockEntity>> PHASE_LIQUID = blockEntity("phase_liquid", PhaseLiquidBlockEntity::new, AcademyBlocks.PHASE_LIQUID.get());
    public static final RegistryObject<BlockEntityType<NodeBasicBlockEntity>> NODE_BASIC = blockEntity("node_basic", NodeBasicBlockEntity::new, AcademyBlocks.NODE_BASIC.get());




    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup() {
    }


    public static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> blockEntity(String name, BlockEntityType.BlockEntitySupplier<T> tile, Block... blocks) {
        return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(tile, blocks).build(null));
    }
}
