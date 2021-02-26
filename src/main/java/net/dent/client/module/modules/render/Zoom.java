package net.dent.client.module.modules.render;

import net.dent.client.module.Category;
import net.dent.client.module.Module;
import org.lwjgl.glfw.GLFW;

public class Zoom extends Module {

    private double normal = 103;

    public Zoom() {
        super("Zoom", GLFW.GLFW_KEY_C, Category.RENDER, true);
    }

    @Override
    public void onEnable() {
        normal = mc.options.fov;
        mc.options.fov = 30;
        toggle();
    }

    @Override
    public void onDisable() {
        mc.options.fov = normal;
    }
}
