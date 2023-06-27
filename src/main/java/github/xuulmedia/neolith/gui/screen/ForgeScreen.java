package github.xuulmedia.neolith.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.gui.menu.ForgeMenu;
import github.xuulmedia.neolith.util.TooltipHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Nullable;

public class ForgeScreen extends AbstractNeolithScreen<ForgeMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Neolith.MODID, "textures/gui/forge_gui.png");
    private @Nullable Integer heatRequiredToCook;
    private final int imageWidth;
    private final int imageHeight;

    public ForgeScreen(ForgeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, TEXTURE);
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

        float litProgress = this.menu.fuelProportion();
        if (litProgress > 0) {
            int scaledLitProgress = (int) (litProgress * 13f);
            renderVerticallyScaledComponent(gui, x, y, 176, 0, 57, 37, 14, 14, scaledLitProgress);
        }

        /*Progress Arrow*/
        float progressArrowProportion = this.menu.progressProportion();
        int scaledProgressArrow = (int) (progressArrowProportion * 22f);
        renderHorizontallyScaledComponent(gui, x, y, 176, 14, 79, 35, 25, 17, scaledProgressArrow);

        // heat prop
        float heatBarProportion = this.menu.heatProportion();
        if (heatBarProportion > 0) {
            int scaledHeatProp = Mth.ceil(heatBarProportion * 42f);
            renderVerticallyScaledComponent(gui, x, y, 176, 31, 45, 22, 6, 42, scaledHeatProp);
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
    protected void renderTooltip(GuiGraphics gui, int mx, int my) {
        super.renderTooltip(gui, mx, my);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        TooltipHelper[] tooltipHelpers = new TooltipHelper[]{
                new TooltipHelper(x + 45, x + 50, y + 22, y + 63, () -> true, () -> Component.translatable("container.neolith.forge.heat", this.menu.heat())),
                new TooltipHelper(x + 56, x + 70, y + 36, y + 50, this.menu::isBurningFuel, () -> Component.translatable("container.neolith.forge.heat.target", this.menu.targetHeat())),
                new TooltipHelper(x + 76, x + 87, y + 19, y + 30, this::isTooColdToCook, () -> Component.translatable("container.neolith.forge.heat.too_cold", this.heatRequiredToCook)),
        };

        for (TooltipHelper tooltipHelper : tooltipHelpers) {
            if (tooltipHelper.isMouseOver(mx, my) && tooltipHelper.shouldRender()) {
                gui.renderTooltip(this.font, tooltipHelper.getText(), mx, my);
                break;
            }
        }
    }

}

