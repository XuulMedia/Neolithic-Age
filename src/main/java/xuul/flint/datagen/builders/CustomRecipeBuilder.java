package xuul.flint.datagen.builders;

import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import xuul.flint.recipe.FlintStationRecipe;
import xuul.flint.recipe.GrindstoneRecipe;

public class CustomRecipeBuilder extends SingleItemRecipeBuilder {
    public CustomRecipeBuilder(RecipeSerializer<?> pType, Ingredient pIngredient, ItemLike pResult, int pCount) {
        super(pType, pIngredient, pResult, pCount);
    }

    public static SingleItemRecipeBuilder flintstation(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(FlintStationRecipe.SERIALIZER, pIngredient, pResult, pCount);
    }

    public static SingleItemRecipeBuilder grindstone(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(GrindstoneRecipe.SERIALIZER, pIngredient, pResult, pCount);
    }




}