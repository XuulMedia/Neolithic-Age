package github.xuulmedia.neolith.recipe;

import com.google.gson.JsonObject;
import github.xuulmedia.neolith.Neolith;
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


public class FlintStationRecipe  extends AbstractNeolithItemCraft{
    public static final Serializer SERIALIZER = new Serializer();

    protected int SLOT_INPUT = 0;
    protected int SLOT_RESULT = 1;

    public FlintStationRecipe(ResourceLocation id, String group, NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, float experience) {
        super(ForgeRecipe.Type.INSTANCE, id, group, ingredients, results, experience);
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.ingredients.get(0).test(pContainer.getItem(SLOT_INPUT));
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.results.get(0).copy();
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.results.get(0).copy();
    }

    public ItemStack getResult(){
        return  this.results.get(0).copy();
    }

    public Ingredient getIngredient() {
        return  this.ingredients.get(0);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FlintStationRecipe.SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return FlintStationRecipe.Type.INSTANCE;
    }


    public static class Type implements RecipeType<FlintStationRecipe> {
        private Type() {
        }

        public static final FlintStationRecipe.Type INSTANCE = new FlintStationRecipe.Type();
        public static final String ID = "flint_station";
    }

    private static class Serializer implements RecipeSerializer<FlintStationRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "flint_station");

        @Override
        public FlintStationRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");

            NonNullList<Ingredient> ingredients = ingredientsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            NonNullList<ItemStack> results = resultsFromJson(GsonHelper.getAsJsonArray(json, "results"));

            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            return new FlintStationRecipe(recipeID, group, ingredients, results, experience);
        }

        @Nullable
        @Override
        public FlintStationRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            NonNullList<Ingredient> ingredients = buffer.readCollection(NonNullList::createWithCapacity,
                    Ingredient::fromNetwork);
            NonNullList<ItemStack> results = buffer.readCollection(NonNullList::createWithCapacity,
                    FriendlyByteBuf::readItem);
            float xp = buffer.readFloat();
            return new FlintStationRecipe(recipeID, group,  ingredients, results, xp);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, FlintStationRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeCollection(recipe.ingredients, (fbb, ingr) -> ingr.toNetwork(fbb));
            buffer.writeCollection(recipe.results, FriendlyByteBuf::writeItem);
            buffer.writeFloat(recipe.experience);
        }
    }

}





