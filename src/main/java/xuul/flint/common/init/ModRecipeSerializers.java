package xuul.flint.common.init;

import xuul.flint.Flint;
import xuul.flint.common.recipe.FlintStationRecipe;
import xuul.flint.common.recipe.ToolUseRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Flint.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> FLINT_STATION = RECIPES.register( "flint_station", () ->
            FlintStationRecipe.SERIALIZER);

    public static final RegistryObject<RecipeSerializer<?>> TOOL_USE_RECIPE = RECIPES.register( "tool_use", () ->
            ToolUseRecipe.SERIALIZER);


}
