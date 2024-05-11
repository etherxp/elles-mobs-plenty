package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
  public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {
    addDrop(ModBlocks.NEPHRITE_BLOCK);
    addDrop(ModBlocks.RAW_NEPHRITE_BLOCK);
    addDrop(ModBlocks.GREEN_MUSHROOM_LAMP);
    addDrop(ModBlocks.BLUE_MUSHROOM_LAMP);
    addDrop(ModBlocks.LUCERO_PLANKS);
    addDrop(ModBlocks.LUCERO_BUTTON);
    addDrop(ModBlocks.LUCERO_PRESSURE_PLATE);
    addDrop(ModBlocks.LUCERO_FENCE);
    addDrop(ModBlocks.LUCERO_FENCE_GATE);
    addDrop(ModBlocks.LUCERO_WALL);
    addDrop(ModBlocks.LUCERO_SLABS, slabDrops(ModBlocks.LUCERO_PLANKS));
    addDrop(ModBlocks.LUCERO_TRAPDOOR);
    addDrop(ModBlocks.LUCERO_DOOR, doorDrops(ModBlocks.LUCERO_DOOR));
    addDrop(ModBlocks.LUCERO_LOG);
    addDrop(ModBlocks.LUCERO_WOOD);
    addDrop(ModBlocks.STRIPPED_LUCERO_LOG);
    addDrop(ModBlocks.STRIPPED_LUCERO_WOOD);
    addDrop(ModBlocks.CHOMPER_BLOCK);

    addDrop(ModBlocks.NEPHRITE_ORE, oreDrops(ModBlocks.NEPHRITE_ORE, ModItems.RAW_NEPHRITE));
    addDrop(ModBlocks.DEEPSLATE_NEPHRITE_ORE, oreDrops(ModBlocks.NEPHRITE_ORE, ModItems.RAW_NEPHRITE));
  }
}
