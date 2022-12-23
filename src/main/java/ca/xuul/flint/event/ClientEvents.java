package ca.xuul.flint.event;

import ca.xuul.flint.Flint;
import ca.xuul.flint.block.entity.renderer.ModCampfireBlockEntityRenderer;
import ca.xuul.flint.init.ModBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = Flint.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
    }



    @Mod.EventBusSubscriber(modid = Flint.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.CAMPFIRE.get(),
                    ModCampfireBlockEntityRenderer::new);
        }
    }
}
