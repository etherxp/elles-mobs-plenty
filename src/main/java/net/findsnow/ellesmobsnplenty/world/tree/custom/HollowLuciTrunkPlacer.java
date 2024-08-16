package net.findsnow.ellesmobsnplenty.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.findsnow.ellesmobsnplenty.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class HollowLuciTrunkPlacer extends TrunkPlacer {
  public static final MapCodec<HollowLuciTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(hollowLuciTrunkPlacerInstance ->
          fillTrunkPlacerFields(hollowLuciTrunkPlacerInstance).apply(hollowLuciTrunkPlacerInstance, HollowLuciTrunkPlacer::new));


  public HollowLuciTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
    super(baseHeight, firstRandomHeight, secondRandomHeight);
  }

  @Override
  protected TrunkPlacerType<?> getType() {
    return ModTrunkPlacerTypes.HOLLOW_LUCI_TRUNK_PLACER;
  }

  @Override
  public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                               Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
    Direction logDirection = random.nextBoolean() ? Direction.NORTH : Direction.EAST;
    BlockPos.Mutable currentPos = startPos.mutableCopy().move(logDirection, height / 2 + 1);
    int mossSkip = 1;

    for (int i = 0; i < height; i++) {
      BlockPos localPos = currentPos.move(logDirection.getOpposite());

      if (!world.testBlockState(localPos, AbstractBlock.AbstractBlockState::isReplaceable)) {
        return ImmutableList.of();
      }
      if (world.testBlockState(localPos.down(), BlockState::isAir)) {
        return ImmutableList.of();
      }
      if (world.testBlockState(localPos.down(), BlockState::isLiquid)) {
        return ImmutableList.of();
      }
    }
    for (int i = 0; i < height; ++i) {
      checkAndPlaceBlockState(world, random, currentPos.move(logDirection), replacer, config.trunkProvider.get(random, currentPos)
              .with(PillarBlock.AXIS, logDirection.getAxis()));

      BlockPos belowPos = currentPos.down();
      if (world.testBlockState(belowPos, BlockState::isAir)) {
        replacer.accept(belowPos, Blocks.HANGING_ROOTS.getDefaultState());
      }

      if (mossSkip > 0 && random.nextInt(height) < mossSkip) {
        mossSkip --;
      } else {
        BlockPos abovePos = currentPos.up();
        if (world.testBlockState(abovePos, BlockState::isAir)) {
          replacer.accept(abovePos, Blocks.MOSS_CARPET.getDefaultState());
        }
      }
    }
    return ImmutableList.of();
  }

  private static void checkAndPlaceBlockState(TestableWorld world, Random random, BlockPos blockPos,
                                              BiConsumer<BlockPos, BlockState> replacer, BlockState blockState) {
    if (TreeFeature.canReplace(world, blockPos)) {
      replacer.accept(blockPos.toImmutable(), blockState);
    }
  }
}
