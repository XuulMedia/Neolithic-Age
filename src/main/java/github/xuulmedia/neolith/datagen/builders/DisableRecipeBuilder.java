package github.xuulmedia.neolith.datagen.builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import github.xuulmedia.neolith.init.ModRecipes;
import github.xuulmedia.neolith.recipe.AbstractHeatRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
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
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class DisableRecipeBuilder implements RecipeBuilder {

    private final Item result;

    public DisableRecipeBuilder(Item result) {
        this.result = result;
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        // Implement as needed
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        // Implement as needed
        return null;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        pFinishedRecipeConsumer.accept(new Result(pRecipeId));
    }

    private class Result implements FinishedRecipe {

        private final ResourceLocation id;
        public Result(ResourceLocation id) {
            this.id = id;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray conditions = new JsonArray();
            JsonObject condition = new JsonObject();
            condition.addProperty("type", "forge:false");
            conditions.add(condition);
            json.add("conditions", conditions);
        }

        @Override
        public RecipeSerializer<?> getType() {
            // return your RecipeSerializer here
            return ModRecipes.DISABLE_SERIALIZER.get();
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public JsonObject serializeAdvancement() {
            // Implement as needed
            return null;
        }

        @Override
        public ResourceLocation getAdvancementId() {
            // Implement as needed
            return null;
        }
    }
}