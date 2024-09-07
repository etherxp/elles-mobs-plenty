package net.findsnow.ellesmobsnplenty.world.biome;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.findsnow.ellesmobsnplenty.world.ModPlacedFeatures;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;

public class ModBiomes {
  public static final RegistryKey<Biome> LUCI_REGION_1 = register("luci_forest");

  public static RegistryKey<Biome> register(String name) {
    return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(EllesMobsNPlenty.MOD_ID, name));
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

    // Biome Features
    GenerationSettings.LookupBackedBuilder biomeBuilder =
            new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                    context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

    // Mobs
    SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
    spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.BUTTERFLY, 6, 7, 15));

    DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
    DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
    globalOverworldGeneration(biomeBuilder);
    DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
    DefaultBiomeFeatures.addForestGrass(biomeBuilder);
    DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
    DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
    DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
    DefaultBiomeFeatures.addGrassAndClayDisks(biomeBuilder);
    DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

    return new Biome.Builder()
            .precipitation(true)
            .downfall(0.25f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects((new BiomeEffects.Builder())
                    .waterColor(0x3F76E4)
                    .waterFogColor(0x618ee8)
                    .skyColor(0x7BA4FF)
                    .grassColor(0x548b4c)
                    .foliageColor(0x548b4c)
                    .fogColor(0x9ABD95)
                    .moodSound(BiomeMoodSound.CAVE)
                    .music(MusicType.GAME)
                    .build())
            .build();
  }
}