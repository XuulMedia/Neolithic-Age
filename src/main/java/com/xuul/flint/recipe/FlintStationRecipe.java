package com.xuul.flint.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
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


REFRENCE https://github.com/TerraFirmaCraft/TerraFirmaCraft/blob/1.18.x/src/main/java/net/dries007/tfc/common/recipes/SimpleItemRecipe.java

public class FlintStationRecipe implements Recipe<Inventory> {
    protected final Ingredient ingredient;
    protected final int amount;
    protected final ItemStack output;
    protected final int outputAmount;
    private final RecipeType<?> type;
    private final RecipeSerializer<?> serializer;
    protected final ResourceLocation recipeId;
    protected final String group;

    public FlintStationRecipe(Ingredient ingredient, int amount, ItemStack output, int outputAmount, ResourceLocation recipeId) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.output = output;
        this.outputAmount = outputAmount;
        this.recipeId = recipeId;


        this.type = type;
        this.serializer = serializer;
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

    public static class Serializer<R extends Recipe<?>> extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<R> {

        public R fromJson(ResourceLocation recipeId, JsonObject json) {
            FlintStationJsonFormat recipeJson = new Gson().fromJson(json, FlintStationJsonFormat.class);
            if (recipeJson.ingredient == null || recipeJson.outputItem == null) {
                throw new JsonSyntaxException("A required attribute is missing!");
                String s = GsonHelper.getAsString(json, "group", "");
                Ingredient ingredient;
                // If any amount is set to zero default it to 1
                if (recipeJson.amount == 0) recipeJson.amount = 1;
                if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;
                int amount = recipeJson.amount;
                int outputAmount = recipeJson.outputAmount;

                ItemStack output = new ItemStack(recipeJson.outputItem, recipeJson.outputAmount);
                return new FlintStationRecipe(ingredient, amount, output, outputAmount, recipeId);
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


        public AlloyRecipe read(Identifier id, JsonObject json) {
            AlloyRecipeJsonFormat recipeJson = new Gson().fromJson(json, AlloyRecipeJsonFormat.class);
            if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
                throw new JsonSyntaxException("A required attribute is missing!");
            }
            Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
            Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
//        If any amount is set to zero default it to 1
            if (recipeJson.amountA == 0) recipeJson.amountA = 1;
            if (recipeJson.amountB == 0) recipeJson.amountB = 1;
            if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;
            int amountA = recipeJson.amountA;
            int amountB = recipeJson.amountB;


            Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                    // Validate the inputted item actually exists
                    .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
            ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);
            return new AlloyRecipe(inputA, inputB, amountA, amountB, output, id);


            final SingleItemRecipe.Serializer.SingleItemMaker<T> factory;

        protected Serializer(SingleItemRecipe.Serializer.SingleItemMaker < T > pFactory) {
                this.factory = pFactory;
            }


            public T fromNetwork (ResourceLocation pRecipeId, FriendlyByteBuf pBuffer){
                String s = pBuffer.readUtf();
                Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
                ItemStack itemstack = pBuffer.readItem();
                return this.factory.create(pRecipeId, s, ingredient, itemstack);
            }

            public void toNetwork (FriendlyByteBuf pBuffer, T pRecipe){
                pBuffer.writeUtf(pRecipe.group);
                pRecipe.ingredient.toNetwork(pBuffer);
                pBuffer.writeItem(pRecipe.result);
            }


        }



    }
    class FlintStationJsonFormat {
        JsonObject ingredient;
        int amount;
        Item outputItem;
        int outputAmount;
    }


}
