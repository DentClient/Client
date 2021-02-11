package net.dent.client.settings;

import net.dent.client.main.Setting;
import net.dent.client.main.SettingType;

public class logSpam_message extends Setting {
	
	public logSpam_message() {
		super("Message", "Sets message for the dupe.", SettingType.TEXTFIELD, "Dent Client on Top!", true);
	}
}
