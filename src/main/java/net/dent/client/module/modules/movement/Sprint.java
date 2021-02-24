package net.dent.client.module.modules.movement;

import net.dent.client.setting.Setting;
import org.lwjgl.glfw.GLFW;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;

public class Sprint extends Module {
    public Setting noParticle = new Setting(this, "No Particles", false);

    public Sprint() {
        super("Sprint", GLFW.GLFW_KEY_SEMICOLON, Category.MOVEMENT, true);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        if(mc.player.isSneaking() != true) {
            if(noParticle.isToggle()) {
                try {
                    if (mc.player.getMovementSpeed() != 0) {
                        mc.player.setSprinting(true);
                    }
                } catch(Exception ex) {
                    System.err.println(ex.getStackTrace());
                    noParticle.setToggle(false);
                }
            } else {
                mc.player.setSprinting(true);
            }

        }
    }
}
