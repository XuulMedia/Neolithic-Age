package ca.xuul.flint.init;

import ca.xuul.flint.Flint;
import ca.xuul.flint.gui.*;
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

    private ModMenuTypes() {
    }

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES,
        Flint.MOD_ID);


    public static final RegistryObject<MenuType<FlintStationMenu>> FLINT_STATION_CONTAINER = MENUS.register(
        "flint_station",
        () -> IForgeMenuType.create(
            (windowId, inv, data) -> new FlintStationMenu(windowId, data.readBlockPos(), inv, inv.player)));

    public static final RegistryObject<MenuType<GrindstoneMenu>> GRINDSTONE_CONTAINER = MENUS.register(
            "grindstone",
            () -> IForgeMenuType.create(
                    (windowId, inv, data) -> new GrindstoneMenu(windowId, data.readBlockPos(), inv, inv.player)));

    public static final RegistryObject<MenuType<BasketMenu>> BASKET_CONTAINER = MENUS.register("basket",
        () -> IForgeMenuType.create(BasketMenu::createClientMenu));


    public static final RegistryObject<MenuType<FoundryMenu>> FOUNDRY = MENUS.register("foundry",
        () -> IForgeMenuType.create(FoundryMenu::new));


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(
        IContainerFactory<T> factory,
        String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }


    @OnlyIn(Dist.CLIENT)
    public static void registerMenuScreens() {
        MenuScreens.register(ModMenuTypes.FLINT_STATION_CONTAINER.get(), FlintStationScreen::new);
        MenuScreens.register(ModMenuTypes.BASKET_CONTAINER.get(), BasketScreen::new);
        MenuScreens.register(ModMenuTypes.FOUNDRY.get(), FoundryScreen::new);
    }


//
//	public static final RegistryObject<MenuType<CobaltBlasterMenu>> COBALT_BLASTER_MENU =
//			registerMenuType(CobaltBlasterMenu::new, "cobalt_blaster_menu");
//
//
//	private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
//																								  String name) {
//		return MENUS.register(name, () -> IForgeMenuType.create(factory));
//	}

}
