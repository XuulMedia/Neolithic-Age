package github.xuulmedia.neolith.recipe;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.entity.FoundryBE;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FoundryRecipe extends AbstractHeatRecipe {
    public static final Serializer SERIALIZER = new Serializer();

    public FoundryRecipe(ResourceLocation id, String group, int heatRequired, NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, float experience, int cookingTime) {
        super(Type.INSTANCE, id, group, heatRequired, ingredients, results, experience, cookingTime);
    }


    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return FoundryBE.recipeMatches(this, index -> pContainer.getItem(FoundryBE.SLOT_INPUT + index));
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess p_267165_)  {
        return this.results.get(0).copy();
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.results.get(0).copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return FoundryRecipe.Type.INSTANCE;
    }


    public static class Type implements RecipeType<FoundryRecipe> {
        private Type() {
        }
        public static final FoundryRecipe.Type INSTANCE = new Type();
    }

    private static class Serializer implements RecipeSerializer<FoundryRecipe> {
        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "foundry_recipe");

        @Override
        public FoundryRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            int heatReq = GsonHelper.getAsInt(json, "heatRequired");

            NonNullList<Ingredient> ingredients = ingredientsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            NonNullList<ItemStack> results = resultsFromJson(GsonHelper.getAsJsonArray(json, "results"));


            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int cookingtime = GsonHelper.getAsInt(json, "cookingtime", 200);

            return new FoundryRecipe(recipeID, group, heatReq, ingredients, results, experience, cookingtime);
        }

        @Nullable
        @Override
        public FoundryRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            int heatReq = buffer.readInt();
            NonNullList<Ingredient> ingredients = buffer.readCollection(NonNullList::createWithCapacity,
                    Ingredient::fromNetwork);
            NonNullList<ItemStack> results = buffer.readCollection(NonNullList::createWithCapacity,
                    FriendlyByteBuf::readItem);
            float xp = buffer.readFloat();
            int cookTime = buffer.readVarInt();
            return new FoundryRecipe(recipeID, group, heatReq, ingredients, results, xp, cookTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, FoundryRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeInt(recipe.heatRequired);
            buffer.writeCollection(recipe.ingredients, (fbb, ingr) -> ingr.toNetwork(fbb));
            buffer.writeCollection(recipe.results, FriendlyByteBuf::writeItem);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.cookingTime);
        }


    }
}
