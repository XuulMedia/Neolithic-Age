package ca.xuul.flint.init;

import ca.xuul.flint.Flint;
import ca.xuul.flint.util.BaseArmorMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class ModArmorMaterial{

    private ModArmorMaterial(){}

    public static final ArmorMaterial BRONZE = new BaseArmorMaterial(16, new int[] { 180, 200, 215, 160 },
            new int[] { 2, 5, 6, 2 }, 0f, 0f, Flint.MOD_ID + ":bronze",
            SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(ModItems.INGOT_BRONZE.get()));


}
