package github.xuulmedia.neolith.gui.screen;

import github.xuulmedia.neolith.Neolith;
import com.mojang.blaze3d.systems.RenderSystem;
import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.block.entity.FoundryBE;
import github.xuulmedia.neolith.gui.menu.FoundryMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Nullable;

public class FoundryScreen extends AbstractContainerScreen<FoundryMenu> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Neolith.MODID,"textures/gui/foundry_gui.png");
    private @Nullable Integer heatRequiredToCook;
    private final int imageWidth;
    private final int imageHeight;

    public FoundryScreen(FoundryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
        int arrowBarRenderLeftPos = 86;
        int arrowBarRenderTopPos = 35;

        float progressArrowProportion = this.menu.progressProportion();
        int scaledProgressArrow = (int)(progressArrowProportion * 22f);
        gui.blit(TEXTURE, x+ arrowBarRenderLeftPos, y + arrowBarRenderTopPos, arrowBarLeftPos, arrowBarTopPos, 1 + scaledProgressArrow, 16);

        //temp prop
        int tempPropLeftPos = 176;
        int tempPropTopPos = 31;
        int tempPropRenderLeftPos = 24;
        int tempPropRenderTopPos = 22;

        float heatBarProportion =  this.menu.heatProportion();
        if(heatBarProportion > 0){
            var scaledHeatProp = Mth.ceil(heatBarProportion * 42f);
            gui.blit(TEXTURE, x + tempPropRenderLeftPos, y + tempPropRenderTopPos + 42 - scaledHeatProp, tempPropLeftPos, tempPropTopPos + 42 - scaledHeatProp, 6 , scaledHeatProp);
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
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    protected void renderTooltip(GuiGraphics gui, int mx, int my) {
        super.renderTooltip(gui, mx, my);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        if (mx >= x + 24 && mx <= x + 29 && my >= y + 22 && my <= y + 63) {

            gui.renderTooltip(this.font, Component.translatable("container.neolith.forge.heat", this.menu.heat()), mx, my);
        } else if (mx >= x + 56 && mx <= x + 70 && my >= y + 36 && my <= y + 50 && this.menu.isBurningFuel()) {
            gui.renderTooltip(this.font, Component.translatable("container.neolith.forge.heat.target", this.menu.targetHeat()),  mx, my);
        } else if (mx >= x + 76 && mx <= x + 87 && my >= y + 19 && my <= y + 30 && this.isTooColdToCook()) {
            gui.renderTooltip(this.font, Component.translatable("container.neolith.forge.heat.too_cold", this.heatRequiredToCook), mx, my);
        } else if (this.menu.getCarried().isEmpty() && this.hoveredSlot != null && this.hoveredSlot.hasItem()) {
            gui.renderTooltip(this.font, this.hoveredSlot.getItem(), mx, my);
        } else if (!this.menu.getCarried().isEmpty()
                && this.hoveredSlot != null && this.hoveredSlot.index == FoundryBE.SLOT_FUEL) {
            var fuelTemp = this.menu.maxHeatOf(this.menu.getCarried());
            if (fuelTemp != null) {
                gui.renderTooltip(this.font,Component.translatable("container.neolith.forge.heat.target", fuelTemp), mx, my);
            }
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

//    @Override
//    protected void containerTick() {
//        var recipe = this.getMenu().getCachedRecipe();
//        if (recipe != null) {
//            this.heatReqdToCookInput = recipe.getHeatRequired();
//        } else {
//            this.heatReqdToCookInput = null;
//        }
//    }
//
//    @Override
//    public boolean isPauseScreen() {
//        return false;
//    }
//
//    private boolean isTooColdToCook() {
//        if (this.heatReqdToCookInput == null) {
//            return false;
//        }
//        return this.heatReqdToCookInput > this.menu.heat();
//    }
}
