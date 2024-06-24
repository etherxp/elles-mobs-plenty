package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.util.ModBlockTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
  public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(ModBlocks.LUCI_PLANKS)
            .add(ModBlocks.LUCI_STAIRS)
            .add(ModBlocks.LUCI_BUTTON)
            .add(ModBlocks.LUCI_LOG)
            .add(ModBlocks.LUCI_WOOD)
            .add(ModBlocks.STRIPPED_LUCI_LOG)
            .add(ModBlocks.STRIPPED_LUCI_WOOD)
            .add(ModBlocks.LUCI_PRESSURE_PLATE)
            .add(ModBlocks.LUCI_FENCE)
            .add(ModBlocks.LUCI_FENCE_GATE)
            .add(ModBlocks.LUCI_WALL)
            .add(ModBlocks.LUCI_TRAPDOOR)
            .add(ModBlocks.LUCI_DOOR)
            .add(ModBlocks.LUCI_SLABS)
            .add(ModBlocks.CHOMPER_BLOCK);

    getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            .add(ModBlocks.LUCI_LEAVES)
            .add(ModBlocks.BLOSSOMING_LUCI_LEAVES);

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.NEPHRITE_ORE)
            .add(ModBlocks.NEPHRITE_BLOCK)
            .add(ModBlocks.RAW_NEPHRITE_BLOCK)
            .add(ModBlocks.DEEPSLATE_NEPHRITE_ORE);

    getOrCreateTagBuilder(BlockTags.WALLS)
            .add(ModBlocks.LUCI_WALL);

    getOrCreateTagBuilder(BlockTags.FENCES)
            .add(ModBlocks.LUCI_FENCE);

    getOrCreateTagBuilder(BlockTags.FENCE_GATES)
            .add(ModBlocks.LUCI_FENCE_GATE);

    getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
            .addTag(ModBlockTags.LUCI_LOGS);

    getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
            .add(ModBlocks.LUCI_LOG);

    getOrCreateTagBuilder(BlockTags.FLOWERS)
            .add(ModBlocks.BLOSSOMING_LUCI_LEAVES);

    getOrCreateTagBuilder(BlockTags.LEAVES)
            .addTag(ModBlockTags.LUCI_LEAVES);

    getOrCreateTagBuilder(ModBlockTags.LUCI_LEAVES)
            .add(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES);

    getOrCreateTagBuilder(ModBlockTags.LUCI_LOGS)
            .add(ModBlocks.LUCI_LOG)
            .add(ModBlocks.STRIPPED_LUCI_LOG)
            .add(ModBlocks.STRIPPED_LUCI_WOOD)
            .add(ModBlocks.LUCI_WOOD);

    getOrCreateTagBuilder(BlockTags.SAPLINGS)
            .add(ModBlocks.LUCI_SAPLING)
            .add(ModBlocks.BLOSSOMING_LUCI_SAPLING);

    getOrCreateTagBuilder(BlockTags.PLANKS)
            .add(ModBlocks.LUCI_PLANKS);

    getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_5")));
  }
}
