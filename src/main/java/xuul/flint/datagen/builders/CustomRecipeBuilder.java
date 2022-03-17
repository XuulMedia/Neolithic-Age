package xuul.flint.datagen.builders;

import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import xuul.flint.common.recipe.ClayShapingRecipe;
import xuul.flint.common.recipe.FlintStationRecipe;

public class CustomRecipeBuilder extends SingleItemRecipeBuilder {
    public CustomRecipeBuilder(RecipeSerializer<?> pType, Ingredient pIngredient, ItemLike pResult, int pCount) {
        super(pType, pIngredient, pResult, pCount);
    }

    public static SingleItemRecipeBuilder flintstation(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(FlintStationRecipe.SERIALIZER, pIngredient, pResult, pCount);
    }

    public static SingleItemRecipeBuilder clay(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(ClayShapingRecipe.SERIALIZER, pIngredient, pResult, pCount);
    }
}