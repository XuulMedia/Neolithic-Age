package com.xuul.flint.datagen;

import com.xuul.flint.Flint;
import com.xuul.flint.init.ModBlocks;
import com.xuul.flint.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, Flint.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + Flint.FLINT_TAB, "Stone Age");
        add("itemGroup." + Flint.IRON_AGE_TAB, "Metal Age");



        add(ModBlocks.ORE_TIN.get(), "Tin Ore");
        add(ModBlocks.ORE_SILVER.get(), "Nether Silver Ore");

        add(ModBlocks.COBBLESTONE.get(), "Cobblestone");
        add(ModBlocks.BASALT_COBBLESTONE.get(), "Basalt Cobblestone");
        add(ModBlocks.DEEPSLATE_COBBLESTONE.get(), "Deepslate Cobblestone");
        add(ModBlocks.NETHERRACK_COBBLESTONE.get(), "Netherrack Cobblestone");
        add(ModBlocks.SANDSTONE_COBBLESTONE.get(), "Sandstone Cobblestone");
        add(ModBlocks.BLACKSTONE_COBBLESTONE.get(), "Blackstone Cobblestone");
        add(ModBlocks.ENDSTONE_COBBLESTONE.get(), "Endstone Cobblestone");
        add(ModBlocks.GRANITE_COBBLESTONE.get(), "Granite Cobblestone");
        add(ModBlocks.TUFF_COBBLESTONE.get(), "Tuff Cobblestone");
        add(ModBlocks.ANDESITE_COBBLESTONE.get(), "Andesite Cobblestone");
        add(ModBlocks.DIORITE_COBBLESTONE.get(), "Diorite Cobblestone");
        add(ModBlocks.CALCITE_COBBLESTONE.get(), "Calcite Cobblestone");

        add(ModItems.DUST_STONE.get(), "Stone Dust");
        add(ModItems.DUST_BASALT.get(), "Basalt Dust");
        add(ModItems.DUST_DEEPSLATE.get(), "Deepslate Dust");
        add(ModItems.DUST_NETHERRACK.get(), "Netherrack Dust");
        add(ModItems.DUST_DRIPSTONE.get(), "Dripstone Dust");
        add(ModItems.DUST_SANDSTONE.get(), "Sandstone Dust");
        add(ModItems.DUST_BLACKSTONE.get(), "Blackstone Dust");
        add(ModItems.DUST_ENDSTONE.get(), "Endstone Dust");
        add(ModItems.DUST_GRANITE.get(), "Granite Dust");
        add(ModItems.DUST_TUFF.get(), "Tuff Dust");
        add(ModItems.DUST_ANDESITE.get(), "Andesite Dust");
        add(ModItems.DUST_DIORITE.get(), "Diorite Dust");
        add(ModItems.DUST_CALCITE.get(), "Calcite Dust");

        add(ModItems.BRONZE_SWORD.get(), "Bronze Sword");
        add(ModItems.BRONZE_PICK.get(), "Bronze Pick");
        add(ModItems.BRONZE_SHOVEL.get(), "Bronze Shovel");
        add(ModItems.BRONZE_AXE.get(), "Bronze Axe");
        add(ModItems.BRONZE_HOE.get(), "Bronze Hoe");
        add(ModItems.BRONZE_HELMET.get(), "Bronze Helmet");
        add(ModItems.BRONZE_CHEST.get(), "Bronze Chest");
        add(ModItems.BRONZE_LEGS.get(), "Bronze Legs");
        add(ModItems.BRONZE_BOOTS.get(), "Bronze Boots");


        add(ModBlocks.BLOCK_TIN.get(), "Tin Block");
        add(ModBlocks.BLOCK_SILVER.get(), "Silver Block");
        add(ModBlocks.BLOCK_BRONZE.get(), "Bronze Block");
        add(ModBlocks.BLOCK_STEEL.get(), "Steel Block");

        add(ModItems.PLANT_FIBRE.get(), "Plant Fibre");
        add(ModItems.BRAIDED_PLANT_FIBRE.get(), "Braided Plant Fibre");

        add(ModItems.LOG_ACACIA.get(), "Acacia Log");
        add(ModItems.LOG_AZALEA.get(), "Azalea Log");
        add(ModItems.LOG_BIRCH.get(), "Birch Log");
        add(ModItems.LOG_DARK_OAK.get(), "Dark Oak Log");
        add(ModItems.LOG_JUNGLE.get(), "Jungle Log");
        add(ModItems.LOG_OAK.get(), "Oak Log");
        add(ModItems.LOG_SPRUCE.get(), "Spruce Log");


        add(ModItems.INGOT_TIN.get(),"Tin Ingot");
        add(ModItems.INGOT_BRONZE.get(),"Bronze Ingot");
        add(ModItems.INGOT_SILVER.get(),"Silver Ingot");
        add(ModItems.INGOT_STEEL.get(),"Steel Ingot Log");

        add(ModItems.NUGGET_COPPER.get(), "Copper Nugget");
        add(ModItems.NUGGET_TIN.get(),"Tin Nugget");
        add(ModItems.NUGGET_BRONZE.get(), "Bronze Nugget");
        add(ModItems.NUGGET_SILVER.get(),"Silver Nugget");
        add(ModItems.NUGGET_STEEL.get(),"Steel Nugget");

        add(ModItems.DUST_IRON.get(),"Iron Dust");
        add(ModItems.DUST_GOLD.get(),"Gold Dust");
        add(ModItems.DUST_COPPER.get(),"Copper Dust");
        add(ModItems.DUST_TIN.get(),"Tin Dust");
        add(ModItems.DUST_BRONZE.get(), "Bronze Dust");
        add(ModItems.DUST_SILVER.get(),"Silver Dust");
        add(ModItems.DUST_STEEL.get(),"Steel Dust");

        add(ModItems.CHUNK_STONE.get(),"Stone Chunk");
        add(ModItems.CHUNK_ANDESITE.get(),"Andesite Chunk");
        add(ModItems.CHUNK_DEEPSLATE.get(),"Deepslate Chunk");
        add(ModItems.CHUNK_DRIPSTONE.get(),"Dripstone Chunk");
        add(ModItems.CHUNK_DIORITE.get(),"Diorite Chunk");
        add(ModItems.CHUNK_GRANITE.get(),"Granite Chunk");
        add(ModItems.CHUNK_BASALT.get(),"Basalt Chunk");
        add(ModItems.CHUNK_TUFF.get(),"Tuff Chunk");
        add(ModItems.CHUNK_NETHERRACK.get(),"Netherrack Chunk");
        add(ModItems.CHUNK_BLACKSTONE.get(),"Blackstone Chunk");
        add(ModItems.CHUNK_CALCITE.get(),"Calcite Chunk");

        add(ModItems.BRICK_STONE.get(),"Stone Brick");
        add(ModItems.BRICK_ANDESITE.get(),"Andesite Brick");
        add(ModItems.BRICK_DEEPSLATE.get(),"Deepslate Brick");
        add(ModItems.BRICK_DRIPSTONE.get(),"Dripstone Brick");
        add(ModItems.BRICK_DIORITE.get(),"Diorite Brick");
        add(ModItems.BRICK_GRANITE.get(),"Granite Brick");
        add(ModItems.BRICK_BASALT.get(),"Basalt Brick");
        add(ModItems.BRICK_TUFF.get(),"Tuff Brick");
        add(ModItems.BRICK_NETHERRACK.get(),"Netherrack Brick");
        add(ModItems.BRICK_BLACKSTONE.get(),"Blackstone Brick");
        add(ModItems.BRICK_CALCITE.get(),"Calcite Brick");
















    }
}
