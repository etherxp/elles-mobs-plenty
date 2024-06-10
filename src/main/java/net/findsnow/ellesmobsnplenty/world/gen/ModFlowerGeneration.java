package net.findsnow.ellesmobsnplenty.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.findsnow.ellesmobsnplenty.world.ModPlacedFeatures;
import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {
  public static void generateFlowers() {
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LUCI_REGION_1),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUCI_PETAL_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LUCI_REGION_1),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FLAURELLE_PLACED_KEY);

  }
}
