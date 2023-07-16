package github.xuulmedia.neolith.datagen.loot;

import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.packs.VanillaEntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModEntityLoot extends VanillaEntityLoot {

    @Override
    public void generate() {
        createAnimalDropTable(EntityType.CAMEL, ModItems.HIDE_LARGE.get(), ModItems.MEAT_CAMELID.get(), 1, 3);
        //chicken
        createAnimalDropTable(EntityType.COW, ModItems.HIDE_LARGE.get(), Items.BEEF, 1, 3);
        createAnimalDropTable(EntityType.DONKEY, ModItems.HIDE_MEDIUM.get(), ModItems.MEAT_EQUINE.get(), 1, 3);
        createAnimalDropTable(EntityType.FOX, ModItems.HIDE_SMALL.get());
        //frog
        createAnimalDropTable(EntityType.HORSE, ModItems.HIDE_MEDIUM.get(), ModItems.MEAT_EQUINE.get(), 1, 3);
        createAnimalDropTable(EntityType.MOOSHROOM, ModItems.HIDE_LARGE.get(), Items.BEEF, 1, 3);
        createAnimalDropTable(EntityType.MULE, ModItems.HIDE_MEDIUM.get(), ModItems.MEAT_EQUINE.get(), 1, 2);
        //parrot
        createAnimalDropTable(EntityType.PIG, ModItems.HIDE_MEDIUM.get(), Items.PORKCHOP, 1, 2);
        createAnimalDropTable(EntityType.RABBIT, ModItems.HIDE_SMALL.get(), Items.RABBIT, 1, 1);
        //TODO sheep
        //turtle

        /*Neutral Mobs*/
        createAnimalDropTable(EntityType.GOAT, ModItems.HIDE_MEDIUM.get(), Items.MUTTON, 1, 2);
        createAnimalDropTable(EntityType.LLAMA, ModItems.HIDE_MEDIUM.get(), ModItems.MEAT_CAMELID.get(), 1, 2);
        createAnimalDropTable(EntityType.TRADER_LLAMA, ModItems.HIDE_MEDIUM.get(), ModItems.MEAT_CAMELID.get(), 1, 2);

        createAnimalDropTable(EntityType.POLAR_BEAR, ModItems.HIDE_LARGE.get(), ModItems.MEAT_BEAR.get(), 2, 5);
        createAnimalDropTable(EntityType.PANDA, ModItems.HIDE_LARGE.get(), ModItems.MEAT_BEAR.get(), 2, 5);


        /*HOSTILE*/
        createAnimalDropTable(EntityType.HOGLIN, ModItems.HIDE_LARGE.get(), Items.PORKCHOP, 2, 5);

    }


    @Override
    protected java.util.stream.Stream<EntityType<?>> getKnownEntityTypes() {
        return ENTITY_TYPES_TO_OVERWRITE.stream();
    }

    private static final Set<EntityType<?>> ENTITY_TYPES_TO_OVERWRITE = Set.of(
            EntityType.CAMEL,
            EntityType.COW,
            EntityType.DONKEY,
            EntityType.FOX,
            EntityType.HORSE,
            EntityType.MOOSHROOM,
            EntityType.MULE,
            EntityType.PIG,
            EntityType.RABBIT,
            EntityType.GOAT,
            EntityType.LLAMA,
            EntityType.TRADER_LLAMA,
            EntityType.POLAR_BEAR,
            EntityType.PANDA,
            EntityType.HOGLIN

    );



    private void createAnimalDropTable(EntityType animal, Item hide, Item meat, float meatMin, float meatMax) {
        LootPool.Builder hideBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(hide)
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0f, 1.0f))));

        LootPool.Builder meatBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(meat)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(meatMin, meatMax)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0f, 1.0f))));

        LootPool.Builder fatBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(ModItems.ANIMAL_FAT.get())
                        .when(LootItemRandomChanceCondition.randomChance(0.7F)));

        this.add(animal, LootTable.lootTable().withPool(hideBuilder).withPool(meatBuilder).withPool(fatBuilder));
    }

    private void createAnimalDropTable(EntityType animal, Item hide) {
        LootPool.Builder hideBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(hide)
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0f, 1.0f))));

        this.add(animal, LootTable.lootTable().withPool(hideBuilder));
    }


    //for cooked meat use ALTERNATIVES instead of smelting since that is disabled
    /*TODO - fat differences, and add bones*/

}


