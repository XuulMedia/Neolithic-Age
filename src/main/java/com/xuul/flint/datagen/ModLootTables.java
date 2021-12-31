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

    }
}
