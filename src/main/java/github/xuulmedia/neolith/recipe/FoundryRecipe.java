package github.xuulmedia.neolith.recipe;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.block.entity.FoundryBE;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FoundryRecipe implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();

    public static final int MAX_INPUTS = 3;
    public static final int MAX_OUTPUTS = 2;

    private final ResourceLocation id;
    private final String group;

    public final NonNullList<Ingredient> ingredients;
    public final NonNullList<ItemStack> results;
    public final int heat;

    public FoundryRecipe(ResourceLocation id, String group, int heat, NonNullList<Ingredient> ingredients,
                         NonNullList<ItemStack> results) {
        this.id = id;
        this.group = group;
        this.heat = heat;
        this.ingredients = ingredients;
        this.results = results;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return FoundryBE.recipeMatches(this, idx -> pContainer.getItem(FoundryBE.SLOT_INPUT0 + idx));
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess p_267165_)  {
        return this.results.get(0).copy();
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.results.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth * pHeight >= 1;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<FoundryRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "kiln";
    }

    private static class Serializer implements RecipeSerializer<FoundryRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "kiln");

        @Override
        public FoundryRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            var group = GsonHelper.getAsString(json, "group", "");
            var heat = GsonHelper.getAsInt(json, "heat");

            NonNullList<Ingredient> inputs = NonNullList.create();
            var ingrArr = GsonHelper.getAsJsonArray(json, "inputs");
            for (JsonElement ingrElt : ingrArr) {
                Ingredient ingredient = Ingredient.fromJson(ingrElt);
                if (!ingredient.isEmpty()) {
                    inputs.add(ingredient);
                }
            }
            if (!(1 <= inputs.size() && inputs.size() <= MAX_INPUTS)) {
                throw new JsonParseException("must have between 1 and 3 inputs to a kiln recipe but got " + inputs.size());
            }

            NonNullList<ItemStack> outputs = NonNullList.create();
            var outputArr = GsonHelper.getAsJsonArray(json, "outputs");
            for (int i = 0; i < outputArr.size(); i++) {
                JsonElement outElt = outputArr.get(i);
                if (!(outElt instanceof JsonObject outObj)) {
                    throw new JsonParseException("outputs[" + i + "] was not a JsonObject");
                }
                ItemStack output = ShapedRecipe.itemStackFromJson(outObj);
                outputs.add(output);
            }
            if (!(1 <= outputs.size() && outputs.size() <= MAX_OUTPUTS)) {
                throw new JsonParseException("must have between 1 and 2 outputs to a kiln recipe but got " + outputs.size());
            }

            return new FoundryRecipe(recipeID, group, heat, inputs, outputs);
        }

        @Nullable
        @Override
        public FoundryRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            var group = buf.readUtf();
            var heat = buf.readInt();

            NonNullList<Ingredient> inputs = buf.readCollection(NonNullList::createWithCapacity,
                    Ingredient::fromNetwork);
            NonNullList<ItemStack> output = buf.readCollection(NonNullList::createWithCapacity,
                    FriendlyByteBuf::readItem);
            return new FoundryRecipe(id, group, heat, inputs, output);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, FoundryRecipe recipe) {
            buf.writeUtf(recipe.group);
            buf.writeInt(recipe.heat);

            buf.writeCollection(recipe.ingredients, (fbb, ingr) -> ingr.toNetwork(fbb));
            buf.writeCollection(recipe.results, FriendlyByteBuf::writeItem);
        }
    }
}
