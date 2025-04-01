package cn.evole.mods.academy.api.common.wrapper;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandlerModifiable;

/**
 * @Project: Avaritia
 * @Author: cnlimiter
 * @CreateTime: 2025/2/1 02:48
 * @Description:
 */
public interface BaseItemWrapper extends IItemHandlerModifiable, INBTSerializable<CompoundTag> {
}
