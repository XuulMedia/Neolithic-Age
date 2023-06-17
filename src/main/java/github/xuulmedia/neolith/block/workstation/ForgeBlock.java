package github.xuulmedia.neolith.block.workstation;

import github.xuulmedia.neolith.block.entity.ForgeBE;
import github.xuulmedia.neolith.init.ModBlockEntities;
import github.xuulmedia.neolith.block.entity.AbstractHeatingBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ForgeBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final String HEAT_MESSAGE ="container.flint.forge.heat";
    public static final String HEAT_TARGET_MESSAGE ="container.flint.forge.heat.target";
    public static final String TOO_COLD_MESSAGE ="container.flint.forge.heat.too_cold";

    public ForgeBlock(Properties props) {
        super(props);
        this.registerDefaultState(
                this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter reader, List<Component> list, TooltipFlag flags) {
        list.add(Component.translatable(HEAT_MESSAGE, Integer.toString(AbstractHeatingBlockEntity.INDEX_HEAT))
                .withStyle(ChatFormatting.YELLOW));
        list.add(Component.translatable(HEAT_TARGET_MESSAGE, Integer.toString(AbstractHeatingBlockEntity.INDEX_TARGET_HEAT))
                .withStyle(ChatFormatting.BLUE));
        list.add(Component.translatable(TOO_COLD_MESSAGE, Integer.toString(AbstractHeatingBlockEntity.INDEX_MAX_PROGRESS))
                .withStyle(ChatFormatting.BLUE));
    }


    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.1875, 0.125, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0.0625, 0.875, 0.125, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0.8125, 0.875, 0.125, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.8125, 0.1875, 0.125, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.125, 0.0625, 0.875, 0.8125, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.8125, 0.3125, 0.875, 1, 0.9375), BooleanOp.OR);
        return shape;
    }

    private static final Optional<VoxelShape> SHAPE = Optional.of(makeShape());

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE.get();
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
                : createTickerHelper(pBlockEntityType, ModBlockEntities.FORGE.get(), ForgeBE::tick);
    }


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
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof ForgeBE) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (ForgeBE)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ForgeBE(pPos, pState);
    }


    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ForgeBE fbe) {
                fbe.drops();
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }

    }

}
