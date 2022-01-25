package xuul.flint.datagen;

import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import xuul.flint.common.recipe.FlintStationRecipe;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import xuul.flint.common.recipe.ToolUseRecipe;

public class CustomRecipeBuilder extends SingleItemRecipeBuilder {
    public CustomRecipeBuilder(RecipeSerializer<?> pType, Ingredient pIngredient, ItemLike pResult, int pCount) {
        super(pType, pIngredient, pResult, pCount);
    }

    public static SingleItemRecipeBuilder flintstation(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(FlintStationRecipe.SERIALIZER, pIngredient, pResult, pCount);
    }

//    public static ShapelessRecipeBuilder tooluse(Ingredient tool, NonNullList<Ingredient> ingredients, ItemLike result) {
//        return new ShapelessRecipeBuilder(ToolUseRecipe.SERIALIZER, result, tool, ingredients);
//    }


}
