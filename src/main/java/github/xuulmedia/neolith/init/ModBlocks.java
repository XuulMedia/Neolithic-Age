package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.FlintNodeBlock;
import github.xuulmedia.neolith.block.ThatchBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Neolith.MODID);
    public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");


//    public static final RegistryObject<FlintNodeBlock> FLINT_NODE = registerBlock("flint_node",
//            () -> new FlintNodeBlock(BlockBehaviour.Properties.of(Material.STONE)
//                    .instabreak()), new Item.Properties);


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
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> DEEPSLATE_BRICK_BLOCK = registerBlock("bricks_deepslate",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> NETHERRACK_BRICK_BLOCK = registerBlock("bricks_netherrack",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> SANDSTONE_BRICK_BLOCK = registerBlock("bricks_sandstone",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> BLACKSTONE_BRICK_BLOCK = registerBlock("bricks_blackstone",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> ENDSTONE_BRICK_BLOCK = registerBlock("bricks_endstone",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> GRANITE_BRICK_BLOCK = registerBlock("bricks_granite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> TUFF_BRICK_BLOCK = registerBlock("bricks_tuff",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> ANDESITE_BRICK_BLOCK = registerBlock("bricks_andesite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> DIORITE_BRICK_BLOCK = registerBlock("bricks_diorite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());
    public static final RegistryObject<GravelBlock> CALCITE_BRICK_BLOCK = registerBlock("bricks_calcite",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())),new Item.Properties());

    /*Plants*/
    public static final RegistryObject<ThatchBlock> THATCH = registerBlock("thatch",
            () -> new ThatchBlock(BlockBehaviour.Properties.of().noCollission().strength(4.0F).sound(SoundType.GRASS)), new Item.Properties());



    /*Crops*/

//    public static final RegistryObject<MedicineCropBlock> MEDICINE_CROP = BLOCKS.register("medicine_crop",
//            () -> new MedicineCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    /*Vanilla modifiers*/
//
//    public static final RegistryObject<RotatedPillarBlock> OAK_LOG = VANILLA_BLOCKS.register("oak_log", () -> log(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> SPRUCE_LOG = VANILLA_BLOCKS.register("spruce_log", () -> log(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> BIRCH_LOG = VANILLA_BLOCKS.register("birch_log", () -> log(MaterialColor.SAND, MaterialColor.QUARTZ));
//    public static final RegistryObject<RotatedPillarBlock> JUNGLE_LOG = VANILLA_BLOCKS.register("jungle_log", () -> log(MaterialColor.DIRT, MaterialColor.PODZOL));
//    public static final RegistryObject<RotatedPillarBlock> ACACIA_LOG = VANILLA_BLOCKS.register("acacia_log", () -> log(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
//    public static final RegistryObject<RotatedPillarBlock> DARK_OAK_LOG = VANILLA_BLOCKS.register("dark_oak_log",() ->  log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> MANGROVE_LOG = VANILLA_BLOCKS.register("mangrove_log", () -> log(MaterialColor.COLOR_BROWN, MaterialColor.STONE));
//    public static final RegistryObject<RotatedPillarBlock> CRIMSON_STEM = VANILLA_BLOCKS.register("crimson_stem", () -> log(MaterialColor.COLOR_RED, MaterialColor.STONE));
//    public static final RegistryObject<RotatedPillarBlock> WARPED_STEM = VANILLA_BLOCKS.register("warped_stem", () -> log(MaterialColor.COLOR_BLUE, MaterialColor.STONE));
//

//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_OAK_LOG = VANILLA_BLOCKS.register("stripped_oak_log", () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SPRUCE_LOG = VANILLA_BLOCKS.register("stripped_spruce_log",() ->  log(MaterialColor.PODZOL, MaterialColor.PODZOL));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BIRCH_LOG = VANILLA_BLOCKS.register("stripped_birch_log",() ->  log(MaterialColor.SAND, MaterialColor.SAND));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_JUNGLE_LOG = VANILLA_BLOCKS.register("stripped_jungle_log", () -> log(MaterialColor.DIRT, MaterialColor.DIRT));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ACACIA_LOG = VANILLA_BLOCKS.register("stripped_acacia_log", () -> log(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DARK_OAK_LOG = VANILLA_BLOCKS.register("stripped_dark_oak_log",() ->  log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));

//    public static final RegistryObject<GravelBlock> DIRT = VANILLA_BLOCKS.register("dirt",  () -> new GravelBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
//            .strength(0.5F)
//            .sound(SoundType.GRAVEL)
//            .requiresCorrectToolForDrops()));
//
//    public static final RegistryObject<GrassGravityBlock> GRASS_BLOCK = VANILLA_BLOCKS.register("grass_block",  () -> new GrassGravityBlock(BlockBehaviour.Properties.of(Material.GRASS)
//            .randomTicks().strength(0.6F)
//            .sound(SoundType.GRASS)
//            .requiresCorrectToolForDrops()));


    /*Workstations*/
//    public static final RegistryObject<GrindstoneBlock> GRINDSTONE = registerBlock("grindstone",
//            GrindstoneBlock::new, new Item.Properties());
//
//
//    public static final RegistryObject<FoundryBlock> FOUNDRY = registerBlock("foundry",
//            () -> new FoundryBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)), new Item.Properties());
//
//    public static final RegistryObject<KilnBlock> KILN = registerBlock("kiln",
//            () -> new KilnBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)), new Item.Properties());
//
//
//    public static final RegistryObject<FlintStationBlock> FLINT_STATION = registerBlock("flint_station",
//            FlintStationBlock::new, new Item.Properties());

//
//    public static final RegistryObject<ModCampfireBlock> CAMPFIRE = VANILLA_BLOCKS.register("campfire",
//            () -> new ModCampfireBlock(true, 1));

//    public static final RegistryObject<ModCampfireBlock> CAMPFIRE = registerBlock("campfire",
//            () -> new ModCampfireBlock(true, 1, BlockBehaviour.Properties.copy(Blocks.CAMPFIRE)), new Item.Properties());
//
//    public static final RegistryObject<ModTorchBlock> TORCH = registerBlock("torch",
//            () -> new ModTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION)
//                    .noCollission()
//                    .instabreak()
//                    .lightLevel(litBlockEmission(15))), new Item.Properties());
//





    /*Vanilla modifiers*/
//
//    public static final RegistryObject<RotatedPillarBlock> OAK_LOG = VANILLA_BLOCKS.register("oak_log", () -> log(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> SPRUCE_LOG = VANILLA_BLOCKS.register("spruce_log", () -> log(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> BIRCH_LOG = VANILLA_BLOCKS.register("birch_log", () -> log(MaterialColor.SAND, MaterialColor.QUARTZ));
//    public static final RegistryObject<RotatedPillarBlock> JUNGLE_LOG = VANILLA_BLOCKS.register("jungle_log", () -> log(MaterialColor.DIRT, MaterialColor.PODZOL));
//    public static final RegistryObject<RotatedPillarBlock> ACACIA_LOG = VANILLA_BLOCKS.register("acacia_log", () -> log(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
//    public static final RegistryObject<RotatedPillarBlock> DARK_OAK_LOG = VANILLA_BLOCKS.register("dark_oak_log",() ->  log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> MANGROVE_LOG = VANILLA_BLOCKS.register("mangrove_log", () -> log(MaterialColor.COLOR_BROWN, MaterialColor.STONE));
//    public static final RegistryObject<RotatedPillarBlock> CRIMSON_STEM = VANILLA_BLOCKS.register("crimson_stem", () -> log(MaterialColor.COLOR_RED, MaterialColor.STONE));
//    public static final RegistryObject<RotatedPillarBlock> WARPED_STEM = VANILLA_BLOCKS.register("warped_stem", () -> log(MaterialColor.COLOR_BLUE, MaterialColor.STONE));
//
//
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_OAK_LOG = VANILLA_BLOCKS.register("stripped_oak_log", () -> log(MaterialColor.WOOD, MaterialColor.WOOD));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SPRUCE_LOG = VANILLA_BLOCKS.register("stripped_spruce_log",() ->  log(MaterialColor.PODZOL, MaterialColor.PODZOL));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BIRCH_LOG = VANILLA_BLOCKS.register("stripped_birch_log",() ->  log(MaterialColor.SAND, MaterialColor.SAND));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_JUNGLE_LOG = VANILLA_BLOCKS.register("stripped_jungle_log", () -> log(MaterialColor.DIRT, MaterialColor.DIRT));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ACACIA_LOG = VANILLA_BLOCKS.register("stripped_acacia_log", () -> log(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DARK_OAK_LOG = VANILLA_BLOCKS.register("stripped_dark_oak_log",() ->  log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));
//
//    public static final RegistryObject<GravelBlock> DIRT = VANILLA_BLOCKS.register("dirt",  () -> new GravelBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT)
//            .strength(0.5F)
//            .sound(SoundType.GRAVEL)
//            .requiresCorrectToolForDrops()));
//
//    public static final RegistryObject<GrassGravityBlock> GRASS_BLOCK = VANILLA_BLOCKS.register("grass_block",  () -> new GrassGravityBlock(BlockBehaviour.Properties.of(Material.GRASS)
//            .randomTicks().strength(0.6F)
//            .sound(SoundType.GRASS)
//            .requiresCorrectToolForDrops()));








    /*Helpers*/
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties) {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, itemProperties);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties itemProperties) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }

    private static Boolean never(BlockState state, BlockGetter block, BlockPos pos, EntityType<?> type) {
        return (boolean)false;
    }

    private static Boolean always(BlockState state, BlockGetter block, BlockPos pos, EntityType<?> type) {
        return (boolean)true;
    }

//    private static RotatedPillarBlock log(MaterialColor pTopColor, MaterialColor pBarkColor) {
//        return  new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (rotation) -> {
//            return rotation.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ?  pTopColor: pBarkColor;
//        }).strength(2.0F).sound(SoundType.WOOD).requiresCorrectToolForDrops());
//    }


    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }


}
