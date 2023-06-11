//package github.xuulmedia.neolith.datagen.builders;
//
//import github.xuulmedia.neolith.recipe.FlintStationRecipe;
//
//import net.minecraft.data.recipes.SingleItemRecipeBuilder;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.level.ItemLike;
//
//public class CustomRecipeBuilder extends SingleItemRecipeBuilder {
//    public CustomRecipeBuilder(RecipeSerializer<?> pType, RecipeSerializer serializer, Ingredient pIngredient, ItemLike pResult, int pCount) {
//        super(pType, pIngredient, pResult, pCount);
//    }
//
//    public static SingleItemRecipeBuilder flintstation(Ingredient pIngredient, ItemLike pResult, int pCount) {
//        return new SingleItemRecipeBuilder(FlintStationRecipe.Serializer.INSTANCE, pIngredient, pResult, pCount);
//    }
//
//
//
//
//
//}