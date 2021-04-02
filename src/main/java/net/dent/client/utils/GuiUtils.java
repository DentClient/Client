package net.dent.client.utils;

import com.lukflug.panelstudio.settings.EnumSetting;
import com.lukflug.panelstudio.settings.KeybindSetting;
import com.lukflug.panelstudio.settings.NumberSetting;
import com.lukflug.panelstudio.settings.Toggleable;
import net.dent.client.setting.Setting;
import net.dent.client.module.Module;
import org.lwjgl.glfw.GLFW;

public class GuiUtils {


    public static Toggleable boolSettingToToggleable(Setting s) {
        if(s.getCategoryEnum() != Setting.Category.BOOLEAN) {
            return null;
        }
        //convert setting to new Toggleable
        return new Toggleable() {
            @Override
            public void toggle() {
                s.setToggle(!s.isToggle());
            }

            @Override
            public boolean isOn() {
                return s.isToggle();
            }
        };
    }

    public static NumberSetting intSettingToNumSetting(Setting s) {
        if(s.getCategoryEnum() != Setting.Category.VALUE_INT) {
            return null;
        }
        return new NumberSetting() {
            @Override
            public double getNumber() {
                return ((double) s.getCurrentValueInt());
            }

            @Override
            public void setNumber(double value) {
                s.setCurrentValueInt(((int) value));
            }

            @Override
            public double getMaximumValue() {
                return ((double) s.getMaxValueInt());
            }

            @Override
            public double getMinimumValue() {
                return ((double) s.getMinValueInt());
            }

            @Override
            public int getPrecision() {
                return 0;
            }
        };
    }

    public static NumberSetting doubleSettingToNumSetting(Setting s) {
        if(s.getCategoryEnum() != Setting.Category.VALUE_DOUBLE) {
            return null;
        }
        return new NumberSetting() {
            @Override
            public double getNumber() {
                return s.getCurrentValueDouble();
            }

            @Override
            public void setNumber(double value) {
                s.setCurrentValueDouble(value);
            }

            @Override
            public double getMaximumValue() {
                return s.getMaxValueDouble();
            }

            @Override
            public double getMinimumValue() {
                return s.getMinValueDouble();
            }

            @Override
            public int getPrecision() {
                return 2;
            }
        };
    }

    public static EnumSetting modeSettingToEnumSetting(Setting s) {
        if(s.getCategoryEnum() != Setting.Category.MODE) {
            return null;
        }

        return new EnumSetting() {
            @Override
            public void increment() {

            }

            @Override
            public String getValueName() {
                return s.getModes().get(s.getCurrentModeIndex());
            }
        };
    }

    public static KeybindSetting codeToKeybindSetting(Module m) {
        return new KeybindSetting() {
            @Override
            public int getKey() {
                return m.getKeyCode();
            }

            @Override
            public void setKey(int key) {
                m.setKeyCode(key);
            }

            @Override
            public String getKeyName() {
                String keyName = GLFW.glfwGetKeyName(m.getKeyCode(), GLFW.glfwGetKeyScancode(m.getKeyCode()));
                return keyName;
            }
        };
    }
}
