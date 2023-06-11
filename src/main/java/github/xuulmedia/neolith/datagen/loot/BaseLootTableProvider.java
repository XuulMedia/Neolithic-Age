//package github.xuulmedia.neolith.datagen.loot;
//
//import github.xuulmedia.neolith.init.ModItems;
//import github.xuulmedia.neolith.init.ModTags;
//import com.google.common.collect.ImmutableSet;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import net.minecraft.advancements.critereon.*;
//import net.minecraft.data.CachedOutput;
//import net.minecraft.data.DataGenerator;
//import net.minecraft.data.DataProvider;
//import net.minecraft.data.loot.LootTableProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.enchantment.Enchantments;
//import net.minecraft.world.level.ItemLike;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.storage.loot.LootPool;
//import net.minecraft.world.level.storage.loot.LootTable;
//import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
//import net.minecraft.world.level.storage.loot.entries.LootItem;
//import net.minecraft.world.level.storage.loot.entries.LootTableReference;
//import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
//import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
//import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
//import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
//import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
//import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
//import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
//import net.minecraft.world.level.storage.loot.predicates.MatchTool;
//import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
//import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//public abstract class BaseLootTableProvider extends LootTableProvider {
//
//
//    private static final Logger LOGGER = LogManager.getLogger();
//    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
//
//    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
//    protected final Map<ResourceLocation, LootTable.Builder> entityLootTables = new HashMap<>();
//
//    private final DataGenerator generator;
//
//    public BaseLootTableProvider(DataGenerator dataGeneratorIn) {
//        super(dataGeneratorIn);
//        this.generator = dataGeneratorIn;
//    }
//
//    /*Block Related*/
//    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
//    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
//    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
//    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
//    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
//    private static final LootItemCondition.Builder HAS_KNIFE = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.KNIVES));
//    private static final LootItemCondition.Builder HAS_HAMMER = MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.HAMMERS));
//
//
//    /*Entity Related*/
//    protected static final EntityPredicate.Builder ENTITY_ON_FIRE = EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true).build());
//    private static final Set<EntityType<?>> SPECIAL_LOOT_TABLE_TYPES = ImmutableSet.of(EntityType.PLAYER, EntityType.ARMOR_STAND, EntityType.IRON_GOLEM, EntityType.SNOW_GOLEM, EntityType.VILLAGER);
//
//
//    protected abstract void addTables();
//
////    ref
////    protected LootTable.Builder createStandardTable(String name, Block block, BlockEntityType<?> type) {
////        LootPool.Builder builder = LootPool.lootPool()
////                .name(name)
////                .setRolls(ConstantValue.exactly(1))
////                .add(LootItem.lootTableItem(block)
////                        .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
////                        .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
////                                .copy("Info", "BlockEntityTag.Info", CopyNbtFunction.MergeStrategy.REPLACE)
////                                .copy("Inventory", "BlockEntityTag.Inventory", CopyNbtFunction.MergeStrategy.REPLACE)
////                                .copy("Energy", "BlockEntityTag.Energy", CopyNbtFunction.MergeStrategy.REPLACE))
////                        .apply(SetContainerContents.setContents(type)
////                                .withEntry(DynamicLoot.dynamicEntry(new ResourceLocation("minecraft", "contents"))))
////                );
////        return LootTable.lootTable().withPool(builder);
////    }
////
////    protected LootTable.Builder DropSelfTable(String name, Block block) {
////        LootPool.Builder builder = LootPool.lootPool()
////                .name(name)
////                .setRolls(ConstantValue.exactly(1))
////                .add(LootItem.lootTableItem(block));
////        return LootTable.lootTable().withPool(builder);
////    }
////
////    protected LootTable.Builder SingleItemDrop(String name ,Item item) {
////        LootPool.Builder builder = LootPool.lootPool()
////                .name(name)
////                .setRolls(ConstantValue.exactly(1))
////                .add(LootItem.lootTableItem(item));
////        return LootTable.lootTable().withPool(builder);
////    }
//
//
//    private static final float[] MODDED_LEAVES_STICK_CHANCES = new float[]{0.4F, 0.444444444F, 0.45F, 0.5555555F, 1F};
//
//
//    protected LootTable.Builder leavesSticksSaplingTable(String name,Block block, Item item1, Item sapling, float... chances){
//        LootPool.Builder builder = LootPool.lootPool()
//                .name(name)
//                .setRolls(ConstantValue.exactly(1))
//                .add(AlternativesEntry.alternatives(
//                        LootItem.lootTableItem(block).when(HAS_SHEARS_OR_SILK_TOUCH),
//                        LootItem.lootTableItem(ModItems.PLANT_FIBRE.get()).when(HAS_KNIFE),
//                        LootItem.lootTableItem(sapling).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,chances))
//                                .otherwise(LootItem.lootTableItem(item1).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, MODDED_LEAVES_STICK_CHANCES))
//                                )
//                )
//        );
//        return LootTable.lootTable().withPool(builder);
//    }
//
//
//    protected LootTable.Builder HammerSmashingTable(String name, Block block, Item item, Item dust, float min, float max) {
//        LootPool.Builder builder = LootPool.lootPool()
//                .name(name)
//                .setRolls(ConstantValue.exactly(1))
//                .add(AlternativesEntry.alternatives(
//                                LootItem.lootTableItem(block).when(HAS_SILK_TOUCH),
//                                LootItem.lootTableItem(dust).when(HAS_HAMMER)
//                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
//                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1)),
//                                LootItem.lootTableItem(item)
//                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
//                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
//                                        .apply(ApplyExplosionDecay.explosionDecay())
//                        )
//                );
//        return LootTable.lootTable().withPool(builder);
//    }
//
//
//    //    Functions with silk touch. Provide the block itself then the item with fortune  bonus numbers after
//    protected LootTable.Builder createSilkTouchTable(String name, Block block, Item lootItem, float min, float max) {
//        LootPool.Builder builder = LootPool.lootPool()
//                .name(name)
//                .setRolls(ConstantValue.exactly(1))
//                .add(AlternativesEntry.alternatives(
//                        LootItem.lootTableItem(block)
//                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
//                                        .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))),
//                        LootItem.lootTableItem(lootItem)
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
//                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
//                                .apply(ApplyExplosionDecay.explosionDecay())
//                        )
//                );
//        return LootTable.lootTable().withPool(builder);
//    }
//
//
//
//
//
//    /* ************ */
//    /*    Entity    */
//    /* *********** */
//
//
//    protected LootTable.Builder twoCommonMobDropTable(Item loot1,  float min1, float max1, Item loot2, float min2, float max2) {
//        LootPool.Builder builder1 = LootPool.lootPool()
//                .setRolls(ConstantValue.exactly(1.0F))
//                .add(LootItem.lootTableItem(loot1)
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min1, max1)))
//                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))));
//
//        LootPool.Builder builder2 = LootPool.lootPool()
//                .setRolls(ConstantValue.exactly(1.0F))
//                .add(LootItem.lootTableItem(loot2)
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min2, max2)))
//                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F))));
//
//        return LootTable.lootTable().withPool(builder1).withPool(builder2);
//
//    }
//
//    protected static LootTable.Builder createSheepTable(ItemLike pWool) {
//        return LootTable.lootTable()
//                .withPool(
//                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//                                .add(LootItem.lootTableItem(pWool)))
//
//                .withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1.0F))
//                        .add(LootTableReference.lootTableReference(EntityType.SHEEP.getDefaultLootTable())));
//    }
//
//
//
//
//
//    /*Helpers*/
//
//
//    @Override
//    public void run(CachedOutput cache) {
//        addTables();
//
//        Map<ResourceLocation, LootTable> tables = new HashMap<>();
//        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
//            tables.put(entry.getKey().getLootTable(), entry.getValue().setParamSet(LootContextParamSets.BLOCK).build());
//        }
//        for (Map.Entry<ResourceLocation, LootTable.Builder> entry : entityLootTables.entrySet()) {
//            tables.put(entry.getKey(), entry.getValue().setParamSet(LootContextParamSets.ENTITY).build());
//        }
//        writeTables(cache, tables);
//    }
//
//    private void writeTables(CachedOutput cache, Map<ResourceLocation, LootTable> tables) {
//        Path outputFolder = this.generator.getOutputFolder();
//        tables.forEach((key, lootTable) -> {
//            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
//            try {
//                DataProvider.saveStable(cache, LootTables.serialize(lootTable), path);
//            } catch (IOException e) {
//                LOGGER.error("Couldn't write loot table {}", path, e);
//            }
//        });
//    }
//
////    @Override
////    public String getName() {
////        return "Flint LootTables";
////    }
//
//
//
//}
