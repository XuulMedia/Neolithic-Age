package github.xuulmedia.neolith.block.crops;

import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GreenBeanCrop extends ModCropBlock {

    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE  = IntegerProperty.create("age", 0, 4);

    public GreenBeanCrop(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.GREEN_BEAN_SEEDS.get();
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }


    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }
}
