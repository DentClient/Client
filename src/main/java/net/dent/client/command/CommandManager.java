package net.dent.client.command;

import java.util.HashMap;
import java.util.Map;

import net.dent.client.command.commands.*;
import net.dent.client.utils.ChatUtils;

public class CommandManager {

    private HashMap<String[], Command> commands;

    private String prefix;

    public CommandManager() {
        commands = new HashMap<String[], Command>();
        prefix = "-";
    }

    public void loadCommands() {
        commands.put(new String[]{"help", "h"}, new HelpCommand());
        commands.put(new String[]{"toggle", "t"}, new ToggleCommand());
        commands.put(new String[]{"set","s"},new SetCommand());
        commands.put(new String[]{"bind"}, new BindCommand());
    }

    public boolean processCommand(String rawMessage) {

        if (!rawMessage.startsWith(prefix)) {
            return false;
        }

        boolean safe = rawMessage.split(prefix).length > 1;

        if (safe) {

            String beheaded = rawMessage.split(prefix)[1];

            String[] args = beheaded.split(" ");

            Command command = getCommand(args[0]);

            if (command != null) {

                if (!command.run(args)) {
                    for(String s : command.usage()) {
                        ChatUtils.message("USAGE:" + s);
                    }
                }
            }

            else {
                ChatUtils.message("Try -help.");
            }
        }

        else {
            ChatUtils.message("Try -help.");
        }

        return true;
    }

    private Command getCommand(String name) {
        for (Map.Entry entry : commands.entrySet()) {
            String[] key = (String[]) entry.getKey();
            for (String s : key) {
                if (s.equalsIgnoreCase(name)) {
                    return (Command) entry.getValue();
                }
            }
        }
        return null;
    }

    public HashMap<String[], Command> getCommands() {
        return commands;
    }

}
