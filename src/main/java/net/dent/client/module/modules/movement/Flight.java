package net.dent.client.module.modules.movement;


import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.dent.client.setting.Setting;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.CallbackI;

public class Flight extends Module {

    private Setting Speed = new Setting(this, "Speed", false);

    public Flight() {
        //name, key, category, isGhost
        super("Flight", GLFW.GLFW_KEY_0, Category.MOVEMENT, true);
        addSetting(Speed);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
        mc.player.abilities.setFlySpeed(1);
        mc.player.abilities.flying = true;



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
    }
}