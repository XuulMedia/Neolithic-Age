package com.xuul.flint.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

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
                    return new TranslatableComponent(MESSAGE_FLINT_STATION);
                }

                @Override
                public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
                    return new FlintStationContainer(windowId, pos, playerInventory, playerEntity);
                }

            };
            return InteractionResult.CONSUME;
        }
        return InteractionResult.SUCCESS;
    }

    };

//    @Nullable
//    public AbstractContainerMenu getMenuProvider() {
//        return new FlintStationContainer(windowId, pos, playerInventory, playerEntity);
//    }
//
//
//
//
//    @SuppressWarnings("deprecation")
//    @Override
//    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
//        return RENDER_SHAPE;
//    }
//}

