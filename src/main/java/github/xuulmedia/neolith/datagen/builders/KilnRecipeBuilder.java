package github.xuulmedia.neolith.datagen.builders;

import github.xuulmedia.neolith.recipe.KilnRecipe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class KilnRecipeBuilder implements RecipeBuilder {
    public final NonNullList<Ingredient> inputs;
    public final NonNullList<ItemStack> outputs;
    public final int heat;

    private final Advancement.Builder advancement;
    @Nullable
    private String group;

    public KilnRecipeBuilder(NonNullList<Ingredient> inputs, NonNullList<ItemStack> outputs, int heat) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.heat = heat;
        this.advancement = Advancement.Builder.advancement();

        if (!(1 <= inputs.size() && inputs.size() <= KilnRecipe.MAX_INPUTS)) {
            throw new IllegalStateException("must have between 1 and 3 inputs to a kiln recipe but got " + inputs.size());
        }
        if (!(1 <= outputs.size() && outputs.size() <= KilnRecipe.MAX_OUTPUTS)) {
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
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public final NonNullList<Ingredient> inputs;
        public final NonNullList<ItemStack> outputs;
        public final int heat;


        public Result(ResourceLocation id, String group, int heat, NonNullList<Ingredient> inputs,
                      NonNullList<ItemStack> outputs,
                      Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.group = group;
            this.advancement = advancement;
            this.advancementId = advancementId;

            this.heat = heat;
            this.inputs = inputs;
            this.outputs = outputs;

        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }

            pJson.addProperty("heat", this.heat);

            var inputsArr = new JsonArray(this.inputs.size());
            for (Ingredient ingr : this.inputs) {
                inputsArr.add(ingr.toJson());
            }
            pJson.add("inputs", inputsArr);

            var outputsArr = new JsonArray(this.inputs.size());
            for (ItemStack out : this.outputs) {
                var outObj = new JsonObject();
                outObj.addProperty("item", Registry.ITEM.getKey(out.getItem()).toString());
                outObj.addProperty("count", out.getCount());
                outputsArr.add(outObj);
            }
            pJson.add("outputs", outputsArr);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return KilnRecipe.SERIALIZER;
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
