package net.findsnow.ellesmobsnplenty.block;

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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class LuciLogBlock extends LogBlock {

  public LuciLogBlock(Block leaves, Block blossomingLeaves, Settings settings) {
    super(leaves, blossomingLeaves, settings);
  }

  @Override
  protected boolean shouldBeLeaf(WorldView world, BlockPos pos, BlockState blockState) {
    Direction.Axis axis = blockState.get(LuciLogBlock.AXIS);
    Direction[] directions;
    if (axis == Direction.Axis.X) {
      directions = new Direction[]{Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH};
    } else if (axis == Direction.Axis.Z) {
      directions = new Direction[]{Direction.UP, Direction.DOWN, Direction.WEST, Direction.EAST};
    } else {
      directions = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
    }
    for (Direction direction : directions) {
      BlockState neighborState = world.getBlockState(pos.offset(direction));
      if (neighborState.getBlock() != ModBlocks.LUCI_LEAVES && neighborState.getBlock() != ModBlocks.BLOSSOMING_LUCI_LEAVES) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
    if (!world.isClient) {
      boolean shouldBeLeafy = shouldBeLeaf(world, pos, state);
      if (shouldBeLeafy && !state.get(LEAF)) {
        world.setBlockState(pos, state.with(LEAF, true), 2);
        world.updateListeners(pos, state, state, 3);
      } else if (!shouldBeLeafy && state.get(LEAF)) {
        world.setBlockState(pos, state.with(LEAF, false), 2);
        world.updateListeners(pos, state, state, 3);
      }
    }
  }
}
