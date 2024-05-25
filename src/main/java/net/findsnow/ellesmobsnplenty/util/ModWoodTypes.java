package net.findsnow.ellesmobsnplenty.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class ModWoodTypes {
  public static final WoodType LUCI = WoodTypeRegistry.register(new Identifier(EllesMobsNPlenty.MOD_ID, "luci"), BlockSetType.CHERRY);
}
