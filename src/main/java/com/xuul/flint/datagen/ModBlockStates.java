package com.xuul.flint.datagen;

import com.xuul.flint.Flint;
import com.xuul.flint.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModBlockStates extends BlockStateProvider {

    public ModBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Flint.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ORE_TIN.get());
        simpleBlock(ModBlocks.ORE_SILVER.get());

//        simpleBlock(ModBlocks.COBBLESTONE.get());
//        simpleBlock(ModBlocks.BASALT_COBBLESTONE.get());
//        simpleBlock(ModBlocks.DEEPSLATE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.NETHERRACK_COBBLESTONE.get());
//        simpleBlock(ModBlocks.SANDSTONE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.BLACKSTONE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.ENDSTONE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.GRANITE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.TUFF_COBBLESTONE.get());
//        simpleBlock(ModBlocks.ANDESITE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.DIORITE_COBBLESTONE.get());
//        simpleBlock(ModBlocks.CALCITE_COBBLESTONE.get());
//
        simpleBlock(ModBlocks.BLOCK_TIN.get());
        simpleBlock(ModBlocks.BLOCK_SILVER.get());
        simpleBlock(ModBlocks.BLOCK_BRONZE.get());
        simpleBlock(ModBlocks.BLOCK_STEEL.get());

    }
}
