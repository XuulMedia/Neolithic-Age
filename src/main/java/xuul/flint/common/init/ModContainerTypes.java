package xuul.flint.common.init;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xuul.flint.Flint;
import xuul.flint.client.BasketScreen;
import xuul.flint.client.FlintStationScreen;
import xuul.flint.common.gui.BasketMenu;
import xuul.flint.common.gui.FlintStationMenu;

public final class ModContainerTypes {

	private ModContainerTypes() {}

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Flint.MOD_ID);


    public static final RegistryObject<MenuType<FlintStationMenu>> FLINT_STATION_CONTAINER = CONTAINERS.register("flint_station",
            () -> IForgeMenuType.create((windowId, inv, data) -> new FlintStationMenu(windowId, data.readBlockPos(), inv, inv.player)));

    public static final RegistryObject<MenuType<BasketMenu>> BASKET_CONTAINER = CONTAINERS.register("basket", () -> IForgeMenuType.create(BasketMenu::createClientMenu));

	@OnlyIn(Dist.CLIENT)
	public static void registerMenuScreens() {
		MenuScreens.register(ModContainerTypes.FLINT_STATION_CONTAINER.get(), FlintStationScreen::new);
		MenuScreens.register(ModContainerTypes.BASKET_CONTAINER.get(), BasketScreen::new);
	}

}
