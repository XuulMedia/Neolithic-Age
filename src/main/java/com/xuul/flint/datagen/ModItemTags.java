package com.xuul.flint.datagen;

import com.xuul.flint.Flint;
import com.xuul.flint.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
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



    }
}