package net.dent.client;

import net.dent.client.command.CommandManager;
import net.dent.client.config.ConfigManager;
import net.dent.client.event.EventManager;
import net.dent.client.module.ModuleManager;
import net.dent.client.setting.SettingManager;



public enum DentClient {

    instance;

    public static String name = "Dent Client";
    public static String author = "Whop42";
    public static String version = "0.42";
    public static String game = "1.16.5";

    

    public EventManager eventManager;
    public ModuleManager moduleManager;
    public SettingManager settingManager;
    public CommandManager commandManager;
    public ConfigManager configManager;

    public void run() {
        eventManager = new EventManager();
        moduleManager = new ModuleManager();
        settingManager = new SettingManager();
        commandManager = new CommandManager();
        configManager = new ConfigManager();
        moduleManager.loadMods();
        commandManager.loadCommands();
        configManager.loadConfig();
    }

    public void stop() {
        configManager.saveConfig();
    }

    public static String getVersion() {
        return version;
    }

}
