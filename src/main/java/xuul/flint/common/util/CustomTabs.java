package xuul.flint.common.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class CustomTabs extends CreativeModeTab {
    private final RegistryObject<Item> item;

    public CustomTabs(final String ID, final RegistryObject<Item> item) {
        super(ID);

        this.item = item;
    }

    @Override
    public ItemStack makeIcon() {
        return item.get().getDefaultInstance();
    }
}
