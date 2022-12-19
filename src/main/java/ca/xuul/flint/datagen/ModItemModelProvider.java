package ca.xuul.flint.datagen;

import ca.xuul.flint.Flint;
import ca.xuul.flint.init.ModBlocks;
import ca.xuul.flint.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Flint.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.ORE_TIN_ITEM.get()).getPath(), modLoc("block/ore_tin"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.ORE_SILVER_ITEM.get()).getPath(), modLoc("block/ore_nether_silver"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.BLOCK_TIN_ITEM.get()).getPath(), modLoc("block/block_tin"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.BLOCK_SILVER_ITEM.get()).getPath(), modLoc("block/block_silver"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.BLOCK_BRONZE_ITEM.get()).getPath(), modLoc("block/block_bronze"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.FLINT_STATION_ITEM.get()).getPath(), modLoc("block/flint_station"));


        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.THATCH_BLOCK_ITEM.get()).getPath(), modLoc("block/thatch"));

        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.COBBLESTONE_ITEM.get()).getPath(), modLoc("block/cobblestone"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.BASALT_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/basalt_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.DEEPSLATE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/deepslate_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.NETHERRACK_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/netherrack_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.SANDSTONE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/sandstone_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.BLACKSTONE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/blackstone_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.ENDSTONE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/endstone_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.GRANITE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/granite_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.TUFF_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/tuff_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.ANDESITE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/andesite_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.DIORITE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/diorite_cobble"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ModBlocks.CALCITE_COBBLESTONE_ITEM.get()).getPath(), modLoc("block/calcite_cobble"));




//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.RAW_TIN.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/raw_tin"));
//
//                singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.RAW_SILVER.get()).getPath(),
//                        mcLoc("item/generated"),
//                        "layer0", modLoc("item/raw_silver"));
//
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANT_FIBRE.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/plant_fibre"));
//
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRAIDED_PLANT_FIBRE.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/braided_plant_fibre"));
//
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.WOOL.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/wool"));
//
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.YARN.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/yarn"));



        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BASKET.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/basket"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.HIDE_SMALL.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/hides/hide_small"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.HIDE_MEDIUM.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/hides/hide_medium"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.HIDE_LARGE.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/hides/hide_large"));


//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.UNFIRED_CLAY_JUG.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/unfired_clay_jug"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.UNFIRED_CLAY_BUCKET.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/unfired_clay_bucket"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.UNFIRED_CLAY_VIAL.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/unfired_clay_vial"));
//
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_VIAL.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/clay_vial"));




        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.INGOT_TIN.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/ingots/ingot_tin"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.INGOT_BRONZE.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/ingots/ingot_bronze"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.INGOT_SILVER.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/ingots/ingot_silver"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.INGOT_STEEL.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/ingots/ingot_steel"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.NUGGET_TIN.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_tin"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.NUGGET_COPPER.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_copper"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.NUGGET_SILVER.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_silver"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.NUGGET_BRONZE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_bronze"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.NUGGET_STEEL.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/nuggets/nugget_steel"));

        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_TIN.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_tin"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_COPPER.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_copper"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_SILVER.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_silver"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_BRONZE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_bronze"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_STEEL.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_steel"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_IRON.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_iron"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_GOLD.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/dusts/dust_gold"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_SWORD.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_sword"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_PICK.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_pickaxe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_SHOVEL.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_shovel"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_AXE.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_axe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_HOE.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_hoe"));

        /*LOGS*/
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_OAK.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_oak"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_ACACIA.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_acacia"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_BIRCH.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_birch"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_SPRUCE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_spruce"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_CRIMSON.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_crimson"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_DARK_OAK.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_dark_oak"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_JUNGLE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_jungle"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_SPRUCE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_spruce"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.LOG_WARPED.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/woods/log_warped"));

        /*Planks*/
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_OAK.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_oak"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_ACACIA.get()).getPath(),
//                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_acacia"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_BIRCH.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_birch"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_SPRUCE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_spruce"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_CRIMSON.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_crimson"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_DARK_OAK.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_dark_oak"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_JUNGLE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_jungle"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_SPRUCE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_spruce"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.PLANK_WARPED.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/planks/plank_warped"));


        /*TODO setup layered texture*/
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_HELMET.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_helmet"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_CHEST.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_chest"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_LEGS.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_legs"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_BOOTS.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_boots"));
//

        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_STONE.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_stone"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_ANDESITE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_andesite"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_DEEPSLATE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_deepslate"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_DRIPSTONE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_dripstone"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_DIORITE.get()).getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_diorite"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_GRANITE.get()).getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_granite"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_BASALT.get()).getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_basalt"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_TUFF.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_tuff"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_NETHERRACK.get()).getPath(),
            mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_netherrack"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_BLACKSTONE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_blackstone"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_CALCITE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_calcite"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CHUNK_SANDSTONE.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/rocks/chunk_sandstone"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_STONE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_stone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_ANDESITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_andesite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_DEEPSLATE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_deepslate"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_DRIPSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_dripstone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_SANDSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_diorite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_DIORITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_granite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_GRANITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_basalt"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_BASALT.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_tuff"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_TUFF.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_netherrack"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_NETHERRACK.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_blackstone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.DUST_BLACKSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/dusts/dust_calcite"));



//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_STONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_stone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_ANDESITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_andesite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_DEEPSLATE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_deepslate"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_DRIPSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_dripstone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_SANDSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_diorite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_DIORITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_granite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_GRANITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_basalt"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_BASALT.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_tuff"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_TUFF.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_netherrack"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_NETHERRACK.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_blackstone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRICK_BLACKSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/bricks/brick_calcite"));



//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_STONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_stone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_ANDESITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_andesite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_DEEPSLATE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_deepslate"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_DRIPSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_dripstone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_SANDSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_diorite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_DIORITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_granite"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_GRANITE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_basalt"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_BASALT.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_tuff"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_TUFF.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_netherrack"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_NETHERRACK.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_blackstone"));
//      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_BLACKSTONE.get()).getPath(),
//              mcLoc("item/generated"),"layer0", modLoc("item/clay/clay_calcite"));


      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_KNIFE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_knife"));
      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_PICK.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_pickaxe"));
      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SHOVEL.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_shovel"));
      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_AXE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_axe"));
      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_HOE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_hoe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SAW.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/tools/flint_saw"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.STONE_HAMMER.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/tools/stone_hammer"));



      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_BLADE.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_knife"));
      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_PICK_HEAD.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_pickaxe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SHOVEL_HEAD.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_shovel"));
      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_AXE_HEAD.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_axe"));
      singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_HOE_HEAD.get()).getPath(),
              mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_hoe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SAW_HEAD.get()).getPath(),
                mcLoc("item/generated"),"layer0", modLoc("item/tools/toolhead_flint_saw"));



    }

}
