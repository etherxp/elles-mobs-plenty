package net.findsnow.ellesmobsnplenty.util;

import com.mojang.serialization.Codec;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.world.features.ModFallenTreeFeature;
import net.findsnow.ellesmobsnplenty.world.features.config.ModFallenTreeFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModFeatures {
  public static final Feature<ModFallenTreeFeatureConfig> FALLEN_LOG = Registry.register(
          Registries.FEATURE,
          new Identifier(EllesMobsNPlenty.MOD_ID, "fallen_log"),
          new ModFallenTreeFeature(ModFallenTreeFeatureConfig.CODEC)
  );

  public static void register() {
    EllesMobsNPlenty.LOGGER.info("Registering Features for" + EllesMobsNPlenty.MOD_ID);
  }
}
