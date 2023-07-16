package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.crops.*;
import github.xuulmedia.neolith.block.custom.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static github.xuulmedia.neolith.init.ModItems.registerMetalAgeItem;
import static github.xuulmedia.neolith.init.ModItems.registerStoneAgeItem;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Neolith.MODID);
    public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");

    public static final RegistryObject<NeolithFallingBlock> ORE_TIN = registerBlock("ore_tin", ModCreativeTabs.TAB_NAME.METAL_AGE,
            () -> new NeolithFallingBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.SNARE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE), UniformInt.of(0, 5)),
            new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> ORE_SILVER = registerBlock("ore_nether_silver", ModCreativeTabs.TAB_NAME.METAL_AGE,
            () -> new NeolithFallingBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.SNARE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.NETHER_ORE), UniformInt.of(0, 5)),
            new Item.Properties());

    public static final RegistryObject<NeolithFallingBlock> ORE_CLAY = registerBlock("ore_clay", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new NeolithFallingBlock(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.FLUTE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0f, 0.6f)
                    .mapColor(MapColor.CLAY)
                    .sound(SoundType.STONE), UniformInt.of(0, 2)),
            new Item.Properties());


    public static final RegistryObject<Block> BLOCK_TIN = registerBlock("block_tin", ModCreativeTabs.TAB_NAME.METAL_AGE,
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.METAL)
                    .sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> BLOCK_SILVER = registerBlock("block_silver", ModCreativeTabs.TAB_NAME.METAL_AGE,
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())), new Item.Properties());
    public static final RegistryObject<Block> BLOCK_BRONZE = registerBlock("block_bronze", ModCreativeTabs.TAB_NAME.METAL_AGE,
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())), new Item.Properties());
    public static final RegistryObject<Block> BLOCK_STEEL = registerBlock("block_steel", ModCreativeTabs.TAB_NAME.METAL_AGE,
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())), new Item.Properties());

    /*Stone*/
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_ANDESITE = registerBlock("cobblestone_andesite", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_BASALT = registerBlock("cobblestone_basalt", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_BLACKSTONE = registerBlock("cobblestone_blackstone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_CALCITE = registerBlock("cobblestone_calcite", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_DEEPSLATE = registerBlock("cobblestone_deepslate", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_DIORITE = registerBlock("cobblestone_diorite", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_DRIPSTONE = registerBlock("cobblestone_dripstone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_GRANITE = registerBlock("cobblestone_granite", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_NETHERRACK = registerBlock("cobblestone_netherrack", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_RED_SANDSTONE = registerBlock("cobblestone_red_sandstone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_SANDSTONE = registerBlock("cobblestone_sandstone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_STONE = registerBlock("cobblestone_stone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_TUFF = registerBlock("cobblestone_tuff", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<NeolithFallingBlock> COBBLESTONE_ENDSTONE = registerBlock("cobblestone_endstone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCobblestone(MapColor.STONE), new Item.Properties());


    /*Stone Brick*/
    public static final RegistryObject<CutStoneBlock> STONE_BRICK_BLOCK = registerBlock("bricks_stone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> DEEPSLATE_BRICK_BLOCK = registerBlock("bricks_deepslate", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.DEEPSLATE), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> NETHERRACK_BRICK_BLOCK = registerBlock("bricks_netherrack", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.NETHER), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> ENDSTONE_BRICK_BLOCK = registerBlock("bricks_endstone", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.STONE), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> BROWN_BRICK_BLOCK = registerBlock("bricks_brown", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.TERRACOTTA_BROWN), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> WHITE_BRICK_BLOCK = registerBlock("bricks_white", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.TERRACOTTA_WHITE), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> BLACK_BRICK_BLOCK = registerBlock("bricks_black", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.DEEPSLATE), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> SAND_BRICK_BLOCK = registerBlock("bricks_sand", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.SAND), new Item.Properties());
    public static final RegistryObject<CutStoneBlock> RED_SAND_BRICK_BLOCK = registerBlock("bricks_red_sand", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.TERRACOTTA_RED), new Item.Properties());


    public static final RegistryObject<CutStoneBlock> WARDED_GRASS_BLOCK = registerBlock("warded_grass", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> createCutStoneBlock(MapColor.STONE), new Item.Properties());


    public static final RegistryObject<FlintNodeBlock> FLINT_NODE = registerBlock("flint_node", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new FlintNodeBlock(BlockBehaviour.Properties.of()
                    .instabreak()), new Item.Properties());

    public static final RegistryObject<Block> TORCH = BLOCKS.register("torch", () -> createTorchBlock(false, 14));
    public static final RegistryObject<Block> WALL_TORCH = registerWallBlock("torch", ModCreativeTabs.TAB_NAME.STONE_AGE, TORCH,
            () -> createTorchBlock(true, 14), new Item.Properties());

    /*Plants*/
    public static final RegistryObject<Block> THATCH = registerBlock("thatch", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new ThatchBlock(BlockBehaviour.Properties.of().noCollission().strength(4.0F).sound(SoundType.GRASS)), new Item.Properties());

    /*Crops*/
    /*TODO make this better for faster crops*/


    public static final RegistryObject<ModCropBlock> JUTE_CROP = BLOCKS.register("jute_crop", () ->
            new JuteCropBlock(cropProperties()));

    public static final RegistryObject<ModCropBlock> GREEN_BEAN_CROP = BLOCKS.register("green_bean_crop", () ->
            new GreenBeanCrop(cropProperties()));

    public static final RegistryObject<ModCropBlock> ONION_CROP = BLOCKS.register("onion_crop", () ->
            new OnionCrop(cropProperties()));

    public static final RegistryObject<ModCropBlock> BLUE_ABRORE_CROP = BLOCKS.register("blue_abrore_crop", () ->
            new BlueAbroreCrop(cropProperties()));

    /*Wild Crops*/


    /*Workstations*/
    public static final RegistryObject<ManualGrinderBlock> MANUAL_GRINDER = registerBlock("manual_grinder", ModCreativeTabs.TAB_NAME.STONE_AGE,
            ManualGrinderBlock::new, new Item.Properties());
    public static final RegistryObject<FlintStationBlock> FLINT_STATION = registerBlock("flint_station", ModCreativeTabs.TAB_NAME.STONE_AGE,
            FlintStationBlock::new, new Item.Properties());
    public static final RegistryObject<ForgeBlock> FORGE = registerBlock("forge", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new ForgeBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)), new Item.Properties());
    public static final RegistryObject<FoundryBlock> FOUNDRY = registerBlock("foundry", ModCreativeTabs.TAB_NAME.METAL_AGE,
            () -> new FoundryBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)), new Item.Properties());

    public static final RegistryObject<WorkBenchBlock> WORK_BENCH = registerBlock("workbench", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new WorkBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)), new Item.Properties());
    public static final RegistryObject<ModCampfireBlock> CAMPFIRE = registerBlock("campfire", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new ModCampfireBlock(true, 1, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE)), new Item.Properties().stacksTo(1));


    public static final RegistryObject<ClayPotBlock> CLAY_POT = registerBlock("clay_pot", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new ClayPotBlock(BlockBehaviour.Properties.copy(Blocks.DECORATED_POT)), new Item.Properties());

    public static final RegistryObject<DryingRackBlock> DRYING_RACK = registerBlock("drying_rack", ModCreativeTabs.TAB_NAME.STONE_AGE,
            () -> new DryingRackBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD)), new Item.Properties());



    /***************/
    /* VANILLA    */
    /************/

    /*LOGS*/
    public static final RegistryObject<RotatedPillarBlock> OAK_LOG = registerVanillaBlock("oak_log", () -> createLog(MapColor.WOOD, MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> SPRUCE_LOG = registerVanillaBlock("spruce_log", () -> createLog(MapColor.PODZOL, MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> BIRCH_LOG = registerVanillaBlock("birch_log", () -> createLog(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<RotatedPillarBlock> JUNGLE_LOG = registerVanillaBlock("jungle_log", () -> createLog(MapColor.DIRT, MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> ACACIA_LOG = registerVanillaBlock("acacia_log", () -> createLog(MapColor.COLOR_ORANGE, MapColor.STONE));
    //      public static final RegistryObject<RotatedPillarBlock> CHERRY_LOG = registerVanillaBlock("cherry_log", () -> createLog(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_GRAY, SoundType.CHERRY_WOOD));
    public static final RegistryObject<RotatedPillarBlock> DARK_OAK_LOG = registerVanillaBlock("dark_oak_log", () -> createLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> MANGROVE_LOG = registerVanillaBlock("mangrove_log", () -> createLog(MapColor.COLOR_BROWN, MapColor.STONE));
    //TODO MAGROVE ROOT
    //TODO  MUDDY MANGROVE ROOT
    //TODO Bamboo block
    public static final RegistryObject<RotatedPillarBlock> CRIMSON_STEM = registerVanillaBlock("crimson_stem", () -> createLog(MapColor.COLOR_RED, MapColor.STONE));
    public static final RegistryObject<RotatedPillarBlock> WARPED_STEM = registerVanillaBlock("warped_stem", () -> createLog(MapColor.COLOR_BLUE, MapColor.STONE));

    /*Stripped Logs*/
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_OAK_LOG = registerVanillaBlock("stripped_oak_log", () -> createLog(MapColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SPRUCE_LOG = registerVanillaBlock("stripped_spruce_log", () -> createLog(MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BIRCH_LOG = registerVanillaBlock("stripped_birch_log", () -> createLog(MapColor.SAND));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ACACIA_LOG = registerVanillaBlock("stripped_acacia_log", () -> createLog(MapColor.COLOR_ORANGE));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_CHERRY_LOG = registerVanillaBlock("stripped_cherry_log", () -> createLog(MapColor.TERRACOTTA_WHITE));
    //TODO CHERRY
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DARK_OAK_LOG = registerVanillaBlock("stripped_dark_oak_log", () -> createLog(MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_JUNGLE_LOG = registerVanillaBlock("stripped_jungle_log", () -> createLog(MapColor.DIRT));
    //TODO STRIPPED_MANGROVE_LOG
    //TODO STRIPPED_BAMBOO_BLOCK

    /*PLANKS */
    public static final RegistryObject<Block> SPRUCE_PLANKS = registerVanillaBlock("spruce_planks", () -> createPlanks(MapColor.PODZOL, SoundType.WOOD));
    public static final RegistryObject<Block> BIRCH_PLANKS = registerVanillaBlock("birch_planks", () -> createPlanks(MapColor.SAND, SoundType.WOOD));
    public static final RegistryObject<Block> JUNGLE_PLANKS = registerVanillaBlock("jungle_planks", () -> createPlanks(MapColor.DIRT, SoundType.WOOD));
    public static final RegistryObject<Block> ACACIA_PLANKS = registerVanillaBlock("acacia_planks", () -> createPlanks(MapColor.COLOR_ORANGE, SoundType.WOOD));
    public static final RegistryObject<Block> CHERRY_PLANKS = registerVanillaBlock("cherry_planks", () -> createPlanks(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD));
    public static final RegistryObject<Block> DARK_OAK_PLANKS = registerVanillaBlock("dark_oak_planks", () -> createPlanks(MapColor.COLOR_BROWN, SoundType.WOOD));
    public static final RegistryObject<Block> MANGROVE_PLANKS = registerVanillaBlock("mangrove_planks", () -> createPlanks(MapColor.COLOR_RED, SoundType.WOOD));
    public static final RegistryObject<Block> BAMBOO_PLANKS = registerVanillaBlock("bamboo_planks", () -> createPlanks(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD));
    public static final RegistryObject<Block> BAMBOO_MOSAIC = registerVanillaBlock("bamboo_mosaic", () -> createPlanks(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD));

    // WOOD
    public static final RegistryObject<RotatedPillarBlock> OAK_WOOD = registerVanillaBlock("oak_wood", () -> createLog(MapColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> SPRUCE_WOOD = registerVanillaBlock("spruce_wood", () -> createLog(MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> BIRCH_WOOD = registerVanillaBlock("birch_wood", () -> createLog(MapColor.SAND));
    public static final RegistryObject<RotatedPillarBlock> JUNGLE_WOOD = registerVanillaBlock("jungle_wood", () -> createLog(MapColor.DIRT));
    public static final RegistryObject<RotatedPillarBlock> ACACIA_WOOD = registerVanillaBlock("acacia_wood", () -> createLog(MapColor.COLOR_GRAY));
    public static final RegistryObject<RotatedPillarBlock> CHERRY_WOOD = registerVanillaBlock("cherry_wood", () -> createLog(MapColor.TERRACOTTA_GRAY));
    public static final RegistryObject<RotatedPillarBlock> DARK_OAK_WOOD = registerVanillaBlock("dark_oak_wood", () -> createLog(MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> MANGROVE_WOOD = registerVanillaBlock("mangrove_wood", () -> createLog(MapColor.COLOR_RED));

    //Stripped wood
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_OAK_WOOD = registerVanillaBlock("stripped_oak_wood", () -> createLog(MapColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SPRUCE_WOOD = registerVanillaBlock("stripped_spruce_wood", () -> createLog(MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BIRCH_WOOD = registerVanillaBlock("stripped_birch_wood", () -> createLog(MapColor.SAND));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_JUNGLE_WOOD = registerVanillaBlock("stripped_jungle_wood", () -> createLog(MapColor.DIRT));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ACACIA_WOOD = registerVanillaBlock("stripped_acacia_wood", () -> createLog(MapColor.COLOR_ORANGE));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_CHERRY_WOOD = registerVanillaBlock("stripped_cherry_wood", () -> createLog(MapColor.TERRACOTTA_PINK));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DARK_OAK_WOOD = registerVanillaBlock("stripped_dark_oak_wood", () -> createLog(MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MANGROVE_WOOD = registerVanillaBlock("stripped_mangrove_wood", () -> createLog(MapColor.COLOR_RED));


    //saplings
    public static final RegistryObject<Block> OAK_SAPLING = registerVanillaBlock("oak_sapling", () -> createResistantSapling(new OakTreeGrower()));
    public static final RegistryObject<Block> SPRUCE_SAPLING = registerVanillaBlock("spruce_sapling", () -> createResistantSapling(new SpruceTreeGrower()));
    public static final RegistryObject<Block> BIRCH_SAPLING = registerVanillaBlock("birch_sapling", () -> createResistantSapling(new BirchTreeGrower()));
    public static final RegistryObject<Block> JUNGLE_SAPLING = registerVanillaBlock("jungle_sapling", () -> createResistantSapling(new JungleTreeGrower()));
    public static final RegistryObject<Block> ACACIA_SAPLING = registerVanillaBlock("acacia_sapling", () -> createResistantSapling(new AcaciaTreeGrower()));
    public static final RegistryObject<Block> CHERRY_SAPLING = registerVanillaBlock("cherry_sapling", () -> createResistantSapling(new CherryTreeGrower()));
    public static final RegistryObject<Block> DARK_OAK_SAPLING = registerVanillaBlock("dark_oak_sapling", () -> createResistantSapling(new DarkOakTreeGrower()));

    /*Concrete*/
    public static final RegistryObject<GravelBlock> WHITE_CONCRETE = registerVanillaBlock("white_concrete", () -> createConcrete(DyeColor.WHITE));
    public static final RegistryObject<GravelBlock> ORANGE_CONCRETE = registerVanillaBlock("orange_concrete", () -> createConcrete(DyeColor.ORANGE));
    public static final RegistryObject<GravelBlock> MAGENTA_CONCRETE = registerVanillaBlock("magenta_concrete", () -> createConcrete(DyeColor.MAGENTA));
    public static final RegistryObject<GravelBlock> LIGHT_BLUE_CONCRETE = registerVanillaBlock("light_blue_concrete", () -> createConcrete(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<GravelBlock> YELLOW_CONCRETE = registerVanillaBlock("yellow_concrete", () -> createConcrete(DyeColor.YELLOW));
    public static final RegistryObject<GravelBlock> LIME_CONCRETE = registerVanillaBlock("lime_concrete", () -> createConcrete(DyeColor.LIME));
    public static final RegistryObject<GravelBlock> PINK_CONCRETE = registerVanillaBlock("pink_concrete", () -> createConcrete(DyeColor.PINK));
    public static final RegistryObject<GravelBlock> GRAY_CONCRETE = registerVanillaBlock("gray_concrete", () -> createConcrete(DyeColor.GRAY));
    public static final RegistryObject<GravelBlock> LIGHT_GRAY_CONCRETE = registerVanillaBlock("light_gray_concrete", () -> createConcrete(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<GravelBlock> CYAN_CONCRETE = registerVanillaBlock("cyan_concrete", () -> createConcrete(DyeColor.CYAN));
    public static final RegistryObject<GravelBlock> PURPLE_CONCRETE = registerVanillaBlock("purple_concrete", () -> createConcrete(DyeColor.PURPLE));
    public static final RegistryObject<GravelBlock> BLUE_CONCRETE = registerVanillaBlock("blue_concrete", () -> createConcrete(DyeColor.BLUE));
    public static final RegistryObject<GravelBlock> BROWN_CONCRETE = registerVanillaBlock("brown_concrete", () -> createConcrete(DyeColor.BROWN));
    public static final RegistryObject<GravelBlock> GREEN_CONCRETE = registerVanillaBlock("green_concrete", () -> createConcrete(DyeColor.GREEN));
    public static final RegistryObject<GravelBlock> RED_CONCRETE = registerVanillaBlock("red_concrete", () -> createConcrete(DyeColor.RED));
    public static final RegistryObject<GravelBlock> BLACK_CONCRETE = registerVanillaBlock("black_concrete", () -> createConcrete(DyeColor.BLACK));

    /*Dirt*/
    public static final RegistryObject<GravelBlock> DIRT = registerVanillaBlock("dirt", () -> new GravelBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).requiresCorrectToolForDrops()));
    public static final RegistryObject<GrassGravityBlock> GRASS_BLOCK = registerVanillaBlock("grass_block", () -> new GrassGravityBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).randomTicks().strength(.6F).sound(SoundType.GRASS).requiresCorrectToolForDrops()));
    public static final RegistryObject<GravelBlock> COARSE_DIRT = registerVanillaBlock("coarse_dirt", () -> new GravelBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).requiresCorrectToolForDrops()));

//    PODZOL
//    MUD
//    PATHBLOCK
    /*TODO all saplings need a new type for bonemeal resistance*/

    /*WOOL
    * WHITE_WOOL
ORANGE_WOOL
MAGENTA_WOOL
LIGHT_BLUE_WOOL
YELLOW_WOOL
LIME_WOOL
PINK_WOOL
GRAY_WOOL
LIGHT_GRAY_WOOL
CYAN_WOOL
PURPLE_WOOL
BLUE_WOOL
BROWN_WOOL
GREEN_WOOL
RED_WOOL
BLACK_WOOL*/


    /*Helpers*/
    private static <T extends Block> RegistryObject<T> registerBlock(String name, ModCreativeTabs.TAB_NAME tab, Supplier<T> block, Item.Properties itemProperties) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemProperties, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties itemProperties, ModCreativeTabs.TAB_NAME tab) {
        if (tab == ModCreativeTabs.TAB_NAME.STONE_AGE) {
            return registerStoneAgeItem(name, () -> new BlockItem(block.get(), itemProperties));
        } else if (tab == ModCreativeTabs.TAB_NAME.METAL_AGE) {
            return registerMetalAgeItem(name, () -> new BlockItem(block.get(), itemProperties));
        } else {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
        }
    }

    private static <T extends Block> RegistryObject<T> registerVanillaBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = VANILLA_BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerWallBlock(String name, ModCreativeTabs.TAB_NAME creativeTab, Supplier<T> torchBlock, Supplier<T> wallTorch, Item.Properties itemProperties) {

        RegistryObject<T> toReturn = BLOCKS.register("wall_" + name, wallTorch);
        registerStandingAndWallBlockItem(name, torchBlock, toReturn, itemProperties, creativeTab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerStandingAndWallBlockItem(String name, Supplier<T> standingBlock, Supplier<T> wallBlock, Item.Properties itemProperties, ModCreativeTabs.TAB_NAME tab) {
        if (tab == ModCreativeTabs.TAB_NAME.STONE_AGE) {
            return registerStoneAgeItem(name, () -> new StandingAndWallBlockItem(standingBlock.get(), wallBlock.get(), itemProperties, Direction.DOWN));
        } else if (tab == ModCreativeTabs.TAB_NAME.METAL_AGE) {
            return registerMetalAgeItem(name, () -> new StandingAndWallBlockItem(standingBlock.get(), wallBlock.get(), itemProperties, Direction.DOWN));
        } else {
            return ModItems.ITEMS.register(name, () -> new StandingAndWallBlockItem(standingBlock.get(), wallBlock.get(), itemProperties, Direction.DOWN));
        }
    }


    /*CREATE BLOCKS*/


    private static NeolithFallingBlock updateVanillaOre() {
        return new NeolithFallingBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 3.0F), UniformInt.of(0, 2));
    }


    public static CutStoneBlock createCutStoneBlock(MapColor color) {
        return new CutStoneBlock(BlockBehaviour.Properties.of()
                .requiresCorrectToolForDrops()
                .strength(1.5f, 6.0f)
                .isValidSpawn(ModBlocks::never)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.STONE)
                .mapColor(color));
    }

    private static NeolithFallingBlock createCobblestone(MapColor color) {
        return new NeolithFallingBlock(BlockBehaviour.Properties.of()
                .requiresCorrectToolForDrops()
                .strength(2.0f, 2.0f)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.STONE)
                .mapColor(color), ConstantInt.of(0));
    }

    private static GravelBlock createConcrete(DyeColor color) {
        return new GravelBlock(BlockBehaviour.Properties.of()
                .mapColor(color)
                .strength(1.8f)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops());
    }


    private static RotatedPillarBlock createLog(MapColor topColor, MapColor barkColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of()
                .mapColor((color) -> {
                    return color.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
                })
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava().
                requiresCorrectToolForDrops());
    }

    private static RotatedPillarBlock createLog(MapColor color) {
        return createLog(color, color);
    }

    private static Block createPlanks(MapColor color, SoundType sound) {
        return new Block(BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F).sound(sound).ignitedByLava().requiresCorrectToolForDrops());
    }

    private static ModSaplingBlock createResistantSapling(AbstractTreeGrower treeGrower) {
        return new ModSaplingBlock(treeGrower, BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .randomTicks()
                .instabreak()
                .sound(SoundType.GRASS)
                .pushReaction(PushReaction.DESTROY));
    }

    private static ModTorchBlock createTorchBlock(boolean wall, int lightLevel) {
        if (!wall) {
            return new ModTorchBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .instabreak()
                    .noOcclusion()
                    .sound(SoundType.WOOD)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(litBlockEmission(lightLevel)));
        } else {
            return new ModWallTorchBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .instabreak()
                    .noOcclusion()
                    .sound(SoundType.WOOD)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(litBlockEmission(lightLevel)));
        }
    }

    private static BlockBehaviour.Properties cropProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .noOcclusion()
                .randomTicks()
                .instabreak()
                .sound(SoundType.CROP)
                .pushReaction(PushReaction.DESTROY);
    }


    private static Boolean never(BlockState state, BlockGetter block, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static Boolean always(BlockState state, BlockGetter block, BlockPos pos, EntityType<?> type) {
        return true;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }


}