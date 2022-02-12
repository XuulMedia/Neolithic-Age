package xuul.flint.common.init;

import xuul.flint.Flint;
import xuul.flint.common.gui.BasketContainer;
import xuul.flint.common.gui.FlintStationContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainerTypes {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Flint.MOD_ID);


    public static final RegistryObject<MenuType<FlintStationContainer>> FLINT_STATION_CONTAINER = CONTAINERS.register("flint_station",
            () -> IForgeMenuType.create((windowId, inv, data) -> new FlintStationContainer(windowId, data.readBlockPos(), inv, inv.player)));

    public static final RegistryObject<MenuType<BasketContainer>> BASKET_CONTAINER = CONTAINERS.register("basket",
            () -> IForgeMenuType.create((windowId, inv, data) -> new BasketContainer(windowId, inv)));

}
