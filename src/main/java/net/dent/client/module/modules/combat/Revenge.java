package net.dent.client.module.modules.combat;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.dent.client.setting.Setting;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class Revenge extends Module {

    /*
        Attacks when someone attacks you
        author: Whop42
    */


    public Revenge() {
        super("Revenge", GLFW.GLFW_KEY_UNKNOWN, Category.COMBAT, false);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        if(mc.player.getAttacker() != null) {
            mc.player.attack(mc.player.getAttacker());
            mc.player.attack(mc.player.getAttacker());
        }
    }

}
