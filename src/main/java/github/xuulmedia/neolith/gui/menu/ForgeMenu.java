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
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static github.xuulmedia.neolith.block.entity.ForgeBE.*;

public class ForgeMenu extends AbstractNeolithMenu {
    public final ForgeBE blockEntity;
    private final Level level;
    private final ContainerData data;


    private final List<HeatingFuelRecipe> fuels;
    private final List<ForgeRecipe> recipes;

    public ForgeMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, inventory.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(6));
    }

    public ForgeMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.FORGE_MENU.get(), id);

        checkContainerSize(inventory, ForgeBE.SLOT_COUNT);
        blockEntity = (ForgeBE) entity;
        this.level = inventory.player.level();
        this.data = data;

        this.addSlot(new SlotItemHandler(blockEntity.getInputItems(), ForgeBE.SLOT_INPUT, 56, 17));
        this.addSlot(new SlotItemHandler(blockEntity.getFuelItems(), ForgeBE.SLOT_FUEL, 56, 53));
        this.addSlot(new SlotItemHandler(blockEntity.getResultItems(), ForgeBE.SLOT_RESULT, 116, 35));

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.addDataSlots(data);


        RecipeManager recipeManager = this.level.getRecipeManager();
        this.fuels = recipeManager.getAllRecipesFor(HeatingFuelRecipe.Type.INSTANCE);
        this.recipes = recipeManager.getAllRecipesFor(ForgeRecipe.Type.INSTANCE);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), pPlayer, ModBlocks.FORGE.get());
    }

    public float fuelProportion() {
        var maxFuel = this.data.get(ForgeBE.INDEX_MAX_FUEL_LEFT);
        if (maxFuel < 0) {
            return 0f;
        }

        return (float) this.data.get(ForgeBE.INDEX_FUEL_LEFT) / (float) maxFuel;
    }

    public float progressProportion() {
        var maxProgress = this.data.get(ForgeBE.INDEX_MAX_PROGRESS);
        if (maxProgress < 0) {
            return 0f;
        }

        return (float) this.data.get(ForgeBE.INDEX_PROGRESS) / (float) maxProgress;
    }

    public float heatProportion() {
        return (float) this.data.get(ForgeBE.INDEX_HEAT) / (float) ForgeBE.MAX_HEAT;
    }

    public int heat() {
        return this.data.get(ForgeBE.INDEX_HEAT);
    }

    public int targetHeat() {
        return this.data.get(ForgeBE.INDEX_TARGET_HEAT);
    }

    public boolean isBurningFuel() {
        return this.data.get(ForgeBE.INDEX_MAX_FUEL_LEFT) >= 0;
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
        ItemStack input = this.getSlot(ForgeBE.SLOT_INPUT).getItem();
        if (input.isEmpty()) {
            return null;
        }
        for (var recipe : this.recipes) {
            return recipe.getHeatRequired();
        }
        return null;
    }

//TODO this is mostly fixed now just to make fuel work!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        Slot sourceSlot = this.slots.get(index);
        if (sourceSlot.hasItem()) {
            ItemStack sourceStack = sourceSlot.getItem();
            returnStack = sourceStack.copy(); // need to copy

            //Check if we are clicking a mod slot or vanilla inventory
            if (index < SLOT_COUNT) {
                //This is a vanilla container so we move to the BE inventory
                if (!moveItemStackTo(sourceStack, SLOT_COUNT, Inventory.INVENTORY_SIZE + SLOT_COUNT, true)) {
                    return ItemStack.EMPTY;
                }
            }

            // Here we pick where to move items into FROM the player inventory
            if (!this.moveItemStackTo(sourceStack, SLOT_INPUT, SLOT_INPUT + SLOT_INPUT_COUNT, false)) {
                return ItemStack.EMPTY;
            }

            // If stack size == 0 (the entire stack was moved) set slot contents to null
            if (sourceStack.getCount() == 0) {
                sourceSlot.set(ItemStack.EMPTY);
            } else {
                sourceSlot.setChanged();
            }
            sourceSlot.onTake(playerIn, sourceStack);

        }
        return returnStack;
    }
}


