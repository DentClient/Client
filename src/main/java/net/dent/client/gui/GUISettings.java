package net.dent.client.gui;

import com.ibm.icu.impl.coll.CollationRoot;
import com.lukflug.panelstudio.settings.ColorSetting;
import com.lukflug.panelstudio.settings.NumberSetting;
import com.lukflug.panelstudio.settings.Toggleable;

import java.awt.*;

public class GUISettings {

    static Toggleable colorToggle = new Toggleable() {

        boolean value = true;

        @Override
        public void toggle() {
            value = !value;
        }

        @Override
        public boolean isOn() {
            return value;
        }
    };

    static ColorSetting activeColor = new ColorSetting() {

        Color color = new Color(213, 108, 0);

        boolean isRainbow = false;

        @Override
        public Color getValue() {
            return color;
        }

        @Override
        public void setValue(Color value) {
            color = value;
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public boolean getRainbow() {
            return isRainbow;
        }

        @Override
        public void setRainbow(boolean rainbow) {
            isRainbow = rainbow;
        }
    };



    static ColorSetting inactiveColor = new ColorSetting() {

        Color color = new Color(187, 110, 32);

        boolean isRainbow = false;

        @Override
        public Color getValue() {
            return color;
        }

        @Override
        public void setValue(Color value) {
            color = value;
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public boolean getRainbow() {
            return isRainbow;
        }

        @Override
        public void setRainbow(boolean rainbow) {
            isRainbow = rainbow;
        }
    };

    static ColorSetting backgroundColor = new ColorSetting() {

        Color color = new Color(43, 43, 43);

        boolean isRainbow = false;

        @Override
        public Color getValue() {
            return color;
        }

        @Override
        public void setValue(Color value) {
            color = value;
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public boolean getRainbow() {
            return isRainbow;
        }

        @Override
        public void setRainbow(boolean rainbow) {
            isRainbow = rainbow;
        }
    };

    static ColorSetting outlineColor = new ColorSetting() {

        Color color = new Color(255, 152, 0);

        boolean isRainbow = false;

        @Override
        public Color getValue() {
            return color;
        }

        @Override
        public void setValue(Color value) {
            color = value;
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public boolean getRainbow() {
            return isRainbow;
        }

        @Override
        public void setRainbow(boolean rainbow) {
            isRainbow = rainbow;
        }
    };

    static ColorSetting fontColor = new ColorSetting() {

        Color color = new Color(222, 222, 222);

        boolean isRainbow = false;

        @Override
        public Color getValue() {
            return color;
        }

        @Override
        public void setValue(Color value) {
            color = value;
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public boolean getRainbow() {
            return isRainbow;
        }

        @Override
        public void setRainbow(boolean rainbow) {
            isRainbow = rainbow;
        }
    };

    static NumberSetting opacity = new NumberSetting() {

        double num = 95;
        double min = 0;
        double max = 100;

        @Override
        public double getNumber() {
            return num;
        }

        @Override
        public void setNumber(double value) {
            num = value;
        }

        @Override
        public double getMaximumValue() {
            return max;
        }

        @Override
        public double getMinimumValue() {
            return min;
        }

        @Override
        public int getPrecision() {
            return 5;
        }
    };

    static NumberSetting animationSpeed = new NumberSetting() {

        double num = 1;
        double min = 0;
        double max = 10;

        @Override
        public double getNumber() {
            return num;
        }

        @Override
        public void setNumber(double value) {
            num = value;
        }

        @Override
        public double getMaximumValue() {
            return max;
        }

        @Override
        public double getMinimumValue() {
            return min;
        }

        @Override
        public int getPrecision() {
            return 1;
        }
    };


}
