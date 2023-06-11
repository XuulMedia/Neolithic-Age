package github.xuulmedia.neolith.recipe;

import github.xuulmedia.neolith.Flint;
import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.util.HeatingFuelContainer;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
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

// "recipe"
public class HeatingFuelRecipe implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();

    public final String group;
    public final ResourceLocation id;
    public final Ingredient input;
    public final int maxHeat;
    public final int burnTime;

    public HeatingFuelRecipe(ResourceLocation id, String group, Ingredient input, int maxHeat, int burnTime) {
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
        return Type.INSTANCE;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        if (pContainer instanceof HeatingFuelContainer hfc) {
            return this.input.test(hfc.getItem(hfc.getFuelSlot()));
        } else {
            return false;
        }
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth * pHeight >= 1;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    public static class Type implements RecipeType<HeatingFuelRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "heating_fuel";
    }


    private static class Serializer implements RecipeSerializer<HeatingFuelRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "heating_fuel");


        @Override
        public HeatingFuelRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            var group = GsonHelper.getAsString(json, "group", "");
            var input = Ingredient.fromJson(json.get("input"));
            var maxHeat = GsonHelper.getAsInt(json, "heat");
            var burnTime = GsonHelper.getAsInt(json, "burnTime");
            return new HeatingFuelRecipe(recipeID, group, input, maxHeat, burnTime);
        }

        @Nullable
        @Override
        public HeatingFuelRecipe fromNetwork(ResourceLocation recipeID, FriendlyByteBuf buf) {
            var group = buf.readUtf();
            var input = Ingredient.fromNetwork(buf);
            var maxHeat = buf.readInt();
            var burnTime = buf.readInt();
            return new HeatingFuelRecipe(recipeID, group, input, maxHeat, burnTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, HeatingFuelRecipe recipe) {
            buf.writeUtf(recipe.group);
            recipe.input.toNetwork(buf);
            buf.writeInt(recipe.maxHeat);
            buf.writeInt(recipe.burnTime);
        }
    }
}
