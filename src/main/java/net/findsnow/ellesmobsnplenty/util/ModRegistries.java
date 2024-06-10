package net.findsnow.ellesmobsnplenty.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.TurtleEntity;
import net.findsnow.ellesmobsnplenty.world.features.config.ModFallenTreeFeatureConfig;

public class ModRegistries {
  public static void RegisterModStuff() {
    registerFuels();
    registerStrippable();
    registerFlammables();
    registerAttributes();
  }

  private static void registerFuels() {

  }

  private static void registerAttributes() {
    FabricDefaultAttributeRegistry.register(ModEntities.CRAB, CrabEntity.createCrabAttributes());
    FabricDefaultAttributeRegistry.register(ModEntities.TURTLE, TurtleEntity.createTurtleAttributes());
  }

  private static void registerStrippable() {
    StrippableBlockRegistry.register(ModBlocks.LUCI_LOG, ModBlocks.STRIPPED_LUCI_LOG);
    StrippableBlockRegistry.register(ModBlocks.LUCI_WOOD, ModBlocks.STRIPPED_LUCI_WOOD);
  }

  private static void registerFlammables() {
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCI_LOG, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCI_WOOD, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LUCI_LOG, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LUCI_WOOD, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCI_PLANKS, 5, 10);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCI_LEAVES, 30, 60);
  }
}
