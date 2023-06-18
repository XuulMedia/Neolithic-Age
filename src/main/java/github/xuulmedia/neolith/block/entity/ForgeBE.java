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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import org.jline.utils.Log;

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
        AbstractHeatingBlockEntity.tickHeat(level, pos, state, forgeBE, ersatzInv);

        RecipeManager recipeManager = level.getRecipeManager();
        var recipeMatch = recipeManager.getRecipeFor(ForgeRecipe.Type.INSTANCE, ersatzInv, level);
        ItemStack currentOutputStack = forgeBE.itemHandler.getStackInSlot(SLOT_OUTPUT);

        boolean recipeOk = false;
        if (recipeMatch.isPresent()) {
            var recipe = recipeMatch.get();

            if (recipe.getIngredient().test(forgeBE.itemHandler.getStackInSlot(SLOT_INPUT))
                    && recipe.getHeatRequired() <= forgeBE.heat
                    && (currentOutputStack.isEmpty() || recipe.getResult().is(currentOutputStack.getItem()))
                    && currentOutputStack.getMaxStackSize() >= currentOutputStack.getCount() + recipe.getResult().getCount()) {
                recipeOk = true;
            }
            if (recipeOk) {

                forgeBE.progress += 1;
                if (forgeBE.progress > recipeMatch.get().getCookingTime()) {
                    forgeBE.progress = 0;
                    if (currentOutputStack.isEmpty()) {
                        forgeBE.itemHandler.setStackInSlot(SLOT_OUTPUT, recipeMatch.get().getResult());
                    } else {
                        currentOutputStack.grow(recipeMatch.get().getResult().getCount());
                    }
                    forgeBE.itemHandler.getStackInSlot(SLOT_INPUT).shrink(1);
                }
            } else {
                forgeBE.progress = 0;
            }

        }
    }
}
