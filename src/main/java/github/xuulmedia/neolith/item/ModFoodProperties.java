package github.xuulmedia.neolith.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModFoodProperties {
    public static final FoodProperties SALVE = new FoodProperties.Builder().saturationMod(0).alwaysEat().fast()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60), 1).build();

}
