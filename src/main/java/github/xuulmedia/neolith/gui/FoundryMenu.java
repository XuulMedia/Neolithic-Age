package github.xuulmedia.neolith.gui;

import github.xuulmedia.neolith.block.entity.FoundryBlockEntity;
import github.xuulmedia.neolith.gui.slot.ModResultSlot;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.FoundryRecipe;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FoundryMenu extends AbstractContainerMenu {
    private final BlockPos pos;
    private final Level world;
    private final Player player;
    private final Inventory playerInventory;
    private final FoundryBlockEntity tile;

    private final ContainerData data;

    private final List<HeatingFuelRecipe> fuels;
    private final List<FoundryRecipe> recipes;

    public FoundryMenu(int windowId, Inventory inv, FriendlyByteBuf extraData) {
        this(windowId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public FoundryMenu(int windowId, Inventory inventory, BlockEntity tile, ContainerData data) {
        super(ModMenuTypes.FOUNDRY.get(), windowId);

        this.playerInventory = inventory;
        this.player = this.playerInventory.player;
        this.world = this.player.level;
        this.tile = (FoundryBlockEntity) tile;
        this.pos = this.tile.getBlockPos();
        this.data = data;

        this.tile.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, FoundryBlockEntity.SLOT_INPUT, 56, 17));
            this.addSlot(new FuelSlot(handler, FoundryBlockEntity.SLOT_FUEL, 56, 53));
            this.addSlot(new ModResultSlot(handler, FoundryBlockEntity.SLOT_OUTPUT, 116, 35));
        });

        // Inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Hotbar
        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(data);

        var recman = this.world.getRecipeManager();
        this.fuels = recman.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recman.getAllRecipesFor(FoundryRecipe.Type.INSTANCE);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(world, pos), pPlayer, ModBlocks.FOUNDRY.get());
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack out = ItemStack.EMPTY;
        Slot hoveredSlot = this.slots.get(pIndex);
        if (hoveredSlot != null && hoveredSlot.hasItem()) {
            ItemStack hoveredItem = hoveredSlot.getItem();
            out = hoveredItem.copy();
            if (pIndex == FoundryBlockEntity.SLOT_OUTPUT) {
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
            if (recipe.input.test(stack)) {
                return true;
            }
        }
        return false;
    }

    public float fuelProportion() {
        var maxFuel = this.data.get(FoundryBlockEntity.IDX_MAX_FUEL_LEFT);
        if (maxFuel < 0) {
            return 0f;
        }

        return (float) this.data.get(FoundryBlockEntity.IDX_FUEL_LEFT) / (float) maxFuel;
    }

    public float progressProportion() {
        var maxProgress = this.data.get(FoundryBlockEntity.IDX_MAX_PROGRESS);
        if (maxProgress < 0) {
            return 0f;
        }

        return (float) this.data.get(FoundryBlockEntity.IDX_PROGRESS) / (float) maxProgress;
    }

    public float heatProportion() {
        return (float) this.data.get(FoundryBlockEntity.IDX_HEAT) / (float) FoundryBlockEntity.MAX_HEAT;
    }

    public int heat() {
        return this.data.get(FoundryBlockEntity.IDX_HEAT);
    }

    public int targetHeat() {
        return this.data.get(FoundryBlockEntity.IDX_TARGET_HEAT);
    }

    public boolean isBurningFuel() {
        return this.data.get(FoundryBlockEntity.IDX_MAX_FUEL_LEFT) >= 0;
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
        var input = this.getSlot(FoundryBlockEntity.SLOT_INPUT).getItem();
        if (input.isEmpty()) {
            return null;
        }

        for (var recipe : this.recipes) {
            if (recipe.input.test(input)) {
                return recipe.heat;
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
            for (var fuel : FoundryMenu.this.fuels) {
                if (fuel.input.test(stack)) {
                    return true;
                }
            }
            return false;
        }
    }
}
