package github.xuulmedia.neolith.gui.menu;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractNeolithMenu extends AbstractContainerMenu {

    protected AbstractNeolithMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }


    protected void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    protected void addPlayerInventory(Inventory playerInventory, int xOffset, int yOffset) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, xOffset + 8 + l * 18, yOffset + 86 + i * 18));
            }
        }
    }

    protected void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }

    protected void addPlayerHotbar(Inventory playerInventory, int xOffset, int yOffset) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, xOffset + 8 + i * 18, yOffset + 144));
        }
    }

    protected void addSlotRange(ItemStackHandler inventory , int numSlots, int xPos, int yPos, int dx) {
        for (int i = 0; i < numSlots; i++) {
            addSlot(new SlotItemHandler(inventory, i, xPos, yPos));
            xPos += dx;
        }
    }

    protected void addSlotGrid(ItemStackHandler inventory, int numColumns, int numRows, int xPos, int yPos, int dx, int dy) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int index = i * numColumns + j;
                addSlot(new SlotItemHandler(inventory, index, xPos + j * dx, yPos + i * dy));
            }
        }
    }

    
}
