package xuul.flint.common.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xuul.flint.Flint;
import xuul.flint.common.item.BasketItem;
import xuul.flint.common.item.HammerItem;
import xuul.flint.common.item.SawItem;
import xuul.flint.common.item.SpindleItem;


public class ModItems {
    private ModItems() {
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Flint.MOD_ID);


    public static final Item.Properties STANDARD_METAL_AGE_PROPERTIES = new Item.Properties().tab(Flint.METAL_TAB)
        .stacksTo(64);
    public static final Item.Properties STANDARD_STONE_AGE_PROPERTIES = new Item.Properties().tab(Flint.FLINT_TAB)
        .stacksTo(64);

//    Items

    /*PLANTS*/
    public static final RegistryObject<Item> PLANT_FIBRE = ITEMS.register("plant_fibre",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRAIDED_PLANT_FIBRE = ITEMS.register("braided_plant_fibre",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));

    public static final RegistryObject<BasketItem> BASKET = ITEMS.register("basket",
        () -> new BasketItem(new Item.Properties().tab(Flint.METAL_TAB).stacksTo(1)));


    /*HIDES*/
    public static final RegistryObject<Item> HIDE_SMALL = ITEMS.register("hide_small",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> HIDE_MEDIUM = ITEMS.register("hide_medium",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> HIDE_LARGE = ITEMS.register("hide_large",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    /*TOOLS*/
    //Req Material, Damage, attack speed and repair item

    public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
        () -> new SwordItem(ModToolMaterials.BRONZE, 6, 1.6f, new Item.Properties().tab(Flint.METAL_TAB)));

    public static final RegistryObject<PickaxeItem> BRONZE_PICK = ITEMS.register("bronze_pick",
        () -> new PickaxeItem(ModToolMaterials.BRONZE, 4, 1.2f, new Item.Properties().tab(Flint.METAL_TAB)));

    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
        () -> new ShovelItem(ModToolMaterials.BRONZE, 2.25f, 1.0f, new Item.Properties().tab(Flint.METAL_TAB)));

    public static final RegistryObject<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
        () -> new AxeItem(ModToolMaterials.BRONZE, 9, 0.9f, new Item.Properties().tab(Flint.METAL_TAB)));

