package github.xuulmedia.neolith.datagen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, Neolith.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.stone_age." + Neolith.MODID, "Stone Age");
        add("itemGroup.metal_age." + Neolith.MODID, "Bronze Age");

        add("container.neolith.forge.heat", "%s degrees");
        add("container.neolith.forge.heat.target", "Fuel max temperature: %s degrees");
        add("container.neolith.forge.heat.too_cold", "Too cold! Requires %s degrees");
        add("fuel.no_shift", "Press SHIFT for info");

        add("container.flint_station", "Knapping");
//
        add(ModBlocks.FLINT_STATION.get(), "Flintknapping Station");
        add(ModBlocks.FOUNDRY.get(), "Foundry");


        add(ModItems.FLINT_KNIFE.get(), "Flint Knife");
        add(ModItems.FLINT_PICK.get(), "Flint Pick");
        add(ModItems.FLINT_SHOVEL.get(), "Flint Shovel");
        add(ModItems.FLINT_AXE.get(), "Flint Axe");
        add(ModItems.FLINT_HOE.get(), "Flint Hoe");
        add(ModItems.FLINT_SAW.get(), "Flint Saw");
        add(ModItems.STONE_HAMMER.get(), "Stone Hammer");
        add(ModItems.STONE_SPEAR.get(), "Flint Spear");
        add(ModItems.BASIC_FIRESTARTER.get(), "Firestarter");

        add(ModItems.HIDE_SMALL.get(), "Small Hide");
        add(ModItems.HIDE_MEDIUM.get(), "Medium Hide");
        add(ModItems.HIDE_LARGE.get(), "Large Hide");


        add(ModItems.FLINT_BLADE.get(), "Sharp Flint");
        add(ModItems.FLINT_PICK_HEAD.get(), "Flint Pickaxe Head");
        add(ModItems.FLINT_SHOVEL_HEAD.get(), "Flint Shovel Head");
        add(ModItems.FLINT_AXE_HEAD.get(), "Flint Axe Head");
        add(ModItems.FLINT_HOE_HEAD.get(), "Flint Hoe Head");
        add(ModItems.FLINT_SAW_HEAD.get(), "Flint Saw Head");

        add(ModItems.LOG_ACACIA.get(),"Acacia Log");
        add(ModItems.LOG_BIRCH.get(),"Birch Log");
        add(ModItems.LOG_CHERRY.get(),"Cherry Log");
        add(ModItems.LOG_DARK_OAK.get(),"Dark_oak Log");
        add(ModItems.LOG_JUNGLE.get(),"Jungle Log");
        add(ModItems.LOG_MANGROVE.get(),"Mangrove Log");
        add(ModItems.LOG_OAK.get(),"Oak Log");
        add(ModItems.LOG_SPRUCE.get(),"Spruce Log");
        add(ModItems.LOG_WARPED.get(),"Warped Log");
        add(ModItems.LOG_CRIMSON.get(),"Crimson Log");

        add(ModItems.PLANK_ACACIA.get(),"Acacia Plank");
        add(ModItems.PLANK_BIRCH.get(),"Birch Plank");
        add(ModItems.PLANK_CHERRY.get(),"Cherry Plank");
        add(ModItems.PLANK_DARK_OAK.get(),"Dark_oak Plank");
        add(ModItems.PLANK_JUNGLE.get(),"Jungle Plank");
        add(ModItems.PLANK_MANGROVE.get(),"Mangrove Plank");
        add(ModItems.PLANK_OAK.get(),"Oak Plank");
        add(ModItems.PLANK_SPRUCE.get(),"Spruce Plank");
        add(ModItems.PLANK_WARPED.get(),"Warped Plank");
        add(ModItems.PLANK_CRIMSON.get(),"Crimson Plank");

         add(ModBlocks.ORE_TIN.get(), "Tin Ore");
        add(ModBlocks.ORE_SILVER.get(), "Nether Silver Ore");
        add(ModBlocks.FLINT_NODE.get(), "Flint Nodule");

        add(ModItems.PLANT_FIBRE.get(), "Plant Fibre");
        add(ModItems.BRAIDED_PLANT_FIBRE.get(), "Braided Plant Fibre");
        add(ModBlocks.THATCH.get(), "Thatch");

        add(ModItems.WOOL.get(), "Wool");
        add(ModItems.YARN.get(), "Yarn");
        add(ModItems.SPINDLE.get(), "Spindle");

