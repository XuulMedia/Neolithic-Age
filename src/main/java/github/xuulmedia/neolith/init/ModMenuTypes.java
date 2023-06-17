package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.gui.menu.*;
import github.xuulmedia.neolith.gui.screen.*;
import github.xuulmedia.neolith.gui.screen.FoundryScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Neolith.MODID);


    /*Menus*/
    public static final RegistryObject<MenuType<ManualGrinderMenu>> MANUAL_GRINDER_MENU =
            registerMenuType(ManualGrinderMenu::new, "manual_grinder_menu");
    public static final RegistryObject<MenuType<FlintStationMenu>> FLINT_STATION_MENU =
            registerMenuType(FlintStationMenu::new, "flint_station_menu");
    public static final RegistryObject<MenuType<ForgeMenu>> FORGE_MENU =
            registerMenuType(ForgeMenu::new,"forge_menu");
    public static final RegistryObject<MenuType<github.xuulmedia.neolith.gui.menu.FoundryMenu>> FOUNDRY_MENU =
            registerMenuType(github.xuulmedia.neolith.gui.menu.FoundryMenu::new,"foundry_menu");

    public static final RegistryObject<MenuType<BasketMenu>> BASKET_MENU = MENUS.register("basket_menu",
            () -> IForgeMenuType.create(BasketMenu::createClientMenu));


    @OnlyIn(Dist.CLIENT)
    public static void registerMenuScreens() {
        MenuScreens.register(ModMenuTypes.MANUAL_GRINDER_MENU.get(), ManualGrinderScreen::new);
        MenuScreens.register(ModMenuTypes.FLINT_STATION_MENU.get(), FlintStationScreen::new);
        MenuScreens.register(ModMenuTypes.FORGE_MENU.get(), ForgeScreen::new);
        MenuScreens.register(ModMenuTypes.FOUNDRY_MENU.get(), FoundryScreen::new);
        MenuScreens.register(ModMenuTypes.BASKET_MENU.get(), BasketScreen::new);
    }


    /*Helpers*/
    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
}



