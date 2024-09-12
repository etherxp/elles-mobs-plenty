package net.findsnow.ellesmobsnplenty.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.entity.ChomperBlockEntityData;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import javax.script.ScriptEngine;

public class ModScreenHandlers {

    public static final ScreenHandlerType<ChomperBlockScreenHandler> CHOMPER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(EllesMobsNPlenty.MOD_ID, "chomper"),
                    new ExtendedScreenHandlerType<>(ChomperBlockScreenHandler::new, ChomperBlockEntityData.PACKET_CODEC));

    public static void registerScreenHandler() {
        EllesMobsNPlenty.LOGGER.info("Registering Screen Handlers for" + EllesMobsNPlenty.MOD_ID);
    }
}
