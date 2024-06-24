package net.findsnow.ellesmobsnplenty.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {


  public static void registerScreenHandler() {
    EllesMobsNPlenty.LOGGER.info("Registering Screen Handlers for" + EllesMobsNPlenty.MOD_ID);
  }
}
