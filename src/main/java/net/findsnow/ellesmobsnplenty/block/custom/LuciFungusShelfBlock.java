package net.findsnow.ellesmobsnplenty.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LuciFungusShelfBlock extends HorizontalFacingBlock {
  // keep working on this, not working

  public static final MapCodec<LuciFungusShelfBlock> CODEC = createCodec(LuciFungusShelfBlock::new);
  public static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(0D, 0D, 0D, 16D, 16D, 3D);
  public static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0D, 0D, 13D, 16D, 16D, 16D);
  public static final VoxelShape SHAPE_WEST = Block.createCuboidShape(13D, 0D, 0D, 16D, 16D, 16D);
  public static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0D, 0D, 0D, 3D, 16D, 16D);

  public LuciFungusShelfBlock(Settings settings) {
    super(settings);
    this.getDefaultState().with(FACING, Direction.NORTH);
  }

  @Override
  protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
    return CODEC;
  }

  @Override
  protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    Item item = stack.getItem();
    if (stack.isOf(Items.SHEARS)) {
      if (!world.isClient) {
        dropStack(world, pos, new ItemStack(this));
        world.removeBlock(pos, false);
      }
      return ItemActionResult.SUCCESS;
    }
    return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  private boolean canPlaceOn(BlockView world, BlockPos pos, Direction side) {
    BlockState blockState = world.getBlockState(pos);
    return blockState.isSideSolidFullSquare(world, pos, side);
  }

  @Override
  public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    Direction direction = state.get(FACING);
    return this.canPlaceOn(world, pos.offset(direction.getOpposite()), direction);
  }

  @Override
  public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
    if (direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos)) {
      return Blocks.AIR.getDefaultState();
    }
    return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
  }

  @Override
  public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
    super.neighborUpdate(state, world, pos, block, fromPos, notify);
    if (world.getBlockState(pos.offset(state.get(FACING).getOpposite())).isAir()) {
      world.breakBlock(pos, true);
    }
  }

  @Nullable
  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return switch (ctx.getHorizontalPlayerFacing()) {
      default -> this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
      case UP, DOWN -> null;
    };
  }

  @Override
  public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
    return true;
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return switch (state.get(FACING)) {
      default -> SHAPE_NORTH;
      case NORTH -> SHAPE_SOUTH;
      case WEST -> SHAPE_WEST;
      case EAST -> SHAPE_EAST;
    };
  }
}
