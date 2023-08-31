package github.xuulmedia.neolith.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import github.xuulmedia.neolith.block.custom.DryingRackBlock;
import github.xuulmedia.neolith.block.entity.DryingRackBE;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DryingRackRenderer implements BlockEntityRenderer<DryingRackBE> {
    private static final float SIZE = 0.7F;
    private final ItemRenderer itemRenderer;

    public DryingRackRenderer(BlockEntityRendererProvider.Context pContext) {
        this.itemRenderer = pContext.getItemRenderer();
    }

    public void render(DryingRackBE pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        Direction direction = pBlockEntity.getBlockState().getValue(DryingRackBlock.FACING);
        NonNullList<ItemStack> nonnulllist = pBlockEntity.getItems();
        ItemStack itemstack = nonnulllist.get(0);
        if (itemstack != ItemStack.EMPTY) {
            pPoseStack.pushPose();
            float f = direction.getClockWise().toYRot();
            switch (direction) {
                default:
                    pPoseStack.translate(0.35F, 0.5F, 0.5F);

                    break;
                case SOUTH:
                    pPoseStack.translate(0.5F, 0.5F, 0.35F);

                    break;
                case WEST:
                    pPoseStack.translate(0.65F, 0.5F, 0.5F);

                    break;
                case NORTH:
                    pPoseStack.translate(0.5F, 0.5F, 0.65F);

                    break;
            }
            pPoseStack.mulPose(Axis.YP.rotationDegrees(f+90));

            pPoseStack.scale(0.375F, 0.375F, 0.375F);
            this.itemRenderer.renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 0);
            pPoseStack.popPose();
        }
    }
}
