package ca.xuul.flint.init;

import ca.xuul.flint.Flint;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;


public class ModTags {
    private ModTags() {
    }

    public static final TagKey<Item> HAMMERS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "hammers"));
    public static final TagKey<Item> SAWS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "saws"));
    public static final TagKey<Item> KNIVES = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "knives"));
    public static final TagKey<Item> SHOVELS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "shovels"));

    public static final TagKey<Item> LOGS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "logs"));
    public static final TagKey<Item> PLANKS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "planks"));


    public static final TagKey<Item> STONE_CHUNKS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "stone_chunks"));

    public static final TagKey<Item> BINDINGS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "bindings"));

    public static final TagKey<Item> PLANT_FIBRE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "plant_fibre"));


    public static final TagKey<Item> CLAY = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "clay"));


    /*For items that can light and put out campfires and torches*/
    public static final TagKey<Item> LIGHTERS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "lighters"));
    public static final TagKey<Item> DOUSERS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Flint.MOD_ID, "dousers"));


    /*BlockTags*/
    public static final TagKey<Block> MINEABLE_WITH_HAMMER = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Flint.MOD_ID, "requires_hammer"));

    public static final TagKey<Block> NEEDS_FLINT_TOOL = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Flint.MOD_ID, "requires_flint"));




}
