package net.dent.client.module.modules.movement;


        import net.dent.client.event.EventTarget;
        import net.dent.client.event.events.EventUpdate;
        import net.dent.client.module.Category;
        import net.dent.client.module.Module;
        import org.lwjgl.glfw.GLFW;
        import org.lwjgl.system.CallbackI;

public class AirJump extends Module {



        public AirJump() {
        //name, key, category, isGhost
        super("Air Jump", GLFW.GLFW_KEY_R, Category.MOVEMENT, true);

        }

        @EventTarget
        public void onUpdate(EventUpdate e) {
        //Every Tick
                mc.player.jump();

        }

        @Override
        public void onEnable() {
        //Once, when enabled
        super.onEnable(); //THIS IS ESSENTIAL

        }

        @Override
        public void onDisable() {
        //Once, when disabled
        super.onDisable(); //THIS IS ESSENTIAL

        }
        }