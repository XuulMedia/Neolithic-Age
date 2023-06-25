package github.xuulmedia.neolith.datagen.builders;

import github.xuulmedia.neolith.recipe.FoundryRecipe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class FoundryRecipieBuilder implements RecipeBuilder {
    public final NonNullList<Ingredient> inputs;
    public final NonNullList<ItemStack> outputs;
    public final int heat;

    private final Advancement.Builder advancement;
    @Nullable
    private String group;

    public FoundryRecipieBuilder(NonNullList<Ingredient> inputs, NonNullList<ItemStack> outputs, int heat) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.heat = heat;
        this.advancement = Advancement.Builder.advancement();

        if (!(1 <= inputs.size() && inputs.size() <= FoundryRecipe.MAX_INPUTS)) {
            throw new IllegalStateException("must have between 1 and 3 inputs to a kiln recipe but got " + inputs.size());
        }
        if (!(1 <= outputs.size() && outputs.size() <= FoundryRecipe.MAX_OUTPUTS)) {
            throw new IllegalStateException("must have between 1 and 2 outputs to a kiln recipe but got " + outputs.size());
        }
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
        return this.outputs.get(0).getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pRecipeId);
        }
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId))
                .requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new Result(
                pRecipeId,
                this.group == null ? "" : this.group,
                this.heat,
                this.inputs,
                this.outputs,
                this.advancement,
                new ResourceLocation(pRecipeId.getNamespace(), "recipes/kiln/" + pRecipeId.getPath())));

    }

    public static class Result implements FinishedRecipe {


        private final ResourceLocation id;
        private final String group;
        public final int heat;
        private final List<Ingredient> ingredients;
        public final NonNullList<ItemStack> results;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result( ResourceLocation id, String group, int heat, NonNullList<Ingredient> ingredients,
                      NonNullList<ItemStack> results, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.group = group;
            this.heat = heat;
            this.ingredients = ingredients;
            this.results = results;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
//            pJson.addProperty("category", this.category.getSerializedName());
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }
            pJson.addProperty("heat", this.heat);

            JsonArray ingredientsArray = new JsonArray();
            for(Ingredient ingredient : this.ingredients) {
                ingredientsArray.add(ingredient.toJson());
            }
            pJson.add("ingredients", ingredientsArray);

            JsonArray resultsArray = new JsonArray();
            for (ItemStack result : this.results) {{
                JsonObject results = new JsonObject();
                results.addProperty("item", BuiltInRegistries.ITEM.getKey(result.getItem()).toString());
//                results.addProperty("count", result.getCount());
                resultsArray.add(results);
            }}
            pJson.add("results", resultsArray);

            pJson.addProperty("heat", this.heat);
            pJson.addProperty("heat", this.heat);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return FoundryRecipe.SERIALIZER;
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
