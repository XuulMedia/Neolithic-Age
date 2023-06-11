//package github.xuulmedia.neolith.datagen.loot;
//
//import github.xuulmedia.neolith.init.ModItems;
//import net.minecraft.data.DataGenerator;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.storage.loot.BuiltInLootTables;
//
//public class EntityLootTableProvider extends BaseLootTableProvider {
//
//    public EntityLootTableProvider(DataGenerator dataGeneratorIn) {
//        super(dataGeneratorIn);
//    }
//
//
//    @Override
//    protected void addTables() {
//        entityLootTables.put(EntityType.COW.getDefaultLootTable(), twoCommonMobDropTable(Items.BEEF, 0, 2, ModItems.HIDE_LARGE.get(), 0, 1));
//        entityLootTables.put(EntityType.PIG.getDefaultLootTable(), twoCommonMobDropTable(Items.PORKCHOP, 0, 2, ModItems.HIDE_MEDIUM.get(), 0, 1));
//
//         entityLootTables.put(BuiltInLootTables.SHEEP_BLACK, createSheepTable(Blocks.BLACK_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_BLUE, createSheepTable(Blocks.BLUE_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_BROWN, createSheepTable(Blocks.BROWN_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_CYAN, createSheepTable(Blocks.CYAN_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_GRAY, createSheepTable(Blocks.GRAY_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_GREEN, createSheepTable(Blocks.GREEN_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_LIGHT_BLUE, createSheepTable(Blocks.LIGHT_BLUE_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_LIGHT_GRAY, createSheepTable(Blocks.LIGHT_GRAY_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_LIME, createSheepTable(Blocks.LIME_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_MAGENTA, createSheepTable(Blocks.MAGENTA_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_ORANGE, createSheepTable(Blocks.ORANGE_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_PINK, createSheepTable(Blocks.PINK_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_PURPLE, createSheepTable(Blocks.PURPLE_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_RED, createSheepTable(Blocks.RED_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_WHITE, createSheepTable(Blocks.WHITE_WOOL));
//         entityLootTables.put(BuiltInLootTables.SHEEP_YELLOW, createSheepTable(Blocks.YELLOW_WOOL));
//
//
//    }
//
//
//}
//
//
//
//
