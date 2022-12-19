package ca.xuul.flint;

import ca.xuul.flint.init.*;
import ca.xuul.flint.client.ClientSetup;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(Flint.MOD_ID)
public class Flint {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "flint";

    public Flint() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(ModEvents.class);
        ModBlockEntities.BLOCK_ENTITIES.register(bus);
        ModMenuTypes.MENUS.register(bus);
        ModRecipeSerializers.RECIPES.register(bus);

        // Register the setup method for modloading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
//        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }

    /*Creative mode tabs*/
    public static final CreativeModeTab FLINT_TAB = new CreativeModeTab(MOD_ID + "stone_age") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ModItems.CHUNK_GRANITE.get().getDefaultInstance();
        }
    };
    public static final CreativeModeTab METAL_TAB = new CreativeModeTab(MOD_ID + "metal_age") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ModItems.INGOT_STEEL.get().getDefaultInstance();
        }
    };




}
