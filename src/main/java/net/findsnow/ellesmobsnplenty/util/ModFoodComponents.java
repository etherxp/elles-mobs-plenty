package net.findsnow.ellesmobsnplenty.util;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent SHARK_MEAT =
            new FoodComponent.Builder()
                    .nutrition(3)
                    .saturationModifier(0.3f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.6f)
                    .build();
    public static final FoodComponent COOKED_SHARK_MEAT =
            new FoodComponent.Builder()
                    .nutrition(9)
                    .saturationModifier(0.9f)
                    .build();
    public static final FoodComponent CRAB_MEAT =
            new FoodComponent.Builder()
                    .nutrition(3)
                    .saturationModifier(0.3f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.6f)
                    .build();
    public static final FoodComponent COOKED_CRAB_MEAT =
            new FoodComponent.Builder()
                    .nutrition(8)
                    .saturationModifier(0.8f)
                    .build();
    public static final FoodComponent RAW_SHRIMP =
            new FoodComponent.Builder()
                    .nutrition(3)
                    .saturationModifier(0.3f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.6f)
                    .build();
    public static final FoodComponent COOKED_SHRIMP =
            new FoodComponent.Builder()
                    .nutrition(8)
                    .saturationModifier(0.8f)
                    .build();


}
