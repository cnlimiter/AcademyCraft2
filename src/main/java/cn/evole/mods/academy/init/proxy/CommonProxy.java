package cn.evole.mods.academy.init.proxy;

import cn.evole.mods.academy.init.gen.provider.AcademyBlockTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.objectweb.asm.Type;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Name: AcademyCraft2 / CommonProxy
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:12
 * Description:
 */

public class CommonProxy {


    public void construct(IEventBus modBus)
    {
        modBus.addListener(CommonProxy::gatherData);
    }

    public void commonSetup()
    {
    }

    public void clientSetup()
    {
    }

    public Player getClientPlayer()
    {
        return null;
    }



    public ReloadableResourceManager getResourceManager()
    {
        MinecraftServer serv = ServerLifecycleHooks.getCurrentServer();
        if(serv != null) return (ReloadableResourceManager) serv.getServerResources().resourceManager();
        return null;
    }

    public Consumer<FMLClientSetupEvent> addTESR(Type owner, String member, Type tesr)
    {
        return null;
    }

    public Consumer<RegisterParticleProvidersEvent> addParticleTypeProvider(Type owner, String member, Type tesr)
    {
        return null;
    }


    public String getLanguage()
    {
        return "en_us";
    }

    public String getLanguage(Player player)
    {
        if(player instanceof ServerPlayer ent)
            return ent.getLanguage();
        return getLanguage();
    }


    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(event.includeServer(), new AcademyBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));

    }

}
