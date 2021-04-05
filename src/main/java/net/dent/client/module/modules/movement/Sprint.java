package net.dent.client.module.modules.movement;

import net.dent.client.setting.Setting;
import org.lwjgl.glfw.GLFW;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;

public class Sprint extends Module {

    private Setting noParticle = new Setting(this, "No Particles", true);

    public Sprint() {
        super("Sprint", GLFW.GLFW_KEY_SEMICOLON, Category.MOVEMENT, true);
        addSetting(noParticle);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        if (mc.player.forwardSpeed > 0 && !noParticle.isToggle()) {
            mc.player.setSprinting(true);
        } else if (noParticle.isToggle()) {
            mc.player.setSprinting(true);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.player.setSprinting(false);
    }
}
