package github.xuulmedia.neolith.datagen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Neolith.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.PLANT_FIBRE.get());
        simpleItem(ModItems.BRAIDED_PLANT_FIBRE.get());
        handheldItem(ModItems.BASKET.get());

//        simpleItem(ModItems.WOOL.get());
//        simpleItem(ModItems.YARN.get());

        simpleItem(ModItems.INGOT_TIN.get(), "ingots");
        simpleItem(ModItems.INGOT_BRONZE.get(), "ingots");
        simpleItem(ModItems.INGOT_SILVER.get(), "ingots");
        simpleItem(ModItems.INGOT_STEEL.get(), "ingots");

        simpleItem(ModItems.HIDE_SMALL.get(), "hides");
        simpleItem(ModItems.HIDE_MEDIUM.get(), "hides");
        simpleItem(ModItems.HIDE_LARGE.get(), "hides");

        simpleItem(ModItems.NUGGET_TIN.get(), "nuggets");
        simpleItem(ModItems.NUGGET_COPPER.get(), "nuggets");
        simpleItem(ModItems.NUGGET_SILVER.get(), "nuggets");
        simpleItem(ModItems.NUGGET_BRONZE.get(), "nuggets");
        simpleItem(ModItems.NUGGET_STEEL.get(), "nuggets");

        simpleItem(ModItems.DUST_TIN.get(), "dusts");
        simpleItem(ModItems.DUST_COPPER.get(), "dusts");
        simpleItem(ModItems.DUST_SILVER.get(), "dusts");
        simpleItem(ModItems.DUST_BRONZE.get(), "dusts");
        simpleItem(ModItems.DUST_STEEL.get(), "dusts");
        simpleItem(ModItems.DUST_IRON.get(), "dusts");
        simpleItem(ModItems.DUST_GOLD.get(), "dusts");

        simpleItem(ModItems.LOG_OAK.get(), "logs");
        simpleItem(ModItems.LOG_SPRUCE.get(), "logs");
        simpleItem(ModItems.LOG_BIRCH.get(), "logs");
        simpleItem(ModItems.LOG_JUNGLE.get(), "logs");
        simpleItem(ModItems.LOG_ACACIA.get(), "logs");
        simpleItem(ModItems.LOG_DARK_OAK.get(), "logs");
        // simpleItem(ModItems.LOG_MANGROVE.get(), "logs");
        simpleItem(ModItems.LOG_WARPED.get(), "logs");
        simpleItem(ModItems.LOG_CRIMSON.get(), "logs");

        simpleItem(ModItems.PLANK_OAK.get(), "planks");
        simpleItem(ModItems.PLANK_SPRUCE.get(), "planks");
        simpleItem(ModItems.PLANK_BIRCH.get(), "planks");
        simpleItem(ModItems.PLANK_JUNGLE.get(), "planks");
        simpleItem(ModItems.PLANK_ACACIA.get(), "planks");
        simpleItem(ModItems.PLANK_DARK_OAK.get(), "planks");
        // simpleItem(ModItems.PLANK_MANGROVE.get(), "planks");
        simpleItem(ModItems.PLANK_CRIMSON.get(), "planks");
        simpleItem(ModItems.PLANK_WARPED.get(), "planks");

        simpleItem(ModItems.CHUNK_STONE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_ANDESITE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_DEEPSLATE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_DRIPSTONE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_DIORITE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_GRANITE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_BASALT.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_TUFF.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_NETHERRACK.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_BLACKSTONE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_CALCITE.get(), "stone/chunks");
        simpleItem(ModItems.CHUNK_SANDSTONE.get(), "stone/chunks");

        simpleItem(ModItems.DUST_STONE.get(), "stone/dusts");
        simpleItem(ModItems.DUST_ANDESITE.get(), "stone/dusts");
        simpleItem(ModItems.DUST_DEEPSLATE.get(), "stone/dusts");
//        simpleItem(ModItems.DUST_DRIPSTONE.get(), "stone/dusts");
        simpleItem(ModItems.DUST_DIORITE.get(), "stone/dusts");
        simpleItem(ModItems.DUST_GRANITE.get(), "stone/dusts");
        simpleItem(ModItems.DUST_BASALT.get(), "stone/dusts");
//        simpleItem(ModItems.DUST_TUFF.get(), "stone/dusts");
        simpleItem(ModItems.DUST_NETHERRACK.get(), "stone/dusts");
//        simpleItem(ModItems.DUST_BLACKSTONE.get(), "stone/dusts");
        simpleItem(ModItems.DUST_CALCITE.get(), "stone/dusts");
        simpleItem(ModItems.DUST_SANDSTONE.get(), "stone/dusts");

