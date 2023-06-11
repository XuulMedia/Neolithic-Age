package github.xuulmedia.neolith.datagen.loot;

import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModItems;
import github.xuulmedia.neolith.init.ModTags;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    private static final float[] LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};
    private static final float[] MODDED_LEAVES_STICK_CHANCES = new float[]{0.4F, 0.444444444F, 0.45F, 0.5555555F, 1F};


    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
    private static final LootItemCondition.Builder HAS_KNIFE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.KNIVES));
    private static final LootItemCondition.Builder HAS_HAMMER = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.HAMMERS));


    @Override
    protected void addTables() {
        this.add(ModBlocks.ORE_TIN.get() , createSilkTouchTable("ore_tin", ModBlocks.ORE_TIN.get(), ModItems.RAW_TIN.get(), 1, 2));
        this.add(ModBlocks.ORE_SILVER.get() , createSilkTouchTable("ore_silver", ModBlocks.ORE_SILVER.get(), ModItems.RAW_SILVER.get(), 1, 2));

        this.dropSelf(ModBlocks.BLOCK_TIN.get());
        this.dropSelf(ModBlocks.BLOCK_SILVER.get());
        this.dropSelf(ModBlocks.BLOCK_BRONZE.get());
        this.dropSelf(ModBlocks.BLOCK_STEEL.get());

        this.dropOther(ModBlocks.FLINT_NODE.get(), Items.FLINT);

        this.dropSelf(ModBlocks.COBBLESTONE.get());
        this.dropSelf(ModBlocks.BASALT_COBBLESTONE.get());
        this.dropSelf(ModBlocks.DEEPSLATE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.NETHERRACK_COBBLESTONE.get());
        this.dropSelf(ModBlocks.SANDSTONE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.BLACKSTONE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.ENDSTONE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.GRANITE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.TUFF_COBBLESTONE.get());
        this.dropSelf(ModBlocks.ANDESITE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.DIORITE_COBBLESTONE.get());
        this.dropSelf(ModBlocks.CALCITE_COBBLESTONE.get());

        this.dropSelf(ModBlocks.STONE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.BASALT_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.DEEPSLATE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.NETHERRACK_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.SANDSTONE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.BLACKSTONE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.ENDSTONE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.GRANITE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.TUFF_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.ANDESITE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.DIORITE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.CALCITE_BRICK_BLOCK.get());

        this.dropSelf(ModBlocks.THATCH.get());

        this.dropSelf(ModBlocks.GRINDSTONE.get());
        this.dropSelf(ModBlocks.FOUNDRY.get());
        this.dropSelf(ModBlocks.FLINT_STATION.get());
        this.dropSelf(ModBlocks.KILN.get());

        this.dropOther(ModBlocks.CAMPFIRE.get(), Items.CHARCOAL);
        this.dropOther(ModBlocks.TORCH.get(), Items.STICK);

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }




    protected LootTable.Builder createSilkTouchTable(String name, Block block, Item lootItem, float min, float max) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
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
        return LootTable.lootTable().withPool(builder);
    }




    protected LootTable.Builder leavesSticksSaplingTable(String name,Block block, Item item1, Item sapling, float... chances){
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                        LootItem.lootTableItem(block).when(HAS_SHEARS_OR_SILK_TOUCH),
                        LootItem.lootTableItem(ModItems.PLANT_FIBRE.get()).when(HAS_KNIFE),
                        LootItem.lootTableItem(sapling).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,chances))
                                .otherwise(LootItem.lootTableItem(item1).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, MODDED_LEAVES_STICK_CHANCES))
                                )
                )
        );
        return LootTable.lootTable().withPool(builder);
    }


    protected LootTable.Builder HammerSmashingTable(String name, Block block, Item item, Item dust, float min, float max) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block).when(HAS_SILK_TOUCH),
                                LootItem.lootTableItem(dust).when(HAS_HAMMER)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1)),
                                LootItem.lootTableItem(item)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                        .apply(ApplyExplosionDecay.explosionDecay())
                        )
                );
        return LootTable.lootTable().withPool(builder);
    }

}
