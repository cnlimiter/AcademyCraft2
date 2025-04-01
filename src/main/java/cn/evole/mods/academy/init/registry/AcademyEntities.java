package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.Static;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class AcademyEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Static.MOD_ID);



    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup() {

    }

}
