package net.findsnow.ellesmobsnplenty.entity;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
  public static final EntityType<CrabEntity> CRAB = Registry.register(Registries.ENTITY_TYPE,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "crab"),
          EntityType.Builder.create(CrabEntity::new, SpawnGroup.CREATURE)
                  .dimensions(0.40F, 0.40F)
                  .build());

  public static final EntityType<TurtleEntity> TURTLE = Registry.register(Registries.ENTITY_TYPE,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "turtle"),
          EntityType.Builder.create(TurtleEntity::new, SpawnGroup.CREATURE)
                  .dimensions(0.40F, 0.40F)
                  .build());

  public static final EntityType<ButterflyEntity> BUTTERFLY = Registry.register(Registries.ENTITY_TYPE,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "butterfly"),
          EntityType.Builder.create(ButterflyEntity::new, SpawnGroup.CREATURE)
                  .dimensions(0.40F, 0.40F)
                  .build());

  public static final EntityType<CaterpillarEntity> CATERPILLAR = Registry.register(Registries.ENTITY_TYPE,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "caterpillar"),
          EntityType.Builder.create(CaterpillarEntity::new, SpawnGroup.CREATURE)
                  .dimensions(0.40F, 0.40F)
                  .build());

  public static final EntityType<SharkEntity> SHARK = Registry.register(Registries.ENTITY_TYPE,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "shark"),
          EntityType.Builder.create(SharkEntity::new, SpawnGroup.WATER_CREATURE)
                  .dimensions(1.3F, 1.0F)
                  .build());

  public static final EntityType<ShrimpEntity> SHRIMP = Registry.register(Registries.ENTITY_TYPE,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "shrimp"),
          EntityType.Builder.create(ShrimpEntity::new, SpawnGroup.WATER_CREATURE)
                  .dimensions(0.40F, 0.40F)
                  .build());

  public static final EntityType<RabbitReplacementEntity> RABBIT = Registry.register(Registries.ENTITY_TYPE,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "rabbit"),
          EntityType.Builder.create(RabbitReplacementEntity::new, SpawnGroup.CREATURE)
                  .dimensions(0.50F, 0.50F)
                  .build());


  public static void registerModEntities() {
    EllesMobsNPlenty.LOGGER.info("Registering Entities for " + EllesMobsNPlenty.MOD_ID);
  }
}
