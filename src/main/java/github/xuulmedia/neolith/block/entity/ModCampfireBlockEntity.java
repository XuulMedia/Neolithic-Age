package github.xuulmedia.neolith.block.entity;

import github.xuulmedia.neolith.block.custom.ModCampfireBlock;
import github.xuulmedia.neolith.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.Optional;

public class ModCampfireBlockEntity extends BlockEntity implements Clearable {
    protected static final  int BURN_MINUITES = 1; // how long in min the fire will burn
    private static final int DELAY = 1200; // 1200 ticks is 60 seconds
    public int maxBurnTime= BURN_MINUITES * DELAY; //should be in minutes
    public int burnTime = maxBurnTime;

    private final NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);
    private final int[] cookingProgress = new int[4];
    private final int[] cookingTime = new int[4];
    private final RecipeManager.CachedCheck<Container, CampfireCookingRecipe> quickCheck = RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);

    public ModCampfireBlockEntity(BlockPos pPos, BlockState state) {
        super(ModBlockEntities.CAMPFIRE.get(), pPos, state);
    }

    public static void cookTick(Level level, BlockPos blockPos, BlockState state, ModCampfireBlockEntity blockEntity) {

        boolean flag = false;
        for(int i = 0; i < blockEntity.items.size(); ++i) {
            ItemStack itemstack = blockEntity.items.get(i);
            if (!itemstack.isEmpty()) {
                flag = true;
                int j = blockEntity.cookingProgress[i]++;
                if (blockEntity.cookingProgress[i] >= blockEntity.cookingTime[i]) {
                    Container container = new SimpleContainer(itemstack);
                    ItemStack itemstack1 = blockEntity.quickCheck.getRecipeFor(container, level).map((p_270054_) -> {
                        return p_270054_.assemble(container, level.registryAccess());
                    }).orElse(itemstack);
                    if (itemstack1.isItemEnabled(level.enabledFeatures())) {
                        Containers.dropItemStack(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), itemstack1);
                        blockEntity.items.set(i, ItemStack.EMPTY);
                        level.sendBlockUpdated(blockPos, state, state, 3);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(state));
                    }
                }
            }
        }

        if(level.isRaining() && blockEntity.isNearRain(level,blockPos)) {
            level.setBlockAndUpdate(blockPos, state.setValue(ModCampfireBlock.LIT, false));
            level.playSound(null, blockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, level.getRandom().nextFloat() * 0.1F + 0.9F);

            blockEntity.setChanged();
            return;
        }

        int newBurnTime = blockEntity.burnTime - 1;
        System.out.println("burn time " + newBurnTime);
        if(newBurnTime <= 0){
            level.setBlockAndUpdate(blockPos, state.setValue(ModCampfireBlock.LIT, false));
            level.playSound(null, blockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, level.getRandom().nextFloat() * 0.1F + 0.9F);
            blockEntity.burnTime = blockEntity.maxBurnTime;
            blockEntity.setChanged();
            return;
        } else {
            blockEntity.burnTime = newBurnTime;
        }

        if (flag) {
            setChanged(level, blockPos, state);
        }
    }



    public static void cooldownTick(Level level, BlockPos blockPos, BlockState pState, ModCampfireBlockEntity blockEntity) {
        boolean flag = false;

        for(int i = 0; i < blockEntity.items.size(); ++i) {
            if (blockEntity.cookingProgress[i] > 0) {
                flag = true;
                blockEntity.cookingProgress[i] = Mth.clamp(blockEntity.cookingProgress[i] - 2, 0, blockEntity.cookingTime[i]);
            }
        }

        if (flag) {
            setChanged(level, blockPos, pState);
        }

    }

    public static void particleTick(Level level, BlockPos blockPos, BlockState pState, ModCampfireBlockEntity blockEntity) {
        RandomSource randomsource = level.random;
        if (randomsource.nextFloat() < 0.11F) {
            for(int i = 0; i < randomsource.nextInt(2) + 2; ++i) {
                ModCampfireBlock.makeParticles(level, blockPos, pState.getValue(ModCampfireBlock.SIGNAL_FIRE), false);
            }
        }

        int l = pState.getValue(ModCampfireBlock.FACING).get2DDataValue();

        for(int j = 0; j < blockEntity.items.size(); ++j) {
            if (!blockEntity.items.get(j).isEmpty() && randomsource.nextFloat() < 0.2F) {
                Direction direction = Direction.from2DDataValue(Math.floorMod(j + l, 4));
                float f = 0.3125F;
                double d0 = (double)blockPos.getX() + 0.5D - (double)((float)direction.getStepX() * 0.3125F) + (double)((float)direction.getClockWise().getStepX() * 0.3125F);
                double d1 = (double)blockPos.getY() + 0.5D;
                double d2 = (double)blockPos.getZ() + 0.5D - (double)((float)direction.getStepZ() * 0.3125F) + (double)((float)direction.getClockWise().getStepZ() * 0.3125F);

                for(int k = 0; k < 4; ++k) {
                    level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 5.0E-4D, 0.0D);
                }
            }
        }
    }

    /**
     * @return the items currently held in this campfire
     */
    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items.clear();
        ContainerHelper.loadAllItems(pTag, this.items);
        if (pTag.contains("CookingTimes", 11)) {
            int[] aint = pTag.getIntArray("CookingTimes");
            System.arraycopy(aint, 0, this.cookingProgress, 0, Math.min(this.cookingTime.length, aint.length));
        }

        if (pTag.contains("CookingTotalTimes", 11)) {
            int[] aint1 = pTag.getIntArray("CookingTotalTimes");
            System.arraycopy(aint1, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, aint1.length));
        }
    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items, true);
        pTag.putIntArray("CookingTimes", this.cookingProgress);
        pTag.putIntArray("CookingTotalTimes", this.cookingTime);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    /**
     * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the chunk or when
     * many blocks change at once. This compound comes back to you clientside in {@link handleUpdateTag}
     */
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true);
        return compoundtag;
    }

    public Optional<CampfireCookingRecipe> getCookableRecipe(ItemStack pStack) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.quickCheck.getRecipeFor(new SimpleContainer(pStack), this.level);
    }

    public boolean placeFood(@Nullable Entity pEntity, ItemStack pStack, int pCookTime) {
        for(int i = 0; i < this.items.size(); ++i) {
            ItemStack itemstack = this.items.get(i);
            if (itemstack.isEmpty()) {
                this.cookingTime[i] = pCookTime;
                this.cookingProgress[i] = 0;
                this.items.set(i, pStack.split(1));
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(pEntity, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }
        return false;
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

    public void dowse() {
        if (this.level != null) {
            this.markUpdated();
        }
    }
    public void reset(){
        burnTime = maxBurnTime;
    }

    public boolean isStillBurning() {return burnTime > 0;}

    public boolean isNearRain(Level level, BlockPos blockPos) {
        return level.isRainingAt(blockPos) || level.isRainingAt(blockPos.west()) || level.isRainingAt(blockPos.east()) || level.isRainingAt(blockPos.north()) || level.isRainingAt(blockPos.south());
    }

    public void extinguishFire(BlockState state, Level level, BlockPos blockPos){
        if (!isStillBurning()) {
            level.setBlockAndUpdate(blockPos, state.setValue(ModCampfireBlock.LIT, false));
            level.playSound(null, blockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, level.getRandom().nextFloat() * 0.1F + 0.9F);
        }
    }



}