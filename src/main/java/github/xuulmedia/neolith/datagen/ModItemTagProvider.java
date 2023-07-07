package github.xuulmedia.neolith.datagen;


import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModItems;
import github.xuulmedia.neolith.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.PackOutput;


import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tagLookup, Neolith.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(Tags.Items.INGOTS)
                .add(ModItems.INGOT_TIN.get())
                .add(ModItems.INGOT_BRONZE.get())
                .add(ModItems.INGOT_SILVER.get())
                .add(ModItems.INGOT_STEEL.get());

        tag(ModTags.BINDINGS)
                .add(ModItems.BRAIDED_PLANT_FIBRE.get())
                .add(Items.STRING);

        tag(ModTags.PLANT_FIBRE)
                .add(ModItems.PLANT_FIBRE.get())
                .add(Items.VINE)
                .add(Items.TWISTING_VINES)
                .add(Items.WEEPING_VINES);

        tag(ModTags.HAMMERS)
                .add(ModItems.STONE_HAMMER.get())
                .add(ModItems.BRONZE_HAMMER.get());

        tag(ModTags.SAWS)
                .add(ModItems.FLINT_SAW.get())
                .add(ModItems.BRONZE_SAW.get());

        tag(ModTags.KNIVES)
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.BRONZE_KNIFE.get());

        tag(ModTags.SHOVELS)
                .add(ModItems.FLINT_SHOVEL.get())
                .add(ModItems.BRONZE_SHOVEL.get());



        tag(ModTags.LOGS)
                .add(ModItems.LOG_OAK.get())
                .add(ModItems.LOG_SPRUCE.get())
                .add(ModItems.LOG_BIRCH.get())
                .add(ModItems.LOG_JUNGLE.get())
                .add(ModItems.LOG_ACACIA.get())
                .add(ModItems.LOG_DARK_OAK.get())
                .add(ModItems.LOG_MANGROVE.get())
                .add(ModItems.LOG_WARPED.get())
                .add(ModItems.LOG_CRIMSON.get());

        tag(ModTags.PLANKS)
                .add(ModItems.PLANK_OAK.get())
                .add(ModItems.PLANK_SPRUCE.get())
                .add(ModItems.PLANK_BIRCH.get())
                .add(ModItems.PLANK_JUNGLE.get())
                .add(ModItems.PLANK_ACACIA.get())
                .add(ModItems.PLANK_DARK_OAK.get())
                .add(ModItems.PLANK_MANGROVE.get())
                .add(ModItems.PLANK_WARPED.get())
                .add(ModItems.PLANK_CRIMSON.get());


        tag(ModTags.STONE_CHUNKS)
                .add(ModItems.CHUNK_ANDESITE.get())
                .add(ModItems.CHUNK_BASALT.get())
                .add(ModItems.CHUNK_BLACKSTONE.get())
                .add(ModItems.CHUNK_CALCITE.get())
                .add(ModItems.CHUNK_DEEPSLATE.get())
                .add(ModItems.CHUNK_DIORITE.get())
                .add(ModItems.CHUNK_DRIPSTONE.get())
                .add(ModItems.CHUNK_GRANITE.get())
                .add(ModItems.CHUNK_NETHERRACK.get())
                .add(ModItems.CHUNK_RED_SANDSTONE.get())
                .add(ModItems.CHUNK_SANDSTONE.get())
                .add(ModItems.CHUNK_STONE.get())
                .add(ModItems.CHUNK_TUFF.get())
                .add(ModItems.CHUNK_ENDSTONE.get());

        tag(ModTags.DUSTS_STONE)
                .add(ModItems.DUST_STONE.get())
                .add(ModItems.DUST_DEEPSLATE.get())
                .add(ModItems.DUST_NETHERRACK.get())
                .add(ModItems.DUST_ENDSTONE.get())
                .add(ModItems.DUST_BROWN.get())
                .add(ModItems.DUST_WHITE.get())
                .add(ModItems.DUST_BLACK.get())
                .add(ModItems.DUST_SAND.get())
                .add(ModItems.DUST_RED_SAND.get())
                .add(ModItems.DUST_TUFF.get());

        tag(ModTags.DUSTS_SANDS)
                .add(ModItems.DUST_SAND.get())
                .add(ModItems.DUST_RED_SAND.get())
                .add(ModItems.DUST_TUFF.get());

        tag(ModTags.CLAY)
                .add(ModItems.CLAY_STONE.get())
                .add(ModItems.CLAY_DEEPSLATE.get())
                .add(ModItems.CLAY_NETHERRACK.get())
                .add(ModItems.CLAY_ENDSTONE.get())
                .add(ModItems.CLAY_BROWN.get())
                .add(ModItems.CLAY_WHITE.get())
                .add(ModItems.CLAY_BLACK.get())
                .add(ModItems.CLAY_SAND.get())
                .add(ModItems.CLAY_RED_SAND.get())
                .add(Items.CLAY_BALL);

        tag(ModTags.BRICKS)
                .add(ModItems.BRICK_STONE.get())
                .add(ModItems.BRICK_DEEPSLATE.get())
                .add(ModItems.BRICK_NETHERRACK.get())
                .add(ModItems.BRICK_ENDSTONE.get())
                .add(ModItems.BRICK_BROWN.get())
                .add(ModItems.BRICK_WHITE.get())
                .add(ModItems.BRICK_BLACK.get())
                .add(ModItems.BRICK_SAND.get())
                .add(ModItems.BRICK_RED_SAND.get());

        tag(ModTags.COBBLESTONES)
                .add(ModBlocks.COBBLESTONE_ANDESITE.get().asItem())
                .add(ModBlocks.COBBLESTONE_BASALT.get().asItem())
                .add(ModBlocks.COBBLESTONE_BLACKSTONE.get().asItem())
                .add(ModBlocks.COBBLESTONE_CALCITE.get().asItem())
                .add(ModBlocks.COBBLESTONE_DEEPSLATE.get().asItem())
                .add(ModBlocks.COBBLESTONE_DIORITE.get().asItem())
                .add(ModBlocks.COBBLESTONE_DRIPSTONE.get().asItem())
                .add(ModBlocks.COBBLESTONE_GRANITE.get().asItem())
                .add(ModBlocks.COBBLESTONE_NETHERRACK.get().asItem())
                .add(ModBlocks.COBBLESTONE_RED_SANDSTONE.get().asItem())
                .add(ModBlocks.COBBLESTONE_SANDSTONE.get().asItem())
                .add(ModBlocks.COBBLESTONE_STONE.get().asItem())
                .add(ModBlocks.COBBLESTONE_TUFF.get().asItem())
                .add(ModBlocks.COBBLESTONE_ENDSTONE.get().asItem());

        tag(ModTags.BRICK_BLOCKS)
                .add(ModBlocks.STONE_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.DEEPSLATE_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.NETHERRACK_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.ENDSTONE_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.BROWN_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.WHITE_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.BLACK_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.SAND_BRICK_BLOCK.get().asItem())
                .add(ModBlocks.RED_SAND_BRICK_BLOCK.get().asItem());


        tag(ModTags.LIGHTERS)
                .add(ModItems.BASIC_FIRESTARTER.get())
                .add(Items.FLINT_AND_STEEL)
                .add(Items.CANDLE)
                .add(ModBlocks.TORCH.get().asItem());

        tag(ModTags.DOUSERS)
                .add(ModItems.FLINT_SHOVEL.get());



        tag(ModTags.LOW_HEAT_WOOD)
                .add(ModItems.LOG_ACACIA.get())
                .add(ModItems.LOG_JUNGLE.get())
                .add(ModItems.PLANK_ACACIA.get())
                .add(ModItems.PLANK_JUNGLE.get());

        tag(ModTags.MED_HEAT_WOOD)
                .add(ModItems.LOG_BIRCH.get())
                .add(ModItems.LOG_CHERRY.get())
                .add(ModItems.LOG_DARK_OAK.get())
                .add(ModItems.PLANK_BIRCH.get())
                .add(ModItems.PLANK_CHERRY.get())
                .add(ModItems.PLANK_DARK_OAK.get());

        tag(ModTags.HIGH_HEAT_WOOD)
                .add(ModItems.LOG_MANGROVE.get())
                .add(ModItems.LOG_OAK.get())
                .add(ModItems.PLANK_MANGROVE.get())
                .add(ModItems.PLANK_OAK.get());

        tag(ModTags.NETHER_HEAT_WOOD)
                .add(ModItems.LOG_WARPED.get())
                .add(ModItems.LOG_CRIMSON.get())
                .add(ModItems.PLANK_WARPED.get())
                .add(ModItems.PLANK_CRIMSON.get());


    }


}