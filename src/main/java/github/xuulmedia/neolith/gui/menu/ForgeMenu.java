package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.ForgeRecipe;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static github.xuulmedia.neolith.block.entity.ForgeBE.SLOT_COUNT;
import static github.xuulmedia.neolith.block.entity.ForgeBE.SLOT_INPUT;

public class ForgeMenu extends AbstractContainerMenu {
    public final ForgeBE blockEntity;
    private final Level level;
    private final ContainerData data;
    public static final int STACK_SIZE = 3; // this must be a match with the number in the block BE

    private final List<HeatingFuelRecipe> fuels;
    private final List<ForgeRecipe> recipes;

    public ForgeMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public ForgeMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FORGE_MENU.get(), id);
        checkContainerSize(inventory, STACK_SIZE);
        blockEntity = (ForgeBE) entity;
        this.level = inventory.player.level();
        this.data = data;

        this.addSlot(new SlotItemHandler(blockEntity.getInputItems(), ForgeBE.SLOT_INPUT, 56, 17));
        this.addSlot(new SlotItemHandler(blockEntity.getFuelItems(), ForgeBE.SLOT_FUEL, 56, 53));
        this.addSlot(new SlotItemHandler(blockEntity.getOutputItems(), ForgeBE.SLOT_OUTPUT, 116, 35));

        this.addDataSlots(data);

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);


        RecipeManager recipeManager = this.level.getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(ForgeRecipe.Type.INSTANCE);
    }


    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, ModBlocks.FORGE.get());
    }


    private boolean isFuel(ItemStack stack) {
        for (var fuel : this.fuels) {
            if (fuel.input.test(stack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInputtable(ItemStack stack) {
        for (var recipe : this.recipes) {
            if (recipe.getIngredient().test(stack)) {
                return true;
            }
        }
        return false;
    }

    public float fuelProportion() {
        var maxFuel = this.data.get(ForgeBE.INDEX_MAX_FUEL_LEFT);
        if (maxFuel < 0) {
            return 0f;
        }

        return (float) this.data.get(ForgeBE.INDEX_FUEL_LEFT) / (float) maxFuel;
    }

    public float progressProportion() {
        var maxProgress = this.data.get(ForgeBE.INDEX_MAX_PROGRESS);
        if (maxProgress < 0) {
            return 0f;
        }

        return (float) this.data.get(ForgeBE.INDEX_PROGRESS) / (float) maxProgress;
    }

    public float heatProportion() {
        return (float) this.data.get(ForgeBE.INDEX_HEAT) / (float) ForgeBE.MAX_HEAT;
    }

    public int heat() {
        return this.data.get(ForgeBE.INDEX_HEAT);
    }

    public int targetHeat() {
        return this.data.get(ForgeBE.INDEX_TARGET_HEAT);
    }

    public boolean isBurningFuel() {
        return this.data.get(ForgeBE.INDEX_MAX_FUEL_LEFT) >= 0;
    }

    public @Nullable Integer maxHeatOf(ItemStack stack) {
        for (var fuel : this.fuels) {
            if (fuel.input.test(stack)) {
                return fuel.maxHeat;
            }
        }
        return null;
    }

    public @Nullable Integer heatReqdToCookInput() {
        ItemStack input = this.getSlot(ForgeBE.SLOT_INPUT).getItem();
        if (input.isEmpty()) {
            return null;
        }
        for (var recipe : this.recipes) {
            return recipe.getHeatRequired();
        }
        return null;
    }


    //QUICK MOVE CODE CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }



    //HELPERS

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }

    private class FuelSlot extends SlotItemHandler {
        public FuelSlot(IItemHandler itemHandler, int index, int x, int y) {
            super(itemHandler, index, x, y);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            for (var fuel : ForgeMenu.this.fuels) {
                if (fuel.input.test(stack)) {
                    return true;
                }
            }
            return false;
        }
    }


    /*Helpers for quick stack and player inventory*/

}
