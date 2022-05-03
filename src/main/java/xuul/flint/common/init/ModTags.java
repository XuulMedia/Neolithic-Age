package xuul.flint.common.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import xuul.flint.Flint;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;


public class ModTags {
    private ModTags() {
    }


    public static final TagKey<Item> HAMMERS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "hammers"));
    public static final TagKey<Item> SAWS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "saws"));
    public static final TagKey<Item> KNIVES = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "knives"));

    public static final TagKey<Item> LOGS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "logs"));
    public static final TagKey<Item> PLANKS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "planks"));


    public static final TagKey<Item> STONE_CHUNKS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "stone_chunks"));

    public static final TagKey<Item> BINDINGS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "bindings"));

    public static final TagKey<Item> PLANT_FIBRE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "plant_fibre"));


    public static final TagKey<Item> CLAY = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "clay"));


    /*BlockTags*/
    public static final TagKey<Block> MINEABLE_WITH_HAMMER = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Flint.MOD_ID, "plant_fibre"));




}
