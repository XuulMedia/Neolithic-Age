package github.xuulmedia.neolith.datagen.builders;

import github.xuulmedia.neolith.init.ModRecipes;
import github.xuulmedia.neolith.recipe.FlintStationRecipe;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class CustomRecipeBuilder extends SingleItemRecipeBuilder {
    public CustomRecipeBuilder(RecipeSerializer<?> pType, RecipeSerializer serializer, Ingredient pIngredient, ItemLike pResult, int pCount) {
        super(RecipeCategory.MISC, pType, pIngredient, pResult, pCount);
    }

    public static SingleItemRecipeBuilder flintstation(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(RecipeCategory.MISC, ModRecipes.FLINT_STATION_SERIALIZER.get(), pIngredient, pResult, pCount);
    }





}