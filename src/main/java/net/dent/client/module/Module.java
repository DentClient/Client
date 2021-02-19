package net.dent.client.module;

import net.dent.client.DentClient;
import net.dent.client.setting.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class Module {
    private boolean toggle;
    private String name;
    private int keyCode;
    private Category category;
    private String desc;
    private boolean ghost;

    private String displayText;

    protected MinecraftClient mc = MinecraftClient.getInstance();

    public Module(String name, int keyCode, Category category, boolean ghost) {
        this.toggle = false;
        this.name = name;
        this.keyCode = keyCode;
        this.category = category;
        this.ghost = ghost;
    }

    protected void addSetting(Setting setting) {
        DentClient.instance.settingManager.addSetting(setting);
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String descrip) {
        desc = descrip;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDisplayName() {
        if (displayText == null) {
            return name;
        } else {
            return name  + " : " + displayText;
        }
    }

    protected void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public void toggle()
    {
        this.toggle = !this.toggle;
        if(this.toggle) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {
        DentClient.instance.eventManager.register(this);
    }

    public void onDisable() {
        DentClient.instance.eventManager.unregister(this);
    }
}
