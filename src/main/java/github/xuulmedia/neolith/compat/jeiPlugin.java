//package github.xuulmedia.neolith.compat;
//
//import github.xuulmedia.neolith.Neolith;
//import github.xuulmedia.neolith.recipe.ForgeRecipe;
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.recipe.RecipeType;
//import mezz.jei.api.registration.IRecipeCategoryRegistration;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.minecraft.client.Minecraft;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.RecipeManager;
//
//import java.util.List;
//import java.util.Objects;
//
//@JeiPlugin
//public class jeiPlugin implements IModPlugin {
//    public static RecipeType<ForgeRecipe> FORGE_HEAT_TYPE =
//            new RecipeType<>(ForgeRecipeCategory.UID, ForgeRecipe.class);
//
//
//    @Override
//    public ResourceLocation getPluginUid() {
//        return new ResourceLocation(Neolith.MODID, "jei_plugin");
//    }
//
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registration) {
//        registration.addRecipeCategories(new
//                ForgeRecipe(registration.getJeiHelpers().getGuiHelper()));
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
//
//        List<ForgeRecipe> recipesInfusing = recipeManager.getAllRecipesFor(ForgeRecipe.Type.INSTANCE);
//        registration.addRecipes(FORGE_HEAT_TYPE, recipesInfusing);
//    }
//
//
//}
