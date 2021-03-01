package net.dent.client.screen.clickgui;

import net.dent.client.DentClient;
import net.dent.client.module.Module;
import net.dent.client.screen.clickgui.setting.BooleanSettingElement;
import net.dent.client.screen.clickgui.setting.SettingElement;
import net.dent.client.screen.clickgui.setting.ValueSettingElement;
import net.dent.client.setting.Setting;
import net.dent.client.utils.ColorUtils;
import net.dent.client.utils.FontUtils;
import net.dent.client.utils.Render2D;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.ArrayList;
//FoxClickGUI by enaium (go follow him)
public class ModulePanel {

    private Module module;
    private boolean hovered;

    private boolean displaySettingElement;

    private ArrayList<SettingElement> settingElements;

    public ModulePanel(Module module) {
        this.module = module;
        this.settingElements = new ArrayList<>();
        ArrayList<Setting> settings = DentClient.instance.settingManager.getSettingsForModule(this.module);
        if (settings != null) {
            for (Setting setting : settings) {
                if (setting.isBoolean()) {
                    this.settingElements.add(new BooleanSettingElement(setting));
                } else if (setting.isValue() || setting.isMode()) {
                    this.settingElements.add(new ValueSettingElement(setting));
                }
            }
        }
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, double x, double y, double width, double height) {
        this.hovered = Render2D.isHovered(mouseX, mouseY, x, y, width, height);
        int color = ColorUtils.BG;
        if (this.module.isToggle()) {
            color = ColorUtils.TOGGLE;
        }
        if (this.hovered) {
            color = ColorUtils.SELECT;
        }
        //Draws bkg rect
        Render2D.drawRectWH(matrices, x, y, width, height, color);
        //Draws name on rect
        FontUtils.drawHVCenteredString(matrices, this.module.getName(), x + width / 2, y + height / 2, Color.WHITE.getRGB());
        if (this.displaySettingElement) {
            double SettingElementY = y;
            for (SettingElement settingElement : settingElements) {
                settingElement.render(matrices, mouseX, mouseY, delta, x + width, SettingElementY, getWidestSetting(), height);
                SettingElementY += height;
            }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (this.hovered) {
            if (button == 0) {
                this.module.toggle();
            } else if (button == 1) {
                this.displaySettingElement = !displaySettingElement;
            }
        }

        for (SettingElement settingElement : settingElements) {
            settingElement.mouseClicked(mouseX, mouseY, button);
        }
    }

    private int getWidestSetting() {
        int width = 0;
        for (Setting m : DentClient.instance.settingManager.getSettings()) {
            String name = m.getName();
            if (m.isValueInt()) {
                name = name + ":" + m.getCurrentValueInt();
            } else if (m.isValueDouble()) {
                name = name + ":" + m.getCurrentValueDouble();
            } else if (m.isValueFloat()) {
                name = name + ":" + m.getCurrentValueFloat();
            } else if (m.isMode()) {
                name = name + ":" + m.getCurrentMode();
            }
            int cWidth = FontUtils.getStringWidth(
                    name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase());
            if (cWidth > width) {
                width = cWidth;
            }
        }
        return width;
    }
}
