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
import org.lwjgl.glfw.GLFW;

public class Step extends Module {
//pretty broken ngl



    private Setting stepHeight = new Setting(this, "Step Height", 1.5, 0.5, 20);



    private double normal;

    public Step() {
        //name, key, category, isGhost
        super("Step", GLFW.GLFW_KEY_O, Category.MOVEMENT, true);
        addSetting(stepHeight);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
        mc.player.stepHeight = (float) stepHeight.getCurrentValueDouble();
    }

    @Override
    public void onEnable() {
        //Once, when enabled
        super.onEnable(); //THIS IS ESSENTIAL
        mc.player.stepHeight = (float) stepHeight.getCurrentValueDouble();
    }

    @Override
    public void onDisable() {
        //Once, when disabled
        super.onDisable(); //THIS IS ESSENTIAL
        mc.player.stepHeight = (float) 0.75;
    }


}