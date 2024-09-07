package net.findsnow.ellesmobsnplenty.world;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.world.decorators.LuciBranchTreeDecorator;
import net.findsnow.ellesmobsnplenty.world.decorators.ModFungusTreeDecorator;
import net.findsnow.ellesmobsnplenty.world.tree.custom.HollowLuciTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
  public final BlockStateProvider stateProvider;
  public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_LUCI_KEY = registryKey("fallen_luci");
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCERO_KEY = registryKey("lucero");
  public static final RegistryKey<ConfiguredFeature<?, ?>> NEPHRITE_ORE_KEY = registryKey("nephrite_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> FROSTITE_ORE_KEY = registryKey("frostite_ore");
  public static final RegistryKey<ConfiguredFeature<?, ?>> BLOSSOMING_LUCI_KEY = registryKey("blossoming_luci");
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCI_PETALS = registryKey("luci_petals");
  public static final RegistryKey<ConfiguredFeature<?, ?>> FLAURELLE = registryKey("flaurelle");
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCI_MUSHROOM = registryKey("luci_mushroom");
  public static final RegistryKey<ConfiguredFeature<?, ?>> LUCI_LEAF_PILE = registryKey("luci_leaf_pile");
  public static final RegistryKey<ConfiguredFeature<?, ?>> CLOVER = registryKey("clover");
  public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_CLOVER = registryKey("tall_clover");

  public ModConfiguredFeatures(BlockStateProvider stateProvider) {
    this.stateProvider = stateProvider;
  }

  public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
    RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    List<OreFeatureConfig.Target> overworldNephriteOres =
            List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.NEPHRITE_ORE.getDefaultState()),
                    OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_NEPHRITE_ORE.getDefaultState()));
    List<OreFeatureConfig.Target> overworldFrostiteOres =
            List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.FROSTITE_ORE.getDefaultState()),
                    OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_FROSTITE_ORE.getDefaultState()));

    register(context, FALLEN_LUCI_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.LUCI_LOG),
            new HollowLuciTrunkPlacer(2, 1, 2),
            BlockStateProvider.of(Blocks.MOSS_CARPET),
            new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 3),
            new TwoLayersFeatureSize(1, 0, 2))
            .forceDirt()
            .build());

    register(context, LUCERO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.LUCI_LOG),
            new StraightTrunkPlacer(11, 2, 1),
            BlockStateProvider.of(ModBlocks.LUCI_LEAVES),
            new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
            new TwoLayersFeatureSize(1, 0, 2))
            .decorators(List.of(
                    new ModFungusTreeDecorator(0.1F, 2),
                    new BeehiveTreeDecorator(0.05F),
                    new LuciBranchTreeDecorator(0.08F, 8)))
            .ignoreVines()
            .forceDirt()
            .build()
    );

    register(context, BLOSSOMING_LUCI_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.LUCI_LOG),
            new StraightTrunkPlacer(16, 2, 1),
            new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                    .add(ModBlocks.LUCI_LEAVES.getDefaultState(), 4)
                    .build()),
            new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
            new TwoLayersFeatureSize(2, 0, 2))
            .decorators(List.of(
                    new ModFungusTreeDecorator(0.1F, 2),
                    new BeehiveTreeDecorator(0.05F),
                    new LuciBranchTreeDecorator(0.08F, 8)))
            .ignoreVines()
            .forceDirt()
            .build()
    );

    register(context, NEPHRITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldNephriteOres, 7));
    register(context, FROSTITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldFrostiteOres, 7));

    register(context, LUCI_PETALS, Feature.FLOWER, new RandomPatchFeatureConfig(37, 6,2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUCI_PETAL)))));
    register(context, LUCI_LEAF_PILE, Feature.FLOWER, new RandomPatchFeatureConfig(95, 6, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUCI_LEAF_PILE)))));
    register(context, FLAURELLE, Feature.FLOWER, new RandomPatchFeatureConfig(10, 7,4, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLAURELLE)))));
    register(context, LUCI_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(4, 2,4, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUCI_FUNGUS)))));
    register(context, CLOVER, Feature.FLOWER, new RandomPatchFeatureConfig(96, 2,3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CLOVER)))));
    register(context, TALL_CLOVER, Feature.FLOWER, new RandomPatchFeatureConfig(96, 3,3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
            new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALL_CLOVER)))));
  }

  public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(EllesMobsNPlenty.MOD_ID, name));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                 RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
    context.register(key, new ConfiguredFeature<>(feature, configuration));
  }
}
