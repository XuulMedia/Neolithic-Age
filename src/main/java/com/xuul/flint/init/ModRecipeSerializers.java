package com.xuul.flint.init;

import com.xuul.flint.Flint;
import com.xuul.flint.recipe.FlintStationRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Flint.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> FLINT_STATION = RECIPES.register(Flint.MOD_ID + "flint_station", () ->
            FlintStationRecipe.SERIALIZER);
}
