package xuul.flint.recipe;

import com.google.gson.JsonObject;
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
import org.jetbrains.annotations.Nullable;
import xuul.flint.Flint;
import xuul.flint.gui.FoundryMenu;

// "recipe"
public class FoundryFuelRecipe implements Recipe<Container> {
    public static final RecipeType<FoundryFuelRecipe> TYPE = RecipeType.register(Flint.MOD_ID + ":foundry_fuel");
    public static final Serializer SERIALIZER = new Serializer();

    public final String group;
    public final ResourceLocation id;
    public final Ingredient input;
    public final int maxHeat;
    public final int burnTime;

    public FoundryFuelRecipe(ResourceLocation id, String group, Ingredient input, int maxHeat, int burnTime) {
        this.id = id;
        this.group = group;
        this.input = input;
        this.maxHeat = maxHeat;
        this.burnTime = burnTime;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return TYPE;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.input.test(pContainer.getItem(FoundryMenu.FUEL_SLOT));
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth * pHeight >= 1;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    private static class Serializer implements RecipeSerializer<FoundryFuelRecipe> {
        public static final FoundryFuelRecipe.Serializer INSTANCE = new FoundryFuelRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Flint.MOD_ID, "foundry_fuel");


        @Override
        public FoundryFuelRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            var group = GsonHelper.getAsString(json, "group", "");
            var input = Ingredient.fromJson(json.get("input"));
            var maxHeat = GsonHelper.getAsInt(json, "heat");
            var burnTime = GsonHelper.getAsInt(json, "burnTime");
            return new FoundryFuelRecipe(recipeID, group, input, maxHeat, burnTime);
        }

        @Nullable
        @Override
        public FoundryFuelRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buf) {
            var group = buf.readUtf();
            var input = Ingredient.fromNetwork(buf);
            var maxHeat = buf.readInt();
            var burnTime = buf.readInt();
            return new FoundryFuelRecipe(recipeID, group, input, maxHeat, burnTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, FoundryFuelRecipe recipe) {
            buf.writeUtf(recipe.group);
            recipe.input.toNetwork(buf);
            buf.writeInt(recipe.maxHeat);
            buf.writeInt(recipe.burnTime);
        }
    }
}
