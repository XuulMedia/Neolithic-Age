package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Neolith.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Neolith.MODID);


    public static final List<Supplier<? extends ItemLike>> STONE_AGE_ITEMS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> METAL_AGE_ITEMS = new ArrayList<>();

    //CreativeModeTabs
    public static final RegistryObject<CreativeModeTab> STONE_AGE_TAB = CREATIVE_MODE_TABS.register("stone_age_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.stone_age." + Neolith.MODID))
            .icon(() -> ModItems.CHUNK_STONE.get().getDefaultInstance())
            .displayItems((enabledFeatures, entries) ->
                    STONE_AGE_ITEMS.forEach(itemLike -> entries.accept(itemLike.get())))
            .withSearchBar()
            .build());

    public static final RegistryObject<CreativeModeTab> METAL_AGE_TAB = CREATIVE_MODE_TABS.register("metal_age_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("metal_age" + Neolith.MODID))
            .icon(() -> ModItems.INGOT_BRONZE.get().getDefaultInstance())
            .withTabsBefore(new ResourceLocation(Neolith.MODID, "stone_age_tab"))
            .displayItems((enabledFeatures, entries) ->
                    METAL_AGE_ITEMS.forEach(itemLike -> entries.accept(itemLike.get())))
            .withSearchBar()
            .build());


    /*HELPERS*/
    private static <T extends Item> RegistryObject<T> addToTab(List<Supplier<? extends ItemLike>> list, RegistryObject<T> itemLike) {
        list.add(itemLike);
        return itemLike;
    }

    public static <T extends Item> RegistryObject<T> addToStoneAgeTab(RegistryObject<T> itemLike) {
        addToTab(STONE_AGE_ITEMS, itemLike);
        return itemLike;
    }

    public static <T extends Item> RegistryObject<T> addToMetalAgeTab(RegistryObject<T> itemLike) {
        addToTab(METAL_AGE_ITEMS, itemLike);
        return itemLike;
    }

    public enum TAB_NAME {
        STONE_AGE,
        METAL_AGE
    }


    //Adding to vanilla tab

//    @SubscribeEvent
//    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
//        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.getEntries().putAfter(Items.ACACIA_LOG.getDefaultInstance(), ModItems.INGOT_BRONZE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
//        }
//    }
}


