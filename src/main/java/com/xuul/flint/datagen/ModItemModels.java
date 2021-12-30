package com.xuul.flint.datagen;

import com.xuul.flint.Flint;
import com.xuul.flint.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModels extends ItemModelProvider {


    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Flint.MOD_ID, existingFileHelper);
    }



//This function registers the items to a texture. Existing parent is for blocks that have been set up under Block States it references them
    @Override
    protected void registerModels() {
        withExistingParent(ModItems.ORE_TIN_ITEM.get().getRegistryName().getPath(), modLoc("block/ore_tin"));
        withExistingParent(ModItems.ORE_SILVER_ITEM.get().getRegistryName().getPath(), modLoc("block/ore_nether_silver"));
        withExistingParent(ModItems.BLOCK_TIN_ITEM.get().getRegistryName().getPath(), modLoc("block/block_tin"));
        withExistingParent(ModItems.BLOCK_SILVER_ITEM.get().getRegistryName().getPath(), modLoc("block/block_silver"));
        withExistingParent(ModItems.BLOCK_BRONZE_ITEM.get().getRegistryName().getPath(), modLoc("block/block_bronze"));
        withExistingParent(ModItems.BLOCK_STEEL_ITEM.get().getRegistryName().getPath(), modLoc("block/block_steel"));


//        singleTexture(ModItems.RAW_TIN.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/raw_tin"));
//
//                singleTexture(ModItems.RAW_SILVER.get().getRegistryName().getPath(),
//                        mcLoc("item/generated"),
//                        "layer0", modLoc("item/raw_silver"));


        singleTexture(ModItems.INGOT_TIN.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/ingots/ingot_tin"));
        singleTexture(ModItems.INGOT_BRONZE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/ingots/ingot_bronze"));
        singleTexture(ModItems.INGOT_SILVER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/ingots/ingot_silver"));
        singleTexture(ModItems.INGOT_STEEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/ingots/ingot_steel"));


        singleTexture(ModItems.NUGGET_TIN.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/nuggets/nugget_tin"));
        singleTexture(ModItems.NUGGET_COPPER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/nuggets/nugget_copper"));
        singleTexture(ModItems.NUGGET_SILVER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/nuggets/nugget_silver"));
        singleTexture(ModItems.NUGGET_BRONZE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/nuggets/nugget_bronze"));
        singleTexture(ModItems.NUGGET_STEEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/nuggets/nugget_steel"));

        singleTexture(ModItems.DUST_TIN.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/dusts/dust_tin"));
        singleTexture(ModItems.DUST_COPPER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/dusts/dust_copper"));
        singleTexture(ModItems.DUST_SILVER.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/dusts/dust_silver"));
        singleTexture(ModItems.DUST_BRONZE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/dusts/dust_bronze"));
        singleTexture(ModItems.DUST_STEEL.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/dusts/dust_steel"));
        singleTexture(ModItems.DUST_IRON.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/dusts/dust_iron"));
        singleTexture(ModItems.DUST_GOLD.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/dusts/dust_gold"));

        singleTexture(ModItems.CHUNK_STONE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/rocks/chunk_stone"));
//        singleTexture(ModItems.CHUNK_ANDESITE.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/rocks/chunk_andesite"));
//        singleTexture(ModItems.CHUNK_DEEPSLATE.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/rocks/chunk_deepslate"));
//        singleTexture(ModItems.CHUNK_DRIPSTONE.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/rocks/chunk_dripstone"));
        singleTexture(ModItems.CHUNK_DIORITE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/rocks/chunk_diorite"));
        singleTexture(ModItems.CHUNK_GRANITE.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/rocks/chunk_granite"));
        singleTexture(ModItems.CHUNK_BASALT.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/rocks/chunk_basalt"));
//        singleTexture(ModItems.CHUNK_TUFF.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/rocks/chunk_tuff"));
        singleTexture(ModItems.CHUNK_NETHERRACK.get().getRegistryName().getPath(),
                mcLoc("item/generated"),
                "layer0", modLoc("item/rocks/chunk_netherrack"));
//        singleTexture(ModItems.CHUNK_BLACKSTONE.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/rocks/chunk_blackstone"));
//        singleTexture(ModItems.CHUNK_CALCITE.get().getRegistryName().getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("item/rocks/chunk_calcite"));








    }

}
