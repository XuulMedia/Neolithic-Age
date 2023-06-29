//package github.xuulmedia.neolith.compat;
//
//import github.xuulmedia.neolith.Neolith;
//import github.xuulmedia.neolith.block.entity.ForgeBE;
//import github.xuulmedia.neolith.gui.menu.ForgeMenu;
//import github.xuulmedia.neolith.gui.screen.ForgeScreen;
//import github.xuulmedia.neolith.init.ModBlocks;
//import github.xuulmedia.neolith.recipe.ForgeRecipe;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.IFocusGroup;
//import mezz.jei.api.recipe.RecipeIngredientRole;
//import mezz.jei.api.recipe.RecipeType;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//
//public class ForgeRecipeCategory  implements IRecipeCategory<ForgeRecipe> {
//    public final static ResourceLocation UID = new ResourceLocation(Neolith.MODID, "forge_recipe");
//    public final static ResourceLocation TEXTURE = ForgeScreen.TEXTURE;
//
//    private final IDrawable background;
//    private final IDrawable icon;
//
//    public ForgeRecipeCategory(IGuiHelper helper) {
//        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
//        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FORGE.get()));
//    }
//
//    @Override
//    public RecipeType<ForgeRecipe> getRecipeType() {
//        return jeiPlugin.FORGE_HEAT_TYPE;
//    }
//
//    @Override
//    public Component getTitle() {
//        return Component.translatable(ForgeBE.DISPLAY_NAME);
//    }
//
//    @Override
//    public IDrawable getBackground() {
//        return this.background;
//    }
//
//    @Override
//    public IDrawable getIcon() {
//        return this.icon;
//    }
//
//    @Override
//    public void setRecipe(IRecipeLayoutBuilder builder, ForgeRecipe recipe, IFocusGroup focuses) {
//        builder.addSlot(RecipeIngredientRole.INPUT, 56, 17).addIngredients(recipe.getIngredients().get(0));
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(recipe.getResult());
//    }
//}
