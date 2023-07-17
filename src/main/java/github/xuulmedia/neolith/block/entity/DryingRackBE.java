package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.recipe.DryingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.Optional;


public class DryingRackBE extends BlockEntity {
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    private final int[] cookingProgress = new int[1];
    private final int[] cookingTime = new int[1];
    private final RecipeManager.CachedCheck<Container, DryingRecipe> quickCheck = RecipeManager.createCheck(DryingRecipe.Type.INSTANCE);

    public DryingRackBE(BlockPos pPos, BlockState state) {
        super(ModBlockEntities.DRYING_RACK.get(), pPos, state);
    }

    public static void dryTick(Level level, BlockPos blockPos, BlockState state, DryingRackBE blockEntity) {
        ItemStack itemstack = blockEntity.items.get(0);
        if (!itemstack.isEmpty()) {
            int j = blockEntity.cookingProgress[0]++;
            if (blockEntity.cookingProgress[0] >= blockEntity.cookingTime[0]) {
                Container container = new SimpleContainer(itemstack);
                ItemStack itemstack1 = blockEntity.quickCheck.getRecipeFor(container, level).map((p_270054_) -> {
                    return p_270054_.assemble(container, level.registryAccess());
                }).orElse(itemstack);
                if (!itemstack1.isEmpty()) {
                    Containers.dropItemStack(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), itemstack1);
                    blockEntity.items.set(0, ItemStack.EMPTY);
                    level.sendBlockUpdated(blockPos, state, state, 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(state));
                }
            }
        }
    }

    @Override
    public void load(CompoundTag compoundtag) {
        super.load(compoundtag);
        ContainerHelper.loadAllItems(compoundtag, this.items);
        if (compoundtag.contains("CookingTimes", 11)) {
            this.cookingProgress[0] = compoundtag.getIntArray("CookingTimes")[0];
        }
        if (compoundtag.contains("CookingTotalTimes", 11)) {
            this.cookingTime[0] = compoundtag.getIntArray("CookingTotalTimes")[0];
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items, true);
        pTag.putIntArray("CookingTimes", this.cookingProgress);
        pTag.putIntArray("CookingTotalTimes", this.cookingTime);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true);
        return compoundtag;
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public boolean placeItem(@Nullable Entity pEntity, ItemStack pStack, int pCookTime) {

            ItemStack itemstack = this.items.get(0);
            if (itemstack.isEmpty()) {
                this.cookingTime[0] = pCookTime;
                this.cookingProgress[0] = 0;
                this.items.set(0, pStack.split(1));
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(pEntity, this.getBlockState()));
                this.markUpdated();
                return true;

        }
        return false;
    }

    public Optional<DryingRecipe> getDryingRecipe(ItemStack pStack) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.quickCheck.getRecipeFor(new SimpleContainer(pStack), this.level);
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public void clearContent() {
        this.items.clear();
    }


}

