package com.xuul.flint.init;

import com.xuul.flint.util.BaseToolMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModToolMaterials {
    private ModToolMaterials(){}

    protected static final Tier BRONZE = new BaseToolMaterial(0,16,2,6.0f,320,
            () -> Ingredient.of(ModItems.INGOT_BRONZE.get()));
}
