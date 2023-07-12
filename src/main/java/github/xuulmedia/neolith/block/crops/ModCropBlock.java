package github.xuulmedia.neolith.block.crops;

import net.minecraft.world.level.ItemLike;
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
}