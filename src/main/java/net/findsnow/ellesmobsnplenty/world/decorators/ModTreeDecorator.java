package net.findsnow.ellesmobsnplenty.world.decorators;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.mixin.TreeDecoratorTypeMixin;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecorator {
  public static final TreeDecoratorType<?> LUCI_FUNGUS_SHELF = TreeDecoratorTypeMixin.callRegister
          ("luci_fungus_shelf_decorator", ModFungusTreeDecorator.CODEC);
  public static final TreeDecoratorType<?> BLOSSOMING_LUCI_VINES = TreeDecoratorTypeMixin.callRegister
          ("blossoming_luci_vines", BlossomingLuciVineTreeDecorator.CODEC);

  public static void register() {
    EllesMobsNPlenty.LOGGER.info("Registering Tree Decorators for" + EllesMobsNPlenty.MOD_ID);
  }
 }
