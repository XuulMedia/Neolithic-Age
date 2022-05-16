package xuul.flint.common.init;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xuul.flint.Flint;
import xuul.flint.common.block.*;
import xuul.flint.common.block.GrindstoneBlock;

public class ModBlocks {
    private ModBlocks() {

    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Flint.MOD_ID);
//    public static final DeferredRegister<Block> CLASSIC_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");


    //Blocks
    public static final RegistryObject<FlintNodeBlock> FLINT_NODE = BLOCKS.register("flint_node",
            () -> new FlintNodeBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .instabreak()));


    public static final RegistryObject<Block> ORE_TIN = BLOCKS.register("ore_tin",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> ORE_SILVER = BLOCKS.register("ore_nether_silver",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block> BLOCK_TIN = BLOCKS.register("block_tin",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.METAL)));

    public static final RegistryObject<Block> BLOCK_SILVER = BLOCKS.register("block_silver",
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())));
    public static final RegistryObject<Block> BLOCK_BRONZE = BLOCKS.register("block_bronze",
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())));
    public static final RegistryObject<Block> BLOCK_STEEL = BLOCKS.register("block_steel",
            () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())));

    /*Stone*/

    public static final RegistryObject<GravelBlock> COBBLESTONE = BLOCKS.register("cobblestone",
            () -> new GravelBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0f, 2.0f)
                    .isValidSpawn(Blocks::never)
                    .sound(SoundType.STONE)
                    .color(MaterialColor.COLOR_GRAY)));

    public static final RegistryObject<GravelBlock> BASALT_COBBLESTONE = BLOCKS.register("basalt_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> DEEPSLATE_COBBLESTONE = BLOCKS.register("deepslate_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> NETHERRACK_COBBLESTONE = BLOCKS.register("netherrack_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> SANDSTONE_COBBLESTONE = BLOCKS.register("sandstone_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> BLACKSTONE_COBBLESTONE = BLOCKS.register("blackstone_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> ENDSTONE_COBBLESTONE = BLOCKS.register("endstone_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> GRANITE_COBBLESTONE = BLOCKS.register("granite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> TUFF_COBBLESTONE = BLOCKS.register("tuff_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> ANDESITE_COBBLESTONE = BLOCKS.register("andesite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> DIORITE_COBBLESTONE = BLOCKS.register("diorite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<GravelBlock> CALCITE_COBBLESTONE = BLOCKS.register("calcite_cobble",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));


    /*Stone Brick*/
    public static final RegistryObject<GravelBlock> STONE_BRICK_BLOCK = BLOCKS.register("stone_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
                    .isValidSpawn(Blocks::never)
                    .sound(SoundType.STONE)));

    public static final RegistryObject<GravelBlock> BASALT_BRICK_BLOCK = BLOCKS.register("basalt_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> DEEPSLATE_BRICK_BLOCK = BLOCKS.register("deepslate_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> NETHERRACK_BRICK_BLOCK = BLOCKS.register("netherrack_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> SANDSTONE_BRICK_BLOCK = BLOCKS.register("sandstone_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> BLACKSTONE_BRICK_BLOCK = BLOCKS.register("blackstone_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> ENDSTONE_BRICK_BLOCK = BLOCKS.register("endstone_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> GRANITE_BRICK_BLOCK = BLOCKS.register("granite_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> TUFF_BRICK_BLOCK = BLOCKS.register("tuff_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> ANDESITE_BRICK_BLOCK = BLOCKS.register("andesite_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> DIORITE_BRICK_BLOCK = BLOCKS.register("diorite_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<GravelBlock> CALCITE_BRICK_BLOCK = BLOCKS.register("calcite_brick_block",
            () -> new GravelBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));


    /*Plants*/
    public static final RegistryObject<ThatchBlock> THATCH = BLOCKS.register("thatch",
            () -> new ThatchBlock(BlockBehaviour.Properties.of(Material.GRASS).noCollission().strength(4.0F).sound(SoundType.GRASS)));

    /*Vanilla Log modifiers*/

//    public static final RegistryObject<RotatedPillarBlock> OAK_LOG = CLASSIC_BLOCKS.register("oak_log",
//            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (rotation) -> {
//                return rotation.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ?  MaterialColor.WOOD: MaterialColor.PODZOL;
//            }).strength(2.0F).sound(SoundType.WOOD).requiresCorrectToolForDrops()));
//
//
//    public static final RegistryObject<RotatedPillarBlock> SPRUCE_LOG = CLASSIC_BLOCKS.register("spruce_log", () -> log(MaterialColor.PODZOL, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> BIRCH_LOG = CLASSIC_BLOCKS.register("birch_log", () -> log(MaterialColor.SAND, MaterialColor.QUARTZ));
//    public static final RegistryObject<RotatedPillarBlock> JUNGLE_LOG = CLASSIC_BLOCKS.register("jungle_log", () -> log(MaterialColor.DIRT, MaterialColor.PODZOL));
//    public static final RegistryObject<RotatedPillarBlock> ACACIA_LOG = CLASSIC_BLOCKS.register("acacia_log", () -> log(MaterialColor.COLOR_ORANGE, MaterialColor.STONE));
//    public static final RegistryObject<RotatedPillarBlock> DARK_OAK_LOG = CLASSIC_BLOCKS.register("dark_oak_log",() ->  log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_SPRUCE_LOG = CLASSIC_BLOCKS.register("stripped_spruce_log",() ->  log(MaterialColor.PODZOL, MaterialColor.PODZOL));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_BIRCH_LOG = CLASSIC_BLOCKS.register("stripped_birch_log",() ->  log(MaterialColor.SAND, MaterialColor.SAND));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_JUNGLE_LOG = CLASSIC_BLOCKS.register("stripped_jungle_log", () -> log(MaterialColor.DIRT, MaterialColor.DIRT));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ACACIA_LOG = CLASSIC_BLOCKS.register("stripped_acacia_log", () -> log(MaterialColor.COLOR_ORANGE, MaterialColor.COLOR_ORANGE));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_DARK_OAK_LOG = CLASSIC_BLOCKS.register("stripped_dark_oak_log",() ->  log(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN));
//    public static final RegistryObject<RotatedPillarBlock> STRIPPED_OAK_LOG = CLASSIC_BLOCKS.register("stripped_oak_log", () -> log(MaterialColor.WOOD, MaterialColor.WOOD));


    /*FlintStation*/
    public static final RegistryObject<FlintStationBlock> FLINT_STATION = BLOCKS.register("flint_station",
            FlintStationBlock::new);


    public static final RegistryObject<GrindstoneBlock> GRINDSTONE = BLOCKS.register("grindstone",
            GrindstoneBlock::new);


    public static final RegistryObject<FoundryBlock> FOUNDRY = BLOCKS.register("foundry",
            () -> new FoundryBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE)));


    private static RotatedPillarBlock log(MaterialColor pTopColor, MaterialColor pBarkColor) {
        return  new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (rotation) -> {
            return rotation.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ?  pTopColor: pBarkColor;
        }).strength(2.0F).sound(SoundType.GRAVEL).requiresCorrectToolForDrops());
    }

    private static Block register(String pKey, Block pBlock) {
        return Registry.register(Registry.BLOCK, pKey, pBlock);
    }

}