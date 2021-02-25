package net.dent.client.screen.clickgui;

import net.dent.client.DentClient;
import net.dent.client.module.Category;
import net.dent.client.utils.FontUtils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

import java.util.ArrayList;


//FoxClickGUI by enaium (go follow him)
public class ClickGUI extends Screen {

    ArrayList<CategoryPanel> categoryPanels;

    public ClickGUI() {
        super(new LiteralText(""));
        categoryPanels = new ArrayList<>();
        double categoryX = 5;
        for (Category category : Category.values()) {
            categoryPanels.add(new CategoryPanel(category, categoryX, 5, getWidestCategory() + 50,
                    FontUtils.getFontHeight() + 10));
            categoryX += FontUtils.getFontHeight() + 10 + 5;
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        for (CategoryPanel categoryPanel : categoryPanels) {
            categoryPanel.render(matrices, mouseX, mouseY, delta);
        }
        FontUtils.drawString(matrices, DentClient.name + " v" + DentClient.getVersion(), 5, this.height - FontUtils.getFontHeight(), 0xFFFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (CategoryPanel categoryPanel : categoryPanels) {
            categoryPanel.mouseClicked(mouseX, mouseY, button);
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (CategoryPanel categoryPanel : categoryPanels) {
            categoryPanel.mouseReleased(mouseX, mouseY, button);
        }
        return false;
    }

    private int getWidestCategory() {
        int width = 0;
        for (Category c : Category.values()) {
            String name = c.name();
            int cWidth = FontUtils.getStringWidth(
                    name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase());
            if (cWidth > width) {
                width = cWidth;
            }
        }
        return width;
    }
}
