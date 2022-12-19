package ca.xuul.flint.block.entity;

import ca.xuul.flint.gui.FoundryMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ca.xuul.flint.block.FoundryBlock;
import ca.xuul.flint.init.ModBlockEntities;
import ca.xuul.flint.recipe.FoundryFuelRecipe;
import ca.xuul.flint.recipe.FoundryRecipe;

public class FoundryBlockEntity extends BlockEntity implements MenuProvider {
    public static final int ROOM_TEMP = 30;
    public static final int MAX_HEAT = 2100;
    public static final int DELTA_HEAT_UP = 1;
    public static final int DELTA_HEAT_COOL = 3;
    public static final int DELTA_HEAT_COLD = 5;

    public static final int IDX_HEAT = 0, IDX_TARGET_HEAT = 1,
        IDX_FUEL_LEFT = 2, IDX_MAX_FUEL_LEFT = 3,
        IDX_PROGRESS = 4, IDX_MAX_PROGRESS = 5;

    private static final String TAG_INVENTORY = "inventory",
        TAG_HEAT = "foundry.heat",
        TAG_TARGET_HEAT = "foundry.targetHeat",
        TAG_FUEL_LEFT = "foundry.fuelLeft",
        TAG_MAX_FUEL_LEFT = "foundry.maxFuelLeft",
        TAG_PROGRESS = "foundry.progress",
        TAG_MAX_PROGRESS = "foundry.maxProgress";

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    public int heat = 0;
    public int targetHeat = 0;

    public int fuelTicksLeft = 0;
    public int maxFuelTicksLeft = -1; // -1 for no fuel

    public int progress = 0;
    public int maxProgress = 20 * 10;


    public FoundryBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.FOUNDRY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int idx) {
                var it = FoundryBlockEntity.this;
                return switch (idx) {
                    case 0 -> it.heat;
                    case 1 -> it.targetHeat;
                    case 2 -> it.fuelTicksLeft;
                    case 3 -> it.maxFuelTicksLeft;
                    case 4 -> it.progress;
                    case 5 -> it.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int idx, int value) {
                var it = FoundryBlockEntity.this;
                switch (idx) {
                    case 0 -> it.heat = value;
                    case 1 -> it.targetHeat = value;
                    case 2 -> it.fuelTicksLeft = value;
                    case 3 -> it.maxFuelTicksLeft = value;
                    case 4 -> it.progress = value;
                    case 5 -> it.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return IDX_MAX_PROGRESS + 1;
            }
        };
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

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.lazyItemHandler = LazyOptional.of(() -> this.itemHandler);
    }


    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put(TAG_INVENTORY, this.itemHandler.serializeNBT());
        tag.putInt(TAG_HEAT, this.heat);
        tag.putInt(TAG_TARGET_HEAT, this.targetHeat);
        tag.putInt(TAG_FUEL_LEFT, this.fuelTicksLeft);
        tag.putInt(TAG_MAX_FUEL_LEFT, this.maxFuelTicksLeft);
        tag.putInt(TAG_PROGRESS, this.progress);
        tag.putInt(TAG_MAX_PROGRESS, this.maxProgress);

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.itemHandler.deserializeNBT(tag.getCompound(TAG_INVENTORY));
        this.heat = tag.getInt(TAG_HEAT);
        this.targetHeat = tag.getInt(TAG_TARGET_HEAT);
        this.fuelTicksLeft = tag.getInt(TAG_FUEL_LEFT);
        this.maxFuelTicksLeft = tag.getInt(TAG_MAX_FUEL_LEFT);
        this.progress = tag.getInt(TAG_PROGRESS);
        this.maxProgress = tag.getInt(TAG_MAX_PROGRESS);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level world, BlockPos pos, BlockState state, FoundryBlockEntity tile) {
        var ersatzInv = new SimpleContainer(tile.itemHandler.getSlots());
        for (int i = 0; i < tile.itemHandler.getSlots(); i++) {
            ersatzInv.setItem(i, tile.itemHandler.getStackInSlot(i));
        }
        var recman = world.getRecipeManager();

        if (tile.fuelTicksLeft > 0) {
            tile.fuelTicksLeft--;
        } else {
            var fuelMatch = recman.getRecipeFor(FoundryFuelRecipe.Type.INSTANCE, ersatzInv, world);
            if (fuelMatch.isPresent()) {
                var fuel = fuelMatch.get();
                tile.itemHandler.getStackInSlot(FoundryMenu.FUEL_SLOT).shrink(1);
                tile.targetHeat = fuel.maxHeat;
                tile.fuelTicksLeft = tile.maxFuelTicksLeft = fuel.burnTime;
            } else {
                tile.targetHeat = ROOM_TEMP;
                tile.fuelTicksLeft = 0;
                tile.maxFuelTicksLeft = -1;
            }
        }

        var delta = Mth.clamp(tile.targetHeat - tile.heat,
            -(tile.maxFuelTicksLeft >= 0 ? DELTA_HEAT_COOL : DELTA_HEAT_COLD),
            DELTA_HEAT_UP);
        tile.heat += delta;

        var recipeMatch = recman.getRecipeFor(FoundryRecipe.Type.INSTANCE, ersatzInv, world);
        var presentOutputStack = tile.itemHandler.getStackInSlot(FoundryMenu.OUTPUT_SLOT);
        var recipeOk = false;
        if (recipeMatch.isPresent()) {
            var recipe = recipeMatch.get();

            if (recipe.input.test(tile.itemHandler.getStackInSlot(FoundryMenu.INPUT_SLOT))
                && recipe.heat <= tile.heat
                && (presentOutputStack.isEmpty() || recipe.output.sameItem(presentOutputStack))
                && presentOutputStack.getMaxStackSize() >= presentOutputStack.getCount() + recipe.output.getCount()) {
                recipeOk = true;
            }
        }
        if (recipeOk) {
            tile.progress += 1;
            if (tile.progress > tile.maxProgress) {
                tile.progress = 0;
                if (presentOutputStack.isEmpty()) {
                    tile.itemHandler.setStackInSlot(FoundryMenu.OUTPUT_SLOT, recipeMatch.get().getResultItem());
                } else {
                    presentOutputStack.grow(recipeMatch.get().getResultItem().getCount());
                }
                tile.itemHandler.getStackInSlot(FoundryMenu.INPUT_SLOT).shrink(1);
            }
        } else {
            tile.progress = 0;
        }

        var newLit = tile.fuelTicksLeft > 0;
        if (newLit != state.getValue(FoundryBlock.LIT)) {
            world.setBlockAndUpdate(pos, state.setValue(FoundryBlock.LIT, newLit));
        }

        tile.setChanged();
    }
}
