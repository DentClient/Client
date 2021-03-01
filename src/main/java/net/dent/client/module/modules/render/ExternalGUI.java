package net.dent.client.module.modules.render;
import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import org.lwjgl.glfw.GLFW;

public class ExternalGUI extends Module {
    public ExternalGUI() {
        super("External GUI", -1, Category.RENDER, true);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onEnable() {
        super.onEnable();
        GLFW.glfwCreateWindow(500, 500, "Dent Client", 1, 1);
    }
    @Override
    public void onDisable() {
        super.onDisable();
        GLFW.glfwDestroyWindow(1);
    }


}
