package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.util.BaseToolMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolMaterials {
    private ModToolMaterials(){}

//    protected static final Tier BRONZE = new BaseToolMaterial(0,16,2,6.0f,320,
//            () -> Ingredient.of(ModItems.INGOT_BRONZE.get()));
//

//    protected static final Tier FLINT = new BaseToolMaterial(0,5,2,2f,100,
//            () -> Ingredient.of(Items.FLINT));

    public static final ForgeTier FLINT = new ForgeTier(1, 100,2f,0,5,ModTags.NEEDS_FLINT_TOOL,
            () -> Ingredient.of(Items.FLINT));


    protected static final Tier BRONZE = new ForgeTier(1,320,6f,0,16,ModTags.NEEDS_BRONZE_TOOL,
            () -> Ingredient.of(ModItems.INGOT_BRONZE.get()));

}
