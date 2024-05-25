package net.findsnow.ellesmobsnplenty.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

  public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
          new Identifier(EllesMobsNPlenty.MOD_ID,"mod_sign_entity"),
          FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                  ModBlocks.LUCI_SIGN, ModBlocks.LUCI_WALL_SIGN).build());
  public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
          new Identifier(EllesMobsNPlenty.MOD_ID,"mod_hanging_sign_entity"),
          FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                  ModBlocks.LUCI_HANGING_SIGN, ModBlocks.LUCI_WALL_HANGING_SIGN).build(null));


  public static void registerBlockEntities() {
    EllesMobsNPlenty.LOGGER.info("Registering Block Entities for " + EllesMobsNPlenty.MOD_ID);
  }
}
