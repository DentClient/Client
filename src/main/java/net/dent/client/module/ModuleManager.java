package net.dent.client.module;

import net.dent.client.DentClient;
import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventKeyboard;
import net.dent.client.module.modules.combat.Revenge;
import net.dent.client.module.modules.combat.Trigger;
import net.dent.client.module.modules.movement.*;
import net.dent.client.module.modules.other.GhostMode;
import net.dent.client.module.modules.player.NoFall;
import net.dent.client.module.modules.player.PotionSpoof;
import net.dent.client.module.modules.render.*;
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
        //this.addModule(new Revenge()); //Doesn't function
        this.addModule(new GUI());
        this.addModule(new Zoom());
        this.addModule(new Trigger());
        this.addModule(new Flight());
        this.addModule(new Step());
        this.addModule(new AirJump());
        this.addModule(new PotionSpoof());
        this.addModule(new NoFall());
        this.addModule(new GhostMode());
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
