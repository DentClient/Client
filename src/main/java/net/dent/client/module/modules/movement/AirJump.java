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
import net.minecraft.entity.effect.StatusEffectInstance;
import org.lwjgl.glfw.GLFW;

public class AirJump extends Module {



    public AirJump() {
        //name, key, category, isGhost
        super("Air Jump", GLFW.GLFW_KEY_L, Category.MOVEMENT, true);

    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
        if (isToggle()) {
            mc.player.setOnGround(true);
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

    }
}