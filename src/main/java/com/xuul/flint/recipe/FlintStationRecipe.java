package com.xuul.flint.recipe;

import com.google.gson.JsonObject;
import com.xuul.flint.Flint;
import com.xuul.flint.init.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;


public class FlintStationRecipe  implements Recipe<Container> {

    private final String group;
    private final ResourceLocation id;
    @Nullable
    private final Ingredient ingredient;
    private final ItemStack result;

    public static RecipeSerializer<?> SERIALIZER = new Serializer();
    public static RecipeType<FlintStationRecipe> FLINT_STATION = RecipeType.register(Flint.MOD_ID + ":flint_station");


    public FlintStationRecipe(ResourceLocation id, String group, @Nullable Ingredient ingredient, ItemStack result) {
        this.group = group;
        this.id = id;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return getResultItem().copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> allIngredients = NonNullList.create();
        allIngredients.add(ingredient != null ? ingredient : Ingredient.EMPTY);
        return allIngredients;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {

        return FLINT_STATION;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.FLINT_STATION.get());
    }

    public Ingredient getPattern() {
        return ingredient != null ? ingredient : Ingredient.EMPTY;
    }


    public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>>
            implements RecipeSerializer<FlintStationRecipe> {

        protected FlintStationRecipe createRecipe(ResourceLocation recipeId, String group, Ingredient ingredient, ItemStack result) {
            return new FlintStationRecipe(recipeId, group, ingredient, result);
        }


        @Override
        public FlintStationRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            Ingredient input = json.has("ingredient") ? CraftingHelper.getIngredient(json.get("ingredient")) : null;
            ItemStack result = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "result"), true);
            return createRecipe(recipeId, group, input, result);
        }

        @Nullable
        @Override
        public FlintStationRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String group = buffer.readUtf(32767);
            boolean hasInput = buffer.readBoolean();
            Ingredient input = hasInput ? Ingredient.fromNetwork(buffer) : null;
            ItemStack result = buffer.readItem();
            return createRecipe(recipeId, group, input, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, FlintStationRecipe recipe) {

            buffer.writeUtf(recipe.group);
            boolean hasInput = recipe.ingredient != null;
            buffer.writeBoolean(hasInput);
            if (hasInput) recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);

        }
    }

}
