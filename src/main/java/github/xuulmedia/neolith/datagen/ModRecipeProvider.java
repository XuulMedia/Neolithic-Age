package github.xuulmedia.neolith.datagen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.datagen.builders.CustomRecipeBuilder;
import github.xuulmedia.neolith.datagen.builders.HeatingFuelRecipeBuilder;
import github.xuulmedia.neolith.init.ModItems;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModTags;
import github.xuulmedia.neolith.item.FuelItem;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        final int BURN_TIME_STANDARD = 20 * 10 * 8;

        processOre(RecipeCategory.MISC, ModBlocks.ORE_TIN.get(),  ModItems.INGOT_TIN.get(), 1, 100, consumer);
        processOre(RecipeCategory.MISC, ModBlocks.ORE_SILVER.get(),  ModItems.INGOT_SILVER.get(), 1, 100, consumer);
        processOre(RecipeCategory.MISC, ModItems.RAW_TIN.get(),  ModItems.INGOT_SILVER.get(), 1, 100, consumer);
        processOre(RecipeCategory.MISC, ModItems.RAW_SILVER.get(),  ModItems.INGOT_SILVER.get(), 1, 100, consumer);

        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_TIN.get(), ModItems.INGOT_TIN.get(), ModBlocks.BLOCK_TIN.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_BRONZE.get(), ModItems.INGOT_BRONZE.get(), ModBlocks.BLOCK_BRONZE.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_SILVER.get(), ModItems.INGOT_SILVER.get(), ModBlocks.BLOCK_SILVER.get(), consumer);
        nuggetsIngotsBlocks(RecipeCategory.MISC, ModItems.NUGGET_STEEL.get(), ModItems.INGOT_STEEL.get(), ModBlocks.BLOCK_STEEL.get(), consumer);

        //unfired bricks
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_ANDESITE.get(), ModItems.CLAY_ANDESITE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_STONE.get(), ModItems.CLAY_STONE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_DEEPSLATE.get(), ModItems.CLAY_DEEPSLATE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_DRIPSTONE.get(), ModItems.CLAY_DRIPSTONE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_SANDSTONE.get(), ModItems.CLAY_SANDSTONE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_DIORITE.get(), ModItems.CLAY_DIORITE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_GRANITE.get(), ModItems.CLAY_GRANITE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_BASALT.get(), ModItems.CLAY_BASALT.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_TUFF.get(), ModItems.CLAY_TUFF.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_NETHERRACK.get(), ModItems.CLAY_NETHERRACK.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_BLACKSTONE.get(), ModItems.CLAY_BLACKSTONE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_ENDSTONE.get(), ModItems.CLAY_ENDSTONE.get(), consumer);
        clayFromDust(RecipeCategory.MISC, ModItems.DUST_CALCITE.get(), ModItems.CLAY_CALCITE.get(), consumer);

        //Saw plank to board
        sawLog(RecipeCategory.MISC, ModItems.LOG_OAK.get(), ModItems.PLANK_OAK.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_SPRUCE.get(), ModItems.PLANK_SPRUCE.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_BIRCH.get(), ModItems.PLANK_BIRCH.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_JUNGLE.get(), ModItems.PLANK_JUNGLE.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_ACACIA.get(), ModItems.PLANK_ACACIA.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_DARK_OAK.get(), ModItems.PLANK_DARK_OAK.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_MANGROVE.get(), ModItems.PLANK_MANGROVE.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_CRIMSON.get(), ModItems.PLANK_CRIMSON.get(), consumer);
        sawLog(RecipeCategory.MISC, ModItems.LOG_WARPED.get(), ModItems.PLANK_WARPED.get(), consumer);

       //Stone chunk to dust
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_STONE.get(), ModItems.DUST_STONE.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_ANDESITE.get(), ModItems.DUST_ANDESITE.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_DEEPSLATE.get(), ModItems.DUST_DEEPSLATE.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_SANDSTONE.get(), ModItems.DUST_SANDSTONE.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_DRIPSTONE.get(), ModItems.DUST_DRIPSTONE.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_DIORITE.get(), ModItems.DUST_DIORITE.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_GRANITE.get(), ModItems.DUST_GRANITE.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_BASALT.get(), ModItems.DUST_BASALT.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_TUFF.get(), ModItems.DUST_TUFF.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_NETHERRACK.get(), ModItems.DUST_NETHERRACK.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.CHUNK_BLACKSTONE.get(), ModItems.DUST_BLACKSTONE.get(), consumer);

        hammerSmash(RecipeCategory.MISC, ModItems.RAW_TIN.get(), ModItems.DUST_TIN.get(), consumer);
        hammerSmash(RecipeCategory.MISC, Items.RAW_COPPER, ModItems.DUST_COPPER.get(), consumer);
        hammerSmash(RecipeCategory.MISC, ModItems.RAW_SILVER.get(), ModItems.DUST_SILVER.get(), consumer);
        hammerSmash(RecipeCategory.MISC, Items.RAW_IRON, ModItems.DUST_IRON.get(), consumer);
        hammerSmash(RecipeCategory.MISC, Items.RAW_COPPER, ModItems.DUST_GOLD.get(), consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRAIDED_PLANT_FIBRE.get())
                .requires(ModItems.PLANT_FIBRE.get(), 3)
                .unlockedBy("has_plant_fibre", has(ModItems.PLANT_FIBRE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.YARN.get(), 1)
                .requires(ModItems.WOOL.get())

                .unlockedBy("has_wool", has(ModItems.WOOL.get()))
                .save(consumer, RL("yarn_from_wool"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,Items.STRING, 1)
                .requires(ModItems.YARN.get(), 3)
                .requires(ModItems.SPINDLE.get())
                .unlockedBy("has_yarn", has(ModItems.YARN.get()))
                .save(consumer, RL("string_from_yarn"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Blocks.WHITE_WOOL, 1)
                .requires(ModItems.WOOL.get(), 4)
                .unlockedBy("has_wool", has(ModItems.WOOL.get()))
                .save(consumer, RL("wool_block_from_wool"));




        /*CLAY */
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_JUG.get())
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)

                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, RL("unfired_clay_jug"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_BUCKET.get())
                .pattern("x x")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.CLAY)

                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, RL("unfired_clay_bucket"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.UNFIRED_CLAY_BOTTLE.get())
                .pattern("x x")
                .pattern(" x ")
                .define('x', ModTags.CLAY)

                .unlockedBy("has_clay", has(ModTags.CLAY))
                .save(consumer, RL("unfired_clay_vial"));

        /*Wood Plank*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.CHEST)
                .pattern("xxx")
                .pattern("x x")
                .pattern("xxx")
                .define('x', ModTags.PLANKS)
                .unlockedBy("planks", has(ModTags.PLANKS))
                .save(consumer);










        /*Crafting Stations*/
        ShapelessRecipeBuilder.shapeless(ModBlocks.FLINT_STATION.get())
               .requires(Items.FLINT, 4)
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Blocks.CRAFTING_TABLE)
                .pattern("xx")
                .pattern("xx")
                .define('x', ModTags.LOGS)
                .unlockedBy("log", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LOG_OAK.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(ModBlocks.CAMPFIRE.get())
                .pattern(" x ")
                .pattern("xPx")
                .define('x', ModTags.LOGS)
                .define('P', ModTags.PLANT_FIBRE)
                .group("flint")
                .unlockedBy("log", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LOG_OAK.get()))
                .save(consumer);















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

        ShapedRecipeBuilder.shaped(ModItems.STONE_SPEAR.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_BLADE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .group("stone_spear")
                .unlockedBy("has_sharp_flint", has(ModItems.FLINT_BLADE.get()))
                .save(consumer, RL("stone_spear"));

        ShapedRecipeBuilder.shaped(ModItems.STONE_SPEAR.get())
                .pattern("I")
                .pattern("x")
                .pattern("T")
                .define('I', ModItems.FLINT_KNIFE.get())
                .define('x', ModTags.BINDINGS)
                .define('T', Items.STICK)
                .unlockedBy("has_sharp_flint", has(ModItems.FLINT_BLADE.get()))
                .group("stone_spear")
                .save(consumer, RL("stone_spear_from_knife"));

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

        ShapelessRecipeBuilder.shapeless(ModItems.BASIC_FIRESTARTER.get())
                .requires(Items.STICK, 2)
                .unlockedBy("has_stick", has(Items.STICK))
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






//        ItemLike pResult, Ingredient pIngredient, float pExperience, int pCookingTime, SimpleCookingSerializer<?> pSerializer)

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.STICK), ModBlocks.TORCH.get(), 10, 100)
                .unlockedBy("has_campfire", has(ModBlocks.CAMPFIRE.get()))
                .save(consumer, RL("campfire/torch_from_stick"));



