package net.dent.client.module.modules.render;

import net.dent.client.event.EventTarget;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.dent.client.setting.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.client.options.GameOptions;
import org.lwjgl.glfw.GLFW;

public class Zoom extends Module {

    private double normal = 103;

    private Setting fov = new Setting(this, "FOV", 30, -180, 180);

    public Zoom() {
        super("Zoom", GLFW.GLFW_KEY_C, Category.RENDER, true);
        addSetting(fov);
    }



    @Override
    public void onEnable() {
        super.onEnable();
        normal = mc.options.fov;
        mc.options.fov = fov.getCurrentValueInt();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.options.fov = normal;
    }
}
