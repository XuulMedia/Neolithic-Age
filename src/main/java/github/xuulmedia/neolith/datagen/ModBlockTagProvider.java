package github.xuulmedia.neolith.datagen;


import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Neolith.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ORE_TIN.get())
                .add(ModBlocks.ORE_SILVER.get())
                .add(ModBlocks.BLOCK_TIN.get())
                .add(ModBlocks.BLOCK_SILVER.get())
                .add(ModBlocks.BLOCK_BRONZE.get())
                .add(ModBlocks.BLOCK_STEEL.get())

                .add(ModBlocks.COBBLESTONE_ANDESITE.get())
                .add(ModBlocks.COBBLESTONE_BASALT.get())
                .add(ModBlocks.COBBLESTONE_BLACKSTONE.get())
                .add(ModBlocks.COBBLESTONE_CALCITE.get())
                .add(ModBlocks.COBBLESTONE_DEEPSLATE.get())
                .add(ModBlocks.COBBLESTONE_DIORITE.get())
                .add(ModBlocks.COBBLESTONE_DRIPSTONE.get())
                .add(ModBlocks.COBBLESTONE_GRANITE.get())
                .add(ModBlocks.COBBLESTONE_NETHERRACK.get())
                .add(ModBlocks.COBBLESTONE_RED_SANDSTONE.get())
                .add(ModBlocks.COBBLESTONE_SANDSTONE.get())
                .add(ModBlocks.COBBLESTONE_STONE.get())
                .add(ModBlocks.COBBLESTONE_TUFF.get())
                .add(ModBlocks.COBBLESTONE_ENDSTONE.get())
                .add(ModBlocks.STONE_BRICK_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_BRICK_BLOCK.get())
                .add(ModBlocks.NETHERRACK_BRICK_BLOCK.get())
                .add(ModBlocks.ENDSTONE_BRICK_BLOCK.get())
                .add(ModBlocks.BROWN_BRICK_BLOCK.get())
                .add(ModBlocks.WHITE_BRICK_BLOCK.get())
                .add(ModBlocks.BLACK_BRICK_BLOCK.get())
                .add(ModBlocks.SAND_BRICK_BLOCK.get())
                .add(ModBlocks.RED_SAND_BRICK_BLOCK.get())

                .add(ModBlocks.ORE_CLAY.get())
                .add(ModBlocks.FLINT_STATION.get());

        tag(ModTags.MINEABLE_WITH_HAMMER)
                .add(Blocks.ANDESITE)
                .add(Blocks.BASALT)
                .add(Blocks.BLACKSTONE)
                .add(Blocks.CALCITE)
                .add(Blocks.DEEPSLATE)
                .add(Blocks.DIORITE)
                .add(Blocks.DRIPSTONE_BLOCK)
                .add(Blocks.GRANITE)
                .add(Blocks.NETHERRACK)
                .add(Blocks.RED_SANDSTONE)
                .add(Blocks.SANDSTONE)
                .add(Blocks.STONE)
                .add(Blocks.TUFF)
                .add(Blocks.END_STONE)
                .add(ModBlocks.COBBLESTONE_ANDESITE.get())
                .add(ModBlocks.COBBLESTONE_BASALT.get())
                .add(ModBlocks.COBBLESTONE_BLACKSTONE.get())
                .add(ModBlocks.COBBLESTONE_CALCITE.get())
                .add(ModBlocks.COBBLESTONE_DEEPSLATE.get())
                .add(ModBlocks.COBBLESTONE_DIORITE.get())
                .add(ModBlocks.COBBLESTONE_DRIPSTONE.get())
                .add(ModBlocks.COBBLESTONE_GRANITE.get())
                .add(ModBlocks.COBBLESTONE_NETHERRACK.get())
                .add(ModBlocks.COBBLESTONE_RED_SANDSTONE.get())
                .add(ModBlocks.COBBLESTONE_SANDSTONE.get())
                .add(ModBlocks.COBBLESTONE_STONE.get())
                .add(ModBlocks.COBBLESTONE_TUFF.get())
                .add(ModBlocks.COBBLESTONE_ENDSTONE.get())
                .add(ModBlocks.ORE_TIN.get())
                .add(ModBlocks.ORE_SILVER.get());

