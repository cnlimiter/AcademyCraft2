package cn.evole.mods.academy.api.interfaces;

import cn.evole.mods.academy.api.common.CreativeTab;
import org.jetbrains.annotations.NotNull;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 0:03
 * Name ICreativeTabBlock
 * Description
 */

public interface ICreativeTabBlock {
    @NotNull
    CreativeTab getCreativeTab();
}
