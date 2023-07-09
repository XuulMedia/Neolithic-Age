package github.xuulmedia.neolith.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

import javax.annotation.Nullable;
import java.util.Map;

public class ModStandingAndWallBlockItem extends BlockItem {
    protected final Block wallBlock;
    private final Direction attachmentDirection;

    public ModStandingAndWallBlockItem(Block standingBlock, Block wallBlock, Item.Properties itemProperties, Direction attachmentDirection) {
        super(standingBlock, itemProperties);
        this.wallBlock = wallBlock;
        this.attachmentDirection = attachmentDirection;
    }

    protected boolean canPlace(LevelReader levelReader, BlockState blockState, BlockPos blockPos) {
        boolean toReturn  = blockState.canSurvive(levelReader, blockPos);
        return toReturn;
    }

    @Nullable
    protected BlockState getPlacementState(BlockPlaceContext context) {
        BlockState standingState = this.getBlock().getStateForPlacement(context);
        BlockState wallState = this.wallBlock.getStateForPlacement(context);
        BlockState placementState = null;
        LevelReader levelReader = context.getLevel();
        BlockPos blockPos = context.getClickedPos();

        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction != this.attachmentDirection.getOpposite()) {
                BlockState state = direction == this.attachmentDirection ? standingState : wallState;
                if (state != null && this.canPlace(levelReader, state, blockPos)) {
                    placementState = state;
                    break;
                }
            }
        }

        return placementState != null && levelReader.isUnobstructed(placementState, blockPos, CollisionContext.empty()) ? placementState : null;
    }

    public void registerBlocks(Map<Block, Item> blockToItemMap, Item item) {
        super.registerBlocks(blockToItemMap, item);
        blockToItemMap.put(this.wallBlock, item);
    }

    public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item item) {
        super.removeFromBlockToItemMap(blockToItemMap, item);
        blockToItemMap.remove(this.wallBlock);
    }
}