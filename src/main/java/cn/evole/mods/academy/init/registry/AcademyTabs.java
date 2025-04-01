package cn.evole.mods.academy.init.registry;

import cn.evole.mods.academy.AcademyCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: AcademyCraft2
 * @Author: cnlimiter
 * @CreateTime: 2025/4/1 13:46
 * @Description:
 */
public class AcademyTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AcademyCraft.MODID);
    public static final List<RegistryObject<Item>> ACCEPT_ITEM = new ArrayList<>();
    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = TABS.register("academy_group", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tab.Academy"))
            .icon(() -> AcademyItems.CAT_ENGINE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                for (var item : ACCEPT_ITEM){
                    output.accept(item.get());
                }

            })
            .build());

}
