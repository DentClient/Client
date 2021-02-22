package net.dent.client.event;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.dent.client.DentClient;



public abstract class Event {

    private boolean cancelled;
    private Type type;

    public Event(Type type) {
        this.type = type;
        this.cancelled = false;
    }

    public enum Type {
        PRE, POST
    }

    public void call() {
        cancelled = false;

        CopyOnWriteArrayList<Data> dataList = DentClient.instance.eventManager.get(this.getClass());

        if (dataList == null) {
            return;
        }

        dataList.forEach(data -> {
            
            try {
                data.getTarget().invoke(data.getSource(), this);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        });


    }

    public Type getType() {
        return type;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }


}