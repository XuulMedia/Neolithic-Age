package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.block.entity.FoundryBE;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.ForgeRecipe;
import github.xuulmedia.neolith.recipe.FoundryRecipe;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static github.xuulmedia.neolith.block.entity.FoundryBE.SLOT_COUNT;
import static github.xuulmedia.neolith.block.entity.FoundryBE.SLOT_INPUT;
import static github.xuulmedia.neolith.block.entity.FoundryBE.SLOT_INPUT_COUNT;
import static github.xuulmedia.neolith.block.entity.FoundryBE.SLOT_RESULT_COUNT;

public class FoundryMenu extends AbstractHeatCookMenu {
    public final FoundryBE blockEntity;
    private final Level level;
    private final List<FoundryRecipe> recipes;

    public FoundryMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public FoundryMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FOUNDRY_MENU.get(), id, data);

        checkContainerSize(inventory, FoundryBE.SLOT_COUNT);
        this.blockEntity = (FoundryBE) entity;
        this.level = inventory.player.level();

        addSlotRange(blockEntity.getInputItems(), SLOT_INPUT_COUNT, 38, 18, 18);

        this.addSlot(new SlotItemHandler(blockEntity.getFuelItems(), ForgeBE.SLOT_FUEL, 56, 53));

        addSlotRange(blockEntity.getResultItems(), SLOT_RESULT_COUNT, 116, 35, 20);

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.addDataSlots(data);

        RecipeManager recipeManager = this.level.getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(FoundryRecipe.Type.INSTANCE);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.FOUNDRY.get());
    }

    @Override
    protected int getInputSlotsCount() {
        return SLOT_INPUT_COUNT;
    }

    @Override
    protected int getInputSlotStartIndex() {
        return FoundryBE.SLOT_INPUT;
    }

    @Override
    protected List<FoundryRecipe> getRecipes() {
        return recipes;
    }

    public @Nullable Integer heatReqdToCookInput() {
        SimpleContainer inputContainer = new SimpleContainer(blockEntity.getInputItems().getSlots());
        for (int i = 0; i < blockEntity.getInputItems().getSlots(); i++) {
            inputContainer.setItem(i, blockEntity.getInputItems().getStackInSlot(i));
        }
        if(inputContainer.isEmpty()){
            return null;
        }
        for (var recipe : this.recipes) {
            return recipe.getHeatRequired();
        }
        return null;

    }private static final int PLAYER_INVENTORY_START = SLOT_COUNT;
    private static final int PLAYER_INVENTORY_END = SLOT_COUNT + 27;
    private static final int PLAYER_HOTBAR_START = PLAYER_INVENTORY_END;
    private static final int PLAYER_HOTBAR_END = PLAYER_HOTBAR_START + 9;

    private static final int FUEL_START = 3;
    private static final int OUTPUT_START = 1;
    private static final int OUTPUT_END = OUTPUT_START + SLOT_RESULT_COUNT;

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        Slot sourceSlot = this.slots.get(index);

        if (sourceSlot != null && sourceSlot.hasItem()) {
            ItemStack sourceStack = sourceSlot.getItem();
            returnStack = sourceStack.copy();

            if (index >= PLAYER_INVENTORY_START && index < PLAYER_INVENTORY_END) {
                // Move from player inventory to foundry inputs
                if (this.isInputtable(sourceStack)) {
                    if (!this.moveItemStackTo(sourceStack, SLOT_INPUT, SLOT_INPUT + SLOT_INPUT_COUNT, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(sourceStack)) {
                    if (!this.moveItemStackTo(sourceStack, FUEL_START, FUEL_START + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(sourceStack, PLAYER_HOTBAR_START, PLAYER_HOTBAR_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= PLAYER_HOTBAR_START && index < PLAYER_HOTBAR_END) {
                // Move from player hotbar to furnace
                if (!this.moveItemStackTo(sourceStack, PLAYER_INVENTORY_START, PLAYER_INVENTORY_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(sourceStack, PLAYER_INVENTORY_START, PLAYER_HOTBAR_END, false)) {
                return ItemStack.EMPTY;
            }

            if (sourceStack.isEmpty()) {
                sourceSlot.set(ItemStack.EMPTY);
            } else {
                sourceSlot.setChanged();
            }
        }

        return returnStack;
    }

    private boolean isInputtable(ItemStack stack) {
        for (FoundryRecipe recipe : recipes) {
            if (recipe.getIngredients().stream().anyMatch(ingredient -> ingredient.test(stack))) {
                return true;
            }
        }
        return false;
    }


}
