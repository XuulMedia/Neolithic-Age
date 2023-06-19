package github.xuulmedia.neolith.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.gui.menu.ForgeMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Debug;
import org.jetbrains.annotations.Nullable;

public class ForgeScreen extends AbstractContainerScreen<ForgeMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Neolith.MODID, "textures/gui/forge_gui.png");
    private @Nullable Integer heatRequiredToCook;
    private final int leftPos;
    private final int topPos ;
    private final int imageWidth;
    private final int imageHeight;

    public ForgeScreen(ForgeMenu pMenu, Inventory pPlayerInventory,
                       Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.heatRequiredToCook = this.menu.heatReqdToCookInput();
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void containerTick() {
        this.heatRequiredToCook = this.menu.heatReqdToCookInput();
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float delta) {
        this.renderBackground(gui);
        super.render(gui, mouseX, mouseY, delta);
        this.renderTooltip(gui, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics gui, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        //blit (texture, screenOriginX, screenOriginY, readTextureX, readTextureY, renderTexturePosX, renderTexturePosY
        gui.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        /*Lit fuel left amount*/
        int fireBarLeftPos = 176;
        int fireBarTopPos = 0;
        int fireBarRenderLeftPos = 56;
        int fireBarRenderTopPos = 36;

        float litProgress = this.menu.fuelProportion();
        if (litProgress > 0) {
            int scaledLitProgress = (int)(litProgress * 13f);
            gui.blit(TEXTURE, x + fireBarRenderLeftPos, y + fireBarRenderTopPos + 12 - scaledLitProgress, fireBarLeftPos, 12 - scaledLitProgress, 14, 1 + scaledLitProgress);
        }

        /*Progress Arrow*/
        int arrowBarLeftPos = 176;
        int arrowBarTopPos = 14;
        int arrowBarRenderLeftPos = 79;
        int arrowBarRenderTopPos = 34;

        float progressArrowProportion = this.menu.progressProportion();
        int scaledProgressArrow = (int)(progressArrowProportion * 22f);
        gui.blit(TEXTURE, x+ arrowBarRenderLeftPos, y + arrowBarRenderTopPos, arrowBarLeftPos, arrowBarTopPos, 1 + scaledProgressArrow, 16);


        //temp prop
        int tempPropLeftPos = 176;
        int tempPropTopPos = 31;
        int tempPropRenderLeftPos = 45;
        int tempPropRenderTopPos = 22;

        float heatBarProportion =  this.menu.heatProportion();
        if(heatBarProportion > 0){
            var scaledHeatProp = Mth.ceil(heatBarProportion * 42f);
            gui.blit(TEXTURE, x + tempPropRenderLeftPos, y + tempPropRenderTopPos + 42 - scaledHeatProp, tempPropLeftPos, tempPropTopPos + 42 - scaledHeatProp, 6 , scaledHeatProp);
        }

        //too cold X
        int tooColdPropLeftPos = 176;
        int tooColdPropTopPos = 79;
        int tooColdRenderLeftPos = 76;
        int tooColdRenderTopPos = 19;

        if (this.isTooColdToCook()) {
            gui.blit(TEXTURE, x + tooColdRenderLeftPos, y + tooColdRenderTopPos, tooColdPropLeftPos, tooColdPropTopPos, 12, 12);
        }


    }

    private boolean isTooColdToCook() {
        if (this.heatRequiredToCook == null) {
            return false;
        }
        return this.heatRequiredToCook > this.menu.heat();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    protected void renderTooltip(GuiGraphics gui, int mx, int my) {
        super.renderTooltip(gui, mx, my);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        if (mx >= x + 45 && mx <= x + 50 && my >= y + 22 && my <= y + 63) {

            gui.renderTooltip(this.font, Component.translatable("container.neolith.forge.heat", this.menu.heat()), mx, my);
        } else if (mx >= x + 56 && mx <= x + 70 && my >= y + 36 && my <= y + 50 && this.menu.isBurningFuel()) {
            gui.renderTooltip(this.font, Component.translatable("container.neolith.forge.heat.target", this.menu.targetHeat()),  mx, my);
        } else if (mx >= x + 76 && mx <= x + 87 && my >= y + 19 && my <= y + 30 && this.isTooColdToCook()) {
            gui.renderTooltip(this.font, Component.translatable("container.neolith.forge.heat.too_cold", this.heatRequiredToCook), mx, my);
        } else if (this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
            gui.renderTooltip(this.font, this.hoveredSlot.getItem(), mx, my);
        } else if (!this.menu.getCarried().isEmpty()
                && this.hoveredSlot != null && this.hoveredSlot.index == ForgeBE.SLOT_FUEL) {
            var fuelTemp = this.menu.maxHeatOf(this.menu.getCarried());
            if (fuelTemp != null) {
                gui.renderTooltip(this.font,Component.translatable("container.neolith.forge.heat.target", fuelTemp), mx, my);
            }
        }
    }




}

