package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import github.xuulmedia.neolith.gui.menu.FlintStationMenu;
import github.xuulmedia.neolith.gui.menu.FoundryMenu;
import github.xuulmedia.neolith.gui.menu.ManualGrinderMenu;
import github.xuulmedia.neolith.gui.screen.FoundryScreen;
import github.xuulmedia.neolith.gui.screen.ManualGrinderScreen;
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
    public static final RegistryObject<MenuType<FoundryMenu>> FOUNDRY_MENU =
            registerMenuType(FoundryMenu::new,"foundry_menu");




    @OnlyIn(Dist.CLIENT)
    public static void registerMenuScreens() {
        MenuScreens.register(ModMenuTypes.MANUAL_GRINDER_MENU.get(), ManualGrinderScreen::new);
        MenuScreens.register(ModMenuTypes.FOUNDRY_MENU.get(), FoundryScreen::new);
    }


    /*Helpers*/
    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
}


//    public static final RegistryObject<MenuType<FlintStationMenu>> FLINT_STATION_CONTAINER = MENUS.register(
//            "flint_station",
//            () -> IForgeMenuType.create(
//                    (windowId, inv, data) -> new FlintStationMenu(windowId, data.readBlockPos(), inv, inv.player)));
//
//
//    public static final RegistryObject<MenuType<BasketMenu>> BASKET_CONTAINER = MENUS.register("basket",
//            () -> IForgeMenuType.create(BasketMenu::createClientMenu));
//
//

//    public static final RegistryObject<MenuType<KilnMenu>> KILN = MENUS.register("kiln",
//            () -> IForgeMenuType.create(KilnMenu::new));
//









//        MenuScreens.register(ModMenuTypes.FLINT_STATION_CONTAINER.get(), FlintStationScreen::new);
//        MenuScreens.register(ModMenuTypes.BASKET_CONTAINER.get(), BasketScreen::new);
//        MenuScreens.register(ModMenuTypes.FOUNDRY.get(), FoundryScreen::new);
//        MenuScreens.register(ModMenuTypes.KILN.get(), KilnScreen::new);
//

