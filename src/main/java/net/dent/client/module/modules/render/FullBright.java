package net.dent.client.module.modules.render;

import org.lwjgl.glfw.GLFW;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;

public class FullBright extends Module {

    public FullBright() {
        super("FullBright", GLFW.GLFW_KEY_G, Category.RENDER);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        mc.options.gamma = 300;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.options.gamma = 1;
    }


}
