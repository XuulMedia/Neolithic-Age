package com.xuul.flint.init;

import com.xuul.flint.Flint;
import com.xuul.flint.block.FlintStationContainer;
import com.xuul.flint.block.FlintStationRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public interface ModRecipeTypes<T extends Recipe<?>> extends net.minecraftforge.registries.IForgeRegistryEntry<RecipeSerializer<?>> {

    RecipeType<FlintStationRecipe> FLINT_STATION = register("flint_station");


    static <T extends Recipe<?>> RecipeType<T> register(final String pIdentifier) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(pIdentifier), new RecipeType<T>() {
            public String toString() {
                return pIdentifier;
            }
        });


    }



}