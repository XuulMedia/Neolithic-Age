package com.xuul.flint.datagen;

import com.xuul.flint.init.ModItems;
import com.xuul.flint.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;


import java.util.function.Consumer;

public class ModRecipes extends RecipeProvider {

    public ModRecipes(DataGenerator generatorIn) {super(generatorIn);}

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer){

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.ORE_TIN_ITEM.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(ModItems.ORE_TIN_ITEM.get()))
                .save(consumer, "ingot_tin1");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_TIN.get()),
                ModItems.INGOT_TIN.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(ModItems.RAW_TIN.get()))
                .save(consumer, "ingot_tin2");

    }
}
