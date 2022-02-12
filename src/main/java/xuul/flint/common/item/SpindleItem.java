package xuul.flint.common.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

import javax.annotation.Nonnull;
import java.util.Random;

public class SpindleItem extends TieredItem {
    public SpindleItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Nonnull
    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack stack)
    {
        ItemStack container = stack.copy();
        if(container.hurt(1, new Random(), null))
            return ItemStack.EMPTY;
        else
            return container;
    }


    @Override
    public boolean hasContainerItem(@Nonnull ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack)
    {
        return true;
    }
}
