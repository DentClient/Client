package net.dent.client.event.events;

import net.dent.client.event.Event;
public class EventRender3D extends Event {

	public float particlTicks;

	public EventRender3D(float particlTicks) {
		super(Type.PRE);
		this.particlTicks = particlTicks;
	}

}
