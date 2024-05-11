package net.findsnow.ellesmobsnplenty.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;

public class ModRegistries {
  public static void RegisterModStuff() {
    registerFuels();
    registerStrippable();
    registerFlammables();
  }

  private static void registerFuels() {

  }

  private static void registerStrippable() {
    StrippableBlockRegistry.register(ModBlocks.LUCERO_LOG, ModBlocks.STRIPPED_LUCERO_LOG);
    StrippableBlockRegistry.register(ModBlocks.LUCERO_WOOD, ModBlocks.STRIPPED_LUCERO_WOOD);
  }

  private static void registerFlammables() {
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCERO_LOG, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCERO_WOOD, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LUCERO_LOG, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LUCERO_WOOD, 5, 5);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCERO_PLANKS, 5, 10);
    FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LUCERO_LEAVES, 30, 60);
  }
}
