package com.xuul.flint.init;

import com.xuul.flint.Flint;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags {
    private ModTags() {
    }



    public static final Tags.IOptionalNamedTag<Item> LOGS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "logs"));
    public static final Tags.IOptionalNamedTag<Item> STONE_CHUNKS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "stone_chunks"));

    public static final Tags.IOptionalNamedTag<Item> BINDINGS = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "bindings"));

    public static final Tags.IOptionalNamedTag<Item> PLANT_FIBRE = ItemTags.createOptional(new ResourceLocation(Flint.MOD_ID, "plant_fibre"));




}
