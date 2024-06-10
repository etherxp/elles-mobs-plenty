package net.findsnow.ellesmobsnplenty.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.util.math.intprovider.IntProvider;

public class ModFallenTreeFeatureConfig implements FeatureConfig {
  public static final Codec<ModFallenTreeFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                  BlockStateProvider.TYPE_CODEC.fieldOf("log").forGetter(config -> config.log),
                  IntProvider.VALUE_CODEC.fieldOf("length").forGetter(config -> config.length),
                  Codec.BOOL.fieldOf("mushroom_shelf").forGetter(config -> config.mushroom_shelf))
          .apply(instance, ModFallenTreeFeatureConfig::new));

  public final BlockStateProvider log;
  public final IntProvider length;
  public final boolean mushroom_shelf;

  public ModFallenTreeFeatureConfig(BlockStateProvider log, IntProvider length, boolean mushroom_shelf) {
    this.log = log;
    this.length = length;
    this.mushroom_shelf = mushroom_shelf;
  }
}