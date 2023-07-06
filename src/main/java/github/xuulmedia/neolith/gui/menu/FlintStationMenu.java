package github.xuulmedia.neolith.gui.menu;

import com.google.common.collect.Lists;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.init.ModRecipes;
import github.xuulmedia.neolith.recipe.FlintStationRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

import static github.xuulmedia.neolith.block.entity.ForgeBE.*;

public class FlintStationMenu extends AbstractNeolithMenu {
    private final Level level;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private List<FlintStationRecipe> recipes = Lists.newArrayList();

    private ItemStack input = ItemStack.EMPTY;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {
    };
    public static final int STACK_SIZE = 1;

    public final Container container = new SimpleContainer(1) {
        public void setChanged() {
            super.setChanged();
            FlintStationMenu.this.slotsChanged(this);
            FlintStationMenu.this.slotUpdateListener.run();
        }
    };
    final ResultContainer resultContainer = new ResultContainer();

    public FlintStationMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf extraData) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public FlintStationMenu(int pContainerId, Inventory inventory, final ContainerLevelAccess pAccess) {
        super(ModMenuTypes.FLINT_STATION_MENU.get(), pContainerId);
        this.access = pAccess;
        this.level = inventory.player.level();





        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            public boolean mayPlace(ItemStack p_40362_) {
                return false;
            }

            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                FlintStationMenu.this.resultContainer.awardUsedRecipes(player, this.getRelevantItems());
                ItemStack itemstack = FlintStationMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    FlintStationMenu.this.setupResultSlot();
                }
                super.onTake(player, stack);
            }

            private List<ItemStack> getRelevantItems() {
                return List.of(FlintStationMenu.this.inputSlot.getItem());
            }
        });

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.addDataSlot(this.selectedRecipeIndex);
    }


    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<FlintStationRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }


    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access, pPlayer, ModBlocks.FLINT_STATION.get());
    }

    public boolean clickMenuButton(Player pPlayer, int pId) {
        if (this.isValidRecipeIndex(pId)) {
            this.selectedRecipeIndex.set(pId);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int pRecipeIndex) {
        return pRecipeIndex >= 0 && pRecipeIndex < this.recipes.size();
    }

    public void slotsChanged(Container pInventory) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(pInventory, itemstack);
        }

    }

    private void setupRecipeList(Container pContainer, ItemStack pStack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!pStack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(FlintStationRecipe.Type.INSTANCE, pContainer, this.level);
        }

    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            FlintStationRecipe flintStationRecipe = this.recipes.get(this.selectedRecipeIndex.get());
            ItemStack itemstack = flintStationRecipe.assemble(this.container, this.level.registryAccess());

            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(flintStationRecipe);
                this.resultSlot.set(itemstack);
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
                this.resultSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public void registerUpdateListener(Runnable pListener) {
        this.slotUpdateListener = pListener;
    }

    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> {
            this.clearContainer(pPlayer, this.container);
        });
    }




    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        Slot sourceSlot = this.slots.get(index);
        if (sourceSlot.hasItem()) {
            ItemStack sourceStack = sourceSlot.getItem();
            returnStack = sourceStack.copy();

            if (index == 1) { // If the source slot is the output slot
                sourceStack.getItem().onCraftedBy(sourceStack, player.level(), player);
                if (!moveItemStackTo(sourceStack, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
                sourceSlot.onQuickCraft(sourceStack, returnStack);
            } else if (index == 0) {
                if (!moveItemStackTo(sourceStack, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(FlintStationRecipe.Type.INSTANCE, new SimpleContainer(sourceStack), this.level).isPresent()) {
                if (!moveItemStackTo(sourceStack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!moveItemStackTo(sourceStack, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38) {
                if (!moveItemStackTo(sourceStack, 2, 29, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (sourceStack.isEmpty()) {
                sourceSlot.set(ItemStack.EMPTY);
            } else {
                sourceSlot.setChanged();
            }

            if (sourceStack.getCount() == returnStack.getCount()) {
                return ItemStack.EMPTY;
            }

            sourceSlot.onTake(player, sourceStack);
            this.broadcastChanges();
        }

        return returnStack;
    }


}
