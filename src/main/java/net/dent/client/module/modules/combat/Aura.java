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

public class Aura extends Module {

    Setting cps = new Setting(this, "CPS", 7, 1, 20);

    Setting mode = new Setting(this, "MODE", "MOD1", new ArrayList<>(Arrays.asList(new String[]{"MOD1","MOD2","MOD3"})));


    public Aura() {
        super("Aura", GLFW.GLFW_KEY_R, Category.COMBAT);
        addSetting(cps);
        addSetting(mode);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {

    }
}
