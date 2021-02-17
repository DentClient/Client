package net.dent.client.module.modules.render;

import org.lwjgl.glfw.GLFW;

import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.dent.client.screen.clickgui.ClickGUI;

public class GUI extends Module {
    public GUI() {
        super("GUI", GLFW.GLFW_KEY_RIGHT_SHIFT, Category.RENDER);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        mc.openScreen(new ClickGUI());
        toggle();
    }
}
