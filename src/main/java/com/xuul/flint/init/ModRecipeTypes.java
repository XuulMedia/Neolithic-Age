package com.xuul.flint.init;

import com.xuul.flint.Flint;
import com.xuul.flint.recipe.FlintStationRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.util.Lazy;

import java.util.function.Supplier;


public class ModRecipeTypes {
    public static final Supplier<RecipeType<FlintStationRecipe>> FLINT_STATION = register("flint_station");


    public static void registerRecipeTypes() {
        FLINT_STATION.get();
    }


    private static <R extends Recipe<?>> Supplier<RecipeType<R>> register(String name) {
        return Lazy.of(() -> RecipeType.register(new ResourceLocation(Flint.MOD_ID, name).toString()));
    }
}