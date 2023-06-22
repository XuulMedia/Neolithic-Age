package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    public static final RegistryObject<CreativeModeTab> STONE_AGE_TAB = CREATIVE_MODE_TABS.register((Neolith.MODID + "stone_age"), () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.stone_age." + Neolith.MODID))
            .icon(() -> ModItems.CHUNK_STONE.get().getDefaultInstance())
            .displayItems((enabledFeatures, entries) ->
                    STONE_AGE_ITEMS.forEach(itemLike -> entries.accept(itemLike.get())))
            .withSearchBar()
            .build());




    public static final RegistryObject<CreativeModeTab> METAL_AGE_TAB = CREATIVE_MODE_TABS.register((Neolith.MODID + "metal_age"), () -> CreativeModeTab.builder()
            .title(Component.translatable("bronze_age" + Neolith.MODID))
            .icon(() -> ModItems.INGOT_BRONZE.get().getDefaultInstance())
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ModBlocks.ORE_TIN.get());
                entries.accept(ModBlocks.ORE_SILVER.get());
                entries.accept(ModBlocks.BLOCK_TIN.get());
                entries.accept(ModBlocks.BLOCK_SILVER.get());
                entries.accept(ModBlocks.BLOCK_BRONZE.get());
                entries.accept(ModBlocks.BLOCK_STEEL.get());

//                entries.accept(BRONZE_SWORD.get());
//                entries.accept(BRONZE_PICK.get());
//                entries.accept(BRONZE_SHOVEL.get());
//                entries.accept(BRONZE_AXE.get());
//                entries.accept(BRONZE_HOE.get());
//
//                entries.accept(RAW_TIN.get());
//                entries.accept(RAW_SILVER.get());
//                entries.accept(INGOT_TIN.get());
//                entries.accept(INGOT_BRONZE.get());
//                entries.accept(INGOT_STEEL.get());
//                entries.accept(INGOT_SILVER.get());
//                entries.accept(NUGGET_COPPER.get());
//                entries.accept(NUGGET_TIN.get());
//                entries.accept(NUGGET_BRONZE.get());
//                entries.accept(NUGGET_STEEL.get());
//                entries.accept(NUGGET_SILVER.get());
//                entries.accept(DUST_IRON.get());
//                entries.accept(DUST_GOLD.get());
//                entries.accept(DUST_COPPER.get());
//                entries.accept(DUST_TIN.get());
//                entries.accept(DUST_BRONZE.get());
//                entries.accept(DUST_STEEL.get());
//                entries.accept(DUST_SILVER.get());
//
//                entries.accept(BRONZE_HELMET.get());
//                entries.accept(BRONZE_CHEST.get());
//                entries.accept(BRONZE_LEGS.get());
//                entries.accept(BRONZE_BOOTS.get());
            }).build());


    private static <T extends Item> RegistryObject<T> addToTab(List<Supplier<? extends ItemLike>> list, RegistryObject<T> itemLike) {
        list.add(itemLike);
        return itemLike;
    }

    public static <T extends Item> RegistryObject<T> addToStoneAgeTab(RegistryObject<T> itemLike){
        addToTab(STONE_AGE_ITEMS, itemLike);
        return itemLike;
    }

    public static <T extends Item> RegistryObject<T> addToMetalAgeTab(RegistryObject<T> itemLike){
        addToTab(METAL_AGE_ITEMS, itemLike);
        return itemLike;
    }



    //Adding to vanilla tab

//    @SubscribeEvent
//    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
//        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.getEntries().putAfter(Items.ACACIA_LOG.getDefaultInstance(), ModItems.INGOT_BRONZE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
//        }
//    }
}


