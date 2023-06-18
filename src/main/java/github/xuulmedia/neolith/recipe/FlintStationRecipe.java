package github.xuulmedia.neolith.recipe;

import com.google.gson.JsonObject;
import github.xuulmedia.neolith.Neolith;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;


public class FlintStationRecipe  implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();

    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final ResourceLocation id;


    public FlintStationRecipe(ResourceLocation id, Ingredient ingredient, ItemStack result) {
        this.id = id;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.result;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ManualGrinderRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return ManualGrinderRecipe.Type.INSTANCE;
    }


    public static class Type implements RecipeType<FlintStationRecipe> {
        private Type() {
        }

        public static final FlintStationRecipe.Type INSTANCE = new FlintStationRecipe.Type();
        public static final String ID = "flint_station";
    }

    private static class Serializer implements RecipeSerializer<FlintStationRecipe> {

        public static final ResourceLocation ID = new ResourceLocation(Neolith.MODID, "flint_station");


        @Override
        public FlintStationRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));

            Ingredient ingredient;
            if (GsonHelper.isArrayNode(pSerializedRecipe, "ingredient")) {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredient"), false);
            } else {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient"), false);
            }

            return new FlintStationRecipe(pRecipeId, ingredient, output);

        }

        @Override
        public @Nullable FlintStationRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            ItemStack output = pBuffer.readItem();
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            return new FlintStationRecipe(pRecipeId, ingredient, output);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, FlintStationRecipe pRecipe) {
            pBuffer.writeItem(pRecipe.result);
            pRecipe.ingredient.toNetwork(pBuffer);
        }
    }

}





