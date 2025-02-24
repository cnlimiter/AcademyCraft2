package cn.evole.mods.academy.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseFactor extends AcademyItem {
    public BaseFactor(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        String key = getDescriptionId();
        Component tag = Component.translatable(key);
        if (!key.equalsIgnoreCase(tag.getString())) {
            components.add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.academy.induction_factor");
    }
}
