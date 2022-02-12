package xuul.flint.common.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import xuul.flint.Flint;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;

public class ModTags {
    private ModTags() {
    }


    public static final Tags.IOptionalNamedTag<Item> HAMMERS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "hammers"));
    public static final Tags.IOptionalNamedTag<Item> SAWS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "saws"));
    public static final Tags.IOptionalNamedTag<Item> KNIVES = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "knives"));

    public static final Tags.IOptionalNamedTag<Item> LOGS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "logs"));
    public static final Tags.IOptionalNamedTag<Item> PLANKS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "planks"));


    public static final Tags.IOptionalNamedTag<Item> STONE_CHUNKS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "stone_chunks"));

    public static final Tags.IOptionalNamedTag<Item> BINDINGS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "bindings"));

    public static final Tags.IOptionalNamedTag<Item> PLANT_FIBRE = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "plant_fibre"));


    /*BlockTags*/
    public static final Tags.IOptionalNamedTag<Block> MINEABLE_WITH_HAMMER = BlockTags.createOptional(new ResourceLocation(Flint.MOD_ID, "plant_fibre"));




}
