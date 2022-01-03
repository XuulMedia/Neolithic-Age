package com.xuul.flint.init;

import com.xuul.flint.recipe.FlintStationRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public interface ModRecipeTypes<R extends Recipe<?>> extends net.minecraftforge.registries.IForgeRegistryEntry<RecipeSerializer<?>> {

    static final RecipeType<FlintStationRecipe> FLINT_STATION = register("flint_station");



    static <R extends Recipe<?>> RecipeType<R> register(final String identifier) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(identifier), new RecipeType<R>() {
            public String toString() {
                return identifier;
            }
        });





}