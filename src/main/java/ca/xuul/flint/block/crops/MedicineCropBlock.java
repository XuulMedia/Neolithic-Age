package ca.xuul.flint.block.crops;

import ca.xuul.flint.init.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class MedicineCropBlock extends CropBlock {


    public MedicineCropBlock(Properties pProperties) {
        super(pProperties);
    }

//    @Override
//    protected ItemLike getBaseSeedId() {
//        return ModItems.MEDICINE_PLANT_SEEDS.get();
//    }


}
