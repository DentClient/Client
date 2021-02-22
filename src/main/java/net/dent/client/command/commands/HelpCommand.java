package net.dent.client.command.commands;

import net.dent.client.DentClient;
import net.dent.client.command.Command;
import net.dent.client.utils.ChatUtils;

public class HelpCommand implements Command {

    @Override
    public boolean run(String[] args) {
        ChatUtils.message("Here are the list of commands:");
        for (Command c : DentClient.instance.commandManager.getCommands().values()) {
            for(String s : c.usage()) {
                ChatUtils.message("USAGE: " + s);
            }
        }
        return true;
    }

    @Override
    public String[] usage() {
        return new String[]{"-help"};
    }

}
