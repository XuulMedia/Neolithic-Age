package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.menu.WorkBenchMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class WorkBenchBE extends AbstractNeolithBlockEntity {
    public static final String DISPLAY_NAME = "Work Bench";

    public static final int RESULT_SLOT = 0;
    public static final int CRAFTING_SLOTS_START = 1;
    public static final int CRAFTING_SLOTS_END = 9;
    public static final int STORAGE_SLOTS_START = 10;
    public static final int STORAGE_SLOTS_END = 19;

    public static final int NUM_SLOTS = 19; // this must be a match with the number in the block MENU
    protected final ContainerData data;
    private int progress = 0;

    public WorkBenchBE(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.WORK_BENCH.get(), pPos, pBlockState);
        itemHandler = createItemHandler(NUM_SLOTS);


        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> WorkBenchBE.this.progress;
                    default -> 0;
                };
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> WorkBenchBE.this.progress = value;
                }
            }
            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new WorkBenchMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveClientData(tag);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        if (tag != null) {
            loadClientData(tag);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        saveClientData(tag);
    }

    private void saveClientData(CompoundTag tag) {
        tag.put(DISPLAY_NAME, itemHandler.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        loadClientData(tag);
    }

    private void loadClientData(CompoundTag tag) {
        if (tag.contains(DISPLAY_NAME)) {
            itemHandler.deserializeNBT(tag.getCompound(DISPLAY_NAME));
        }
    }
}
