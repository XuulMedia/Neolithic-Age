package github.xuulmedia.neolith.util;

import net.minecraft.world.SimpleContainer;

public abstract class HeatingFuelContainer extends SimpleContainer {
    public HeatingFuelContainer(int pSize) {
        super(pSize);
    }

    public abstract int getFuelSlot();
}