    public static final RegistryObject<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
        () -> new HoeItem(ModToolMaterials.BRONZE, 1, 3.0f, new Item.Properties().tab(Flint.METAL_TAB)));


    public static final RegistryObject<SwordItem> FLINT_KNIFE = ITEMS.register("flint_knife",
        () -> new SwordItem(ModToolMaterials.FLINT, 4, 1.6f, new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<PickaxeItem> FLINT_PICK = ITEMS.register("flint_pickaxe",
        () -> new PickaxeItem(ModToolMaterials.FLINT, 2, 1.2f, new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<ShovelItem> FLINT_SHOVEL = ITEMS.register("flint_shovel",
        () -> new ShovelItem(ModToolMaterials.FLINT, 1.25f, 1.0f, new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<AxeItem> FLINT_AXE = ITEMS.register("flint_axe",
        () -> new AxeItem(ModToolMaterials.FLINT, 7, 0.8f, new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<HoeItem> FLINT_HOE = ITEMS.register("flint_hoe",
        () -> new HoeItem(ModToolMaterials.FLINT, 1, 1f, new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<SawItem> FLINT_SAW = ITEMS.register("flint_saw",
        () -> new SawItem(ModToolMaterials.FLINT, 1, 1f, new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<HammerItem> STONE_HAMMER = ITEMS.register("stone_hammer",
        () -> new HammerItem(ModToolMaterials.FLINT, 8, .5f, new Item.Properties().tab(Flint.FLINT_TAB)));

//    public static final RegistryObject<TridentItem> STONE_HSpe = ITEMS.register("stone_hammer",
//            () -> new TridentItem(ModToolMaterials.FLINT, 8, .5f, new Item.Properties().tab(Flint.FLINT_TAB)));


    public static final RegistryObject<SpindleItem> SPINDLE = ITEMS.register("spindle",
        () -> new SpindleItem(ModToolMaterials.FLINT, new Item.Properties().tab(Flint.FLINT_TAB)));


    /*TOOLHEADS*/
    public static final RegistryObject<Item> FLINT_BLADE = ITEMS.register("flint_blade",
        () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> FLINT_PICK_HEAD = ITEMS.register("flint_pick_head",
        () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> FLINT_SHOVEL_HEAD = ITEMS.register("flint_shovel_head",
        () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> FLINT_AXE_HEAD = ITEMS.register("flint_axe_head",
        () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> FLINT_HOE_HEAD = ITEMS.register("flint_hoe_head",
        () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));

    public static final RegistryObject<Item> FLINT_SAW_HEAD = ITEMS.register("flint_saw_head",
        () -> new Item(new Item.Properties().tab(Flint.FLINT_TAB)));




    /*Armor*/

    public static final RegistryObject<ArmorItem> BRONZE_HELMET = ITEMS.register("bronze_helmet",
        () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlot.HEAD, new Item.Properties().tab(Flint.METAL_TAB)));

    public static final RegistryObject<ArmorItem> BRONZE_CHEST = ITEMS.register("bronze_chest",
        () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlot.CHEST, new Item.Properties().tab(Flint.METAL_TAB)));

    public static final RegistryObject<ArmorItem> BRONZE_LEGS = ITEMS.register("bronze_legs",
        () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlot.LEGS, new Item.Properties().tab(Flint.METAL_TAB)));

    public static final RegistryObject<ArmorItem> BRONZE_BOOTS = ITEMS.register("bronze_boots",
        () -> new ArmorItem(ModArmorMaterial.BRONZE, EquipmentSlot.FEET, new Item.Properties().tab(Flint.METAL_TAB)));


    /*ORE CHUNKS*/
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));


    /*Ingots*/
    public static final RegistryObject<Item> INGOT_TIN = ITEMS.register("ingot_tin",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));

    public static final RegistryObject<Item> INGOT_BRONZE = ITEMS.register("ingot_bronze",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));

    public static final RegistryObject<Item> INGOT_STEEL = ITEMS.register("ingot_steel",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));

    public static final RegistryObject<Item> INGOT_SILVER = ITEMS.register("ingot_silver",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));


    /*Nuggets*/
    public static final RegistryObject<Item> NUGGET_COPPER = ITEMS.register("nugget_copper",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> NUGGET_TIN = ITEMS.register("nugget_tin",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> NUGGET_BRONZE = ITEMS.register("nugget_bronze",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> NUGGET_STEEL = ITEMS.register("nugget_steel",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> NUGGET_SILVER = ITEMS.register("nugget_silver",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));


    /*Dusts*/
    public static final RegistryObject<Item> DUST_IRON = ITEMS.register("dust_iron",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_GOLD = ITEMS.register("dust_gold",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_COPPER = ITEMS.register("dust_copper",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_TIN = ITEMS.register("dust_tin",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_BRONZE = ITEMS.register("dust_bronze",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_STEEL = ITEMS.register("dust_steel",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_SILVER = ITEMS.register("dust_silver",
        () -> new Item(STANDARD_METAL_AGE_PROPERTIES));

    /*STONE CHUNKS*/


    public static final RegistryObject<Item> CHUNK_STONE = ITEMS.register("chunk_stone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_ANDESITE = ITEMS.register("chunk_andesite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_DEEPSLATE = ITEMS.register("chunk_deepslate",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_SANDSTONE = ITEMS.register("chunk_sandstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_DRIPSTONE = ITEMS.register("chunk_dripstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_DIORITE = ITEMS.register("chunk_diorite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_GRANITE = ITEMS.register("chunk_granite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_BASALT = ITEMS.register("chunk_basalt",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_TUFF = ITEMS.register("chunk_tuff",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_NETHERRACK = ITEMS.register("chunk_netherrack",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_BLACKSTONE = ITEMS.register("chunk_blackstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CHUNK_CALCITE = ITEMS.register("chunk_calcite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));


    /*STONE DUSTS*/


    public static final RegistryObject<Item> DUST_STONE = ITEMS.register("dust_stone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_ANDESITE = ITEMS.register("dust_andesite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_DEEPSLATE = ITEMS.register("dust_deepslate",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_DRIPSTONE = ITEMS.register("dust_dripstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_SANDSTONE = ITEMS.register("dust_sandstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_DIORITE = ITEMS.register("dust_diorite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_GRANITE = ITEMS.register("dust_granite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_BASALT = ITEMS.register("dust_basalt",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_TUFF = ITEMS.register("dust_tuff",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_NETHERRACK = ITEMS.register("dust_netherrack",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_BLACKSTONE = ITEMS.register("dust_blackstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_ENDSTONE = ITEMS.register("dust_endstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> DUST_CALCITE = ITEMS.register("dust_calcite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));

    /*Stone Clay*/
    public static final RegistryObject<Item> CLAY_STONE = ITEMS.register("clay_stone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_ANDESITE = ITEMS.register("clay_andesite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_DEEPSLATE = ITEMS.register("clay_deepslate",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_DRIPSTONE = ITEMS.register("clay_dripstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_SANDSTONE = ITEMS.register("clay_sandstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_DIORITE = ITEMS.register("clay_diorite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_GRANITE = ITEMS.register("clay_granite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_BASALT = ITEMS.register("clay_basalt",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_TUFF = ITEMS.register("clay_tuff",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_NETHERRACK = ITEMS.register("clay_netherrack",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_BLACKSTONE = ITEMS.register("clay_blackstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_ENDSTONE = ITEMS.register("clay_endstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> CLAY_CALCITE = ITEMS.register("clay_calcite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));

    /*STONE BRICKS*/
    public static final RegistryObject<Item> BRICK_STONE = ITEMS.register("brick_stone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_ANDESITE = ITEMS.register("brick_andesite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_DEEPSLATE = ITEMS.register("brick_deepslate",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_DRIPSTONE = ITEMS.register("brick_dripstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_SANDSTONE = ITEMS.register("brick_sandstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_DIORITE = ITEMS.register("brick_diorite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_GRANITE = ITEMS.register("brick_granite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_BASALT = ITEMS.register("brick_basalt",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_TUFF = ITEMS.register("brick_tuff",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_NETHERRACK = ITEMS.register("brick_netherrack",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_BLACKSTONE = ITEMS.register("brick_blackstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_ENDSTONE = ITEMS.register("brick_endstone",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> BRICK_CALCITE = ITEMS.register("brick_calcite",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));

    /*Logs*/
    public static final RegistryObject<Item> LOG_OAK = ITEMS.register("log_oak",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_SPRUCE = ITEMS.register("log_spruce",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_BIRCH = ITEMS.register("log_birch",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_JUNGLE = ITEMS.register("log_jungle",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_ACACIA = ITEMS.register("log_acacia",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_DARK_OAK = ITEMS.register("log_dark_oak",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_AZALEA = ITEMS.register("log_azalea",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_WARPED = ITEMS.register("log_warped",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> LOG_CRIMSON = ITEMS.register("log_crimson",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));

    /*Logs*/
    public static final RegistryObject<Item> PLANK_OAK = ITEMS.register("plank_oak",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_SPRUCE = ITEMS.register("plank_spruce",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_BIRCH = ITEMS.register("plank_birch",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_JUNGLE = ITEMS.register("plank_jungle",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_ACACIA = ITEMS.register("plank_acacia",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_DARK_OAK = ITEMS.register("plank_dark_oak",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_AZALEA = ITEMS.register("plank_azalea",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_WARPED = ITEMS.register("plank_warped",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));
    public static final RegistryObject<Item> PLANK_CRIMSON = ITEMS.register("plank_crimson",
        () -> new Item(STANDARD_STONE_AGE_PROPERTIES));






    /*BLOCKITEMS*/
    public static <B extends Block> RegistryObject<Item> itemFromBlock(RegistryObject<B> block, Item.Properties item) {
        return ITEMS.register(block.getId().getPath(),
            () -> new BlockItem(block.get(), item));
    }

    public static final RegistryObject<Item> ORE_TIN_ITEM = itemFromBlock(ModBlocks.ORE_TIN,
        STANDARD_METAL_AGE_PROPERTIES);
    public static final RegistryObject<Item> ORE_SILVER_ITEM = itemFromBlock(ModBlocks.ORE_SILVER,
        STANDARD_METAL_AGE_PROPERTIES);

    public static final RegistryObject<Item> BLOCK_TIN_ITEM = itemFromBlock(ModBlocks.BLOCK_TIN,
        STANDARD_METAL_AGE_PROPERTIES);
    public static final RegistryObject<Item> BLOCK_SILVER_ITEM = itemFromBlock(ModBlocks.BLOCK_SILVER,
        STANDARD_METAL_AGE_PROPERTIES);
    public static final RegistryObject<Item> BLOCK_BRONZE_ITEM = itemFromBlock(ModBlocks.BLOCK_BRONZE,
        STANDARD_METAL_AGE_PROPERTIES);
    public static final RegistryObject<Item> BLOCK_STEEL_ITEM = itemFromBlock(ModBlocks.BLOCK_STEEL,
        STANDARD_METAL_AGE_PROPERTIES);


    public static final RegistryObject<Item> COBBLESTONE_ITEM = itemFromBlock(ModBlocks.COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> BASALT_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.BASALT_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> DEEPSLATE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.DEEPSLATE_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> NETHERRACK_COBBLESTONE_ITEM = itemFromBlock(
        ModBlocks.NETHERRACK_COBBLESTONE, STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> SANDSTONE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.SANDSTONE_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> BLACKSTONE_COBBLESTONE_ITEM = itemFromBlock(
        ModBlocks.BLACKSTONE_COBBLESTONE, STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> ENDSTONE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.ENDSTONE_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> GRANITE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.GRANITE_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> TUFF_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.TUFF_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> ANDESITE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.ANDESITE_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> DIORITE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.DIORITE_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> CALCITE_COBBLESTONE_ITEM = itemFromBlock(ModBlocks.CALCITE_COBBLESTONE,
        STANDARD_STONE_AGE_PROPERTIES);

    public static final RegistryObject<Item> FLINT_STATION_ITEM = itemFromBlock(ModBlocks.FLINT_STATION,
        STANDARD_STONE_AGE_PROPERTIES);
    public static final RegistryObject<Item> THATCH_BLOCK_ITEM = itemFromBlock(ModBlocks.THATCH,
        STANDARD_STONE_AGE_PROPERTIES);

    public static final RegistryObject<Item> FOUNDRY_BLOCK_ITEM = itemFromBlock(ModBlocks.FOUNDRY,
        STANDARD_STONE_AGE_PROPERTIES);

    public static final RegistryObject<Item> FLINT_NODE_ITEM = itemFromBlock(ModBlocks.FLINT_NODE,
            STANDARD_STONE_AGE_PROPERTIES);


}

