package com.xuul.flint.init;

import com.xuul.flint.Flint;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    private ModItems() {
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Flint.MOD_ID);

//    Items

    /*PLANTS*/
    public static final RegistryObject<Item> PLANT_FIBRE = ITEMS.register("plant_fibre",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> BRAIDED_PLANT_FIBRE = ITEMS.register("braided_plant_fibre",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));


    /*ORE CHUNKS*/
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));


    /*Ingots*/
    public static final RegistryObject<Item> INGOT_TIN = ITEMS.register("ingot_tin",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> INGOT_BRONZE = ITEMS.register("ingot_bronze",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> INGOT_STEEL = ITEMS.register("ingot_steel",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> INGOT_SILVER = ITEMS.register("ingot_silver",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));


    /*Nuggets*/
    public static final RegistryObject<Item> NUGGET_COPPER = ITEMS.register("nugget_copper",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> NUGGET_TIN = ITEMS.register("nugget_tin",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> NUGGET_BRONZE = ITEMS.register("nugget_bronze",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> NUGGET_STEEL = ITEMS.register("nugget_steel",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> NUGGET_SILVER = ITEMS.register("nugget_silver",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));


    /*Dusts*/
    public static final RegistryObject<Item> DUST_IRON = ITEMS.register("dust_iron",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_COPPER = ITEMS.register("dust_copper",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_TIN = ITEMS.register("dust_tin",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_BRONZE = ITEMS.register("dust_bronze",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_STEEL = ITEMS.register("dust_steel",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_SILVER = ITEMS.register("dust_silver",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    /*STONE CHUNKS*/
    public static final RegistryObject<Item> CHUNK_STONE = ITEMS.register("chunk_stone",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_ANDESITE = ITEMS.register("chunk_andesite",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_DEEPSLATE = ITEMS.register("chunk_deepslate",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_DRIPSTONE = ITEMS.register("chunk_dripstone",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_DIORITE = ITEMS.register("chunk_diorite",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_GRANITE = ITEMS.register("chunk_granite",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_BASALT = ITEMS.register("chunk_basalt",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_TUFF = ITEMS.register("chunk_tuff",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_NETHERRACK = ITEMS.register("chunk_netherrack",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_BLACKSTONE = ITEMS.register("chunk_blackstone",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> CHUNK_CALCITE = ITEMS.register("chunk_calcite",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));


    /*STONE DUSTS*/
    public static final RegistryObject<Item> DUST_STONE = ITEMS.register("dust_stone",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_ANDESITE = ITEMS.register("dust_andesite",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_DEEPSLATE = ITEMS.register("dust_deepslate",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_DRIPSTONE = ITEMS.register("dust_dripstone",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_DIORITE = ITEMS.register("dust_diorite",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_GRANITE = ITEMS.register("dust_granite",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_BASALT = ITEMS.register("dust_basalt",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_TUFF = ITEMS.register("dust_tuff",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_NETHERRACK = ITEMS.register("dust_netherrack",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> DUST_BLACKSTONE = ITEMS.register("dust_blackstone",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    /*STONE DUSTS*/

    /*Logs*/
    public static final RegistryObject<Item> LOG_OAK = ITEMS.register("log_oak",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_SPRUCE = ITEMS.register("log_spruce",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_BIRCH = ITEMS.register("log_birch",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_JUNGLE = ITEMS.register("log_jungle",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_ACACIA = ITEMS.register("log_acacia",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_DARK_OAK = ITEMS.register("log_dark_oak",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_AZALEA = ITEMS.register("log_azalea",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_WARPED = ITEMS.register("log_warped",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));
    public static final RegistryObject<Item> LOG_CRIMSON = ITEMS.register("log_crimson",
            () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));



    /*BLOCKITEMS*/
    public static final  RegistryObject<BlockItem> ORE_TIN_ITEM = ITEMS.register("ore_tin",
            () -> new BlockItem(ModBlocks.ORE_TIN.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> ORE_SILVER_ITEM = ITEMS.register("ore_nether_silver",
            () -> new BlockItem(ModBlocks.ORE_SILVER.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> BLOCK_TIN_ITEM = ITEMS.register("block_tin",
            () -> new BlockItem(ModBlocks.BLOCK_TIN.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> BLOCK_SILVER_ITEM = ITEMS.register("block_silver",
            () -> new BlockItem(ModBlocks.BLOCK_SILVER.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> BLOCK_BRONZE_ITEM = ITEMS.register("block_bronze",
            () -> new BlockItem(ModBlocks.BLOCK_BRONZE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> BLOCK_STEEL_ITEM = ITEMS.register("block_steel",
            () -> new BlockItem(ModBlocks.BLOCK_STEEL.get(), new Item.Properties().tab(Flint.FLINT_TAB)));



    public static final  RegistryObject<BlockItem> COBBLESTONE_ITEM = ITEMS.register("cobblestone",
            () -> new BlockItem(ModBlocks.COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> BASTALT_COBBLESTONE_ITEM = ITEMS.register("basalt_cobblestone",
            () -> new BlockItem(ModBlocks.BASALT_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> DEEPSLATE_COBBLESTONE_ITEM = ITEMS.register("deepslate_cobblestone",
            () -> new BlockItem(ModBlocks.DEEPSLATE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> NETHERRACK_COBBLESTONE_ITEM = ITEMS.register("netherrack_cobblestone",
            () -> new BlockItem(ModBlocks.NETHERRACK_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> SANDSTONE_COBBLESTONE_ITEM = ITEMS.register("sandstone_cobblestone",
            () -> new BlockItem(ModBlocks.SANDSTONE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> BLACKSTONE_COBBLESTONE_ITEM = ITEMS.register("blackstone_cobblestone",
            () -> new BlockItem(ModBlocks.BLACKSTONE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> ENDSTONE_COBBLESTONE_ITEM = ITEMS.register("endstone_cobblestone",
            () -> new BlockItem(ModBlocks.ENDSTONE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> GRANITE_COBBLESTONE_ITEM = ITEMS.register("granite_cobblestone",
            () -> new BlockItem(ModBlocks.GRANITE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> TUFF_COBBLESTONE_ITEM = ITEMS.register("tuff_cobblestone",
            () -> new BlockItem(ModBlocks.TUFF_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> ANDESITE_COBBLESTONE_ITEM = ITEMS.register("andesite_cobblestone",
            () -> new BlockItem(ModBlocks.ANDESITE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> DIORITE_COBBLESTONE_ITEM = ITEMS.register("diorite_cobblestone",
            () -> new BlockItem(ModBlocks.DIORITE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final  RegistryObject<BlockItem> CALCITE_COBBLESTONE_ITEM = ITEMS.register("calcite_cobblestone",
            () -> new BlockItem(ModBlocks.CALCITE_COBBLESTONE.get(), new Item.Properties().tab(Flint.FLINT_TAB)));







}

