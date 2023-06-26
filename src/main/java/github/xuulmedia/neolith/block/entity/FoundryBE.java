package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.menu.FoundryMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.recipe.FoundryRecipe;
import github.xuulmedia.neolith.util.AdaptedItemHandler;
import github.xuulmedia.neolith.util.HeatingFuelContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.IntFunction;

public class FoundryBE extends AbstractHeatingBlockEntity implements MenuProvider {
    public static final String DISPLAY_NAME = "Foundry";

    public static final int SLOT_INPUT = 0;
    public static final int SLOT_INPUT_COUNT = 3;

    public static final int SLOT_FUEL = 0;
    public static final int SLOT_FUEL_COUNT = 1;

    public static final int SLOT_RESULT = 0;
    public static final int SLOT_RESULT_COUNT = 2;
    public static final int SLOT_COUNT = SLOT_INPUT_COUNT + SLOT_FUEL_COUNT + SLOT_RESULT_COUNT;


    public FoundryBE(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FOUNDRY.get(), pPos, pBlockState);
        this.inputItems = createItemHandler(SLOT_INPUT_COUNT);
        this.fuelItems = createItemHandler(SLOT_FUEL_COUNT);
        this.resultItems = createItemHandler(SLOT_RESULT_COUNT);
        this.lazyItemHandler = LazyOptional.of(() -> new CombinedInvWrapper(inputItems, resultItems, fuelItems));


        this.inputItemHandler = LazyOptional.of(() -> new AdaptedItemHandler(inputItems) {
            @Override
            public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
                return ItemStack.EMPTY;
            }
        });

        this.resultItemHandler = LazyOptional.of(() -> new AdaptedItemHandler(resultItems) {
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


    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory pPlayerInventory, Player pPlayer) {
        return new FoundryMenu(id, pPlayerInventory, this, this.data);
    }

    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME);
    }


    public static void tick(Level level, BlockPos pos, BlockState state, FoundryBE entity) {
        HeatingFuelContainer heatContainer = new HeatingFuelContainer(entity.fuelItems.getSlots()) {
            @Override
            public int getFuelSlot() {
                return SLOT_FUEL;
            }
        };
        for (int i = 0; i < entity.fuelItems.getSlots(); i++) {
            heatContainer.setItem(i, entity.fuelItems.getStackInSlot(i));
        }
        SimpleContainer inputContainer = new SimpleContainer(entity.inputItems.getSlots());
        for (int i = 0; i < entity.inputItems.getSlots(); i++) {
            inputContainer.setItem(i, entity.inputItems.getStackInSlot(i));
        }

        RecipeManager recipeManager = level.getRecipeManager();
        RecipeType<FoundryRecipe> type = FoundryRecipe.Type.INSTANCE;
        Optional<FoundryRecipe> match = recipeManager.getRecipeFor(type, inputContainer, level);

        AbstractHeatingBlockEntity.tickHeat(level, pos, state, entity, heatContainer);

        SimpleContainer resultContainer = new SimpleContainer(entity.resultItems.getSlots());
        for (int i = 0; i < entity.resultItems.getSlots(); i++) {
            inputContainer.setItem(i, entity.resultItems.getStackInSlot(i));
        }


        boolean recipeOk = false;
        if (match.isPresent()) {
            FoundryRecipe recipe = match.get();
            int resultSlotsNeeded = getRequiredNumberOfOutputSlots(recipe);

            if (recipeMatches(recipe, index -> entity.inputItems.getStackInSlot(FoundryBE.SLOT_INPUT + index))
                    && recipe.getHeatRequired() <= entity.heat) {
                boolean outMatches = true;

                for (int i = 0; i < SLOT_RESULT_COUNT - 1; i++) {
                    ItemStack stackHere = entity.resultItems.getStackInSlot(FoundryBE.SLOT_RESULT);
                    ItemStack outAttempt;
                    if (i < recipe.getResultSize()) {
                        outAttempt = recipe.getResultInSlot(i);
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
                if (recipeOk) {
                    entity.progress += 1;
                    if (entity.progress > entity.maxProgress) {
                        entity.progress = 0;

                        for (int i = 0; i < SLOT_INPUT_COUNT - 1; i++) {
                            entity.inputItems.getStackInSlot(FoundryBE.SLOT_INPUT + i).shrink(1);
                        }
                        for (int i = 0; i < recipe.getResultSize(); i++) {
                            ItemStack stackHere = entity.resultItems.getStackInSlot(FoundryBE.SLOT_RESULT + i);
                            ItemStack outAttempt = recipe.getResultInSlot(i);
                            if (stackHere.isEmpty()) {
                                entity.resultItems.setStackInSlot(FoundryBE.SLOT_RESULT + i, outAttempt.copy());
                            } else {
                                stackHere.grow(outAttempt.getCount());
                            }
                        }
                    }
                }
            }
        }
        if (!recipeOk) {
            entity.progress = 0;
        }
    }

    private static int getRequiredNumberOfOutputSlots(FoundryRecipe recipe){
        return recipe.getResultSize();
    }

    private static int getNumOfIngredientTypes(FoundryRecipe recipe){
        return recipe.getIngredientSize();
    }

    public static boolean recipeMatches(FoundryRecipe recipe, IntFunction<ItemStack> getItem) {
        List<Ingredient> recipeIngredients = new ArrayList<>(recipe.getIngredients());
        Set<Integer> usedSlots = new HashSet<>();

        for (Ingredient ingredient : recipeIngredients) {
            boolean isSatisfied = false;
            for (int i = 0; i < SLOT_INPUT_COUNT; i++) {
                if (usedSlots.contains(i)) {
                    continue;
                }
                ItemStack stack = getItem.apply(i);
                if (stack.isEmpty()) { // check if slot is empty
                    continue;
                }
                if (ingredient.test(stack)) {
                    usedSlots.add(i);
                    isSatisfied = true;
                    break;
                }
            }
            if (!isSatisfied) {
                return false;
            }
        }

        // Check if there are extra items in the slots
        for (int i = 0; i < SLOT_INPUT_COUNT; i++) {
            ItemStack stack = getItem.apply(i);
            if (!stack.isEmpty() && !usedSlots.contains(i)) {
                return false; // There is an extra item in the slots
            }
        }

        return true;
    }

}
