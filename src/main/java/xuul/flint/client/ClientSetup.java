package xuul.flint.client;

import xuul.flint.common.init.ModContainerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    public static void init(FMLClientSetupEvent event){
        event.enqueueWork(() -> {
            MenuScreens.register(ModContainerTypes.FLINT_STATION_CONTAINER.get(), FlintStationScreen::new);
        });

    }
}
