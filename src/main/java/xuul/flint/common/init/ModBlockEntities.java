package xuul.flint.common.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xuul.flint.Flint;
import xuul.flint.common.block.entity.KilnBlockEntity;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Flint.MOD_ID);


    public static final RegistryObject<BlockEntityType<KilnBlockEntity>> KILN = BLOCK_ENTITIES.register("kiln",
            () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN_BLOCK.get()).build(null));





}
