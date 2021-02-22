package net.dent.client.module.modules.combat;

import org.lwjgl.glfw.GLFW;

import net.dent.client.module.Module;
import net.dent.client.module.Category;

public class Trigger extends Module {
    public Trigger() {
        super("Trigger", GLFW.GLFW_KEY_I, Category.COMBAT);
        
    }
}