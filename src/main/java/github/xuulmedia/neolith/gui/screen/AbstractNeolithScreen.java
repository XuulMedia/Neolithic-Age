package github.xuulmedia.neolith.gui.screen;

import github.xuulmedia.neolith.gui.menu.AbstractNeolithMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.function.Supplier;

public abstract class AbstractNeolithScreen<T extends AbstractNeolithMenu> extends AbstractContainerScreen<T> {
    private final ResourceLocation texture;

    public AbstractNeolithScreen(T menu, Inventory playerInventory, Component title, ResourceLocation texture) {
        super(menu, playerInventory, title);
        this.texture = texture;
    }

    public void blitHelper(GuiGraphics gui, int x, int y, int barLeftPos, int barTopPos, int renderLeftPos, int renderTopPos,  int barWidth, int barHeight) {
        gui.blit(this.texture, x + renderLeftPos, y + renderTopPos, barLeftPos, barTopPos, barWidth, barHeight);
    }

    public void renderVerticallyScaledComponent(GuiGraphics gui, int x, int y, int leftPos, int topPos, int renderLeftPos, int renderTopPos,  int width, int height, int scaledProgress){
        gui.blit(this.texture, x + renderLeftPos, y + renderTopPos + height - scaledProgress, leftPos, topPos + height - scaledProgress, width, scaledProgress);
    }

    public void renderHorizontallyScaledComponent(GuiGraphics gui, int x, int y, int leftPos, int topPos, int renderLeftPos, int renderTopPos,  int width, int height, int scaledProgress){
        gui.blit(this.texture, x + renderLeftPos, y + renderTopPos, leftPos, topPos, scaledProgress, height);
    }

    protected int scaleProgress(float progress, float size){
        return (int)(progress * size);
    }





}

