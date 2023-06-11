package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.manualGrinderBlock.ManualGrinderMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class ManualGrinderBlockEntity extends BlockEntity implements MenuProvider {
    public static final String DISPLAY_NAME = "Grindstone";
    public static final int STACK_SIZE = 3; // this must be a match with the number in the block MENU

    private final ItemStackHandler itemHandler = new ItemStackHandler(STACK_SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private  int maxProgress = 80;

    public ManualGrinderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MANUAL_GRINDER.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ManualGrinderBlockEntity.this.progress;
                    case 1 -> ManualGrinderBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ManualGrinderBlockEntity.this.progress = value;
                    case 1 -> ManualGrinderBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }
            @Override
    public Component getDisplayName() {
        return Component.literal(DISPLAY_NAME);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory pPlayerInventory, Player pPlayer) {

        return new ManualGrinderMenu(id, pPlayerInventory, this, this.data);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("manual_grindstone.progress", this.progress);

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("manual_grindston.progress");
    }

    public void drops() {
        Container inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ManualGrinderBlockEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }
        boolean hasGrindingStoneInFirstSlot = pEntity.itemHandler.getStackInSlot(1).getItem() == ModItems.BASIC_GRINDING_STONE.get();

        if(!hasGrindingStoneInFirstSlot){
            return;
        }
//        if(hasRecipe(pEntity, hasGrindingStoneInFirstSlot)) {
//            pEntity.progress++;
//            pEntity.itemHandler.getStackInSlot(1).setDamageValue(pEntity.itemHandler.getStackInSlot(1).getDamageValue() -1);
//            setChanged(level, pos, state);
//
//            if(pEntity.progress >= pEntity.maxProgress) {
//                craftItem(pEntity);
//            }
//        } else {
//            pEntity.resetProgress();
//            setChanged(level, pos, state);
//        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

//    private static boolean hasRecipe(ManualGrinderBlockEntity entity, boolean condition) {
//        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
//        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
//            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
//        }
//        return condition && isAmountIntoOutputSlotValid(inventory) &&
//                canInsertItemIntoOutputSlot(inventory, new ItemStack(ModItems.ZIRCON.get(), 1));
//    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean isAmountIntoOutputSlotValid(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }

}
