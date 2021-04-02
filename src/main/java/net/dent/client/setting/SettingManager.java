package net.dent.client.setting;

import java.util.ArrayList;

import net.dent.client.DentClient;
import net.dent.client.module.Module;

public class SettingManager {
    private ArrayList<Setting> settings;

    public SettingManager() {
        this.settings = new ArrayList();
    }

    public void addSetting(Setting s) {
        this.settings.add(s);
    }

    public ArrayList<Setting> getSettings() {
        return this.settings;
    }
    
    public static ArrayList<Setting> getSettingsForModule(Module m) {
        ArrayList<Setting> settings = new ArrayList<Setting>();

        for (Setting s : DentClient.instance.settingManager.getSettings()) {
            if (s.getModule().equals(m)) {
                settings.add(s);
            }
        }

        if (settings.isEmpty()) {
            return null;
        }

        return settings;
    }
}
