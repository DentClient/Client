package net.dent.client.module.modules.player;

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
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import org.lwjgl.glfw.GLFW;

public class PotionSpoof extends Module {

    private Setting Potion = new Setting(this, "Potion Selector", 1, 1, 50);

    public PotionSpoof() {
        //name, key, category, isGhost
        super("Potion Spoof", GLFW.GLFW_KEY_P, Category.MOVEMENT, true);
        addSetting(Potion);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
        if (isToggle()) {
            mc.player.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(8), 10000000, 2));
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
        mc.player.removeStatusEffect(StatusEffect.byRawId(8));
    }
}