package github.xuulmedia.neolith.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;

public class ModWallTorchBlock extends ModTorchBlock {
    protected static final float AABB_OFFSET = 2.5F;
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D), Direction.SOUTH, Block.box(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D), Direction.WEST, Block.box(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D), Direction.EAST, Block.box(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D)));
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ModWallTorchBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, true)
                .setValue(BURNTIME, BURN_TICKS));
    }

    public String getDescriptionId() {
        return this.asItem().getDescriptionId();
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return WallTorchBlock.getShape(pState);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        BlockPos blockpos = pPos.relative(direction.getOpposite());
        BlockState blockstate = pLevel.getBlockState(blockpos);
        Boolean toReturn = blockstate.isFaceSturdy(pLevel, blockpos, direction);
        return toReturn;

    }


//    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
//        Direction direction = pState.getValue(FACING);
//        BlockPos blockpos = pPos.relative(direction.getOpposite());
//        BlockState blockstate = pLevel.getBlockState(blockpos);
//        return blockstate.isFaceSturdy(pLevel, blockpos, direction);
//    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BURNTIME, FACING, LIT);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState blockstate = Blocks.WALL_TORCH.getStateForPlacement(pContext);
        return blockstate == null ? null : this.defaultBlockState().setValue(FACING, blockstate.getValue(FACING));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return pFacing.getOpposite() == pState.getValue(FACING) && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : pState;
    }
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            Direction direction = pState.getValue(FACING).getOpposite();
            double d0 = 0.27D;
            double d1 = (double)pPos.getX() + 0.5D + (pRandom.nextDouble() - 0.5D) * 0.2D + 0.27D * (double)direction.getStepX();
            double d2 = (double)pPos.getY() + 0.7D + (pRandom.nextDouble() - 0.5D) * 0.2D + 0.22D;
            double d3 = (double)pPos.getZ() + 0.5D + (pRandom.nextDouble() - 0.5D) * 0.2D + 0.27D * (double)direction.getStepZ();
            pLevel.addParticle(this.flameParticle, d1, d2, d3, 0.0D, 0.0D, 0.0D);
        }
    }

}

