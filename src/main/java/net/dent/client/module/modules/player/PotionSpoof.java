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

    //We're going to need a mode for multiple potions at some point -Whop

    private Setting Potion = new Setting(this, "Potion Selector", 3, 1, 32);
    private Setting amplifier = new Setting(this, "Amplifier", 1, 1, 255);
    private Setting duration = new Setting(this, "Duration (Seconds)", 60, 1, 9999);

    private int potion;

    public PotionSpoof() {
        //name, key, category, isGhost
        super("Potion Spoof", -1, Category.MOVEMENT, false);
        addSetting(Potion);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        //Every Tick
        potion = Potion.getCurrentValueInt();
        if (!mc.player.hasStatusEffect(StatusEffect.byRawId(potion))) {
            potion = Potion.getCurrentValueInt();
            mc.player.removeStatusEffect(StatusEffect.byRawId(potion));
        }
    }
    @Override
    public void onEnable() {
        //Once, when enabled
        super.onEnable(); //THIS IS ESSENTIAL
        mc.player.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(potion), duration.getCurrentValueInt(), amplifier.getCurrentValueInt()));
    }
    @Override
    public void onDisable() {
        //Once, when disabled
        super.onDisable(); //THIS IS ESSENTIAL
        mc.player.removeStatusEffect(StatusEffect.byRawId(potion));
    }
}