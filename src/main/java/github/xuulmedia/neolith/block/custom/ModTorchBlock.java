package github.xuulmedia.neolith.block.custom;

import github.xuulmedia.neolith.init.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class ModTorchBlock extends TorchBlock {
    protected static final int BURN_MIN = 5; // how long in min the torchs will burn
    protected static final int DELAY = 600; // 600 ticks is 30 seconds This is the delay between each tick
    protected static int BURN_TICKS = 2 * BURN_MIN;
    public int burnTime = BURN_TICKS;

    public static final IntegerProperty BURNTIME = IntegerProperty.create("burn_time", 0, BURN_TICKS);
    public static final BooleanProperty LIT = BooleanProperty.create("lit");


    public ModTorchBlock(Properties pProperties) {
        super(pProperties, ParticleTypes.FLAME);
        registerDefaultState(stateDefinition.any()
                .setValue(LIT, true)
                .setValue(BURNTIME, BURN_TICKS));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT).add(BURNTIME);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide() && !pState.getValue(LIT) && pPlayer.getItemInHand(pHand).is(ModTags.LIGHTERS)) {
            pLevel.scheduleTick(pPos, this, DELAY);
            pLevel.setBlock(pPos, pState.cycle(LIT), 3);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos blockPos, RandomSource randomSource) {
        System.out.println("TORCH TICK");
        if (!level.isClientSide && level.isRaining() && isNearRain(level, blockPos)) {
            extinguish(state, level, blockPos);
            return;
        }
        int newBurnTime = state.getValue(BURNTIME) - 1;
        if (newBurnTime <= 0) {
            state.setValue(LIT, false);
            extinguish(state, level, blockPos);
        } else {
            level.scheduleTick(blockPos, this, DELAY);
            level.setBlock(blockPos, state.setValue(BURNTIME, newBurnTime), 3);
        }
    }

    public boolean isNearRain(Level level, BlockPos blockPos) {
        return level.isRainingAt(blockPos) || level.isRainingAt(blockPos.west()) || level.isRainingAt(blockPos.east()) || level.isRainingAt(blockPos.north()) || level.isRainingAt(blockPos.south());
    }

    public void extinguish(BlockState state, Level level, BlockPos blockPos) {
        level.setBlockAndUpdate(blockPos, state.setValue(LIT, false));
        level.playSound(null, blockPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1f, level.getRandom().nextFloat() * 0.1F + 0.9F);

    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        pLevel.scheduleTick(pos, this, DELAY);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            double d0 = (double) pPos.getX() + 0.5D;
            double d1 = (double) pPos.getY() + 0.7D;
            double d2 = (double) pPos.getZ() + 0.5D;
            pLevel.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            pLevel.addParticle(this.flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return pFacing == Direction.DOWN && !this.canSurvive(pState, pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return canSupportCenter(pLevel, pPos.below(), Direction.UP);
    }

}
