package cn.evole.mods.academy.api.client.gui.component;

import cn.evole.mods.academy.api.client.gui.Widget;
import cn.evole.mods.academy.api.client.gui.event.GuiEvent;
import cn.evole.mods.academy.api.client.gui.event.IGuiEventHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: AcademyCraft2 / Component
 * Author: cnlimiter
 * CreateTime: 2023/12/24 13:34
 * Description:
 */

@OnlyIn(Dist.CLIENT)
public class Component {

    public final String name;

    public boolean enabled = true;

    public boolean canEdit = true;

    /**
     * The widget that this component is attached to. To ease impl and usage, this is exposed as
     *  public field, but DONT assign it, else it yields undefined behaviour.
     */
    @SerializeExcluded
    public Widget widget;

    public Component(String _name) {
        name = _name;
    }

    public <T extends GuiEvent> void listen(Class<? extends T> type, IGuiEventHandler<T> handler) {
        listen(type, handler, 0);
    }

    public <T extends GuiEvent> void listen(Class<? extends T> type, IGuiEventHandler<T> handler, int prio) {
        if(widget != null)
            throw new RuntimeException("Can only add event handlers before componenet is added into widget");
        Node n = new Node();
        n.type = type;
        n.handler = new EHWrapper<>(handler);
        n.prio = prio;
        addedHandlers.add(n);
    }

    /**
     * Called when the component is added into a widget, and the widget field is correctly set.
     */
    public void onAdded() {
        for(Node n : addedHandlers) {
            widget.listen(n.type, n.prio, false, n.handler);
        }
    }

    public void onRemoved() {
        for(Node n : addedHandlers) {
            widget.unlisten(n.type, n.handler);
        }
    }

    public Component copy() {
        return CopyHelper.instance.copy(this);
    }

    private List<Node> addedHandlers = new ArrayList<>();

    @OnlyIn(Dist.CLIENT)
    private final class EHWrapper<T extends GuiEvent> implements IGuiEventHandler<T> {

        final IGuiEventHandler<T> wrapped;

        public EHWrapper(IGuiEventHandler<T> _wrapped) {
            wrapped = _wrapped;
        }

        @Override
        public void handleEvent(Widget w, T event) {
            if(enabled)
                wrapped.handleEvent(w, event);
        }

    }

    @OnlyIn(Dist.CLIENT)
    private static class Node {
        Class<? extends GuiEvent> type;
        IGuiEventHandler handler;
        int prio;
    }

}
