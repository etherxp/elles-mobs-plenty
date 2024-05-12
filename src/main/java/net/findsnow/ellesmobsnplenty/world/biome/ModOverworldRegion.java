package net.findsnow.ellesmobsnplenty.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
  public ModOverworldRegion(Identifier name, int weight) {
    super(name, RegionType.OVERWORLD, 5);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
    this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
      modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.MEADOW, ModBiomes.LUCERO_BIOME);
    });
  }
}
