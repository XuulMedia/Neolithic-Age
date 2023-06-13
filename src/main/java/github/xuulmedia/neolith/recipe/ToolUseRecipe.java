package github.xuulmedia.neolith.recipe;


import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import github.xuulmedia.neolith.Neolith;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ToolUseRecipe extends ShapelessRecipe {

    public static RecipeSerializer<?> SERIALIZER = new Serializer();
    public ToolUseRecipe(ResourceLocation id, String group,  CraftingBookCategory category, ItemStack result, Ingredient tool, NonNullList<Ingredient> ingredients) {
        super(id, group,  category, result, addTo(tool, ingredients));
    }
    private static NonNullList<Ingredient> addTo(Ingredient additional, NonNullList<Ingredient> oldIngredients)
    {
        oldIngredients.add(additional);
        return oldIngredients;
    }

    @Nonnull
    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public boolean isSpecial() {
        return false;
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
    //TODO fix

    @Override
    public boolean matches(CraftingContainer matrix, Level world)
    {
        StackedContents stackedcontents = new StackedContents();
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int j = 0;

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
    public Ingredient getTool()
    {
        return getIngredients().get(getIngredients().size()-1);
    }

    @Override
    public RecipeType<?> getType() {
        return ToolUseRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<ToolUseRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "tool_use";
    }
    public static class Serializer implements RecipeSerializer<ToolUseRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "tool_use");

        @Override
        public ToolUseRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            String group = GsonHelper.getAsString(pSerializedRecipe, "group", "");
            CraftingBookCategory craftingbookcategory = CraftingBookCategory.CODEC.byName(GsonHelper.getAsString(pSerializedRecipe, "category", null), CraftingBookCategory.MISC);
            NonNullList<Ingredient> ingredients = itemsFromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredient"));
            ItemStack result = ShapedRecipe.itemStackFromJson(pSerializedRecipe.getAsJsonObject("result"));
            Ingredient tool = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "tool"));


            return new ToolUseRecipe(pRecipeId, group, craftingbookcategory, result,tool, ingredients);
            }



        @Override
        public @Nullable ToolUseRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();
            CraftingBookCategory craftingbookcategory = pBuffer.readEnum(CraftingBookCategory.class);

            int i = pBuffer.readVarInt();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(i, Ingredient.EMPTY);

            for(int j = 0; j < ingredients.size(); ++j) {
                ingredients.set(j, Ingredient.fromNetwork(pBuffer));
            }
            Ingredient tool = Ingredient.fromNetwork(pBuffer);
            ItemStack result = pBuffer.readItem();

            return new ToolUseRecipe(pRecipeId, group, craftingbookcategory, result,tool, ingredients);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ToolUseRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.getGroup());
            pBuffer.writeEnum(pRecipe.category());
            pBuffer.writeVarInt(pRecipe.getIngredients().size());

            for(Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }
            CraftingHelper.write(pBuffer, pRecipe.getTool());
            pBuffer.writeItem(pRecipe.getResultItem(Minecraft.getInstance().getConnection().registryAccess()));  //TODO see if this is correct
        }



        //helper
        private static NonNullList<Ingredient> itemsFromJson(JsonArray pIngredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();
            for(int i = 0; i < pIngredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(pIngredientArray.get(i), false);
                nonnulllist.add(ingredient);
            }
            return nonnulllist;
        }
//

    }

}
