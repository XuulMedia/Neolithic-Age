package com.xuul.flint.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.checkerframework.checker.signature.qual.Identifier;
import org.jetbrains.annotations.Nullable;


public class FlintStationRecipe implements Recipe<Inventory> {
    protected final Ingredient ingredient;
    protected final int amount;
    protected final ItemStack output;
    protected final int outputAmount;
    protected final ResourceLocation recipeId;
    protected final String group;

    public FlintStationRecipe(Ingredient ingredient,  int amount, ItemStack output, int outputAmount, ResourceLocation recipeId, String group) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.output = output;
        this.outputAmount = outputAmount;
        this.recipeId = recipeId;
        this.group = group;


    }

    public RecipeType<?> getType() {
        return this.type;
    }

    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    public ResourceLocation getId() {
        return this.recipeId;
    }

    public String getGroup() {
        return this.group;
    }



    public ItemStack getResultItem() {
        return this.output;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack assemble(Inventory container) {
        return this.output.copy();
    }

    @Override
    public boolean matches(Inventory container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }


    /*Serializer*/

    public static class Serializer implements RecipeSerializer<FlintStationRecipe> {


        @Override
        public FlintStationRecipe  fromJson(ResourceLocation recipeId, JsonObject json) {
            FlintStationJsonFormat recipeJson = new Gson().fromJson(json, FlintStationJsonFormat.class);
            if (recipeJson.ingredient == null || recipeJson.outputItem == null) {
                throw new JsonSyntaxException("A required attribute is missing!");
            }
                String s = GsonHelper.getAsString(json, "group", "");
                Ingredient ingredient = Ingredient.fromJson(recipeJson.ingredient);
                // If any amount is set to zero default it to 1
                if (recipeJson.amount == 0) recipeJson.amount = 1;
                if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;
                int amount = recipeJson.amount;
                int outputAmount = recipeJson.outputAmount;
            ItemStack output = new ItemStack(recipeJson.outputItem, recipeJson.outputAmount);
                return new FlintStationRecipe(ingredient, amount,  output, outputAmount, recipeId);
            }

        @Nullable
        @Override
        public FlintStationRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer)
            int amount = pBuffer.readInt();
            int outputAmount = pBuffer.readInt();
            ItemStack output = pBuffer.readItem();
            String group = String.


            return new FlintStationRecipe(ingredient, amount, output, outputAmount, pRecipeId, group);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, FlintStationRecipe pRecipe) {

        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return null;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return null;
        }
    }



    class FlintStationJsonFormat {
        JsonObject ingredient;
        String group;
        int amount;
        Item outputItem;
        int outputAmount;
    }
































        Item outputItem = CraftingHelper.getItemStack(getAsJsonObject(json, outputItem), true)
        JsonHelpers.getItemStack(json, "result")


        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                // Validate the inputted item actually exists
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));

        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);



//            if (GsonHelper.isArrayNode(pJson, "ingredient")) {
//                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pJson, "ingredient"));
//            } else {
//                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));
//            }
//
//            String s1 = GsonHelper.getAsString(pJson, "result");
//            int i = GsonHelper.getAsInt(pJson, "count");
//            ItemStack itemstack = new ItemStack(Registry.ITEM.get(new ResourceLocation(s1)), i);
//
//
//            return new FlintStationRecipe(recipeId, s, ingredient, itemstack)
//
//            this.factory.create(pRecipeId, s, ingredient, itemstack);
    }

