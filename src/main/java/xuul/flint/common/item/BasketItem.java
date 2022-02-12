package xuul.flint.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.network.NetworkHooks;
import xuul.flint.common.gui.BasketContainer;
import xuul.flint.common.util.ItemBackedInventory;

import javax.annotation.Nonnull;
import java.util.stream.IntStream;

public class BasketItem extends Item{
    private static final Component CONTAINER_TITLE = new TranslatableComponent("container.basket");
    public static int SIZE = 9;

    public BasketItem(Properties props) {
        super(props);
    }

    public static boolean isValid(int slot, ItemStack stack) {
        Block block = Block.byItem(stack.getItem());
        return !stack.isEmpty();
    }

    public static SimpleContainer getInventory(ItemStack stack) {
        return new ItemBackedInventory(stack, SIZE) {
            @Override
            public boolean canPlaceItem(int slot, @Nonnull ItemStack stack) {
                return isValid(slot, stack);
            }
        };
    }


    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, @Nonnull InteractionHand hand) {
        if (!level.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            NetworkHooks.openGui((ServerPlayer) player, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return stack.getHoverName();
                }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
                    return new BasketContainer(id, inv, stack);
                }
            }, buf -> buf.writeBoolean(hand == InteractionHand.MAIN_HAND));
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }



    @Override
    public boolean canFitInsideContainerItems() {
        return false;
    }

    @Override
    public void onDestroyed(@Nonnull ItemEntity entity) {
        var container = getInventory(entity.getItem());
        var stream = IntStream.range(0, container.getContainerSize())
                .mapToObj(container::getItem)
                .filter(s -> !s.isEmpty());
        ItemUtils.onContainerDestroyed(entity, stream);
        container.clearContent();
    }


}