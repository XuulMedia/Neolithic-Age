package xuul.flint.datagen;

import xuul.flint.common.init.ModBlocks;
import xuul.flint.common.init.ModItems;
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
        lootTables.put(ModBlocks.ORE_TIN.get(), createSilkTouchTable("ore_tin", ModBlocks.ORE_TIN.get(), ModItems.RAW_TIN.get(), 1, 2));
        lootTables.put(ModBlocks.ORE_SILVER.get(), createSilkTouchTable("ore_silver", ModBlocks.ORE_SILVER.get(), ModItems.RAW_SILVER.get(), 1, 2));

        lootTables.put(ModBlocks.BLOCK_TIN.get(), DropSelfTable("block_tin", ModBlocks.BLOCK_TIN.get()));

        lootTables.put(Blocks.OAK_LOG, createSilkTouchTable("oak_log", Blocks.OAK_LOG, ModItems.LOG_OAK.get(), 1, 1));
        lootTables.put(Blocks.ACACIA_LOG, createSilkTouchTable("acacia_log", Blocks.ACACIA_LOG, ModItems.LOG_ACACIA.get(), 1, 1));
        lootTables.put(Blocks.BIRCH_LOG, createSilkTouchTable("birch_log", Blocks.BIRCH_LOG, ModItems.LOG_BIRCH.get(), 1, 1));
        lootTables.put(Blocks.CRIMSON_STEM, createSilkTouchTable("crimson_stem", Blocks.CRIMSON_STEM, ModItems.LOG_CRIMSON.get(), 1, 1));
        lootTables.put(Blocks.DARK_OAK_LOG, createSilkTouchTable("dark_oak_log", Blocks.DARK_OAK_LOG, ModItems.LOG_DARK_OAK.get(), 1, 1));
        lootTables.put(Blocks.JUNGLE_LOG, createSilkTouchTable("jungle_log", Blocks.JUNGLE_LOG, ModItems.LOG_JUNGLE.get(), 1, 1));
        lootTables.put(Blocks.SPRUCE_LOG, createSilkTouchTable("spruce_log", Blocks.SPRUCE_LOG, ModItems.LOG_SPRUCE.get(), 1, 1));
        lootTables.put(Blocks.WARPED_STEM, createSilkTouchTable("warped_stem", Blocks.WARPED_STEM, ModItems.LOG_WARPED.get(), 1, 1));

        lootTables.put(Blocks.OAK_LEAVES, leavesSticksSaplingTable("oak_leaves", Blocks.OAK_LEAVES,Items.STICK,0,1, Items.OAK_SAPLING,LEAVES_SAPLING_CHANCES));
        lootTables.put(Blocks.SPRUCE_LEAVES, leavesSticksSaplingTable("spruce_leaves", Blocks.SPRUCE_LEAVES,Items.STICK,0,1, Items.SPRUCE_SAPLING,LEAVES_SAPLING_CHANCES));
        lootTables.put(Blocks.BIRCH_LEAVES, leavesSticksSaplingTable("birch_leaves", Blocks.BIRCH_LEAVES,Items.STICK,0,1, Items.BIRCH_SAPLING,LEAVES_SAPLING_CHANCES));
        lootTables.put(Blocks.JUNGLE_LEAVES, leavesSticksSaplingTable("jungle_leaves", Blocks.JUNGLE_LEAVES,Items.STICK,0,1, Items.JUNGLE_SAPLING,LEAVES_SAPLING_CHANCES));
        lootTables.put(Blocks.ACACIA_LEAVES, leavesSticksSaplingTable("acacia_leaves", Blocks.ACACIA_LEAVES,Items.STICK,0,1, Items.ACACIA_SAPLING,LEAVES_SAPLING_CHANCES));
        lootTables.put(Blocks.DARK_OAK_LEAVES, leavesSticksSaplingTable("dark_oak_leaves", Blocks.DARK_OAK_LEAVES,Items.STICK,0,1, Items.DARK_OAK_SAPLING,LEAVES_SAPLING_CHANCES));





        lootTables.put(Blocks.STONE, HammerSmashingTable("stone", Blocks.STONE, ModItems.CHUNK_STONE.get(), ModItems.DUST_STONE.get(), 1, 4));
        lootTables.put(Blocks.ANDESITE, HammerSmashingTable("andesite", Blocks.ANDESITE, ModItems.CHUNK_ANDESITE.get(), ModItems.DUST_ANDESITE.get(), 1, 4));
        lootTables.put(Blocks.DEEPSLATE, HammerSmashingTable("deepslate", Blocks.DEEPSLATE, ModItems.CHUNK_DEEPSLATE.get(), ModItems.DUST_DEEPSLATE.get(), 1, 4));
        lootTables.put(Blocks.DRIPSTONE_BLOCK, HammerSmashingTable("dripstone", Blocks.DRIPSTONE_BLOCK, ModItems.CHUNK_DRIPSTONE.get(), ModItems.DUST_DRIPSTONE.get(), 1, 4));
        lootTables.put(Blocks.SANDSTONE, HammerSmashingTable("sandstone", Blocks.SANDSTONE, ModItems.CHUNK_SANDSTONE.get(), ModItems.DUST_SANDSTONE.get(), 1, 4));
        lootTables.put(Blocks.DIORITE, HammerSmashingTable("diorite", Blocks.DIORITE, ModItems.CHUNK_DIORITE.get(), ModItems.DUST_DIORITE.get(), 1, 4));
        lootTables.put(Blocks.GRANITE, HammerSmashingTable("granite", Blocks.GRANITE, ModItems.CHUNK_GRANITE.get(), ModItems.DUST_GRANITE.get(), 1, 4));
        lootTables.put(Blocks.BASALT, HammerSmashingTable("basalt", Blocks.BASALT, ModItems.CHUNK_BASALT.get(), ModItems.DUST_BASALT.get(), 1, 4));
        lootTables.put(Blocks.TUFF, HammerSmashingTable("tuff", Blocks.TUFF, ModItems.CHUNK_TUFF.get(), ModItems.DUST_TUFF.get(), 1, 4));
        lootTables.put(Blocks.NETHERRACK, HammerSmashingTable("netherrack", Blocks.NETHERRACK, ModItems.CHUNK_NETHERRACK.get(), ModItems.DUST_NETHERRACK.get(), 1, 4));
        lootTables.put(Blocks.BLACKSTONE, HammerSmashingTable("blackstone", Blocks.BLACKSTONE, ModItems.CHUNK_BLACKSTONE.get(), ModItems.DUST_BLACKSTONE.get(), 1, 4));

    }
}
