package net.findsnow.ellesmobsnplenty.world.biome;


import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomeModifiers {
  public static void register() {
    BiomeModifications.create(new Identifier(EllesMobsNPlenty.MOD_ID, "fallen_logs_add")).add(ModificationPhase.ADDITIONS, BiomeSelectors.includeByKey(
            ModBiomes.LUCI_REGION_1
    ), context -> {
      BiomeModificationContext.GenerationSettingsContext generationSettings = context.getGenerationSettings();

        generationSettings.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, getPlacedFeature("luci_fallen_log"));
    });
    }



  public static RegistryKey<PlacedFeature> getPlacedFeature (String id){
    return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(EllesMobsNPlenty.MOD_ID, id));
  }
}