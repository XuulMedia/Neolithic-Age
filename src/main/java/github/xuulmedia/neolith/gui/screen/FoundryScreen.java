package github.xuulmedia.neolith.gui.screen;

import github.xuulmedia.neolith.Neolith;
import com.mojang.blaze3d.systems.RenderSystem;
import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.block.entity.FoundryBE;
import github.xuulmedia.neolith.gui.menu.FoundryMenu;
import github.xuulmedia.neolith.util.TooltipHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Nullable;

public class FoundryScreen extends AbstractNeolithScreen<FoundryMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Neolith.MODID, "textures/gui/foundry_gui.png");
    private @Nullable Integer heatRequiredToCook;
    private final int imageWidth;
    private final int imageHeight;

    public FoundryScreen(FoundryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
    protected void init() {
        super.init();
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

        gui.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        //Fuel burn
        float litProgress = this.menu.fuelProportion();
        if (litProgress > 0) {
            renderVerticallyScaledComponent(gui, x, y, 176, 0, 57, 37, 14, 14, scaleProgress(litProgress, 13));
        }
        //progress arrow
        float progressArrowProportion = this.menu.progressProportion();
        int scaledProgressArrow = (int) (progressArrowProportion * 22f);
        renderHorizontallyScaledComponent(gui, x, y, 176, 14, 86, 35, 25, 17, scaledProgressArrow);

        //heat bar
        float heatBarProportion = this.menu.heatProportion();
        if (heatBarProportion > 0) {
            int scaledHeatProp = Mth.ceil(heatBarProportion * 42f);
            renderVerticallyScaledComponent(gui, x, y, 176, 31, 24, 22, 6, 42, scaledHeatProp);
        }

        //too cold X
        int tooColdPropLeftPos = 176;
        int tooColdPropTopPos = 79;
        int tooColdRenderLeftPos = 92;
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


        TooltipHelper[] tooltipHelpers = new TooltipHelper[] {
                new TooltipHelper(x + 24, x + 29, y + 22, y + 63, () -> true, () -> Component.translatable("container.neolith.forge.heat", this.menu.heat())),
                new TooltipHelper(x + 56, x + 70, y + 36, y + 50, this.menu::isBurningFuel, () -> Component.translatable("container.neolith.forge.heat.target", this.menu.targetHeat())),
                new TooltipHelper(x + 92, x + 92+12, y + 19, y + 30, this::isTooColdToCook, () -> Component.translatable("container.neolith.forge.heat.too_cold", this.heatRequiredToCook)),
        };

        for (TooltipHelper tooltipHelper : tooltipHelpers) {
            if (tooltipHelper.isMouseOver(mx, my) && tooltipHelper.shouldRender()) {
                gui.renderTooltip(this.font, tooltipHelper.getText(), mx, my);
                break;
            }
        }
    }
}