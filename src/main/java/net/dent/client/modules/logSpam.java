package net.dent.client.modules;



import java.util.ArrayList;

import net.dent.client.main.Category;
import net.dent.client.main.Keys;
import net.dent.client.main.Mod;
import net.dent.client.main.Setting;


public class logSpam extends Mod {
	protected String message = "Dent Client on Top";
	protected static ArrayList<Setting> setts = new ArrayList<>();
	
	public logSpam() {
		super("LogSpam", Keys.ONE, Category.UTILITY, "Little known dupe, must use for at least 10 mins then quit mc, look at most recent log. Edit the log, and go back in. Then disable, and you have been duped.", setts);
	}
	
	@Override
	public void whenRunning() {
		System.out.println("Dent Client on Top");
	}
	
	
}
