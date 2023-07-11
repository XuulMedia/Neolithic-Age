package github.xuulmedia.neolith.block.crops;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public abstract class ModCropBlock extends CropBlock {
    public ModCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected abstract void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder);

    @Override
    public abstract IntegerProperty getAgeProperty();
}
