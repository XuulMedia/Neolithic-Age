package ca.xuul.flint.datagen.loot;

import ca.xuul.flint.Flint;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifierProvider extends GlobalLootModifierProvider {

    public LootModifierProvider(DataGenerator generator) {
        super(generator, Flint.MOD_ID);

    }

    @Override
    protected void start() {

    }

//    @Override
//    protected void start() {
//        this.add("mineshaft_chest_additions", new AdditionLootModifier(
//                this.mod.resource("chests/mineshaft_chest_additions"),
//                new LootTableIdCondition.Builder(new ResourceLocation("minecraft", "chests/abandoned_mineshaft")).build()
//        ));
//    }
}
