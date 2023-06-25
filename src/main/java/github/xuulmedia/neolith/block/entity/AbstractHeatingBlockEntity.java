package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.block.workstation.ForgeBlock;
import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import github.xuulmedia.neolith.util.HeatingFuelContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public abstract class AbstractHeatingBlockEntity extends BlockEntity implements MenuProvider  {
    public static final int ROOM_TEMP = 30;
    public static final int MAX_HEAT = 2100;
    public static final int DELTA_HEAT_UP = 1;
    public static final int DELTA_HEAT_COOL = 3;
    public static final int DELTA_HEAT_COLD = 5;

    public static final int INDEX_HEAT = 0, INDEX_TARGET_HEAT = 1,
            INDEX_FUEL_LEFT = 2, INDEX_MAX_FUEL_LEFT = 3,
            INDEX_PROGRESS = 4, INDEX_MAX_PROGRESS = 5;

    private static final String TAG_INVENTORY = "inventory";
    private static final String TAG_INPUT_INVENTORY = "inputInventory";
    private static final String TAG_OUTPUT_INVENTORY = "outputInventory";
    private static final String TAG_FUEL_INVENTORY = "fuelInventory";
    private static final String TAG_HEAT = "heat";
    private static final String TAG_TARGET_HEAT = "targetHeat";
    private static final String TAG_FUEL_LEFT = "fuelLeft";
    private static final String TAG_MAX_FUEL_LEFT = "maxFuelLeft";
    private static final String TAG_PROGRESS = "progress";
    private static final String TAG_MAX_PROGRESS = "maxProgress";

//    protected ItemStackHandler items;
    protected ItemStackHandler inputItems;
    protected ItemStackHandler outputItems;
    protected ItemStackHandler fuelItems;
    protected LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected LazyOptional<IItemHandler> inputItemHandler = LazyOptional.empty();;
    protected LazyOptional<IItemHandler> outputItemHandler = LazyOptional.empty();;
    protected LazyOptional<IItemHandler> fuelItemHandler = LazyOptional.empty();;

    protected final ContainerData data;
    public int heat = 0;
    public int targetHeat = 0;

    public int fuelTicksLeft = 0;
    public int maxFuelTicksLeft = -1; // -1 for no fuel

    public int progress = 0;
    public int maxProgress = 20 * 10;


    public AbstractHeatingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState pBlockState) {
        super(type, pos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                var it = AbstractHeatingBlockEntity.this;
                return switch (index) {
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
            public void set(int index, int value) {
                var it = AbstractHeatingBlockEntity.this;
                switch (index) {
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
                return INDEX_MAX_PROGRESS + 1;
            }
        };
    }

    protected abstract int getFuelSlotIndex();


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            } else if (side == Direction.DOWN) {
                return outputItemHandler.cast();
            } else if (side == Direction.UP) {
                return fuelItemHandler.cast();
            } else {
                return inputItemHandler.cast();
            }
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.lazyItemHandler.invalidate();
        this.inputItemHandler.invalidate();
        this.fuelItemHandler.invalidate();
        this.outputItemHandler.invalidate();
    }


    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return
                ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {

        tag.put(TAG_INPUT_INVENTORY, this.inputItems.serializeNBT());
        tag.put(TAG_OUTPUT_INVENTORY, this.outputItems.serializeNBT());
        tag.put(TAG_FUEL_INVENTORY, this.fuelItems.serializeNBT());
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

        this.inputItems.deserializeNBT(tag.getCompound(TAG_INPUT_INVENTORY));
        this.outputItems.deserializeNBT(tag.getCompound(TAG_OUTPUT_INVENTORY));
        this.fuelItems.deserializeNBT(tag.getCompound(TAG_FUEL_INVENTORY));


        this.heat = tag.getInt(TAG_HEAT);
        this.targetHeat = tag.getInt(TAG_TARGET_HEAT);
        this.fuelTicksLeft = tag.getInt(TAG_FUEL_LEFT);
        this.maxFuelTicksLeft = tag.getInt(TAG_MAX_FUEL_LEFT);
        this.progress = tag.getInt(TAG_PROGRESS);
        this.maxProgress = tag.getInt(TAG_MAX_PROGRESS);
    }


//    @Override
//    public void onLoad() {
//        super.onLoad();
//        this.lazyItemHandler = LazyOptional.of(() -> this.items);
//    }

    public void drops() {
        SimpleContainer inputInv = new SimpleContainer(inputItems.getSlots());
        for (int i = 0; i < inputItems.getSlots(); i++) {
            inputInv.setItem(i, inputItems.getStackInSlot(i));
        }
        SimpleContainer outputInv = new SimpleContainer(outputItems.getSlots());
        for (int i = 0; i < outputItems.getSlots(); i++) {
            outputInv.setItem(i, outputItems.getStackInSlot(i));
        }
        SimpleContainer fuelInv = new SimpleContainer(fuelItems.getSlots());
        for (int i = 0; i < fuelItems.getSlots(); i++) {
            fuelInv.setItem(i, fuelItems.getStackInSlot(i));
        }

//        CompoundContainer inv = new CompoundContainer(inputInv,outputInv);
//        CompoundContainer inventory = new CompoundContainer(inv,fuelInv);


        Containers.dropContents(this.level, this.worldPosition, inputInv);
        Containers.dropContents(this.level, this.worldPosition, outputInv);
        Containers.dropContents(this.level, this.worldPosition, fuelInv);
    }

    public static void tickHeat(Level world, BlockPos pos, BlockState state, AbstractHeatingBlockEntity tile,
                                HeatingFuelContainer ersatzInv) {
        var recman = world.getRecipeManager();

        if (tile.fuelTicksLeft > 0) {
            tile.fuelTicksLeft--;
        } else {
            var fuelMatch = recman.getRecipeFor(HeatingFuelRecipe.Type.INSTANCE, ersatzInv, world);
            if (fuelMatch.isPresent()) {
                var fuel = fuelMatch.get();
                tile.fuelItems.getStackInSlot(tile.getFuelSlotIndex()).shrink(1);
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

        var newLit = tile.fuelTicksLeft > 0;
        if (newLit != state.getValue(ForgeBlock.LIT)) {
            world.setBlockAndUpdate(pos, state.setValue(ForgeBlock.LIT, newLit));
        }

        tile.setChanged();
    }

    @Nonnull
    protected ItemStackHandler createItemHandler(int slotCount) {
        return new ItemStackHandler(slotCount) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        };
    }


    public ItemStackHandler getInputItems() {
        return inputItems;
    }

    public ItemStackHandler getOutputItems() {
        return outputItems;
    }

    public ItemStackHandler getFuelItems() {
        return fuelItems;
    }
}
