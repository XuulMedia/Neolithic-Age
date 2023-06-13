package github.xuulmedia.neolith.block.workstation;

import github.xuulmedia.neolith.gui.menu.FlintStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class FlintStationBlock extends Block {
    private static final Component CONTAINER_TITLE = Component.translatable("container.flint_station");

    public FlintStationBlock() {
        super(Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .strength(2.0f)
                .requiresCorrectToolForDrops()
                .mapColor(MapColor.STONE));
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));;
            return InteractionResult.CONSUME;
        }
    }

    public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
        return new SimpleMenuProvider((p_52229_, p_52230_, p_52231_) -> {
            return new FlintStationMenu(p_52229_, p_52230_, ContainerLevelAccess.create(pLevel, pPos));
        }, CONTAINER_TITLE);
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    private static final VoxelShape RENDER_SHAPE = Shapes.box(0, 0, 0, 1, .5, 1);

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.5, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.5, 0.125, 0.375, 0.5625, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.5, 0.25, 0.3125, 0.5625, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.5, 0.5, 0.5625, 0.5625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.5, 0.3125, 0.75, 0.5625, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.5, 0.5625, 0.4375, 0.5625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.5, 0.6875, 0.3125, 0.5625, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.875, 0.5, 0.5625, 0.9375, 0.5625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 0.5, 0.5625, 0.875, 0.5625, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.5, 0.5625, 0.8125, 0.5625, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0.5, 0.5625, 0.75, 0.5625, 0.8125), BooleanOp.OR);

        return shape;
    }

    private static final Optional<VoxelShape> SHAPE = Optional.of(makeShape());

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE.get();
    }

}

