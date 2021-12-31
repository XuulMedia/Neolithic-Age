package com.xuul.flint.init;

import com.xuul.flint.Flint;
import com.xuul.flint.block.GrindStone;
import com.xuul.flint.block.GrindStoneBE;
import com.xuul.flint.block.GrindStoneContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    private ModBlocks(){

    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Flint.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Flint.MOD_ID);
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Flint.MOD_ID);


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



    /*Grindstone*/
    public static final RegistryObject<GrindStone> GRINDSTONE = BLOCKS.register("grindstone", GrindStone::new);
    public static final RegistryObject<BlockEntityType<GrindStoneBE>> GRINDSTONE_BE =
            BLOCK_ENTITIES.register("grindstone", () -> BlockEntityType.Builder.of(GrindStoneBE::new, GRINDSTONE.get()).build(null));
    public static final RegistryObject<MenuType<GrindStoneContainer>> GRINDSTONE_CONTAINER = CONTAINERS.register("powergen",
            () -> IForgeMenuType.create((windowId, inv, data) -> new GrindStoneContainer(windowId, data.readBlockPos(), inv, inv.player)));

}


