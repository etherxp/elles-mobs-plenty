package net.findsnow.ellesmobsnplenty.util;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
  public static final TagKey<Biome> FALLEN_LUCI_LOG_GEN = registerBiomeTag("fallen_luci_log_gen");
  public static final TagKey<Block> MOSS = TagKey.of(RegistryKeys.BLOCK, new Identifier(EllesMobsNPlenty.MOD_ID, "moss"));





  public static final TagKey<Biome> registerBiomeTag(String name) {
    return TagKey.of(RegistryKeys.BIOME, new Identifier(EllesMobsNPlenty.MOD_ID, name));
  }
}
