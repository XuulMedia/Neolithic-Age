package com.xuul.flint.datagen;

import com.xuul.flint.init.ModItems;
import com.xuul.flint.init.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;


import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {

    public ModRecipes(DataGenerator generatorIn) {super(generatorIn);}

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer){

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.ORE_TIN_ITEM.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
                .group("flint")
                .unlockedBy("has_ore", has(ModItems.ORE_TIN_ITEM.get()))
                .save(consumer, "ingot_tin1");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_TIN.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(ModItems.RAW_TIN.get()))
                .save(consumer, "ingot_tin2");

        /*PLANT FIBRE*/
        ShapelessRecipeBuilder.shapeless(ModItems.BRAIDED_PLANT_FIBRE.get())
                .requires(ModTags.BINDINGS)
                .requires(ModTags.BINDINGS)
                .requires(ModTags.BINDINGS)
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
                .save(consumer, "tin_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(ModItems.BLOCK_BRONZE_ITEM.get())
                .requires(ModItems.INGOT_BRONZE.get(), 9)
                .unlockedBy("has_bronze_ingot", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, "bronze_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(ModItems.BLOCK_SILVER_ITEM.get())
                .requires(ModItems.INGOT_SILVER.get(), 9)
                .unlockedBy("has_silver_ingot", has(ModItems.INGOT_SILVER.get()))
                .save(consumer, "silver_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(ModItems.BLOCK_STEEL_ITEM.get())
                .requires(ModItems.INGOT_STEEL.get(), 9)
                .unlockedBy("has_steel_ingot", has(ModItems.INGOT_STEEL.get()))
                .save(consumer, "steel_block_from_ingot");

        /*Ingots from Nuggets*/

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_TIN.get())
                .requires(ModItems.NUGGET_TIN.get(), 9)
                .unlockedBy("has_tin_nugget", has(ModItems.NUGGET_TIN.get()))
                .save(consumer, "tin_ingot_from_nugget");

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_BRONZE.get())
                .requires(ModItems.NUGGET_BRONZE.get(), 9)
                .unlockedBy("has_bronze_nugget", has(ModItems.NUGGET_BRONZE.get()))
                .save(consumer, "bronze_ingot_from_nugget");

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_SILVER.get())
                .requires(ModItems.NUGGET_SILVER.get(), 9)
                .unlockedBy("has_silver_nugget", has(ModItems.NUGGET_SILVER.get()))
                .save(consumer, "silver_ingot_from_nugget");

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_STEEL.get())
                .requires(ModItems.NUGGET_STEEL.get(), 9)
                .unlockedBy("has_steel_nugget", has(ModItems.NUGGET_STEEL.get()))
                .save(consumer, "steel_ingot_from_nugget");

        /*Ingots from BLOCK*/

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_TIN.get(), 9)
                .requires(ModItems.BLOCK_TIN_ITEM.get())
                .unlockedBy("has_tin_block", has(ModItems.BLOCK_TIN_ITEM.get()))
                .save(consumer, "tin_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_BRONZE.get(), 9)
                .requires(ModItems.BLOCK_BRONZE_ITEM.get())
                .unlockedBy("has_bronze_block", has(ModItems.BLOCK_BRONZE_ITEM.get()))
                .save(consumer, "bronze_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_SILVER.get(), 9)
                .requires(ModItems.BLOCK_SILVER_ITEM.get())
                .unlockedBy("has_silver_block", has(ModItems.BLOCK_SILVER_ITEM.get()))
                .save(consumer, "silver_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_STEEL.get(), 9)
                .requires(ModItems.BLOCK_STEEL_ITEM.get())
                .unlockedBy("has_steel_block", has(ModItems.BLOCK_STEEL_ITEM.get()))
                .save(consumer, "steel_ingot_from_block");

        /*Nuggets from Ingot*/

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_TIN.get(), 9)
                .requires(ModItems.INGOT_TIN.get())
                .unlockedBy("has_ingot_tin", has(ModItems.INGOT_TIN.get()))
                .save(consumer, "nugget_tin_from_ingot");

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_BRONZE.get(), 9)
                .requires(ModItems.INGOT_BRONZE.get())
                .unlockedBy("has_ingot_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, "nugget_bronze_from_ingot");

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_SILVER.get(), 9)
                .requires(ModItems.INGOT_SILVER.get())
                .unlockedBy("has_ingot_silver", has(ModItems.INGOT_SILVER.get()))
                .save(consumer, "nugget_silver_from_ingot");

        ShapelessRecipeBuilder.shapeless(ModItems.NUGGET_STEEL.get(), 9)
                .requires(ModItems.INGOT_STEEL.get())
                .unlockedBy("has_ingot_steel", has(ModItems.INGOT_STEEL.get()))
                .save(consumer, "nugget_steel_from_ingot");


        /*TODO: create a custom Recipe builder to datagen custom recipes*/

        /*TOOLS*/

        ShapedRecipeBuilder.shaped(ModItems.FLINT_KNIFE.get())
                .pattern("I")
                .pattern("T")
                .define('I', ModItems.FLINT_BLADE.get())
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_BLADE.get()))
                .save(consumer, "flint_knife");

        ShapedRecipeBuilder.shaped(ModItems.FLINT_PICK.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_PICK_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_PICK_HEAD.get()))
                .save(consumer, "flint_pick");


        ShapedRecipeBuilder.shaped(ModItems.FLINT_SHOVEL.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_SHOVEL_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_SHOVEL_HEAD.get()))
                .save(consumer, "flint_shovel");


        ShapedRecipeBuilder.shaped(ModItems.FLINT_AXE.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_AXE_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_AXE_HEAD.get()))
                .save(consumer, "flint_axe");


        ShapedRecipeBuilder.shaped(ModItems.FLINT_HOE.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_HOE_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("flint")
                .unlockedBy("flint", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLINT_HOE_HEAD.get()))
                .save(consumer, "flint_hoe");


        CustomRecipeBuilder.flintstation(Ingredient.of(Items.FLINT), ModItems.FLINT_BLADE.get(), 1).unlockedBy("has_stone", has(Blocks.PRISMARINE_BRICKS))
                .save(consumer, "flint_blade_from_station");












    }
}
