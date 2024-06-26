package net.findsnow.ellesmobsnplenty.block.mushrooms;

import com.mojang.serialization.MapCodec;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LuciMushroomBlock extends PlantBlock {
  public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
  private static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 14, 14, 14);

  public LuciMushroomBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected MapCodec<? extends PlantBlock> getCodec() {
    return null;
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }

  @Nullable
  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    Random random = ctx.getWorld().getRandom();
    BlockRotation rotation = BlockRotation.values()[random.nextInt(4)];

    return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).rotate(rotation);
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return this.getDefaultState().with(FACING, rotation.rotate(state.get(FACING)));
  }
}
