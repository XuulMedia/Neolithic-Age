//package github.xuulmedia.neolith.recipe;
//
//import com.google.gson.JsonArray;
//import github.xuulmedia.neolith.Neolith;
//import github.xuulmedia.neolith.init.ModBlocks;
//import com.google.gson.JsonObject;
//import net.minecraft.core.NonNullList;
//import net.minecraft.core.Registry;
//import net.minecraft.core.RegistryAccess;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.util.GsonHelper;
//import net.minecraft.world.Container;
//import net.minecraft.world.SimpleContainer;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.*;
//import net.minecraft.world.level.Level;
//import org.jetbrains.annotations.Nullable;
//
//
//public class FlintStationRecipe  implements Recipe<Container> {
//
//    private final ResourceLocation id;
//    @Nullable
//    private final NonNullList<Ingredient> ingredients;
//    private final ItemStack result;
//
//    public static RecipeSerializer<?> SERIALIZER = new Serializer();
//
//    public FlintStationRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, ItemStack result) {
//        this.id = id;
//        this.ingredients = ingredients;
//        this.result = result;
//    }
//
//    @Override
//    public boolean matches(Container pContainer, Level pLevel) {
//        if(pLevel.isClientSide()) {
//            return false;
//        }
//        return ingredients.get(0).test(pContainer.getItem(1));
//    }
//
//    @Override
//    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
//        return result;
//    }
//    @Override
//    public boolean canCraftInDimensions(int pWidth, int pHeight) {
//        return true;
//    }
//
//    @Override
//    public ItemStack getResultItem(RegistryAccess p_266851_) {
//        return result;
//    }
//
//    @Override
//    public NonNullList<Ingredient> getIngredients() {
//       return ingredients;
//    }
//    @Override
//    public boolean isSpecial() {
//        return true;
//    }
//
//    @Override
//    public ResourceLocation getId() {
//        return id;
//    }
//
//    @Override
//    public RecipeSerializer<?> getSerializer() {
//        return SERIALIZER;
//    }
//
//    @Override
//    public RecipeType<?> getType() {
//        return Type.INSTANCE;
//    }
//
//    @Override
//    public ItemStack getToastSymbol() {
//        return new ItemStack(ModBlocks.FLINT_STATION.get());
//    }
//
//
//
//    public static class Type implements RecipeType<FlintStationRecipe> {
//        private Type() { }
//        public static final Type INSTANCE = new Type();
//        public static final String ID = "flint_station";
//    }
//
//
//    public static class Serializer implements RecipeSerializer<FlintStationRecipe> {
//        public static final Serializer INSTANCE = new Serializer();
//        public static final ResourceLocation ID =
//                new ResourceLocation(Neolith.MODID, "flint_station");
//
//
//
//        @Override
//        public FlintStationRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
//            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
//
//            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredient");
//            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);
//
//            for (int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
//            }
//            return new FlintStationRecipe(recipeId, inputs, output);
//        }
//
//        @Nullable
//        @Override
//        public FlintStationRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
//            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);
//            for (int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromNetwork(buffer));
//            }
//
//            ItemStack output = buffer.readItem();
//            return new FlintStationRecipe(recipeId,inputs, output);
//        }
//
//        @Override
//        public void toNetwork(FriendlyByteBuf buffer, FlintStationRecipe recipe) {
//
//            buffer.writeInt(recipe.getIngredients().size());
//
//            for (Ingredient ing : recipe.getIngredients()) {
//                ing.toNetwork(buffer);
//            }
//            buffer.writeItemStack(recipe.result, false);
//        }
//    }
//}
//
//
