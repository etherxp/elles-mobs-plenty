package net.findsnow.ellesmobsnplenty.sound;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {


  public static final SoundEvent NIGHT_TIME = registerSoundEvent("night_time");

public static SoundEvent registerSoundEvent(String name) {
  Identifier identifier = new Identifier(EllesMobsNPlenty.MOD_ID, name);
  return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
}
  public static void registerSounds() {
    EllesMobsNPlenty.LOGGER.info("Registering Mod Sounds for " + EllesMobsNPlenty.MOD_ID);
  }
}
