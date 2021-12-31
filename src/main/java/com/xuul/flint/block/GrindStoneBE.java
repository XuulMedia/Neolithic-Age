package com.xuul.flint.block;

import com.xuul.flint.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class GrindStoneBE extends BlockEntity {

    public static final int INPUT_SLOTS = 1;
    public static final int OUTPUT_SLOTS = 1;
    public static final int GRINDTIME = 10;

    // A direct reference to our items and energy for easy access inside our block entity
    // LazyOptionals to return with getCapability()
    private final ItemStackHandler inputItems = createInputItemHandler();
    private final LazyOptional<IItemHandler> inputItemHandler = LazyOptional.of(() -> inputItems);
    private final ItemStackHandler outputItems = createOutputItemHandler();
    private final LazyOptional<IItemHandler> outputItemHandler = LazyOptional.of(() -> outputItems);
    private final LazyOptional<IItemHandler> combinedItemHandler = LazyOptional.of(this::createCombinedItemHandler);

    private int counter;

    public GrindStoneBE(BlockPos pos, BlockState state) {
        super(ModBlocks.GRINDSTONE_BE.get(), pos, state);
    }


    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == null) {
                return combinedItemHandler.cast();
            } else if (side == Direction.DOWN) {
                return outputItemHandler.cast();
            } else {
                return inputItemHandler.cast();
            }
        } else {
            return super.getCapability(cap, side);
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        inputItemHandler.invalidate();
        outputItemHandler.invalidate();
        combinedItemHandler.invalidate();
    }



/*calls setChanged when the contents are changed so MC knows to save the block contents*/
    @Nonnull
    private ItemStackHandler createInputItemHandler() {
        return new ItemStackHandler(INPUT_SLOTS) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @NotNull
            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                return ItemStack.EMPTY;
            }
        };
    }

    @Nonnull
    private ItemStackHandler createOutputItemHandler() {
        return new ItemStackHandler(OUTPUT_SLOTS) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
    }

    @Nonnull
    private IItemHandler createCombinedItemHandler() {
        return new CombinedInvWrapper(inputItems, outputItems) {
            @NotNull
            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                return ItemStack.EMPTY;
            }

            @NotNull
            @Override
            public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
                return stack;
            }
        };
    }



}
