package net.dent.client.module.modules.render;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventKeyboard;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.dent.client.setting.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.options.GameOptions;
import org.lwjgl.glfw.GLFW;

public class Zoom extends Module {

    private double normal = 103;

    private Setting fov = new Setting(this, "FOV", 30, -180, 180);

    public Zoom() {
        super("Zoom", GLFW.GLFW_KEY_UNKNOWN, Category.RENDER, true);
        addSetting(fov);
    }



    @EventTarget
    public void onUpdate(EventUpdate e) {
        if(mc.options.fov != fov.getCurrentValueInt()) {
            normal = mc.options.fov;
        }
    }

    @EventTarget
    public void onKey(EventKeyboard e) {
        if(this.isToggle()) {
            if(e.getAction() == GLFW.GLFW_RELEASE) {
                mc.options.fov = normal;
            }

            if (e.getAction() != GLFW.GLFW_PRESS) {
                return;
            }

            Screen screen = mc.currentScreen;
            if (screen != null) {
                return;
            }

            switch (e.getKeyCode()) {
                case GLFW.GLFW_KEY_C:
                    mc.options.fov = fov.getCurrentValueInt();
                    break;
                default:
                    mc.options.fov = normal;
                    break;
            }
        } else {
            return;
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.options.fov = normal;
    }
}
