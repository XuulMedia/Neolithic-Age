package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.item.ModFoodProperties;
import github.xuulmedia.neolith.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static github.xuulmedia.neolith.init.ModCreativeTabs.addToMetalAgeTab;
import static github.xuulmedia.neolith.init.ModCreativeTabs.addToStoneAgeTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Neolith.MODID);
    public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");
    public static final int LOW_HEAT_WOOD = 250;
    public static final int MED_HEAT_WOOD = 350;
    public static final int HIGH_HEAT_WOOD = 500;
    public static final int NETHER_HEAT_WOOD = 650;


    /*Stone age tools*/
    public static final RegistryObject<SwordItem> FLINT_KNIFE = registerStoneAgeItem("flint_knife",
            () -> createKnife(ModToolMaterials.FLINT));
    public static final RegistryObject<PickaxeItem> FLINT_PICK = registerStoneAgeItem("flint_pickaxe",
            () -> createPick(ModToolMaterials.FLINT));
    public static final RegistryObject<ShovelItem> FLINT_SHOVEL = registerStoneAgeItem("flint_shovel",
            () -> createShovel(ModToolMaterials.FLINT));
    public static final RegistryObject<AxeItem> FLINT_AXE = registerStoneAgeItem("flint_axe",
            () -> createAxe(ModToolMaterials.FLINT));
    public static final RegistryObject<HoeItem> FLINT_HOE = registerStoneAgeItem("flint_hoe",
            () -> createHoe(ModToolMaterials.FLINT));
    public static final RegistryObject<SawItem> FLINT_SAW = registerStoneAgeItem("flint_saw",
            () -> createSaw(ModToolMaterials.FLINT));
    public static final RegistryObject<HammerItem> STONE_HAMMER = registerStoneAgeItem("stone_hammer",
            () -> createHammer(ModToolMaterials.FLINT));


    public static final RegistryObject<SwordItem> BRONZE_KNIFE = registerMetalAgeItem("bronze_knife",
            () -> createKnife(ModToolMaterials.BRONZE));
    public static final RegistryObject<PickaxeItem> BRONZE_PICK = registerMetalAgeItem("bronze_pick",
            () -> createPick(ModToolMaterials.BRONZE));
    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = registerMetalAgeItem("bronze_shovel",
            () -> createShovel(ModToolMaterials.BRONZE));
    public static final RegistryObject<AxeItem> BRONZE_AXE = registerMetalAgeItem("bronze_axe",
            () -> createAxe(ModToolMaterials.BRONZE));
    public static final RegistryObject<HoeItem> BRONZE_HOE = registerMetalAgeItem("bronze_hoe",
            () -> createHoe(ModToolMaterials.BRONZE));
    public static final RegistryObject<SawItem> BRONZE_SAW = registerMetalAgeItem("bronze_saw",
            () -> createSaw(ModToolMaterials.BRONZE));
    public static final RegistryObject<HammerItem> BRONZE_HAMMER = registerMetalAgeItem("bronze_hammer",
            () -> createHammer(ModToolMaterials.BRONZE));
    public static final RegistryObject<SwordItem> BRONZE_SWORD = registerMetalAgeItem("bronze_sword",
            () -> createSword(ModToolMaterials.BRONZE));


    //Other Tools
    public static final RegistryObject<TridentItem> STONE_SPEAR = registerStoneAgeItem("stone_spear",
            () -> new TridentItem(new Item.Properties().durability(50)));
    public static final RegistryObject<FireStarterItem> BASIC_FIRESTARTER = registerStoneAgeItem("firestarter",
            () -> new FireStarterItem(new Item.Properties().durability(10)));
    public static final RegistryObject<SpindleItem> SPINDLE = registerStoneAgeItem("spindle",
            () -> new SpindleItem(ModToolMaterials.FLINT, new Item.Properties().durability(100)));


    /*Containers*/
    public static final RegistryObject<BasketItem> BASKET = registerStoneAgeItem("basket",
            () -> new BasketItem(new Item.Properties().stacksTo(1)));

    /*HIDES*/
    public static final RegistryObject<Item> HIDE_SMALL = registerStandardStoneAgeItem("hide_small");
    public static final RegistryObject<Item> HIDE_MEDIUM = registerStandardStoneAgeItem("hide_medium");
    public static final RegistryObject<Item> HIDE_LARGE = registerStandardStoneAgeItem("hide_large");

    public static final RegistryObject<Item> LEATHER_SMALL = registerStandardStoneAgeItem("leather_small");
    public static final RegistryObject<Item> LEATHER_MEDIUM = registerStandardStoneAgeItem("leather_medium");
    public static final RegistryObject<Item> LEATHER_LARGE = registerStandardStoneAgeItem("leather_large");

    public static final RegistryObject<Item> ANIMAL_FAT = registerStandardStoneAgeItem("animal_fat");
    public static final RegistryObject<Item> BONE_SHARD = registerStandardStoneAgeItem("bone_shard");




    /*TODO cured hide*/

    /*Clay Objects*/
    public static final RegistryObject<Item> UNFIRED_CLAY_POT = registerStandardStoneAgeItem("unfired_clay_pot");
    public static final RegistryObject<Item> UNFIRED_CLAY_BUCKET = registerStandardStoneAgeItem("unfired_clay_bucket");
    public static final RegistryObject<Item> UNFIRED_CLAY_BOTTLE = registerStandardStoneAgeItem("unfired_clay_bottle");
    public static final RegistryObject<Item> UNFIRED_CLAY_BOWL = registerStandardStoneAgeItem("unfired_clay_bowl");


    public static final RegistryObject<Item> CLAY_BUCKET = registerStandardStoneAgeItem("clay_bucket");
    public static final RegistryObject<Item> CLAY_BOWL = registerStandardStoneAgeItem("clay_bowl");
    public static final RegistryObject<BottleItem> CLAY_BOTTLE = registerStoneAgeItem("clay_bottle",
            () -> new BottleItem(new Item.Properties()));


    /*TOOLHEADS*/
    public static final RegistryObject<Item> FLINT_BLADE = registerStandardStoneAgeItem("flint_blade");
    public static final RegistryObject<Item> FLINT_PICK_HEAD = registerStandardStoneAgeItem("flint_pick_head");
    public static final RegistryObject<Item> FLINT_SHOVEL_HEAD = registerStandardStoneAgeItem("flint_shovel_head");
    public static final RegistryObject<Item> FLINT_AXE_HEAD = registerStandardStoneAgeItem("flint_axe_head");
    public static final RegistryObject<Item> FLINT_HOE_HEAD = registerStandardStoneAgeItem("flint_hoe_head");
    public static final RegistryObject<Item> FLINT_SAW_HEAD = registerStandardStoneAgeItem("flint_saw_head");

    public static final RegistryObject<Item> BRONZE_HAMMER_HEAD = registerStandardStoneAgeItem("bronze_hammer_head");

    /*Logs*/
    public static final RegistryObject<FuelItem> LOG_ACACIA = createFuelItem("log_acacia", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_BIRCH = createFuelItem("log_birch", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_CHERRY = createFuelItem("log_cherry", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_DARK_OAK = createFuelItem("log_dark_oak", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_JUNGLE = createFuelItem("log_jungle", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_MANGROVE = createFuelItem("log_mangrove", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_OAK = createFuelItem("log_oak", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_SPRUCE = createFuelItem("log_spruce", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_WARPED = createFuelItem("log_warped", NETHER_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_CRIMSON = createFuelItem("log_crimson", NETHER_HEAT_WOOD, new Item.Properties());

    /*Planks*/
    public static final RegistryObject<FuelItem> PLANK_ACACIA = createFuelItem("plank_acacia", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_BIRCH = createFuelItem("plank_birch", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_CHERRY = createFuelItem("plank_cherry", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_DARK_OAK = createFuelItem("plank_dark_oak", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_JUNGLE = createFuelItem("plank_jungle", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_MANGROVE = createFuelItem("plank_mangrove", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_OAK = createFuelItem("plank_oak", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_SPRUCE = createFuelItem("plank_spruce", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_WARPED = createFuelItem("plank_warped", NETHER_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_CRIMSON = createFuelItem("plank_crimson", NETHER_HEAT_WOOD, new Item.Properties());

    /*PLANTS*/
    public static final RegistryObject<FuelItem> PLANT_FIBRE = createFuelItem("plant_fibre", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<Item> BRAIDED_PLANT_FIBRE = registerStandardStoneAgeItem("braided_plant_fibre");

    /*STONE CHUNKS*/
    public static final RegistryObject<Item> CHUNK_ANDESITE = registerStandardStoneAgeItem("chunk_andesite");
    public static final RegistryObject<Item> CHUNK_BASALT = registerStandardStoneAgeItem("chunk_basalt");
    public static final RegistryObject<Item> CHUNK_BLACKSTONE = registerStandardStoneAgeItem("chunk_blackstone");
    public static final RegistryObject<Item> CHUNK_CALCITE = registerStandardStoneAgeItem("chunk_calcite");
    public static final RegistryObject<Item> CHUNK_DEEPSLATE = registerStandardStoneAgeItem("chunk_deepslate");
    public static final RegistryObject<Item> CHUNK_DIORITE = registerStandardStoneAgeItem("chunk_diorite");
    public static final RegistryObject<Item> CHUNK_DRIPSTONE = registerStandardStoneAgeItem("chunk_dripstone");
    public static final RegistryObject<Item> CHUNK_GRANITE = registerStandardStoneAgeItem("chunk_granite");
    public static final RegistryObject<Item> CHUNK_NETHERRACK = registerStandardStoneAgeItem("chunk_netherrack");
    public static final RegistryObject<Item> CHUNK_RED_SANDSTONE = registerStandardStoneAgeItem("chunk_red_sandstone");
    public static final RegistryObject<Item> CHUNK_SANDSTONE = registerStandardStoneAgeItem("chunk_sandstone");
    public static final RegistryObject<Item> CHUNK_STONE = registerStandardStoneAgeItem("chunk_stone");
    public static final RegistryObject<Item> CHUNK_TUFF = registerStandardStoneAgeItem("chunk_tuff");
    public static final RegistryObject<Item> CHUNK_ENDSTONE = registerStandardStoneAgeItem("chunk_endstone");

    /*STONE DUSTS*/
    public static final RegistryObject<Item> DUST_STONE = registerStandardStoneAgeItem("dust_stone");
    public static final RegistryObject<Item> DUST_DEEPSLATE = registerStandardStoneAgeItem("dust_deepslate");
    public static final RegistryObject<Item> DUST_NETHERRACK = registerStandardStoneAgeItem("dust_netherrack");
    public static final RegistryObject<Item> DUST_ENDSTONE = registerStandardStoneAgeItem("dust_endstone");

    public static final RegistryObject<Item> DUST_BROWN = registerStandardStoneAgeItem("dust_brown");
    public static final RegistryObject<Item> DUST_WHITE = registerStandardStoneAgeItem("dust_white");
    public static final RegistryObject<Item> DUST_BLACK = registerStandardStoneAgeItem("dust_black");

    public static final RegistryObject<Item> DUST_SAND = registerStandardStoneAgeItem("dust_sand");
    public static final RegistryObject<Item> DUST_TUFF = registerStandardStoneAgeItem("dust_tuff");
    public static final RegistryObject<Item> DUST_RED_SAND = registerStandardStoneAgeItem("dust_red_sand");

    /*STONE CLAY*/
    public static final RegistryObject<Item> CLAY_STONE = registerStandardStoneAgeItem("clay_stone");
    public static final RegistryObject<Item> CLAY_DEEPSLATE = registerStandardStoneAgeItem("clay_deepslate");
    public static final RegistryObject<Item> CLAY_NETHERRACK = registerStandardStoneAgeItem("clay_netherrack");
    public static final RegistryObject<Item> CLAY_ENDSTONE = registerStandardStoneAgeItem("clay_endstone");

    public static final RegistryObject<Item> CLAY_BROWN = registerStandardStoneAgeItem("clay_brown");
    public static final RegistryObject<Item> CLAY_WHITE = registerStandardStoneAgeItem("clay_white");
    public static final RegistryObject<Item> CLAY_BLACK = registerStandardStoneAgeItem("clay_black");

    public static final RegistryObject<Item> CLAY_SAND = registerStandardStoneAgeItem("clay_sand");
    public static final RegistryObject<Item> CLAY_RED_SAND = registerStandardStoneAgeItem("clay_red_sand");


    /*STONE BRICKS*/
    public static final RegistryObject<Item> BRICK_STONE = registerStandardStoneAgeItem("brick_stone");
    public static final RegistryObject<Item> BRICK_DEEPSLATE = registerStandardStoneAgeItem("brick_deepslate");
    public static final RegistryObject<Item> BRICK_NETHERRACK = registerStandardStoneAgeItem("brick_netherrack");
    public static final RegistryObject<Item> BRICK_ENDSTONE = registerStandardStoneAgeItem("brick_endstone");

    public static final RegistryObject<Item> BRICK_BROWN = registerStandardStoneAgeItem("brick_brown");
    public static final RegistryObject<Item> BRICK_WHITE = registerStandardStoneAgeItem("brick_white");
    public static final RegistryObject<Item> BRICK_BLACK = registerStandardStoneAgeItem("brick_black");

    public static final RegistryObject<Item> BRICK_SAND = registerStandardStoneAgeItem("brick_sand");
    public static final RegistryObject<Item> BRICK_RED_SAND = registerStandardStoneAgeItem("brick_red_sand");


    /*Wool*/
    public static final RegistryObject<Item> WOOL = registerStandardStoneAgeItem("wool");
    public static final RegistryObject<Item> YARN = registerStandardStoneAgeItem("yarn");

    /*Armor*/

    public static final RegistryObject<ArmorItem> BRONZE_HELMET = registerMetalAgeItem("bronze_helmet",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<ArmorItem> BRONZE_CHEST = registerMetalAgeItem("bronze_chest",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<ArmorItem> BRONZE_LEGS = registerMetalAgeItem("bronze_legs",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> BRONZE_BOOTS = registerMetalAgeItem("bronze_boots",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.BOOTS, new Item.Properties()));

    /*ORE CHUNKS*/
    public static final RegistryObject<Item> RAW_TIN = registerStandardMetalAgeItem("raw_tin");
    public static final RegistryObject<Item> RAW_SILVER = registerStandardMetalAgeItem("raw_silver");

    /*Ingots*/
    public static final RegistryObject<Item> INGOT_TIN = registerStandardMetalAgeItem("ingot_tin");
    public static final RegistryObject<Item> INGOT_BRONZE = registerStandardMetalAgeItem("ingot_bronze");
    public static final RegistryObject<Item> INGOT_STEEL = registerStandardMetalAgeItem("ingot_steel");
    public static final RegistryObject<Item> INGOT_SILVER = registerStandardMetalAgeItem("ingot_silver");

    /*Nuggets*/
    public static final RegistryObject<Item> NUGGET_COPPER = registerStandardMetalAgeItem("nugget_copper");
    public static final RegistryObject<Item> NUGGET_TIN = registerStandardMetalAgeItem("nugget_tin");
    public static final RegistryObject<Item> NUGGET_BRONZE = registerStandardMetalAgeItem("nugget_bronze");
    public static final RegistryObject<Item> NUGGET_STEEL = registerStandardMetalAgeItem("nugget_steel");
    public static final RegistryObject<Item> NUGGET_SILVER = registerStandardMetalAgeItem("nugget_silver");

    /*Dusts*/
    public static final RegistryObject<Item> DUST_IRON = registerStandardMetalAgeItem("dust_iron");
    public static final RegistryObject<Item> DUST_GOLD = registerStandardMetalAgeItem("dust_gold");
    public static final RegistryObject<Item> DUST_COPPER = registerStandardMetalAgeItem("dust_copper");
    public static final RegistryObject<Item> DUST_TIN = registerStandardMetalAgeItem("dust_tin");
    public static final RegistryObject<Item> DUST_BRONZE = registerStandardMetalAgeItem("dust_bronze");
    public static final RegistryObject<Item> DUST_STEEL = registerStandardMetalAgeItem("dust_steel");
    public static final RegistryObject<Item> DUST_SILVER = registerStandardMetalAgeItem("dust_silver");
    public static final RegistryObject<Item> DUST_OBSIDIAN = registerStandardMetalAgeItem("dust_obsidian");


    public static final RegistryObject<Item> HINGE_IRON = registerStandardMetalAgeItem("hinge_iron");
    public static final RegistryObject<Item> CLASP_BRONZE = registerStandardMetalAgeItem("clasp_bronze");


    public static final RegistryObject<Item> HEMP_SEEDS = addToStoneAgeTab(ITEMS.register("hemp_seeds",
            () -> new ItemNameBlockItem(ModBlocks.HEMP_CROP.get(), new Item.Properties())));

    public static final RegistryObject<Item> GREEN_BEAN_SEEDS = addToStoneAgeTab(ITEMS.register("green_bean_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GREEN_BEAN_CROP.get(), new Item.Properties().food(ModFoodProperties.RAW_VEG).stacksTo(16))));
    public static final RegistryObject<Item> BLUE_ABRORE_SEEDS = addToStoneAgeTab(ITEMS.register("blue_abrore_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUE_ABRORE_CROP.get(), new Item.Properties())));


    public static final RegistryObject<Item> ONION = addToStoneAgeTab(ITEMS.register("onion",
            () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties().food(ModFoodProperties.RAW_VEG))));
    public static final RegistryObject<Item> GREEN_BEAN = registerStoneAgeItem("green_bean", () -> new Item(new Item.Properties().food(ModFoodProperties.RAW_VEG).stacksTo(8)));
    public static final RegistryObject<Item> BLUE_ABRORE = registerStoneAgeItem("blue_abrore", () -> new Item(new Item.Properties().food(ModFoodProperties.SALVE).stacksTo(8)));


    public static final RegistryObject<Item> MEAT_CAMELID = createFood("meat_camelid", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> MEAT_EQUINE = createFood("meat_equine", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> MEAT_BEAR = createFood("meat_bear", ModFoodProperties.RAW_MEAT);

    public static final RegistryObject<Item> MEAT_CAMELID_COOKED = createFood("meat_camelid_cooked", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> MEAT_EQUINE_COOKED  = createFood("meat_equine_cooked", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> MEAT_BEAR_COOKED  = createFood("meat_bear_cooked", ModFoodProperties.COOKED_MEAT);



    //MEALS (provide buffs)
    public static final RegistryObject<Item> SANDWICH = createFood("sandwich", ModFoodProperties.MEAL_WITH_MEAT);
    public static final RegistryObject<Item> SALAD = createFood("salad", ModFoodProperties.MEAL);




    //TODO Ploughmans Lunch - strenght
    //Travellers Lunch - speed
    // Warriors Soup - damage
    // Painter's Breakfast - vision


    /***************/
    /* VANILLA    */
    /************/

    public static final RegistryObject<?> WOODEN_SWORD = registerVanillaItem("wooden_sword", () -> new SwordItem(Tiers.WOOD, 3, -2.4F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> WOODEN_SHOVEL = registerVanillaItem("wooden_shovel", () -> new ShovelItem(Tiers.WOOD, 1.5F, -3.0F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> WOODEN_PICKAXE = registerVanillaItem("wooden_pickaxe", () -> new PickaxeItem(Tiers.WOOD, 1, -2.8F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> WOODEN_AXE = registerVanillaItem("wooden_axe", () -> new AxeItem(Tiers.WOOD, 6.0F, -3.2F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> WOODEN_HOE = registerVanillaItem("wooden_hoe", () -> new HoeItem(Tiers.WOOD, 0, -3.0F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> STONE_SWORD = registerVanillaItem("stone_sword", () -> new SwordItem(Tiers.STONE, 3, -2.4F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> STONE_SHOVEL = registerVanillaItem("stone_shovel", () -> new ShovelItem(Tiers.STONE, 1.5F, -3.0F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> STONE_PICKAXE = registerVanillaItem("stone_pickaxe", () -> new PickaxeItem(Tiers.STONE, 1, -2.8F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> STONE_AXE = registerVanillaItem("stone_axe", () -> new AxeItem(Tiers.STONE, 7.0F, -3.2F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> STONE_HOE = registerVanillaItem("stone_hoe", () -> new HoeItem(Tiers.STONE, -1, -2.0F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> GOLDEN_SWORD = registerVanillaItem("golden_sword", () -> new SwordItem(Tiers.GOLD, 3, -2.4F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> GOLDEN_SHOVEL = registerVanillaItem("golden_shovel", () -> new ShovelItem(Tiers.GOLD, 1.5F, -3.0F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> GOLDEN_PICKAXE = registerVanillaItem("golden_pickaxe", () -> new PickaxeItem(Tiers.GOLD, 1, -2.8F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> GOLDEN_AXE = registerVanillaItem("golden_axe", () -> new AxeItem(Tiers.GOLD, 6.0F, -3.0F, new Item.Properties().durability(1)));
    public static final RegistryObject<?> GOLDEN_HOE = registerVanillaItem("golden_hoe", () -> new HoeItem(Tiers.GOLD, 0, -3.0F, new Item.Properties().durability(1)));


    //Danger foods
    public static final RegistryObject<Item> ROTTEN_FLESH = createVanillaFood("rotten_flesh", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> SPIDER_EYE = createVanillaFood("spider_eye", ModFoodProperties.DANGER);
    public static final RegistryObject<Item> POISONOUS_POTATO = createVanillaFood("poisonous_potato", ModFoodProperties.DANGER);

    //raw meat
    public static final RegistryObject<Item> BEEF = createVanillaFood("beef", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> CHICKEN = createVanillaFood("chicken", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> COD = createVanillaFood("cod", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> MUTTON = createVanillaFood("mutton", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> PORKCHOP = createVanillaFood("porkchop", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> PUFFERFISH = createVanillaFood("pufferfish", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> SALMON = createVanillaFood("salmon", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> RABBIT = createVanillaFood("rabbit", ModFoodProperties.RAW_MEAT);
    public static final RegistryObject<Item> TROPICAL_FISH = createVanillaFood("tropical_fish", ModFoodProperties.RAW_MEAT);

    // LOW FOODS
    public static final RegistryObject<Item> APPLE = createVanillaFood("apple", ModFoodProperties.RAW_VEG);
    public static final RegistryObject<Item> BEETROOT = createVanillaFood("beetroot", ModFoodProperties.RAW_VEG);
    public static final RegistryObject<Item> CARROT = createVanillaFood("carrot", ModFoodProperties.RAW_VEG);
    public static final RegistryObject<Item> POTATO = createVanillaFood("potato", ModFoodProperties.RAW_VEG);
    public static final RegistryObject<Item> MELON_SLICE = createVanillaFood("melon_slice", ModFoodProperties.BERRY);
    public static final RegistryObject<Item> SWEET_BERRIES = createVanillaFood("sweet_berries", ModFoodProperties.BERRY);
    public static final RegistryObject<Item> GLOW_BERRIES = createVanillaFood("glow_berries", ModFoodProperties.BERRY);
    public static final RegistryObject<Item> HONEY_BOTTLE = registerVanillaItem("honey_bottle", () -> new HoneyBottleItem((new Item.Properties())
            .craftRemainder(Items.GLASS_BOTTLE).food(Foods.HONEY_BOTTLE).stacksTo(16)));

    //Average foods
    public static final RegistryObject<Item> BAKED_POTATO = createVanillaFood("baked_potato", ModFoodProperties.BASIC);
    public static final RegistryObject<Item> BREAD = createVanillaFood("bread", ModFoodProperties.BASIC);

    public static final RegistryObject<Item> COOKED_BEEF = createVanillaFood("cooked_beef", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> COOKED_CHICKEN = createVanillaFood("cooked_chicken", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> COOKED_COD = createVanillaFood("cooked_cod", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> COOKED_MUTTON = createVanillaFood("cooked_mutton", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> COOKED_PORKCHOP = createVanillaFood("cooked_porkchop", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> COOKED_SALMON = createVanillaFood("cooked_salmon", ModFoodProperties.COOKED_MEAT);
    public static final RegistryObject<Item> COOKED_RABBIT = createVanillaFood("cooked_rabbit", ModFoodProperties.COOKED_MEAT_SMALL);


    //GOOD FOODs
    public static final RegistryObject<Item> BEETROOT_SOUP = registerVanillaItem("beetroot_soup", () -> new ClayBowlFoodItem(new Item.Properties()
            .stacksTo(1).food(ModFoodProperties.GOOD)));
    public static final RegistryObject<Item> MUSHROOM_STEW = registerVanillaItem("mushroom_stew", () -> new ClayBowlFoodItem(new Item.Properties()
            .stacksTo(1).food(ModFoodProperties.GOOD)));
    public static final RegistryObject<Item> RABBIT_STEW = registerVanillaItem("rabbit_stew", () -> new ClayBowlFoodItem(new Item.Properties()
            .stacksTo(1).food(ModFoodProperties.STEW)));

    public static final RegistryObject<Item> PUMPKIN_PIE = createVanillaFood("pumpkin_pie", ModFoodProperties.GOOD);


//    public static final RegistryObject<Item> CHORUS_FRUIT = createVanillaFood("chorus_fruit", ModFoodProperties.BASIC);


    //Special Foods

//    public static final RegistryObject<Item> SUSPICIOUS_STEW = createVanillaFood("suspicious_stew", ModFoodProperties.BASIC);

//    public static final RegistryObject<Item> COOKIE = createVanillaFood("cookie", ModFoodProperties.BASIC);
//    public static final RegistryObject<Item> DRIED_KELP = createVanillaFood("dried_kelp", ModFoodProperties.BASIC);

    //magic
//    public static final RegistryObject<Item> ENCHANTED_GOLDEN_APPLE = createVanillaFood("enchanted_golden_apple", ModFoodProperties.BASIC);
//    public static final RegistryObject<Item> GOLDEN_APPLE = createVanillaFood("golden_apple", ModFoodProperties.BASIC);
//    public static final RegistryObject<Item> GOLDEN_CARROT = createVanillaFood("golden_carrot", ModFoodProperties.BASIC);



    /*Helpers*/

    public static <I extends Item> RegistryObject<I> registerStoneAgeItem(String name, Supplier<I> item) {
        return addToStoneAgeTab(ITEMS.register(name, item));
    }

    public static <I extends Item> RegistryObject<I> registerMetalAgeItem(String name, Supplier<I> item) {
        return addToMetalAgeTab(ITEMS.register(name, item));
    }


    private static <I extends Item> RegistryObject<FuelItem> createFuelItem(String name, int heat, Item.Properties itemProperties) {
        return addToStoneAgeTab(ITEMS.register(name, () -> new FuelItem(itemProperties, heat, name)));
    }

    private static RegistryObject<Item> registerStandardStoneAgeItem(String name) {
        return addToStoneAgeTab(ITEMS.register(name,
                () -> new Item(new Item.Properties())));
    }

    private static RegistryObject<Item> registerStandardMetalAgeItem(String name) {
        return addToMetalAgeTab(ITEMS.register(name,
                () -> new Item(new Item.Properties())));
    }

    public static <I extends Item> RegistryObject<I> registerVanillaItem(String name, Supplier<I> item) {
        return VANILLA_ITEMS.register(name, item);
    }


    private static RegistryObject<Item> createVanillaFood(String name, FoodProperties foodProperties) {
        return registerVanillaItem(name, () -> new Item(new Item.Properties().food(foodProperties)));
    }

    private static RegistryObject<Item> createFood(String name, FoodProperties foodProperties) {
        return registerStoneAgeItem(name, () -> new Item(new Item.Properties().food(foodProperties)));
    }

    private static GravelBlock createConcrete(DyeColor color) {
        return new GravelBlock(BlockBehaviour.Properties.of()
                .mapColor(color)
                .strength(1.8f)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops());
    }

    private static SwordItem createKnife(ForgeTier tier) {
        return new SwordItem(tier, 3, -2.4F, new Item.Properties().durability(tier.getUses() * 2));
    }

    private static SwordItem createSword(ForgeTier tier) {
        return new SwordItem(tier, 2, -1.2F, new Item.Properties());
    }

    private static ModShovelItem createShovel(ForgeTier tier) {
        return new ModShovelItem(tier, 1.5F, -3F, new Item.Properties());
    }

    private static AxeItem createAxe(ForgeTier tier) {
        return new AxeItem(tier, 6.0F, -3.2F, new Item.Properties());
    }

    private static HoeItem createHoe(ForgeTier tier) {
        return new HoeItem(tier, -1, -2.0F, new Item.Properties());
    }

    private static PickaxeItem createPick(ForgeTier tier) {
        return new PickaxeItem(tier, 1, -2.8F, new Item.Properties());
    }

    private static HammerItem createHammer(ForgeTier tier) {
        return new HammerItem(tier, 7.5F, -4.5F, new Item.Properties());
    }

    private static SawItem createSaw(ForgeTier tier) {
        return new SawItem(tier, 1.5F, -2.4F, new Item.Properties());
    }




    /*Heat Values for wood*/
//    High: Apple, Beech, Pecan, OAK, Hickory, Mangrove ironwood
//    Med: birch, walnut  Birch, Walnut, Larch, Ash,
//    Low: Elm,  Cedar, Poplar, Pine. Alder, Elm, Mapple, Cherry, acacia

    /*Wood real estimates + Heat Level */
//    OAK = High Heat
//    SPRUCE = LOW HEAT
//    BIRCH = white birch = MED HEAT
//    JUNGLE = cacao or maybe kapok = LOW HEAT
//    ACACIA = acacia = LOW
//    DARK_OAK = black oak (Quercus velutina) = MED HEAT
//    MANGROVE = HIGH HEAT
//    CHERRY - LOW HEAT
//    WARPED Nether woods cant burn normally currently giving them extra high heat instead
//    CRIMSON
//    https://theyardable.com/firewood-weight-btu-chart/

    /*TODO add woods hickorty, ironwood, elm and walnut*/
}





