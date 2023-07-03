package github.xuulmedia.neolith.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class DisableRecipe implements Recipe<Container> {
    protected final ResourceLocation id;
    public static final Serializer SERIALIZER = new Serializer();


    public DisableRecipe(ResourceLocation id) {
        this.id = id;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return null;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }


    public static class Type implements RecipeType<DisableRecipe> {
        private Type() {
        }
        public static final Type INSTANCE = new Type();
    }

    private static class Serializer implements RecipeSerializer<DisableRecipe> {

        @Override
        public DisableRecipe fromJson(ResourceLocation id, JsonObject pSerializedRecipe) {
            return new DisableRecipe(id);
        }

        @Override
        public DisableRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer)
        {
            return new DisableRecipe(id);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, DisableRecipe recipe) {}
    }

}

