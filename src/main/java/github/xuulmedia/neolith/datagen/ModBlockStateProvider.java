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

        blockWithItem(ModBlocks.ANDESITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.BASALT_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.BLACKSTONE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.CALCITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.DEEPSLATE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.DIORITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.ENDSTONE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.GRANITE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.NETHERRACK_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.SANDSTONE_COBBLESTONE.get(), "block/cobble");
        blockWithItem(ModBlocks.TUFF_COBBLESTONE.get(), "block/cobble");


//        makeCrop(ModBlocks.MEDICINE_CROP.get(), "medicine_crop_stage","medicine_crop_stage");

        blockWithItem(ModBlocks.STONE_BRICK_BLOCK.get(), "block/bricks");
//        simpleCube(ModBlocks.BASALT_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
//        simpleCube(ModBlocks.DEEPSLATE_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
//        blockWithItem(ModBlocks.NETHERRACK_BRICK_BLOCK.get(),"block/bricks");
        blockWithItem(ModBlocks.SANDSTONE_BRICK_BLOCK.get(), "block/bricks");
//        simpleCube(ModBlocks.BLACKSTONE_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
        blockWithItem(ModBlocks.GRANITE_BRICK_BLOCK.get(), "block/bricks");
//        simpleCube(ModBlocks.TUFF_BRICK_BLOCK.get(),"block/bricks/bricks_XX");
        blockWithItem(ModBlocks.ANDESITE_BRICK_BLOCK.get(), "block/bricks");
        blockWithItem(ModBlocks.DIORITE_BRICK_BLOCK.get(), "block/bricks");
        blockWithItem(ModBlocks.CALCITE_BRICK_BLOCK.get(), "block/bricks");
        blockWithItem(ModBlocks.ENDSTONE_BRICK_BLOCK.get(), "block/bricks");

    }


    private void blockWithItem(Block block, String folder) {
        String key = ForgeRegistries.BLOCKS.getKey(block).getPath();

        ResourceLocation texture = new ResourceLocation(Neolith.MODID, folder + "/" + key);
        ModelFile model = models().cubeAll(key, texture);
        itemModels().getBuilder(key).parent(model);

        simpleBlock(block, model);
    }

//    private void sideBottomTop(Block block, String folder, String side, String bottom, String top) {
//        String key = ForgeRegistries.BLOCKS.getKey(block).getPath();
//
//        ResourceLocation textureTop = new ResourceLocation(Neolith.MODID, folder + "/" + side);
//        ResourceLocation textureSide = new ResourceLocation(Neolith.MODID, folder + "/" + bottom);
//        ResourceLocation textureBottom = new ResourceLocation(Neolith.MODID, folder + "/" + top);
//
//
//
//        ModelFile model = models().sideBottomTop(key, textureSide, textureTop, textureBottom);
//        itemModels().getBuilder(key).parent(model);
//
//        simpleBlock(block, model);
//    }
//    private void stairsBlockInternal(StairBlock block, String baseName, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
//        ModelFile stairs = models().stairs(baseName, side, bottom, top);
//        ModelFile stairsInner = models().stairsInner(baseName + "_inner", side, bottom, top);
//        ModelFile stairsOuter = models().stairsOuter(baseName + "_outer", side, bottom, top);
//        stairsBlock(block, stairs, stairsInner, stairsOuter);
//    }
//
//
//    sideBottomTop

//
//    public ModelFile cubeAll(Block block) {
//        return models().cubeAll(name(block), blockTexture(block));
//    }
//
//    public void simpleBlock(Block block, ConfiguredModel... models) {
//        getVariantBuilder(block)
//                .partialState().setModels(models);
//    }
//
//    public void simpleBlock(Block block) {
//        simpleBlock(block, cubeAll(block));
//    }
//
//    private String name(Block block) {
//        return key(block).getPath();
//    }
//    private ResourceLocation key(Block block) {
//        return ForgeRegistries.BLOCKS.getKey(block);
//    }
//
//    public VariantBlockStateBuilder getVariantBuilder(Block b) {
//        if (registeredBlocks.containsKey(b)) {
//            IGeneratedBlockState old = registeredBlocks.get(b);
//            Preconditions.checkState(old instanceof VariantBlockStateBuilder);
//            return (VariantBlockStateBuilder) old;
//        } else {
//            VariantBlockStateBuilder ret = new VariantBlockStateBuilder(b);
//            registeredBlocks.put(b, ret);
//            return ret;
//        }
//    }

}




