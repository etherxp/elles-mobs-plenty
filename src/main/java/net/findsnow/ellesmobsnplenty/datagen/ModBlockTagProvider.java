package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
  public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(ModBlocks.LUCERO_PLANKS,
                    ModBlocks.LUCERO_STAIRS,
                    ModBlocks.LUCERO_BUTTON,
                    ModBlocks.LUCERO_PRESSURE_PLATE,
                    ModBlocks.LUCERO_FENCE,
                    ModBlocks.LUCERO_FENCE_GATE,
                    ModBlocks.LUCERO_WALL,
                    ModBlocks.LUCERO_TRAPDOOR,
                    ModBlocks.LUCERO_DOOR,
                    ModBlocks.LUCERO_SLABS);

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.NEPHRITE_ORE,
                    ModBlocks.NEPHRITE_BLOCK,
                    ModBlocks.RAW_NEPHRITE_BLOCK,
                    ModBlocks.DEEPSLATE_NEPHRITE_ORE);

    getOrCreateTagBuilder(BlockTags.WALLS)
            .add(ModBlocks.LUCERO_WALL);

    getOrCreateTagBuilder(BlockTags.FENCES)
            .add(ModBlocks.LUCERO_FENCE);

    getOrCreateTagBuilder(BlockTags.FENCE_GATES)
            .add(ModBlocks.LUCERO_FENCE_GATE);

    getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
            .add(ModBlocks.LUCERO_LOG,
                    ModBlocks.STRIPPED_LUCERO_LOG,
                    ModBlocks.STRIPPED_LUCERO_WOOD,
                    ModBlocks.LUCERO_WOOD);
  }
}
