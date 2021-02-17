package net.dent.client.module.modules.movement;

import org.lwjgl.glfw.GLFW;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", GLFW.GLFW_KEY_SEMICOLON, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        mc.player.setSprinting(true);
    }
}
