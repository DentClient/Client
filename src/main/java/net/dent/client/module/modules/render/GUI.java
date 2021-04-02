package net.dent.client.module.modules.render;

import com.lukflug.panelstudio.ClickGUI;
import net.dent.client.DentClient;
import net.dent.client.gui.Guey;
import org.lwjgl.glfw.GLFW;

import net.dent.client.module.Category;
import net.dent.client.module.Module;


public class GUI extends Module {
    public GUI() {
        super("GUI", GLFW.GLFW_KEY_RIGHT_SHIFT, Category.RENDER, true);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        DentClient.instance.gui.enterGUI();

        toggle();
    }
}
