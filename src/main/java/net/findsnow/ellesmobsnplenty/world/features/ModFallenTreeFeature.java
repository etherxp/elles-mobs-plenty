package net.findsnow.ellesmobsnplenty.world.features;

import com.mojang.serialization.Codec;
import net.findsnow.ellesmobsnplenty.block.hollow.HollowLuciLogBlock;
import net.findsnow.ellesmobsnplenty.world.ModConfiguredFeatures;
import net.findsnow.ellesmobsnplenty.world.features.config.ModFallenTreeFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class ModFallenTreeFeature extends Feature<ModFallenTreeFeatureConfig> {
  public static BlockState MOSS = Blocks.MOSS_CARPET.getDefaultState();

  public ModFallenTreeFeature(Codec<ModFallenTreeFeatureConfig> configCodec) {
    super(configCodec);
  }


  @Override
  public boolean generate(FeatureContext<ModFallenTreeFeatureConfig> context) {
    StructureWorldAccess world = context.getWorld();
    BlockPos blockPos = context.getOrigin();
    Random random = context.getRandom();
    ModFallenTreeFeatureConfig config = context.getConfig();
    Direction direction = Direction.Type.HORIZONTAL.random(random);
    int logLength = random.nextInt(1) + 3;
    BlockPos.Mutable mutable = blockPos.mutableCopy();

    if (!world.getBlockState(blockPos.down()).isIn(BlockTags.DIRT)) {
      return false;
    }

    for (int i = 0; i < logLength; i++) {
      BlockPos currentPos = mutable.move(direction);
      if (world.isAir(currentPos) || world.getBlockState(currentPos).isOf(Blocks.WATER)) {
        BlockState logState = config.log.get(random, currentPos).with(Properties.AXIS, direction.getAxis());
        world.setBlockState(currentPos, logState, 3);
        if (random.nextFloat() < 0.25f) {
          world.setBlockState(currentPos.up(), MOSS, 3);
        }
      } else {
        break;
      }
    }
    return true;
  }
}