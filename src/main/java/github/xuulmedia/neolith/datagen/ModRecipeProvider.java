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
        //block of kelp is 20 * 120       block of coal is 20 * 800       lava bucket is 20x1000
        //Low wood - 250 med wood 350 high wood - 500

        final int VERY_SLOW_SMELT_TIME = 20 * 45;
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
        disable(Blocks.FLETCHING_TABLE, consumer);
        disable(Blocks.SCAFFOLDING, consumer);
        disable(Blocks.BAMBOO_BLOCK, consumer);

        disable(Blocks.GLASS, consumer);
        disable(Blocks.CLAY, consumer);

        disable(Blocks.CHEST, consumer);
        disable(Items.PAPER, consumer);
        disable(Blocks.LADDER, consumer);
        disable(Items.BONE_MEAL, consumer);

        disable(Blocks.CAKE, consumer);
        disable(Items.BREAD, consumer);

        disableCookFood(Items.COOKED_BEEF, consumer);
        disableCookFood(Items.COOKED_CHICKEN, consumer);
        disableCookFood(Items.COOKED_COD, consumer);
        disableCookFood(Items.COOKED_MUTTON, consumer);
        disableCookFood(Items.COOKED_PORKCHOP, consumer);
        disableCookFood(Items.COOKED_SALMON, consumer);
        disableCookFood(Items.COOKED_RABBIT, consumer);
        disableCookFood(Items.BAKED_POTATO, consumer);

        disableProcessOre(Items.CLAY, Items.BRICK, consumer);
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
        simpleShapeless(ModBlocks.FLINT_NODE.get(), 1, Items.FLINT, consumer);

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
        shapeless2to1(ModItems.DUST_TIN.get(), 1, ModItems.DUST_COPPER.get(), 1, ModItems.DUST_BRONZE.get(), consumer);
        shapeless3to1(ModItems.DUST_GOLD.get(), ModItems.DUST_IRON.get(), Items.REDSTONE, ModItems.DUST_OBSIDIAN.get(), consumer);


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

        forgeRecipe(ModItems.DUST_OBSIDIAN.get(), Blocks.OBSIDIAN, 600, SLOW_SMELT_TIME, consumer);
        foundryRecipe3to1(ModItems.DUST_GOLD.get(), ModItems.DUST_IRON.get(), Items.REDSTONE, Blocks.OBSIDIAN, 600, SLOW_SMELT_TIME, consumer);


        foundryRecipe1to1(ModItems.RAW_SILVER.get(), ModItems.INGOT_SILVER.get(), 400, STANDARD_SMELT_TIME, consumer);
        foundryRecipe2to1(ModItems.DUST_COPPER.get(), ModItems.DUST_TIN.get(), ModItems.INGOT_BRONZE.get(), 400, STANDARD_SMELT_TIME, consumer);
