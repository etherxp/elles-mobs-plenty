package net.findsnow.ellesmobsnplenty.world.gen;

import net.findsnow.ellesmobsnplenty.entity.ModEntities;

public class ModWorldGeneration {
  public static void generatorModWorldGeneration() {
    ModTreeGeneration.generateTrees();
    ModFlowerGeneration.generateFlowers();
    ModEntitySpawns.addSpawns();
  }
}
