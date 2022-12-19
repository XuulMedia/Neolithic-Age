package ca.xuul.flint.init;

import ca.xuul.flint.Flint;
import ca.xuul.flint.block.entity.FoundryBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
        ForgeRegistries.BLOCK_ENTITY_TYPES, Flint.MOD_ID);



    public static final RegistryObject<BlockEntityType<FoundryBlockEntity>> FOUNDRY = BLOCK_ENTITIES.register("foundry",
        () -> BlockEntityType.Builder.of(FoundryBlockEntity::new, ModBlocks.FOUNDRY.get()).build(null));


}