package github.xuulmedia.neolith.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import github.xuulmedia.neolith.block.custom.ModCampfireBlock;
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
        Direction direction = pBlockEntity.getBlockState().getValue(ModCampfireBlock.FACING);
        NonNullList<ItemStack> nonnulllist = pBlockEntity.getItems();
        int i = (int) pBlockEntity.getBlockPos().asLong();


        ItemStack itemstack = nonnulllist.get(0);
        if (itemstack != ItemStack.EMPTY) {
            pPoseStack.pushPose();
            pPoseStack.translate(0.5F, 0.5F, 0.5F);
            Direction direction1 = Direction.from2DDataValue(direction.get2DDataValue());
            float f = -direction1.toYRot();
            pPoseStack.mulPose(Axis.YP.rotationDegrees(f));
                pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
            pPoseStack.translate(-0.3125F, -0.3125F, 0.0F);
            pPoseStack.scale(0.375F, 0.375F, 0.375F);
            this.itemRenderer.renderStatic(itemstack, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, pBlockEntity.getLevel(), i);
            pPoseStack.popPose();
        }
    }
}
