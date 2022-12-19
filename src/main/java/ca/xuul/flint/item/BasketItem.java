package ca.xuul.flint.item;

import ca.xuul.flint.gui.BasketMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import ca.xuul.flint.util.ItemBackedContainer;

import javax.annotation.Nonnull;
import java.util.stream.IntStream;

public class BasketItem extends Item implements DyeableLeatherItem {

	public static final int INVENTORY_SLOTS = 9;
	private static final Component CONTAINER_TITLE = Component.translatable("container.basket");

	public BasketItem(Properties props) {
		super(props);
	}

	public static boolean isValid(int slot, ItemStack stack) {
		return !stack.isEmpty() && !(stack.getItem() instanceof BasketItem);
	}

	public static ItemBackedContainer getInventory(ItemStack stack) {
		return new ItemBackedContainer(stack, INVENTORY_SLOTS) {
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
			ItemBackedContainer inventory = getInventory(stack);
			MenuProvider menu = new SimpleMenuProvider((id, playerInv, p) -> BasketMenu.createServerMenu(id, playerInv, inventory), stack.getHoverName());
			NetworkHooks.openScreen((ServerPlayer) player, menu, buffer -> {
				buffer.writeItem(stack);
				buffer.writeVarInt(inventory.getContainerSize());
			});
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