//        foundryRecipe2to2(Blocks.IRON_ORE, ModBlocks.ORE_SILVER.get(), ModItems.INGOT_BRONZE.get(), Items.STICK, 200, 200, consumer);


        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_TIN.get(), ModItems.INGOT_TIN.get(), ModBlocks.BLOCK_TIN.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_BRONZE.get(), ModItems.INGOT_BRONZE.get(), ModBlocks.BLOCK_BRONZE.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_SILVER.get(), ModItems.INGOT_SILVER.get(), ModBlocks.BLOCK_SILVER.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_STEEL.get(), ModItems.INGOT_STEEL.get(), ModBlocks.BLOCK_STEEL.get(), consumer);

        //Other smelting
        forgeGlass(ModTags.DUSTS_SANDS, Blocks.GLASS, 350, STANDARD_SMELT_TIME, "sand", consumer);

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
        hammerSmash(ModItems.CHUNK_ANDESITE.get(), ModItems.DUST_STONE.get(), consumer);
        hammerSmash(ModItems.CHUNK_BASALT.get(), ModItems.DUST_BLACK.get(), consumer);
        hammerSmash(ModItems.CHUNK_BLACKSTONE.get(), ModItems.DUST_BLACK.get(), consumer);
        hammerSmash(ModItems.CHUNK_CALCITE.get(), ModItems.DUST_WHITE.get(), consumer);
        hammerSmash(ModItems.CHUNK_DEEPSLATE.get(), ModItems.DUST_DEEPSLATE.get(), consumer);
        hammerSmash(ModItems.CHUNK_DIORITE.get(), ModItems.DUST_WHITE.get(), consumer);
        hammerSmash(ModItems.CHUNK_DRIPSTONE.get(), ModItems.DUST_BROWN.get(), consumer);
        hammerSmash(ModItems.CHUNK_GRANITE.get(), ModItems.DUST_BROWN.get(), consumer);
        hammerSmash(ModItems.CHUNK_NETHERRACK.get(), ModItems.DUST_NETHERRACK.get(), consumer);
        hammerSmash(ModItems.CHUNK_RED_SANDSTONE.get(), ModItems.DUST_RED_SAND.get(), consumer);
        hammerSmash(ModItems.CHUNK_SANDSTONE.get(), ModItems.DUST_SAND.get(), consumer);
        hammerSmash(ModItems.CHUNK_STONE.get(), ModItems.DUST_STONE.get(), consumer);
        hammerSmash(ModItems.CHUNK_TUFF.get(), ModItems.DUST_TUFF.get(), consumer);
        hammerSmash(ModItems.CHUNK_ENDSTONE.get(), ModItems.DUST_ENDSTONE.get(), consumer);

        //Make clay for bricks
        clayFromDust(ModItems.DUST_STONE.get(), ModItems.CLAY_STONE.get(), consumer);
        clayFromDust(ModItems.DUST_DEEPSLATE.get(), ModItems.CLAY_DEEPSLATE.get(), consumer);
        clayFromDust(ModItems.DUST_NETHERRACK.get(), ModItems.CLAY_NETHERRACK.get(), consumer);
        clayFromDust(ModItems.DUST_ENDSTONE.get(), ModItems.CLAY_ENDSTONE.get(), consumer);
        clayFromDust(ModItems.DUST_BROWN.get(), ModItems.CLAY_BROWN.get(), consumer);
        clayFromDust(ModItems.DUST_WHITE.get(), ModItems.CLAY_WHITE.get(), consumer);
        clayFromDust(ModItems.DUST_BLACK.get(), ModItems.CLAY_BLACK.get(), consumer);
        clayFromDust(ModItems.DUST_SAND.get(), ModItems.CLAY_SAND.get(), consumer);
        clayFromDust(ModItems.DUST_RED_SAND.get(), ModItems.CLAY_RED_SAND.get(), consumer);

        //Cook Bricks
        forgeRecipe(ModItems.CLAY_STONE.get(), ModItems.BRICK_STONE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_DEEPSLATE.get(), ModItems.BRICK_DEEPSLATE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_NETHERRACK.get(), ModItems.BRICK_NETHERRACK.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_ENDSTONE.get(), ModItems.BRICK_ENDSTONE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_BROWN.get(), ModItems.BRICK_BROWN.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_WHITE.get(), ModItems.BRICK_WHITE.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_BLACK.get(), ModItems.BRICK_BLACK.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_SAND.get(), ModItems.BRICK_SAND.get(), 250, STANDARD_SMELT_TIME, consumer);
        forgeRecipe(ModItems.CLAY_RED_SAND.get(), ModItems.BRICK_RED_SAND.get(), 250, STANDARD_SMELT_TIME, consumer);

        campfireCook(ModItems.CLAY_STONE.get(), ModItems.BRICK_STONE.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_DEEPSLATE.get(), ModItems.BRICK_DEEPSLATE.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_NETHERRACK.get(), ModItems.BRICK_NETHERRACK.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_ENDSTONE.get(), ModItems.BRICK_ENDSTONE.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_BROWN.get(), ModItems.BRICK_BROWN.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_WHITE.get(), ModItems.BRICK_WHITE.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_BLACK.get(), ModItems.BRICK_BLACK.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_SAND.get(), ModItems.BRICK_SAND.get(), 3, SLOW_SMELT_TIME, consumer);
        campfireCook(ModItems.CLAY_RED_SAND.get(), ModItems.BRICK_RED_SAND.get(), 3, SLOW_SMELT_TIME, consumer);

        //Brick blocks
        createBrickBlock(ModItems.BRICK_STONE.get(), ModBlocks.STONE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_DEEPSLATE.get(), ModBlocks.DEEPSLATE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_NETHERRACK.get(), ModBlocks.NETHERRACK_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_ENDSTONE.get(), ModBlocks.ENDSTONE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_BROWN.get(), ModBlocks.BROWN_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_WHITE.get(), ModBlocks.WHITE_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_BLACK.get(), ModBlocks.BLACK_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_SAND.get(), ModBlocks.SAND_BRICK_BLOCK.get(), consumer);
        createBrickBlock(ModItems.BRICK_RED_SAND.get(), ModBlocks.RED_SAND_BRICK_BLOCK.get(), consumer);


        //Smashing metal
        hammerSmash(ModItems.RAW_TIN.get(), ModItems.DUST_TIN.get(), consumer);
        hammerSmash(Items.RAW_COPPER, ModItems.DUST_COPPER.get(), consumer);
        hammerSmash(ModItems.RAW_SILVER.get(), ModItems.DUST_SILVER.get(), consumer);
        hammerSmash(Items.RAW_IRON, ModItems.DUST_IRON.get(), consumer);
        hammerSmash(Items.RAW_GOLD, ModItems.DUST_GOLD.get(), consumer);

        hammerSmash(ModBlocks.ORE_TIN.get(), ModItems.DUST_TIN.get(), consumer);
        hammerSmash(Blocks.COPPER_ORE, ModItems.DUST_COPPER.get(), consumer);
        hammerSmash(ModBlocks.ORE_SILVER.get(), ModItems.DUST_SILVER.get(), consumer);
        hammerSmash(Blocks.IRON_ORE, ModItems.DUST_IRON.get(), consumer);
        hammerSmash(Blocks.GOLD_ORE, ModItems.DUST_GOLD.get(), consumer);


        simpleShapeless(ModItems.PLANT_FIBRE.get(), 3, ModItems.BRAIDED_PLANT_FIBRE.get(), consumer);
        simpleShapeless(ModItems.WOOL.get(), 3, ModItems.YARN.get(), consumer);
        simpleShapeless(ModItems.WOOL.get(), 4, Blocks.WHITE_WOOL, consumer);


        //processed goods
        createDoor(ModItems.LOG_ACACIA.get(), Blocks.ACACIA_DOOR, consumer);
        createDoor(ModBlocks.BAMBOO_PLANKS.get(), Blocks.BAMBOO_DOOR, consumer);
        createDoor(ModItems.LOG_BIRCH.get(), Blocks.BIRCH_DOOR, consumer);
        createDoor(ModItems.LOG_CHERRY.get(), Blocks.CHERRY_DOOR, consumer);
        createDoor(ModItems.LOG_DARK_OAK.get(), Blocks.DARK_OAK_DOOR, consumer);
        createDoor(ModItems.LOG_JUNGLE.get(), Blocks.JUNGLE_DOOR, consumer);
        createDoor(ModItems.LOG_MANGROVE.get(), Blocks.MANGROVE_DOOR, consumer);
        createDoor(ModItems.LOG_OAK.get(), Blocks.OAK_DOOR, consumer);
        createDoor(ModItems.LOG_SPRUCE.get(), Blocks.SPRUCE_DOOR, consumer);
        createDoor(ModItems.LOG_WARPED.get(), Blocks.WARPED_DOOR, consumer);
        createDoor(ModItems.LOG_CRIMSON.get(), Blocks.CRIMSON_DOOR, consumer);

        createDoor(Items.IRON_INGOT, Blocks.IRON_DOOR, consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.BAMBOO_BLOCK)
                .pattern("bbb")
                .pattern("rbr")
                .pattern("bbb")
                .define('b', Items.BAMBOO)
                .define('r', ModTags.BINDINGS)
                .unlockedBy("has_bamboo", has(Items.BAMBOO))
                .save(consumer, toResultRL(Blocks.BAMBOO_BLOCK));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HINGE_IRON.get())
                .pattern("xnx")
                .define('x', Items.IRON_INGOT)
                .define('n', Items.IRON_NUGGET)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(consumer, toResultRL(ModItems.HINGE_IRON.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CLASP_BRONZE.get())
                .pattern("xnx")
                .define('x', ModItems.INGOT_BRONZE.get())
                .define('n', ModItems.NUGGET_BRONZE.get())
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, toResultRL(ModItems.CLASP_BRONZE.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.CHEST)
                .pattern("xxx")
                .pattern("xcx")
                .pattern("xxx")
                .define('x', ModTags.PLANKS)
                .define('c', ModItems.CLASP_BRONZE.get())
                .unlockedBy("has_planks", has(ModTags.PLANKS))
                .save(consumer, toResultRL(Blocks.CHEST));


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


        /*CLAY Containers*/
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_POT.get())
                .pattern(" x ")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', ModTags.CLAY)
                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, toResultRL(ModItems.UNFIRED_CLAY_POT.get()));


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_BOTTLE.get())
                .pattern("x x")
                .pattern(" x ")
                .define('x', ModTags.CLAY)
                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, toResultRL(ModItems.UNFIRED_CLAY_BOTTLE.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_BOWL.get())
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)
                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, toResultRL(ModItems.UNFIRED_CLAY_BOWL.get()));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_BUCKET.get())
                .pattern("x x")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)
                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, toResultRL(ModItems.UNFIRED_CLAY_BUCKET.get()));


        campfireCook(ModItems.UNFIRED_CLAY_POT.get(), ModBlocks.CLAY_POT.get(), 2, VERY_SLOW_SMELT_TIME, consumer);
        forgeRecipe(ModItems.UNFIRED_CLAY_POT.get(), ModBlocks.CLAY_POT.get(), 300, SLOW_SMELT_TIME, consumer);

        campfireCook(ModItems.UNFIRED_CLAY_BOTTLE.get(), ModItems.CLAY_BOTTLE.get(), 2, SLOW_SMELT_TIME, consumer);
        forgeRecipe(ModItems.UNFIRED_CLAY_BOTTLE.get(), ModItems.CLAY_BOTTLE.get(), 300, STANDARD_SMELT_TIME, consumer);

        campfireCook(ModItems.UNFIRED_CLAY_BOWL.get(), ModItems.CLAY_BOWL.get(), 2, SLOW_SMELT_TIME, consumer);
        forgeRecipe(ModItems.UNFIRED_CLAY_BOWL.get(), ModItems.CLAY_BOWL.get(), 300, STANDARD_SMELT_TIME, consumer);


 /*Crafting Stations*/

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.FLINT_STATION.get())
                .requires(Items.FLINT, 4)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer, RL("workstations/flint_station"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
                .pattern("xx")
                .pattern("xx")
                .define('x', ModTags.LOGS)
                .unlockedBy("log", has(ModTags.LOGS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CAMPFIRE.get())
                .pattern(" x ")
                .pattern("xPx")
                .define('x', ModTags.LOGS)
                .define('P', ModTags.PLANT_FIBRE)
                .unlockedBy("log", has(ModTags.LOGS))
                .save(consumer, RL("workstations/campfire"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FORGE.get())
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.BRICKS)
                .unlockedBy("bricks", has(ModTags.BRICKS))
                .save(consumer, RL("workstations/forge"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.DISPENSER)
                .pattern(" /s")
                .pattern("/Ds")
                .pattern(" /s")
                .define('/', Items.STICK)
                .define('s', ModTags.BINDINGS)
                .define('D', Blocks.DISPENSER)
                .unlockedBy("redstone", has(Items.REDSTONE))
                .save(consumer, RL("alt_dispenser"));


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

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_KNIFE.get())
                .pattern("I")
                .pattern("T")
                .define('I', ModItems.INGOT_BRONZE.get())
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_knife"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_PICK.get())
                .pattern("III")
                .pattern(" x ")
                .pattern(" T ")
                .define('I', ModItems.INGOT_BRONZE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_pick"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_SHOVEL.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.INGOT_BRONZE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_AXE.get())
                .pattern("II")
                .pattern("Ix")
                .pattern(" T")
                .define('I', ModItems.INGOT_BRONZE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_HOE.get())
                .pattern("II")
                .pattern(" x")
                .pattern(" T")
                .define('I', ModItems.INGOT_BRONZE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_SAW.get())
                .pattern("TTT")
                .pattern("IIx")
                .pattern("  T")
                .define('I', ModItems.INGOT_BRONZE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_saw"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_HAMMER.get())
                .pattern("O")
                .pattern("x")
                .pattern("T")
                .define('O', ModItems.BRONZE_HAMMER_HEAD.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_hammer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_SWORD.get())
                .pattern("I")
                .pattern("I")
                .pattern("T")
                .define('I', ModItems.INGOT_BRONZE.get())
                .define('T', Items.STICK)
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_HAMMER_HEAD.get())
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.INGOT_BRONZE.get())
                .unlockedBy("has_bronze", has(ModItems.INGOT_BRONZE.get()))
                .save(consumer, RL("bronze_hammer_head"));


        //Foundry Fuels
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

        FuelSetup(ModItems.PLANT_FIBRE.get(), 40, consumer);


    }

    /*Helpers*/
    private static ResourceLocation RL(String string) {
        return new ResourceLocation(Neolith.MODID, string);
    }

    private static ResourceLocation toResultRL(ItemLike output) {
        return new ResourceLocation(Neolith.MODID, getItemName(output));
    }

    //    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
//        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
//    }
//
//    public static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> tagKey) {
//        return inventoryTrigger(ItemPredicate.Builder.item().of(tagKey).build());
//    }
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
                .save(consumer, RL(getItemName(result) + "_from_" + getItemName(ingredient)));
    }

    private static void shapeless2to1(ItemLike ingredient, int ingredientAmount, ItemLike ingredient2, int ingredient2Amount, ItemLike result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(ingredient, ingredientAmount)
                .requires(ingredient2, ingredient2Amount)
                .unlockedBy("has" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL(getItemName(result) + "_from_" + getItemName(ingredient) + "_and_" + getItemName(ingredient2)));
    }

    private static void shapeless3to1(ItemLike ingredient, ItemLike ingredient2, ItemLike ingredient3, ItemLike result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result)
                .requires(ingredient, 1)
                .requires(ingredient2, 1)
                .requires(ingredient3, 1)
                .unlockedBy("has" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL(getItemName(result) + "_from_" + getItemName(ingredient) + "_and_" + getItemName(ingredient2) + "_and_" + getItemName(ingredient3)));
    }

    private static void createDoor(ItemLike material, ItemLike door, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, door)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', material)
                .unlockedBy("has" + getItemName(material), has(material))
                .save(consumer, RL(getItemName(door) + "_from_" + getItemName(material)));

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
                        NonNullList.of(Ingredient.of(ingredient)),
                        NonNullList.of(result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has" + getItemName(ingredient), has(ingredient))
                .save(consumer, RL("forge/" + getItemName(result) + "_with_forge_from_" + getItemName(ingredient)));
    }

    private static void forgeGlass(TagKey<Item> ingredient, ItemLike result, int heatRequired, int cookTime, String tagName, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.forgeStationRecipe(
                        NonNullList.of(Ingredient.of(ingredient)),
                        NonNullList.of(result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_" + tagName, has(ingredient))
                .save(consumer, RL("forge/" + getItemName(result) + "_from_" + tagName));
    }


    private static void foundryRecipe1to1(ItemLike ingredient, ItemLike result, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.foundryRecipe(
                        NonNullList.of(Ingredient.of(ingredient)),
                        NonNullList.of(result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/1to1/" + getItemName(result) + "_with_foundry_from_" + getItemName(ingredient)));
    }

    private static void foundryRecipe2to1(ItemLike ingredient1, ItemLike ingredient2, ItemLike result, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.foundryRecipe(
                        NonNullList.of(Ingredient.of(ingredient1), Ingredient.of(ingredient2)),
                        NonNullList.of(result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/2to1/" + getItemName(result) + "_from_" + getItemName(ingredient1) + "_and_" + getItemName(ingredient2)));
    }


    private static void foundryRecipe3to1(ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike result, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.foundryRecipe(
                        NonNullList.of(Ingredient.of(ingredient1), Ingredient.of(ingredient2), Ingredient.of(ingredient3)),
                        NonNullList.of(result.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/3to1/" + getItemName(result) + "_from_" + getItemName(ingredient1) + "_and_" + getItemName(ingredient2) + "_and_" + getItemName(ingredient3)));
    }

    private static void foundryRecipe2to2(ItemLike ingredient1, ItemLike ingredient2, ItemLike result1, ItemLike result2, int heatRequired, int cookTime, Consumer<FinishedRecipe> consumer) {
        HeatRecipeBuilder.foundryRecipe(
                        NonNullList.of(Ingredient.of(ingredient1), Ingredient.of(ingredient2)),
                        NonNullList.of(result1.asItem().getDefaultInstance(), result2.asItem().getDefaultInstance()),
                        heatRequired,
                        10,
                        cookTime)
                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
                .save(consumer, RL("foundry/2to1/" + getItemName(result1) + "_and_" + getItemName(result2) + "_with_foundry_from_" + getItemName(ingredient1) + "_and_" + getItemName(ingredient2)));
    }


    private static void flintStation(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        NeolithRecipeBuilder.flintKnapping(
                        NonNullList.of(Ingredient.of(ingredient)),
                        NonNullList.of(result.asItem().getDefaultInstance()),
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

    private static void disableProcessOre(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        new DisableRecipeBuilder(result.asItem())
                .save(consumer, new ResourceLocation(getItemName(result) + "_from_smelting_" + getItemName(ingredient)));

        new DisableRecipeBuilder(result.asItem()).save(consumer,
                new ResourceLocation(getItemName(result) + "_from_blasting_" + getItemName(ingredient)));

    }

    private static void disableCookFood(ItemLike result, Consumer<FinishedRecipe> consumer) {
        new DisableRecipeBuilder(result.asItem())
                .save(consumer, new ResourceLocation(getItemName(result)));

        new DisableRecipeBuilder(result.asItem())
                .save(consumer, new ResourceLocation(getItemName(result) + "_from_smoking"));

        new DisableRecipeBuilder(result.asItem())
                .save(consumer, new ResourceLocation(getItemName(result) + "_from_campfire_cooking"));
    }


}
