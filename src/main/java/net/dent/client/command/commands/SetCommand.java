package net.dent.client.command.commands;

import java.util.ArrayList;

import net.dent.client.DentClient;
import net.dent.client.command.Command;
import net.dent.client.module.Module;
import net.dent.client.setting.Setting;
import net.dent.client.utils.ChatUtils;

public class SetCommand implements Command {


    @Override
    public boolean run(String[] args) {



        if (args.length == 2 || args.length == 4) {

            Module module = DentClient.instance.moduleManager.getModule(args[1]);
            ArrayList<Setting> settings = DentClient.instance.settingManager.getSettingsForModule(DentClient.instance.moduleManager.getModule(args[1]));

            if(module == null) {
                ChatUtils.message(args[1] + ": does not exist.");
                return true;
            }

            if(settings == null) {
                ChatUtils.message(args[1] + ": no setting exists.");
                return true;
            }

            if(args.length == 2) {
                ChatUtils.message("Here are the list of settings:");

                for (Setting s : settings) {
                    ChatUtils.message(s.getName() + "(" + s.getCategory() + ")");
                    if(s.isMode()) {
                        s.getModes().forEach(ChatUtils::message);
                    }
                }
            }

            if(args.length == 4) {
                for (Setting s : settings) {
                    if(s.getName().equalsIgnoreCase(args[2])) {
                        if(s.isBoolean()) {
                            s.setToggle(Boolean.parseBoolean(args[3]));
                        } else if (s.isValueInt()) {
                            s.setCurrentValueInt(Integer.parseInt(args[3]));
                        } else if(s.isValueDouble()) {
                            s.setCurrentValueDouble(Double.parseDouble(args[3]));
                        } else if(s.isValueFloat()) {
                            s.setCurrentValueFloat(Float.parseFloat(args[3]));
                        } else if(s.isMode()) {
                            s.setCurrentMode(args[3]);
                        }
                        ChatUtils.message(s.getName() + " has setting to " + args[3] + ".");
                    }
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public String[] usage() {
        return new String[]{"-set [module]","-set [module] [setting] [value]"};
    }
}
