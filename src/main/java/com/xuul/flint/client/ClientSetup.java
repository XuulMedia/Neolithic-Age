package com.xuul.flint.client;

import com.xuul.flint.client.FlintStationScreen;
import com.xuul.flint.init.ModContainerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    public static void init(FMLClientSetupEvent event){
        event.enqueueWork(() -> {
            MenuScreens.register(ModContainerTypes.FLINT_STATION_CONTAINER.get(), FlintStationScreen::new);
        });

    }
}
