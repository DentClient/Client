package net.dent.client.command.commands;

import net.dent.client.DentClient;
import net.dent.client.command.Command;
import net.dent.client.module.Module;
import net.dent.client.utils.ChatUtils;

public class ToggleCommand implements Command {

    @Override
    public boolean run(String[] args) {

        if (args.length == 2) {

            Module module = DentClient.instance.moduleManager.getModule(args[1]);

            if (module == null) {
                ChatUtils.message("The module with the name " + args[1] + " does not exist.");
                return true;
            }

            module.toggle();

            return true;
        }


        return false;
    }

    @Override
    public String[] usage() {
        return new String[]{"-toggle [module]"};
    }
}
