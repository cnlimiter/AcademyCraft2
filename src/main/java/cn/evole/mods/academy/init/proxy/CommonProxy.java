package cn.evole.mods.academy.init.proxy;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.objectweb.asm.Type;

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

}
