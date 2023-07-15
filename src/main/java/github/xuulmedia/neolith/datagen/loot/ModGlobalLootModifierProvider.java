package github.xuulmedia.neolith.datagen.loot;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.datagen.loot.AddItemModifier;
import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, Neolith.MODID);
    }

    @Override
    protected void start() {

        add("meat_from_camel", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(entity("camel")).build()},
                 ModItems.MEAT_CAMELID.get())
        );

//        add("meat_from_horse", new AddItemModifier(new LootItemCondition[]{
//                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER, EntityType.HORSE).build(),
//                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.HIDE_LARGE.get()));
//        }
////
//        add("kohlrabi_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
//                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.KOHLRABI_SEEDS.get()));
//        add("kohlrabi_seeds_from_fern", new AddItemModifier(new LootItemCondition[] {
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN).build(),
//                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.KOHLRABI_SEEDS.get()));
//
//        add("metal_detector_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
//                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build() },
//                ModItems.METAL_DETECTOR.get()));
//
    }



    private ResourceLocation entity(String name){
        return new ResourceLocation("entities/" + name);
    }
}
