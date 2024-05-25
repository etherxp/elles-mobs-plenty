package net.findsnow.ellesmobsnplenty.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

  public static void registerModEntities() {
    EllesMobsNPlenty.LOGGER.info("Registering Entities for " + EllesMobsNPlenty.MOD_ID);
  }
}
