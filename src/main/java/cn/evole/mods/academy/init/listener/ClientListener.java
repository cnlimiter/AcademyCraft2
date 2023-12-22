package cn.evole.mods.academy.init.listener;

import cn.evole.mods.academy.AcademyCraft;
import cn.evole.mods.academy.client.model.CatEngineModel;
import cn.evole.mods.academy.client.render.CatEngineRender;
import cn.evole.mods.academy.client.render.PhaseLiquidRender;
import cn.evole.mods.academy.client.render.WindGenFanRender;
import cn.evole.mods.academy.common.AcademyBlockEntities;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

/**
 * 客户端事件监听器
 *
 * @author lliiooll
 */
@Mod.EventBusSubscriber(modid = AcademyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientListener {

    private static ClientListener INSTANCE = null;
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        LOGGER.info("HELLO FROM CLIENT SETUP");
        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    //将所有的生物的皮肤贴图信息写在这个函数里，有几个写几个
    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CatEngineModel.LAYER_LOCATION, CatEngineModel::createBodyLayer);
    }

    //将所有的生物的渲染信息写在这个函数里，有几个写几个
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(AcademyBlockEntities.CAT_ENGINE.get(), CatEngineRender::new);
        event.registerBlockEntityRenderer(AcademyBlockEntities.PHASE_LIQUID.get(), PhaseLiquidRender::new);
        event.registerBlockEntityRenderer(AcademyBlockEntities.WINDGEN_FAN.get(), WindGenFanRender::new);
    }


    public static ClientListener getInstance() {
        if (INSTANCE == null) INSTANCE = new ClientListener();
        return INSTANCE;
    }
}
