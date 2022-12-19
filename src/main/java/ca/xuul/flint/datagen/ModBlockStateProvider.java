package ca.xuul.flint.datagen;

import ca.xuul.flint.Flint;
import ca.xuul.flint.init.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Flint.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ORE_TIN.get());
        simpleBlock(ModBlocks.ORE_SILVER.get());

        simpleCube(ModBlocks.COBBLESTONE.get(), "block/cobble/cobblestone");
        simpleCube(ModBlocks.BASALT_COBBLESTONE.get(), "block/cobble/basalt_cobble");
        simpleCube(ModBlocks.DEEPSLATE_COBBLESTONE.get(), "block/cobble/deepslate_cobble");
        simpleCube(ModBlocks.NETHERRACK_COBBLESTONE.get(), "block/cobble/netherrack_cobble");
        simpleCube(ModBlocks.SANDSTONE_COBBLESTONE.get(), "block/cobble/sandstone_cobble");
        simpleCube(ModBlocks.BLACKSTONE_COBBLESTONE.get(), "block/cobble/blackstone_cobble");
        simpleCube(ModBlocks.ENDSTONE_COBBLESTONE.get(), "block/cobble/endstone_cobble");
        simpleCube(ModBlocks.GRANITE_COBBLESTONE.get(), "block/cobble/granite_cobble");
        simpleCube(ModBlocks.TUFF_COBBLESTONE.get(), "block/cobble/tuff_cobble");
        simpleCube(ModBlocks.ANDESITE_COBBLESTONE.get(), "block/cobble/andesite_cobble");
        simpleCube(ModBlocks.DIORITE_COBBLESTONE.get(), "block/cobble/diorite_cobble");
        simpleCube(ModBlocks.CALCITE_COBBLESTONE.get(), "block/cobble/calcite_cobble");



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

//        simpleBlock(ModBlocks.THATCH.get());

    }

    private void simpleCube(Block block, String resourceLoc) {
        ResourceLocation side = modLoc(resourceLoc);
        simpleBlock(block, models().cube(ForgeRegistries.BLOCKS.getKey(block).getPath(), side, side, side, side, side, side));
    }

}




