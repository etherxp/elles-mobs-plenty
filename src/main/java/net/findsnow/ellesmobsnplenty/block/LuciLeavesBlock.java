package net.findsnow.ellesmobsnplenty.block;

import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.CherryLeavesBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.joml.Math;

public class LuciLeavesBlock extends LeavesBlock {
  public static final BooleanProperty HAS_BLOSSOMS = BooleanProperty.of("has_blossoms");

  public LuciLeavesBlock(Settings settings) {
    super(settings);

  }

  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    super.randomDisplayTick(state, world, pos, random);
    if (random.nextInt(10) != 0) {
      return;
    }
    BlockPos blockPos = pos.down();
    BlockState blockState = world.getBlockState(blockPos);
    if (CherryLeavesBlock.isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
      return;
    }
    ParticleUtil.spawnParticle(world, pos, random, ModParticles.FALLING_LEAVES_PARTICLE);
  }
}

