package github.xuulmedia.neolith.gui.menu;

import github.xuulmedia.neolith.recipe.HeatingFuelRecipe;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static github.xuulmedia.neolith.block.entity.AbstractHeatingBlockEntity.*;

public abstract class AbstractHeatCookMenu extends AbstractNeolithMenu{

    protected final ContainerData data;
    protected List<HeatingFuelRecipe> fuels;

    protected AbstractHeatCookMenu(@Nullable MenuType<?> pMenuType, int pContainerId, ContainerData data) {
        super(pMenuType, pContainerId);
        this.data = data;
    }

    public float fuelProportion() {
        var maxFuel = this.data.get(INDEX_MAX_FUEL_LEFT);
        if (maxFuel < 0) {
            return 0f;
        }
        return (float) this.data.get(INDEX_FUEL_LEFT) / (float) maxFuel;
    }

    public float progressProportion() {
        var maxProgress = this.data.get(INDEX_MAX_PROGRESS);
        if (maxProgress < 0) {
            return 0f;
        }
        return (float) this.data.get(INDEX_PROGRESS) / (float) maxProgress;
    }

    public float heatProportion() {
        return (float) this.data.get(INDEX_HEAT) / (float) MAX_HEAT;
    }

    public int heat() {
        return this.data.get(INDEX_HEAT);
    }

    public int targetHeat() {
        return this.data.get(INDEX_TARGET_HEAT);
    }

    public boolean isBurningFuel() {
        return this.data.get(INDEX_MAX_FUEL_LEFT) >= 0;
    }


    public @Nullable Integer maxHeatOf(ItemStack stack) {
        for (var fuel : this.fuels) {
            if (fuel.input.test(stack)) {
                return fuel.maxHeat;
            }
        }
        return null;
    }

    protected @Nullable Integer heatReqdToCookInput() {

        return null;
    }



}
