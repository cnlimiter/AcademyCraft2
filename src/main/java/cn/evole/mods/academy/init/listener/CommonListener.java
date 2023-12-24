package cn.evole.mods.academy.init.listener;

import cn.evole.mods.academy.client.gui.NodeBasicGui;
import cn.evole.mods.academy.client.gui.WindBaseGui;
import cn.evole.mods.academy.client.gui.WindMainGui;
import cn.evole.mods.academy.constant.ModMenus;
import cn.evole.mods.academy.init.gen.provider.AcademyBlockTagsProvider;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

/**
 * 通用事件监听器
 *
 * @author lliiooll
 */
public class CommonListener {

    private static CommonListener INSTANCE = null;
    private static final Logger LOGGER = LogUtils.getLogger();
    private IEventBus modEventBus;

    public static CommonListener getInstance() {
        if (INSTANCE == null) INSTANCE = new CommonListener();
        return INSTANCE;
    }

    /**
     * 初始化事件
     */
    public void init() {
        if (this.modEventBus == null) {
            this.modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        }
        this.modEventBus.addListener(this::commonSetup);
        this.modEventBus.addListener(this::gatherData);
        this.modEventBus.addListener(this::clientSetup);
        NeoForge.EVENT_BUS.register(this);
    }

    public void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(event.includeServer(), new AcademyBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));

    }

    /**
     * 初始化事件
     *
     * @param event
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenus.WIND_BASE_MENU, WindBaseGui::new);
            MenuScreens.register(ModMenus.WIND_MAIN_MENU, WindMainGui::new);
            MenuScreens.register(ModMenus.NODE_BASIC, NodeBasicGui::new);
        });
    }


    public IEventBus getModEventBus() {
        return modEventBus;
    }

}
