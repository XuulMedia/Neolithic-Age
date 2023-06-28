package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.menu.WorkBenchMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.util.AdaptedItemHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class WorkBenchBE extends AbstractNeolithBlockEntity {
    public static final String DISPLAY_NAME = "Work Bench";
    private static final String TAG_INPUT_INVENTORY = "inputInventory";
    private static final String TAG_RESULT_INVENTORY = "resultInventory";
    private static final String TAG_STORAGE_INVENTORY = "storageInventory";



    public static final int SLOT_CRAFTING_COUNT = 9;

    public static final int SLOT_STORAGE_COUNT = 9;

    public static final int SLOT_RESULT_COUNT = 1;

    public static final int SLOT_COUNT = SLOT_RESULT_COUNT + SLOT_CRAFTING_COUNT + SLOT_STORAGE_COUNT;

    protected ItemStackHandler resultItems = createItemHandler(SLOT_RESULT_COUNT);
    protected ItemStackHandler craftingItems = createItemHandler(SLOT_CRAFTING_COUNT);
    protected ItemStackHandler storageItems = createItemHandler(SLOT_STORAGE_COUNT);

    protected LazyOptional<IItemHandler> combinedItemHandler = LazyOptional.of(() -> new CombinedInvWrapper(resultItems, craftingItems, storageItems));
    protected LazyOptional<IItemHandler> resultItemHandler = LazyOptional.of(() -> new AdaptedItemHandler(resultItems) {
        @Override
        public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            return stack;
        }
    });
    protected LazyOptional<IItemHandler> craftingItemHandler = LazyOptional.of(()-> new AdaptedItemHandler(craftingItems));
    protected LazyOptional<IItemHandler> storageItemHandler = LazyOptional.of(()-> new AdaptedItemHandler(storageItems));;

    public WorkBenchBE(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.WORK_BENCH.get(), pPos, pBlockState);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        combinedItemHandler.invalidate();
        resultItemHandler.invalidate();
        craftingItemHandler.invalidate();
        storageItemHandler.invalidate();
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put(TAG_INPUT_INVENTORY, this.resultItems.serializeNBT());
        tag.put(TAG_RESULT_INVENTORY, this.craftingItems.serializeNBT());
        tag.put(TAG_STORAGE_INVENTORY, this.storageItems.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.resultItems.deserializeNBT(tag.getCompound(TAG_INPUT_INVENTORY));
        this.craftingItems.deserializeNBT(tag.getCompound(TAG_RESULT_INVENTORY));
        this.storageItems.deserializeNBT(tag.getCompound(TAG_STORAGE_INVENTORY));
    }

    public ItemStackHandler getResultItems() {
        return resultItems;
    }
    public ItemStackHandler getCraftingItems() {
        return craftingItems;
    }
    public ItemStackHandler getStorageItems() {
        return storageItems;
    }
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new WorkBenchMenu(pContainerId, pPlayerInventory, this);
    }

    public void drops() {
        SimpleContainer outputInv = new SimpleContainer(resultItems.getSlots());
        for (int i = 0; i < resultItems.getSlots(); i++) {
            outputInv.setItem(i, resultItems.getStackInSlot(i));
        }
        SimpleContainer inputInv = new SimpleContainer(craftingItems.getSlots());
        for (int i = 0; i < craftingItems.getSlots(); i++) {
            inputInv.setItem(i, craftingItems.getStackInSlot(i));
        }
        SimpleContainer fuelInv = new SimpleContainer(storageItems.getSlots());
        for (int i = 0; i < storageItems.getSlots(); i++) {
            fuelInv.setItem(i, storageItems.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inputInv);
        Containers.dropContents(this.level, this.worldPosition, outputInv);
        Containers.dropContents(this.level, this.worldPosition, fuelInv);
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME);
    }
}



//
//
//
//
//
//    @Override
//    public CompoundTag getUpdateTag() {
//        CompoundTag tag = super.getUpdateTag();
//        saveClientData(tag);
//        return tag;
//    }
//
//    @Override
//    public void handleUpdateTag(CompoundTag tag) {
//        if (tag != null) {
//            loadClientData(tag);
//        }
//    }
//
//    @Override
//    protected void saveAdditional(CompoundTag tag) {
//        super.saveAdditional(tag);
//        saveClientData(tag);
//    }
//
//    private void saveClientData(CompoundTag tag) {
//        tag.put(DISPLAY_NAME, itemHandler.serializeNBT());
//    }
//
//    @Override
//    public void load(CompoundTag tag) {
//        super.load(tag);
//        loadClientData(tag);
//    }
//
//    private void loadClientData(CompoundTag tag) {
//        if (tag.contains(DISPLAY_NAME)) {
//            itemHandler.deserializeNBT(tag.getCompound(DISPLAY_NAME));
//        }
//    }


    // to abstract

