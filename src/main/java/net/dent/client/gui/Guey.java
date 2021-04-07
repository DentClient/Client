package net.dent.client.gui;

import com.lukflug.panelstudio.*;
import com.lukflug.panelstudio.mc16.MinecraftGUI;
import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.theme.GameSenseTheme;
import com.lukflug.panelstudio.theme.SettingsColorScheme;
import com.lukflug.panelstudio.theme.Theme;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.dent.client.module.ModuleManager;
import net.dent.client.setting.Setting;
import net.dent.client.setting.SettingManager;
import net.dent.client.utils.FontUtils;
import net.dent.client.utils.GuiUtils;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class Guey extends MinecraftGUI {

    private final Toggleable colorToggle;
    private final GUIInterface guiInterface;
    private final Theme theme;
    private final ClickGUI gui;

    public Guey() {
        // Intialize necessary fields
        colorToggle = GUISettings.colorToggle; // <-- Toggleable indicating whether to use the RGB or HSB model for color settings
        guiInterface = new GUIInterface(true) {
            @Override
            protected String getResourcePrefix() {
                return "dentclient:gui/";
            }

            @Override
            public void drawString(Point pos, String s, Color c) {
                end();
                FontUtils.drawString(new MatrixStack(), s, pos.x ,pos.y, c.getRGB());
                begin();
            }

            @Override
            public int getFontWidth(String s) {
                return FontUtils.getStringWidth(s);
            }

            @Override
            public int getFontHeight() {
                return FontUtils.getFontHeight();
            }
        };
        theme = new GameSenseTheme(new SettingsColorScheme(GUISettings.activeColor, GUISettings.inactiveColor, GUISettings.backgroundColor, GUISettings.outlineColor, GUISettings.fontColor, GUISettings.opacity), height,2,5); // <-- Can be replaced by another theme (could be a custom one)
        gui = new ClickGUI(guiInterface, null);
        // Populate the ClickGUI with modules and settings
        int x = 1;
        int y = 5;
        int width = 50;

        for (Category category: Category.values()) {
            DraggableContainer panel = new DraggableContainer(category.toString(),null, theme.getPanelRenderer(),new SimpleToggleable(false),new SettingsAnimation(GUISettings.animationSpeed),null, new Point(x, y), width); // <-- Width and default position of the panels needs to be defined
            gui.addComponent(panel);

            for (Module module: ModuleManager.getModulesForCategory(category)) {
                CollapsibleContainer container = new CollapsibleContainer(module.getName(),null,theme.getContainerRenderer(),new SimpleToggleable(false),new SettingsAnimation(GUISettings.animationSpeed), module); // <-- It is recommended that the module-class implements Toggleable
                panel.addComponent(container);
                if(SettingManager.getSettingsForModule(module) != null) {
                    for (Setting setting: SettingManager.getSettingsForModule(module)) {
                        if (setting.getCategoryEnum() == Setting.Category.BOOLEAN) container.addComponent(new BooleanComponent(setting.getName(),null,theme.getComponentRenderer(), GuiUtils.boolSettingToToggleable(setting)));
                        else if (setting.getCategoryEnum() == Setting.Category.VALUE_INT) container.addComponent(new NumberComponent(setting.getName(),null,theme.getComponentRenderer(), GuiUtils.intSettingToNumSetting(setting), setting.getMaxValueInt(),setting.getMaxValueInt()));
                        else if (setting.getCategoryEnum() == Setting.Category.VALUE_DOUBLE) container.addComponent(new NumberComponent(setting.getName(),null,theme.getComponentRenderer(), GuiUtils.doubleSettingToNumSetting(setting),setting.getMinValueDouble(),setting.getMaxValueDouble()));
                        else if (setting.getCategoryEnum() == Setting.Category.MODE) container.addComponent(new EnumComponent(setting.getName(),null, theme.getComponentRenderer(), GuiUtils.modeSettingToEnumSetting(setting)));
                        //We don't have a color setting lol (oof) //else if (setting instanceof ColorSetting) container.addComponent(new ColorComponent(setting.getName(),null,theme.getContainerRenderer(),new SettingsAnimation(GUISettings.animationSpeed),theme.getComponentRenderer(),(ColorSetting)setting, setting.alpha, setting.rainbowEnabled, colorToggle));
                    }
                }
                container.addComponent(new KeybindComponent(theme.getComponentRenderer(), GuiUtils.codeToKeybindSetting(module)));
            }

            x += width + 10;
        }
    }

    @Override
    protected ClickGUI getGUI() {
        return gui;
    }

    @Override
    protected GUIInterface getInterface() {
        return guiInterface;
    }

    @Override
    protected int getScrollSpeed() {
        return 10;
    }


}
