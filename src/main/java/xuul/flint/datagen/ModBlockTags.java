package xuul.flint.datagen;

import xuul.flint.Flint;
import xuul.flint.common.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Flint.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
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





        /*TODO create the tool tier for flint and stone*/
       tag(BlockTags.NEEDS_STONE_TOOL)
               .add(ModBlocks.ORE_TIN.get()
               );



       tag(Tags.Blocks.NEEDS_WOOD_TOOL);

       tag(Tags.Blocks.ORES)
               .add(ModBlocks.ORE_TIN.get());


    }


}

