package github.xuulmedia.neolith.datagen.loot;

import net.minecraft.data.loot.packs.VanillaEntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

public class ModEntityLoot extends VanillaEntityLoot {

    @Override
    public void generate() {
        this.add(EntityType.SHEEP, BuiltInLootTables.SHEEP_PURPLE, createSheepTable(Blocks.PURPLE_WOOL));

    }
}
