package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;


import github.xuulmedia.neolith.block.entity.*;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
        ForgeRegistries.BLOCK_ENTITY_TYPES, Neolith.MODID);

    public static final RegistryObject<BlockEntityType<ManualGrinderBlockEntity>> MANUAL_GRINDER = BLOCK_ENTITIES.register("manual_grinder",
            () -> BlockEntityType.Builder.of(ManualGrinderBlockEntity::new, ModBlocks.MANUAL_GRINDER.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModCampfireBlockEntity>> CAMPFIRE = BLOCK_ENTITIES.register("campfire",
            () -> BlockEntityType.Builder.of(ModCampfireBlockEntity::new, ModBlocks.CAMPFIRE.get()).build(null));

    public static final RegistryObject<BlockEntityType<ForgeBE>> FORGE = BLOCK_ENTITIES.register("forge",
        () -> BlockEntityType.Builder.of(ForgeBE::new, ModBlocks.FORGE.get()).build(null));

    public static final RegistryObject<BlockEntityType<FoundryBE>> FOUNDRY = BLOCK_ENTITIES.register("kiln",
            () -> BlockEntityType.Builder.of(FoundryBE::new, ModBlocks.FOUNDRY.get()).build(null));


    public static final RegistryObject<BlockEntityType<WorkBenchBE>> WORK_BENCH = BLOCK_ENTITIES.register("workbench",
            () -> BlockEntityType.Builder.of(WorkBenchBE::new, ModBlocks.WORK_BENCH.get()).build(null));

    public static final RegistryObject<BlockEntityType<ClayPotBE>> CLAY_POT = BLOCK_ENTITIES.register("clay_pot",
            () -> BlockEntityType.Builder.of(ClayPotBE::new, ModBlocks.CLAY_POT.get()).build(null));

}
