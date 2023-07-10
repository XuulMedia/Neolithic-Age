package github.xuulmedia.neolith.datagen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import github.xuulmedia.neolith.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.common.Mod;

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


        add(ModItems.FLINT_KNIFE.get(), "Flint Knife");
        add(ModItems.FLINT_PICK.get(), "Flint Pick");
        add(ModItems.FLINT_SHOVEL.get(), "Flint Shovel");
        add(ModItems.FLINT_AXE.get(), "Flint Axe");
        add(ModItems.FLINT_HOE.get(), "Flint Hoe");
        add(ModItems.FLINT_SAW.get(), "Flint Saw");
        add(ModItems.STONE_HAMMER.get(), "Stone Hammer");


        add(ModItems.BRONZE_KNIFE.get(), "Bronze Knife");
        add(ModItems.BRONZE_PICK.get(), "Bronze Pick");
        add(ModItems.BRONZE_SHOVEL.get(), "Bronze Shovel");
        add(ModItems.BRONZE_AXE.get(), "Bronze Axe");
        add(ModItems.BRONZE_HOE.get(), "Bronze Hoe");
        add(ModItems.BRONZE_SAW.get(), "Bronze Saw");
        add(ModItems.BRONZE_HAMMER.get(), "Bronze Hammer");
        add(ModItems.BRONZE_SWORD.get(), "Bronze Sword");


        add(ModItems.STONE_SPEAR.get(), "Flint Spear");
        add(ModItems.BASIC_FIRESTARTER.get(), "Firestarter");
        add(ModItems.SPINDLE.get(), "Spindle");

        add(ModItems.BASKET.get(), "Basket"); //hide pouch later

        add(ModItems.HIDE_SMALL.get(), "Small Hide");
        add(ModItems.HIDE_MEDIUM.get(), "Medium Hide");
        add(ModItems.HIDE_LARGE.get(), "Large Hide");

        add(ModItems.UNFIRED_CLAY_POT.get(), "Unfired Jug");
        add(ModItems.UNFIRED_CLAY_BUCKET.get(), "Unfired Clay Bucket");
        add(ModItems.UNFIRED_CLAY_BOTTLE.get(), "Unfired Clay Bottle");
        add(ModItems.UNFIRED_CLAY_BOWL.get(), "Unfired Clay Bowl");

        add(ModItems.CLAY_BUCKET.get(), "Clay Bucket");
        add(ModItems.CLAY_BOTTLE.get(), "Clay Vial");
        add(ModItems.CLAY_BOWL.get(), "Clay Bowl");

        add(ModItems.FLINT_BLADE.get(), "Flint Blade");
        add(ModItems.FLINT_PICK_HEAD.get(), "Flint Pick Head");
        add(ModItems.FLINT_SHOVEL_HEAD.get(), "Flint Shovel Head");
        add(ModItems.FLINT_AXE_HEAD.get(), "Flint Axe Head");
        add(ModItems.FLINT_HOE_HEAD.get(), "Flint Hoe Head");
        add(ModItems.FLINT_SAW_HEAD.get(), "Flint Saw Head");

        add(ModItems.BRONZE_HAMMER_HEAD.get(), "Bronze Hammer Head");

        add(ModItems.LOG_ACACIA.get(), "Acacia Log");
        add(ModItems.LOG_BIRCH.get(), "Birch Log");
        add(ModItems.LOG_CHERRY.get(), "Cherry Log");
        add(ModItems.LOG_DARK_OAK.get(), "Dark_oak Log");
        add(ModItems.LOG_JUNGLE.get(), "Jungle Log");
        add(ModItems.LOG_MANGROVE.get(), "Mangrove Log");
        add(ModItems.LOG_OAK.get(), "Oak Log");
        add(ModItems.LOG_SPRUCE.get(), "Spruce Log");
        add(ModItems.LOG_WARPED.get(), "Warped Log");
        add(ModItems.LOG_CRIMSON.get(), "Crimson Log");

        add(ModItems.PLANK_ACACIA.get(), "Acacia Plank");
        add(ModItems.PLANK_BIRCH.get(), "Birch Plank");
        add(ModItems.PLANK_CHERRY.get(), "Cherry Plank");
        add(ModItems.PLANK_DARK_OAK.get(), "Dark_oak Plank");
        add(ModItems.PLANK_JUNGLE.get(), "Jungle Plank");
        add(ModItems.PLANK_MANGROVE.get(), "Mangrove Plank");
        add(ModItems.PLANK_OAK.get(), "Oak Plank");
        add(ModItems.PLANK_SPRUCE.get(), "Spruce Plank");
        add(ModItems.PLANK_WARPED.get(), "Warped Plank");
        add(ModItems.PLANK_CRIMSON.get(), "Crimson Plank");

        add(ModItems.PLANT_FIBRE.get(), "Plant Fibre");
        add(ModItems.BRAIDED_PLANT_FIBRE.get(), "Braided Plant Fibre");

        add(ModItems.CHUNK_ANDESITE.get(), "Andesite Chunk");
        add(ModItems.CHUNK_BASALT.get(), "Basalt Chunk");
        add(ModItems.CHUNK_BLACKSTONE.get(), "Blackstone Chunk");
        add(ModItems.CHUNK_CALCITE.get(), "Calcite Chunk");
        add(ModItems.CHUNK_DEEPSLATE.get(), "Deepslate Chunk");
        add(ModItems.CHUNK_DIORITE.get(), "Diorite Chunk");
        add(ModItems.CHUNK_DRIPSTONE.get(), "Dripstone Chunk");
        add(ModItems.CHUNK_GRANITE.get(), "Granite Chunk");
        add(ModItems.CHUNK_NETHERRACK.get(), "Netherrack Chunk");
        add(ModItems.CHUNK_RED_SANDSTONE.get(), "Red Sand Chunk");
        add(ModItems.CHUNK_SANDSTONE.get(), "Sandstone Chunk");
        add(ModItems.CHUNK_STONE.get(), "Stone Chunk");
        add(ModItems.CHUNK_TUFF.get(), "Tuff Chunk");
        add(ModItems.CHUNK_ENDSTONE.get(), "Endstone Chunk");


        add(ModItems.DUST_STONE.get(), "Stone Dust");
        add(ModItems.DUST_DEEPSLATE.get(), "Deepslate Dust");
        add(ModItems.DUST_NETHERRACK.get(), "Netherrack Dust");
        add(ModItems.DUST_ENDSTONE.get(), "Endstone Dust");
        add(ModItems.DUST_BROWN.get(), "Brown Stone Dust");
        add(ModItems.DUST_WHITE.get(), "White Stone Dust");
        add(ModItems.DUST_BLACK.get(), "Black Stone Dust");
        add(ModItems.DUST_SAND.get(), "Sand");
        add(ModItems.DUST_RED_SAND.get(), "Red Sand");
        add(ModItems.DUST_TUFF.get(), "Tuff Ash");


        add(ModItems.CLAY_STONE.get(), "Stoney Clay");
        add(ModItems.CLAY_DEEPSLATE.get(), "Deepslate Clay");
        add(ModItems.CLAY_NETHERRACK.get(), "Netherrack Clay");
        add(ModItems.CLAY_ENDSTONE.get(), "Endstone Clay");
        add(ModItems.CLAY_BROWN.get(), "Brown Clay");
        add(ModItems.CLAY_WHITE.get(), "White Clay");
        add(ModItems.CLAY_BLACK.get(), "Black Clay");
        add(ModItems.CLAY_SAND.get(), "Sandy Clay");
        add(ModItems.CLAY_RED_SAND.get(), "Red Clay");

        add(ModItems.BRICK_STONE.get(), "Stone Brick");
        add(ModItems.BRICK_DEEPSLATE.get(), "Deepslate Brick");
        add(ModItems.BRICK_NETHERRACK.get(), "Netherrack Brick");
        add(ModItems.BRICK_ENDSTONE.get(), "Endstone Brick");
        add(ModItems.BRICK_BROWN.get(), "Brown Brick");
        add(ModItems.BRICK_WHITE.get(), "White Brick");
        add(ModItems.BRICK_BLACK.get(), "Black Brick");
        add(ModItems.BRICK_SAND.get(), "Sand Brick");
        add(ModItems.BRICK_RED_SAND.get(), "Red Brick");

        add(ModItems.WOOL.get(), "Wool");
        add(ModItems.YARN.get(), "Yarn");

        add(ModItems.BRONZE_HELMET.get(), "Bronze Helmet");
        add(ModItems.BRONZE_CHEST.get(), "Bronze Chest");
        add(ModItems.BRONZE_LEGS.get(), "Bronze Legs");
        add(ModItems.BRONZE_BOOTS.get(), "Bronze Boots");

        add(ModItems.RAW_TIN.get(), "Raw Tin");
        add(ModItems.RAW_SILVER.get(), "Raw Silver");

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
        add(ModItems.DUST_OBSIDIAN.get(), "Obsidian Blend");

        add(ModItems.JUTE_SEEDS.get(), "Jute Seeds");

        add(ModItems.SANDWICH.get(), "Sandwich");
        add(ModItems.SALAD.get(), "Salad");


        /*BLOCKS*/

        add(ModBlocks.ORE_TIN.get(), "Tin Ore");
        add(ModBlocks.ORE_SILVER.get(), "Nether Silver Ore");
        add(ModBlocks.ORE_CLAY.get(), "Clay Infused Stone");

        add(ModBlocks.BLOCK_TIN.get(), "Tin Block");
        add(ModBlocks.BLOCK_SILVER.get(), "Silver Block");
        add(ModBlocks.BLOCK_BRONZE.get(), "Bronze Block");
        add(ModBlocks.BLOCK_STEEL.get(), "Steel Block");

        add(ModBlocks.COBBLESTONE_ANDESITE.get(), "Andesite Cobblestone");
        add(ModBlocks.COBBLESTONE_BASALT.get(), "Basalt Cobblestone");
        add(ModBlocks.COBBLESTONE_BLACKSTONE.get(), "Blackstone Cobblestone");
        add(ModBlocks.COBBLESTONE_CALCITE.get(), "Calcite Cobblestone");
        add(ModBlocks.COBBLESTONE_DEEPSLATE.get(), "Deepslate Cobblestone");
        add(ModBlocks.COBBLESTONE_DIORITE.get(), "Diorite Cobblestone");
        add(ModBlocks.COBBLESTONE_DRIPSTONE.get(), "Dripstone Cobblestone");
        add(ModBlocks.COBBLESTONE_GRANITE.get(), "Granite Cobblestone");
        add(ModBlocks.COBBLESTONE_NETHERRACK.get(), "Netherrack Cobblestone");
        add(ModBlocks.COBBLESTONE_RED_SANDSTONE.get(), "Red Cobblestone");
        add(ModBlocks.COBBLESTONE_SANDSTONE.get(), "Sandy Cobblestone");
        add(ModBlocks.COBBLESTONE_STONE.get(), "Stone Cobblestone");
        add(ModBlocks.COBBLESTONE_TUFF.get(), "Tuff Cobblestone");
        add(ModBlocks.COBBLESTONE_ENDSTONE.get(), "Endstone Cobblestone");

        add(ModBlocks.STONE_BRICK_BLOCK.get(), "Stone Bricks");
        add(ModBlocks.DEEPSLATE_BRICK_BLOCK.get(), "Deepslate Bricks");
        add(ModBlocks.NETHERRACK_BRICK_BLOCK.get(), "Nether Bricks");
        add(ModBlocks.ENDSTONE_BRICK_BLOCK.get(), "Endstone Bricks");
        add(ModBlocks.BROWN_BRICK_BLOCK.get(), "Brown Bricks");
        add(ModBlocks.WHITE_BRICK_BLOCK.get(), "White Bricks");
        add(ModBlocks.BLACK_BRICK_BLOCK.get(), "Black Bricks");
        add(ModBlocks.SAND_BRICK_BLOCK.get(), "Sandy Bricks");
        add(ModBlocks.RED_SAND_BRICK_BLOCK.get(), "Red Bricks");

        add(ModBlocks.WARDED_GRASS_BLOCK.get(), "Warded Grass");

        add(ModBlocks.FLINT_NODE.get(), "Flint Nodule");

        add(ModBlocks.THATCH.get(), "Thatch");

        add(ModBlocks.FLINT_STATION.get(), "Flint");
        add(ModBlocks.FORGE.get(), "Forge");
        add(ModBlocks.FOUNDRY.get(), "Foundry");
        add(ModBlocks.CAMPFIRE.get(), "Campfire");
        add(ModBlocks.CLAY_POT.get(), "Clay Pot");


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


    }

}
