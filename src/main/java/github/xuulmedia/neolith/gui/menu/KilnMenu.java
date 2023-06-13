package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.KilnBlockEntity;
import github.xuulmedia.neolith.gui.slot.ModResultSlot;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import github.xuulmedia.neolith.recipe.KilnRecipe;
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

public class KilnMenu extends AbstractContainerMenu {

    public final KilnBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;
    private final List<HeatingFuelRecipe> fuels;
    private final List<KilnRecipe> recipes;

    @Nullable
    private KilnRecipe cachedRecipe;

    public KilnMenu(int windowId, Inventory inventory, FriendlyByteBuf extraData) {
        this(windowId, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public KilnMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.KILN_MENU.get(), id);
        checkContainerSize(inventory, 6);
        this.blockEntity = (KilnBlockEntity) entity;
        this.level = inventory.player.level();
        this.data = data;
        this.cachedRecipe = null;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new FuelSlot(handler, KilnBlockEntity.SLOT_FUEL, 56, 53));

            for (int i = 0; i < KilnRecipe.MAX_INPUTS; i++) {
                this.addSlot(new SlotItemHandler(handler, KilnBlockEntity.SLOT_INPUT0 + i, 38 + 18 * i, 18) {
                    @Override
                    public void setChanged() {
                        super.setChanged();
                        KilnMenu.this.cachedRecipe = KilnBlockEntity.getAttemptedRecipe(recipes,
                                INDEX -> handler.getStackInSlot(KilnBlockEntity.SLOT_INPUT0 + INDEX));
                    }
                });
            }
            for (int i = 0; i < KilnRecipe.MAX_OUTPUTS; i++) {
                this.addSlot(new ModResultSlot(handler, KilnBlockEntity.SLOT_OUTPUT0 + i, 116 + 20 * i, 35));
            }
        });



        this.addDataSlots(data);

        RecipeManager recipeManager = inventory.player.level().getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(KilnRecipe.Type.INSTANCE);

    }
    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.KILN.get());
    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int index) {
        ItemStack out = ItemStack.EMPTY;
        Slot hoveredSlot = this.slots.get(index);
        if (hoveredSlot != null && hoveredSlot.hasItem()) {
            ItemStack hoveredItem = hoveredSlot.getItem();
            out = hoveredItem.copy();
            if (KilnBlockEntity.SLOT_FUEL <= index && index <= KilnBlockEntity.SLOT_OUTPUT1) {
                // move from the kiln's slots input to main inv
                if (!this.moveItemStackTo(hoveredItem, KilnBlockEntity.SLOT_OUTPUT1 + 1,
                        KilnBlockEntity.SLOT_OUTPUT1 + 1 + 36, false)) {
                    return ItemStack.EMPTY;
                }

//				hoveredSlot.onQuickCraft(hoveredItem, out);
            } else if (index >= KilnBlockEntity.SLOT_OUTPUT1 + 1) {
                // Move from inv ...
                if (this.isInputtable(hoveredItem) && !this.moveItemStackTo(hoveredItem, KilnBlockEntity.SLOT_INPUT0,
                        KilnBlockEntity.SLOT_INPUT2 + 1, false)) {
                    // to inputs?
                    return ItemStack.EMPTY;
                } else if (this.isFuel(hoveredItem) && !this.moveItemStackTo(hoveredItem, KilnBlockEntity.SLOT_FUEL,
                        KilnBlockEntity.SLOT_FUEL + 1, false)) {
                    // to fuel?
                    return ItemStack.EMPTY;
                } else if (index <= KilnBlockEntity.SLOT_OUTPUT1 + 1 + 27
                        && !this.moveItemStackTo(hoveredItem, KilnBlockEntity.SLOT_OUTPUT1 + 1 + 27,
                        KilnBlockEntity.SLOT_OUTPUT1 + 1 + 27 + 9, true)) {
                    // from main inv to hotbar?
                    return ItemStack.EMPTY;
                } else if (index > KilnBlockEntity.SLOT_OUTPUT1 + 1 + 27
                        && !this.moveItemStackTo(hoveredItem, KilnBlockEntity.SLOT_OUTPUT1 + 1,
                        KilnBlockEntity.SLOT_OUTPUT1 + 1 + 27, false)) {
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
            for (var ingr : recipe.inputs) {
                if (ingr.test(stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public float fuelProportion() {
        var maxFuel = this.data.get(KilnBlockEntity.INDEX_MAX_FUEL_LEFT);
        if (maxFuel < 0) {
            return 0f;
        }

        return (float) this.data.get(KilnBlockEntity.INDEX_FUEL_LEFT) / (float) maxFuel;
    }

    public float progressProportion() {
        var maxProgress = this.data.get(KilnBlockEntity.INDEX_MAX_PROGRESS);
        if (maxProgress < 0) {
            return 0f;
        }

        return (float) this.data.get(KilnBlockEntity.INDEX_PROGRESS) / (float) maxProgress;
    }

    public float heatProportion() {
        return (float) this.data.get(KilnBlockEntity.INDEX_HEAT) / (float) KilnBlockEntity.MAX_HEAT;
    }

    public int heat() {
        return this.data.get(KilnBlockEntity.INDEX_HEAT);
    }

    public int targetHeat() {
        return this.data.get(KilnBlockEntity.INDEX_TARGET_HEAT);
    }

    public boolean isBurningFuel() {
        return this.data.get(KilnBlockEntity.INDEX_MAX_FUEL_LEFT) >= 0;
    }

    public @Nullable Integer maxHeatOf(ItemStack stack) {
        for (var fuel : this.fuels) {
            if (fuel.input.test(stack)) {
                return fuel.maxHeat;
            }
        }
        return null;
    }

    public KilnRecipe getCachedRecipe() {
        return cachedRecipe;
    }

    private class FuelSlot extends SlotItemHandler {
        public FuelSlot(IItemHandler itemHandler, int index, int x, int y) {
            super(itemHandler, index, x, y);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            for (var fuel : KilnMenu.this.fuels) {
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
