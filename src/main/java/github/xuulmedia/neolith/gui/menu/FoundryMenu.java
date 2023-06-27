package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.block.entity.FoundryBE;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.FoundryRecipe;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;
import java.util.List;

import static github.xuulmedia.neolith.block.entity.ForgeBE.SLOT_COUNT;
import static github.xuulmedia.neolith.block.entity.ForgeBE.SLOT_INPUT;
import static github.xuulmedia.neolith.block.entity.FoundryBE.SLOT_INPUT_COUNT;
import static github.xuulmedia.neolith.block.entity.FoundryBE.SLOT_RESULT_COUNT;

public class FoundryMenu extends AbstractHeatCookMenu {
    public final FoundryBE blockEntity;
    private final Level level;
    private final List<FoundryRecipe> recipes;

    public FoundryMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public FoundryMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FOUNDRY_MENU.get(), id, data);

        checkContainerSize(inventory, FoundryBE.SLOT_COUNT);
        this.blockEntity = (FoundryBE) entity;
        this.level = inventory.player.level();

        addSlotRange(blockEntity.getInputItems(), SLOT_INPUT_COUNT, 38, 18, 18);

        this.addSlot(new SlotItemHandler(blockEntity.getFuelItems(), ForgeBE.SLOT_FUEL, 56, 53));

        addSlotRange(blockEntity.getResultItems(), SLOT_RESULT_COUNT, 116, 35, 20);

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.addDataSlots(data);


        RecipeManager recipeManager = this.level.getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(FoundryRecipe.Type.INSTANCE);

    }


    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.FOUNDRY.get());
    }

    public @Nullable Integer heatReqdToCookInput() {
        ItemStack input = this.getSlot(FoundryBE.SLOT_INPUT).getItem();
        if (input.isEmpty()) {
            return null;
        }
        for (var recipe : this.recipes) {
            return recipe.getHeatRequired();
        }
        return null;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        Slot sourceSlot = this.slots.get(index);

        if (sourceSlot.hasItem()) {
            ItemStack sourceStack = sourceSlot.getItem();
            returnStack = sourceStack.copy(); // need to copy

            //Check if we are clicking a mod slot or vanilla inventory
            if (index < SLOT_COUNT) {
                //This is a vanilla container so we move to the BE inventory
                if (!moveItemStackTo(sourceStack, SLOT_COUNT, Inventory.INVENTORY_SIZE + SLOT_COUNT, true)) {
                    return ItemStack.EMPTY;
                }
            }

            if (!this.moveItemStackTo(sourceStack, SLOT_INPUT, SLOT_INPUT + ForgeBE.SLOT_INPUT_COUNT, false)) {
                return ItemStack.EMPTY;
            }

            // If stack size == 0 (the entire stack was moved) set slot contents to null
            if (sourceStack.getCount() == 0) {
                sourceSlot.set(ItemStack.EMPTY);
            } else {
                sourceSlot.setChanged();
            }
            sourceSlot.onTake(player, sourceStack);

        }
        return returnStack;
    }




