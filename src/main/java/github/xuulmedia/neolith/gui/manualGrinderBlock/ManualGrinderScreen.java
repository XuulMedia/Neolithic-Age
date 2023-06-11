package github.xuulmedia.neolith.gui.manualGrinderBlock;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ManualGrinderScreen extends AbstractContainerScreen<ManualGrinderMenu> {
    public ManualGrinderScreen(ManualGrinderMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics gui, float partialTick, int mouseX, int mouseY) {

    }

    private void renderProgressArrow(GuiGraphics gui, int x, int y) {
        if(menu.isCrafting()) {
            gui.fillGradient(x + 105, y + 33, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float delta) {
        renderBackground(gui);
        super.render(gui, mouseX, mouseY, delta);
        super.renderTooltip(gui, mouseX, mouseY);
    }
}