//        tag(BlockTags.MINEABLE_WITH_AXE);
//        tag(BlockTags.MINEABLE_WITH_HOE);

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ORE_CLAY.get());



        /*Harvest Levels*/

        tag(BlockTags.NEEDS_STONE_TOOL)
                .remove(Blocks.COAL_ORE)
                .remove(Blocks.IRON_BLOCK)
                .remove(Blocks.RAW_IRON_BLOCK)
                .remove(Blocks.IRON_ORE)
                .remove(Blocks.DEEPSLATE_IRON_ORE)
                .remove(Blocks.LAPIS_BLOCK)
                .remove(Blocks.LAPIS_ORE)
                .remove(Blocks.DEEPSLATE_LAPIS_ORE)
                .remove(Blocks.COPPER_BLOCK)
                .remove(Blocks.RAW_COPPER_BLOCK)
                .remove(Blocks.COPPER_ORE)
                .remove(Blocks.DEEPSLATE_COPPER_ORE)
                .remove(Blocks.CUT_COPPER_SLAB)
                .remove(Blocks.CUT_COPPER_STAIRS)
                .remove(Blocks.CUT_COPPER)
                .remove(Blocks.WEATHERED_COPPER)
                .remove(Blocks.WEATHERED_CUT_COPPER_SLAB)
                .remove(Blocks.WEATHERED_CUT_COPPER_STAIRS)
                .remove(Blocks.WEATHERED_CUT_COPPER)
                .remove(Blocks.OXIDIZED_COPPER)
                .remove(Blocks.OXIDIZED_CUT_COPPER_SLAB)
                .remove(Blocks.OXIDIZED_CUT_COPPER_STAIRS)
                .remove(Blocks.OXIDIZED_CUT_COPPER)
                .remove(Blocks.EXPOSED_COPPER)
                .remove(Blocks.EXPOSED_CUT_COPPER_SLAB)
                .remove(Blocks.EXPOSED_CUT_COPPER_STAIRS)
                .remove(Blocks.EXPOSED_CUT_COPPER)
                .remove(Blocks.WAXED_COPPER_BLOCK)
                .remove(Blocks.WAXED_CUT_COPPER_SLAB)
                .remove(Blocks.WAXED_CUT_COPPER_STAIRS)
                .remove(Blocks.WAXED_CUT_COPPER)
                .remove(Blocks.WAXED_WEATHERED_COPPER)
                .remove(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB)
                .remove(Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS)
                .remove(Blocks.WAXED_WEATHERED_CUT_COPPER)
                .remove(Blocks.WAXED_EXPOSED_COPPER)
                .remove(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB)
                .remove(Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS)
                .remove(Blocks.WAXED_EXPOSED_CUT_COPPER)
                .remove(Blocks.WAXED_OXIDIZED_COPPER)
                .remove(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB)
                .remove(Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS)
                .remove(Blocks.WAXED_OXIDIZED_CUT_COPPER)
                .remove(Blocks.LIGHTNING_ROD);

        tag(ModTags.NEEDS_FLINT_TOOL)
                .add(ModBlocks.ORE_TIN.get())
                .add(Blocks.COPPER_ORE)
                .addTag(BlockTags.LOGS)
                .add(ModBlocks.ORE_CLAY.get())
                .add(ModBlocks.FLINT_STATION.get());

        tag(ModTags.NEEDS_BRONZE_TOOL)
                .addTag(BlockTags.IRON_ORES)
                .addTags(BlockTags.LAPIS_ORES)
                .add(Blocks.NETHER_QUARTZ_ORE)
                .add(Blocks.DEEPSLATE);


        tag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(BlockTags.GOLD_ORES)
                .addTag(BlockTags.REDSTONE_ORES)
                .addTag(BlockTags.COAL_ORES)
                .add(Blocks.NETHERRACK);

        tag(ModTags.NEEDS_STEEL_TOOL)
                .addTag(BlockTags.DIAMOND_ORES)
                .addTags(BlockTags.EMERALD_ORES)
                .add(ModBlocks.ORE_SILVER.get())
                .add(Blocks.END_STONE);


    }


}

