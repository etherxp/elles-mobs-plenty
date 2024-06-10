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

  public static final ScreenHandlerType<AncientFurnaceScreenHandler> ANCIENT_FURNACE_SCREEN_HANDLER =
          Registry.register(Registries.SCREEN_HANDLER, new Identifier(EllesMobsNPlenty.MOD_ID, "ancient_furnace_screen_handler"),
                  new ScreenHandlerType<>(AncientFurnaceScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

  public static void registerScreenHandler() {
    EllesMobsNPlenty.LOGGER.info("Registering Screen Handlers for" + EllesMobsNPlenty.MOD_ID);
  }
}
