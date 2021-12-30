package com.xuul.flint.init;

import com.xuul.flint.Flint;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
    public static final RegistryObject<Item> DUST_GOLD = ITEMS.register("dust_gold",
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
    public static <B extends Block> RegistryObject<Item> itemFromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(),
                () -> new BlockItem(block.get(), new Item.Properties().tab(Flint.FLINT_TAB)));
    }

    public static final  RegistryObject<Item> ORE_TIN_ITEM = itemFromBlock(ModBlocks.ORE_TIN);
    public static final  RegistryObject<Item> ORE_SILVER_ITEM = itemFromBlock(ModBlocks.ORE_SILVER);

    public static final  RegistryObject<Item> BLOCK_TIN_ITEM = itemFromBlock(ModBlocks.BLOCK_TIN);
    public static final  RegistryObject<Item> BLOCK_SILVER_ITEM = itemFromBlock(ModBlocks.BLOCK_SILVER);
    public static final  RegistryObject<Item> BLOCK_BRONZE_ITEM = itemFromBlock(ModBlocks.BLOCK_BRONZE);
    public static final  RegistryObject<Item> BLOCK_STEEL_ITEM = itemFromBlock(ModBlocks.BLOCK_STEEL);


    public static final  RegistryObject<Item> COBBLESTONE_ITEM = itemFromBlock(ModBlocks.COBBLESTONE);
    public static final  RegistryObject<Item> BASTALT_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.BASALT_COBBLESTONE);
    public static final  RegistryObject<Item> DEEPSLATE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.DEEPSLATE_COBBLESTONE);
    public static final  RegistryObject<Item> NETHERRACK_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.NETHERRACK_COBBLESTONE);
    public static final  RegistryObject<Item> SANDSTONE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.SANDSTONE_COBBLESTONE);
    public static final  RegistryObject<Item> BLACKSTONE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.BLACKSTONE_COBBLESTONE);
    public static final  RegistryObject<Item> ENDSTONE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.ENDSTONE_COBBLESTONE);
    public static final  RegistryObject<Item> GRANITE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.GRANITE_COBBLESTONE);
    public static final  RegistryObject<Item> TUFF_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.TUFF_COBBLESTONE);
    public static final  RegistryObject<Item> ANDESITE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.ANDESITE_COBBLESTONE);
    public static final  RegistryObject<Item> DIORITE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.DIORITE_COBBLESTONE);
    public static final  RegistryObject<Item> CALCITE_COBBLESTONE_ITEM= itemFromBlock(ModBlocks.CALCITE_COBBLESTONE);






}

