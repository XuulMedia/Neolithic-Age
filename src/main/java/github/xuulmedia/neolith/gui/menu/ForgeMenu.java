package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModMenuTypes;
import github.xuulmedia.neolith.recipe.ForgeRecipe;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static github.xuulmedia.neolith.block.entity.ForgeBE.*;

public class ForgeMenu extends AbstractHeatCookMenu {
    public final ForgeBE blockEntity;
    private final Level level;
    private final List<ForgeRecipe> recipes;

    public ForgeMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public ForgeMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FORGE_MENU.get(), id, data);

        checkContainerSize(inventory, ForgeBE.SLOT_COUNT);
        blockEntity = (ForgeBE) entity;
        this.level = inventory.player.level();

        this.addSlot(new SlotItemHandler(blockEntity.getInputItems(), SLOT_INPUT, 56, 17));
        this.addSlot(new SlotItemHandler(blockEntity.getFuelItems(), SLOT_FUEL, 56, 53));
        this.addSlot(new SlotItemHandler(blockEntity.getResultItems(), SLOT_RESULT, 116, 35));

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.addDataSlots(data);

        RecipeManager recipeManager = this.level.getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(ForgeRecipe.Type.INSTANCE);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.FORGE.get());
    }

    @Override
    protected int getInputSlotsCount() {
        return SLOT_INPUT_COUNT;
    }

    @Override
    protected int getInputSlotStartIndex() {
        return ForgeBE.SLOT_INPUT;
    }

    @Override
    protected List<ForgeRecipe> getRecipes() {
        return recipes;
    }


    public @Nullable Integer heatReqdToCookInput() {
        ItemStack input = this.getSlot(ForgeBE.SLOT_INPUT).getItem();
        if (input.isEmpty()) {
            return null;
        }

        for (var recipe : this.recipes) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                if (ingredient.test(input)) {
                    return recipe.getHeatRequired();
                }
            }
        }

        return null;
    }

    private static final int PLAYER_INVENTORY_START = SLOT_COUNT;
    private static final int PLAYER_INVENTORY_END = SLOT_COUNT + 27;
    private static final int PLAYER_HOTBAR_START = PLAYER_INVENTORY_END;
    private static final int PLAYER_HOTBAR_END = PLAYER_HOTBAR_START + 9;

    private static final int FUEL_START = 1;


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        Slot sourceSlot = this.slots.get(index);

        if (sourceSlot != null && sourceSlot.hasItem()) {
            ItemStack sourceStack = sourceSlot.getItem();
            returnStack = sourceStack.copy();

            if (index >= PLAYER_INVENTORY_START && index < PLAYER_INVENTORY_END) {
                // Move from player inventory to furnace inputs
                if (this.isInputtable(sourceStack)) {
                    if (!this.moveItemStackTo(sourceStack, SLOT_INPUT, SLOT_INPUT + 1, false)) {
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
        for (ForgeRecipe recipe : recipes) {
            if (recipe.getIngredient().test(stack)) {
                return true;
            }
        }
        return false;
    }


}


