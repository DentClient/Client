package net.dent.client.module.modules.render;
import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;



import javax.swing.*;

public class ExternalGUI extends Module {
    public ExternalGUI() {
        super("External GUI", -1, Category.RENDER, true);
        this.setDesc("Creates the external GUI.");
    }


    @EventTarget
    public void onUpdate(EventUpdate e) {

    }

    @Override
    public void onEnable() {
        super.onEnable();

    }

}
