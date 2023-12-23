package cn.evole.mods.academy.api.interfaces;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.RegisterEvent;

/**
 * Name: AcademyCraft2 / ICustomReg
 * Author: cnlimiter
 * CreateTime: 2023/12/24 0:00
 * Description:
 */

public interface ICustomReg
{
    void performRegister(RegisterEvent event, ResourceLocation id);
}
