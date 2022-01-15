package com.xuul.flint.datagen;

import com.xuul.flint.Flint;
import com.xuul.flint.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModels extends ItemModelProvider {


    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Flint.MOD_ID, existingFileHelper);
    }



//This function registers the items to a texture. Existing parent is for blocks that have been set up under Block States it references them
    @Override
    protected void registerModels() {
        withExistingParent(ModItems.ORE_TIN_ITEM.get().getRegistryName().getPath(), modLoc("block/ore_tin"));
        withExistingParent(ModItems.ORE_SILVER_ITEM.get().getRegistryName().getPath(), modLoc("block/ore_nether_silver"));
        withExistingParent(ModItems.BLOCK_TIN_ITEM.get().getRegistryName().getPath(), modLoc("block/block_tin"));
        withExistingParent(ModItems.BLOCK_SILVER_ITEM.get().getRegistryName().getPath(), modLoc("block/block_silver"));
        withExistingParent(ModItems.BLOCK_BRONZE_ITEM.get().getRegistryName().getPath(), modLoc("block/block_bronze"));
        withExistingParent(ModItems.BLOCK_STEEL_ITEM.get().getRegistryName().getPath(), modLoc("block/block_steel"));


//        singleTexture(ModItems.RAW_TIN.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/raw_tin"));
//
//                singleTexture(ModItems.RAW_SILVER.get().getRegistryName().getPath(),
//                        mcLoc("item/generated"),
//                        "layer0", modLoc("item/raw_silver"));

        singleTexture(ModItems.PLANT_FIBRE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/plant_fibre"));
        singleTexture(ModItems.BRAIDED_PLANT_FIBRE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/braided_plant_fibre"));



        singleTexture(ModItems.INGOT_TIN.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/ingots/ingot_tin"));

        singleTexture(ModItems.INGOT_BRONZE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/ingots/ingot_bronze"));
        singleTexture(ModItems.INGOT_SILVER.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/ingots/ingot_silver"));
        singleTexture(ModItems.INGOT_STEEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/ingots/ingot_steel"));


        singleTexture(ModItems.NUGGET_TIN.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_tin"));
        singleTexture(ModItems.NUGGET_COPPER.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_copper"));
        singleTexture(ModItems.NUGGET_SILVER.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_silver"));
        singleTexture(ModItems.NUGGET_BRONZE.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_bronze"));
        singleTexture(ModItems.NUGGET_STEEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_steel"));

        singleTexture(ModItems.DUST_TIN.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_tin"));
        singleTexture(ModItems.DUST_COPPER.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_copper"));
        singleTexture(ModItems.DUST_SILVER.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_silver"));
        singleTexture(ModItems.DUST_BRONZE.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_bronze"));
        singleTexture(ModItems.DUST_STEEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_steel"));
        singleTexture(ModItems.DUST_IRON.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_iron"));
        singleTexture(ModItems.DUST_GOLD.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_gold"));


        singleTexture(ModItems.BRONZE_SWORD.get().getRegistryName().getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_sword"));
        singleTexture(ModItems.BRONZE_PICK.get().getRegistryName().getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_pickaxe"));
        singleTexture(ModItems.BRONZE_SHOVEL.get().getRegistryName().getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_shovel"));
        singleTexture(ModItems.BRONZE_AXE.get().getRegistryName().getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_axe"));
        singleTexture(ModItems.BRONZE_HOE.get().getRegistryName().getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_hoe"));

        /*LOGS*/


        singleTexture(ModItems.LOG_ACACIA.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_acacia"));
        singleTexture(ModItems.LOG_BIRCH.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_birch"));
        singleTexture(ModItems.LOG_SPRUCE.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_spruce"));
        singleTexture(ModItems.LOG_CRIMSON.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_crimson"));
        singleTexture(ModItems.LOG_DARK_OAK.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_dark_oak"));
        singleTexture(ModItems.LOG_JUNGLE.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_jungle"));
        singleTexture(ModItems.LOG_SPRUCE.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_spruce"));
        singleTexture(ModItems.LOG_WARPED.get().getRegistryName().getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_warped"));


        /*TODO setup layered texture*/
//        singleTexture(ModItems.BRONZE_HELMET.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_helmet"));
//        singleTexture(ModItems.BRONZE_CHEST.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_chest"));
//        singleTexture(ModItems.BRONZE_LEGS.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_legs"));
//        singleTexture(ModItems.BRONZE_BOOTS.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_boots"));
//

        singleTexture(ModItems.CHUNK_STONE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_stone"));
        singleTexture(ModItems.CHUNK_ANDESITE.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_andesite"));
//        singleTexture(ModItems.CHUNK_DEEPSLATE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_deepslate"));
//        singleTexture(ModItems.CHUNK_DRIPSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_dripstone"));
        singleTexture(ModItems.CHUNK_DIORITE.get().getRegistryName().getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_diorite"));
        singleTexture(ModItems.CHUNK_GRANITE.get().getRegistryName().getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_granite"));
        singleTexture(ModItems.CHUNK_BASALT.get().getRegistryName().getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_basalt"));
//        singleTexture(ModItems.CHUNK_TUFF.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_tuff"));
        singleTexture(ModItems.CHUNK_NETHERRACK.get().getRegistryName().getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_netherrack"));
//        singleTexture(ModItems.CHUNK_BLACKSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_blackstone"));
//        singleTexture(ModItems.CHUNK_CALCITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_calcite"));


//        singleTexture(ModItems.DUST_STONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_stone"));
//      singleTexture(ModItems.DUST_ANDESITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_andesite"));
//      singleTexture(ModItems.DUST_DEEPSLATE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_deepslate"));
//      singleTexture(ModItems.DUST_DRIPSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_dripstone"));
//      singleTexture(ModItems.DUST_SANDSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_diorite"));
//      singleTexture(ModItems.DUST_DIORITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_granite"));
//      singleTexture(ModItems.DUST_GRANITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_basalt"));
//      singleTexture(ModItems.DUST_BASALT.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_tuff"));
//      singleTexture(ModItems.DUST_TUFF.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_netherrack"));
//      singleTexture(ModItems.DUST_NETHERRACK.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_blackstone"));
//      singleTexture(ModItems.DUST_BLACKSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dust/dust_calcite"));



//      singleTexture(ModItems.BRICK_STONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_stone"));
//      singleTexture(ModItems.BRICK_ANDESITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_andesite"));
//      singleTexture(ModItems.BRICK_DEEPSLATE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_deepslate"));
//      singleTexture(ModItems.BRICK_DRIPSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_dripstone"));
//      singleTexture(ModItems.BRICK_SANDSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_diorite"));
//      singleTexture(ModItems.BRICK_DIORITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_granite"));
//      singleTexture(ModItems.BRICK_GRANITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_basalt"));
//      singleTexture(ModItems.BRICK_BASALT.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_tuff"));
//      singleTexture(ModItems.BRICK_TUFF.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_netherrack"));
//      singleTexture(ModItems.BRICK_NETHERRACK.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_blackstone"));
//      singleTexture(ModItems.BRICK_BLACKSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_calcite"));



//      singleTexture(ModItems.CLAY_STONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_stone"));
//      singleTexture(ModItems.CLAY_ANDESITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_andesite"));
//      singleTexture(ModItems.CLAY_DEEPSLATE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_deepslate"));
//      singleTexture(ModItems.CLAY_DRIPSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_dripstone"));
//      singleTexture(ModItems.CLAY_SANDSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_diorite"));
//      singleTexture(ModItems.CLAY_DIORITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_granite"));
//      singleTexture(ModItems.CLAY_GRANITE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_basalt"));
//      singleTexture(ModItems.CLAY_BASALT.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_tuff"));
//      singleTexture(ModItems.CLAY_TUFF.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_netherrack"));
//      singleTexture(ModItems.CLAY_NETHERRACK.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_blackstone"));
//      singleTexture(ModItems.CLAY_BLACKSTONE.get().getRegistryName().getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_calcite"));


      singleTexture(ModItems.FLINT_KNIFE.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_knife"));
      singleTexture(ModItems.FLINT_PICK.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_pick"));
      singleTexture(ModItems.FLINT_SHOVEL.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_shovel"));
      singleTexture(ModItems.FLINT_AXE.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_axe"));
      singleTexture(ModItems.FLINT_HOE.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_hoe"));

      singleTexture(ModItems.FLINT_BLADE.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_knife"));
      singleTexture(ModItems.FLINT_PICK_HEAD.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_pickaxe"));
        singleTexture(ModItems.FLINT_SHOVEL_HEAD.get().getRegistryName().getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_hoe"));
      singleTexture(ModItems.FLINT_AXE_HEAD.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_shovel"));
      singleTexture(ModItems.FLINT_HOE_HEAD.get().getRegistryName().getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_axe"));












    }

}
