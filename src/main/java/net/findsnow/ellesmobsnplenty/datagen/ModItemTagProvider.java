package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
  public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
            .add(ModBlocks.LUCI_LOG.asItem(), ModBlocks.STRIPPED_LUCI_LOG.asItem(),
                    ModBlocks.STRIPPED_LUCI_WOOD.asItem(), ModBlocks.LUCI_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.PLANKS)
            .add(ModBlocks.LUCI_PLANKS.asItem());

    getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
            .add(ModItems.NIGHT_TIME_MUSIC_DISC);
  }
}
