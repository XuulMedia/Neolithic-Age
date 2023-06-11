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
                .add(ModBlocks.CALCITE_COBBLESTONE.get());

        tag(ModTags.MINEABLE_WITH_HAMMER)
                .add(Blocks.STONE)
                .add(Blocks.STONE)
                .add(Blocks.ANDESITE)
                .add(Blocks.DEEPSLATE)
                .add(Blocks.SANDSTONE)
                .add(Blocks.DRIPSTONE_BLOCK)
                .add(Blocks.DIORITE)
                .add(Blocks.GRANITE)
                .add(Blocks.BASALT)
                .add(Blocks.TUFF)
                .add(Blocks.NETHERRACK)
                .add(Blocks.BLACKSTONE)
                .add(Blocks.CALCITE);
//
//        tag(BlockTags.CAMPFIRES)
//                .add(ModBlocks.CAMPFIRE.get());



        /*TODO create the tool tier for flint and stone*/


        /*Harvest Levels*/

        tag(Tags.Blocks.NEEDS_WOOD_TOOL);

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ORE_TIN.get())
                .addTag(BlockTags.LOGS);

        tag(BlockTags.NEEDS_IRON_TOOL);

        tag(BlockTags.NEEDS_DIAMOND_TOOL);


        tag(BlockTags.MINEABLE_WITH_AXE);
        tag(BlockTags.MINEABLE_WITH_HOE);
        tag(BlockTags.MINEABLE_WITH_PICKAXE);
        tag(BlockTags.MINEABLE_WITH_SHOVEL);

        tag(Tags.Blocks.ORES)
                .add(ModBlocks.ORE_TIN.get());


    }




}

