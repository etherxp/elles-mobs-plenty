package net.findsnow.ellesmobsnplenty.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.findsnow.ellesmobsnplenty.world.ModPlacedFeatures;
import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
  public static void generateTrees() {
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LUCERO_BIOME),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUCERO_PLACED_KEY);
  }
}
