package xuul.flint.datagen.builders;

import com.google.common.collect.Lists;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class ToolUseRecipeBuilder implements RecipeBuilder {

    private final Item result;
    private final Ingredient tool;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    @javax.annotation.Nullable
    private String group;
    private final RecipeSerializer<?> type;

    public ToolUseRecipeBuilder(RecipeSerializer<?> type, ItemLike result, Ingredient tool) {
        this.result = result.asItem();
        this.tool = tool;
        this.type = type;
    }


    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        return null;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return null;
    }

    @Override
    public Item getResult() {
        return null;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {

    }
}
