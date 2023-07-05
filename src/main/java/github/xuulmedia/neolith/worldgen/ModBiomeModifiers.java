package github.xuulmedia.neolith.worldgen;

import github.xuulmedia.neolith.Neolith;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_FLINT_NODE = registerKey("add_flint_node");
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey("add_tin_ore");
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE_LARGE = registerKey("add_tin_ore_large");
    public static final ResourceKey<BiomeModifier> ADD_CLAY_ORE = registerKey("add_clay_ore");
    public static final ResourceKey<BiomeModifier> ADD_CLAY_ORE_LARGE = registerKey("add_clay_ore_large");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_SILVER_ORE = registerKey("add_nether_silver_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


        context.register(ADD_FLINT_NODE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.FLINT_PLACED_KEY)),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION));

        context.register(ADD_TIN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TIN_ORE_LARGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_LARDE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));





        context.register(ADD_CLAY_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CLAY_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


        context.register(ADD_CLAY_ORE_LARGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CLAY_ORE_LARGE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));



        context.register(ADD_NETHER_SILVER_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_SILVER_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));




    }
        private static ResourceKey<BiomeModifier> registerKey(String name) {
            return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Neolith.MODID, name));
        }
}
