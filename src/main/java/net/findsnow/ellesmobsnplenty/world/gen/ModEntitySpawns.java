package net.findsnow.ellesmobsnplenty.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.util.ModBiomeTags;
import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.BiomeKeys;

import java.util.Random;

public class ModEntitySpawns {
  public static void addSpawns() {
    BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
            BiomeKeys.FOREST,
                    BiomeKeys.PLAINS,
                    BiomeKeys.MEADOW),
            SpawnGroup.CREATURE,
            ModEntities.BUTTERFLY,
            60,
            2,
            7);

    SpawnRestriction.register(
            ModEntities.BUTTERFLY,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            AnimalEntity::isValidNaturalSpawn);

    BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
            BiomeKeys.WARM_OCEAN,
                    BiomeKeys.DEEP_LUKEWARM_OCEAN),
            SpawnGroup.WATER_CREATURE,
            ModEntities.SHARK,
            40,
            3,
            5);

    SpawnRestriction.register(
            ModEntities.SHARK,
            SpawnLocationTypes.IN_WATER,
            Heightmap.Type.OCEAN_FLOOR_WG,
            WaterCreatureEntity::canSpawn);
  }
}
