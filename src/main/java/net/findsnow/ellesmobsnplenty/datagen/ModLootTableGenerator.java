package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
  public ModLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(dataOutput, registryLookup);
  }

  @Override
  public void generate() {
    this.addDrop(ModBlocks.JAR_BLOCK);
    this.addDrop(ModBlocks.NEPHRITE_BLOCK);
    this.addDrop(ModBlocks.RAW_NEPHRITE_BLOCK);
    this.addDrop(ModBlocks.GREEN_MUSHROOM_LAMP);
    this.addDrop(ModBlocks.BLUE_MUSHROOM_LAMP);
    this.addDrop(ModBlocks.LUCI_PLANKS);
    this.addDrop(ModBlocks.LUCI_BUTTON);
    this.addDrop(ModBlocks.LUCI_PRESSURE_PLATE);
    this.addDrop(ModBlocks.LUCI_FENCE);
    this.addDrop(ModBlocks.LUCI_FENCE_GATE);
    this.addDrop(ModBlocks.LUCI_SLABS, slabDrops(ModBlocks.LUCI_SLABS));
    this.addDrop(ModBlocks.LUCI_TRAPDOOR);
    this.addDrop(ModBlocks.LUCI_DOOR, doorDrops(ModBlocks.LUCI_DOOR));
    this.addDrop(ModBlocks.LUCI_LOG);
    this.addDrop(ModBlocks.LUCI_WOOD);
    this.addDrop(ModBlocks.LUCI_FUNGUS_SHELF_BLOCk, dropsWithShears(Items.BROWN_MUSHROOM_BLOCK));
    this.addDrop(ModBlocks.LUCI_LEAVES, leavesDrops(ModBlocks.LUCI_LEAVES, ModBlocks.LUCI_SAPLING, 0.1f));
    this.addDrop(ModBlocks.BLOSSOMING_LUCI_LEAVES, leavesDrops(ModBlocks.BLOSSOMING_LUCI_LEAVES, ModBlocks.LUCI_SAPLING, 0.1f));
    this.addDrop(ModBlocks.STRIPPED_LUCI_LOG);
    this.addDrop(ModBlocks.STRIPPED_LUCI_WOOD);
    this.addDrop(ModBlocks.CHOMPER_BLOCK);
    this.addDrop(ModBlocks.LUCI_MUSHROOM);
    this.addDrop(ModBlocks.PEBBLE_BLOCK);
    this.addDrop(ModBlocks.ROCK_BLOCK);
    this.addDrop(ModBlocks.CLOVER);
    this.addDrop(ModBlocks.TALL_CLOVER);

    this.addDrop(ModBlocks.NEPHRITE_ORE, oreDrops(ModBlocks.NEPHRITE_ORE, ModItems.RAW_NEPHRITE));
    this.addDrop(ModBlocks.DEEPSLATE_NEPHRITE_ORE, oreDrops(ModBlocks.NEPHRITE_ORE, ModItems.RAW_NEPHRITE));
  }
}
