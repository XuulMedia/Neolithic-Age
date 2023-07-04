package github.xuulmedia.neolith.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SALVE = new FoodProperties.Builder()
            .saturationMod(0)
            .alwaysEat()
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, sec(3)), 1)
            .build();

    /*HAZARD TIER*/
    public static final FoodProperties DANGER = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0)
            .effect(new MobEffectInstance(MobEffects.HUNGER, sec(30), 0), 1)
            .effect(new MobEffectInstance(MobEffects.POISON, sec(60), 1), 1.0F)
            .build();

    public static final FoodProperties RAW_MEAT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0)
            .effect(new MobEffectInstance(MobEffects.HUNGER, sec(30), 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.POISON, sec(60), 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, sec(15), 0), 1.0F)
            .meat()
            .build();


    /*LOW TIER*/
    public static final FoodProperties RAW_VEG = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F)
            .build();

    public static final FoodProperties BERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3F)
            .alwaysEat()
            .fast()
            .build();


    /*BASIC TIER*/
    public static final FoodProperties COOKED_MEAT = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.6F)
            .meat()
            .build();
    public static final FoodProperties COOKED_MEAT_SMALL = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.5F)
            .meat()
            .build();

    public static final FoodProperties BASIC = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.6F)
            .build();



    /*GOOD TIER*/
    public static final FoodProperties STEW = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.8F)
            .meat()
            .build();

    public static final FoodProperties GOOD = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.8F)
            .build();

    public static final FoodProperties MEAL_WITH_MEAT = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, sec(60), 0), 1.0F)
            .meat()
            .build();
    public static final FoodProperties MEAL = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, sec(60), 0), 1.0F)
            .build();




    /*SUPER TIER*/




    //seconds helper so code is more readable
    private static int sec(int timeInSeconds){
        return 20 * timeInSeconds;
    }
}

