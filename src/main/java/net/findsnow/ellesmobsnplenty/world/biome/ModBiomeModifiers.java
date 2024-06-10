package net.findsnow.ellesmobsnplenty.world.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.findsnow.ellesmobsnplenty.util.ModTags;
import net.findsnow.ellesmobsnplenty.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModBiomeModifiers {
  public static void register() {
    addFallenLog();
  }


  public static void addFallenLog() {
    addFeature(ModPlacedFeatures.LUCI_FALLEN_LOG, ModTags.FALLEN_LUCI_LOG_GEN, GenerationStep.Feature.LOCAL_MODIFICATIONS);
  }


  public static void addFeature(RegistryKey<PlacedFeature> featureRegistryEntry, RegistryKey<Biome> biomeRegistryKey, GenerationStep.Feature step) {
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(biomeRegistryKey), step, featureRegistryEntry);
  }

  public static void addFeature(RegistryKey<PlacedFeature> featureRegistryEntry, TagKey<Biome> biomeRegistryKey, GenerationStep.Feature step) {
    BiomeModifications.addFeature(BiomeSelectors.tag(biomeRegistryKey), step, featureRegistryEntry);
  }
}
