package net.dent.client.module.modules.other;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import org.lwjgl.glfw.GLFW;

public class GhostMode extends Module {

    public GhostMode() {
        super("Ghost Mode", GLFW.GLFW_KEY_DELETE, Category.OTHER, true);
    }

    @Override
    public void onEnable() {

    }
}
