package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.recipe.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(
            ForgeRegistries.RECIPE_SERIALIZERS, Neolith.MODID);
    public static void register(IEventBus eventBus){
        RECIPES.register(eventBus);
    }

    public static final RegistryObject<RecipeSerializer<?>> MANUAL_GRINDER_SERIALIZER = RECIPES.register(
            "manual_grinder", () -> ManualGrinderRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ForgeRecipe>> FORGE_SERIZALIZER = RECIPES.register(
            "forge_recipe", () -> ForgeRecipe.SERIALIZER);

    public static final RegistryObject<RecipeSerializer<FoundryRecipe>> FOUNDRY_SERIZALIZER = RECIPES.register(
            "foundry_recipe", () -> FoundryRecipe.SERIALIZER);


    public static final RegistryObject<RecipeSerializer<FlintStationRecipe>> FLINT_STATION_SERIALIZER = RECIPES.register(
            "flint_station",  () -> FlintStationRecipe.SERIALIZER);
    public static final RegistryObject<RecipeSerializer<HeatingFuelRecipe>> HEATING_FUEL_RECIPE = RECIPES.register(
            "heating_fuel",   () -> HeatingFuelRecipe.SERIALIZER);


}
