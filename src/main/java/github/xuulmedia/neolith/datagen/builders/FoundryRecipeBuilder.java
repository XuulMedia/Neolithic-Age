package github.xuulmedia.neolith.datagen.builders;

import github.xuulmedia.neolith.recipe.FoundryRecipe;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class FoundryRecipeBuilder implements RecipeBuilder {
    private final Ingredient input;
    private final Item output;
    private final int count;
    private final int heat;

    private final Advancement.Builder advancement;
    @Nullable
    private String group;

    public FoundryRecipeBuilder(Ingredient input, Item output, int count, int heat) {
        this.input = input;
        this.output = output;
        this.count = count;
        this.heat = heat;
        this.advancement = Advancement.Builder.advancement();
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
        return this.output;
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
                this.input,
                this.output,
                this.count,
                this.heat,
                this.advancement,
                new ResourceLocation(pRecipeId.getNamespace(), "recipes/foundry/" + pRecipeId.getPath())));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient input;
        private final Item output;
        private final int count;
        private final int heat;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, String group, Ingredient input, Item output, int count, int heat,
                      Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.group = group;
            this.input = input;
            this.heat = heat;
            this.output = output;
            this.count = count;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }

            pJson.add("input", this.input.toJson());
            pJson.addProperty("output", Registry.ITEM.getKey(this.output).toString());
            pJson.addProperty("count", this.count);
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
