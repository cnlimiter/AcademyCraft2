package cn.evole.mods.academy.api.client.gui.event;

import cn.evole.mods.academy.api.client.gui.Widget;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Author cnlimiter
 * CreateTime 2023/12/24 13:33
 * Name IGuiEventHandler
 * Description
 */

@FunctionalInterface
@OnlyIn(Dist.CLIENT)
public interface IGuiEventHandler<T extends GuiEvent> {

    void handleEvent(Widget w, T event);

}
