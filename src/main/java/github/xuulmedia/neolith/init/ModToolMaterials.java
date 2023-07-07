package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.util.BaseToolMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolMaterials {
    private ModToolMaterials(){}
        public static final ForgeTier FLINT = new ForgeTier(1, 85,2f,0,5,ModTags.NEEDS_FLINT_TOOL,
            () -> Ingredient.of(Items.FLINT));
    protected static final ForgeTier BRONZE = new ForgeTier(2,165,4f,1,16,ModTags.NEEDS_BRONZE_TOOL,
            () -> Ingredient.of(ModItems.INGOT_BRONZE.get()));
    protected static final ForgeTier IRON = new ForgeTier(2,285,5f,2,12,ModTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.IRON_INGOT));
    protected static final ForgeTier STEEL = new ForgeTier(3,1561,8f,3,8,ModTags.NEEDS_STEEL_TOOL,
            () -> Ingredient.of(ModItems.INGOT_STEEL.get())); //equiv to diamond


//    protected static final ForgeTier DIAMOND = new ForgeTier(4,2031,9f,4,18,ModTags.NEEDS_BRONZE_TOOL,
//            () -> Ingredient.of(Items.DIAMOND)); // this is set to netherrite stats

}
