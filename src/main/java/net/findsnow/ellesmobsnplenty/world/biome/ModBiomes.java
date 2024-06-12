package net.findsnow.ellesmobsnplenty.world.biome;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.world.ModPlacedFeatures;
import net.minecraft.client.sound.MusicType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomes {
  public static final RegistryKey<Biome> LUCI_REGION_1 = register("luci_forest");

  public static RegistryKey<Biome> register(String name) {
    return RegistryKey.of(RegistryKeys.BIOME, new Identifier(EllesMobsNPlenty.MOD_ID, name));
  }

  public static void bootstrap(Registerable<Biome> context) {
    context.register(LUCI_REGION_1, luciForest(context));
  }

  public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
    DefaultBiomeFeatures.addLandCarvers(builder);
    DefaultBiomeFeatures.addAmethystGeodes(builder);
    DefaultBiomeFeatures.addDungeons(builder);
    DefaultBiomeFeatures.addMineables(builder);
    DefaultBiomeFeatures.addSprings(builder);
    DefaultBiomeFeatures.addFrozenTopLayer(builder);
  }

  public static Biome luciForest(Registerable<Biome> context) {

    // Mobs
    SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

    DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
    DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

    // Biome Features
    GenerationSettings.LookupBackedBuilder biomeBuilder =
            new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                    context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

    globalOverworldGeneration(biomeBuilder);
    DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
    DefaultBiomeFeatures.addExtraDefaultFlowers(biomeBuilder);
    DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
    DefaultBiomeFeatures.addForestGrass(biomeBuilder);
    DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
    DefaultBiomeFeatures.addGrassAndClayDisks(biomeBuilder);
    DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

    return new Biome.Builder()
            .precipitation(true)
            .downfall(0.25f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects((new BiomeEffects.Builder())
                    .waterColor(0x2e6ce8)
                    .waterFogColor(0x618ee8)
                    .skyColor(0x87ceeb)
                    .grassColor(0x689e41)
                    .foliageColor(0x689e41)
                    .fogColor(0x9ABD95)
                    .moodSound(BiomeMoodSound.CAVE)
                    .music(MusicType.GAME)
                    .build())
            .build();
  }
}