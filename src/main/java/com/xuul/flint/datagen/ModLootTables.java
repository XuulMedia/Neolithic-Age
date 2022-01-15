package com.xuul.flint.datagen;

import com.xuul.flint.init.ModBlocks;
import com.xuul.flint.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;


public class ModLootTables extends BaseLootTableProvider {

    public ModLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    private static final float[] LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        lootTables.put(ModBlocks.ORE_TIN.get(), createSilkTouchTable("ore_tin", ModBlocks.ORE_TIN.get(), ModItems.RAW_TIN.get(), 1, 3));
        lootTables.put(ModBlocks.ORE_SILVER.get(), createSilkTouchTable("ore_silver", ModBlocks.ORE_SILVER.get(), ModItems.RAW_SILVER.get(), 1, 3));

        lootTables.put(ModBlocks.BLOCK_TIN.get(), DropSelfTable("block_tin", ModBlocks.BLOCK_TIN.get()));

        lootTables.put(Blocks.OAK_LOG, createSilkTouchTable("oak_log", Blocks.OAK_LOG, ModItems.LOG_OAK.get(), 1, 1));
        lootTables.put(Blocks.ACACIA_LOG, createSilkTouchTable("acacia_log", Blocks.ACACIA_LOG, ModItems.LOG_ACACIA.get(), 1, 1));
        lootTables.put(Blocks.BIRCH_LOG, createSilkTouchTable("birch_log", Blocks.BIRCH_LOG, ModItems.LOG_BIRCH.get(), 1, 3));
        lootTables.put(Blocks.CRIMSON_STEM, createSilkTouchTable("crimson_stem", Blocks.CRIMSON_STEM, ModItems.LOG_CRIMSON.get(), 1, 1));
        lootTables.put(Blocks.DARK_OAK_LOG, createSilkTouchTable("dark_oak_log", Blocks.DARK_OAK_LOG, ModItems.LOG_DARK_OAK.get(), 1, 1));
        lootTables.put(Blocks.JUNGLE_LOG, createSilkTouchTable("jungle_log", Blocks.JUNGLE_LOG, ModItems.LOG_JUNGLE.get(), 1, 1));
        lootTables.put(Blocks.SPRUCE_LOG, createSilkTouchTable("spruce_log", Blocks.SPRUCE_LOG, ModItems.LOG_SPRUCE.get(), 1, 1));
        lootTables.put(Blocks.WARPED_STEM, createSilkTouchTable("warped_stem", Blocks.WARPED_STEM, ModItems.LOG_WARPED.get(), 1, 1));

        lootTables.put(Blocks.OAK_LEAVES, leavesSticksSaplingTable("oak_leaves", Blocks.OAK_LEAVES,Items.STICK,1,2, Items.OAK_SAPLING,LEAVES_SAPLING_CHANCES));

//        lootTables.put(Blocks.OAK_LOG, createSilkTouchTable("oak_log", Blocks.OAK_LOG, ModItems.LOG_OAK.get(), 1, 3));
//        lootTables.put(Blocks.ACACIA_LOG, createSilkTouchTable("acacia_log", Blocks.ACACIA_LOG, ModItems.LOG_ACACIA.get(), 1, 3));
//        lootTables.put(Blocks.BIRCH_LOG, createSilkTouchTable("birch_log", Blocks.BIRCH_LOG, ModItems.LOG_BIRCH.get(), 1, 3));
//        lootTables.put(Blocks.CRIMSON_STEM, createSilkTouchTable("crimson_stem", Blocks.CRIMSON_STEM, ModItems.LOG_CRIMSON.get(), 1, 3));
//        lootTables.put(Blocks.DARK_OAK_LOG, createSilkTouchTable("dark_oak_log", Blocks.DARK_OAK_LOG, ModItems.LOG_DARK_OAK.get(), 1, 3));
//        lootTables.put(Blocks.JUNGLE_LOG, createSilkTouchTable("jungle_log", Blocks.JUNGLE_LOG, ModItems.LOG_JUNGLE.get(), 1, 3));
//        lootTables.put(Blocks.SPRUCE_LOG, createSilkTouchTable("spruce_log", Blocks.SPRUCE_LOG, ModItems.LOG_SPRUCE.get(), 1, 3));
//        lootTables.put(Blocks.WARPED_STEM, createSilkTouchTable("warped_stem", Blocks.WARPED_STEM, ModItems.LOG_WARPED.get(), 1, 3));


        lootTables.put(Blocks.STONE, createSilkTouchTable("stone", Blocks.STONE, ModItems.CHUNK_STONE.get(), 1, 4));
        lootTables.put(Blocks.ANDESITE, createSilkTouchTable("andesite", Blocks.ANDESITE, ModItems.CHUNK_ANDESITE.get(), 1, 4));
        lootTables.put(Blocks.DEEPSLATE, createSilkTouchTable("deepslate", Blocks.DEEPSLATE, ModItems.CHUNK_DEEPSLATE.get(), 1, 4));
        lootTables.put(Blocks.DRIPSTONE_BLOCK, createSilkTouchTable("dripstone", Blocks.DRIPSTONE_BLOCK, ModItems.CHUNK_DRIPSTONE.get(), 1, 4));
        lootTables.put(Blocks.SANDSTONE, createSilkTouchTable("sandstone", Blocks.SANDSTONE, ModItems.CHUNK_SANDSTONE.get(), 1, 4));
        lootTables.put(Blocks.DIORITE, createSilkTouchTable("diorite", Blocks.DIORITE, ModItems.CHUNK_DIORITE.get(), 1, 4));
        lootTables.put(Blocks.GRANITE, createSilkTouchTable("granite", Blocks.GRANITE, ModItems.CHUNK_GRANITE.get(), 1, 4));
        lootTables.put(Blocks.BASALT, createSilkTouchTable("basalt", Blocks.BASALT, ModItems.CHUNK_BASALT.get(), 1, 4));
        lootTables.put(Blocks.TUFF, createSilkTouchTable("tuff", Blocks.TUFF, ModItems.CHUNK_TUFF.get(), 1, 4));
        lootTables.put(Blocks.NETHERRACK, createSilkTouchTable("netherrack", Blocks.NETHERRACK, ModItems.CHUNK_NETHERRACK.get(), 1, 4));
        lootTables.put(Blocks.BLACKSTONE, createSilkTouchTable("blackstone", Blocks.BLACKSTONE, ModItems.CHUNK_BLACKSTONE.get(), 1, 4));

    }
}
