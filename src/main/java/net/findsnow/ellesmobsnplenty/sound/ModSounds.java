package net.findsnow.ellesmobsnplenty.sound;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent BLOCK_LUCI_WOOD_BREAK = registerSoundEvent("luci_wood_break");
    public static final SoundEvent BLOCK_LUCI_WOOD_STEP = registerSoundEvent("luci_wood_step");
    public static final SoundEvent BLOCK_LUCI_WOOD_PLACE = registerSoundEvent("luci_wood_place");
    public static final SoundEvent BLOCK_LUCI_WOOD_HIT = registerSoundEvent("luci_wood_hit");
    public static final SoundEvent BLOCK_LUCI_WOOD_FALL = registerSoundEvent("luci_wood_fall");

    public static final BlockSoundGroup LUCI_WOOD_SOUNDS = new BlockSoundGroup(1f, 1f,
            BLOCK_LUCI_WOOD_BREAK,
            BLOCK_LUCI_WOOD_STEP,
            BLOCK_LUCI_WOOD_PLACE,
            BLOCK_LUCI_WOOD_HIT,
            BLOCK_LUCI_WOOD_FALL);

  private static SoundEvent registerSoundEvent(String name) {
    Identifier identifier = Identifier.of(EllesMobsNPlenty.MOD_ID, name);
    return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
  }

  public static void registerSounds() {
    EllesMobsNPlenty.LOGGER.info("Registering Mod Sounds for " + EllesMobsNPlenty.MOD_ID);
  }
}
