package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.ClayPotBE;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import static github.xuulmedia.neolith.block.entity.ClayPotBE.SLOT_COUNT;

public class ClayPotMenu extends AbstractNeolithMenu{
    public final ClayPotBE blockEntity;
    private final Level level;
    private final ContainerLevelAccess access;
    private final Player player;

    public ClayPotMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public ClayPotMenu(int id, Inventory inventory, BlockEntity entity) {
        super(ModMenuTypes.CLAY_POT_MENU.get(), id);

        checkContainerSize(inventory, ClayPotBE.SLOT_COUNT);
        blockEntity = (ClayPotBE) entity;
        this.level = inventory.player.level();

        this.addSlotGrid(blockEntity.getItems(), 5,3, 44,16,18,18);
        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.player = inventory.player;
        this.access = ContainerLevelAccess.NULL;

    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.CLAY_POT.get());
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack resturnStack = ItemStack.EMPTY;
        Slot sourceSlot = this.slots.get(index);
        if (sourceSlot.hasItem()) {
            ItemStack sourceStack = sourceSlot.getItem();
            resturnStack = sourceStack.copy(); // need to copy

            //Check if we are clicking a mod slot or vanilla inventory
            if (index < SLOT_COUNT) {
                //This is a vanilla container so we move to the BE inventory
                if (!moveItemStackTo(sourceStack, SLOT_COUNT, Inventory.INVENTORY_SIZE + SLOT_COUNT, true)) {
                    return ItemStack.EMPTY;
                }
            }
            // This the BE Slot so we move to player inventory
            if (index < Inventory.INVENTORY_SIZE + SLOT_COUNT && !this.moveItemStackTo(sourceStack, SLOT_COUNT, 27 + SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }

            // If stack size == 0 (the entire stack was moved) set slot contents to null
            if (sourceStack.getCount() == 0) {
                sourceSlot.set(ItemStack.EMPTY);
            } else {
                sourceSlot.setChanged();
            }
            sourceSlot.onTake(playerIn, sourceStack);

        }
        return resturnStack;
    }

}
