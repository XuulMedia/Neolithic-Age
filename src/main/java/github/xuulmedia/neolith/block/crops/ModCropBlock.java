package github.xuulmedia.neolith.block.crops;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModCropBlock extends CropBlock {
    public static final IntegerProperty AGE  = IntegerProperty.create("age", 0, 6);
    public ModCropBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }
}
