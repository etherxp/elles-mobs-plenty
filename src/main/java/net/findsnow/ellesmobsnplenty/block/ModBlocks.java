package net.findsnow.ellesmobsnplenty.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.mushrooms.BlueMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.GreenMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.world.tree.LuceroSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;

public class ModBlocks {

  // Blocks
  public static final Block NEPHRITE_BLOCK = registerBlock("nephrite_block",
          new Block(FabricBlockSettings.copy(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
  public static final Block GREEN_MUSHROOM_LAMP = registerBlock("green_mushroom_lamp",
          new GreenMushroomLampBlock(FabricBlockSettings.create().mapColor(MapColor.EMERALD_GREEN).sounds(BlockSoundGroup.FUNGUS).luminance(
                  state -> state.get(GreenMushroomLampBlock.CLICKED) ? 7 : 0)));
  public static final Block BLUE_MUSHROOM_LAMP = registerBlock("blue_mushroom_lamp",
          new BlueMushroomLampBlock(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).sounds(BlockSoundGroup.FUNGUS).luminance(
                  state -> state.get(GreenMushroomLampBlock.CLICKED) ? 7 : 0)));
  public static final Block RAW_NEPHRITE_BLOCK = registerBlock("raw_nephrite_block",
          new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK)));

  public static final Block CHOMPER_BLOCK = registerBlock("chomper_block",
          new ChomperBlock(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));

  // Wood Blocks
  public static final Block LUCERO_LOG = registerBlock("lucero_log",
          new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG).strength(4f)));
  public static final Block LUCERO_WOOD = registerBlock("lucero_wood",
          new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD).strength(4f)));
  public static final Block STRIPPED_LUCERO_LOG = registerBlock("stripped_lucero_log",
          new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG).strength(4f)));
  public static final Block STRIPPED_LUCERO_WOOD = registerBlock("stripped_lucero_wood",
          new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD).strength(4f)));
  public static final Block LUCERO_LEAVES = registerBlock("lucero_leaves",
          new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.CHERRY_LEAVES)));
  public static final Block LUCERO_SAPLING = registerBlock("lucero_sapling",
          new SaplingBlock(new LuceroSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1f)));
  public static final Block LUCERO_PLANKS = registerBlock("lucero_planks",
          new Block(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
  public static final Block LUCERO_STAIRS = registerBlock("lucero_stairs",
          new StairsBlock(ModBlocks.LUCERO_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.CHERRY_STAIRS)));
  public static final Block LUCERO_SLABS = registerBlock("lucero_slabs",
          new SlabBlock(FabricBlockSettings.copy(Blocks.CHERRY_SLAB)));
  public static final Block LUCERO_BUTTON = registerBlock("lucero_button",
          new ButtonBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_BUTTON), BlockSetType.OAK, 10, true));
  public static final Block LUCERO_FENCE = registerBlock("lucero_fence",
          new FenceBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE)));
  public static final Block LUCERO_FENCE_GATE = registerBlock("lucero_fence_gate",
          new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE_GATE), WoodType.OAK));
  public static final Block LUCERO_WALL = registerBlock("lucero_wall",
          new WallBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
  public static final Block LUCERO_DOOR = registerBlock("lucero_door",
          new DoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_DOOR), BlockSetType.OAK));
  public static final Block LUCERO_TRAPDOOR = registerBlock("lucero_trapdoor",
          new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_TRAPDOOR), BlockSetType.OAK));
  public static final Block LUCERO_PRESSURE_PLATE = registerBlock("lucero_pressure_plate",
          new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                  FabricBlockSettings.copyOf(Blocks.CHERRY_PRESSURE_PLATE), BlockSetType.OAK));

  // Ore Blocks
  public static final Block NEPHRITE_ORE = registerBlock("nephrite_ore",
          new Block(FabricBlockSettings.copy(Blocks.STONE)));

  public static final Block DEEPSLATE_NEPHRITE_ORE = registerBlock("deepslate_nephrite_ore",
          new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE)));



  // Helper Methods

  private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, new Identifier(EllesMobsNPlenty.MOD_ID, name), block);
  }
  private static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, new Identifier(EllesMobsNPlenty.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
  }
  public static void registerModBlocks() {
    EllesMobsNPlenty.LOGGER.info("Registering Mod Blocks for " + EllesMobsNPlenty.MOD_ID);

  }
}