//        simpleItem(ModItems.CLAY_STONE.get(), "stone/clay");
//        simpleItem(ModItems.CLAY_ANDESITE.get(), "stone/clay");
//        simpleItem(ModItems.CLAY_DEEPSLATE.get(), "stone/clay");
//        simpleItem(ModItems.CLAY_DRIPSTONE.get(), "stone/clay");
//        simpleItem(ModItems.CLAY_DIORITE.get(), "stone/clay");
//        simpleItem(ModItems.CLAY_GRANITE.get(), "stone/clay");
//        simpleItem(ModItems.CLAY_BASALT.get(), "stone/clay");
//        simpleItem(ModItems.CLAY_TUFF.get(), "stone/clay");
        simpleItem(ModItems.CLAY_NETHERRACK.get(), "stone/clay");
        simpleItem(ModItems.CLAY_BLACKSTONE.get(), "stone/clay");
        simpleItem(ModItems.CLAY_CALCITE.get(), "stone/clay");
        simpleItem(ModItems.CLAY_SANDSTONE.get(), "stone/clay");

        simpleItem(ModItems.BRICK_STONE.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_ANDESITE.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_DEEPSLATE.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_DRIPSTONE.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_DIORITE.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_GRANITE.get(), "stone/bricks");
        simpleItem(ModItems.BRICK_BASALT.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_TUFF.get(), "stone/bricks");
        simpleItem(ModItems.BRICK_NETHERRACK.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_BLACKSTONE.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_CALCITE.get(), "stone/bricks");
//        simpleItem(ModItems.BRICK_SANDSTONE.get(), "stone/bricks");


//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.UNFIRED_CLAY_JUG.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/unfired_clay_jug"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.UNFIRED_CLAY_BUCKET.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/unfired_clay_bucket"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.UNFIRED_CLAY_VIAL.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/unfired_clay_vial"));
//
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.CLAY_VIAL.get()).getPath(),
//                mcLoc("item/generated"),"layer0", modLoc("item/clay_vial"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_SWORD.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_sword"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_PICK.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_pickaxe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_SHOVEL.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_shovel"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_AXE.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_axe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_HOE.get()).getPath(),
                mcLoc("item/handheld"), "layer0", modLoc("item/tools/bronze_hoe"));








        /*TODO setup layered texture*/
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_HELMET.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_helmet"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_CHEST.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_chest"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_LEGS.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_legs"));
//        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BRONZE_BOOTS.get()).getPath(),
//                mcLoc("item/generated"),
//                "layer0", modLoc("model/armor/bronze_boots"));
//


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_KNIFE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/flint_knife"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_PICK.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/flint_pickaxe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SHOVEL.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/flint_shovel"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_AXE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/flint_axe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_HOE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/flint_hoe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SAW.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/flint_saw"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.STONE_SPEAR.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/flint_spear"));

        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.STONE_HAMMER.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/stone_hammer"));

        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.BASIC_FIRESTARTER.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/firestarter"));


        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_BLADE.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/toolhead_flint_knife"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_PICK_HEAD.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/toolhead_flint_pickaxe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SHOVEL_HEAD.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/toolhead_flint_shovel"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_AXE_HEAD.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/toolhead_flint_axe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_HOE_HEAD.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/toolhead_flint_hoe"));
        singleTexture(ForgeRegistries.ITEMS.getKey(ModItems.FLINT_SAW_HEAD.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/tools/toolhead_flint_saw"));



        /*

         */
        /*complex blocks with manual json*//*

        withExistingParent(ForgeRegistries.BLOCKS.getKey(ModBlocks.FLINT_NODE.get()).getPath(), modLoc("block/flint_node"));
        withExistingParent(ForgeRegistries.BLOCKS.getKey(ModBlocks.FLINT_STATION.get()).getPath(), modLoc("block/flint_station"));
        withExistingParent(ForgeRegistries.BLOCKS.getKey(ModBlocks.FOUNDRY.get()).getPath(), modLoc("block/foundry"));
        withExistingParent(ForgeRegistries.BLOCKS.getKey(ModBlocks.THATCH.get()).getPath(), modLoc("block/thatch"));
*/

    }

    private ItemModelBuilder simpleItem(Item item) {
        String path = ForgeRegistries.ITEMS.getKey(item).getPath();
        return withExistingParent(path,
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Neolith.MODID,"item/" + path));
    }
    private ItemModelBuilder simpleItem(Item item, String folder) {
        String path = ForgeRegistries.ITEMS.getKey(item).getPath();
        return withExistingParent(path,
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Neolith.MODID,"item/" + folder+ "/" +path));
    }

    private ItemModelBuilder handheldItem(Item item) {
        String path = ForgeRegistries.ITEMS.getKey(item).getPath();

        return withExistingParent(path,
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Neolith.MODID,"item/" + path));
    }

    private ItemModelBuilder handheldItem(Item item, String folder) {
        String path = ForgeRegistries.ITEMS.getKey(item).getPath();

        return withExistingParent(path,
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Neolith.MODID,"item/" + folder + "/" + path));
    }




}
