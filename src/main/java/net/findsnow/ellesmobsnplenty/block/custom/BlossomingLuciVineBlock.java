package net.findsnow.ellesmobsnplenty.block.custom;

import com.mojang.serialization.MapCodec;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class BlossomingLuciVineBlock extends Block{
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public BlossomingLuciVineBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction[] directions = ctx.getPlacementDirections();

        for (Direction direction : directions) {
            if (direction == Direction.DOWN) {
                BlockState blockState = this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
                if (blockState.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
                    return blockState;
                }
            }
        }

        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPosAbove = pos.up(); // Get the position above
        BlockState blockStateAbove = world.getBlockState(blockPosAbove);
        return blockStateAbove.isSideSolidFullSquare(world, blockPosAbove, Direction.DOWN);
    }


    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }
}
