package github.xuulmedia.neolith.datagen.builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import github.xuulmedia.neolith.init.ModRecipes;
import github.xuulmedia.neolith.recipe.AbstractHeatRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class HeatRecipeBuilder implements RecipeBuilder {
    protected final int heatRequired;
    protected final NonNullList<Ingredient> ingredients;
    protected final NonNullList<ItemStack> results;
    protected final float experience;
    protected final int cookingTime;
    private final Advancement.Builder advancement;
    @Nullable
    protected String group;
    private final RecipeSerializer<? extends AbstractHeatRecipe> serializer;


    public HeatRecipeBuilder(int heatRequired, NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, float experience, int cookingTime, RecipeSerializer<? extends AbstractHeatRecipe> serializer) {

        this.heatRequired = heatRequired;
        this.ingredients = ingredients;
        this.results = results;

        this.experience = experience;
        this.cookingTime = cookingTime;
        this.serializer = serializer;
        this.advancement = Advancement.Builder.advancement();
    }

    public static HeatRecipeBuilder forgeStationRecipe(NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, int heatRequired, float experience, int cookingTime){
        return new HeatRecipeBuilder(heatRequired, ingredients, results, experience, cookingTime, ModRecipes.FORGE_SERIZALIZER.get());
    }

    public static HeatRecipeBuilder foundryRecipe(NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, int heatRequired, float experience, int cookingTime){
        return new HeatRecipeBuilder(heatRequired, ingredients, results, experience, cookingTime, ModRecipes.FOUNDRY_SERIZALIZER.get());
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }


    @Override
    public Item getResult() {
        return this.results.get(0).getItem();
    }
    public NonNullList<ItemStack> getResultsList(){
        return this.results;
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);

        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT)
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new HeatRecipeBuilder.Result(
                pRecipeId,
                this.group == null ? "" : this.group,
                this.heatRequired,
                this.ingredients,
                this.results,
                this.experience,
                this.cookingTime,
                this.advancement,
                new ResourceLocation(pRecipeId.getNamespace(), "recipes/forge/" + pRecipeId.getPath()) ,
                this.serializer));
    }

    static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final CookingBookCategory category;
        private final int heatRequired;
        private final NonNullList<Ingredient> ingredients;
        private final NonNullList<ItemStack> results;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<? extends AbstractHeatRecipe> serializer;

        public Result(ResourceLocation id, String group, int heatRequired, NonNullList<Ingredient> ingredients,
                      NonNullList<ItemStack> results, float experience, int cookingTime, Advancement.Builder advancement, ResourceLocation advancementId, RecipeSerializer<? extends AbstractHeatRecipe> serializer) {
            this.id = id;
            this.group = group;
            this.category = CookingBookCategory.MISC;
            this.heatRequired = heatRequired;
            this.ingredients = ingredients;
            this.results = results;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.advancement = advancement;
            this.advancementId = advancementId;
            this.serializer = serializer;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty("category", this.category.getSerializedName());
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }
            json.addProperty("heatRequired", this.heatRequired);

            JsonArray ingredientsArray = new JsonArray();
            for(Ingredient ingredient : this.ingredients) {
                ingredientsArray.add(ingredient.toJson());
            }
            json.add("ingredients", ingredientsArray);

            JsonArray resultsArray = new JsonArray();
            for (ItemStack result : this.results) {{
                JsonObject results = new JsonObject();
                results.addProperty("item", BuiltInRegistries.ITEM.getKey(result.getItem()).toString());
                results.addProperty("count", result.getCount());
                resultsArray.add(results);
            }}
            json.add("results", resultsArray);

            json.addProperty("experience", this.experience);
            json.addProperty("cookingtime", this.cookingTime);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return this.serializer;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }



}
