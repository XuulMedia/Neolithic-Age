package ca.xuul.flint.init;

import ca.xuul.flint.Flint;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ca.xuul.flint.recipe.FlintStationRecipe;
import ca.xuul.flint.recipe.FoundryFuelRecipe;
import ca.xuul.flint.recipe.FoundryRecipe;
import ca.xuul.flint.recipe.ToolUseRecipe;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(
        ForgeRegistries.RECIPE_SERIALIZERS, Flint.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> FLINT_STATION = RECIPES.register("flint_station", () ->
        FlintStationRecipe.SERIALIZER);

//    public static final RegistryObject<RecipeSerializer<?>> CLAY_SHAPING = RECIPES.register("slay_shaping", () ->
//        ClayShapingRecipe.SERIALIZER);

    public static final RegistryObject<RecipeSerializer<?>> TOOL_USE_RECIPE = RECIPES.register("tool_use", () ->
        ToolUseRecipe.SERIALIZER);

    public static final RegistryObject<RecipeSerializer<?>> FOUNDRY_RECIPE = RECIPES.register("foundry",
        () -> FoundryRecipe.SERIALIZER);
    public static final RegistryObject<RecipeSerializer<?>> FOUNDRY_FUEL_RECIPE = RECIPES.register("foundry_fuel",
        () -> FoundryFuelRecipe.SERIALIZER);


}