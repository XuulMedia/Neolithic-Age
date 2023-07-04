package github.xuulmedia.neolith.datagen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.datagen.builders.DisableRecipeBuilder;
import github.xuulmedia.neolith.datagen.builders.HeatRecipeBuilder;
import github.xuulmedia.neolith.datagen.builders.HeatingFuelRecipeBuilder;
import github.xuulmedia.neolith.datagen.builders.NeolithRecipeBuilder;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModItems;
import github.xuulmedia.neolith.init.ModTags;
import github.xuulmedia.neolith.item.custom.FuelItem;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.NonNullList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        //Burn time in ticks * Seconds
        final int SHORT_BURN_TIME = 20 * 15; // similar to logs
        final int BURN_TIME_STANDARD = 20 * 80; // similar to coal
        final int BURN_TIME_LONG = 20 * 120; // similar to blaze Rods

        //block of kelp is 20 * 120
        //block of coal is 20 * 800
        //lava bucket is 20x1000

        //Low wood - 250
        // med wood 350
        // high wood - 500

        //Items normally take 200 ticks or 10 seconds * 20 tick
        final int SLOW_SMELT_TIME = 20 * 30;
        final int STANDARD_SMELT_TIME = 20 * 10;
        final int FAST_SMELT_TIME = 20 * 5;


        disable(Items.WOODEN_AXE, consumer);
        disable(Items.WOODEN_HOE, consumer);
        disable(Items.WOODEN_PICKAXE, consumer);
        disable(Items.WOODEN_SHOVEL, consumer);
        disable(Items.WOODEN_SWORD, consumer);

        disable(Items.STONE_AXE, consumer);
        disable(Items.STONE_HOE, consumer);
        disable(Items.STONE_PICKAXE, consumer);
        disable(Items.STONE_SHOVEL, consumer);
        disable(Items.STONE_SWORD, consumer);

        disable(Items.GOLDEN_AXE, consumer);
        disable(Items.GOLDEN_HOE, consumer);
        disable(Items.GOLDEN_PICKAXE, consumer);
        disable(Items.GOLDEN_SHOVEL, consumer);
        disable(Items.GOLDEN_SWORD, consumer);

        disable(Items.IRON_AXE, consumer);
        disable(Items.IRON_HOE, consumer);
        disable(Items.IRON_PICKAXE, consumer);
        disable(Items.IRON_SHOVEL, consumer);
        disable(Items.IRON_SWORD, consumer);

        disable(Items.DIAMOND_AXE, consumer);
        disable(Items.DIAMOND_HOE, consumer);
        disable(Items.DIAMOND_PICKAXE, consumer);
        disable(Items.DIAMOND_SHOVEL, consumer);
        disable(Items.DIAMOND_SWORD, consumer);

        disable(Blocks.CAMPFIRE, consumer);
        disable(Blocks.FURNACE, consumer);
        disable(Blocks.BLAST_FURNACE, consumer);

        disableCookFood(Items.COOKED_BEEF, consumer);
        disableCookFood(Items.COOKED_CHICKEN, consumer);
        disableCookFood(Items.COOKED_COD, consumer);
        disableCookFood(Items.COOKED_MUTTON, consumer);
        disableCookFood(Items.COOKED_PORKCHOP, consumer);
        disableCookFood(Items.COOKED_SALMON, consumer);
        disableCookFood(Items.COOKED_RABBIT, consumer);
        disableCookFood(Items.BAKED_POTATO, consumer);

        disableProcessOre(Items.RAW_IRON, Items.IRON_INGOT, consumer);
        disableProcessOre(Items.RAW_GOLD, Items.GOLD_INGOT, consumer);
        disableProcessOre(Items.RAW_COPPER, Items.COPPER_INGOT, consumer);

        disableProcessOre(Items.IRON_ORE, Items.IRON_INGOT, consumer);
        disableProcessOre(Items.GOLD_ORE, Items.GOLD_INGOT, consumer);
        disableProcessOre(Items.COPPER_ORE, Items.COPPER_INGOT, consumer);

        disableProcessOre(Items.DEEPSLATE_IRON_ORE, Items.IRON_INGOT, consumer);
        disableProcessOre(Items.DEEPSLATE_GOLD_ORE, Items.GOLD_INGOT, consumer);
        disableProcessOre(Items.DEEPSLATE_COPPER_ORE, Items.COPPER_INGOT, consumer);



        /*Flint from gravel*/
        simpleShapeless(Blocks.GRAVEL, 3, Items.FLINT, consumer);

        /*create torches*/
        campfireCook(Items.STICK, ModBlocks.TORCH.get(), 10, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(Items.STICK, ModBlocks.TORCH.get(), 80, FAST_SMELT_TIME, consumer);


        flintStation(Items.FLINT, ModItems.FLINT_BLADE.get(), consumer);
        flintStation(Items.FLINT, ModItems.FLINT_PICK_HEAD.get(), consumer);
        flintStation(Items.FLINT, ModItems.FLINT_SHOVEL_HEAD.get(), consumer);
        flintStation(Items.FLINT, ModItems.FLINT_AXE_HEAD.get(), consumer);
        flintStation(Items.FLINT, ModItems.FLINT_HOE_HEAD.get(), consumer);
        flintStation(Items.FLINT, ModItems.FLINT_SAW_HEAD.get(), consumer);

        /*metal processing*/
        forgeRecipe(ModItems.RAW_TIN.get(), ModItems.INGOT_TIN.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.DUST_TIN.get(), ModItems.INGOT_TIN.get(), 250, FAST_SMELT_TIME, consumer);
        forgeRecipe(ModBlocks.ORE_TIN.get(), ModItems.INGOT_TIN.get(), 250, STANDARD_SMELT_TIME, consumer);

        forgeRecipe(Items.RAW_COPPER, Items.COPPER_INGOT, 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.DUST_COPPER.get(), Items.COPPER_INGOT, 250, FAST_SMELT_TIME, consumer);
        forgeRecipe(Blocks.COPPER_ORE, Items.COPPER_INGOT, 250, STANDARD_SMELT_TIME, consumer);

        forgeRecipe(ModItems.DUST_BRONZE.get(), ModItems.INGOT_BRONZE.get(), 350, STANDARD_SMELT_TIME, consumer);

        forgeRecipe(Items.RAW_IRON, Items.IRON_INGOT, 350, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.DUST_IRON.get(), Items.IRON_INGOT, 350, FAST_SMELT_TIME, consumer);
        forgeRecipe(Blocks.IRON_ORE, Items.IRON_INGOT, 350, STANDARD_SMELT_TIME, consumer);

        forgeRecipe(ModItems.DUST_STEEL.get(), ModItems.INGOT_STEEL.get(), 500, SLOW_SMELT_TIME, consumer);

        forgeRecipe(Items.RAW_GOLD, Items.GOLD_INGOT, 350, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.DUST_GOLD.get(), Items.GOLD_INGOT, 350, FAST_SMELT_TIME, consumer);
        forgeRecipe(Blocks.GOLD_ORE, Items.GOLD_INGOT, 350, STANDARD_SMELT_TIME, consumer);

        forgeRecipe(ModItems.RAW_SILVER.get(), ModItems.INGOT_SILVER.get(), 400, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.DUST_SILVER.get(), ModItems.INGOT_SILVER.get(), 400, FAST_SMELT_TIME, consumer);
        forgeRecipe(ModBlocks.ORE_SILVER.get(), ModItems.INGOT_SILVER.get(), 400, STANDARD_SMELT_TIME, consumer);


        foundryRecipe1to1(ModItems.RAW_SILVER.get(), ModItems.INGOT_SILVER.get(), 400, STANDARD_SMELT_TIME, consumer);
        foundryRecipe2to1(ModItems.DUST_COPPER.get(), ModItems.DUST_TIN.get(), ModItems.INGOT_BRONZE.get(), 400, STANDARD_SMELT_TIME, consumer);
//        foundryRecipe2to2(Blocks.IRON_ORE, ModBlocks.ORE_SILVER.get(), ModItems.INGOT_BRONZE.get(), Items.STICK, 200, 200, consumer);


        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_TIN.get(), ModItems.INGOT_TIN.get(), ModBlocks.BLOCK_TIN.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_BRONZE.get(), ModItems.INGOT_BRONZE.get(), ModBlocks.BLOCK_BRONZE.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_SILVER.get(), ModItems.INGOT_SILVER.get(), ModBlocks.BLOCK_SILVER.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_STEEL.get(), ModItems.INGOT_STEEL.get(), ModBlocks.BLOCK_STEEL.get(), consumer);

        //Saw plank to board
        sawLog(ModItems.LOG_ACACIA.get(), ModItems.PLANK_ACACIA.get(), consumer);
        sawLog(ModItems.LOG_BIRCH.get(), ModItems.PLANK_BIRCH.get(), consumer);
        sawLog(ModItems.LOG_CHERRY.get(), ModItems.PLANK_CHERRY.get(), consumer);
        sawLog(ModItems.LOG_DARK_OAK.get(), ModItems.PLANK_DARK_OAK.get(), consumer);
        sawLog(ModItems.LOG_JUNGLE.get(), ModItems.PLANK_JUNGLE.get(), consumer);
        sawLog(ModItems.LOG_MANGROVE.get(), ModItems.PLANK_MANGROVE.get(), consumer);
        sawLog(ModItems.LOG_OAK.get(), ModItems.PLANK_OAK.get(), consumer);
        sawLog(ModItems.LOG_SPRUCE.get(), ModItems.PLANK_SPRUCE.get(), consumer);
        sawLog(ModItems.LOG_WARPED.get(), ModItems.PLANK_WARPED.get(), consumer);
        sawLog(ModItems.LOG_CRIMSON.get(), ModItems.PLANK_CRIMSON.get(), consumer);

        //Stone chunk to dust
        hammerSmash(ModItems.CHUNK_ANDESITE.get(), ModItems.DUST_ANDESITE.get(), consumer);
        hammerSmash(ModItems.CHUNK_BASALT.get(), ModItems.DUST_BASALT.get(), consumer);
        hammerSmash(ModItems.CHUNK_BLACKSTONE.get(), ModItems.DUST_BLACKSTONE.get(), consumer);
        hammerSmash(ModItems.CHUNK_CALCITE.get(), ModItems.DUST_CALCITE.get(), consumer);
        hammerSmash(ModItems.CHUNK_DEEPSLATE.get(), ModItems.DUST_DEEPSLATE.get(), consumer);
        hammerSmash(ModItems.CHUNK_DIORITE.get(), ModItems.DUST_DIORITE.get(), consumer);
        hammerSmash(ModItems.CHUNK_DRIPSTONE.get(), ModItems.DUST_DRIPSTONE.get(), consumer);
        hammerSmash(ModItems.CHUNK_GRANITE.get(), ModItems.DUST_GRANITE.get(), consumer);
        hammerSmash(ModItems.CHUNK_NETHERRACK.get(), ModItems.DUST_NETHERRACK.get(), consumer);
        hammerSmash(ModItems.CHUNK_RED_SANDSTONE.get(), ModItems.DUST_RED_SANDSTONE.get(), consumer);
        hammerSmash(ModItems.CHUNK_SANDSTONE.get(), ModItems.DUST_SANDSTONE.get(), consumer);
        hammerSmash(ModItems.CHUNK_STONE.get(), ModItems.DUST_STONE.get(), consumer);
        hammerSmash(ModItems.CHUNK_TUFF.get(), ModItems.DUST_TUFF.get(), consumer);
        hammerSmash(ModItems.CHUNK_ENDSTONE.get(), ModItems.DUST_ENDSTONE.get(), consumer);

        //Make clay for bricks
        clayFromDust(ModItems.DUST_ANDESITE.get(), ModItems.CLAY_ANDESITE.get(), consumer);
        clayFromDust(ModItems.DUST_BASALT.get(), ModItems.CLAY_BASALT.get(), consumer);
        clayFromDust(ModItems.DUST_BLACKSTONE.get(), ModItems.CLAY_BLACKSTONE.get(), consumer);
        clayFromDust(ModItems.DUST_CALCITE.get(), ModItems.CLAY_CALCITE.get(), consumer);
        clayFromDust(ModItems.DUST_DEEPSLATE.get(), ModItems.CLAY_DEEPSLATE.get(), consumer);
        clayFromDust(ModItems.DUST_DIORITE.get(), ModItems.CLAY_DIORITE.get(), consumer);
        clayFromDust(ModItems.DUST_DRIPSTONE.get(), ModItems.CLAY_DRIPSTONE.get(), consumer);
        clayFromDust(ModItems.DUST_GRANITE.get(), ModItems.CLAY_GRANITE.get(), consumer);
        clayFromDust(ModItems.DUST_NETHERRACK.get(), ModItems.CLAY_NETHERRACK.get(), consumer);
        clayFromDust(ModItems.DUST_RED_SANDSTONE.get(), ModItems.CLAY_RED_SANDSTONE.get(), consumer);
        clayFromDust(ModItems.DUST_SANDSTONE.get(), ModItems.CLAY_SANDSTONE.get(), consumer);
        clayFromDust(ModItems.DUST_STONE.get(), ModItems.CLAY_STONE.get(), consumer);
        clayFromDust(ModItems.DUST_TUFF.get(), ModItems.CLAY_TUFF.get(), consumer);
        clayFromDust(ModItems.DUST_ENDSTONE.get(), ModItems.CLAY_ENDSTONE.get(), consumer);

        //Cook Bricks
        forgeRecipe(ModItems.CLAY_ANDESITE.get(), ModItems.BRICK_ANDESITE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_BASALT.get(), ModItems.BRICK_BASALT.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_BLACKSTONE.get(), ModItems.BRICK_BLACKSTONE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_CALCITE.get(), ModItems.BRICK_CALCITE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_DEEPSLATE.get(), ModItems.BRICK_DEEPSLATE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_DIORITE.get(), ModItems.BRICK_DIORITE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_DRIPSTONE.get(), ModItems.BRICK_DRIPSTONE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_GRANITE.get(), ModItems.BRICK_GRANITE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_NETHERRACK.get(), ModItems.BRICK_NETHERRACK.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_RED_SANDSTONE.get(), ModItems.BRICK_RED_SANDSTONE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_SANDSTONE.get(), ModItems.BRICK_SANDSTONE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_STONE.get(), ModItems.BRICK_STONE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_TUFF.get(), ModItems.BRICK_TUFF.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_ENDSTONE.get(), ModItems.BRICK_ENDSTONE.get(), 250, STANDARD_SMELT_TIME, consumer);

        campfireCook(ModItems.CLAY_ANDESITE.get(), ModItems.BRICK_ANDESITE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_BASALT.get(), ModItems.BRICK_BASALT.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_BLACKSTONE.get(), ModItems.BRICK_BLACKSTONE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_CALCITE.get(), ModItems.BRICK_CALCITE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_DEEPSLATE.get(), ModItems.BRICK_DEEPSLATE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_DIORITE.get(), ModItems.BRICK_DIORITE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_DRIPSTONE.get(), ModItems.BRICK_DRIPSTONE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_GRANITE.get(), ModItems.BRICK_GRANITE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_NETHERRACK.get(), ModItems.BRICK_NETHERRACK.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_RED_SANDSTONE.get(), ModItems.BRICK_RED_SANDSTONE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_SANDSTONE.get(), ModItems.BRICK_SANDSTONE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_STONE.get(), ModItems.BRICK_STONE.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_TUFF.get(), ModItems.BRICK_TUFF.get(), 1, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_ENDSTONE.get(), ModItems.BRICK_ENDSTONE.get(), 1, SLOW_SMELT_TIME, consumer);

        //Brick blocks
        createBrickBlock(ModItems.BRICK_ANDESITE.get(), ModBlocks.ANDESITE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_BASALT.get(), ModBlocks.BASALT_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_BLACKSTONE.get(), ModBlocks.BLACKSTONE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_CALCITE.get(), ModBlocks.CALCITE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_DEEPSLATE.get(), ModBlocks.DEEPSLATE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_DIORITE.get(), ModBlocks.DIORITE_BRICK_BLOCK.get(), consumer);
