package net.dent.client.main;
import java.util.*;


public class Setting {
	
	protected String name;
	protected SettingType type;
	protected int max;
	protected int min;
	protected boolean ghost = false;
	protected String desc;
	protected boolean state;
	protected String text;
	protected int value;
	
	//toggle
	public Setting(String nm, String description, SettingType t, boolean isGhost) {
		name = nm;
		type = t;
		state = false;
		desc = description;
		switch(type) {
			case TOGGLE:
				this.desc = desc + " | Type: TOGGLE";
				this.max = 1;
				this.min = 0;
				break;
			case TEXTFIELD:
				this.desc = desc + " | Type: TEXT FIELD";
				break;
			case NUMFIELD:
				this.desc = desc + " | Type: NUMBER FIELD";
				break;
		}
		
	}
	//num input
	public Setting(String nm, String description, SettingType t, int maximum, int minimum, int val, boolean isGhost) {
		name = nm;
		type = t;
		value = val;
		desc = description;
		
		switch(type) {
			case TOGGLE:
				this.desc = desc + " | Type: TOGGLE";
				this.max = 1;
				this.min = 0;
				break;
			case TEXTFIELD:
				this.desc = desc + " | Type: TEXT FIELD";
				
				break;
			case NUMFIELD:
				this.desc = desc + " | Type: NUMBER FIELD";
				this.min = minimum;
				this.max = maximum;
				break;
		case SLIDER:
			break;
		default:
			break;
		}
		
	}
	
	//text input
	public Setting(String nm, String description, SettingType t, String textInput, boolean isGhost) {
		name = nm;
		type = t;
		desc = description;
		
		switch(type) {
			case TOGGLE:
				this.desc = desc + " | Type: TOGGLE";
				this.max = 1;
				this.min = 0;
				break;
			case TEXTFIELD:
				this.desc = desc + " | Type: TEXT FIELD";
				this.text = textInput;
				break;
			case NUMFIELD:
				this.desc = desc + " | Type: NUMBER FIELD";
				break;
		}
		
	}


	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getMax() {
		return max;
	}





	public void setMax(int max) {
		this.max = max;
	}





	public int getMin() {
		return min;
	}





	public void setMin(int min) {
		this.min = min;
	}





	public boolean isGhost() {
		return ghost;
	}





	public void setGhost(boolean ghost) {
		this.ghost = ghost;
	}





	public String getDesc() {
		return desc;
	}





	public void setDesc(String desc) {
		this.desc = desc;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public SettingType getType() {
		return type;
	}


	public void setType(SettingType type) {
		this.type = type;
	}
	
	
}
