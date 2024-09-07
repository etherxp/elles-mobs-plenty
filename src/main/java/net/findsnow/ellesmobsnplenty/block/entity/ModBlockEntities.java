package net.findsnow.ellesmobsnplenty.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {


  public static final BlockEntityType<ChomperBlockEntity> CHOMPER_BLOCK_ENTITY =
          Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(EllesMobsNPlenty.MOD_ID, "chomper_block_entity"),
                  BlockEntityType.Builder.create(ChomperBlockEntity::new, ModBlocks.CHOMPER_BLOCK).build(null));

  public static void registerBlockEntities() {
    EllesMobsNPlenty.LOGGER.info("Registering Block Entities for " + EllesMobsNPlenty.MOD_ID);
  }
}
