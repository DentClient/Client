package net.dent.client.event.events;

import net.dent.client.event.Event;
import net.minecraft.client.util.math.MatrixStack;

public class EventRender2D extends Event {
	private final MatrixStack matrixStack;
	public EventRender2D(MatrixStack matrixStack) {
		super(Type.PRE);
		this.matrixStack = matrixStack;
	}

	public MatrixStack getMatrixStack() {
		return matrixStack;
	}

}
