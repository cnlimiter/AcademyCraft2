package cn.evole.mods.academy.api.client.gui.event;

import cn.evole.mods.academy.api.client.gui.Widget;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Name: AcademyCraft2 / AddWidgetEvent
 * Author: cnlimiter
 * CreateTime: 2023/12/24 13:40
 * Description:
 */

@OnlyIn(Dist.CLIENT)
public class AddWidgetEvent implements GuiEvent {

    public final Widget widget;

    public AddWidgetEvent(Widget w) {
        widget = w;
    }

}

