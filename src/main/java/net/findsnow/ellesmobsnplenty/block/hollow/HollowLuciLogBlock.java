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
  public static final BooleanProperty MOSSY = BooleanProperty.of("mossy");
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
    setDefaultState(getDefaultState()
            .with(AXIS, Direction.Axis.Y)
            .with(MOSSY, false));
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(AXIS, MOSSY);
  }

  @SuppressWarnings("depreciated")
  @Override
  public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
    if (direction == Direction.UP) {
      Block above = neighborState.getBlock();
      return state.with(MOSSY, (above == Blocks.MOSS_CARPET) || (above == Blocks.MOSS_BLOCK));
    }

    return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
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
    Block up = ctx.getWorld().getBlockState(ctx.getBlockPos().up()).getBlock();
    return this.getDefaultState()
            .with(AXIS, ctx.getSide().getAxis())
            .with(MOSSY, (up == Blocks.MOSS_CARPET || (up == Blocks.MOSS_BLOCK)));
  }

}
