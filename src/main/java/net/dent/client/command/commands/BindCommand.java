package net.dent.client.command.commands;

import net.dent.client.DentClient;
import net.dent.client.command.Command;
import net.dent.client.module.Module;
import net.dent.client.utils.ChatUtils;
import org.lwjgl.glfw.GLFW;

public class BindCommand implements Command {

    @Override
    public boolean run(String[] args) {

        if (args.length == 3) {

            Module module = DentClient.instance.moduleManager.getModule(args[1]);

            if (module == null) {
                ChatUtils.message("The module " + args[1] + " does not exist.");
                return true;
            }

            if(args[3] == null && module != null) {
                ChatUtils.message(args[3] + " has been unbound. Previous bind: " + module.getKeyCode());
            }

            switch(args[3]) {
                case "q":
                    module.setKeyCode(GLFW.GLFW_KEY_Q);
                    break;
                case "z":
                    module.setKeyCode(GLFW.GLFW_KEY_Z);
                    break;
                case "r":
                    module.setKeyCode(GLFW.GLFW_KEY_R);
                    break;
                case "f":
                    module.setKeyCode(GLFW.GLFW_KEY_F);
                    break;
                case "c":
                    module.setKeyCode(GLFW.GLFW_KEY_C);
                    break;
                case "x":
                    module.setKeyCode(GLFW.GLFW_KEY_X);
                    break;
                case "g":
                    module.setKeyCode(GLFW.GLFW_KEY_G);
                    break;
                case "t":
                    module.setKeyCode(GLFW.GLFW_KEY_T);
                    break;
                case "b":
                    module.setKeyCode(GLFW.GLFW_KEY_B);
                    break;
                case "y":
                    module.setKeyCode(GLFW.GLFW_KEY_Y);
                    break;
                case "h":
                    module.setKeyCode(GLFW.GLFW_KEY_H);
                    break;
                case "n":
                    module.setKeyCode(GLFW.GLFW_KEY_N);
                    break;
                case "u":
                    module.setKeyCode(GLFW.GLFW_KEY_U);
                    break;
                case "j":
                    module.setKeyCode(GLFW.GLFW_KEY_J);
                    break;
                case "m":
                    module.setKeyCode(GLFW.GLFW_KEY_M);
                    break;
                case "i":
                    module.setKeyCode(GLFW.GLFW_KEY_I);
                    break;
                case "k":
                    module.setKeyCode(GLFW.GLFW_KEY_K);
                    break;
                case ",":
                    module.setKeyCode(GLFW.GLFW_KEY_COMMA);
                    break;
                case "o":
                    module.setKeyCode(GLFW.GLFW_KEY_O);
                    break;
                case "l":
                    module.setKeyCode(GLFW.GLFW_KEY_L);
                    break;
                case ".":
                    module.setKeyCode(GLFW.GLFW_KEY_PERIOD);
                    break;
                case "p":
                    module.setKeyCode(GLFW.GLFW_KEY_P);
                    break;
                case ";":
                    module.setKeyCode(GLFW.GLFW_KEY_SEMICOLON);
                    break;
                case "/":
                    module.setKeyCode(GLFW.GLFW_KEY_SLASH);
                    break;
                case "[":
                    module.setKeyCode(GLFW.GLFW_KEY_LEFT_BRACKET);
                    break;
                case "]":
                    module.setKeyCode(GLFW.GLFW_KEY_RIGHT_BRACKET);
                    break;
                case "1":
                    module.setKeyCode(GLFW.GLFW_KEY_1);
                    break;
                case "2":
                    module.setKeyCode(GLFW.GLFW_KEY_2);
                    break;
                case "3":
                    module.setKeyCode(GLFW.GLFW_KEY_3);
                    break;
                case "4":
                    module.setKeyCode(GLFW.GLFW_KEY_4);
                    break;
                case "5":
                    module.setKeyCode(GLFW.GLFW_KEY_5);
                    break;
                case "6":
                    module.setKeyCode(GLFW.GLFW_KEY_6);
                    break;
                case "7":
                    module.setKeyCode(GLFW.GLFW_KEY_7);
                    break;
                case "8":
                    module.setKeyCode(GLFW.GLFW_KEY_8);
                    break;
                case "9":
                    module.setKeyCode(GLFW.GLFW_KEY_9);
                    break;
                case "0":
                    module.setKeyCode(GLFW.GLFW_KEY_0);
                    break;
                case "-":
                    module.setKeyCode(GLFW.GLFW_KEY_MINUS);
                    break;
                case "=":
                    module.setKeyCode(GLFW.GLFW_KEY_EQUAL);
                    break;
                case "rshift":
                    module.setKeyCode(GLFW.GLFW_KEY_RIGHT_SHIFT);
                    break;
                case "lshift":
                    module.setKeyCode(GLFW.GLFW_KEY_LEFT_SHIFT);
                    break;
                case "down":
                    module.setKeyCode(GLFW.GLFW_KEY_DOWN);
                    break;
                case "left":
                    module.setKeyCode(GLFW.GLFW_KEY_LEFT);
                    break;
                case "up":
                    module.setKeyCode(GLFW.GLFW_KEY_UP);
                    break;
                case "right":
                    module.setKeyCode(GLFW.GLFW_KEY_RIGHT);
                    break;
                case "`":
                    module.setKeyCode(GLFW.GLFW_KEY_GRAVE_ACCENT);
                    break;
                default:
                    break;
            }

            return true;
        }


        return false;
    }

    @Override
    public String[] usage() {
        return new String[]{"-bind [module] [key]"};
    }
}