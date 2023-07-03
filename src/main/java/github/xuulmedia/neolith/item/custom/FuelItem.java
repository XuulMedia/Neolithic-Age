package github.xuulmedia.neolith.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class FuelItem extends Item {
    public int heatLevel;
    public String name;
    public static final String NO_SHIFT_MESSAGE ="fuel.no_shift";

    public FuelItem(Properties pProperties, int heatLevel, String name) {
        super(pProperties);
        this.heatLevel= heatLevel;
        this.name = "heat.level." + name;
    }

    public int getHeat(){
        return this.heatLevel;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable(name, Integer.toString(this.heatLevel)));
        } else {
            pTooltipComponents.add(Component.translatable(NO_SHIFT_MESSAGE).withStyle(ChatFormatting.ITALIC));
        }
    }
}
