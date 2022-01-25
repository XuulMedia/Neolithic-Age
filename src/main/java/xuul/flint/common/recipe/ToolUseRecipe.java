package xuul.flint.common.recipe;


import com.google.gson.JsonObject;
import net.minecraft.util.GsonHelper;
import xuul.flint.Flint;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ToolUseRecipe extends ShapelessRecipe {

    public static RecipeSerializer<?> SERIALIZER = new Serializer();
    public static RecipeType<ToolUseRecipe> TOOL_USE_RECIPE_TYPE = RecipeType.register(Flint.MOD_ID + "tool_use");

    public ToolUseRecipe(ResourceLocation id, String group, ItemStack result, Ingredient tool, NonNullList<Ingredient> ingredients) {
        super(id, group, result, addTo(tool, ingredients));
    }


    private static NonNullList<Ingredient> addTo(Ingredient additional, NonNullList<Ingredient> oldIngredients)
    {
        oldIngredients.add(additional);
        return oldIngredients;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Nonnull
    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer inv)
    {
        NonNullList<ItemStack> remains = super.getRemainingItems(inv);
        for(int i = 0; i < remains.size(); i++)
        {
            ItemStack s = inv.getItem(i);
            ItemStack remain = remains.get(i);
            ItemStack tool = ItemStack.EMPTY;
            int toolDamageSlot = getIngredients().size()-1;
            if(remain.isEmpty()&&!s.isEmpty()&&getIngredients().get(toolDamageSlot).test(s))
                tool = s.copy();
            else if(!remain.isEmpty()&&getIngredients().get(toolDamageSlot).test(remain))
                tool = remain;
            if(!tool.isEmpty()&&tool.isDamageableItem())
            {
                tool.setDamageValue(tool.getDamageValue()+1);
                if(tool.getDamageValue() > tool.getMaxDamage())
                    tool = ItemStack.EMPTY;
                remains.set(i, tool);
            }
        }
        return remains;
    }

    @Override
    public boolean matches(CraftingContainer matrix, Level world)
    {
        List<Ingredient> required = new LinkedList<>(getIngredients());

        for(int i = 0; i < matrix.getContainerSize(); i++)
        {
            ItemStack slot = matrix.getItem(i);
            if(!slot.isEmpty())
            {
                boolean inRecipe = false;
                Iterator<Ingredient> iterator = required.iterator();
                while(iterator.hasNext())
                {
                    Ingredient next = iterator.next();
                    if(next.test(slot))
                    {
                        inRecipe = true;
                        iterator.remove();
                        break;
                    }
                }
                if(!inRecipe)
                    return false;
            }
        }
        return required.isEmpty();
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return SERIALIZER;
    }

    public RecipeType<?> getType() {

        return TOOL_USE_RECIPE_TYPE;
    }

    public Ingredient getTool()
    {
        return getIngredients().get(getIngredients().size()-1);
    }


    public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>>
            implements RecipeSerializer<ToolUseRecipe> {
        @Nonnull
        @Override
        public ToolUseRecipe fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json)
        {
            Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
            ItemStack result = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("result"));
            Ingredient tool = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "tool"));

            NonNullList<Ingredient> ingredients =
                    NonNullList.of(Ingredient.EMPTY, input, tool);

            String group = json.get("group").getAsString();

            return new ToolUseRecipe(recipeId, group, result,tool, ingredients);
        }

        @Nonnull
        @Override
        public ToolUseRecipe fromNetwork(@Nonnull ResourceLocation recipeId, @Nonnull FriendlyByteBuf buffer)
        {
            int stdCount = buffer.readInt();
            NonNullList<Ingredient> ingredients = NonNullList.create();
            for(int i = 0; i < stdCount; ++i)
                ingredients.add(Ingredient.fromNetwork(buffer));
            Ingredient tool = Ingredient.fromNetwork(buffer);
            String group = buffer.readUtf(512);
            ItemStack output = buffer.readItem();
            return new ToolUseRecipe(recipeId, group, output, tool, ingredients);
        }

        @Override
        public void toNetwork(@Nonnull FriendlyByteBuf buffer, @Nonnull ToolUseRecipe recipe)
        {
            int standardCount = recipe.getIngredients().size()-1;
            buffer.writeInt(standardCount);
            for(int i = 0; i < standardCount; ++i)
                CraftingHelper.write(buffer, recipe.getIngredients().get(i));
            CraftingHelper.write(buffer, recipe.getTool());
            buffer.writeUtf(recipe.getGroup());
            buffer.writeItem(recipe.getResultItem());
        }

    }

}
