package github.xuulmedia.neolith.recipe;

import github.xuulmedia.neolith.Flint;
import github.xuulmedia.neolith.block.entity.FoundryBlockEntity;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
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

public class FoundryRecipe implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();

    private final ResourceLocation id;
    private final String group;
    public final Ingredient input;
    public final int heat;
    public final ItemStack output;

    public FoundryRecipe(ResourceLocation id, String group, int heat, Ingredient input, ItemStack output) {
        this.id = id;
        this.group = group;
        this.heat = heat;
        this.input = input;
        this.output = output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(this.input);
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.input.test(pContainer.getItem(FoundryBlockEntity.SLOT_INPUT));
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return this.output.copy();
    }


    @Override
    public ItemStack getResultItem() {
        return this.output.copy();
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
        public static final String ID = "foundry";
    }

    private static class Serializer implements RecipeSerializer<FoundryRecipe> {

        public static final ToolUseRecipe.Serializer INSTANCE = new ToolUseRecipe.Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Neolith.MODID, "foundry");

        @Override
        public FoundryRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            var group = GsonHelper.getAsString(json, "group", "");
            var input = Ingredient.fromJson(json.get("input"));
            var count = GsonHelper.getAsInt(json, "count");
            var outputResLoc = GsonHelper.getAsString(json, "output");
            var output = new ItemStack(Registry.ITEM.get(new ResourceLocation(outputResLoc)), count);
            var heat = GsonHelper.getAsInt(json, "heat");
            return new FoundryRecipe(recipeID, group, heat, input, output);
        }

        @Nullable
        @Override
        public FoundryRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            var group = buf.readUtf();
            var input = Ingredient.fromNetwork(buf);
            var output = buf.readItem();
            var heat = buf.readInt();
            return new FoundryRecipe(id, group, heat, input, output);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, FoundryRecipe recipe) {
            buf.writeUtf(recipe.group);
            recipe.input.toNetwork(buf);
            buf.writeItem(recipe.output);
            buf.writeInt(recipe.heat);
        }
    }
}
