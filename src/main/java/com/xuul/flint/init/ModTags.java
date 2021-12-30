package com.xuul.flint.init;

import com.xuul.flint.Flint;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    private ModTags() {
    }


    public static final Tags.IOptionalNamedTag<Item> LOGS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "logs"));
    public static final Tags.IOptionalNamedTag<Item> STONE_CHUNKS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "stone_chunks"));




}
