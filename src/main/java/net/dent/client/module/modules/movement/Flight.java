package net.dent.client.module.modules.movement;

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
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class Flight extends Module {

    private float speed = (float) 0.1;

    private Setting Speed = new Setting(this, "Flight Speed", 1, 1, 5);

    public Flight() {
        //name, key, category, isGhost
        super("Flight", GLFW.GLFW_KEY_0, Category.MOVEMENT, true);
        addSetting(Speed);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
        if (isToggle()) {
            mc.player.abilities.setFlySpeed((float)0.1);
            mc.player.abilities.flying = true;
        }
    }

    @Override
    public void onEnable() {
        //Once, when enabled
        super.onEnable(); //THIS IS ESSENTIAL

    }

    @Override
    public void onDisable() {
        //Once, when disabled
        super.onDisable(); //THIS IS ESSENTIAL
        mc.player.abilities.flying = false;
        mc.player.flyingSpeed = (float) 0.1;
    }
}