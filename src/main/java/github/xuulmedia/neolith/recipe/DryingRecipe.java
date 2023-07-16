package github.xuulmedia.neolith.recipe;

import com.google.gson.JsonObject;
import github.xuulmedia.neolith.Neolith;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DryingRecipe extends AbstractNeolithItemCraft {
    public static final Serializer SERIALIZER = new Serializer();
    protected final int cookingTime;

    public DryingRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, int cookingTime) {
        super(Type.INSTANCE, id, "", ingredients, results, 0, RecipeCategory.MISC);
        this.cookingTime = cookingTime;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.ingredients.get(0).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.results.get(0).copy();
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.results.get(0).copy();
    }

    public Ingredient getIngredient() {
        return this.ingredients.get(0);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public int getDryingTime() {
        return this.cookingTime;
    }

    public static class Type implements RecipeType<DryingRecipe> {
        private Type() {
        }

        public static final DryingRecipe.Type INSTANCE = new DryingRecipe.Type();
        public static final String ID = "drying";
    }

    private static class Serializer implements RecipeSerializer<DryingRecipe> {
        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "drying");

        @Override
        public DryingRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            NonNullList<Ingredient> ingredients = ingredientsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            NonNullList<ItemStack> results = resultsFromJson(GsonHelper.getAsJsonArray(json, "results"));
            int cooktime = GsonHelper.getAsInt(json, "cookingtime", 200);

            return new DryingRecipe(recipeID, ingredients, results, cooktime);
        }

        @Nullable
        @Override
        public DryingRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
            NonNullList<Ingredient> ingredients = buffer.readCollection(NonNullList::createWithCapacity,
                    Ingredient::fromNetwork);
            NonNullList<ItemStack> results = buffer.readCollection(NonNullList::createWithCapacity,
                    FriendlyByteBuf::readItem);
            int cooktime = buffer.readVarInt();

            return new DryingRecipe(recipeID, ingredients, results, cooktime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, DryingRecipe recipe) {
            buffer.writeCollection(recipe.ingredients, (fbb, ingr) -> ingr.toNetwork(fbb));
            buffer.writeCollection(recipe.results, FriendlyByteBuf::writeItem);
            buffer.writeVarInt(recipe.cookingTime);
        }
    }
}
