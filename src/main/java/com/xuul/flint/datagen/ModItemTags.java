package com.xuul.flint.datagen;

import com.xuul.flint.Flint;
import com.xuul.flint.init.ModItems;
import com.xuul.flint.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider {

    public ModItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, Flint.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(ModItems.ORE_TIN_ITEM.get())
                .add(ModItems.ORE_SILVER_ITEM.get());

        tag(Tags.Items.INGOTS)
                .add(ModItems.INGOT_TIN.get())
                .add(ModItems.INGOT_BRONZE.get())
                .add(ModItems.INGOT_SILVER.get())
                .add(ModItems.INGOT_STEEL.get());

        tag(ModTags.BINDINGS)
                .add(ModItems.BRAIDED_PLANT_FIBRE.get())
                .add(Items.STRING);

        tag(ModTags.PLANT_FIBRE)
                .add(ModItems.PLANT_FIBRE.get())
                .add(Items.VINE)
                .add(Items.TWISTING_VINES)
                .add(Items.WEEPING_VINES);

        tag(ModTags.HAMMERS)
                .add(ModItems.STONE_HAMMER.get());

        tag(ModTags.SAWS)
                .add(ModItems.FLINT_SAW.get());

        tag(ModTags.KNIVES)
                .add(ModItems.FLINT_KNIFE.get());



        tag(ModTags.LOGS)
                .add(ModItems.LOG_OAK.get())
                .add(ModItems.LOG_SPRUCE.get())
                .add(ModItems.LOG_BIRCH.get())
                .add(ModItems.LOG_JUNGLE.get())
                .add(ModItems.LOG_ACACIA.get())
                .add(ModItems.LOG_DARK_OAK.get())
                .add(ModItems.LOG_AZALEA.get())
                .add(ModItems.LOG_WARPED.get())
                .add(ModItems.LOG_CRIMSON.get());

        tag(ModTags.PLANKS)
                .add(ModItems.PLANK_OAK.get())
                .add(ModItems.PLANK_SPRUCE.get())
                .add(ModItems.PLANK_BIRCH.get())
                .add(ModItems.PLANK_JUNGLE.get())
                .add(ModItems.PLANK_ACACIA.get())
                .add(ModItems.PLANK_DARK_OAK.get())
                .add(ModItems.PLANK_AZALEA.get())
                .add(ModItems.PLANK_WARPED.get())
                .add(ModItems.PLANK_CRIMSON.get());

        tag(ModTags.STONE_CHUNKS)
                .add(ModItems.CHUNK_STONE.get())
                .add(ModItems.CHUNK_ANDESITE.get())
                .add(ModItems.CHUNK_DEEPSLATE.get())
                .add(ModItems.CHUNK_DRIPSTONE.get())
                .add(ModItems.CHUNK_DIORITE.get())
                .add(ModItems.CHUNK_GRANITE.get())
                .add(ModItems.CHUNK_BASALT.get())
                .add(ModItems.CHUNK_TUFF.get())
                .add(ModItems.CHUNK_NETHERRACK.get())
                .add(ModItems.CHUNK_BLACKSTONE.get())
                .add(ModItems.CHUNK_CALCITE.get());

    }
}