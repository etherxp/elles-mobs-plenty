package net.findsnow.ellesmobsnplenty.block.hollow;

import net.findsnow.ellesmobsnplenty.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class HollowLuciLogBlock extends PillarBlock {
  public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;
  private static final VoxelShape SHAPE_BOTTOM = Block.createCuboidShape(0F, 0F, 0F, 16F, 2F, 16F);
  private static final VoxelShape SHAPE_TOP = Block.createCuboidShape(0F, 14F, 0F, 16F, 16F, 16F);
  private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0F, 0F, 0F, 2F, 16F, 16F);
  private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(14F, 0F, 0F, 16F, 16F, 16F);
  private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0F, 0F, 0F, 16F, 16F, 2F);
  private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(0F, 0F, 14F, 16F, 16F, 16F);
  private static final VoxelShape SHAPE_X = VoxelShapes.union(SHAPE_BOTTOM, SHAPE_TOP, SHAPE_EAST, SHAPE_WEST);
  private static final VoxelShape SHAPE_Y = VoxelShapes.union(SHAPE_NORTH, SHAPE_SOUTH, SHAPE_EAST, SHAPE_WEST);
  private static final VoxelShape SHAPE_Z = VoxelShapes.union(SHAPE_BOTTOM, SHAPE_TOP, SHAPE_NORTH, SHAPE_SOUTH);

  public HollowLuciLogBlock(Settings settings) {
    super(settings);
    this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y));
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(AXIS);
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return switch (state.get(AXIS)) {
      case X -> SHAPE_X;
      case Y -> SHAPE_Y;
      case Z -> SHAPE_Z;
    };
  }

  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    Direction.Axis axis = ctx.getHorizontalPlayerFacing().getOpposite().getAxis();

    return this.getDefaultState()
            .with(AXIS, axis);
  }
}
