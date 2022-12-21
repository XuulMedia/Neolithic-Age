package ca.xuul.flint.recipe;

import ca.xuul.flint.Flint;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class KilnRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;

    public static RecipeSerializer<?> SERIALIZER = new Serializer();

    public KilnRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.result = result;
        this.recipeItems = recipeItems;
    }


    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result.copy();
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
        return FoundryRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<KilnRecipe> {
        private Type() { }
        public static final KilnRecipe.Type INSTANCE = new KilnRecipe.Type();
        public static final String ID = "kiln";
    }



    public static class Serializer implements RecipeSerializer<KilnRecipe> {

        public static final ToolUseRecipe.Serializer INSTANCE = new ToolUseRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Flint.MOD_ID, "kiln");

        protected KilnRecipe createRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> recipeItems) {
            return new KilnRecipe(id, result, recipeItems);
        }

        @Override
        public KilnRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            return null;
        }

        @Nullable
        @Override
        public KilnRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            return null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, KilnRecipe pRecipe) {

        }
    }
}
