package net.findsnow.ellesmobsnplenty.block.hollow;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class LogBlock extends PillarBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty LEAF = BooleanProperty.of("leaf");
    public static Block LEAVES;
    public static Block LEAVES1;

    public LogBlock(Block leaves, Block blossomingLeaves, Settings settings) {
        super(settings);
        LEAVES = leaves;
        LEAVES1 = blossomingLeaves;
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false).with(AXIS, Direction.Axis.Y).with(LEAF, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx)
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                .with(LEAF, shouldBeLeaf(ctx.getWorld(), ctx.getBlockPos(), super.getDefaultState()));
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);

        if (!world.isClient) {
            boolean shouldBeLeafy = shouldBeLeaf(world, pos, state);
            if (shouldBeLeafy != state.get(LEAF)) {
                world.setBlockState(pos, state.with(LEAF, shouldBeLeafy), 2);
            }
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected abstract boolean shouldBeLeaf(WorldView world, BlockPos pos, BlockState blockState);

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            boolean shouldBeLeaf = shouldBeLeaf(world, pos, state);
            if (shouldBeLeaf && !state.get(LEAF)) {
                world.setBlockState(pos, state.with(LEAF, true), 2);
                world.updateListeners(pos, state, state, 3);
            } else if (!shouldBeLeaf && state.get(LEAF)) {
                world.setBlockState(pos, state.with(LEAF, false), 2);
                world.updateListeners(pos, state, state, 3);
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, LEAF);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
