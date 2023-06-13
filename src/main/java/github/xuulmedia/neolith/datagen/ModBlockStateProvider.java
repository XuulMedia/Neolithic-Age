package github.xuulmedia.neolith.datagen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, Neolith.MODID, helper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ORE_TIN.get(), "block/ore");
        blockWithItem(ModBlocks.ORE_SILVER.get(), "block/ore");

        blockWithItem(ModBlocks.BLOCK_TIN.get(), "block");
        blockWithItem(ModBlocks.BLOCK_SILVER.get(), "block");
        blockWithItem(ModBlocks.BLOCK_BRONZE.get(), "block");
        blockWithItem(ModBlocks.BLOCK_STEEL.get(), "block");
//        simpleBlock(ModBlocks.THATCH.get());

        blockWithItem(ModBlocks.COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.BASALT_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.DEEPSLATE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.NETHERRACK_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.SANDSTONE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.BLACKSTONE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.GRANITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.TUFF_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.ANDESITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.DIORITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.CALCITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.ENDSTONE_COBBLESTONE.get(), "block/cobble");

//        makeCrop(ModBlocks.MEDICINE_CROP.get(), "medicine_crop_stage","medicine_crop_stage");

        blockWithItem(ModBlocks.STONE_BRICK_BLOCK.get(),"block/bricks");
//        simpleCube(ModBlocks.BASALT_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
//        simpleCube(ModBlocks.DEEPSLATE_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
//        blockWithItem(ModBlocks.NETHERRACK_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.SANDSTONE_BRICK_BLOCK.get() ,"block/bricks");
//        simpleCube(ModBlocks.BLACKSTONE_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
        blockWithItem(ModBlocks.GRANITE_BRICK_BLOCK.get(),"block/bricks");
//        simpleCube(ModBlocks.TUFF_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
        blockWithItem(ModBlocks.ANDESITE_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.DIORITE_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.CALCITE_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.ENDSTONE_BRICK_BLOCK.get() ,"block/bricks");

    }


    private void blockWithItem(Block block, String folder) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        ResourceLocation texture =  new ResourceLocation(Neolith.MODID, folder + "/" + key.getPath());

        models().cubeAll(key.getPath(), texture);
        itemModels().getBuilder(key.getPath()).parent(models().cubeAll(key.getPath(), texture));
    }



}




