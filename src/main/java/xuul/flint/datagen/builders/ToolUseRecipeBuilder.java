package xuul.flint.datagen.builders;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import xuul.flint.common.recipe.ToolUseRecipe;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ToolUseRecipeBuilder extends ShapelessRecipeBuilder {
    private final Item result;
    private final int count;
    private Ingredient tool = null;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;


    public ToolUseRecipeBuilder(ItemLike result, int count) {
        super(result,count);
        this.group = group;
        this.tool = tool;
        this.result = result.asItem();
        this.count = count;
    }

    public static ToolUseRecipeBuilder build(ItemLike pResult) {
        return new ToolUseRecipeBuilder(pResult, 1);
    }

    public static ToolUseRecipeBuilder build(ItemLike pResult, int pCount) {
        return new ToolUseRecipeBuilder(pResult, pCount);
    }



    public ToolUseRecipeBuilder tool(Tag<Item> tag) {
        return this.tool(Ingredient.of(tag));
    }

    public ToolUseRecipeBuilder tool(ItemLike pItem) {
        return this.tool(pItem);
    }


    public ShapelessRecipeBuilder requires(Tag<Item> pTag) {
        return this.requires(Ingredient.of(pTag));
    }

    @Override
    public ShapelessRecipeBuilder requires(ItemLike pItem) {
        return this.requires(pItem, 1);
    }


    @Override
    public ShapelessRecipeBuilder requires(ItemLike pItem, int pQuantity) {
        for(int i = 0; i < pQuantity; ++i) {
            this.requires(Ingredient.of(pItem));
        }

        return this;
    }
    @Override
    public ShapelessRecipeBuilder requires(Ingredient pIngredient) {
        return this.requires(pIngredient, 1);
    }

    @Override
    public ShapelessRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
        for(int i = 0; i < pQuantity; ++i) {
            this.ingredients.add(pIngredient);
        }

        return this;
    }




    @Override
    public ToolUseRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    public ToolUseRecipeBuilder tool(Ingredient tool) {
        this.tool = tool;
        return this;
    }
    
    public RecipeSerializer<?> getType() {
        return ToolUseRecipe.SERIALIZER;
    }
    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation id) {
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
        finishedRecipeConsumer.accept(new ToolUseRecipeBuilder
                .Result(id,
                this.result,
                this.count,
                this.group == null ? "" : this.group,
                this.tool,
                this.ingredients,
                this.advancement,
                new ResourceLocation(id.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + id.getPath())));
    }


    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String group;
        private final Ingredient tool;
        private final List<Ingredient> ingredients;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, Ingredient tool, List<Ingredient> pIngredients, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;
            this.group = pGroup;
            this.tool = tool;
            this.ingredients = pIngredients;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }

            Ingredient tool =this.tool;

            JsonArray jsonarray = new JsonArray();

            for(Ingredient ingredient : this.ingredients) {
                jsonarray.add(ingredient.toJson());
            }

            pJson.add("ingredients", jsonarray);
            pJson.add("tool", tool.toJson());

            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", Registry.ITEM.getKey(this.result).toString());
            if (this.count > 1) {
                jsonobject.addProperty("count", this.count);
            }
            JsonObject jsonobject2 = new JsonObject();
            jsonobject2.addProperty("tool", Registry.ITEM.getKey(this.result).toString());


            pJson.add("result", jsonobject);
        }

        public RecipeSerializer<?> getType() {
            return ToolUseRecipe.SERIALIZER;
        }


        public ResourceLocation getId() {
            return this.id;
        }


        @javax.annotation.Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }


        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
