package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.menu.FoundryMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.recipe.FoundryRecipe;
import github.xuulmedia.neolith.util.AdaptedItemHandler;
import github.xuulmedia.neolith.util.HeatingFuelContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.IntFunction;

public class FoundryBE extends AbstractHeatingBlockEntity implements MenuProvider {
    public static final String DISPLAY_NAME = "Foundry";

    public static final int SLOT_FUEL = 0;
    public static final int SLOT_INPUT0 = 1;
    public static final int SLOT_INPUT1 = 2;
    public static final int SLOT_INPUT2 = 3;
    public static final int SLOT_OUTPUT0 = 4;
    public static final int SLOT_OUTPUT1 = 5;

    public static final int SLOT_INPUT_COUNT = 1;
    public static final int SLOT_FUEL_COUNT = 1;
    public static final int SLOT_OUTPUT_COUNT = 1;

    public static final int SLOT_COUNT  = SLOT_INPUT_COUNT + SLOT_FUEL_COUNT + SLOT_OUTPUT_COUNT;

    public FoundryBE(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FOUNDRY.get(), pPos, pBlockState);
        this.inputItems = createItemHandler(SLOT_INPUT_COUNT);
        this.fuelItems = createItemHandler(SLOT_FUEL_COUNT);
        this.outputItems = createItemHandler(SLOT_OUTPUT_COUNT);
        this.lazyItemHandler =  LazyOptional.of(() -> new CombinedInvWrapper(inputItems, inputItems, outputItems, fuelItems));


        this.inputItemHandler = LazyOptional.of(() -> new AdaptedItemHandler(inputItems) {
            @Override
            public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
                return ItemStack.EMPTY;
            }
        });

        this.outputItemHandler = LazyOptional.of(() -> new AdaptedItemHandler(outputItems) {
            @Override
            public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
                return stack;
            }
        });

        this.fuelItemHandler = LazyOptional.of(() -> new AdaptedItemHandler(fuelItems) {
            @Override
            public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
                return ItemStack.EMPTY;
            }
        });
    }
    @Override
    protected int getFuelSlotIndex() {
        return SLOT_FUEL;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory pPlayerInventory, Player pPlayer) {
        return new FoundryMenu(id, pPlayerInventory, this, this.data);
    }


    public static void tick(Level world, BlockPos pos, BlockState state, FoundryBE tile) {
        var ersatzInv = new HeatingFuelContainer(tile.fuelItems.getSlots()) {
            @Override
            public int getFuelSlot() {
                return SLOT_FUEL;
            }
        };
        for (int i = 0; i < tile.fuelItems.getSlots(); i++) {
            ersatzInv.setItem(i, tile.fuelItems.getStackInSlot(i));
        }

        AbstractHeatingBlockEntity.tickHeat(world, pos, state, tile, ersatzInv);

        var recman = world.getRecipeManager();

        var recipeMatch = recman.getRecipeFor(FoundryRecipe.Type.INSTANCE, ersatzInv, world);
        var recipeOk = false;

        if (recipeMatch.isPresent()) {
            var recipe = recipeMatch.get();

            if (recipeMatches(recipe, idx -> tile.inputItems.getStackInSlot(FoundryBE.SLOT_INPUT0 + idx))
                && recipe.heat <= tile.heat) {

                boolean outMatches = true;
//                System.out.println(recipe.outputs.size());
                for (int i = 0; i < FoundryRecipe.MAX_OUTPUTS; i++) {
                    var stackHere = tile.outputItems.getStackInSlot(FoundryBE.SLOT_OUTPUT0 + i);
                    ItemStack outAttempt;
                    if (i < recipe.results.size()) {
                        outAttempt = recipe.results.get(i);
                    } else {
                        outAttempt = ItemStack.EMPTY;
                    }

                    if (!stackHere.isEmpty()
                        && (!ItemStack.isSameItemSameTags(outAttempt, stackHere)
                        || outAttempt.getCount() + stackHere.getCount() > outAttempt.getMaxStackSize())) {
                        outMatches = false;
                        break;
                    }
                }
                if (outMatches) {
                    recipeOk = true;
                }

            }

            if (recipeOk) {
                tile.progress += 1;
                if (tile.progress > tile.maxProgress) {
                    tile.progress = 0;

                    for (int i = 0; i < FoundryRecipe.MAX_INPUTS; i++) {
                        tile.inputItems.getStackInSlot(FoundryBE.SLOT_INPUT0 + i).shrink(1);
                    }
                    for (int i = 0; i < recipe.results.size(); i++) {
                        var stackHere = tile.outputItems.getStackInSlot(FoundryBE.SLOT_OUTPUT0 + i);
                        var outAttempt = recipe.results.get(i);
                        if (stackHere.isEmpty()) {
                            tile.outputItems.setStackInSlot(FoundryBE.SLOT_OUTPUT0 + i, outAttempt.copy());
                        } else {
                            stackHere.grow(outAttempt.getCount());
                        }
                    }

                }
            }
        }

        if (!recipeOk) {
            tile.progress = 0;
        }
    }

    /**
     * Scan the input slots and get the recipe it looks like the player is trying to do.
     * <p>
     * The index to {@code getItem} is 0-based, 0 is the first input slot.
     */
    @Nullable
    public static FoundryRecipe getAttemptedRecipe(List<FoundryRecipe> recipes, IntFunction<ItemStack> getItem) {
        for (var recipe : recipes) {
            if (recipeMatches(recipe, getItem)) {
                return recipe;
            }
        }
        return null;
    }

    public static boolean recipeMatches(FoundryRecipe recipe, IntFunction<ItemStack> getItem) {
        // Make sure each ingredient is satisfied exactly once
        int usedBitmask = 0;
        int satisfiedCount = 0;
        for (var ingr : recipe.ingredients) {
            for (int i = 0; i < FoundryRecipe.MAX_INPUTS; i++) {
                if ((usedBitmask & (1 << i)) != 0) {
                    continue;
                }
                var stack = getItem.apply(i);
                if (ingr.test(stack)) {
                    usedBitmask |= (1 << i);
                    satisfiedCount += 1;
                }
            }
        }
        return satisfiedCount == recipe.ingredients.size();
    }


}
