package com.xuul.flint.datagen;

import com.xuul.flint.init.ModBlocks;
import com.xuul.flint.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;


public class ModLootTables extends BaseLootTableProvider {

    public ModLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(ModBlocks.ORE_TIN.get(), createSilkTouchTable("ore_tin", ModBlocks.ORE_TIN.get(), ModItems.RAW_TIN.get(), 1, 3));
        lootTables.put(ModBlocks.ORE_SILVER.get(), createSilkTouchTable("ore_silver", ModBlocks.ORE_SILVER.get(), ModItems.RAW_SILVER.get(), 1, 3));

        lootTables.put(Blocks.OAK_LOG, createSilkTouchTable("oak_log", Blocks.OAK_LOG, ModItems.LOG_OAK.get(), 1, 3));
        lootTables.put(Blocks.ACACIA_LOG, createSilkTouchTable("acacia_log", Blocks.ACACIA_LOG, ModItems.LOG_ACACIA.get(), 1, 3));
        lootTables.put(Blocks.BIRCH_LOG, createSilkTouchTable("birch_log", Blocks.BIRCH_LOG, ModItems.LOG_BIRCH.get(), 1, 3));
        lootTables.put(Blocks.CRIMSON_STEM, createSilkTouchTable("crimson_stem", Blocks.CRIMSON_STEM, ModItems.LOG_CRIMSON.get(), 1, 3));
        lootTables.put(Blocks.DARK_OAK_LOG, createSilkTouchTable("dark_oak_log", Blocks.DARK_OAK_LOG, ModItems.LOG_DARK_OAK.get(), 1, 3));
        lootTables.put(Blocks.JUNGLE_LOG, createSilkTouchTable("jungle_log", Blocks.JUNGLE_LOG, ModItems.LOG_JUNGLE.get(), 1, 3));
        lootTables.put(Blocks.SPRUCE_LOG, createSilkTouchTable("spruce_log", Blocks.SPRUCE_LOG, ModItems.LOG_SPRUCE.get(), 1, 3));
        lootTables.put(Blocks.WARPED_STEM, createSilkTouchTable("warped_stem", Blocks.WARPED_STEM, ModItems.LOG_WARPED.get(), 1, 3));

    }
}