////
//    @Override
//    public ItemStack quickMoveStack(Player pPlayer, int index) {
//        ItemStack out = ItemStack.EMPTY;
//        Slot hoveredSlot = this.slots.get(index);
//        if (hoveredSlot != null && hoveredSlot.hasItem()) {
//            ItemStack hoveredItem = hoveredSlot.getItem();
//            out = hoveredItem.copy();
//            if (FoundryBE.SLOT_FUEL <= index && index <= FoundryBE.SLOT_OUTPUT1) {
//                // move from the kiln's slots input to main inv
//                if (!this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_OUTPUT1 + 1,
//                        FoundryBE.SLOT_OUTPUT1 + 1 + 36, false)) {
//                    return ItemStack.EMPTY;
//                }
//
////				hoveredSlot.onQuickCraft(hoveredItem, out);
//            } else if (index >= FoundryBE.SLOT_OUTPUT1 + 1) {
//                // Move from inv ...
//                if (this.isInputtable(hoveredItem) && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_INPUT0,
//                        FoundryBE.SLOT_INPUT2 + 1, false)) {
//                    // to inputs?
//                    return ItemStack.EMPTY;
//                } else if (this.isFuel(hoveredItem) && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_FUEL,
//                        FoundryBE.SLOT_FUEL + 1, false)) {
//                    // to fuel?
//                    return ItemStack.EMPTY;
//                } else if (index <= FoundryBE.SLOT_OUTPUT1 + 1 + 27
//                        && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_OUTPUT1 + 1 + 27,
//                        FoundryBE.SLOT_OUTPUT1 + 1 + 27 + 9, true)) {
//                    // from main inv to hotbar?
//                    return ItemStack.EMPTY;
//                } else if (index > FoundryBE.SLOT_OUTPUT1 + 1 + 27
//                        && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_OUTPUT1 + 1,
//                        FoundryBE.SLOT_OUTPUT1 + 1 + 27, false)) {
//                    // from hotbar to main inv?
//                    return ItemStack.EMPTY;
//                }
//            }
//
//            if (hoveredItem.isEmpty()) {
//                hoveredSlot.set(ItemStack.EMPTY);
//            } else {
//                hoveredSlot.setChanged();
//            }
//
//            if (hoveredItem.getCount() == out.getCount()) {
//                return ItemStack.EMPTY;
//            }
//
//            hoveredSlot.onTake(pPlayer, hoveredItem);
//        }
//
//        return out;
//    }

//    private boolean isFuel(ItemStack stack) {
//        for (var fuel : this.fuels) {
//            if (fuel.input.test(stack)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isInputtable(ItemStack stack) {
//        // TODO: some level of caching?
//        for (var recipe : this.recipes) {
//            for (var ingr : recipe.ingredients) {
//                if (ingr.test(stack)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    public float fuelProportion() {
//        var maxFuel = this.data.get(FoundryBE.INDEX_MAX_FUEL_LEFT);
//        if (maxFuel < 0) {
//            return 0f;
//        }
//
//        return (float) this.data.get(FoundryBE.INDEX_FUEL_LEFT) / (float) maxFuel;
//    }

//    public float progressProportion() {
//        var maxProgress = this.data.get(FoundryBE.INDEX_MAX_PROGRESS);
//        if (maxProgress < 0) {
//            return 0f;
//        }
//
//        return (float) this.data.get(FoundryBE.INDEX_PROGRESS) / (float) maxProgress;
//    }
//
//    public float heatProportion() {
//        return (float) this.data.get(FoundryBE.INDEX_HEAT) / (float) FoundryBE.MAX_HEAT;
//    }
//
//    public int heat() {
//        return this.data.get(FoundryBE.INDEX_HEAT);
//    }
//
//    public int targetHeat() {
//        return this.data.get(FoundryBE.INDEX_TARGET_HEAT);
//    }
//
//    public boolean isBurningFuel() {
//        return this.data.get(FoundryBE.INDEX_MAX_FUEL_LEFT) >= 0;
//    }
//
//    public @Nullable Integer maxHeatOf(ItemStack stack) {
//        for (var fuel : this.fuels) {
//            if (fuel.input.test(stack)) {
//                return fuel.maxHeat;
//            }
//        }
//        return null;
//    }
//    private class FuelSlot extends SlotItemHandler {
//        public FuelSlot(IItemHandler itemHandler, int index, int x, int y) {
//            super(itemHandler, index, x, y);
//        }
//
//        @Override
//        public boolean mayPlace(@NotNull ItemStack stack) {
//            for (var fuel : FoundryMenu.this.fuels) {
//                if (fuel.input.test(stack)) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//
//    protected void addPlayerInventory(Inventory playerInventory) {
//        for (int i = 0; i < 3; ++i) {
//            for (int l = 0; l < 9; ++l) {
//                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
//            }
//        }
//    }
//    protected void addPlayerHotbar(Inventory playerInventory) {
//        for (int i = 0; i < 9; ++i) {
//            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
//        }
//    }


}
