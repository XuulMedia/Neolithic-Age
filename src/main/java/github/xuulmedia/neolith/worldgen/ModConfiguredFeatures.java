package github.xuulmedia.neolith.worldgen;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.init.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {



    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TIN_ORE_KEY = registerKey("overworld_tin_ore_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TIN_ORE_LARGE_KEY = registerKey("overworld_tin_ore_large_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CLAY_ORE_KEY = registerKey("overworld_clay_ore_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CLAY_ORE_LARGE_KEY = registerKey("overworld_clay_ore_large_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SILVER_ORE_KEY = registerKey("nether_silver_ore_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLINT_KEY = registerKey("flint_node_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HEALING_HERB_KEY = registerKey("healing_herb_key");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceabeles = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceabeles = new BlockMatchTest(Blocks.END_STONE);


        register(context, OVERWORLD_TIN_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceabeles, ModBlocks.ORE_TIN.get().defaultBlockState(), 7));
        register(context, OVERWORLD_TIN_ORE_LARGE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceabeles, ModBlocks.ORE_TIN.get().defaultBlockState(), 16));

        register(context, OVERWORLD_CLAY_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceabeles, ModBlocks.ORE_CLAY.get().defaultBlockState(), 5));
        register(context, OVERWORLD_CLAY_ORE_LARGE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceabeles, ModBlocks.ORE_CLAY.get().defaultBlockState(), 18));

        register(context, NETHER_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceabeles, ModBlocks.ORE_SILVER.get().defaultBlockState(), 7));


        /*Surface*/
        register(context, FLINT_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(4, 2, 0, PlacementUtils.onlyWhenEmpty(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FLINT_NODE.get())))));

        register(context, HEALING_HERB_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(2, 1, 0, PlacementUtils.onlyWhenEmpty(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUE_ABRORE_CROP.get())))));
    }





    //helpers
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Neolith.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
