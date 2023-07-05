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
                .add(ModItems.STONE_HAMMER.get());

        tag(ModTags.SAWS)
                .add(ModItems.FLINT_SAW.get());

        tag(ModTags.KNIVES)
                .add(ModItems.FLINT_KNIFE.get());

        tag(ModTags.SHOVELS)
                .add(ModItems.FLINT_SHOVEL.get());



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

//        tag(ModTags.STONE_DUSTS)
//                .add(ModItems.DUST_ANDESITE.get())
//                .add(ModItems.DUST_BASALT.get())
//                .add(ModItems.DUST_BLACKSTONE.get())
//                .add(ModItems.DUST_CALCITE.get())
//                .add(ModItems.DUST_DEEPSLATE.get())
//                .add(ModItems.DUST_DIORITE.get())
//                .add(ModItems.DUST_DRIPSTONE.get())
//                .add(ModItems.DUST_GRANITE.get())
//                .add(ModItems.DUST_NETHERRACK.get())
//                .add(ModItems.DUST_RED_SANDSTONE.get())
//                .add(ModItems.DUST_SANDSTONE.get())
//                .add(ModItems.DUST_STONE.get())
//                .add(ModItems.DUST_TUFF.get())
//                .add(ModItems.DUST_ENDSTONE.get());

        tag(ModTags.CLAY)
                .add(ModItems.CLAY_ANDESITE.get())
                .add(ModItems.CLAY_BASALT.get())
                .add(ModItems.CLAY_BLACKSTONE.get())
                .add(ModItems.CLAY_CALCITE.get())
                .add(ModItems.CLAY_DEEPSLATE.get())
                .add(ModItems.CLAY_DIORITE.get())
                .add(ModItems.CLAY_DRIPSTONE.get())
                .add(ModItems.CLAY_GRANITE.get())
                .add(ModItems.CLAY_NETHERRACK.get())
                .add(ModItems.CLAY_RED_SANDSTONE.get())
                .add(ModItems.CLAY_SANDSTONE.get())
                .add(ModItems.CLAY_STONE.get())
                .add(ModItems.CLAY_TUFF.get())
                .add(ModItems.CLAY_ENDSTONE.get())
                .add(Items.CLAY_BALL);

        tag(ModTags.BRICKS)
                .add(ModItems.BRICK_ANDESITE.get())
                .add(ModItems.BRICK_BASALT.get())
                .add(ModItems.BRICK_BLACKSTONE.get())
                .add(ModItems.BRICK_CALCITE.get())
                .add(ModItems.BRICK_DEEPSLATE.get())
                .add(ModItems.BRICK_DIORITE.get())
                .add(ModItems.BRICK_DRIPSTONE.get())
                .add(ModItems.BRICK_GRANITE.get())
                .add(ModItems.BRICK_NETHERRACK.get())
                .add(ModItems.BRICK_RED_SANDSTONE.get())
                .add(ModItems.BRICK_SANDSTONE.get())
                .add(ModItems.BRICK_STONE.get())
                .add(ModItems.BRICK_TUFF.get())
                .add(ModItems.BRICK_ENDSTONE.get());


        tag(ModTags.LIGHTERS)
                .add(ModItems.BASIC_FIRESTARTER.get())
                .add(Items.FLINT_AND_STEEL)
                .add(Items.CANDLE)
                .add(ModBlocks.TORCH.get().asItem());

        tag(ModTags.DOUSERS)
                .add(ModItems.FLINT_SHOVEL.get());


        tag(ModTags.DUSTS_STONE_OVERWORLD)
                .add(ModItems.DUST_ANDESITE.get())
                .add(ModItems.DUST_BASALT.get())
                .add(ModItems.DUST_BLACKSTONE.get())
                .add(ModItems.DUST_CALCITE.get())
                .add(ModItems.DUST_DEEPSLATE.get())
                .add(ModItems.DUST_DIORITE.get())
                .add(ModItems.DUST_DRIPSTONE.get())
                .add(ModItems.DUST_GRANITE.get())
                .add(ModItems.DUST_STONE.get())
                .add(ModItems.DUST_TUFF.get());


    }


}