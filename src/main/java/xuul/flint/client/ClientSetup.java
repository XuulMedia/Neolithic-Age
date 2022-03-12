package xuul.flint.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import xuul.flint.Flint;
import xuul.flint.common.init.ModMenuTypes;
import xuul.flint.common.init.ModItems;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Flint.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientSetup {

	private ClientSetup() {}

	@SubscribeEvent
    public static void init(FMLClientSetupEvent event){
        event.enqueueWork(() -> {
            ModMenuTypes.registerMenuScreens();
        });
    }

	@SubscribeEvent
	public static void onItemColorRegistry(final ColorHandlerEvent.Item event) {
		event.getItemColors().register((stack, index) -> index == 0 ? ModItems.BASKET.get().getColor(stack) : -1, ModItems.BASKET.get());
	}

}
