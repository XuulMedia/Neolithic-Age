package github.xuulmedia.neolith.gui.screen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.gui.menu.ManualGrinderMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class ManualGrinderScreen extends AbstractContainerScreen<ManualGrinderMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Neolith.MODID,"textures/gui/manual_grinder.png");

    public ManualGrinderScreen(ManualGrinderMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick , int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(guiGraphics, x, y);
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
