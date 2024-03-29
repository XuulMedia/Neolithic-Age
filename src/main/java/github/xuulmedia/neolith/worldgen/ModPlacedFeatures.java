package github.xuulmedia.neolith.worldgen;

import github.xuulmedia.neolith.Neolith;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;


public class ModPlacedFeatures {


    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> TIN_ORE_LARDE_PLACED_KEY = registerKey("tin_ore_large_placed");
    public static final ResourceKey<PlacedFeature> CLAY_ORE_PLACED_KEY = registerKey("clay_ore_placed");
    public static final ResourceKey<PlacedFeature> CLAY_ORE_LARGE_PLACED_KEY = registerKey("clay_ore_large_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SILVER_ORE_PLACED_KEY = registerKey("nether_silver_ore_placed");


    public static final ResourceKey<PlacedFeature> FLINT_PLACED_KEY = registerKey("flint_node_placed");
    public static final ResourceKey<PlacedFeature> HEALING_HERB_PLACED_KEY = registerKey("healing_herb_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TIN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(2), VerticalAnchor.absolute(100))));


        register(context, TIN_ORE_LARDE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TIN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(2), VerticalAnchor.absolute(100))));



        register(context, CLAY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CLAY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(45), VerticalAnchor.absolute(112))));

        register(context, CLAY_ORE_LARGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CLAY_ORE_LARGE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(85), VerticalAnchor.top())));


        register(context, NETHER_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.top())));



        /*Surface*/

        register(context, FLINT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLINT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, HEALING_HERB_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HEALING_HERB_KEY),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    }

    //helpers
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Neolith.MODID, name));
    }
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
