package github.xuulmedia.neolith.datagen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, Neolith.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
//        simpleBlock(ModBlocks.ORE_TIN.get());

        blockWithItem(ModBlocks.ORE_TIN.get(), "block/ore");
        blockWithItem(ModBlocks.ORE_SILVER.get(), "block/ore");
        blockWithItem(ModBlocks.ORE_CLAY.get(), "block/ore");

        blockWithItem(ModBlocks.BLOCK_TIN.get(), "block");
        blockWithItem(ModBlocks.BLOCK_SILVER.get(), "block");
        blockWithItem(ModBlocks.BLOCK_BRONZE.get(), "block");
        blockWithItem(ModBlocks.BLOCK_STEEL.get(), "block");
//        simpleBlock(ModBlocks.THATCH.get());

        //cobblestone
        blockWithItem(ModBlocks.COBBLESTONE_ANDESITE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_BASALT.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_BLACKSTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_CALCITE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_DEEPSLATE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_DIORITE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_DRIPSTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_GRANITE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_NETHERRACK.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_RED_SANDSTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_SANDSTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_STONE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_TUFF.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE_ENDSTONE.get(), "block/cobble");

        //Bricks
        blockWithItem(ModBlocks.STONE_BRICK_BLOCK.get(), "block/bricks");
        blockWithItem(ModBlocks.DEEPSLATE_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.NETHERRACK_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.ENDSTONE_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.BROWN_BRICK_BLOCK.get(), "block/bricks");
        blockWithItem(ModBlocks.WHITE_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.BLACK_BRICK_BLOCK.get(), "block/bricks");
        blockWithItem(ModBlocks.SAND_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.RED_SAND_BRICK_BLOCK.get(), "block/bricks");


    }


    private void blockWithItem(Block block, String folder) {
        String key = ForgeRegistries.BLOCKS.getKey(block).getPath();

        ResourceLocation texture = new ResourceLocation(Neolith.MODID, folder + "/" + key);
        ModelFile model = models().cubeAll(key, texture);
        itemModels().getBuilder(key).parent(model);

        simpleBlock(block, model);
    }



}




