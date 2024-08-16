package net.findsnow.ellesmobsnplenty.world.tree;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.mixin.FoliagePlacerTypeInvoker;
import net.findsnow.ellesmobsnplenty.world.tree.custom.BlossomingLuciFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
  public static final FoliagePlacerType<?> BLOSSOMING_LUCI_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
          "blossoming_luci_foliage_placer", BlossomingLuciFoliagePlacer.CODEC);

  public static void register() {
    EllesMobsNPlenty.LOGGER.info("Registering custom foliage placers for" + EllesMobsNPlenty.MOD_ID);
  }
}
