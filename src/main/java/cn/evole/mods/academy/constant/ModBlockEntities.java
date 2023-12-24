package cn.evole.mods.academy.constant;

import cn.evole.mods.academy.api.annotations.Reg;
import cn.evole.mods.academy.api.annotations.RegName;
import cn.evole.mods.academy.api.annotations.TileRenderer;
import cn.evole.mods.academy.api.init.registry.BlockApi;
import cn.evole.mods.academy.client.render.CatEngineRender;
import cn.evole.mods.academy.client.render.WindGenFanRender;
import cn.evole.mods.academy.common.blockentity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;

@Reg
public class ModBlockEntities {

    @RegName
    @TileRenderer(CatEngineRender.class)
    public static final BlockEntityType<CatEngineBlockEntity> CAT_ENGINE = BlockApi.createBlockEntityType(CatEngineBlockEntity::new, ModBlocks.CAT_ENGINE);
    @RegName
    public static final BlockEntityType<DevNormalBlockEntity> DEV_NORMAL = BlockApi.createBlockEntityType(DevNormalBlockEntity::new, ModBlocks.DEV_NORMAL);
    @RegName
    public static final BlockEntityType<DevAdvancedBlockEntity> DEV_ADVANCED = BlockApi.createBlockEntityType(DevAdvancedBlockEntity::new, ModBlocks.DEV_NORMAL);
    @RegName
    public static final BlockEntityType<DevNormalSubBlockEntity> DEV_NORMAL_SUB = BlockApi.createBlockEntityType(DevNormalSubBlockEntity::new, ModBlocks.DEV_NORMAL_SUB);
    @RegName
    public static final BlockEntityType<DevAdvancedBlockEntity> DEV_ADVANCED_SUB = BlockApi.createBlockEntityType(DevAdvancedBlockEntity::new, ModBlocks.DEV_ADVANCED_SUB);
    @RegName
    public static final BlockEntityType<WindGenBaseSubBlockEntity> WIND_GEN_BASE_SUB = BlockApi.createBlockEntityType(WindGenBaseSubBlockEntity::new, ModBlocks.WIND_GEN_BASE_SUB);
    @RegName
    public static final BlockEntityType<MatrixBlockEntity> MATRIX = BlockApi.createBlockEntityType(MatrixBlockEntity::new, ModBlocks.MATRIX);
    @RegName
    public static final BlockEntityType<MatrixSubBlockEntity> MATRIX_SUB = BlockApi.createBlockEntityType(MatrixSubBlockEntity::new, ModBlocks.MATRIX_SUB);
    @RegName
    public static final BlockEntityType<PhaseGenBlockEntity> PHASE_GEN = BlockApi.createBlockEntityType(PhaseGenBlockEntity::new, ModBlocks.PHASE_GEN);
    @RegName
    public static final BlockEntityType<SolarGenBlockEntity> SOLAR_GEN = BlockApi.createBlockEntityType(SolarGenBlockEntity::new, ModBlocks.SOLAR_GEN);
    @RegName
    public static final BlockEntityType<WindGenBaseBlockEntity> WINDGEN_BASE = BlockApi.createBlockEntityType(WindGenBaseBlockEntity::new, ModBlocks.WINDGEN_BASE);
    @RegName
    @TileRenderer(WindGenFanRender.class)
    public static final BlockEntityType<WindGenFanBlockEntity> WINDGEN_FAN = BlockApi.createBlockEntityType(WindGenFanBlockEntity::new, ModBlocks.WINDGEN_FAN);
    @RegName
    public static final BlockEntityType<WindGenMainBlockEntity> WINDGEN_MAIN = BlockApi.createBlockEntityType(WindGenMainBlockEntity::new, ModBlocks.WINDGEN_MAIN);
    @RegName
    public static final BlockEntityType<WindGenPillarBlockEntity> WINDGEN_PILLAR = BlockApi.createBlockEntityType(WindGenPillarBlockEntity::new, ModBlocks.WINDGEN_PILLAR);
    @RegName
    public static final BlockEntityType<PhaseLiquidBlockEntity> PHASE_LIQUID = BlockApi.createBlockEntityType(PhaseLiquidBlockEntity::new, ModBlocks.PHASE_LIQUID);
    @RegName
    public static final BlockEntityType<NodeBasicBlockEntity> NODE_BASIC = BlockApi.createBlockEntityType(NodeBasicBlockEntity::new, ModBlocks.NODE_BASIC);
}
