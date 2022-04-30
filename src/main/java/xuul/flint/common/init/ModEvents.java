package xuul.flint.common.init;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.storage.PrimaryLevelData;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {



    @SubscribeEvent
    public static void onWorldLoad(WorldEvent.Load event) {
        if (event.getWorld().isClientSide()) return;
        if (!(event.getWorld() instanceof ServerLevel world)) return;
        if (!(world.getLevelData() instanceof PrimaryLevelData data)) return;
        GameRules rules = data.getGameRules();
        if (((ServerLevel) event.getWorld()).getGameRules().getBoolean(GameRules.RULE_NATURAL_REGENERATION) == true) {
            rules.getRule(GameRules.RULE_NATURAL_REGENERATION).set(false, world.getServer());
            System.out.println("Natural regeneration is set to false");
        };
    };
}

