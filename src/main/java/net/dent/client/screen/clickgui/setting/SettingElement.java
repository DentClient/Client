package net.dent.client.screen.clickgui.setting;

import net.dent.client.DentClient;
import net.dent.client.module.Module;
import net.dent.client.setting.Setting;
import net.dent.client.utils.ColorUtils;
import net.dent.client.utils.FontUtils;
import net.dent.client.utils.Render2D;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class SettingElement {

    protected Setting setting;

    public SettingElement(Setting setting) {
        this.setting = setting;
    }


    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, double x, double y, double width, double height) {
        Render2D.drawRectWH(matrices, x, y, width + height, height, ColorUtils.BG);
        String name = this.setting.getName();
        if (this.setting.isValueInt()) {
            name = name + ":" + this.setting.getCurrentValueInt();
        } else if (this.setting.isValueDouble()) {
            name = name + ":" + this.setting.getCurrentValueDouble();
        } else if (this.setting.isValueFloat()) {
            name = name + ":" + this.setting.getCurrentValueFloat();
        } else if (this.setting.isMode()) {
            name = name + ":" + this.setting.getCurrentMode();
        }
        FontUtils.drawHVCenteredString(matrices, name, x + width / 2, y + height / 2, Color.WHITE.getRGB());
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

    }
}
