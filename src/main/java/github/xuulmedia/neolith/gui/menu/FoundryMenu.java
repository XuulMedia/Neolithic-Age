package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.FoundryBE;
import github.xuulmedia.neolith.gui.slot.ModResultSlot;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import github.xuulmedia.neolith.recipe.FoundryRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class FoundryMenu extends AbstractContainerMenu {

    public final FoundryBE blockEntity;
    private final Level level;
    private final ContainerData data;
    private final List<HeatingFuelRecipe> fuels;
    private final List<FoundryRecipe> recipes;

    @Nullable
    private FoundryRecipe cachedRecipe;

    public FoundryMenu(int windowId, Inventory inventory, FriendlyByteBuf extraData) {
        this(windowId, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public FoundryMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FOUNDRY_MENU.get(), id);
        checkContainerSize(inventory, 6);
        this.blockEntity = (FoundryBE) entity;
        this.level = inventory.player.level();
        this.data = data;
        this.cachedRecipe = null;


        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new FuelSlot(handler, FoundryBE.SLOT_FUEL, 56, 53));

            for (int i = 0; i < FoundryRecipe.MAX_INPUTS; i++) {
                this.addSlot(new SlotItemHandler(handler, FoundryBE.SLOT_INPUT0 + i, 38 + 18 * i, 18) {
                    @Override
                    public void setChanged() {
                        super.setChanged();
                        FoundryMenu.this.cachedRecipe = FoundryBE.getAttemptedRecipe(recipes,
                                INDEX -> handler.getStackInSlot(FoundryBE.SLOT_INPUT0 + INDEX));
                    }
                });
            }
            for (int i = 0; i < FoundryRecipe.MAX_OUTPUTS; i++) {
                this.addSlot(new ModResultSlot(handler, FoundryBE.SLOT_OUTPUT0 + i, 116 + 20 * i, 35));
            }
        });

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.addDataSlots(data);

        RecipeManager recipeManager = inventory.player.level().getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(FoundryRecipe.Type.INSTANCE);

    }
    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.FOUNDRY.get());
    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int index) {
        ItemStack out = ItemStack.EMPTY;
        Slot hoveredSlot = this.slots.get(index);
        if (hoveredSlot != null && hoveredSlot.hasItem()) {
            ItemStack hoveredItem = hoveredSlot.getItem();
            out = hoveredItem.copy();
            if (FoundryBE.SLOT_FUEL <= index && index <= FoundryBE.SLOT_OUTPUT1) {
                // move from the kiln's slots input to main inv
                if (!this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_OUTPUT1 + 1,
                        FoundryBE.SLOT_OUTPUT1 + 1 + 36, false)) {
                    return ItemStack.EMPTY;
                }

//				hoveredSlot.onQuickCraft(hoveredItem, out);
            } else if (index >= FoundryBE.SLOT_OUTPUT1 + 1) {
                // Move from inv ...
                if (this.isInputtable(hoveredItem) && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_INPUT0,
                        FoundryBE.SLOT_INPUT2 + 1, false)) {
                    // to inputs?
                    return ItemStack.EMPTY;
                } else if (this.isFuel(hoveredItem) && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_FUEL,
                        FoundryBE.SLOT_FUEL + 1, false)) {
                    // to fuel?
                    return ItemStack.EMPTY;
                } else if (index <= FoundryBE.SLOT_OUTPUT1 + 1 + 27
                        && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_OUTPUT1 + 1 + 27,
                        FoundryBE.SLOT_OUTPUT1 + 1 + 27 + 9, true)) {
                    // from main inv to hotbar?
                    return ItemStack.EMPTY;
                } else if (index > FoundryBE.SLOT_OUTPUT1 + 1 + 27
                        && !this.moveItemStackTo(hoveredItem, FoundryBE.SLOT_OUTPUT1 + 1,
                        FoundryBE.SLOT_OUTPUT1 + 1 + 27, false)) {
                    // from hotbar to main inv?
                    return ItemStack.EMPTY;
                }
            }

            if (hoveredItem.isEmpty()) {
                hoveredSlot.set(ItemStack.EMPTY);
            } else {
                hoveredSlot.setChanged();
            }

            if (hoveredItem.getCount() == out.getCount()) {
                return ItemStack.EMPTY;
            }

            hoveredSlot.onTake(pPlayer, hoveredItem);
        }

        return out;
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
        // TODO: some level of caching?
        for (var recipe : this.recipes) {
            for (var ingr : recipe.ingredients) {
                if (ingr.test(stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public float fuelProportion() {
        var maxFuel = this.data.get(FoundryBE.INDEX_MAX_FUEL_LEFT);
        if (maxFuel < 0) {
            return 0f;
        }

        return (float) this.data.get(FoundryBE.INDEX_FUEL_LEFT) / (float) maxFuel;
    }

    public float progressProportion() {
        var maxProgress = this.data.get(FoundryBE.INDEX_MAX_PROGRESS);
        if (maxProgress < 0) {
            return 0f;
        }

        return (float) this.data.get(FoundryBE.INDEX_PROGRESS) / (float) maxProgress;
    }

    public float heatProportion() {
        return (float) this.data.get(FoundryBE.INDEX_HEAT) / (float) FoundryBE.MAX_HEAT;
    }

    public int heat() {
        return this.data.get(FoundryBE.INDEX_HEAT);
    }

    public int targetHeat() {
        return this.data.get(FoundryBE.INDEX_TARGET_HEAT);
    }

    public boolean isBurningFuel() {
        return this.data.get(FoundryBE.INDEX_MAX_FUEL_LEFT) >= 0;
    }

    public @Nullable Integer maxHeatOf(ItemStack stack) {
        for (var fuel : this.fuels) {
            if (fuel.input.test(stack)) {
                return fuel.maxHeat;
            }
        }
        return null;
    }

    public FoundryRecipe getCachedRecipe() {
        return cachedRecipe;
    }

    private class FuelSlot extends SlotItemHandler {
        public FuelSlot(IItemHandler itemHandler, int index, int x, int y) {
            super(itemHandler, index, x, y);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            for (var fuel : FoundryMenu.this.fuels) {
                if (fuel.input.test(stack)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }
    protected void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }


}
