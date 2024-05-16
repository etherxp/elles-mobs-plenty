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
import net.minecraft.util.Identifier;

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
  public static final Block LUCI_LOG = registerBlock("luci_log",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));
  public static final Block HOLLOW_LUCI_LOG = registerBlock("hollow_luci_log",
          new HollowLuciLogBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG).nonOpaque()));
  public static final Block LUCI_WOOD = registerBlock("luci_wood",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));
  public static final Block STRIPPED_LUCI_LOG = registerBlock("stripped_luci_log",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));
  public static final Block STRIPPED_LUCI_WOOD = registerBlock("stripped_luci_wood",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD)));
  public static final Block LUCI_LEAVES = registerBlock("luci_leaves",
          new LuciLeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque().mapColor(MapColor.EMERALD_GREEN)));
  public static final Block BLOSSOMING_LUCI_LEAVES = registerBlock("blossoming_luci_leaves",
          new LuciLeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque().mapColor(MapColor.EMERALD_GREEN)));
  public static final Block LUCI_SAPLING = registerBlock("luci_sapling",
          new SaplingBlock(new LuceroSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
  public static final Block LUCI_PLANKS = registerBlock("luci_planks",
          new Block(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
  public static final Block LUCI_STAIRS = registerBlock("luci_stairs",
          new StairsBlock(ModBlocks.LUCI_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.CHERRY_STAIRS)));
  public static final Block LUCI_SLABS = registerBlock("luci_slabs",
          new SlabBlock(FabricBlockSettings.copy(Blocks.CHERRY_SLAB)));
  public static final Block LUCI_BUTTON = registerBlock("luci_button",
          new ButtonBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_BUTTON), BlockSetType.OAK, 10, true));
  public static final Block LUCI_FENCE = registerBlock("luci_fence",
          new FenceBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE)));
  public static final Block LUCI_FENCE_GATE = registerBlock("luci_fence_gate",
          new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE_GATE), WoodType.OAK));
  public static final Block LUCI_WALL = registerBlock("luci_wall",
          new WallBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
  public static final Block LUCI_DOOR = registerBlock("luci_door",
          new DoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_DOOR), BlockSetType.OAK));
  public static final Block LUCI_TRAPDOOR = registerBlock("luci_trapdoor",
          new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_TRAPDOOR), BlockSetType.OAK));
  public static final Block LUCI_PRESSURE_PLATE = registerBlock("luci_pressure_plate",
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
