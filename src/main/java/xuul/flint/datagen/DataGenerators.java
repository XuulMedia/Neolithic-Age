package xuul.flint.datagen;

import xuul.flint.Flint;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Flint.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), new ModRecipes(generator));
        generator.addProvider(event.includeServer(), new ModLootTables(generator));
        ModBlockTags blockTags = new ModBlockTags(generator, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTags(generator, blockTags, event.getExistingFileHelper()));
//        generator.addProvider(event.includeServer(), new ModBiomeTags(generator, event.getExistingFileHelper()));
//        generator.addProvider(event.includeServer(), new ModStructureSetTags(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModBlockStates(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModItemModels(generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(generator, "en_us"));
    }


}
