package net.findsnow.ellesmobsnplenty.world;

import com.google.common.collect.Maps;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.Map;

public class ModFeatures {

  public static final Map<Feature<?>, String> FEATURES = Maps.newLinkedHashMap();


  private static <FC extends FeatureConfig, F extends Feature<FC>> F registerFeature(String name, F feature) {
    FEATURES.put(feature, name);
    return feature;
  }
  public static void register() {
    FEATURES.forEach((feature, name) -> Registry.register(Registries.FEATURE, new Identifier(EllesMobsNPlenty.MOD_ID, name), feature));
  }
}
