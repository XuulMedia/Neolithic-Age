package xuul.flint.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import xuul.flint.common.block.entity.FoundryBlockEntity;
import xuul.flint.common.init.ModBlockEntities;

import java.util.Random;

public class FoundryBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public FoundryBlock(Properties props) {
        super(props);
        this.registerDefaultState(
            this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LIT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }


    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
        BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide
            ? null
            : createTickerHelper(pBlockEntityType, ModBlockEntities.FOUNDRY.get(), FoundryBlockEntity::tick);
    }

    @Override
    public void animateTick(BlockState bs, Level world, BlockPos pos, Random pRandom) {
        if (bs.getValue(LIT)) {
            double sx = pos.getX() + 0.5D;
            double sy = pos.getY();
            double sz = pos.getZ() + 0.5D;
            if (pRandom.nextDouble() < 0.1D) {
                world.playLocalSound(sx, sy, sz, SoundEvents.BLASTFURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F,
                    false);
            }

            var facing = bs.getValue(FACING);
            var axis = facing.getAxis();
            double offset = pRandom.nextDouble() * 0.6D - 0.3D;
            double x = axis == Direction.Axis.X ? facing.getStepX() * 0.52D : offset;
            double y = pRandom.nextDouble() * 9.0D / 16.0D;
            double z = axis == Direction.Axis.Z ? facing.getStepZ() * 0.52D : offset;
            world.addParticle(ParticleTypes.SMOKE, sx + x, sy + y, sz + z, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
        BlockHitResult pHit) {
        if (pLevel.isClientSide()) {
            return InteractionResult.SUCCESS;
        } else {
            var tile = pLevel.getBlockEntity(pPos);
            if (tile instanceof FoundryBlockEntity fbe) {
                NetworkHooks.openGui((ServerPlayer) pPlayer, fbe, pPos);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FoundryBlockEntity(pPos, pState);
    }


    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof FoundryBlockEntity fbe) {
                fbe.drops();
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }

    }

}
