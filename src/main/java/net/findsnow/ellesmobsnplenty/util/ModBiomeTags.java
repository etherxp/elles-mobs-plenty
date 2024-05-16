package net.findsnow.ellesmobsnplenty.util;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeTags {
  public static final TagKey<Biome> HAS_LUCI_TREES = TagKey.of(RegistryKeys.BIOME, new Identifier(EllesMobsNPlenty.MOD_ID, "has_luci_trees"));
}
