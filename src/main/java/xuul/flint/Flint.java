package xuul.flint;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xuul.flint.common.init.ModBlocks;
import xuul.flint.common.init.ModContainerTypes;
import xuul.flint.common.init.ModItems;
import xuul.flint.common.init.ModRecipeSerializers;

@Mod(Flint.MOD_ID)
public class Flint
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "flint";

    /*Creative Mode Tabs*/

    public static final CreativeModeTab FLINT_TAB = new CreativeModeTab(MOD_ID +"stone_age") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CHUNK_GRANITE.get());
        }
    };

    public static final CreativeModeTab METAL_TAB = new CreativeModeTab(MOD_ID+"metal_age") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.INGOT_STEEL.get());
        }
    };


    public Flint() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModContainerTypes.CONTAINERS.register(bus);
        ModRecipeSerializers.RECIPES.register(bus);
    }



}
