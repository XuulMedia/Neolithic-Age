package github.xuulmedia.neolith.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.gui.menu.ClayPotMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class ClayPotScreen extends AbstractNeolithScreen<ClayPotMenu> {
    public static final ResourceLocation TEXTURE =
            new ResourceLocation(Neolith.MODID, "textures/gui/clay_pot_gui.png");
    private final int imageWidth;
    private final int imageHeight;

    public ClayPotScreen(ClayPotMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, TEXTURE);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }


    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float delta){
        this.renderBackground(gui);
        super.render(gui, mouseX, mouseY, delta);
//        this.renderTooltip(gui, mouseX, mouseY);
    }
    @Override
    protected void renderBg(GuiGraphics gui, float pPartialTick, int pMouseX, int pMouseY) {

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        gui.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

    }
}
