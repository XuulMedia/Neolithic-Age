package com.xuul.flint;

import com.xuul.flint.init.ModBlocks;
import com.xuul.flint.init.ModItems;
import com.xuul.flint.util.CustomTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;

@Mod(Flint.MOD_ID)
public class Flint
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "flint";

    public Flint() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
    }

    /*Creative Mode Tabs*/
    public static final CustomTabs FLINT_TAB = new CustomTabs("flint_tab", ModItems.DUST_IRON);
    public static final CustomTabs IRON_TAB = new CustomTabs("iron_tab", ModItems.INGOT_STEEL);

}
