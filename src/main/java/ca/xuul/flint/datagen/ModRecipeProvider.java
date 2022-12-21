package ca.xuul.flint.datagen;

import ca.xuul.flint.Flint;
import ca.xuul.flint.datagen.builders.CustomRecipeBuilder;
import ca.xuul.flint.datagen.builders.FoundryFuelRecipeBuilder;
import ca.xuul.flint.datagen.builders.FoundryRecipeBuilder;
import ca.xuul.flint.datagen.builders.ToolUseRecipeBuilder;
import ca.xuul.flint.init.ModBlocks;
import ca.xuul.flint.init.ModItems;
import ca.xuul.flint.init.ModTags;
import ca.xuul.flint.item.FuelItem;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jline.utils.Log;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        final int BURN_TIME_STANDARD = 20 * 10 * 8;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ORE_TIN.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
            .group("flint")
            .unlockedBy("has_ore", has(ModBlocks.ORE_TIN.get()))
            .save(consumer, RL("ingot_tin1"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_TIN.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
            .unlockedBy("has_ore", has(ModItems.RAW_TIN.get()))
            .save(consumer, RL("ingot_tin2"));


        /*Crafting Stations*/
        ShapelessRecipeBuilder.shapeless(ModBlocks.FLINT_STATION.get())
               .requires(Items.FLINT, 4)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);


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

        ShapelessRecipeBuilder.shapeless(ModItems.YARN.get(), 1)
                .requires(ModItems.WOOL.get())

                .unlockedBy("has_wool", has(ModItems.WOOL.get()))
                .save(consumer, RL("yarn_from_wool"));

        ShapelessRecipeBuilder.shapeless(Items.STRING, 1)
                .requires(ModItems.YARN.get(), 3)
                .requires(ModItems.SPINDLE.get())
                .unlockedBy("has_yarn", has(ModItems.YARN.get()))
                .save(consumer, RL("string_from_yarn"));

        ShapelessRecipeBuilder.shapeless(Blocks.WHITE_WOOL, 1)
                .requires(ModItems.WOOL.get(), 4)
                .unlockedBy("has_wool", has(ModItems.WOOL.get()))
                .save(consumer, RL("wool_block_from_wool"));




        /*STONE BRICKS*/

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_STONE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_STONE.get(), 2)
            .unlockedBy("has_dust_stone", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_ANDESITE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_ANDESITE.get(), 2)
            .unlockedBy("has_dust_andesite", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_DEEPSLATE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_DEEPSLATE.get(), 2)
            .unlockedBy("has_dust_deepslate", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_DRIPSTONE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_DRIPSTONE.get(), 2)
            .unlockedBy("has_dust_dripstone", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_SANDSTONE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_SANDSTONE.get(), 2)
            .unlockedBy("has_dust_sandstone", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_DIORITE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_DIORITE.get(), 2)
            .unlockedBy("has_dust_diorite", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_GRANITE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_GRANITE.get(), 2)
            .unlockedBy("has_dust_granite", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_BASALT.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_BASALT.get(), 2)
            .unlockedBy("has_dust_basalt", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_TUFF.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_TUFF.get(), 2)
            .unlockedBy("has_dust_tuff", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_NETHERRACK.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_NETHERRACK.get(), 2)
            .unlockedBy("has_dust_netherrack", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_BLACKSTONE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_BLACKSTONE.get(), 2)
            .unlockedBy("has_dust_blackstone", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_ENDSTONE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_ENDSTONE.get(), 2)
            .unlockedBy("has_dust_endstone", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.CLAY_CALCITE.get(), 1)
            .group("clay_bricks")
            .requires(Items.CLAY_BALL)
            .requires(ModItems.DUST_CALCITE.get(), 2)
            .unlockedBy("has_dust_calcite", has(ModItems.DUST_BLACKSTONE.get()))
            .save(consumer);




        /*BLOCKS from ingot*/

        ShapelessRecipeBuilder.shapeless(ModBlocks.BLOCK_TIN.get())
            .requires(ModItems.INGOT_TIN.get(), 9)
            .unlockedBy("has_tin_ingot", has(ModItems.INGOT_TIN.get()))
            .save(consumer, RL("tin_block_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModBlocks.BLOCK_BRONZE.get())
            .requires(ModItems.INGOT_BRONZE.get(), 9)
            .unlockedBy("has_bronze_ingot", has(ModItems.INGOT_BRONZE.get()))
            .save(consumer, RL("bronze_block_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModBlocks.BLOCK_SILVER.get())
            .requires(ModItems.INGOT_SILVER.get(), 9)
            .unlockedBy("has_silver_ingot", has(ModItems.INGOT_SILVER.get()))
            .save(consumer, RL("silver_block_from_ingot"));

        ShapelessRecipeBuilder.shapeless(ModBlocks.BLOCK_STEEL.get())
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
            .save(consumer, RL("steel_ingot_from_nugget"));

        /*Ingots from BLOCK*/

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_TIN.get(), 9)
            .requires(ModBlocks.BLOCK_TIN.get())
            .unlockedBy("has_tin_block", has(ModBlocks.BLOCK_TIN.get()))
            .save(consumer, RL("tin_ingot_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_BRONZE.get(), 9)
            .requires(ModBlocks.BLOCK_BRONZE.get())
            .unlockedBy("has_bronze_block", has(ModBlocks.BLOCK_BRONZE.get()))
            .save(consumer, RL("bronze_ingot_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_SILVER.get(), 9)
            .requires(ModBlocks.BLOCK_SILVER.get())
            .unlockedBy("has_silver_block", has(ModBlocks.BLOCK_SILVER.get()))
            .save(consumer, RL("silver_ingot_from_block"));

        ShapelessRecipeBuilder.shapeless(ModItems.INGOT_STEEL.get(), 9)
            .requires(ModBlocks.BLOCK_STEEL.get())
            .unlockedBy("has_steel_block", has(ModBlocks.BLOCK_STEEL.get()))
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




        /*Saw Recipes*/
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_OAK.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_OAK.get())
                .unlockedBy("has_log", has(ModItems.LOG_OAK.get()))
                .save(consumer, RL("oak_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_SPRUCE.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_SPRUCE.get())
                .unlockedBy("has_log", has(ModItems.LOG_SPRUCE.get()))
                .save(consumer, RL("spruce_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_BIRCH.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_BIRCH.get())
                .unlockedBy("has_log", has(ModItems.LOG_BIRCH.get()))
                .save(consumer, RL("birch_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_JUNGLE.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_JUNGLE.get())
                .unlockedBy("has_log", has(ModItems.LOG_JUNGLE.get()))
                .save(consumer, RL("jungle_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_ACACIA.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_ACACIA.get())
                .unlockedBy("has_log", has(ModItems.LOG_ACACIA.get()))
                .save(consumer, RL("acacia_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_DARK_OAK.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_DARK_OAK.get())
                .unlockedBy("has_log", has(ModItems.LOG_DARK_OAK.get()))
                .save(consumer, RL("dark_oak_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_MANGROVE.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_MANGROVE.get())
                .unlockedBy("has_log", has(ModItems.LOG_MANGROVE.get()))
                .save(consumer, RL("mangrove_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_WARPED.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_WARPED.get())
                .unlockedBy("has_log", has(ModItems.LOG_WARPED.get()))
                .save(consumer, RL("warped_plank_from_saw"));
        ShapelessRecipeBuilder.shapeless(ModItems.PLANK_CRIMSON.get(), 1)
                .requires(ModTags.SAWS)
                .requires(ModItems.LOG_CRIMSON.get())
                .unlockedBy("has_log", has(ModItems.LOG_CRIMSON.get()))
                .save(consumer, RL("crimson_plank_from_saw"));


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


        ShapelessRecipeBuilder.shapeless(Items.RAW_IRON, 1)
                .requires(ItemTags.IRON_ORES)
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_raw", has(ItemTags.IRON_ORES))
                .save(consumer, RL("raw_iron_hammered_from_ore"));

        ShapelessRecipeBuilder.shapeless(Items.RAW_COPPER, 1)
                .requires(ItemTags.COPPER_ORES)
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_raw", has(ItemTags.COPPER_ORES))
                .save(consumer, RL("raw_copper_hammered_from_ore"));

        ShapelessRecipeBuilder.shapeless(Items.RAW_GOLD, 1)
                .requires(ItemTags.GOLD_ORES)
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_raw", has(ItemTags.GOLD_ORES))
                .save(consumer, RL("raw_gold_hammered_from_ore"));





        ShapelessRecipeBuilder.shapeless(ModItems.RAW_TIN.get(), 1)
                .requires(ModBlocks.ORE_TIN.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_raw", has(ModBlocks.ORE_TIN.get()))
                .save(consumer, RL("raw_tin_hammered_from_ore"));

        ShapelessRecipeBuilder.shapeless(ModItems.RAW_SILVER.get(), 1)
                .requires(ModBlocks.ORE_SILVER.get())
                .requires(ModTags.HAMMERS)
                .unlockedBy("has_raw", has(ModBlocks.ORE_TIN.get()))
                .save(consumer, RL("raw_silver_hammered_from_ore"));





        /*TOOLS*/

        ShapelessRecipeBuilder.shapeless(ModItems.FLINT_KNIFE.get())
               .requires(ModItems.FLINT_BLADE.get())
                .requires(Items.STICK)
                .unlockedBy("flint", has(Items.FLINT))
                .save(consumer, RL("flint_knife"));

        ShapedRecipeBuilder.shaped(ModItems.STONE_HAMMER.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModTags.STONE_CHUNKS)
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_stone_chunk", has(ModTags.STONE_CHUNKS))
                .save(consumer, RL("stone_hammer"));

        ShapedRecipeBuilder.shaped(ModItems.FLINT_PICK.get())
            .pattern("I")
            .pattern("x")
            .pattern("T")
            .define('I', ModItems.FLINT_PICK_HEAD.get())
            .define('x', ModTags.BINDINGS)
            .define('T', Items.STICK)
            .unlockedBy("flint_pick_head", has(ModItems.FLINT_PICK_HEAD.get()))
            .save(consumer, RL("flint_pick"));

        ShapedRecipeBuilder.shaped(ModItems.FLINT_SHOVEL.get())
            .pattern("I")
            .pattern("x")
            .pattern("T")
            .define('I', ModItems.FLINT_SHOVEL_HEAD.get())
            .define('x', ModTags.BINDINGS)
            .define('T', Items.STICK)
            .unlockedBy("flint", has(ModItems.FLINT_SHOVEL_HEAD.get()))
            .save(consumer, RL("flint_shovel"));


        ShapedRecipeBuilder.shaped(ModItems.FLINT_AXE.get())
            .pattern("Ix")
            .pattern(" T")
            .define('I', ModItems.FLINT_AXE_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
            .unlockedBy("flint", has(ModItems.FLINT_AXE_HEAD.get()))
            .save(consumer, RL("flint_axe"));


        ShapedRecipeBuilder.shaped(ModItems.FLINT_HOE.get())
            .pattern("I")
            .pattern("x")
            .pattern("T")
            .define('I', ModItems.FLINT_HOE_HEAD.get())
            .define('x', ModTags.BINDINGS)
            .define('T', Items.STICK)
            .unlockedBy("flint", has(ModItems.FLINT_HOE_HEAD.get()))
            .save(consumer, RL("flint_hoe"));

        ShapelessRecipeBuilder.shapeless(ModItems.FLINT_SAW.get(), 1)
            .requires(ModItems.FLINT_SAW_HEAD.get())
            .requires(Items.STICK)
            .unlockedBy("has_stick", has(ModItems.FLINT_SAW_HEAD.get()))
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

        /*Grindstone*/
//        CustomRecipeBuilder.grindstone(Ingredient.of(ModItems.CHUNK_STONE.get()), ModItems.DUST_STONE.get(), 1)
//                .unlockedBy("has_stone", has(Items.FLINT))
//                .save(consumer);
//
//
//

        /*CLAY */
        ShapedRecipeBuilder.shaped(ModItems.UNFIRED_CLAY_JUG.get())
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)

                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, RL("unfired_clay_jug"));

        ShapedRecipeBuilder.shaped(ModItems.UNFIRED_CLAY_BUCKET.get())
                .pattern("x x")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)

                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, RL("unfired_clay_bucket"));

        ShapedRecipeBuilder.shaped(ModItems.UNFIRED_CLAY_VIAL.get())
                .pattern("x x")
                .pattern(" x ")
                .define('x', ModTags.CLAY)

                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, RL("unfired_clay_vial"));


        /*Wood Plank*/
        ShapedRecipeBuilder.shaped(Items.CHEST)
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.PLANKS)

                .unlockedBy("planks", has(ModTags.PLANKS))
                .save(consumer);





        /*Foundry Fuels*/

        new FoundryFuelRecipeBuilder(Ingredient.of(ItemTags.COALS), 500, 20 * 10 * 8)
            .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
            .save(consumer, RL("foundry_fuel/coals"));
        new FoundryFuelRecipeBuilder(Ingredient.of(Items.BLAZE_ROD), 1000, 20 * 10 * 8)
            .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
            .save(consumer, RL("foundry_fuel/blaze"));

        FuelSetup(ModItems.PLANK_OAK,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_SPRUCE,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_BIRCH,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_JUNGLE,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_ACACIA,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_DARK_OAK,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_MANGROVE,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_WARPED,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_CRIMSON,BURN_TIME_STANDARD, consumer);

        FuelSetup(ModItems.LOG_OAK,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_SPRUCE,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_BIRCH,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_JUNGLE,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_ACACIA,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_DARK_OAK,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_MANGROVE,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_WARPED,BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_CRIMSON,BURN_TIME_STANDARD, consumer);




        /*Foundry Cooks*/
        new FoundryRecipeBuilder(Ingredient.of(Items.STICK), Items.TORCH, 2, 300)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/torch"));

        new FoundryRecipeBuilder(Ingredient.of(ItemTags.SAND), Items.GLASS, 1, 500)
            .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
            .save(consumer, RL("foundry/glass"));

        new FoundryRecipeBuilder(Ingredient.of(Items.DIRT), Items.DIAMOND, 1, 1000)
            .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
            .save(consumer, RL("foundry/dirt_to_diamond"));

        /*Flint from gravel*/
        ShapelessRecipeBuilder.shapeless(Items.FLINT)
            .requires(Blocks.GRAVEL, 3)
            .unlockedBy("has_gravel", has(Blocks.GRAVEL))
            .save(consumer, RL("flint_from_gravel"));


        /*TODO Conditional Recipe*/
//        ConditionalRecipe.builder().addCondition(FalseCondition.INSTANCE).build(consumer, new ResourceLocation("torch"));


    }

    private ResourceLocation RL(String string) {
        return new ResourceLocation(Flint.MOD_ID, string);
    }

    public static InventoryChangeTrigger.TriggerInstance has(MinMaxBounds.Ints pCount, ItemLike pItem) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItem).withCount(pCount).build());
    }

    /**
     * Creates a new {@link InventoryChangeTrigger} that checks for a player having a certain item.
     */
    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
    }

    public static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> tagKey) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tagKey).build());
    }

    /*Helpers*/
    private void FuelSetup(RegistryObject<FuelItem> item, int cookTime, Consumer<FinishedRecipe> recipeConsumer) {
        String s = "foundry_fuel/" + item.get();
        new FoundryFuelRecipeBuilder(Ingredient.of(item.get()), item.get().getHeat(), cookTime)
                .unlockedBy("has_" + item.getKey(), has(item.get()))
                .save(recipeConsumer, RL(s));
    };
}
