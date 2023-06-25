package github.xuulmedia.neolith.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public abstract class AbstractNeolithItemCraft implements Recipe<Container> {
    protected final ResourceLocation id;
    protected final RecipeType<?> type;
    private final RecipeCategory category;
    protected final String group;

    protected final NonNullList<Ingredient> ingredients;
    protected final NonNullList<ItemStack> results;
    protected final float experience;

    public AbstractNeolithItemCraft(RecipeType<?> recipeType, ResourceLocation id, String group, NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, float experience) {
        this.id = id;
        this.type = recipeType;
        this.category = RecipeCategory.MISC;
        this.group = group;
        this.ingredients = ingredients;
        this.results = results;
        this.experience = experience;
    }
    
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    public NonNullList<Ingredient> getIngredients() {return  this.ingredients; }

    public String getGroup() {
        return this.group;
    }
    public ResourceLocation getId() {
        return this.id;
    }

    public boolean isSpecial() {
        return true;
    }
    protected static NonNullList<Ingredient> ingredientsFromJson(JsonArray pIngredientArray) {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        for(int i = 0; i < pIngredientArray.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(pIngredientArray.get(i), false);
            nonnulllist.add(ingredient);
        }
        if (nonnulllist.isEmpty()) {
            throw new JsonParseException("No ingredients for shapeless recipe");}
        return nonnulllist;
    }
    protected static NonNullList<ItemStack> resultsFromJson(JsonArray resultsArray) {
        NonNullList<ItemStack> outputArray = NonNullList.create();
        for(int i = 0; i < resultsArray.size(); ++i) {
            JsonElement resultElement = resultsArray.get(i);
            if(!(resultElement instanceof JsonObject resultObject)){
                throw new JsonParseException("results[" + i + "] was not a JsonObject");
            }
            ItemStack result = ShapedRecipe.itemStackFromJson(resultObject);
            outputArray.add(result);
        }
        return outputArray;
    }
}

