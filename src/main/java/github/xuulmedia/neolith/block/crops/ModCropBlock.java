package github.xuulmedia.neolith.block.crops;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public abstract class ModCropBlock extends CropBlock {
    private final Supplier<ItemLike> seedsSupplier;

    public ModCropBlock(Properties properties, Supplier<ItemLike> seedsSupplier) {
        super(properties);
        this.seedsSupplier = seedsSupplier;
    }

    public abstract @NotNull IntegerProperty getAgeProperty();

    protected  abstract void  createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder);
    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return seedsSupplier.get();
    }

    @Override
    protected int getBonemealAgeIncrease(Level pLevel) {
        return 1;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return (double)pLevel.random.nextFloat() < 0.5D; //50% chance
    }

    /*TODO fix for all*/
//    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
//        return !this.isMaxAge(pState);
//    }
}