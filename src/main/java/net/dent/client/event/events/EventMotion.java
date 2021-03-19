package net.dent.client.event.events;

import net.dent.client.event.Event;

public class EventMotion extends Event {
    //Called whenever the player moves
    public EventMotion(Event.Type type) {
        super(type);
    }

    //Look in ClientPlayerEntity mixin for the specific actions
}
