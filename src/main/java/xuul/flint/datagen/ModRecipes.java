package xuul.flint.datagen;

import xuul.flint.Flint;
import xuul.flint.common.init.ModBlocks;
import xuul.flint.common.init.ModItems;
import xuul.flint.common.init.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import xuul.flint.datagen.builders.CustomRecipeBuilder;
import xuul.flint.datagen.builders.ToolUseRecipeBuilder;


import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {

    public ModRecipes(DataGenerator generatorIn) {super(generatorIn);}

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer){

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.ORE_TIN_ITEM.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
                .group("flint")
                .unlockedBy("has_ore", has(ModItems.ORE_TIN_ITEM.get()))
                .save(consumer, RL("ingot_tin1"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_TIN.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(ModItems.RAW_TIN.get()))
                .save(consumer, RL("ingot_tin2"));


        /*Crafting Stations*/
        ShapelessRecipeBuilder.shapeless(ModBlocks.FLINT_STATION.get())
                .requires(Items.FLINT, 4)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer, RL("flint_station"));


        ShapedRecipeBuilder.shaped(Blocks.CRAFTING_TABLE)
                .pattern("xx")
                .pattern("xx")
                .define('x', ModTags.LOGS)
                .group("flint")
                .unlockedBy("log", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LOG_OAK.get()))
                .save(consumer);

        /*PLANT FIBRE*/
        ShapelessRecipeBuilder.shapeless(ModItems.BRAIDED_PLANT_FIBRE.get())
                .requires(ModItems.PLANT_FIBRE.get(), 3)
                .unlockedBy("has_plant_fibre", has(ModItems.PLANT_FIBRE.get()))
                .save(consumer);



        /*STONE BRICKS*/

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_STONE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_STONE.get(),2)
                .unlockedBy("has_dust_stone", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_ANDESITE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_ANDESITE.get(),2)
                .unlockedBy("has_dust_andesite", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_DEEPSLATE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_DEEPSLATE.get(),2)
                .unlockedBy("has_dust_deepslate", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_DRIPSTONE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_DRIPSTONE.get(),2)
                .unlockedBy("has_dust_dripstone", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_SANDSTONE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_SANDSTONE.get(),2)
                .unlockedBy("has_dust_sandstone", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_DIORITE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_DIORITE.get(),2)
                .unlockedBy("has_dust_diorite", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_GRANITE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_GRANITE.get(),2)
                .unlockedBy("has_dust_granite", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_BASALT.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_BASALT.get(),2)
                .unlockedBy("has_dust_basalt", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_TUFF.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_TUFF.get(),2)
                .unlockedBy("has_dust_tuff", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_NETHERRACK.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_NETHERRACK.get(),2)
                .unlockedBy("has_dust_netherrack", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_BLACKSTONE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_BLACKSTONE.get(),2)
                .unlockedBy("has_dust_blackstone", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_ENDSTONE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_ENDSTONE.get(),2)
                .unlockedBy("has_dust_endstone", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_CALCITE.get(), 1)
                .group("clay_bricks")
                .requires(Items.CLAY_BALL)
                .requires(ModItems.DUST_CALCITE.get(),2)
                .unlockedBy("has_dust_calcite", has(ModItems.DUST_BLACKSTONE.get()))
                .save(consumer);




         /*BLOCKS from ingot*/

        ShapelessRecipeBuilder.shapeless(ModItems.BLOCK_TIN_ITEM.get())
                .requires(ModItems.INGOT_TIN.get(), 9)
                .unlockedBy("has_tin_ingot", has(ModItems.INGOT_TIN.get()))
                .save(consumer, RL("tin_block_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModItems.BLOCK_BRONZE_ITEM.get())
                .requires(ModItems.INGOT_BRONZE.get(), 9)
                .unlockedBy("has_bronze_ingot", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_block_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModItems.BLOCK_SILVER_ITEM.get())
                .requires(ModItems.INGOT_SILVER.get(), 9)
                .unlockedBy("has_silver_ingot", has(ModItems.INGOT_SILVER.get()))
                .save(consumer, RL("silver_block_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModItems.BLOCK_STEEL_ITEM.get())
                .requires(ModItems.INGOT_STEEL.get(), 9)
                .unlockedBy("has_steel_ingot", has(ModItems.INGOT_STEEL.get()))
                .save(consumer, RL("steel_block_from_ingot"));

        /*Ingots from Nuggets*/

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_TIN.get())
                .requires(ModItems.NUGGET_TIN.get(), 9)
                .unlockedBy("has_tin_nugget", has(ModItems.NUGGET_TIN.get()))
                .save(consumer, RL("tin_ingot_from_nugget"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_BRONZE.get())
                .requires(ModItems.NUGGET_BRONZE.get(), 9)
                .unlockedBy("has_bronze_nugget", has(ModItems.NUGGET_BRONZE.get()))
                .save(consumer, RL("bronze_ingot_from_nugget"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_SILVER.get())
                .requires(ModItems.NUGGET_SILVER.get(), 9)
                .unlockedBy("has_silver_nugget", has(ModItems.NUGGET_SILVER.get()))
                .save(consumer, RL("silver_ingot_from_nugget"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_STEEL.get())
                .requires(ModItems.NUGGET_STEEL.get(), 9)
                .unlockedBy("has_steel_nugget", has(ModItems.NUGGET_STEEL.get()))
                .save(consumer,RL("steel_ingot_from_nugget"));

        /*Ingots from BLOCK*/

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_TIN.get(), 9)
                .requires(ModItems.BLOCK_TIN_ITEM.get())
                .unlockedBy("has_tin_block", has(ModItems.BLOCK_TIN_ITEM.get()))
                .save(consumer, RL("tin_ingot_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_BRONZE.get(), 9)
                .requires(ModItems.BLOCK_BRONZE_ITEM.get())
                .unlockedBy("has_bronze_block", has(ModItems.BLOCK_BRONZE_ITEM.get()))
                .save(consumer,RL( "bronze_ingot_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_SILVER.get(), 9)
                .requires(ModItems.BLOCK_SILVER_ITEM.get())
                .unlockedBy("has_silver_block", has(ModItems.BLOCK_SILVER_ITEM.get()))
                .save(consumer, RL("silver_ingot_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_STEEL.get(), 9)
                .requires(ModItems.BLOCK_STEEL_ITEM.get())
                .unlockedBy("has_steel_block", has(ModItems.BLOCK_STEEL_ITEM.get()))
                .save(consumer, RL("steel_ingot_from_block"));

        /*Nuggets from Ingot*/

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_TIN.get(), 9)
                .requires(ModItems.INGOT_TIN.get())
                .unlockedBy("has_ingot_tin", has(ModItems.INGOT_TIN.get()))
                .save(consumer, RL("nugget_tin_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_BRONZE.get(), 9)
                .requires(ModItems.INGOT_BRONZE.get())
                .unlockedBy("has_ingot_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("nugget_bronze_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_SILVER.get(), 9)
                .requires(ModItems.INGOT_SILVER.get())
                .unlockedBy("has_ingot_silver", has(ModItems.INGOT_SILVER.get()))
                .save(consumer, RL("nugget_silver_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_STEEL.get(), 9)
                .requires(ModItems.INGOT_STEEL.get())
                .unlockedBy("has_ingot_steel", has(ModItems.INGOT_STEEL.get()))
                .save(consumer, RL("nugget_steel_from_ingot"));


        ToolUseRecipeBuilder.build(ModItems.PLANK_OAK.get())
                .tool(ModTags.SAWS)
                .requires(ModItems.LOG_OAK.get())
                .unlockedBy("has_log", has(ModTags.LOGS))
                .save(consumer, RL("oak_plank_from_saw"));


        ToolUseRecipeBuilder.build(ModItems.PLANK_BIRCH.get())
                .tool(ModTags.SAWS)
                .requires(ModItems.LOG_BIRCH.get())
                .unlockedBy("has_log", has(ModTags.LOGS))
                .save(consumer, RL("birch_plank_from_saw"));



        /*Saw Recipes*/
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_OAK.get(), 1)
                .requires(ModItems.LOG_OAK.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_OAK.get()))
                .save(consumer, RL("oak_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_SPRUCE.get(), 1)
                .requires(ModItems.LOG_SPRUCE.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_SPRUCE.get()))
                .save(consumer, RL("spruce_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_BIRCH.get(), 1)
                .requires(ModItems.LOG_BIRCH.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_BIRCH.get()))
                .save(consumer, RL("birch_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_JUNGLE.get(), 1)
                .requires(ModItems.LOG_JUNGLE.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_JUNGLE.get()))
                .save(consumer, RL("jungle_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_ACACIA.get(), 1)
                .requires(ModItems.LOG_ACACIA.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_ACACIA.get()))
                .save(consumer, RL("acacia_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_DARK_OAK.get(), 1)
                .requires(ModItems.LOG_DARK_OAK.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_DARK_OAK.get()))
                .save(consumer, RL("dark_oak_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_AZALEA.get(), 1)
                .requires(ModItems.LOG_AZALEA.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_AZALEA.get()))
                .save(consumer, RL("azalea_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_WARPED.get(), 1)
                .requires(ModItems.LOG_WARPED.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_WARPED.get()))
                .save(consumer, RL("warped_plank_from_log"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_CRIMSON.get(), 1)
                .requires(ModItems.LOG_CRIMSON.get())
                .requires(ModTags.SAWS)
                .unlockedBy("has_log", has(ModItems.LOG_CRIMSON.get()))
                .save(consumer, RL("crimson_plank_from_log"));


/*Hammer Smashing */
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_STONE.get(), 1)
                .requires(ModItems.CHUNK_STONE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_STONE.get()))
                .save(consumer, RL("stone_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_ANDESITE.get(), 1)
                .requires(ModItems.CHUNK_ANDESITE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_ANDESITE.get()))
                .save(consumer, RL("andesite_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_DEEPSLATE.get(), 1)
                .requires(ModItems.CHUNK_DEEPSLATE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_DEEPSLATE.get()))
                .save(consumer, RL("deepslate_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_SANDSTONE.get(), 1)
                .requires(ModItems.CHUNK_SANDSTONE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_SANDSTONE.get()))
                .save(consumer, RL("sandstone_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_DRIPSTONE.get(), 1)
                .requires(ModItems.CHUNK_DRIPSTONE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_DRIPSTONE.get()))
                .save(consumer, RL("dripstone_block_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_DIORITE.get(), 1)
                .requires(ModItems.CHUNK_DIORITE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_DIORITE.get()))
                .save(consumer, RL("diorite_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_GRANITE.get(), 1)
                .requires(ModItems.CHUNK_GRANITE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_GRANITE.get()))
                .save(consumer, RL("granite_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_BASALT.get(), 1)
                .requires(ModItems.CHUNK_BASALT.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_BASALT.get()))
                .save(consumer, RL("basalt_dust_from_chunk"));

        ShapelessRecipeBuilder.shapeless(ModItems.DUST_TUFF.get(), 1)
                .requires(ModItems.CHUNK_TUFF.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_TUFF.get()))
                .save(consumer, RL("tuff_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_NETHERRACK.get(), 1)
                .requires(ModItems.CHUNK_NETHERRACK.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_NETHERRACK.get()))
                .save(consumer, RL("netherrack_dust_from_chunk"));
        ShapelessRecipeBuilder.shapeless(ModItems.DUST_BLACKSTONE.get(), 1)
                .requires(ModItems.CHUNK_BLACKSTONE.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_chunk", has(ModItems.CHUNK_BLACKSTONE.get()))
                .save(consumer, RL("blackstone_dust_from_chunk"));





        /*TOOLS*/

        ShapedRecipeBuilder.shaped(ModItems.FLINT_KNIFE.get())
                .pattern("I")
                .pattern("T")
                .define('I', ModItems.FLINT_BLADE.get())
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_BLADE.get()))
                .save(consumer, RL("flint_knife"));

        ShapedRecipeBuilder.shaped(ModItems.FLINT_PICK.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_PICK_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_PICK_HEAD.get()))
                .save(consumer, RL("flint_pick"));


        ShapedRecipeBuilder.shaped(ModItems.FLINT_SHOVEL.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_SHOVEL_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_SHOVEL_HEAD.get()))
                .save(consumer, RL("flint_shovel"));


        ShapedRecipeBuilder.shaped(ModItems.FLINT_AXE.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_AXE_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_AXE_HEAD.get()))
                .save(consumer, RL("flint_axe"));


        ShapedRecipeBuilder.shaped(ModItems.FLINT_HOE.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_HOE_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_HOE_HEAD.get()))
                .save(consumer, RL("flint_hoe"));

        ShapelessRecipeBuilder.shapeless(ModItems.FLINT_SAW.get(), 1)
                .requires(ModItems.FLINT_SAW_HEAD.get())
                .requires(Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer, RL("flint_saw"));


        ShapelessRecipeBuilder.shapeless(ModItems.FLINT_BLADE.get())
                .requires(Items.FLINT, 2)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);



        CustomRecipeBuilder.flintstation(Ingredient.of(Items.FLINT), ModItems.FLINT_BLADE.get(), 1)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer, RL("blade_from_flint_station"));
        CustomRecipeBuilder.flintstation(Ingredient.of(Items.FLINT), ModItems.FLINT_PICK_HEAD.get(), 1)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);
        CustomRecipeBuilder.flintstation(Ingredient.of(Items.FLINT), ModItems.FLINT_SHOVEL_HEAD.get(), 1)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);
        CustomRecipeBuilder.flintstation(Ingredient.of(Items.FLINT), ModItems.FLINT_AXE_HEAD.get(), 1)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);
        CustomRecipeBuilder.flintstation(Ingredient.of(Items.FLINT), ModItems.FLINT_HOE_HEAD.get(), 1)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);
        CustomRecipeBuilder.flintstation(Ingredient.of(Items.FLINT), ModItems.FLINT_SAW_HEAD.get(), 1)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);




        /*Flint from gravel*/
        ShapelessRecipeBuilder.shapeless(Items.FLINT)
                .requires(Blocks.GRAVEL, 2)
                .unlockedBy("has_gravel", has(Blocks.GRAVEL))
                .save(consumer, RL("flint_from_gravel"));











    }

    private ResourceLocation RL(String string){
        return new ResourceLocation(Flint.MOD_ID, string);
    }
}
