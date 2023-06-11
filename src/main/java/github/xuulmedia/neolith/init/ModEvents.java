package github.xuulmedia.neolith.init;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.storage.PrimaryLevelData;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {
    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        if (event.getLevel().isClientSide()) return;
        if (!(event.getLevel() instanceof ServerLevel world)) return;
        if (!(world.getLevelData() instanceof PrimaryLevelData data)) return;
        GameRules rules = data.getGameRules();
        if (((ServerLevel) event.getLevel()).getGameRules().getBoolean(GameRules.RULE_NATURAL_REGENERATION) == true) {
            rules.getRule(GameRules.RULE_NATURAL_REGENERATION).set(false, world.getServer());
            System.out.println("Natural regeneration is set to false");
        };
    };
}

