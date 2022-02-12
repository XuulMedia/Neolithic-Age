package xuul.flint.common.gui;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.PlayerInvWrapper;
import xuul.flint.common.init.ModContainerTypes;
import xuul.flint.common.item.BasketItem;
import xuul.flint.common.util.ItemBackedContainer;

public class BasketMenu extends AbstractContainerMenu {

	private final ItemBackedContainer inventory;

	protected BasketMenu(int containerId, Inventory playerInventory, ItemBackedContainer inventory) {
		super(ModContainerTypes.BASKET_CONTAINER.get(), containerId);
		addPlayerSlots(playerInventory);
		this.inventory = inventory;

		int posY = 17;
		int posX = 62;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				this.addSlot(new Slot(inventory, x + y * 3, posX + x * 18, posY + y * 18) {
					@Override
					public boolean mayPlace(ItemStack stack) {
						return !(stack.getItem() instanceof BasketItem);
					}
				});
			}
		}
	}

	public static BasketMenu createServerMenu(int containerId, Inventory playerInventory, ItemBackedContainer inventory) {
		return new BasketMenu(containerId, playerInventory, inventory);
	}

	public static BasketMenu createClientMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
		return new BasketMenu(containerId, playerInventory, new ItemBackedContainer(extraData.readItem(), extraData.readVarInt()));
	}

	@Override
	public boolean stillValid(Player player) {
		return inventory.stillValid(player);
	}

	private void addPlayerSlots(Inventory playerInventory) {
		final int posX = 8;
		final int invPosY = 84;
		final int hotbarPosY = 142;

		PlayerInvWrapper playerInventoryForge = new PlayerInvWrapper(playerInventory);

		// Add the players hotbar
		for (int idx = 0; idx < 9; idx++) {
			addSlot(new SlotItemHandler(playerInventoryForge, idx, posX + 18 * idx, hotbarPosY));
		}

		// Add the players main inventory
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				int slotIndex = 9 + y * 9 + x;
				addSlot(new SlotItemHandler(playerInventoryForge, slotIndex, posX + x * 18, invPosY + y * 18));
			}
		}
	}

	@Override
	public void setCarried(ItemStack stack) {
		super.setCarried(stack);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		if (index == player.getInventory().selected) return ItemStack.EMPTY; //prevent quickmove of selected slot

		Slot slot = slots.get(index);
		if (!slot.hasItem()) return ItemStack.EMPTY;
		ItemStack stackInSlot = slot.getItem();
		ItemStack copyOfStack = stackInSlot.copy();

		boolean successfulTransfer;
		SlotZone slotZone = SlotZone.getZoneFromIndex(index);

		switch (slotZone) {
			case BASKET_INVENTORY -> successfulTransfer = mergeIntoEither(SlotZone.PLAYER_HOTBAR, SlotZone.PLAYER_MAIN_INVENTORY, stackInSlot, true);
			case PLAYER_HOTBAR -> successfulTransfer = mergeIntoEither(SlotZone.BASKET_INVENTORY, SlotZone.PLAYER_MAIN_INVENTORY, stackInSlot, false);
			case PLAYER_MAIN_INVENTORY -> successfulTransfer = mergeIntoEither(SlotZone.BASKET_INVENTORY, SlotZone.PLAYER_HOTBAR, stackInSlot, false);
			default -> throw new IllegalArgumentException("unexpected SlotZone:" + slotZone);
		}

		if (!successfulTransfer) return ItemStack.EMPTY;

		if (stackInSlot.isEmpty()) slot.set(ItemStack.EMPTY);
		else slot.setChanged();

		if (stackInSlot.getCount() == copyOfStack.getCount()) {
			return ItemStack.EMPTY;
		}

		slot.onTake(player, stackInSlot);
		return copyOfStack;
	}

	private boolean mergeInto(SlotZone zone, ItemStack stack, boolean fillFromEnd) {
		if (zone == SlotZone.BASKET_INVENTORY && stack.getItem() instanceof BasketItem) {
			return false; //prevent insertion of baskets into the basket inventory
		}
		return moveItemStackTo(stack, zone.getFirstIndex(), zone.getLastIndexPlusOne(), fillFromEnd);
	}

	private boolean mergeIntoEither(SlotZone zoneA, SlotZone zoneB, ItemStack stack, boolean fillFromEnd) {
		return mergeInto(zoneA, stack, fillFromEnd) || mergeInto(zoneB, stack, fillFromEnd);
	}

	public enum SlotZone {
		PLAYER_HOTBAR(0, 9),
		PLAYER_MAIN_INVENTORY(PLAYER_HOTBAR.lastIndexPlus1, 3 * 9),
		BASKET_INVENTORY(PLAYER_MAIN_INVENTORY.lastIndexPlus1, BasketItem.INVENTORY_SLOTS);

		public final int firstIndex;
		public final int slotCount;
		public final int lastIndexPlus1;

		SlotZone(int firstIndex, int numberOfSlots) {
			this.firstIndex = firstIndex;
			slotCount = numberOfSlots;
			lastIndexPlus1 = firstIndex + numberOfSlots;
		}

		public static SlotZone getZoneFromIndex(int slotIndex) {
			for (SlotZone slotZone : SlotZone.values()) {
				if (slotIndex >= slotZone.firstIndex && slotIndex < slotZone.lastIndexPlus1) return slotZone;
			}
			throw new IndexOutOfBoundsException("Unexpected slotIndex");
		}

		public int getFirstIndex() {
			return firstIndex;
		}

		public int getLastIndexPlusOne() {
			return lastIndexPlus1;
		}

	}

}
