package net.findsnow.ellesmobsnplenty.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.world.decorators.BlossomingLuciVineTreeDecorator;
import net.findsnow.ellesmobsnplenty.world.decorators.ModFungusTreeDecorator;
import net.findsnow.ellesmobsnplenty.world.features.config.ModFallenTreeFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.debug.BeeDebugRenderer;
import net.minecraft.registry.*;
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
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
  public final BlockStateProvider stateProvider;
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCERO_KEY = registryKey("lucero");
  public static final RegistryKey<ConfiguredFeature<?, ?>> BLOSSOMING_LUCI_KEY = registryKey("blossoming_luci");
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCI_PETALS = registryKey("luci_petals");
  public static final RegistryKey<ConfiguredFeature<?, ?>> FLAURELLE = registryKey("flaurelle");
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCI_FALLEN_LOG = registryKey("luci_fallen_log");

  public ModConfiguredFeatures(BlockStateProvider stateProvider) {
    this.stateProvider = stateProvider;
  }

  public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
    register(context, LUCERO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.LUCI_LOG),
            new CherryTrunkPlacer(8, 1, 0,
                    new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1)
                            .add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()),
                    UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)),
            new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                    .add(ModBlocks.LUCI_LEAVES.getDefaultState(), 4)
                    .build()),
            new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0),
                    ConstantIntProvider.create(5), 0.3f, 0.5f,
                    0.36666667f, 0.43333337f),
            new TwoLayersFeatureSize(1, 0, 2))
            .decorators(List.of(new ModFungusTreeDecorator(0.1F, 4), new BeehiveTreeDecorator(0.05F)))
            .forceDirt()
            .ignoreVines()
            .build());
    register(context, BLOSSOMING_LUCI_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.LUCI_LOG),
            new CherryTrunkPlacer(10, 1, 0,
                    new WeightedListIntProvider(DataPool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1)
                            .add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()),
                    UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)),
            new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                    .add(ModBlocks.BLOSSOMING_LUCI_LEAVES.getDefaultState(), 1)
                    .build()),
            new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0),
                    ConstantIntProvider.create(5), 0.3f, 0.5f,
                    0.36666667f, 0.43333337f),
            new TwoLayersFeatureSize(1, 0, 2))
            .decorators(List.of(new ModFungusTreeDecorator(0.1F, 5),
                    new BeehiveTreeDecorator(0.05F),
                    new BlossomingLuciVineTreeDecorator(0.1F, BlockStateProvider.of(ModBlocks.BLOSSOMING_LUCI_VINE), 1)))
            .forceDirt()
            .ignoreVines()
            .build());


    register(context, LUCI_FALLEN_LOG, ModFeatures.FALLEN_LOG, new ModFallenTreeFeatureConfig(BlockStateProvider.of(ModBlocks.HOLLOW_LUCI_LOG), UniformIntProvider.create(2, 3), true));

    register(context, LUCI_PETALS, Feature.FLOWER, new RandomPatchFeatureConfig(37, 6,2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUCI_PETAL)))));
    register(context, FLAURELLE, Feature.FLOWER, new RandomPatchFeatureConfig(37, 6,2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLAURELLE)))));
  }

  public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EllesMobsNPlenty.MOD_ID, name));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                 RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }
}
