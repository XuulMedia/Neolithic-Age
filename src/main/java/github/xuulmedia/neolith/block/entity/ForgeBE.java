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
            boolean ingredientTest = recipe.getIngredient().test(forgeBE.itemHandler.getStackInSlot(SLOT_INPUT));
            boolean canInsertItem = canInsertItemIntoOutputSlot(forgeBE, match.get().getResultItem(level.registryAccess()));
            boolean spaceCheck = canInsertAmountIntoOutputSlot(forgeBE);
            boolean heatCheck = isHeatHighEnough(forgeBE, match);
            if(ingredientTest && canInsertItem && heatCheck && spaceCheck){
                recipeOk = true;
            }
        }
        if(recipeOk){
            forgeBE.progress++;
            if(forgeBE.progress > forgeBE.maxProgress) {
                forgeBE.progress = 0;
                if(currentOutputStack.isEmpty()){
                    forgeBE.itemHandler.setStackInSlot(SLOT_OUTPUT, match.get().getResultItem(level.registryAccess()));
                } else{
                    currentOutputStack.grow(1);
                }
                forgeBE.itemHandler.getStackInSlot(SLOT_INPUT).shrink(1);
           }

        }
    }
    private static boolean canInsertItemIntoOutputSlot(ForgeBE entity, ItemStack resultItem){
        return entity.itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty() || entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getItem() == resultItem.getItem();
    }
    private static boolean canInsertAmountIntoOutputSlot(ForgeBE entity) {
        return entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getMaxStackSize() > entity.itemHandler.getStackInSlot(SLOT_OUTPUT).getCount();
    }

    private static boolean isHeatHighEnough(ForgeBE entity, Optional<ForgeRecipe> match){
      return  match.get().getHeatRequired() <= entity.heat;
    }

}
