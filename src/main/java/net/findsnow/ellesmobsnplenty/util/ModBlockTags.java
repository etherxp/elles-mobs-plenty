package net.findsnow.ellesmobsnplenty.util;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> LUCI_LEAVES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(EllesMobsNPlenty.MOD_ID, "luci_leaves"));
    public static final TagKey<Block> LUCI_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(EllesMobsNPlenty.MOD_ID, "luci_logs"));
}
