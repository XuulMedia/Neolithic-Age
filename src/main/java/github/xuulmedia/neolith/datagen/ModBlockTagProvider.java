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

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
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
                .add(ModBlocks.COBBLESTONE.get())
                .add(ModBlocks.BASALT_COBBLESTONE.get())
                .add(ModBlocks.DEEPSLATE_COBBLESTONE.get())
                .add(ModBlocks.NETHERRACK_COBBLESTONE.get())
                .add(ModBlocks.SANDSTONE_COBBLESTONE.get())
                .add(ModBlocks.BLACKSTONE_COBBLESTONE.get())
                .add(ModBlocks.ENDSTONE_COBBLESTONE.get())
                .add(ModBlocks.GRANITE_COBBLESTONE.get())
                .add(ModBlocks.TUFF_COBBLESTONE.get())
                .add(ModBlocks.ANDESITE_COBBLESTONE.get())
                .add(ModBlocks.DIORITE_COBBLESTONE.get())
                .add(ModBlocks.CALCITE_COBBLESTONE.get())
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
                .add(ModBlocks.ORE_TIN.get())
                .add(ModBlocks.ORE_SILVER.get());
//
//        tag(BlockTags.CAMPFIRES)
//                .add(ModBlocks.CAMPFIRE.get());





        /*Harvest Levels*/

        tag(Tags.Blocks.NEEDS_WOOD_TOOL);

        tag(ModTags.NEEDS_FLINT_TOOL)
                .add(ModBlocks.ORE_TIN.get())
                .addTag(BlockTags.LOGS)
                .add(ModBlocks.ORE_CLAY.get())
                .add(ModBlocks.FLINT_STATION.get());

        tag(ModTags.NEEDS_BRONZE_TOOL)
                .addTag(BlockTags.IRON_ORES);


        tag(BlockTags.NEEDS_IRON_TOOL);

        tag(BlockTags.NEEDS_DIAMOND_TOOL);


        tag(BlockTags.MINEABLE_WITH_AXE);
        tag(BlockTags.MINEABLE_WITH_HOE);
        tag(BlockTags.MINEABLE_WITH_PICKAXE);
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ORE_CLAY.get());

        tag(Tags.Blocks.ORES)
                .add(ModBlocks.ORE_TIN.get());


    }




}

