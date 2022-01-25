package xuul.flint.datagen;

import xuul.flint.Flint;
import xuul.flint.common.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModBlockStates extends BlockStateProvider {

    public ModBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Flint.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ORE_TIN.get());
        simpleBlock(ModBlocks.ORE_SILVER.get());


//        simpleBlock(ModBlocks.COBBLESTONE.get());
//        simpleBlock(ModBlocks.BASALT_COBBLESTONE.get());
//        simpleBlock(ModBlocks.DEEPSLATE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.NETHERRACK_COBBLESTONE.get());
//        simpleBlock(ModBlocks.SANDSTONE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.BLACKSTONE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.ENDSTONE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.GRANITE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.TUFF_COBBLESTONE.get());
//        simpleBlock(ModBlocks.ANDESITE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.DIORITE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.CALCITE_COBBLESTONE.get());
//
//        simpleBlock(ModBlocks.STONE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.BASALT_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.DEEPSLATE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.NETHERRACK_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.SANDSTONE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.BLACKSTONE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.ENDSTONE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.GRANITE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.TUFF_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.ANDESITE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.DIORITE_BRICK_BLOCK.get());
//        simpleBlock(ModBlocks.CALCITE_BRICK_BLOCK.get());

        simpleBlock(ModBlocks.BLOCK_TIN.get());
        simpleBlock(ModBlocks.BLOCK_SILVER.get());
        simpleBlock(ModBlocks.BLOCK_BRONZE.get());
        simpleBlock(ModBlocks.BLOCK_STEEL.get());

    }
}
