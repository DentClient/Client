package net.dent.client.module.modules.combat;

import net.dent.client.setting.Setting;
import org.lwjgl.glfw.GLFW;

import net.dent.client.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;

public class Trigger extends Module {

    /*
        Attacks anyone in your crosshair
        author: Whop42
    */
    private Setting players = new Setting(this, "Attack Players", true);
    private Setting hostile = new Setting(this, "Attack Hostiles", false);
    private Setting neutral = new Setting(this, "Attack Neutrals", false);
    private Setting passive = new Setting(this, "Attack Passives", false);

    public Trigger() {
        super("Trigger", GLFW.GLFW_KEY_I, Category.COMBAT, true);
        this.setDesc("Attacks anyone in your crosshair.");
        addSetting(players);
        addSetting(hostile);
        addSetting(neutral);
        addSetting(passive);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        ClientPlayerEntity player = mc.player;
        if(player.getAttackCooldownProgress(0) < 1)
            return;

        if(mc.crosshairTarget == null || !(mc.crosshairTarget instanceof EntityHitResult)) return;
        Entity target = ((EntityHitResult) mc.crosshairTarget).getEntity();

        mc.interactionManager.attackEntity(player, target);
        player.swingHand(Hand.MAIN_HAND);

    }
}