package com.xuul.flint.init;

import com.xuul.flint.Flint;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.level.block.Blocks.IRON_ORE;

public class ModBlocks {
    private ModBlocks(){

    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Flint.MOD_ID);


//Blocks
    public static final RegistryObject<OreBlock> ORE_TIN = BLOCKS.register("ore_tin", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
        .requiresCorrectToolForDrops()
        .strength(3.0f,3.0f)
        .sound(SoundType.STONE)));

    public static final RegistryObject<OreBlock> ORE_SILVER = BLOCKS.register("ore_nether_silver", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .strength(3.0f,3.0f)
            .sound(SoundType.NETHER_ORE)));

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



    public static final RegistryObject<Block> BLOCK_TIN = BLOCKS.register("block_tin", () -> new Block(BlockBehaviour.Properties.copy(IRON_ORE)));
    public static final RegistryObject<Block> BLOCK_SILVER = BLOCKS.register("block_silver", () -> new Block(BlockBehaviour.Properties.copy(IRON_ORE)));
    public static final RegistryObject<Block> BLOCK_BRONZE = BLOCKS.register("block_bronze", () -> new Block(BlockBehaviour.Properties.copy(IRON_ORE)));
    public static final RegistryObject<Block> BLOCK_STEEL = BLOCKS.register("block_steel", () -> new Block(BlockBehaviour.Properties.copy(IRON_ORE)));

}