//        /*Foundry Fuels*/
//        new HeatingFuelRecipeBuilder(Ingredient.of(ItemTags.COALS), 500, 20 * 10 * 8)
//                .unlockedBy("has_foundry", has(ModBlocks.FOUNDRY.get()))
//                .save(consumer, RL("heating_fuel/coals"));

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


        // Testing!
        new KilnRecipeBuilder(
                NonNullList.of(null, Ingredient.of(Items.GRANITE), Ingredient.of(Items.DIORITE),
                        Ingredient.of(Items.ANDESITE)),
                NonNullList.of(null, new ItemStack(Items.COBBLESTONE, 2), new ItemStack(Items.COBBLED_DEEPSLATE, 4)),
                500)
                .unlockedBy("has_kiln", has(ModBlocks.KILN.get()))
                .save(consumer, RL("kiln/test/3-to-2"));

        new KilnRecipeBuilder(
                NonNullList.of(null, Ingredient.of(Items.IRON_INGOT),
                        Ingredient.of(Items.GOLD_INGOT)),
                NonNullList.of(null, new ItemStack(Items.DIAMOND), new ItemStack(Items.NETHERITE_INGOT)),
                200)
                .unlockedBy("has_kiln", has(ModBlocks.KILN.get()))
                .save(consumer, RL("kiln/test/2-to-2"));

        new KilnRecipeBuilder(
                NonNullList.of(null, Ingredient.of(Items.IRON_BARS)),
                NonNullList.of(null, new ItemStack(Items.IRON_NUGGET)),
                200)
                .unlockedBy("has_kiln", has(ModBlocks.KILN.get()))
                .save(consumer, RL("kiln/test/1-to-1"));

        new KilnRecipeBuilder(
                NonNullList.of(null, Ingredient.of(ItemTags.COPPER_ORES)),
                NonNullList.of(null, new ItemStack(Items.IRON_BLOCK), new ItemStack(Items.ACACIA_LOG, 16)),
                200)
                .unlockedBy("has_kiln", has(ModBlocks.KILN.get()))
                .save(consumer, RL("kiln/test/1-to-2"));





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



    }


    /*Helpers*/
    private ResourceLocation RL(String string) {
        return new ResourceLocation(Neolith.MODID, string);
    }

    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike pItemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(pItemLike).build());
    }

    public static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> tagKey) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tagKey).build());
    }

    private static void processOre(RecipeCategory recipeCategory, ItemLike ingredient,  ItemLike result, float experience, int cookingTime, Consumer<FinishedRecipe> consume){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient),recipeCategory, result, experience, cookingTime).unlockedBy("has_ore", has(ingredient)).save(consume, new ResourceLocation(Neolith.MODID, getItemName(result) + "_from_smelting_" + getItemName(ingredient)));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), recipeCategory, result, experience, cookingTime/2).unlockedBy("has_blast_furnace", has(Blocks.BLAST_FURNACE)).save(consume, new ResourceLocation(Neolith.MODID, getItemName(result) + "_from_blasting_" + getItemName(ingredient));

    }
    private static void clayFromDust(RecipeCategory recipeCategory, ItemLike ingredient,  ItemLike result, Consumer<FinishedRecipe> consumer){
        ShapelessRecipeBuilder.shapeless(recipeCategory, result, 1)
                .requires(ingredient, 2)
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_dust_stone", has(ingredient))
                .save(consumer);
    }

    private static void nuggetsIngotsBlocks(RecipeCategory recipeCategory, ItemLike nugget, ItemLike ingot, ItemLike block,Consumer<FinishedRecipe> consumer ){

        //block => ingot
        ShapelessRecipeBuilder.shapeless(recipeCategory, ingot, 9)
                .requires(block)
                .unlockedBy("has_" + getItemName(block), has(block))
                .save(consumer, new ResourceLocation(Neolith.MODID, getItemName(ingot) + "_from_" + getItemName(block)));
        //Ingot => nuggets
        ShapelessRecipeBuilder.shapeless(recipeCategory, nugget, 9)
                .requires(ingot)
                .unlockedBy("has_" + getItemName(ingot), has(ingot))
                .save(consumer, new ResourceLocation(Neolith.MODID, getItemName(nugget) + "_from_" + getItemName(ingot)));

        //nuggets => ingot
        ShapelessRecipeBuilder.shapeless(recipeCategory, ingot)
                .requires(nugget, 9)
                .unlockedBy("has_" + getItemName(nugget), has(nugget))
                .save(consumer, new ResourceLocation(Neolith.MODID, getItemName(ingot) + "_from_" + getItemName(nugget)));

        //ingot => block
        ShapelessRecipeBuilder.shapeless(recipeCategory, block)
                .requires(ingot, 9)
                .unlockedBy("has_" + getItemName(ingot), has(ingot))
                .save(consumer, new ResourceLocation(Neolith.MODID, getItemName(block) + "_from_" + getItemName(ingot)));
    }


    private static void sawLog(RecipeCategory recipeCategory, ItemLike log, ItemLike result, Consumer<FinishedRecipe> consumer ) {
        ShapelessRecipeBuilder.shapeless(recipeCategory, result, 1)
                .requires(ModTags.SAWS)
                .requires(log)
                .unlockedBy("has" + getItemName(log), has(log))
                .save(consumer, new ResourceLocation(Neolith.MODID, getItemName(result) + "_from_saw"));
    }

    private static void hammerSmash(RecipeCategory recipeCategory, ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer ) {
        ShapelessRecipeBuilder.shapeless(recipeCategory, result, 1)
                .requires(ModTags.HAMMERS)
                .requires(ingredient)
                .unlockedBy("has" + getItemName(ingredient), has(ingredient))
                .save(consumer, new ResourceLocation(Neolith.MODID, getItemName(result) + "_with_hammer_from_"+getItemName(ingredient)));
    }
    private void FuelSetup(RegistryObject<FuelItem> item, int cookTime, Consumer<FinishedRecipe> recipeConsumer) {
        String s = "heating_fuel/" + item.get();
        new HeatingFuelRecipeBuilder(Ingredient.of(item.get()), item.get().getHeat(), cookTime)
                .unlockedBy("has_" + item.getKey(), has(item.get()))
                .save(recipeConsumer, RL(s));
    }

}
