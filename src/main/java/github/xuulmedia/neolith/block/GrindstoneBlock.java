package github.xuulmedia.neolith.block;

import github.xuulmedia.neolith.gui.GrindstoneMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;


public class GrindstoneBlock extends Block {

    private static final Component CONTAINER_TITLE = Component.literal("container.grindstone");
    public static final String MESSAGE_GRINDSTONE = "message.grindstone";

    public GrindstoneBlock() {
        super(Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
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
                    return new GrindstoneMenu(containerId, pos, playerInventory,playerEntity);
                }
            };
            NetworkHooks.openScreen((ServerPlayer) player, containerProvider, pos);
        }
        return InteractionResult.SUCCESS;
    };

//
//    public InteractionResult use (BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
//        if (!level.isClientSide) {
//            MenuProvider containerProvider = new MenuProvider() {
//                @Override
//                public Component getDisplayName() {
//                    return CONTAINER_TITLE;
//                }
//                @Override
//                public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player playerEntity) {
//                    return new FlintStationMenu(containerId, pos, playerInventory,playerEntity);
//                }
//            };
//            NetworkHooks.openScreen((ServerPlayer) player, containerProvider, pos);
//        }
//        return InteractionResult.SUCCESS;
//    };

}
