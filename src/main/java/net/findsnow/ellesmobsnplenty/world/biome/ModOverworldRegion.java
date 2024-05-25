package net.findsnow.ellesmobsnplenty.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
  public ModOverworldRegion(Identifier name, int weight) {
    super(name, RegionType.OVERWORLD, weight);
  }

  @Override
  public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
    VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
    new ParameterUtils.ParameterPointListBuilder()
            .temperature(ParameterUtils.Temperature.NEUTRAL)
            .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.FULL_RANGE))
            .continentalness(ParameterUtils.Continentalness.NEAR_INLAND)
            .erosion(ParameterUtils.Erosion.EROSION_0)
            .depth(ParameterUtils.Depth.SURFACE)
            .weirdness(ParameterUtils.Weirdness.PEAK_NORMAL)
            .build().forEach(point -> builder.add(point, ModBiomes.LUCERO_BIOME));
    builder.build().forEach(mapper);
  }
}