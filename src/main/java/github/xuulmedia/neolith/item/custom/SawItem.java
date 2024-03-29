package github.xuulmedia.neolith.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import javax.annotation.Nonnull;

public class SawItem extends DiggerItem {

    public SawItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, BlockTags.MINEABLE_WITH_AXE, pProperties);
    }
    @Nonnull
    @Override
    public ItemStack getCraftingRemainingItem(@Nonnull ItemStack stack)
    {
        ItemStack container = stack.copy();
        if(container.hurt(1, RandomSource.create(), null))
            return ItemStack.EMPTY;
        else
            return container;
    }

    @Override
    public boolean hasCraftingRemainingItem(@Nonnull ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack)
    {
        return true;
    }

}
