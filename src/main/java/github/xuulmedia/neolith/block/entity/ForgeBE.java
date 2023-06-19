package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.menu.ForgeMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.recipe.ForgeRecipe;
import github.xuulmedia.neolith.util.HeatingFuelContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;

public class ForgeBE extends AbstractHeatingBlockEntity implements MenuProvider {
    public static final String DISPLAY_NAME = "Forge";
    public static final int SLOT_INPUT = 0;
    public static final int SLOT_FUEL = 1;
    public static final int SLOT_OUTPUT = 2;

    public static final int STACK_SIZE = 3; // this must be a match with the number in the block MENU


    public ForgeBE(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.FORGE.get(), pWorldPosition, pBlockState);
        this.itemHandler = new ItemStackHandler(STACK_SIZE) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
    }

    @Override
    protected int getFuelSlotIndex() {
        return SLOT_FUEL;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new ForgeMenu(pContainerId, pInventory, this, this.data);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME);
    }


    public static void tick(Level level, BlockPos pos, BlockState state, ForgeBE forgeBE) {
        HeatingFuelContainer ersatzInv = new HeatingFuelContainer(forgeBE.itemHandler.getSlots()) {
            @Override
            public int getFuelSlot() {
                return SLOT_FUEL;
            }
        };
        for (int i = 0; i < forgeBE.itemHandler.getSlots(); i++) {
            ersatzInv.setItem(i, forgeBE.itemHandler.getStackInSlot(i));
        }

        RecipeManager recipeManager = level.getRecipeManager();
        RecipeType<ForgeRecipe> type = ForgeRecipe.Type.INSTANCE;
        Optional<ForgeRecipe> match = recipeManager.getRecipeFor(type, ersatzInv, level);

        AbstractHeatingBlockEntity.tickHeat(level, pos, state, forgeBE, ersatzInv);
        ItemStack currentOutputStack = forgeBE.itemHandler.getStackInSlot(SLOT_OUTPUT);

        boolean recipeOk = false;
        if(match.isPresent()){
            ForgeRecipe recipe = match.get();
            if(recipe.getIngredient().test(currentOutputStack)
                    && canInsertItemIntoOutputSlot(forgeBE, match.get().getResultItem(level.registryAccess()))
                    && isHeatHighEnough(forgeBE, match)){
                recipeOk = true;
            }
        }

        if(recipeOk){
            forgeBE.progress++;
            if(forgeBE.progress > forgeBE.maxProgress) {
                forgeBE.progress = 0;
                if(currentOutputStack.isEmpty()){
                    forgeBE.itemHandler.setStackInSlot(SLOT_OUTPUT, match.get().getResultItem(level.registryAccess()));
                } else if(canInsertItemIntoOutputSlot(forgeBE, match.get().getResultItem(level.registryAccess())) && canInsertAmountIntoOutputSlot(ersatzInv)){
                    currentOutputStack.grow(1);
                }
                forgeBE.itemHandler.getStackInSlot(SLOT_INPUT).shrink(1);
           }

        }
    }


    private static boolean hasRecipe(ForgeBE entity, Level level, HeatingFuelContainer container) {
        Optional<ForgeRecipe> match = level.getRecipeManager()
                .getRecipeFor(ForgeRecipe.Type.INSTANCE, container, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(container)
                && canInsertItemIntoOutputSlot(entity, match.get().getResultItem(level.registryAccess()))
                && isHeatHighEnough(entity, match);
    }

    private static boolean canInsertItemIntoOutputSlot(ForgeBE entity, ItemStack resultItem){
        return entity.itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty() || entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getItem() == resultItem.getItem();
    }
    private static boolean canInsertAmountIntoOutputSlot(HeatingFuelContainer  container) {
        return container.getItem(SLOT_OUTPUT).getMaxStackSize() > container.getItem(SLOT_OUTPUT).getCount();
    }

    private static boolean isHeatHighEnough(ForgeBE entity, Optional<ForgeRecipe> match){
      return  match.get().getHeatRequired() <= entity.heat;
    }




//    @Nullable
//    public static ForgeRecipe getAttemptedRecipe(List<ForgeRecipe> recipes, IntFunction<ItemStack> getItem) {
//        for (var recipe : recipes) {
//            if (recipeMatches(recipe, getItem)) {
//                return recipe;
//            }
//        }
//        return null;
//    }
//
//    public static boolean recipeMatches(ForgeRecipe recipe, IntFunction<ItemStack> getItem) {
//        // Make sure each ingredient is satisfied exactly once
//        int usedBitmask = 0;
//        int satisfiedCount = 0;
//        for (var ingr : recipe.getIngredients()) {
//            for (int i = 0; i < 1; i++) {
//                if ((usedBitmask & (1 << i)) != 0) {
//                    continue;
//                }
//                var stack = getItem.apply(i);
//                if (ingr.test(stack)) {
//                    usedBitmask |= (1 << i);
//                    satisfiedCount += 1;
//                }
//            }
//        }
//        return satisfiedCount == recipe.getIngredients().size();
//    }
}
