package xuul.flint.common.init;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import xuul.flint.Flint;
import xuul.flint.common.block.FlintStationBlock;
//import com.xuul.flint.block.FlintStationContainer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xuul.flint.common.block.KilnBlock;
import xuul.flint.common.block.ThatchBlock;
import xuul.flint.common.block.block_entity.KilnBE;

public class ModBlocks {
    private ModBlocks(){

    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Flint.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Flint.MOD_ID);



//Blocks
    public static final RegistryObject<Block> ORE_TIN = BLOCKS.register("ore_tin", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
        .requiresCorrectToolForDrops()
        .strength(3.0f,3.0f)
        .sound(SoundType.STONE)));

    public static final RegistryObject<Block> ORE_SILVER = BLOCKS.register("ore_nether_silver", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .strength(3.0f,3.0f)
            .sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block> BLOCK_TIN = BLOCKS.register("block_tin", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.METAL)));

    public static final RegistryObject<Block> BLOCK_SILVER = BLOCKS.register("block_silver", () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())));
    public static final RegistryObject<Block> BLOCK_BRONZE = BLOCKS.register("block_bronze", () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())));
    public static final RegistryObject<Block> BLOCK_STEEL = BLOCKS.register("block_steel", () -> new Block(BlockBehaviour.Properties.copy(BLOCK_TIN.get())));

    /*Stone*/

    public static final RegistryObject<FallingBlock> COBBLESTONE = BLOCKS.register("cobblestone", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .strength(2.0f,2.0f)
            .isValidSpawn(Blocks::never)
            .sound(SoundType.GRAVEL)));

    public static final RegistryObject<FallingBlock> BASALT_COBBLESTONE = BLOCKS.register("basalt_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> DEEPSLATE_COBBLESTONE = BLOCKS.register("deepslate_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> NETHERRACK_COBBLESTONE = BLOCKS.register("netherrack_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> SANDSTONE_COBBLESTONE = BLOCKS.register("sandstone_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> BLACKSTONE_COBBLESTONE = BLOCKS.register("blackstone_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> ENDSTONE_COBBLESTONE = BLOCKS.register("endstone_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> GRANITE_COBBLESTONE = BLOCKS.register("granite_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> TUFF_COBBLESTONE = BLOCKS.register("tuff_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> ANDESITE_COBBLESTONE = BLOCKS.register("andesite_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> DIORITE_COBBLESTONE = BLOCKS.register("diorite_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));

    public static final RegistryObject<FallingBlock> CALCITE_COBBLESTONE = BLOCKS.register("calcite_cobblestone",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.COBBLESTONE.get())));


    /*Stone Brick*/
    public static final RegistryObject<FallingBlock> STONE_BRICK_BLOCK = BLOCKS.register("stone_brick_block", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)
            .isValidSpawn(Blocks::never)
            .sound(SoundType.STONE)));

    public static final RegistryObject<FallingBlock> BASALT_BRICK_BLOCK = BLOCKS.register("basalt_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> DEEPSLATE_BRICK_BLOCK = BLOCKS.register("deepslate_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> NETHERRACK_BRICK_BLOCK = BLOCKS.register("netherrack_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> SANDSTONE_BRICK_BLOCK = BLOCKS.register("sandstone_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> BLACKSTONE_BRICK_BLOCK = BLOCKS.register("blackstone_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> ENDSTONE_BRICK_BLOCK = BLOCKS.register("endstone_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> GRANITE_BRICK_BLOCK = BLOCKS.register("granite_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> TUFF_BRICK_BLOCK = BLOCKS.register("tuff_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> ANDESITE_BRICK_BLOCK = BLOCKS.register("andesite_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> DIORITE_BRICK_BLOCK = BLOCKS.register("diorite_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));

    public static final RegistryObject<FallingBlock> CALCITE_BRICK_BLOCK = BLOCKS.register("calcite_brick_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(ModBlocks.STONE_BRICK_BLOCK.get())));




    /*Plants*/
    public static final RegistryObject<ThatchBlock>THATCH = BLOCKS.register("thatch_block",
            () -> new ThatchBlock(BlockBehaviour.Properties.of(Material.GRASS).noCollission().strength(4.0F)));




    /*FlintStation*/
    public static final RegistryObject<FlintStationBlock> FLINT_STATION = BLOCKS.register("flint_station", FlintStationBlock::new);

//    public static final RegistryObject<KilnBlock> KILN_BLOCK = BLOCKS.register("kiln", KilnBlock::new);
//
//
//
//    /*BLOCK ENTTIES*/
//    public static final RegistryObject<BlockEntity<KilnBE>> KILN_BE = BLOCK_ENTITIES.register("kiln",
//            () -> BlockEntityType.Builder.of(KilnBE::new, KILN_BLOCK.get());
}