package net.dent.client.main;
import javax.swing.*;
import net.dent.client.main.Category;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

import java.util.*;


public class Mod {
	
	public String name;
	public Keys bind;
	public boolean toggled = false;
	public Category category;
	public String desc;
	public ArrayList<Setting> settings = new ArrayList<>();
	public boolean stateLastTick = false;
	public boolean kill;
	
	/* IDK how imma do this -10:37 AM 11/17/2020
	 * Yay I know how now -10:04 AM 1/29/2021
	 * 
	 */
	
	
	
	public Mod(String nm, Keys key, Category c, String d, ArrayList<Setting> setts) {
		name = nm;
		bind = key;
		category = c;
		desc = d;

		switch(key) {
			case ONE:
				KeyBinding keyBindOne = KeyBindingHelper.registerKeyBinding(new KeyBinding(
						"key.client.one", // The translation key of the keybinding's name
						InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
						GLFW.GLFW_KEY_1, // The keycode of the key
						"category.client.keys" // The translation key of the keybinding's category.
				));
			case TWO:
				KeyBinding keyBindTwo = KeyBindingHelper.registerKeyBinding(new KeyBinding(
						"key.client.r", // The translation key of the keybinding's name
						InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
						GLFW.GLFW_KEY_2, // The keycode of the key
						"category.client.keys" // The translation key of the keybinding's category.
				));



		}

		
		
		while(kill = false) {
			if(stateLastTick != toggled && toggled) {
				System.out.println("[" + name + "] has been enabled.");
				whenEnabled();
				toggled = true;
			} else if(stateLastTick != toggled && !toggled) {
				System.out.println("[" + name + "] has been disabled.");
				whenDisabled();
				toggled = false;
			} else if(toggled){
				whenRunning();
				keyListenTest();
			}
			
		}
		
	}



	public void keyListenTest() {
		KeyBinding keyBindTest = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.client.z", // The translation key of the keybinding's name
				InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
				GLFW.GLFW_KEY_Z, // The keycode of the key
				"category.client.keys" // The translation key of the keybinding's category.
		));
		try {
			ClientTickEvents.END_CLIENT_TICK.register(client -> {

				while (keyBindTest.wasPressed()) {
					client.player.sendMessage(new LiteralText("Key 1 was pressed!"), false);
				}
			});
		} catch(Exception e) {
			System.err.println("[DENT ERROR]: " + e);
		}

	}

	public ArrayList<Setting> getSettings() {
		return settings;
	}

	public void setSettings(ArrayList<Setting> settings) {
		this.settings = settings;
	}

	public boolean isStateLastTick() {
		return stateLastTick;
	}

	public void setStateLastTick(boolean stateLastTick) {
		this.stateLastTick = stateLastTick;
	}

	public boolean isKill() {
		return kill;
	}

	public void setKill(boolean kill) {
		this.kill = kill;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void whenEnabled() {
		//once when Enabled
	}
	
	public void whenDisabled() {
		//once when Disabled
	}
	
	public void whenRunning() {
		//while it runs
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Keys getBind() {
		return bind;
	}

	public void setBind(Keys bind) {
		this.bind = bind;
	}

	public boolean toggle() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}

	public Category getCategory() {
		return category;
	}

	public void setCat(Category cat) {
		this.category = cat;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
