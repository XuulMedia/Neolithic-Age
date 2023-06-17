package github.xuulmedia.neolith.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public abstract class AbstractHeatRecipe implements Recipe<Container> {
    protected final ResourceLocation id;
    private final RecipeCategory category;
    protected final String group;
    protected final int heatRequired;
    protected final NonNullList<Ingredient> ingredients;
    protected final NonNullList<ItemStack> results;
    protected final float experience;
    protected final int cookingTime;

    public AbstractHeatRecipe(ResourceLocation id, String group, int heatRequired, NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, float experience, int cookingTime) {
        this.id = id;
        this.category = RecipeCategory.MISC;
        this.group = group;
        this.heatRequired = heatRequired;
        this.ingredients = ingredients;
        this.results = results;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    public NonNullList<Ingredient> getIngredients() {return  this.ingredients; }
    public String getGroup() {
        return this.group;
    }

    public int getCookingHeat() {return this.heatRequired;  }
    public int getCookingTime() {
        return this.cookingTime;
    }

    public ResourceLocation getId() {
        return this.id;
    }


}
