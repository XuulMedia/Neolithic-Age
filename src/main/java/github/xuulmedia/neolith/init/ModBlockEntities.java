package github.xuulmedia.neolith.init;

import github.xuulmedia.neolith.Neolith;


import github.xuulmedia.neolith.block.entity.ManualGrinderBlockEntity;

import github.xuulmedia.neolith.block.entity.ModCampfireBlockEntity;
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
            () -> BlockEntityType.Builder.of(ModCampfireBlockEntity::new, ModBlocks.MANUAL_GRINDER.get()).build(null));

//
//    public static final RegistryObject<BlockEntityType<FoundryBlockEntity>> FOUNDRY = BLOCK_ENTITIES.register("foundry",
//        () -> BlockEntityType.Builder.of(FoundryBlockEntity::new, ModBlocks.FOUNDRY.get()).build(null));
//
//
//    public static final RegistryObject<BlockEntityType<ModCampfireBlockEntity>> CAMPFIRE = BLOCK_ENTITIES.register("campfire",
//            () -> BlockEntityType.Builder.of(ModCampfireBlockEntity::new, ModBlocks.CAMPFIRE.get()).build(null));
//
//    public static final RegistryObject<BlockEntityType<KilnBlockEntity>> KILN = BLOCK_ENTITIES.register("kiln",
//            () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN.get()).build(null));


}
