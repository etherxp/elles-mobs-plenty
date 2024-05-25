package net.findsnow.ellesmobsnplenty.world;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;

public class ModConfiguredFeatures {
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCERO_KEY = registryKey("lucero");

  public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
    register(context, LUCERO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.LUCI_LOG),
            new CherryTrunkPlacer(8, 1, 0,
                    new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1)
                            .add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()),
                    UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)),
            new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                    .add(ModBlocks.LUCI_LEAVES.getDefaultState(), 4)
                    .add(ModBlocks.BLOSSOMING_LUCI_LEAVES.getDefaultState(), 1)
                    .build()),
            new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0),
                    ConstantIntProvider.create(5), 0.3f, 0.5f,
                    0.36666667f, 0.43333337f),
            new TwoLayersFeatureSize(1, 0, 2))
            .ignoreVines()
            .build());
  }

  public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EllesMobsNPlenty.MOD_ID, name));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                 RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }
}
