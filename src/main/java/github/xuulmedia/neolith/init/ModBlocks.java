package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.crops.MedicineCropBlock;
import github.xuulmedia.neolith.block.custom.*;
import github.xuulmedia.neolith.block.custom.GrassGravityBlock;
import github.xuulmedia.neolith.block.workstation.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
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

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Neolith.MODID);
    public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");

    public static final RegistryObject<Block> ORE_TIN = registerBlock("ore_tin",
            () -> new Block(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.SNARE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)), new Item.Properties());

    public static final RegistryObject<Block> ORE_SILVER = registerBlock("ore_nether_silver",
            () -> new Block(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.SNARE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.NETHER_ORE)), new Item.Properties());


    public static final RegistryObject<Block> BLOCK_TIN = registerBlock("block_tin",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(5.0F, 6.0F)
                    .mapColor(MapColor.METAL)
                    .sound(SoundType.METAL)), new Item.Properties());
    public static final RegistryObject<Block> BLOCK_SILVER = registerBlock("block_silver",
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())), new Item.Properties());
    public static final RegistryObject<Block> BLOCK_BRONZE = registerBlock("block_bronze",
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())), new Item.Properties());
    public static final RegistryObject<Block> BLOCK_STEEL = registerBlock("block_steel",
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())), new Item.Properties());

    /*Stone*/
    public static final RegistryObject<GravelBlock> COBBLESTONE = registerBlock("cobblestone",
            () -> new GravelBlock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(2.0f, 2.0f)
                    .instrument(NoteBlockInstrument.SNARE)
                    .isValidSpawn(ModBlocks::never)
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)), new Item.Properties());
    public static final RegistryObject<GravelBlock> BASALT_COBBLESTONE = registerBlock("basalt_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> DEEPSLATE_COBBLESTONE = registerBlock("deepslate_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> NETHERRACK_COBBLESTONE = registerBlock("netherrack_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> SANDSTONE_COBBLESTONE = registerBlock("sandstone_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> BLACKSTONE_COBBLESTONE = registerBlock("blackstone_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> ENDSTONE_COBBLESTONE = registerBlock("endstone_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> GRANITE_COBBLESTONE = registerBlock("granite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> TUFF_COBBLESTONE = registerBlock("tuff_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> ANDESITE_COBBLESTONE = registerBlock("andesite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> DIORITE_COBBLESTONE = registerBlock("diorite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> CALCITE_COBBLESTONE = registerBlock("calcite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())), new Item.Properties());


    /*Stone Brick*/
    public static final RegistryObject<GravelBlock> STONE_BRICK_BLOCK = registerBlock("bricks_stone",
            () -> new GravelBlock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .isValidSpawn(ModBlocks::never)
                    .sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)), new Item.Properties());
    public static final RegistryObject<GravelBlock> BASALT_BRICK_BLOCK = registerBlock("bricks_basalt",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> DEEPSLATE_BRICK_BLOCK = registerBlock("bricks_deepslate",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> NETHERRACK_BRICK_BLOCK = registerBlock("bricks_netherrack",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> SANDSTONE_BRICK_BLOCK = registerBlock("bricks_sandstone",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> BLACKSTONE_BRICK_BLOCK = registerBlock("bricks_blackstone",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> ENDSTONE_BRICK_BLOCK = registerBlock("bricks_endstone",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> GRANITE_BRICK_BLOCK = registerBlock("bricks_granite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> TUFF_BRICK_BLOCK = registerBlock("bricks_tuff",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> ANDESITE_BRICK_BLOCK = registerBlock("bricks_andesite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> DIORITE_BRICK_BLOCK = registerBlock("bricks_diorite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());
    public static final RegistryObject<GravelBlock> CALCITE_BRICK_BLOCK = registerBlock("bricks_calcite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())), new Item.Properties());


    public static final RegistryObject<FlintNodeBlock> FLINT_NODE = registerBlock("flint_node",
            () -> new FlintNodeBlock(BlockBehaviour.Properties.of()
                    .instabreak()), new Item.Properties());


    public static final RegistryObject<ModTorchBlock> TORCH = registerBlock("torch",
            () -> new ModTorchBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .instabreak()
                    .lightLevel(litBlockEmission(15))), new Item.Properties());


    /*Workstations*/
    public static final RegistryObject<ManualGrinderBlock> MANUAL_GRINDER = registerBlock("manual_grinder",
            ManualGrinderBlock::new, new Item.Properties());
    public static final RegistryObject<FlintStationBlock> FLINT_STATION = registerBlock("flint_station",
            FlintStationBlock::new, new Item.Properties());
    public static final RegistryObject<ForgeBlock> FORGE = registerBlock("forge",
            () -> new ForgeBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)), new Item.Properties());
    public static final RegistryObject<FoundryBlock> FOUNDRY = registerBlock("foundry",
            () -> new FoundryBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)), new Item.Properties());

    public static final RegistryObject<ModCampfireBlock> CAMPFIRE = registerBlock("campfire",
            () -> new ModCampfireBlock(true, 1, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE)), new Item.Properties().stacksTo(1));

    public static final RegistryObject<WorkBenchBlock> WORK_BENCH = registerBlock("workbench",
            () -> new WorkBenchBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)), new Item.Properties());


    /*Plants*/
    public static final RegistryObject<ThatchBlock> THATCH = registerBlock("thatch",
            () -> new ThatchBlock(BlockBehaviour.Properties.of().noCollission().strength(4.0F).sound(SoundType.GRASS)), new Item.Properties());

    /*Crops*/
    public static final RegistryObject<MedicineCropBlock> MEDICINE_CROP = BLOCKS.register("medicine_crop",
            () -> new MedicineCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));


    /***************/
    /* VANILLA    */
    /************/

    /*LOGS*/

    public static final RegistryObject<RotatedPillarBlock> OAK_LOG = registerVanillaBlock("oak_log", () -> createLog(MapColor.WOOD, MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> SPRUCE_LOG = registerVanillaBlock("spruce_log", () -> createLog(MapColor.PODZOL, MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> BIRCH_LOG = registerVanillaBlock("birch_log", () -> createLog(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<RotatedPillarBlock> JUNGLE_LOG = registerVanillaBlock("jungle_log", () -> createLog(MapColor.DIRT, MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> ACACIA_LOG = registerVanillaBlock("acacia_log", () -> createLog(MapColor.COLOR_ORANGE, MapColor.STONE));
    //  public static final RegistryObject<RotatedPillarBlock> CHERRY_LOG = registerVanillaBlock("cherry_log", () -> createLog(MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_GRAY, SoundType.CHERRY_WOOD));
    public static final RegistryObject<RotatedPillarBlock> DARK_OAK_LOG = registerVanillaBlock("dark_oak_log", () -> createLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> MANGROVE_LOG = registerVanillaBlock("mangrove_log", () -> createLog(MapColor.COLOR_BROWN, MapColor.STONE));
    //TODO MAGROVE ROOT
    //TODO  MUDDY MANGROVE ROOT
    //TODO Bamboo block
    public static final RegistryObject<RotatedPillarBlock> CRIMSON_STEM = registerVanillaBlock("crimson_stem", () -> createLog(MapColor.COLOR_RED, MapColor.STONE));
    public static final RegistryObject<RotatedPillarBlock> WARPED_STEM = registerVanillaBlock("warped_stem", () -> createLog(MapColor.COLOR_BLUE, MapColor.STONE));

    /*Stripped Logs*/
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_OAK_LOG = registerVanillaBlock("stripped_oak_log", () -> createLog(MapColor.WOOD, MapColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SPRUCE_LOG = registerVanillaBlock("stripped_spruce_log", () -> createLog(MapColor.PODZOL, MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BIRCH_LOG = registerVanillaBlock("stripped_birch_log", () -> createLog(MapColor.SAND, MapColor.SAND));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ACACIA_LOG = registerVanillaBlock("stripped_acacia_log", () -> createLog(MapColor.COLOR_ORANGE, MapColor.COLOR_ORANGE));
    //TODO CHERRY
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DARK_OAK_LOG = registerVanillaBlock("stripped_dark_oak_log", () -> createLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_JUNGLE_LOG = registerVanillaBlock("stripped_jungle_log", () -> createLog(MapColor.DIRT, MapColor.DIRT));
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
    public static final RegistryObject<RotatedPillarBlock> OAK_WOOD = registerVanillaBlock("oak_wood", () -> createLog(MapColor.WOOD, MapColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> SPRUCE_WOOD = registerVanillaBlock("spruce_wood", () -> createLog(MapColor.PODZOL, MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> BIRCH_WOOD = registerVanillaBlock("birch_wood", () -> createLog(MapColor.SAND, MapColor.SAND));
    public static final RegistryObject<RotatedPillarBlock> JUNGLE_WOOD = registerVanillaBlock("jungle_wood", () -> createLog(MapColor.DIRT, MapColor.DIRT));
    public static final RegistryObject<RotatedPillarBlock> ACACIA_WOOD = registerVanillaBlock("acacia_wood", () -> createLog(MapColor.COLOR_GRAY, MapColor.COLOR_GRAY));
    public static final RegistryObject<RotatedPillarBlock> CHERRY_WOOD = registerVanillaBlock("cherry_wood", () -> createLog(MapColor.TERRACOTTA_GRAY, MapColor.TERRACOTTA_GRAY));
    public static final RegistryObject<RotatedPillarBlock> DARK_OAK_WOOD = registerVanillaBlock("dark_oak_wood", () -> createLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> MANGROVE_WOOD = registerVanillaBlock("mangrove_wood", () -> createLog(MapColor.COLOR_RED, MapColor.COLOR_RED));

    //Stripped wood
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_OAK_WOOD = registerVanillaBlock("stripped_oak_wood", () -> createLog(MapColor.WOOD, MapColor.WOOD));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SPRUCE_WOOD = registerVanillaBlock("stripped_spruce_wood", () -> createLog(MapColor.PODZOL, MapColor.PODZOL));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BIRCH_WOOD = registerVanillaBlock("stripped_birch_wood", () -> createLog(MapColor.SAND, MapColor.SAND));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_JUNGLE_WOOD = registerVanillaBlock("stripped_jungle_wood", () -> createLog(MapColor.DIRT, MapColor.DIRT));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ACACIA_WOOD = registerVanillaBlock("stripped_acacia_wood", () -> createLog(MapColor.COLOR_ORANGE, MapColor.COLOR_ORANGE));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_CHERRY_WOOD = registerVanillaBlock("stripped_cherry_wood", () -> createLog(MapColor.TERRACOTTA_PINK, MapColor.TERRACOTTA_PINK));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DARK_OAK_WOOD = registerVanillaBlock("stripped_dark_oak_wood", () -> createLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_MANGROVE_WOOD = registerVanillaBlock("stripped_mangrove_wood", () -> createLog(MapColor.COLOR_RED, MapColor.COLOR_RED));





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


    /*Helpers*/
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemProperties);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties itemProperties) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }

    private static <T extends Block> RegistryObject<T> registerVanillaBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = VANILLA_BLOCKS.register(name, block);
        return toReturn;
    }



    private static RotatedPillarBlock createLog(MapColor topColor, MapColor barkColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((color) -> {
            return color.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().requiresCorrectToolForDrops());
    }
    private static Block createPlanks(MapColor color, SoundType sound) {
        return new Block(BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F).sound(sound).ignitedByLava().requiresCorrectToolForDrops());
    }

    private static GravelBlock createConcrete(DyeColor color ){
        return  new GravelBlock(BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F));
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
