package net.dent.client.gui;

import com.lukflug.panelstudio.*;
import com.lukflug.panelstudio.mc16.MinecraftGUI;
import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.theme.GameSenseTheme;
import com.lukflug.panelstudio.theme.SettingsColorScheme;
import com.lukflug.panelstudio.theme.Theme;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.dent.client.utils.FontUtils;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class Guey extends MinecraftGUI {

    private final Toggleable colorToggle;
    private final GUIInterface guiInterface;
    private final Theme theme;
    private final ClickGUI gui;

    public Guey() {
        // Intialize necessary fields
        colorToggle = new Toggleable() {
            @Override
            public void toggle() {

            }

            @Override
            public boolean isOn() {
                return false;
            }
        }; // <-- Toggleable indicating whether to use the RGB or HSB model for color settings
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
        for (Category category: Category.values() {
            DraggableContainer panel = new DraggableContainer(category.name,null,theme.getPanelRenderer(),new SimpleToggleable(false),new SettingsAnimation(GUISettings.animationSpeed),null, new Point(x, y), width); // <-- Width and default position of the panels needs to be defined
            gui.addComponent(panel);
            for (Module module: category) {
                CollapsibleContainer container=new CollapsibleContainer(module.name,null,theme.getContainerRenderer(),new SimpleToggleable(false),new SettingsAnimation(GUISettings.animationSpeed),module); // <-- It is recommended that the module-class implements Toggleable
                panel.addComponent(container);
                for (CoolSetting setting: module) {
                    if (setting instanceof Toggleable) container.addComponent(new BooleanComponent(setting.name,null,theme.getComponentRenderer(),(Toggleable)setting));
                    else if (setting instanceof NumberSetting) container.addComponent(new NumberComponent(setting.name,null,theme.getComponentRenderer(),(NumberSetting)setting,setting.min,setting.max));
                    else if (setting instanceof EnumSetting) container.addComponent(new EnumComponent(setting.name,null,theme.getComponentRenderer(),(EnumSetting)setting));
                    else if (setting instanceof ColorSetting) container.addComponent(new ColorComponent(setting.name,null,theme.getContainerRenderer(),new SettingsAnimation(GUISettings.animationSpeed),theme.getComponentRenderer(),(ColorSetting)setting,setting.alpha,setting.rainbowEnabled,colorToggle));
                }
                container.addComponent(new KeybindComponent(theme.getComponentRenderer(),module.getKeybind()));
            }
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
        return GUISettings.scrollSpeed.getValue();
    }
}
