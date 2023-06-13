package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Neolith.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Neolith.MODID);

    public static final int LOW_HEAT_WOOD = 250;
    public static final int MED_HEAT_WOOD = 350;
    public static final int HIGH_HEAT_WOOD = 500;
    public static final int NETHER_HEAT_WOOD = 650;


    /*Util*/
    public static final RegistryObject<Item> BASIC_GRINDING_STONE = ITEMS.register("basic_grinding_stone",
            () -> new Item(new Item.Properties().durability(50)));


    /*PLANTS*/
    public static final RegistryObject<Item> PLANT_FIBRE = ITEMS.register("plant_fibre",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRAIDED_PLANT_FIBRE = ITEMS.register("braided_plant_fibre",
            () -> new Item(new Item.Properties()));


    /*Crops*/
//    public static final RegistryObject<Item> MEDICINE_PLANT_SEEDS = ITEMS.register("medicine_seeds",
//            () -> new ItemNameBlockItem(ModBlocks.MEDICINE_CROP.get(),
//                    new Item.Properties()));

    public static final RegistryObject<Item> MEDICINE_PLANT = ITEMS.register("medicine_plant",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(0).saturationMod(0f).alwaysEat().fast().build())));


    /*Wool*/
    public static final RegistryObject<Item> WOOL = ITEMS.register("wool",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YARN = ITEMS.register("yarn",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<SpindleItem> SPINDLE = ITEMS.register("spindle",
            () -> new SpindleItem(ModToolMaterials.FLINT, new Item.Properties().durability(100)));


    /*Containers*/

    public static final RegistryObject<BasketItem> BASKET = ITEMS.register("basket",
            () -> new BasketItem(new Item.Properties().stacksTo(1)));


    /*HIDES*/
    public static final RegistryObject<Item> HIDE_SMALL = ITEMS.register("hide_small",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HIDE_MEDIUM = ITEMS.register("hide_medium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HIDE_LARGE = ITEMS.register("hide_large",
            () -> new Item(new Item.Properties()));

    /*Clay Objects*/
    public static final RegistryObject<Item> UNFIRED_CLAY_JUG = ITEMS.register("unfired_clay_jug",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNFIRED_CLAY_BUCKET = ITEMS.register("unfired_clay_bucket",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNFIRED_CLAY_BOTTLE = ITEMS.register("unfired_clay_bottle",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<BottleItem> CLAY_VIAL = ITEMS.register("clay_vial",
            () -> new BottleItem(new Item.Properties()));



    /*TOOLS*/
    //Req Material, Damage, attack speed and repair item

    public static final RegistryObject<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(ModToolMaterials.BRONZE, 6, 1.6f, new Item.Properties()));

    public static final RegistryObject<PickaxeItem> BRONZE_PICK = ITEMS.register("bronze_pick",
            () -> new PickaxeItem(ModToolMaterials.BRONZE, 4, 1.2f, new Item.Properties()));

    public static final RegistryObject<ModShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new ModShovelItem(ModToolMaterials.BRONZE, 2.25f, 1.0f, new Item.Properties()));

    public static final RegistryObject<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new AxeItem(ModToolMaterials.BRONZE, 9, 0.9f, new Item.Properties()));

    public static final RegistryObject<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new HoeItem(ModToolMaterials.BRONZE, 1, 3.0f, new Item.Properties()));


    public static final RegistryObject<SwordItem> FLINT_KNIFE = ITEMS.register("flint_knife",
            () -> new SwordItem(ModToolMaterials.FLINT, 4, 1.6f, new Item.Properties().durability(50 * 2))); //double durability because sword takes 2 when mining with it

    public static final RegistryObject<PickaxeItem> FLINT_PICK = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(ModToolMaterials.FLINT, 2, 1.2f, new Item.Properties().durability(50)));

    public static final RegistryObject<ShovelItem> FLINT_SHOVEL = ITEMS.register("flint_shovel",
            () -> new ShovelItem(ModToolMaterials.FLINT, 1.25f, 1.0f, new Item.Properties().durability(50)));

    public static final RegistryObject<AxeItem> FLINT_AXE = ITEMS.register("flint_axe",
            () -> new AxeItem(ModToolMaterials.FLINT, 7, 0.8f, new Item.Properties().durability(50)));

    public static final RegistryObject<HoeItem> FLINT_HOE = ITEMS.register("flint_hoe",
            () -> new HoeItem(ModToolMaterials.FLINT, 1, 1f, new Item.Properties().durability(50)));

    public static final RegistryObject<SawItem> FLINT_SAW = ITEMS.register("flint_saw",
            () -> new SawItem(ModToolMaterials.FLINT, 1, 1f, new Item.Properties().durability(50)));

    public static final RegistryObject<HammerItem> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(ModToolMaterials.FLINT, 8, .5f, new Item.Properties().durability(50)));

    public static final RegistryObject<TridentItem> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new TridentItem(new Item.Properties().durability(50)));

    public static final RegistryObject<FireStarterItem> BASIC_FIRESTARTER = ITEMS.register("firestarter",
            () -> new FireStarterItem(new Item.Properties().durability(2)));


    /*TOOLHEADS*/
    public static final RegistryObject<Item> FLINT_BLADE = ITEMS.register("flint_blade",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLINT_PICK_HEAD = ITEMS.register("flint_pick_head",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLINT_SHOVEL_HEAD = ITEMS.register("flint_shovel_head",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLINT_AXE_HEAD = ITEMS.register("flint_axe_head",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLINT_HOE_HEAD = ITEMS.register("flint_hoe_head",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLINT_SAW_HEAD = ITEMS.register("flint_saw_head",
            () -> new Item(new Item.Properties()));




    /*Armor*/

    public static final RegistryObject<ArmorItem> BRONZE_HELMET = ITEMS.register("bronze_helmet",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<ArmorItem> BRONZE_CHEST = ITEMS.register("bronze_chest",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<ArmorItem> BRONZE_LEGS = ITEMS.register("bronze_legs",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<ArmorItem> BRONZE_BOOTS = ITEMS.register("bronze_boots",
            () -> new ArmorItem(ModArmorMaterial.BRONZE, ArmorItem.Type.BOOTS, new Item.Properties()));


    /*FOOD*/
    public static final RegistryObject<Item> SALVE = ITEMS.register("salve",
            () -> new Item(new Item.Properties().food((ModFoods.SALVE))));


    /*ORE CHUNKS*/
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));


    /*Ingots*/
    public static final RegistryObject<Item> INGOT_TIN = ITEMS.register("ingot_tin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INGOT_BRONZE = ITEMS.register("ingot_bronze",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INGOT_STEEL = ITEMS.register("ingot_steel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INGOT_SILVER = ITEMS.register("ingot_silver",
            () -> new Item(new Item.Properties()));


    /*Nuggets*/
    public static final RegistryObject<Item> NUGGET_COPPER = ITEMS.register("nugget_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_TIN = ITEMS.register("nugget_tin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_BRONZE = ITEMS.register("nugget_bronze",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_STEEL = ITEMS.register("nugget_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_SILVER = ITEMS.register("nugget_silver",
            () -> new Item(new Item.Properties()));


    /*Dusts*/
    public static final RegistryObject<Item> DUST_IRON = ITEMS.register("dust_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_GOLD = ITEMS.register("dust_gold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_COPPER = ITEMS.register("dust_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_TIN = ITEMS.register("dust_tin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_BRONZE = ITEMS.register("dust_bronze",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_STEEL = ITEMS.register("dust_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_SILVER = ITEMS.register("dust_silver",
            () -> new Item(new Item.Properties()));

    /*STONE CHUNKS*/


    public static final RegistryObject<Item> CHUNK_STONE = ITEMS.register("chunk_stone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_ANDESITE = ITEMS.register("chunk_andesite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_DEEPSLATE = ITEMS.register("chunk_deepslate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_SANDSTONE = ITEMS.register("chunk_sandstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_DRIPSTONE = ITEMS.register("chunk_dripstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_DIORITE = ITEMS.register("chunk_diorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_GRANITE = ITEMS.register("chunk_granite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_BASALT = ITEMS.register("chunk_basalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_TUFF = ITEMS.register("chunk_tuff",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_NETHERRACK = ITEMS.register("chunk_netherrack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_BLACKSTONE = ITEMS.register("chunk_blackstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_CALCITE = ITEMS.register("chunk_calcite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHUNK_ENDSTONE = ITEMS.register("chunk_endstone",
            () -> new Item(new Item.Properties()));


    /*STONE DUSTS*/


    public static final RegistryObject<Item> DUST_STONE = ITEMS.register("dust_stone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_ANDESITE = ITEMS.register("dust_andesite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_DEEPSLATE = ITEMS.register("dust_deepslate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_DRIPSTONE = ITEMS.register("dust_dripstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_SANDSTONE = ITEMS.register("dust_sandstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_DIORITE = ITEMS.register("dust_diorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_GRANITE = ITEMS.register("dust_granite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_BASALT = ITEMS.register("dust_basalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_TUFF = ITEMS.register("dust_tuff",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_NETHERRACK = ITEMS.register("dust_netherrack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_BLACKSTONE = ITEMS.register("dust_blackstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_CALCITE = ITEMS.register("dust_calcite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUST_ENDSTONE = ITEMS.register("dust_endstone",
            () -> new Item(new Item.Properties()));

    /*Stone Clay*/
    public static final RegistryObject<Item> CLAY_STONE = ITEMS.register("clay_stone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_ANDESITE = ITEMS.register("clay_andesite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_DEEPSLATE = ITEMS.register("clay_deepslate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_DRIPSTONE = ITEMS.register("clay_dripstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_SANDSTONE = ITEMS.register("clay_sandstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_DIORITE = ITEMS.register("clay_diorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_GRANITE = ITEMS.register("clay_granite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_BASALT = ITEMS.register("clay_basalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_TUFF = ITEMS.register("clay_tuff",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_NETHERRACK = ITEMS.register("clay_netherrack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_BLACKSTONE = ITEMS.register("clay_blackstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_CALCITE = ITEMS.register("clay_calcite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_ENDSTONE = ITEMS.register("clay_endstone",
            () -> new Item(new Item.Properties()));

    /*STONE BRICKS*/
    public static final RegistryObject<Item> BRICK_STONE = ITEMS.register("brick_stone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_ANDESITE = ITEMS.register("brick_andesite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_DEEPSLATE = ITEMS.register("brick_deepslate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_DRIPSTONE = ITEMS.register("brick_dripstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_SANDSTONE = ITEMS.register("brick_sandstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_DIORITE = ITEMS.register("brick_diorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_GRANITE = ITEMS.register("brick_granite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_BASALT = ITEMS.register("brick_basalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_TUFF = ITEMS.register("brick_tuff",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_NETHERRACK = ITEMS.register("brick_netherrack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_BLACKSTONE = ITEMS.register("brick_blackstone",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_CALCITE = ITEMS.register("brick_calcite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_ENDSTONE = ITEMS.register("brick_endstone",
            () -> new Item(new Item.Properties()));

    /*Logs*/
    public static final RegistryObject<FuelItem> LOG_OAK = createFuelItem("log_oak", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_SPRUCE = createFuelItem("log_spruce", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_BIRCH = createFuelItem("log_birch", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_JUNGLE = createFuelItem("log_jungle", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_ACACIA = createFuelItem("log_acacia", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_DARK_OAK = createFuelItem("log_dark_oak", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_MANGROVE = createFuelItem("log_mangrove", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_WARPED = createFuelItem("log_warped", NETHER_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> LOG_CRIMSON = createFuelItem("log_crimson", NETHER_HEAT_WOOD, new Item.Properties());

    /*Planks*/
    public static final RegistryObject<FuelItem> PLANK_OAK = createFuelItem("plank_oak", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_SPRUCE = createFuelItem("plank_spruce", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_BIRCH = createFuelItem("plank_birch", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_JUNGLE = createFuelItem("plank_jungle", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_ACACIA = createFuelItem("plank_acacia", LOW_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_DARK_OAK = createFuelItem("plank_dark_oak", MED_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_MANGROVE = createFuelItem("plank_mangrove", HIGH_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_WARPED = createFuelItem("plank_warped", NETHER_HEAT_WOOD, new Item.Properties());
    public static final RegistryObject<FuelItem> PLANK_CRIMSON = createFuelItem("plank_crimson", NETHER_HEAT_WOOD, new Item.Properties());


    //CreativeModeTabs
    public static final RegistryObject<CreativeModeTab> STONE_AGE_TAB = CREATIVE_MODE_TABS.register((Neolith.MODID + "stone_age"), () -> CreativeModeTab.builder()
            .title(Component.translatable("stoneAge." + Neolith.MODID))
            .icon(() -> CHUNK_STONE.get().getDefaultInstance())
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ModBlocks.MANUAL_GRINDER.get());
                entries.accept(ModBlocks.FLINT_STATION.get());
                entries.accept(ModBlocks.FOUNDRY.get());
                entries.accept(CHUNK_STONE.get());
                entries.accept(CHUNK_ANDESITE.get());
                entries.accept(CHUNK_DEEPSLATE.get());
                entries.accept(CHUNK_SANDSTONE.get());
                entries.accept(CHUNK_DRIPSTONE.get());
                entries.accept(CHUNK_DIORITE.get());
                entries.accept(CHUNK_GRANITE.get());
                entries.accept(CHUNK_BASALT.get());
                entries.accept(CHUNK_TUFF.get());
                entries.accept(CHUNK_NETHERRACK.get());
                entries.accept(CHUNK_BLACKSTONE.get());
                entries.accept(CHUNK_CALCITE.get());
                entries.accept(CHUNK_ENDSTONE.get());

                entries.accept(DUST_STONE.get());
                entries.accept(DUST_ANDESITE.get());
                entries.accept(DUST_DEEPSLATE.get());
                entries.accept(DUST_DRIPSTONE.get());
                entries.accept(DUST_SANDSTONE.get());
                entries.accept(DUST_DIORITE.get());
                entries.accept(DUST_GRANITE.get());
                entries.accept(DUST_BASALT.get());
                entries.accept(DUST_TUFF.get());
                entries.accept(DUST_NETHERRACK.get());
                entries.accept(DUST_BLACKSTONE.get());
                entries.accept(DUST_CALCITE.get());
                entries.accept(DUST_ENDSTONE.get());
                entries.accept(CLAY_STONE.get());
                entries.accept(CLAY_ANDESITE.get());
                entries.accept(CLAY_DEEPSLATE.get());
                entries.accept(CLAY_DRIPSTONE.get());
                entries.accept(CLAY_SANDSTONE.get());
                entries.accept(CLAY_DIORITE.get());
                entries.accept(CLAY_GRANITE.get());
                entries.accept(CLAY_BASALT.get());
                entries.accept(CLAY_TUFF.get());
                entries.accept(CLAY_NETHERRACK.get());
                entries.accept(CLAY_BLACKSTONE.get());
                entries.accept(CLAY_CALCITE.get());
                entries.accept(CLAY_ENDSTONE.get());
                entries.accept(BRICK_STONE.get());
                entries.accept(BRICK_ANDESITE.get());
                entries.accept(BRICK_DEEPSLATE.get());
                entries.accept(BRICK_DRIPSTONE.get());
                entries.accept(BRICK_SANDSTONE.get());
                entries.accept(BRICK_DIORITE.get());
                entries.accept(BRICK_GRANITE.get());
                entries.accept(BRICK_BASALT.get());
                entries.accept(BRICK_TUFF.get());
                entries.accept(BRICK_NETHERRACK.get());
                entries.accept(BRICK_BLACKSTONE.get());
                entries.accept(BRICK_CALCITE.get());
                entries.accept(BRICK_ENDSTONE.get());
                entries.accept(LOG_OAK.get());
                entries.accept(LOG_SPRUCE.get());
                entries.accept(LOG_BIRCH.get());
                entries.accept(LOG_JUNGLE.get());
                entries.accept(LOG_ACACIA.get());
                entries.accept(LOG_DARK_OAK.get());
                entries.accept(LOG_MANGROVE.get());
                entries.accept(LOG_WARPED.get());
                entries.accept(LOG_CRIMSON.get());
                entries.accept(PLANK_OAK.get());
                entries.accept(PLANK_SPRUCE.get());
                entries.accept(PLANK_BIRCH.get());
                entries.accept(PLANK_JUNGLE.get());
                entries.accept(PLANK_ACACIA.get());
                entries.accept(PLANK_DARK_OAK.get());
                entries.accept(PLANK_MANGROVE.get());
                entries.accept(PLANK_WARPED.get());
                entries.accept(PLANK_CRIMSON.get());

            }).build());




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
//    WARPED Nether woods cant burn normally currently giving them extra high heat instead
//    CRIMSON
//    https://theyardable.com/firewood-weight-btu-chart/


    /*Helpers*/
    public static <I extends Item> RegistryObject<FuelItem> createFuelItem(String name, int heat, Item.Properties itemProperties) {
        return ITEMS.register(name, () -> new FuelItem(itemProperties, heat, name));
    }


}
