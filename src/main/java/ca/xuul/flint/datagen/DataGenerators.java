package ca.xuul.flint.datagen;

import ca.xuul.flint.Flint;

import ca.xuul.flint.datagen.loot.BlockLootTableProvider;
import ca.xuul.flint.datagen.loot.EntityLootTableProvider;
import ca.xuul.flint.datagen.loot.ModLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Flint.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), new ModRecipeProvider(generator));

        generator.addProvider(event.includeServer(), new ModLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new BlockLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new EntityLootTableProvider(generator));


        ModBlockTagProvider blockTags = new ModBlockTagProvider(generator, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(generator, blockTags, event.getExistingFileHelper()));
//        generator.addProvider(event.includeServer(), new ModBiomeTags(generator, event.getExistingFileHelper()));
//        generator.addProvider(event.includeServer(), new ModStructureSetTags(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(generator, "en_us"));
    }


}
