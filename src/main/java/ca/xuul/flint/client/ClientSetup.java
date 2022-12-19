package ca.xuul.flint.client;

import ca.xuul.flint.Flint;
import ca.xuul.flint.init.ModItems;
import ca.xuul.flint.init.ModMenuTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

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
	public static void onItemColorRegistry(final RegisterColorHandlersEvent.Item event) {
		event.getItemColors().register((stack, index) -> index == 0 ? ModItems.BASKET.get().getColor(stack) : -1, ModItems.BASKET.get());
	}

}