//        add(ModItems.MEDICINE_PLANT_SEEDS.get(), "Herbal Seed");
//        add(ModItems.MEDICINE_PLANT.get(), "Medical Herb");


//        add(ModItems.BASKET.get(), "Basket");


        add(ModItems.UNFIRED_CLAY_JUG.get(), "Unfired Jug");
        add(ModItems.UNFIRED_CLAY_BUCKET.get(), "Unfired Clay Bucket");
        add(ModItems.UNFIRED_CLAY_BOTTLE.get(), "Unfired Clay Bottle");
        add(ModItems.UNFIRED_CLAY_BOWL.get(), "Unfired Clay Bowl");

        add(ModItems.CLAY_VIAL.get(), "Clay Vial");
        add(ModItems.CLAY_BOWL.get(), "Clay Bowl");

        add(ModItems.BRONZE_SWORD.get(), "Bronze Sword");
        add(ModItems.BRONZE_PICK.get(), "Bronze Pick");
        add(ModItems.BRONZE_SHOVEL.get(), "Bronze Shovel");
        add(ModItems.BRONZE_AXE.get(), "Bronze Axe");
        add(ModItems.BRONZE_HOE.get(), "Bronze Hoe");
        add(ModItems.BRONZE_HELMET.get(), "Bronze Helmet");
        add(ModItems.BRONZE_CHEST.get(), "Bronze Chest");
        add(ModItems.BRONZE_LEGS.get(), "Bronze Legs");
        add(ModItems.BRONZE_BOOTS.get(), "Bronze Boots");


        add(ModItems.CHUNK_ANDESITE.get(), "Andesite Chunk");
        add(ModItems.CHUNK_BASALT.get(), "Basalt Chunk");
        add(ModItems.CHUNK_BLACKSTONE.get(), "Blackstone Chunk");
        add(ModItems.CHUNK_CALCITE.get(), "Calcite Chunk");
        add(ModItems.CHUNK_DEEPSLATE.get(), "Deepslate Chunk");
        add(ModItems.CHUNK_DIORITE.get(), "Diorite Chunk");
        add(ModItems.CHUNK_DRIPSTONE.get(), "Dripstone Chunk");
        add(ModItems.CHUNK_GRANITE.get(), "Granite Chunk");
        add(ModItems.CHUNK_NETHERRACK.get(), "Netherrack Chunk");
        add(ModItems.CHUNK_RED_SANDSTONE.get(), "Red_sandstone Chunk");
        add(ModItems.CHUNK_SANDSTONE.get(), "Sandstone Chunk");
        add(ModItems.CHUNK_STONE.get(), "Stone Chunk");
        add(ModItems.CHUNK_TUFF.get(), "Tuff Chunk");
        add(ModItems.CHUNK_ENDSTONE.get(), "Endstone Chunk");

        add(ModItems.DUST_ANDESITE.get(), "Andesite Dust");
        add(ModItems.DUST_BASALT.get(), "Basalt Dust");
        add(ModItems.DUST_BLACKSTONE.get(), "Blackstone Dust");
        add(ModItems.DUST_CALCITE.get(), "Calcite Dust");
        add(ModItems.DUST_DEEPSLATE.get(), "Deepslate Dust");
        add(ModItems.DUST_DIORITE.get(), "Diorite Dust");
        add(ModItems.DUST_DRIPSTONE.get(), "Dripstone Dust");
        add(ModItems.DUST_GRANITE.get(), "Granite Dust");
        add(ModItems.DUST_NETHERRACK.get(), "Netherrack Dust");
        add(ModItems.DUST_RED_SANDSTONE.get(), "Red_sandstone Dust");
        add(ModItems.DUST_SANDSTONE.get(), "Sandstone Dust");
        add(ModItems.DUST_STONE.get(), "Stone Dust");
        add(ModItems.DUST_TUFF.get(), "Tuff Dust");
        add(ModItems.DUST_ENDSTONE.get(), "Endstone Dust");

        add(ModItems.CLAY_ANDESITE.get(), "Andesite Clay");
        add(ModItems.CLAY_BASALT.get(), "Basalt Clay");
        add(ModItems.CLAY_BLACKSTONE.get(), "Blackstone Clay");
        add(ModItems.CLAY_CALCITE.get(), "Calcite Clay");
        add(ModItems.CLAY_DEEPSLATE.get(), "Deepslate Clay");
        add(ModItems.CLAY_DIORITE.get(), "Diorite Clay");
        add(ModItems.CLAY_DRIPSTONE.get(), "Dripstone Clay");
        add(ModItems.CLAY_GRANITE.get(), "Granite Clay");
        add(ModItems.CLAY_NETHERRACK.get(), "Netherrack Clay");
        add(ModItems.CLAY_RED_SANDSTONE.get(), "Red_sandstone Clay");
        add(ModItems.CLAY_SANDSTONE.get(), "Sandstone Clay");
        add(ModItems.CLAY_STONE.get(), "Stone Clay");
        add(ModItems.CLAY_TUFF.get(), "Tuff Clay");
        add(ModItems.CLAY_ENDSTONE.get(), "Endstone Clay");

        add(ModItems.BRICK_ANDESITE.get(), "Andesite Brick");
        add(ModItems.BRICK_BASALT.get(), "Basalt Brick");
        add(ModItems.BRICK_BLACKSTONE.get(), "Blackstone Brick");
        add(ModItems.BRICK_CALCITE.get(), "Calcite Brick");
        add(ModItems.BRICK_DEEPSLATE.get(), "Deepslate Brick");
        add(ModItems.BRICK_DIORITE.get(), "Diorite Brick");
        add(ModItems.BRICK_DRIPSTONE.get(), "Dripstone Brick");
        add(ModItems.BRICK_GRANITE.get(), "Granite Brick");
        add(ModItems.BRICK_NETHERRACK.get(), "Netherrack Brick");
        add(ModItems.BRICK_RED_SANDSTONE.get(), "Red_sandstone Brick");
        add(ModItems.BRICK_SANDSTONE.get(), "Sandstone Brick");
        add(ModItems.BRICK_STONE.get(), "Stone Brick");
        add(ModItems.BRICK_TUFF.get(), "Tuff Brick");
        add(ModItems.BRICK_ENDSTONE.get(), "Endstone Brick");



        add(ModBlocks.COBBLESTONE.get(), "Cobblestone");
        add(ModBlocks.BASALT_COBBLESTONE.get(), "Basalt Cobblestone");
        add(ModBlocks.DEEPSLATE_COBBLESTONE.get(), "Deepslate Cobblestone");
        add(ModBlocks.NETHERRACK_COBBLESTONE.get(), "Netherrack Cobblestone");
        add(ModBlocks.SANDSTONE_COBBLESTONE.get(), "Sandstone Cobblestone");
        add(ModBlocks.BLACKSTONE_COBBLESTONE.get(), "Blackstone Cobblestone");
        add(ModBlocks.ENDSTONE_COBBLESTONE.get(), "Endstone Cobblestone");
        add(ModBlocks.GRANITE_COBBLESTONE.get(), "Granite Cobblestone");
        add(ModBlocks.TUFF_COBBLESTONE.get(), "Tuff Cobblestone");
        add(ModBlocks.ANDESITE_COBBLESTONE.get(), "Andesite Cobblestone");
        add(ModBlocks.DIORITE_COBBLESTONE.get(), "Diorite Cobblestone");
        add(ModBlocks.CALCITE_COBBLESTONE.get(), "Calcite Cobblestone");

        add(ModBlocks.BASALT_BRICK_BLOCK.get(), "Basalt Bricks");
        add(ModBlocks.DEEPSLATE_BRICK_BLOCK.get(), "Deepslate Bricks");
        add(ModBlocks.NETHERRACK_BRICK_BLOCK.get(), "Netherrack Bricks");
        add(ModBlocks.SANDSTONE_BRICK_BLOCK.get(), "Sandstone Bricks");
        add(ModBlocks.BLACKSTONE_BRICK_BLOCK.get(), "Blackstone Bricks");
        add(ModBlocks.ENDSTONE_BRICK_BLOCK.get(), "Endstone Bricks");
        add(ModBlocks.GRANITE_BRICK_BLOCK.get(), "Granite Bricks");
        add(ModBlocks.TUFF_BRICK_BLOCK.get(), "Tuff Bricks");
        add(ModBlocks.ANDESITE_BRICK_BLOCK.get(), "Andesite Bricks");
        add(ModBlocks.DIORITE_BRICK_BLOCK.get(), "Diorite Bricks");
        add(ModBlocks.CALCITE_BRICK_BLOCK.get(), "Calcite Bricks");

        add(ModBlocks.BLOCK_TIN.get(), "Tin Block");
        add(ModBlocks.BLOCK_SILVER.get(), "Silver Block");
        add(ModBlocks.BLOCK_BRONZE.get(), "Bronze Block");
        add(ModBlocks.BLOCK_STEEL.get(), "Steel Block");

        /*Show heatvalue on mouseover*/
        add("heat.level." + ModItems.LOG_ACACIA.get(), ModItems.LOG_ACACIA.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_BIRCH.get(), ModItems.LOG_BIRCH.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_CHERRY.get(), ModItems.LOG_CHERRY.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_DARK_OAK.get(), ModItems.LOG_DARK_OAK.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_JUNGLE.get(), ModItems.LOG_JUNGLE.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_MANGROVE.get(), ModItems.LOG_MANGROVE.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_OAK.get(), ModItems.LOG_OAK.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_SPRUCE.get(), ModItems.LOG_SPRUCE.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_WARPED.get(), ModItems.LOG_WARPED.get().getHeat() + " degrees");
        add("heat.level." + ModItems.LOG_CRIMSON.get(), ModItems.LOG_CRIMSON.get().getHeat() + " degrees");

        add("heat.level." + ModItems.PLANK_ACACIA.get(), ModItems.PLANK_ACACIA.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_BIRCH.get(), ModItems.PLANK_BIRCH.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_CHERRY.get(), ModItems.PLANK_CHERRY.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_DARK_OAK.get(), ModItems.PLANK_DARK_OAK.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_JUNGLE.get(), ModItems.PLANK_JUNGLE.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_MANGROVE.get(), ModItems.PLANK_MANGROVE.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_OAK.get(), ModItems.PLANK_OAK.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_SPRUCE.get(), ModItems.PLANK_SPRUCE.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_WARPED.get(), ModItems.PLANK_WARPED.get().getHeat() + " degrees");
        add("heat.level." + ModItems.PLANK_CRIMSON.get(), ModItems.PLANK_CRIMSON.get().getHeat() + " degrees");

        add(ModItems.INGOT_TIN.get(), "Tin Ingot");
        add(ModItems.INGOT_BRONZE.get(), "Bronze Ingot");
        add(ModItems.INGOT_SILVER.get(), "Silver Ingot");
        add(ModItems.INGOT_STEEL.get(), "Steel Ingot");

        add(ModItems.NUGGET_COPPER.get(), "Copper Nugget");
        add(ModItems.NUGGET_TIN.get(), "Tin Nugget");
        add(ModItems.NUGGET_BRONZE.get(), "Bronze Nugget");
        add(ModItems.NUGGET_SILVER.get(), "Silver Nugget");
        add(ModItems.NUGGET_STEEL.get(), "Steel Nugget");

        add(ModItems.DUST_IRON.get(), "Iron Dust");
        add(ModItems.DUST_GOLD.get(), "Gold Dust");
        add(ModItems.DUST_COPPER.get(), "Copper Dust");
        add(ModItems.DUST_TIN.get(), "Tin Dust");
        add(ModItems.DUST_BRONZE.get(), "Bronze Dust");
        add(ModItems.DUST_SILVER.get(), "Silver Dust");
        add(ModItems.DUST_STEEL.get(), "Steel Dust");




    }

}
