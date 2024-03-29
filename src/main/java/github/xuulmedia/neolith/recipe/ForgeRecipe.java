package github.xuulmedia.neolith.recipe;

import com.google.gson.*;
import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.init.ModRecipes;
import github.xuulmedia.neolith.util.HeatingFuelContainer;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ForgeRecipe extends AbstractHeatRecipe {
    public static final Serializer SERIALIZER = new Serializer();

    public ForgeRecipe(ResourceLocation id, String group, int heatRequired, NonNullList<Ingredient> ingredients, NonNullList<ItemStack> results, float experience, int cookingTime) {
        super(Type.INSTANCE, id, group, heatRequired, ingredients, results, experience, cookingTime);
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.ingredients.get(0).test(pContainer.getItem(ForgeBE.SLOT_INPUT));
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
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }


    public static class Type implements RecipeType<ForgeRecipe> {
        private Type() {
        }
        public static final ForgeRecipe.Type INSTANCE = new ForgeRecipe.Type();
    }

    private static class Serializer implements RecipeSerializer<ForgeRecipe> {

        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "forge_recipe");

        @Override
        public ForgeRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            int heatReq = GsonHelper.getAsInt(json, "heatRequired");

            NonNullList<Ingredient> ingredients = ingredientsFromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            NonNullList<ItemStack> results = resultsFromJson(GsonHelper.getAsJsonArray(json, "results"));


            float experience = GsonHelper.getAsFloat(json, "experience", 0.0F);
            int cookingtime = GsonHelper.getAsInt(json, "cookingtime", 200);

            return new ForgeRecipe(recipeID, group, heatReq, ingredients, results, experience, cookingtime);
        }

        @Nullable
        @Override
        public ForgeRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            int heatReq = buffer.readInt();
            NonNullList<Ingredient> ingredients = buffer.readCollection(NonNullList::createWithCapacity,
                    Ingredient::fromNetwork);
            NonNullList<ItemStack> results = buffer.readCollection(NonNullList::createWithCapacity,
                    FriendlyByteBuf::readItem);
            float xp = buffer.readFloat();
            int cookTime = buffer.readVarInt();
            return new ForgeRecipe(recipeID, group, heatReq, ingredients, results, xp, cookTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, ForgeRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeInt(recipe.heatRequired);
            buffer.writeCollection(recipe.ingredients, (fbb, ingr) -> ingr.toNetwork(fbb));
            buffer.writeCollection(recipe.results, FriendlyByteBuf::writeItem);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.cookingTime);
        }
    }
}
