package com.xuul.flint.init;

import com.xuul.flint.Flint;
import com.xuul.flint.block.FlintStationContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainerTypes {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Flint.MOD_ID);


    public static final RegistryObject<MenuType<FlintStationContainer>> FLINT_STATION_CONTAINER = CONTAINERS.register("flint_station",
            () -> IForgeMenuType.create((windowId, inv, data) -> new FlintStationContainer(windowId, data.readBlockPos(), inv, inv.player)));

}
