package github.xuulmedia.neolith.event;

import github.xuulmedia.neolith.Flint;
import github.xuulmedia.neolith.block.entity.renderer.ModCampfireBlockEntityRenderer;
import github.xuulmedia.neolith.init.ModBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = Neolith.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
    }



    @Mod.EventBusSubscriber(modid = Neolith.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.CAMPFIRE.get(),
                    ModCampfireBlockEntityRenderer::new);
        }
    }
}
