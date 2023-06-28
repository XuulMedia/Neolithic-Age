package github.xuulmedia.neolith.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.gui.menu.WorkBenchMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


public class WorkBenchScreen extends AbstractNeolithScreen<WorkBenchMenu>    {
        private static final ResourceLocation TEXTURE =
                new ResourceLocation(Neolith.MODID, "textures/gui/work_bench_gui.png");
        private final int leftPos;
        private final int topPos ;
        private final int imageWidth;
        private final int imageHeight;

        public WorkBenchScreen(WorkBenchMenu pMenu, Inventory pPlayerInventory,Component pTitle) {
            super(pMenu, pPlayerInventory, pTitle, TEXTURE);
            this.leftPos = 0;
            this.topPos = 0;
            this.imageWidth = 176;
            this.imageHeight = 166;
        }

        @Override
        public void render(GuiGraphics gui, int mouseX, int mouseY, float delta) {
            this.renderBackground(gui);
            super.render(gui, mouseX, mouseY, delta);
            this.renderTooltip(gui, mouseX, mouseY);
        }

        @Override
        protected void renderBg(GuiGraphics gui, float partialTick , int mouseX, int mouseY) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, TEXTURE);
            int x = (width - imageWidth) / 2;
            int y = (height - imageHeight) / 2;

            gui.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        }
    }
