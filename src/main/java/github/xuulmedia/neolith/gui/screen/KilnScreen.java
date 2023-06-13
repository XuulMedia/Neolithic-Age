package github.xuulmedia.neolith.gui.screen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.entity.FoundryBlockEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import github.xuulmedia.neolith.gui.menu.KilnMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Nullable;

public class KilnScreen extends AbstractContainerScreen<KilnMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Neolith.MODID,"textures/gui/kiln_gui.png");
    private @Nullable Integer heatReqdToCookInput;

    public KilnScreen(KilnMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        var recipe = this.getMenu().getCachedRecipe();
        if (recipe != null) {
            this.heatReqdToCookInput = recipe.heat;
        } else {
            this.heatReqdToCookInput = null;
        }
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics gui, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(gui);
        super.render(gui, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(gui, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(GuiGraphics gui, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        gui.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        var fuelProp = this.menu.fuelProportion();
        if (fuelProp > 0) {
            var scaledFuelProp = (int) (fuelProp * 13f);
            gui.blit(TEXTURE, x + 56, y + 36 + 12 - scaledFuelProp, 176, 12 - scaledFuelProp, 14, scaledFuelProp + 1);
        }

        var progressProp = this.menu.progressProportion();
        if (progressProp > 0) {
            var scaledProgressProp = (int) (progressProp * 24);
            gui.blit(TEXTURE, x + 88, y + 35, 176, 14, scaledProgressProp + 1, 16);
        }

        var heatProp = this.menu.heatProportion();
        if (heatProp > 0) {
            var scaledHeatProp = Mth.ceil(heatProp * 42f);
            gui.blit(TEXTURE, x + 24, y + 22 + 42 - scaledHeatProp, 176, 31 + 42 - scaledHeatProp, 6, scaledHeatProp);
        }

        if (this.isTooColdToCook()) {
            gui.blit(TEXTURE, x + 76, y + 55, 176, 79, 12, 12);
        }
    }

//    @Override
//    protected void renderTooltip(PoseStack ps, int mx, int my) {
//        int x = (width - imageWidth) / 2;
//        int y = (height - imageHeight) / 2;
//        // TODO : change these tooltips to the kiln versions
//        if (mx >= x + 24 && mx <= x + 29 && my >= y + 22 && my <= y + 63) {
//            this.renderTooltip(ps, Component.translatable("container.flint.foundry.heat", this.menu.heat()), mx, my);
//        } else if (mx >= x + 56 && mx <= x + 70 && my >= y + 36 && my <= y + 50 && this.menu.isBurningFuel()) {
//            this.renderTooltip(ps,
//                    Component.translatable("container.flint.foundry.heat.target", this.menu.targetHeat()),
//                    mx, my);
//        } else if (mx >= x + 76 && mx <= x + 88 && my >= y + 55 && my <= y + 67 && this.isTooColdToCook()) {
//            this.renderTooltip(ps,
//                    Component.translatable("container.flint.foundry.heat.too_cold", this.heatReqdToCookInput),
//                    mx, my);
//        } else if (this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
//            this.renderTooltip(ps, this.hoveredSlot.getItem(), mx, my);
//        } else if (!this.menu.getCarried().isEmpty()
//                && this.hoveredSlot != null && this.hoveredSlot.index == FoundryBlockEntity.SLOT_FUEL) {
//            var fuelTemp = this.menu.maxHeatOf(this.menu.getCarried());
//            if (fuelTemp != null) {
//                this.renderTooltip(ps,
//                        Component.translatable("container.flint.foundry.heat.target", fuelTemp),
//                        mx, my);
//            }
//        }
//    }

    @Override
    protected void containerTick() {
        var recipe = this.getMenu().getCachedRecipe();
        if (recipe != null) {
            this.heatReqdToCookInput = recipe.heat;
        } else {
            this.heatReqdToCookInput = null;
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private boolean isTooColdToCook() {
        if (this.heatReqdToCookInput == null) {
            return false;
        }
        return this.heatReqdToCookInput > this.menu.heat();
    }
}