//        createBrickBlock(ModItems.BRICK_DRIPSTONE.get(),ModBlocks.DRIPSTONE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_GRANITE.get(), ModBlocks.GRANITE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_NETHERRACK.get(), ModBlocks.NETHERRACK_BRICK_BLOCK.get(), consumer);
//        createBrickBlock(ModItems.BRICK_RED_SANDSTONE.get(),ModBlocks.RED_SANDSTONE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_SANDSTONE.get(), ModBlocks.SANDSTONE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_STONE.get(), ModBlocks.STONE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_TUFF.get(), ModBlocks.TUFF_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_ENDSTONE.get(), ModBlocks.ENDSTONE_BRICK_BLOCK.get(), consumer);

        //Smashing metal
        hammerSmash(ModItems.RAW_TIN.get(), ModItems.DUST_TIN.get(), consumer);
        hammerSmash(Items.RAW_COPPER, ModItems.DUST_COPPER.get(), consumer);
        hammerSmash(ModItems.RAW_SILVER.get(), ModItems.DUST_SILVER.get(), consumer);
        hammerSmash(Items.RAW_IRON, ModItems.DUST_IRON.get(), consumer);
        hammerSmash(Items.RAW_COPPER, ModItems.DUST_GOLD.get(), consumer);

        hammerSmash(ModBlocks.ORE_TIN.get(), ModItems.DUST_TIN.get(), consumer);
        hammerSmash(Blocks.COPPER_ORE, ModItems.DUST_COPPER.get(), consumer);
        hammerSmash(ModBlocks.ORE_SILVER.get(), ModItems.DUST_SILVER.get(), consumer);
        hammerSmash(Blocks.IRON_ORE, ModItems.DUST_IRON.get(), consumer);
        hammerSmash(Blocks.COPPER_ORE, ModItems.DUST_GOLD.get(), consumer);


        simpleShapeless(ModItems.PLANT_FIBRE.get(), 3, ModItems.BRAIDED_PLANT_FIBRE.get(), consumer);
        simpleShapeless(ModItems.WOOL.get(), 3, ModItems.YARN.get(), consumer);
        simpleShapeless(ModItems.WOOL.get(), 4, Blocks.WHITE_WOOL, consumer);


        //Food
        campfireCookFood(Items.BEEF, Items.COOKED_BEEF, 10, STANDARD_SMELT_TIME, consumer);
        campfireCookFood(Items.CHICKEN, Items.COOKED_CHICKEN, 10, STANDARD_SMELT_TIME, consumer);
        campfireCookFood(Items.COD, Items.COOKED_COD, 10, STANDARD_SMELT_TIME, consumer);
        campfireCookFood(Items.MUTTON, Items.COOKED_MUTTON, 10, STANDARD_SMELT_TIME, consumer);
        campfireCookFood(Items.PORKCHOP, Items.COOKED_PORKCHOP, 10, STANDARD_SMELT_TIME, consumer);
        campfireCookFood(Items.SALMON, Items.COOKED_SALMON, 10, STANDARD_SMELT_TIME, consumer);
        campfireCookFood(Items.RABBIT, Items.COOKED_RABBIT, 10, STANDARD_SMELT_TIME, consumer);

        campfireCookFood(Items.POTATO, Items.BAKED_POTATO, 10, STANDARD_SMELT_TIME, consumer);

        forgeRecipe(Items.BEEF, Items.COOKED_BEEF, 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(Items.CHICKEN, Items.COOKED_CHICKEN, 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(Items.COD, Items.COOKED_COD, 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(Items.MUTTON, Items.COOKED_MUTTON, 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(Items.PORKCHOP, Items.COOKED_PORKCHOP, 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(Items.SALMON, Items.COOKED_SALMON, 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(Items.RABBIT, Items.COOKED_RABBIT, 250, STANDARD_SMELT_TIME, consumer);

        forgeRecipe(Items.POTATO, Items.BAKED_POTATO, 250, STANDARD_SMELT_TIME, consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING, 1)
                .requires(ModItems.YARN.get(), 3)
                .requires(ModItems.SPINDLE.get())
                .unlockedBy("has_yarn", has(ModItems.YARN.get()))
                .save(consumer, RL("string_from_yarn"));



        /*CLAY Containers*/
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_JUG.get())
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)
                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, toResultRL(ModItems.UNFIRED_CLAY_JUG.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_BUCKET.get())
                .pattern("x x")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)
                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, toResultRL(ModItems.UNFIRED_CLAY_BUCKET.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_BOTTLE.get())
                .pattern("x x")
                .pattern(" x ")
                .define('x', ModTags.CLAY)
                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, toResultRL(ModItems.UNFIRED_CLAY_BOTTLE.get()));


        /*Wood Chest*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.CHEST)
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.PLANKS)
                .unlockedBy("planks", has(ModTags.PLANKS))
                .save(consumer);


//        /*Crafting Stations*/
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.FLINT_STATION.get())
                .requires(Items.FLINT, 4)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer, RL("workstations/flint_station"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
                .pattern("xx")
                .pattern("xx")
                .define('x', ModTags.LOGS)
                .unlockedBy("log", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LOG_OAK.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CAMPFIRE.get())
                .pattern(" x ")
                .pattern("xPx")
                .define('x', ModTags.LOGS)
                .define('P', ModTags.PLANT_FIBRE)
                .group("flint")
                .unlockedBy("log", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LOG_OAK.get()))
                .save(consumer, RL("workstations/campfire"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FORGE.get())
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.BRICKS)
                .unlockedBy("bricks", has(ModTags.BRICKS))
                .save(consumer, RL("workstations/forge"));








        /*TOOLS*/

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLINT_KNIFE.get())
                .requires(ModItems.FLINT_BLADE.get())
                .requires(Items.STICK)
                .unlockedBy("flint", has(Items.FLINT))
                .save(consumer, RL("flint_knife"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_HAMMER.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModTags.STONE_CHUNKS)
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_stone_chunk", has(ModTags.STONE_CHUNKS))
                .save(consumer, RL("stone_hammer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_SPEAR.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_BLADE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("stone_spear")
                .unlockedBy("has_sharp_flint", has(ModItems.FLINT_BLADE.get()))
                .save(consumer, RL("stone_spear"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_SPEAR.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_KNIFE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_sharp_flint", has(ModItems.FLINT_BLADE.get()))
                .group("stone_spear")
                .save(consumer, RL("stone_spear_from_knife"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLINT_PICK.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_PICK_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("flint_pick_head", has(ModItems.FLINT_PICK_HEAD.get()))
                .save(consumer, RL("flint_pick"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLINT_SHOVEL.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_SHOVEL_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("flint", has(ModItems.FLINT_SHOVEL_HEAD.get()))
                .save(consumer, RL("flint_shovel"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLINT_AXE.get())
                .pattern("Ix")
                .pattern(" T")
                .define('I', ModItems.FLINT_AXE_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("flint", has(ModItems.FLINT_AXE_HEAD.get()))
                .save(consumer, RL("flint_axe"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLINT_HOE.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_HOE_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("flint", has(ModItems.FLINT_HOE_HEAD.get()))
                .save(consumer, RL("flint_hoe"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FLINT_SAW.get(), 1)
                .requires(ModItems.FLINT_SAW_HEAD.get())
                .requires(Items.STICK)
                .unlockedBy("has_stick", has(ModItems.FLINT_SAW_HEAD.get()))
                .save(consumer, RL("flint_saw"));

        simpleShapeless(Items.FLINT, 2, ModItems.FLINT_BLADE.get(), consumer);
        simpleShapeless(Items.STICK, 2, ModItems.BASIC_FIRESTARTER.get(), consumer);


//
//        /*Foundry Fuels*/ // maybe bake cook time into the items

        FuelSetup(ModItems.PLANK_OAK.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.PLANK_SPRUCE.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.PLANK_BIRCH.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.PLANK_JUNGLE.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.PLANK_ACACIA.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.PLANK_DARK_OAK.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.PLANK_MANGROVE.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.PLANK_WARPED.get(), BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.PLANK_CRIMSON.get(), BURN_TIME_STANDARD, consumer);

        FuelSetup(ModItems.LOG_OAK.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.LOG_SPRUCE.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.LOG_BIRCH.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.LOG_JUNGLE.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.LOG_ACACIA.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.LOG_DARK_OAK.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.LOG_MANGROVE.get(), SHORT_BURN_TIME, consumer);
        FuelSetup(ModItems.LOG_WARPED.get(), BURN_TIME_STANDARD, consumer);
        FuelSetup(ModItems.LOG_CRIMSON.get(), BURN_TIME_STANDARD, consumer);


    }


    /*Helpers*/
    private static ResourceLocation RL(String string) {
        return new ResourceLocation(Neolith.MODID, string);
    }

    private static ResourceLocation toResultRL(ItemLike output) {
        return new ResourceLocation(Neolith.MODID, getItemName(output));
    }

    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
    }

    public static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> tagKey) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tagKey).build());
    }


    private static void nuggetsIngotsBlocks(RecipeCategory recipeCategory, ItemLike nugget, ItemLike ingot, ItemLike block, Consumer<FinishedRecipe> consumer) {

        //block => ingot
        ShapelessRecipeBuilder.shapeless(recipeCategory, ingot, 9)
                .requires(block)
                .unlockedBy("has_" + getItemName(block), has(block))
                .save(consumer, RL(getItemName(ingot) + "_from_" + getItemName(block)));
        //Ingot => nuggets
        ShapelessRecipeBuilder.shapeless(recipeCategory, nugget, 9)
                .requires(ingot)
                .unlockedBy("has_" + getItemName(ingot), has(ingot))
                .save(consumer, RL(getItemName(nugget) + "_from_" + getItemName(ingot)));

        //nuggets => ingot
        ShapelessRecipeBuilder.shapeless(recipeCategory, ingot)
                .requires(nugget, 9)
                .unlockedBy("has_" + getItemName(nugget), has(nugget))
                .save(consumer, RL(getItemName(ingot) + "_from_" + getItemName(nugget)));

        //ingot => block
        ShapelessRecipeBuilder.shapeless(recipeCategory, block)
                .requires(ingot, 9)
                .unlockedBy("has_" + getItemName(ingot), has(ingot))
                .save(consumer, RL(getItemName(block) + "_from_" + getItemName(ingot)));
    }

    private static void simpleShapeless(ItemLike ingredient, int ingredientAmount, ItemLike result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(ingredient, ingredientAmount)
                .unlockedBy("has" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL(getItemName(ingredient) + "_from_" + getItemName(result)));
    }


    private static void createBrickBlock(ItemLike brickItem, ItemLike brickBlock, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, brickBlock)
                .pattern("xx")
                .pattern("xx")
                .define('x', brickItem)
                .unlockedBy("has" + getItemName(brickItem), has(brickItem))
                .save(consumer, RL(getItemName(brickBlock) + "_block_from_item"));
    }

    private static void clayFromDust(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 1)
                .requires(ingredient, 2)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_dust_stone", has(ingredient))
                .save(consumer, RL(getItemName(result) + "_with_clay_from_" + getItemName(ingredient)));
    }

    private static void sawLog(ItemLike log, ItemLike result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 1)
                .requires(ModTags.SAWS)
                .requires(log)
                .unlockedBy("has" + getItemName(log), has(log))
                .save(consumer, RL(getItemName(result) + "_from_saw"));
    }

    private static void hammerSmash(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result, 1)
                .requires(ModTags.HAMMERS)
                .requires(ingredient)
                .unlockedBy("has" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL(getItemName(result) + "_with_hammer_from_" + getItemName(ingredient)));
    }

    private static void campfireCook(ItemLike ingredient, ItemLike result, float experience, int cookingTime, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.MISC, result, experience, cookingTime).unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL("campfire/" + getItemName(result) + "_with_campfire_from_" + getItemName(ingredient)));
    }
    private static void campfireCookFood(ItemLike ingredient, ItemLike result, float experience, int cookingTime, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, cookingTime).unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL("campfire/" + getItemName(result) + "_with_campfire_from_" + getItemName(ingredient)));
    }
    private static void forgeRecipe(ItemLike ingredient, ItemLike result, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.forgeStationRecipe(
                        NonNullList.of(null, Ingredient.of(ingredient)),
                        NonNullList.of(null, result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL("forge/" + getItemName(result) + "_with_forge_from_" + getItemName(ingredient)));
    }


    private static void foundryRecipe1to1(ItemLike ingredient, ItemLike result, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.foundryRecipe(
                        NonNullList.of(null, Ingredient.of(ingredient)),
                        NonNullList.of(null, result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/1to1/" + getItemName(result) + "_with_foundry_from_" + getItemName(ingredient)));
    }

    private static void foundryRecipe2to1(ItemLike ingredient1, ItemLike ingredient2, ItemLike result, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.foundryRecipe(
                        NonNullList.of(null, Ingredient.of(ingredient1), Ingredient.of(ingredient2)),
                        NonNullList.of(null, result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/2to1/" + getItemName(result) + "_with_foundry_from_" + getItemName(ingredient1) + "_and_" + getItemName(ingredient2)));
    }

    private static void foundryRecipe2to2(ItemLike ingredient1, ItemLike ingredient2, ItemLike result1, ItemLike result2, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.foundryRecipe(
                        NonNullList.of(null, Ingredient.of(ingredient1), Ingredient.of(ingredient2)),
                        NonNullList.of(null, result1.asItem().getDefaultInstance(), result2.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/2to1/" + getItemName(result1) + "_and_" + getItemName(result2) + "_with_foundry_from_" + getItemName(ingredient1) + "_and_" + getItemName(ingredient2)));
    }


    private static void flintStation(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        NeolithRecipeBuilder.flintKnapping(
                        NonNullList.of(null, Ingredient.of(ingredient)),
                        NonNullList.of(null, result.asItem().getDefaultInstance()),
                        10)
                .unlockedBy("has_flint", has(ingredient))
                .save(consumer, RL(getItemName(result) + "_from_knapping"));
    }


    private void FuelSetup(FuelItem item, int cookTime, Consumer<FinishedRecipe> recipeConsumer) {
        String s = "heating_fuel/" + item.getName();
        new HeatingFuelRecipeBuilder(Ingredient.of(item), item.getHeat(), cookTime)
                .unlockedBy("has_" + item.getName(), has(item))
                .save(recipeConsumer, RL(s));
    }

    private void disable(ItemLike result, Consumer<FinishedRecipe> recipeConsumer) {
        new DisableRecipeBuilder(result.asItem())
                .save(recipeConsumer, new ResourceLocation(getItemName(result)));
    }

    private static void disableProcessOre(ItemLike ingredient,  ItemLike result, Consumer<FinishedRecipe> consumer){
        new DisableRecipeBuilder(result.asItem())
                .save(consumer,new ResourceLocation(getItemName(result) + "_from_smelting_" + getItemName(ingredient)));

        new DisableRecipeBuilder(result.asItem()).save(consumer,
                new ResourceLocation(getItemName(result) + "_from_blasting_" + getItemName(ingredient)));

    }

    private static void disableCookFood(ItemLike result,  Consumer<FinishedRecipe> consumer){
        new DisableRecipeBuilder(result.asItem())
                .save(consumer,new ResourceLocation(getItemName(result)));

        new DisableRecipeBuilder(result.asItem())
                .save(consumer,  new ResourceLocation(getItemName(result) + "_from_smoking"));

        new DisableRecipeBuilder(result.asItem())
                .save(consumer, new ResourceLocation(getItemName(result) + "_from_campfire_cooking"));
    }


}
