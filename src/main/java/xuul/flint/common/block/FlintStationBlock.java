package xuul.flint.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

public class FlintStationBlock extends Block {

    private static final Component CONTAINER_TITLE = new TranslatableComponent("container.flint_station");
    public static final String MESSAGE_FLINT_STATION = "message.flint_station";

    private static final VoxelShape RENDER_SHAPE = Shapes.box(0, 0, 0, 1, .5, 1);

    public FlintStationBlock() {
        super(Properties.of(Material.STONE)
                .strength(2.0f)
                .requiresCorrectToolForDrops());
    }

    @SuppressWarnings("deprecation")
    public InteractionResult use (BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if (!level.isClientSide) {
            MenuProvider containerProvider = new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return CONTAINER_TITLE;
                }
                @Override
                public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player playerEntity) {
                    return new FlintStationContainer(containerId, pos, playerInventory,playerEntity);
                }
            };
            NetworkHooks.openGui((ServerPlayer) player, containerProvider, pos);
        }
        return InteractionResult.SUCCESS;
    };


    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return RENDER_SHAPE;
    }
}
