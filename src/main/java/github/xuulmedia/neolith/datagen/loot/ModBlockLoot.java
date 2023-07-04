package github.xuulmedia.neolith.datagen.loot;

import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModItems;
import github.xuulmedia.neolith.init.ModTags;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLoot extends VanillaBlockLoot {

    protected static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    protected static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    protected static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    protected static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
    protected static final LootItemCondition.Builder HAS_KNIFE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.KNIVES));
    protected static final LootItemCondition.Builder HAS_HAMMER = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.HAMMERS));

    private static final float[] LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};
    protected static final float[] MODDED_LEAVES_STICK_CHANCES = new float[]{0.4F, 0.444444444F, 0.45F, 0.5555555F, 1F};

    @Override
    protected void generate() {

        HammerSmashingTable(ModBlocks.ORE_TIN.get(), ModItems.RAW_TIN.get(), ModItems.DUST_TIN.get(), 1, 3);
        HammerSmashingTable(ModBlocks.ORE_SILVER.get(), ModItems.RAW_SILVER.get(), ModItems.DUST_SILVER.get(), 1, 3);
        dropOther(ModBlocks.ORE_CLAY.get(), Items.CLAY_BALL);

        dropSelf(ModBlocks.BLOCK_TIN.get());
        dropSelf(ModBlocks.BLOCK_SILVER.get());
        dropSelf(ModBlocks.BLOCK_BRONZE.get());
        dropSelf(ModBlocks.BLOCK_STEEL.get());

        HammerSmashingTable(ModBlocks.COBBLESTONE.get(), ModItems.CHUNK_STONE.get(), ModItems.DUST_STONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.BASALT_COBBLESTONE.get(), ModItems.CHUNK_BASALT.get(), ModItems.DUST_BASALT.get(), 2, 4);
        HammerSmashingTable(ModBlocks.DEEPSLATE_COBBLESTONE.get(), ModItems.CHUNK_DEEPSLATE.get(), ModItems.DUST_DEEPSLATE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.NETHERRACK_COBBLESTONE.get(), ModItems.CHUNK_NETHERRACK.get(), ModItems.DUST_NETHERRACK.get(), 2, 4);
        HammerSmashingTable(ModBlocks.SANDSTONE_COBBLESTONE.get(), ModItems.CHUNK_SANDSTONE.get(), ModItems.DUST_SANDSTONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.BLACKSTONE_COBBLESTONE.get(), ModItems.CHUNK_BLACKSTONE.get(), ModItems.DUST_BLACKSTONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.ENDSTONE_COBBLESTONE.get(), ModItems.CHUNK_ENDSTONE.get(), ModItems.DUST_ENDSTONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.GRANITE_COBBLESTONE.get(), ModItems.CHUNK_GRANITE.get(), ModItems.DUST_GRANITE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.TUFF_COBBLESTONE.get(), ModItems.CHUNK_TUFF.get(), ModItems.DUST_TUFF.get(), 2, 4);
        HammerSmashingTable(ModBlocks.ANDESITE_COBBLESTONE.get(), ModItems.CHUNK_ANDESITE.get(), ModItems.DUST_ANDESITE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.DIORITE_COBBLESTONE.get(), ModItems.CHUNK_DIORITE.get(), ModItems.DUST_DIORITE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.CALCITE_COBBLESTONE.get(), ModItems.CHUNK_CALCITE.get(), ModItems.DUST_CALCITE.get(), 2, 4);

        HammerSmashingTable(ModBlocks.STONE_BRICK_BLOCK.get(), ModItems.BRICK_STONE.get(), ModItems.DUST_STONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.BASALT_BRICK_BLOCK.get(), ModItems.BRICK_BASALT.get(), ModItems.DUST_BASALT.get(), 2, 4);
        HammerSmashingTable(ModBlocks.DEEPSLATE_BRICK_BLOCK.get(), ModItems.BRICK_DEEPSLATE.get(), ModItems.DUST_DEEPSLATE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.NETHERRACK_BRICK_BLOCK.get(), ModItems.BRICK_NETHERRACK.get(), ModItems.DUST_NETHERRACK.get(), 2, 4);
        HammerSmashingTable(ModBlocks.SANDSTONE_BRICK_BLOCK.get(), ModItems.BRICK_SANDSTONE.get(), ModItems.DUST_SANDSTONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.BLACKSTONE_BRICK_BLOCK.get(), ModItems.BRICK_BLACKSTONE.get(), ModItems.DUST_BLACKSTONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.ENDSTONE_BRICK_BLOCK.get(), ModItems.BRICK_ENDSTONE.get(), ModItems.DUST_ENDSTONE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.GRANITE_BRICK_BLOCK.get(), ModItems.BRICK_GRANITE.get(), ModItems.DUST_GRANITE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.TUFF_BRICK_BLOCK.get(), ModItems.BRICK_TUFF.get(), ModItems.DUST_TUFF.get(), 2, 4);
        HammerSmashingTable(ModBlocks.ANDESITE_BRICK_BLOCK.get(), ModItems.BRICK_ANDESITE.get(), ModItems.DUST_ANDESITE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.DIORITE_BRICK_BLOCK.get(), ModItems.BRICK_DIORITE.get(), ModItems.DUST_DIORITE.get(), 2, 4);
        HammerSmashingTable(ModBlocks.CALCITE_BRICK_BLOCK.get(), ModItems.BRICK_CALCITE.get(), ModItems.DUST_CALCITE.get(), 2, 4);

        dropOther(ModBlocks.FLINT_NODE.get(), Items.FLINT);

        dropSelf(ModBlocks.TORCH.get());
        dropSelf(ModBlocks.WARDED_GRASS_BLOCK.get());

        dropSelf(ModBlocks.MANUAL_GRINDER.get());
        dropSelf(ModBlocks.FLINT_STATION.get());
        dropSelf(ModBlocks.FORGE.get());
        dropSelf(ModBlocks.FOUNDRY.get());
        dropSelf(ModBlocks.WORK_BENCH.get());

        dropOther(ModBlocks.CAMPFIRE.get(), Items.STICK);

        dropSelf(ModBlocks.THATCH.get());


        createSilkTouchTable(Blocks.ACACIA_LOG, ModItems.LOG_ACACIA.get(), 1, 1);
        createSilkTouchTable(Blocks.BIRCH_LOG, ModItems.LOG_BIRCH.get(), 1, 1);
        createSilkTouchTable(Blocks.CHERRY_LOG, ModItems.LOG_CHERRY.get(), 1, 1);
        createSilkTouchTable(Blocks.DARK_OAK_LOG, ModItems.LOG_DARK_OAK.get(), 1, 1);
        createSilkTouchTable(Blocks.JUNGLE_LOG, ModItems.LOG_JUNGLE.get(), 1, 1);
        createSilkTouchTable(Blocks.MANGROVE_LOG, ModItems.LOG_MANGROVE.get(), 1, 1);
        createSilkTouchTable(Blocks.OAK_LOG, ModItems.LOG_OAK.get(), 1, 1);
        createSilkTouchTable(Blocks.SPRUCE_LOG, ModItems.LOG_SPRUCE.get(), 1, 1);
        createSilkTouchTable(Blocks.WARPED_STEM, ModItems.LOG_WARPED.get(), 1, 1);
        createSilkTouchTable(Blocks.CRIMSON_STEM, ModItems.LOG_CRIMSON.get(), 1, 1);

        createSilkTouchTable(Blocks.ACACIA_WOOD, ModItems.LOG_ACACIA.get(), 1, 1);
        createSilkTouchTable(Blocks.BIRCH_WOOD, ModItems.LOG_BIRCH.get(), 1, 1);
        createSilkTouchTable(Blocks.CHERRY_WOOD, ModItems.LOG_CHERRY.get(), 1, 1);
        createSilkTouchTable(Blocks.DARK_OAK_WOOD, ModItems.LOG_DARK_OAK.get(), 1, 1);
        createSilkTouchTable(Blocks.JUNGLE_WOOD, ModItems.LOG_JUNGLE.get(), 1, 1);
        createSilkTouchTable(Blocks.MANGROVE_WOOD, ModItems.LOG_MANGROVE.get(), 1, 1);
        createSilkTouchTable(Blocks.OAK_WOOD, ModItems.LOG_OAK.get(), 1, 1);
        createSilkTouchTable(Blocks.SPRUCE_WOOD, ModItems.LOG_SPRUCE.get(), 1, 1);

        createSilkTouchTable(Blocks.STRIPPED_ACACIA_LOG, ModItems.LOG_ACACIA.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_BIRCH_LOG, ModItems.LOG_BIRCH.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_CHERRY_LOG, ModItems.LOG_CHERRY.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_DARK_OAK_LOG, ModItems.LOG_DARK_OAK.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_JUNGLE_LOG, ModItems.LOG_JUNGLE.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_MANGROVE_LOG, ModItems.LOG_MANGROVE.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_OAK_LOG, ModItems.LOG_OAK.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_SPRUCE_LOG, ModItems.LOG_SPRUCE.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_WARPED_STEM, ModItems.LOG_WARPED.get(), 1, 1);
        createSilkTouchTable(Blocks.STRIPPED_CRIMSON_STEM, ModItems.LOG_CRIMSON.get(), 1, 1);

        createSilkTouchTable(Blocks.ACACIA_PLANKS, ModItems.PLANK_ACACIA.get(), 1, 4);
        createSilkTouchTable(Blocks.BIRCH_PLANKS, ModItems.PLANK_BIRCH.get(), 1, 4);
        createSilkTouchTable(Blocks.CHERRY_PLANKS, ModItems.PLANK_CHERRY.get(), 1, 4);
        createSilkTouchTable(Blocks.DARK_OAK_PLANKS, ModItems.PLANK_DARK_OAK.get(), 1, 4);
        createSilkTouchTable(Blocks.JUNGLE_PLANKS, ModItems.PLANK_JUNGLE.get(), 1, 4);
        createSilkTouchTable(Blocks.MANGROVE_PLANKS, ModItems.PLANK_MANGROVE.get(), 1, 4);
        createSilkTouchTable(Blocks.OAK_PLANKS, ModItems.PLANK_OAK.get(), 1, 4);
        createSilkTouchTable(Blocks.SPRUCE_PLANKS, ModItems.PLANK_SPRUCE.get(), 1, 4);
        createSilkTouchTable(Blocks.WARPED_PLANKS, ModItems.PLANK_WARPED.get(), 1, 4);
        createSilkTouchTable(Blocks.CRIMSON_PLANKS, ModItems.PLANK_CRIMSON.get(), 1, 4);

        leavesSticksSaplingTable(Blocks.ACACIA_LEAVES, Items.STICK, Items.ACACIA_SAPLING, LEAVES_SAPLING_CHANCES);
        leavesSticksSaplingTable(Blocks.BIRCH_LEAVES, Items.STICK, Items.BIRCH_SAPLING, LEAVES_SAPLING_CHANCES);
        leavesSticksSaplingTable(Blocks.CHERRY_LEAVES, Items.STICK, Items.CHERRY_SAPLING, LEAVES_SAPLING_CHANCES);
        leavesSticksSaplingTable(Blocks.DARK_OAK_LEAVES, Items.STICK, Items.DARK_OAK_SAPLING, LEAVES_SAPLING_CHANCES);
        leavesSticksSaplingTable(Blocks.JUNGLE_LEAVES, Items.STICK, Items.JUNGLE_SAPLING, JUNGLE_LEAVES_SAPLING_CHANGES);
        leavesSticksSaplingTable(Blocks.MANGROVE_LEAVES, Items.STICK, Items.MANGROVE_PROPAGULE, LEAVES_SAPLING_CHANCES);
        leavesSticksSaplingTable(Blocks.OAK_LEAVES, Items.STICK, Items.OAK_SAPLING, LEAVES_SAPLING_CHANCES);
        leavesSticksSaplingTable(Blocks.SPRUCE_LEAVES, Items.STICK, Items.SPRUCE_SAPLING, LEAVES_SAPLING_CHANCES);

//       leavesSticksSaplingTable(Blocks.AZALEA_LEAVES, Items.STICK, Items.AZALEA_SAPLING, LEAVES_SAPLING_CHANCES);
//        leavesSticksSaplingTable(Blocks.FLOWERING_AZALEA_LEAVES, Items.STICK, Items.FLOWERING_AZALEA_SAPLING, LEAVES_SAPLING_CHANCES);
//        leavesSticksSaplingTable(Blocks.WARPED_LEAVES, Items.STICK, Items.WARPED_FUNGUS, JUNGLE_LEAVES_SAPLING_CHANGES);  //nether wart instead o leave and stick
//        leavesSticksSaplingTable(Blocks.CRIMSON_LEAVES, Items.STICK, Items.CRIMSON_FUNGUS, JUNGLE_LEAVES_SAPLING_CHANGES);

        HammerSmashingTable(Blocks.ANDESITE, ModItems.CHUNK_ANDESITE.get(), ModItems.DUST_ANDESITE.get(), 1, 4);
        HammerSmashingTable(Blocks.BASALT, ModItems.CHUNK_BASALT.get(), ModItems.DUST_BASALT.get(), 1, 4);
        HammerSmashingTable(Blocks.BLACKSTONE, ModItems.CHUNK_BLACKSTONE.get(), ModItems.DUST_BLACKSTONE.get(), 1, 4);
        HammerSmashingTable(Blocks.CALCITE, ModItems.CHUNK_CALCITE.get(), ModItems.DUST_CALCITE.get(), 1, 4);
        HammerSmashingTable(Blocks.DEEPSLATE, ModItems.CHUNK_DEEPSLATE.get(), ModItems.DUST_DEEPSLATE.get(), 1, 4);
        HammerSmashingTable(Blocks.DIORITE, ModItems.CHUNK_DIORITE.get(), ModItems.DUST_DIORITE.get(), 1, 4);
        HammerSmashingTable(Blocks.DRIPSTONE_BLOCK, ModItems.CHUNK_DRIPSTONE.get(), ModItems.DUST_DRIPSTONE.get(), 1, 4);
        HammerSmashingTable(Blocks.GRANITE, ModItems.CHUNK_GRANITE.get(), ModItems.DUST_GRANITE.get(), 1, 4);
        HammerSmashingTable(Blocks.NETHERRACK, ModItems.CHUNK_NETHERRACK.get(), ModItems.DUST_NETHERRACK.get(), 1, 4);
        HammerSmashingTable(Blocks.RED_SANDSTONE, ModItems.CHUNK_RED_SANDSTONE.get(), ModItems.DUST_RED_SANDSTONE.get(), 1, 4);
        HammerSmashingTable(Blocks.SANDSTONE, ModItems.CHUNK_SANDSTONE.get(), ModItems.DUST_SANDSTONE.get(), 1, 4);
        HammerSmashingTable(Blocks.STONE, ModItems.CHUNK_STONE.get(), ModItems.DUST_STONE.get(), 1, 4);
        HammerSmashingTable(Blocks.TUFF, ModItems.CHUNK_TUFF.get(), ModItems.DUST_TUFF.get(), 1, 4);
        HammerSmashingTable(Blocks.END_STONE, ModItems.CHUNK_ENDSTONE.get(), ModItems.DUST_ENDSTONE.get(), 1, 4);


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.concat(
                ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get),
                VANILLA_BLOCKS_TO_OVERRIDE.stream()
        )::iterator;
    }

    private static final Set<Block> VANILLA_BLOCKS_TO_OVERRIDE = Set.of(
            Blocks.ACACIA_LOG,
            Blocks.BIRCH_LOG,
            Blocks.CHERRY_LOG,
            Blocks.DARK_OAK_LOG,
            Blocks.JUNGLE_LOG,
            Blocks.MANGROVE_LOG,
            Blocks.OAK_LOG,
            Blocks.SPRUCE_LOG,
            Blocks.WARPED_STEM,
            Blocks.CRIMSON_STEM,
            Blocks.STRIPPED_ACACIA_LOG,
            Blocks.STRIPPED_BIRCH_LOG,
            Blocks.STRIPPED_CHERRY_LOG,
            Blocks.STRIPPED_DARK_OAK_LOG,
            Blocks.STRIPPED_JUNGLE_LOG,
            Blocks.STRIPPED_MANGROVE_LOG,
            Blocks.STRIPPED_OAK_LOG,
            Blocks.STRIPPED_SPRUCE_LOG,
            Blocks.STRIPPED_WARPED_STEM,
            Blocks.STRIPPED_CRIMSON_STEM,
            Blocks.ACACIA_WOOD,
            Blocks.BIRCH_WOOD,
            Blocks.CHERRY_WOOD,
            Blocks.DARK_OAK_WOOD,
            Blocks.JUNGLE_WOOD,
            Blocks.MANGROVE_WOOD,
            Blocks.OAK_WOOD,
            Blocks.SPRUCE_WOOD,
            Blocks.ACACIA_PLANKS,
            Blocks.BIRCH_PLANKS,
            Blocks.CHERRY_PLANKS,
            Blocks.DARK_OAK_PLANKS,
            Blocks.JUNGLE_PLANKS,
            Blocks.MANGROVE_PLANKS,
            Blocks.OAK_PLANKS,
            Blocks.SPRUCE_PLANKS,
            Blocks.WARPED_PLANKS,
            Blocks.CRIMSON_PLANKS,
            Blocks.ACACIA_LEAVES,
            Blocks.BIRCH_LEAVES,
            Blocks.CHERRY_LEAVES,
            Blocks.DARK_OAK_LEAVES,
            Blocks.JUNGLE_LEAVES,
            Blocks.MANGROVE_LEAVES,
            Blocks.OAK_LEAVES,
            Blocks.SPRUCE_LEAVES,
            Blocks.ANDESITE,
            Blocks.BASALT,
            Blocks.BLACKSTONE,
            Blocks.CALCITE,
            Blocks.DEEPSLATE,
            Blocks.DIORITE,
            Blocks.DRIPSTONE_BLOCK,
            Blocks.GRANITE,
            Blocks.NETHERRACK,
            Blocks.RED_SANDSTONE,
            Blocks.SANDSTONE,
            Blocks.STONE,
            Blocks.TUFF,
            Blocks.END_STONE
    );

    protected void leavesSticksSaplingTable(Block block, Item item1, Item sapling, float... chances) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block).when(HAS_SHEARS.or(HAS_SILK_TOUCH)),
                                LootItem.lootTableItem(ModItems.PLANT_FIBRE.get()).when(HAS_KNIFE),
                                LootItem.lootTableItem(sapling).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, chances))
                                        .otherwise(LootItem.lootTableItem(item1).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, MODDED_LEAVES_STICK_CHANCES))
                                        )
                        )
                );
        this.add(block, LootTable.lootTable().withPool(builder));

    }

    protected void HammerSmashingTable(Block block, Item chunk, Item dust, float min, float max) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block).when(HAS_SILK_TOUCH),
                                LootItem.lootTableItem(dust).when(HAS_HAMMER)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1)),
                                LootItem.lootTableItem(chunk)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                        .apply(ApplyExplosionDecay.explosionDecay())
                        )
                );
        this.add(block, LootTable.lootTable().withPool(builder));
    }

    protected void createSilkTouchTable(Block block, Item lootItem, float min, float max) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block)
                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))),
                                LootItem.lootTableItem(lootItem)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                        .apply(ApplyExplosionDecay.explosionDecay())
                        )
                );

        this.add(block, LootTable.lootTable().withPool(builder));
    }

    protected static LootTable.Builder createSelfDropDispatchTable(Block p_252253_, LootItemCondition.Builder p_248764_, LootPoolEntryContainer.Builder<?> p_249146_) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(p_252253_).when(p_248764_).otherwise(p_249146_)));
    }

}
