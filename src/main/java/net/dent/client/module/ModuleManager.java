package net.dent.client.module;

import net.dent.client.DentClient;
import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventKeyboard;
import net.dent.client.module.modules.combat.Aura;
import net.dent.client.module.modules.movement.Sprint;
import net.dent.client.module.modules.render.FullBright;
import net.dent.client.module.modules.render.GUI;
import net.dent.client.module.modules.render.HUD;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module> modules;

    public ModuleManager() {
        this.modules = new ArrayList();
        DentClient.instance.eventManager.register(this);
    }

    public void loadMods() {
        this.addModule(new Sprint());
        this.addModule(new HUD());
        this.addModule(new FullBright());
        this.addModule(new Aura());
        this.addModule(new GUI());
    }


    private void addModule(Module m) {
        modules.add(m);
    }

    @EventTarget
    public void onKey(EventKeyboard e) {
        if (e.getAction() != GLFW.GLFW_PRESS) {
            return;
        }

        Screen screen = MinecraftClient.getInstance().currentScreen;
        if (screen != null) {
            return;
        }

        for (Module mod : modules) {
            if (mod.getKeyCode() == e.getKeyCode()) {
                mod.toggle();
            }
        }
    }

    public Module getModule(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public ArrayList<Module> getModulesForCategory(Category c) {
        ArrayList<Module> modules = new ArrayList<>();

        for (Module m : this.modules) {
            if (m.getCategory().equals(c)) {
                modules.add(m);
            }
        }

        return modules;
    }
}
