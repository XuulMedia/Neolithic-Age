package com.xuul.flint.recipe;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.Optional;

public interface IModRecipeType<T extends Recipe<?>> {

    RecipeType<CraftingRecipe> FLINT_STATION = register("crafting");


    static <T extends Recipe<?>> RecipeType<T> register(final String pIdentifier) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(pIdentifier), new RecipeType<T>() {
            public String toString() {
                return pIdentifier;
            }
        });
    }

    default <C extends Container> Optional<T> tryMatch(Recipe<C> pRecipe, Level pLevel, C pContainer) {
        return pRecipe.matches(pContainer, pLevel) ? Optional.of((T)pRecipe) : Optional.empty();
    }
}
