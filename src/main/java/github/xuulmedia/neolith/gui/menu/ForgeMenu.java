package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.gui.slot.ModResultSlot;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.ForgeRecipe;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
        checkContainerSize(inventory, 3);
        blockEntity = (ForgeBE) entity;
        this.level = inventory.player.level();
        this.data = data;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);


        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, ForgeBE.SLOT_INPUT, 56, 17));
            this.addSlot(new FuelSlot(handler, ForgeBE.SLOT_FUEL, 56, 53));
            this.addSlot(new ModResultSlot(handler, ForgeBE.SLOT_OUTPUT, 116, 35));
        });

        this.addDataSlots(data);

        RecipeManager recipeManager = this.level.getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(ForgeRecipe.Type.INSTANCE);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, ModBlocks.FORGE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack out = ItemStack.EMPTY;
        Slot hoveredSlot = this.slots.get(pIndex);
        if (hoveredSlot != null && hoveredSlot.hasItem()) {
            ItemStack hoveredItem = hoveredSlot.getItem();
            out = hoveredItem.copy();
            if (pIndex == ForgeBE.SLOT_OUTPUT) {
                if (!this.moveItemStackTo(hoveredItem, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                hoveredSlot.onQuickCraft(hoveredItem, out);
            } else if (pIndex != 1 && pIndex != 0) {
                if (this.isFuel(hoveredItem)) {
                    if (!this.moveItemStackTo(hoveredItem, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isInputtable(hoveredItem)) {
                    if (!this.moveItemStackTo(hoveredItem, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 3 && pIndex < 30) {
                    if (!this.moveItemStackTo(hoveredItem, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= 30 && pIndex < 39 && !this.moveItemStackTo(hoveredItem, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(hoveredItem, 3, 39, false)) {
                return ItemStack.EMPTY;
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
        var input = this.getSlot(ForgeBE.SLOT_INPUT).getItem();
        if (input.isEmpty()) {
            return null;
        }

        for (var recipe : this.recipes) {
            if (recipe.getIngredient().test(input)) {
                return recipe.getHeat();
            }
        }

        return null;
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
}
