package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.menu.FoundryMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.recipe.FoundryRecipe;
import github.xuulmedia.neolith.util.HeatingFuelContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class FoundryBlockEntity extends AbstractHeatingBlockEntity implements MenuProvider {
    public static final int SLOT_INPUT = 0;
    public static final int SLOT_FUEL = 1;
    public static final int SLOT_OUTPUT = 2;

    public static final int STACK_SIZE = 3; // this must be a match with the number in the block MENU


    public FoundryBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.FOUNDRY.get(), pWorldPosition, pBlockState);
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
        return new FoundryMenu(pContainerId, pInventory, this, this.data);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("Foundry");
    }


    public static void tick(Level world, BlockPos pos, BlockState state, FoundryBlockEntity tile) {
        var ersatzInv = new HeatingFuelContainer(tile.itemHandler.getSlots()) {
            @Override
            public int getFuelSlot() {
                return SLOT_FUEL;
            }
        };
        for (int i = 0; i < tile.itemHandler.getSlots(); i++) {
            ersatzInv.setItem(i, tile.itemHandler.getStackInSlot(i));
        }

        AbstractHeatingBlockEntity.tickHeat(world, pos, state, tile, ersatzInv);

        var recman = world.getRecipeManager();

        var recipeMatch = recman.getRecipeFor(FoundryRecipe.Type.INSTANCE, ersatzInv, world);
        var presentOutputStack = tile.itemHandler.getStackInSlot(SLOT_OUTPUT);
        var recipeOk = false;
        if (recipeMatch.isPresent()) {
            var recipe = recipeMatch.get();

            if (recipe.input.test(tile.itemHandler.getStackInSlot(SLOT_INPUT))
                    && recipe.heat <= tile.heat
                    && (presentOutputStack.isEmpty() || recipe.output.is(presentOutputStack.getItem()))
                    && presentOutputStack.getMaxStackSize() >= presentOutputStack.getCount() + recipe.output.getCount()) {
                recipeOk = true;
            }
        }
        if (recipeOk) {
            tile.progress += 1;
            if (tile.progress > tile.maxProgress) {
                tile.progress = 0;
                if (presentOutputStack.isEmpty()) {
                    tile.itemHandler.setStackInSlot(SLOT_OUTPUT, recipeMatch.get().output);
                } else {
                    presentOutputStack.grow(recipeMatch.get().output.getCount());
                }
                tile.itemHandler.getStackInSlot(SLOT_INPUT).shrink(1);
            }
        } else {
            tile.progress = 0;
        }
    }
}
