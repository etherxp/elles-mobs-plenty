package net.findsnow.ellesmobsnplenty.block.custom;

import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockLocating;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Optional;

public class BlossomingLuciLeavesBlock extends LeavesBlock {
  public static final BooleanProperty HAS_BLOSSOMS = BooleanProperty.of("has_blossoms");

  public BlossomingLuciLeavesBlock(Settings settings) {
    super(settings);

  }

  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    super.randomDisplayTick(state, world, pos, random);
    if (random.nextInt(10) == 0) {
      BlockPos blockPos = pos.down();
      BlockState blockState = world.getBlockState(blockPos);
      if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
        ParticleUtil.spawnParticle(world, pos, random, ModParticles.BLOSSOMING_FALLING_LEAVES);
      }
    }
  }
}

