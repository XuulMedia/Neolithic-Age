package ca.xuul.flint.datagen;

import ca.xuul.flint.Flint;
import ca.xuul.flint.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;


public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Flint.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ORE_TIN.get());
        simpleBlock(ModBlocks.ORE_SILVER.get());

        simpleBlock(ModBlocks.BLOCK_TIN.get());
        simpleBlock(ModBlocks.BLOCK_SILVER.get());
        simpleBlock(ModBlocks.BLOCK_BRONZE.get());
        simpleBlock(ModBlocks.BLOCK_STEEL.get());

//        simpleBlock(ModBlocks.THATCH.get());

        simpleCube(ModBlocks.COBBLESTONE.get(), "block/cobble/cobblestone");
        simpleCube(ModBlocks.BASALT_COBBLESTONE.get(), "block/cobble/basalt_cobble");
        simpleCube(ModBlocks.DEEPSLATE_COBBLESTONE.get(), "block/cobble/deepslate_cobble");
        simpleCube(ModBlocks.NETHERRACK_COBBLESTONE.get(), "block/cobble/netherrack_cobble");
        simpleCube(ModBlocks.SANDSTONE_COBBLESTONE.get(), "block/cobble/sandstone_cobble");
        simpleCube(ModBlocks.BLACKSTONE_COBBLESTONE.get(), "block/cobble/blackstone_cobble");
        simpleCube(ModBlocks.GRANITE_COBBLESTONE.get(), "block/cobble/granite_cobble");
        simpleCube(ModBlocks.TUFF_COBBLESTONE.get(), "block/cobble/tuff_cobble");
        simpleCube(ModBlocks.ANDESITE_COBBLESTONE.get(), "block/cobble/andesite_cobble");
        simpleCube(ModBlocks.DIORITE_COBBLESTONE.get(), "block/cobble/diorite_cobble");
        simpleCube(ModBlocks.CALCITE_COBBLESTONE.get(), "block/cobble/calcite_cobble");
        simpleCube(ModBlocks.ENDSTONE_COBBLESTONE.get(), "block/cobble/endstone_cobble");

//        makeCrop(ModBlocks.MEDICINE_CROP.get(), "medicine_crop_stage","medicine_crop_stage");


        simpleCube(ModBlocks.STONE_BRICK_BLOCK.get(),"block/bricks/bricks_stone");
//        simpleCube(ModBlocks.BASALT_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
//        simpleCube(ModBlocks.DEEPSLATE_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
        simpleCube(ModBlocks.NETHERRACK_BRICK_BLOCK.get(),"block/bricks/nether_brick");
        simpleCube(ModBlocks.SANDSTONE_BRICK_BLOCK.get() ,"block/bricks/bricks_sandstone");
//        simpleCube(ModBlocks.BLACKSTONE_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
        simpleCube(ModBlocks.GRANITE_BRICK_BLOCK.get(),"block/bricks/bricks_granite");
//        simpleCube(ModBlocks.TUFF_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
        simpleCube(ModBlocks.ANDESITE_BRICK_BLOCK.get(),"block/bricks/bricks_andesite");
        simpleCube(ModBlocks.DIORITE_BRICK_BLOCK.get(),"block/bricks/bricks_diorite");
        simpleCube(ModBlocks.CALCITE_BRICK_BLOCK.get(),"block/bricks/bricks_calcite");
        simpleCube(ModBlocks.ENDSTONE_BRICK_BLOCK.get() ,"block/bricks/bricks_endstone");





    }

    private void simpleCube(Block block, String resourceLoc) {
        ResourceLocation side = modLoc(resourceLoc);
        simpleBlock(block, models().cube(ForgeRegistries.BLOCKS.getKey(block).getPath(), side, side, side, side, side, side));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(Flint.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))));

        return models;
    }

}




