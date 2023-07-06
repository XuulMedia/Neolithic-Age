package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.gui.menu.ClayPotMenu;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.util.AdaptedItemHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class ClayPotBE extends AbstractNeolithBlockEntity {

    public static final String DISPLAY_NAME = "Pot";
    private static final String TAG_INVENTORY = "inventory";
    public static final int SLOT_COUNT = 15;
    protected ItemStackHandler items = createItemHandler(SLOT_COUNT);
    protected LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> new AdaptedItemHandler(items));
    ;

    public ClayPotBE(BlockPos blockPos, BlockState state) {
        super(ModBlockEntities.CLAY_POT.get(), blockPos, state);
    }


    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandler.invalidate();
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put(TAG_INVENTORY, items.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        items.deserializeNBT(tag.getCompound(TAG_INVENTORY));
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ClayPotMenu(pContainerId, pPlayerInventory, this);
    }

    public ItemStackHandler getItems() {
        return items;
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable(DISPLAY_NAME);
    }
}
