package net.findsnow.ellesmobsnplenty.util;

import com.google.common.collect.Maps;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
  private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();
  private static final String WOODEN_GROUP = "wooden";
  private static final String WOODEN_UNLOCK_CRITERION_NAME = "has_planks";

  public static final BlockFamily LUCI_PLANKS = register(ModBlocks.LUCI_PLANKS)
          .button(ModBlocks.LUCI_BUTTON)
          .fence(ModBlocks.LUCI_FENCE)
          .fenceGate(ModBlocks.LUCI_FENCE_GATE)
          .pressurePlate(ModBlocks.LUCI_PRESSURE_PLATE)
          .sign(ModBlocks.LUCI_SIGN, ModBlocks.LUCI_WALL_SIGN)
          .slab(ModBlocks.LUCI_SLABS)
          .stairs(ModBlocks.LUCI_STAIRS)
          .door(ModBlocks.LUCI_DOOR)
          .trapdoor(ModBlocks.LUCI_TRAPDOOR)
          .group("wooden")
          .unlockCriterionName("has_planks")
          .build();

  public static BlockFamily.Builder register(Block baseBlock) {
    BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
    BlockFamily blockFamily = MAP.put(baseBlock, builder.build());
    if (blockFamily != null) {
      throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
    } else {
      return builder;
    }
  }

  public static Stream<BlockFamily> getFamilies() {
    return MAP.values().stream();
  }
}
