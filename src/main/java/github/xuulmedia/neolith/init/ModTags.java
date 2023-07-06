package github.xuulmedia.neolith.init;


import github.xuulmedia.neolith.Neolith;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final TagKey<Item> HAMMERS = createItemTag("hammers");
    public static final TagKey<Item> SAWS = createItemTag("saws");
    public static final TagKey<Item> KNIVES = createItemTag("knives");
    public static final TagKey<Item> SHOVELS = createItemTag("shovels");
    public static final TagKey<Item> LOGS = createItemTag("logs");
    public static final TagKey<Item> PLANKS = createItemTag("planks");

    //Stone stuff
    public static final TagKey<Item> STONE_CHUNKS = createItemTag("stone_chunks");
    public static final TagKey<Item> DUSTS_STONE = createItemTag("dusts_stone");
    public static final TagKey<Item> DUSTS_SANDS = createItemTag("dusts_sand");
    public static final TagKey<Item> CLAY = createItemTag("clay");
    public static final TagKey<Item> BRICKS = createItemTag("brick");

    public static final TagKey<Item> COBBLESTONES = createItemTag("cobblestone");
    public static final TagKey<Item> BRICK_BLOCKS = createItemTag("brick_blocks");


    public static final TagKey<Item> LOW_HEAT_WOOD = createItemTag("low_heat_wood");
    public static final TagKey<Item> MED_HEAT_WOOD = createItemTag("med_heat_wood");
    public static final TagKey<Item> HIGH_HEAT_WOOD = createItemTag("high_heat_wood");
    public static final TagKey<Item> NETHER_HEAT_WOOD = createItemTag("nether_heat_wood");





    public static final TagKey<Item> BINDINGS = createItemTag("bindings");
    public static final TagKey<Item> PLANT_FIBRE = createItemTag("plant_fibre");


    /*For items that can light and put out campfires and torches*/
    public static final TagKey<Item> LIGHTERS = createItemTag("lighters");
    public static final TagKey<Item> DOUSERS = createItemTag("dousers");


    /*BlockTags*/
    public static final TagKey<Block> MINEABLE_WITH_HAMMER = createBlockTag("mineable/needs_hammer");
    public static final TagKey<Block> NEEDS_FLINT_TOOL = createBlockTag("requires_flint");
    public static final TagKey<Block> NEEDS_BRONZE_TOOL = createBlockTag("requires_bronze");
    public static final TagKey<Block> NEEDS_STEEL_TOOL = createBlockTag("requires_steel");


//    Stone Chunks



    /*Helpers*/
    private static TagKey<Block> createBlockTag(String location) {
        return BlockTags.create(new ResourceLocation(Neolith.MODID, location));
    }

    private static TagKey<Block> createBlockTagForge(String location) {
        return BlockTags.create(new ResourceLocation("forge", location));
    }

    private static TagKey<Block> createBlockTagMinecraft(String location) {
        return BlockTags.create(new ResourceLocation("minecraft", location));
    }


    private static TagKey<Item> createItemTag(String location) {
        return ItemTags.create(new ResourceLocation(Neolith.MODID, location));
    }

    private static TagKey<Item> createItemTagForge(String location) {
        return ItemTags.create(new ResourceLocation("forge", location));
    }

    private static TagKey<Item> createItemTagMinecraft(String location) {
        return ItemTags.create(new ResourceLocation("minecraft", location));

    }
}
