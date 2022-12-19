package ca.xuul.flint.init;

import ca.xuul.flint.util.BaseToolMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModToolMaterials {
    private ModToolMaterials(){}

    protected static final Tier BRONZE = new BaseToolMaterial(0,16,2,6.0f,320,
            () -> Ingredient.of(ModItems.INGOT_BRONZE.get()));


    protected static final Tier FLINT = new BaseToolMaterial(0,5,2,2f,100,
            () -> Ingredient.of(Items.FLINT));
}
