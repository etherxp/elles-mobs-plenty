package net.findsnow.ellesmobsnplenty.world.decorators;

import com.mojang.serialization.Codec;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.mixin.TreeDecoratorTypeMixin;
import net.findsnow.ellesmobsnplenty.world.features.config.ModFallenTreeFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import org.jetbrains.annotations.NotNull;

public class ModTreeDecorator {
  public static final TreeDecoratorType<?> LUCI_FUNGUS_SHELF = TreeDecoratorTypeMixin.callRegister
          ("luci_fungus_shelf_decorator", ModFungusTreeDecorator.CODEC);
  public static final TreeDecoratorType<?> BLOSSOMING_LUCI_VINES = TreeDecoratorTypeMixin.callRegister
          ("blossoming_luci_vines", BlossomingLuciVineTreeDecorator.CODEC);

  public static void register() {
    EllesMobsNPlenty.LOGGER.info("Registering Tree Decorators for" + EllesMobsNPlenty.MOD_ID);
  }
 }
