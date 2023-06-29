package github.xuulmedia.neolith.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class FlintNodeBlock extends FallingBlock {
    public FlintNodeBlock(Properties prop) {
        super(prop);
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0.0625, 0.375, 0.625, 0.125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875), BooleanOp.OR);

        return shape;
    }

    private static final Optional<VoxelShape> SHAPE = Optional.of(makeShape());

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE.get();
    }

    @Override
    public boolean canBeReplaced(BlockState pState, Fluid pFluid) {
        return super.canBeReplaced(pState, pFluid);
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return pType == PathComputationType.AIR && !this.hasCollision || super.isPathfindable(pState, pLevel, pPos, pType);
    }
}
