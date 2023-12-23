package cn.evole.mods.academy.common;

import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.api.annotations.TileRenderer;
import cn.evole.mods.academy.api.init.registry.BlockApi;
import cn.evole.mods.academy.client.render.CatEngineRender;
import cn.evole.mods.academy.common.blockentity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Reg
public class ModBlockEntities {

    @TileRenderer(CatEngineRender.class)
    @RegName("cat_engine")
    public static final BlockEntityType<CatEngineBlockEntity> CAT_ENGINE = BlockApi.createBlockEntityType(CatEngineBlockEntity::new, ModBlocks.CAT_ENGINE);
    public static final RegistryObject<BlockEntityType<DevNormalBlockEntity>> DEV_NORMAL = BLOCK_ENTITIES.register("dev_normal", () -> BlockEntityType.Builder.of(DevNormalBlockEntity::new, ModBlocks.DEV_NORMAL.get()).build(null));
    public static final RegistryObject<BlockEntityType<DevAdvancedBlockEntity>> DEV_ADVANCED = BLOCK_ENTITIES.register("dev_advanced", () -> BlockEntityType.Builder.of(DevAdvancedBlockEntity::new, ModBlocks.DEV_NORMAL.get()).build(null));
    public static final RegistryObject<BlockEntityType<DevNormalSubBlockEntity>> DEV_NORMAL_SUB = BLOCK_ENTITIES.register("dev_normal_sub", () -> BlockEntityType.Builder.of(DevNormalSubBlockEntity::new, ModBlocks.DEV_NORMAL_SUB.get()).build(null));
    public static final RegistryObject<BlockEntityType<DevAdvancedBlockEntity>> DEV_ADVANCED_SUB = BLOCK_ENTITIES.register("dev_advanced_sub", () -> BlockEntityType.Builder.of(DevAdvancedBlockEntity::new, ModBlocks.DEV_ADVANCED_SUB.get()).build(null));
    public static final RegistryObject<BlockEntityType<WindGenBaseSubBlockEntity>> WIND_GEN_BASE_SUB = BLOCK_ENTITIES.register("windgen_base_sub", () -> BlockEntityType.Builder.of(WindGenBaseSubBlockEntity::new, ModBlocks.WIND_GEN_BASE_SUB.get()).build(null));
    public static final RegistryObject<BlockEntityType<MatrixBlockEntity>> MATRIX = BLOCK_ENTITIES.register("matrix", () -> BlockEntityType.Builder.of(MatrixBlockEntity::new, ModBlocks.MATRIX.get()).build(null));
    public static final RegistryObject<BlockEntityType<MatrixSubBlockEntity>> MATRIX_SUB = BLOCK_ENTITIES.register("matrix_sub", () -> BlockEntityType.Builder.of(MatrixSubBlockEntity::new, ModBlocks.MATRIX_SUB.get()).build(null));
    public static final RegistryObject<BlockEntityType<PhaseGenBlockEntity>> PHASE_GEN = BLOCK_ENTITIES.register("phase_gen", () -> BlockEntityType.Builder.of(PhaseGenBlockEntity::new, ModBlocks.PHASE_GEN.get()).build(null));
    public static final RegistryObject<BlockEntityType<SolarGenBlockEntity>> SOLAR_GEN = BLOCK_ENTITIES.register("solar_gen", () -> BlockEntityType.Builder.of(SolarGenBlockEntity::new, ModBlocks.SOLAR_GEN.get()).build(null));
    public static final RegistryObject<BlockEntityType<WindGenBaseBlockEntity>> WINDGEN_BASE = BLOCK_ENTITIES.register("windgen_base", () -> BlockEntityType.Builder.of(WindGenBaseBlockEntity::new, ModBlocks.WINDGEN_BASE.get()).build(null));
    public static final RegistryObject<BlockEntityType<WindGenFanBlockEntity>> WINDGEN_FAN = BLOCK_ENTITIES.register("windgen_fan", () -> BlockEntityType.Builder.of(WindGenFanBlockEntity::new, ModBlocks.WINDGEN_FAN.get()).build(null));
    public static final RegistryObject<BlockEntityType<WindGenMainBlockEntity>> WINDGEN_MAIN = BLOCK_ENTITIES.register("windgen_main", () -> BlockEntityType.Builder.of(WindGenMainBlockEntity::new, ModBlocks.WINDGEN_MAIN.get()).build(null));
    public static final RegistryObject<BlockEntityType<WindGenPillarBlockEntity>> WINDGEN_PILLAR = BLOCK_ENTITIES.register("windgen_pillar", () -> BlockEntityType.Builder.of(WindGenPillarBlockEntity::new, ModBlocks.WINDGEN_PILLAR.get()).build(null));
    public static final RegistryObject<BlockEntityType<PhaseLiquidBlockEntity>> PHASE_LIQUID = BLOCK_ENTITIES.register("phase_liquid", () -> BlockEntityType.Builder.of(PhaseLiquidBlockEntity::new, ModBlocks.PHASE_LIQUID.get()).build(null));
    public static final RegistryObject<BlockEntityType<NodeBasicBlockEntity>> NODE_BASIC = BLOCK_ENTITIES.register("node_basic", () -> BlockEntityType.Builder.of(NodeBasicBlockEntity::new, ModBlocks.NODE_BASIC.get()).build(null));
}
