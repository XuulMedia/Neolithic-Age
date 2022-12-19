package ca.xuul.flint.item;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

import javax.annotation.Nonnull;
import java.util.Random;

import net.minecraft.world.item.Item.Properties;

public class SpindleItem extends TieredItem {
    public SpindleItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
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
