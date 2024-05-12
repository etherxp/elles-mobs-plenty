package net.findsnow.ellesmobsnplenty.world.tree;

import net.findsnow.ellesmobsnplenty.world.ModConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class LuceroSaplingGenerator extends SaplingGenerator {
  @Nullable
  @Override
  protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
    return bees ? TreeConfiguredFeatures.CHERRY_BEES_005 : ModConfiguredFeatures.LUCERO_KEY;
  }
}
