package net.findsnow.ellesmobsnplenty.world;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModFeatures {

  private static <C extends FeatureConfig, F extends Feature<C>> F registerFeature(String name, F feature) {
    return Registry.register(Registries.FEATURE, Identifier.of(EllesMobsNPlenty.MOD_ID), feature);
  }

  public static void register() {}
}
