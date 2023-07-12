package github.xuulmedia.neolith.block.crops;

import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class GreenBeanCrop extends ModCropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);

    public GreenBeanCrop(Properties properties) {
        super(properties, () -> ModItems.GREEN_BEAN_SEEDS.get());
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
