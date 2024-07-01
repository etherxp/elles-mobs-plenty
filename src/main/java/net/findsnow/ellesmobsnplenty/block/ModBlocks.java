package net.findsnow.ellesmobsnplenty.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.custom.*;
import net.findsnow.ellesmobsnplenty.block.hollow.HollowLuciLogBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.BlueMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.GreenMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.LuciMushroomBlock;
import net.findsnow.ellesmobsnplenty.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

public class ModBlocks {

  // Blocks
  public static final Block NEPHRITE_BLOCK = registerBlock("nephrite_block",
          new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK)
                  .sounds(BlockSoundGroup.NETHERITE)));

  public static final Block BLOSSOMING_LUCI_VINE = registerBlock("blossoming_luci_vine",
          new BlossomingLuciVineBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)
                  .sounds(BlockSoundGroup.CHERRY_LEAVES)
                  .nonOpaque()
                  .noCollision()
                  .ticksRandomly()
                  .pistonBehavior(PistonBehavior.DESTROY)));

  public static final Block RAW_NEPHRITE_BLOCK = registerBlock("raw_nephrite_block",
          new Block(AbstractBlock.Settings.copy(Blocks.RAW_GOLD_BLOCK)));

  public static final Block LUCI_FUNGUS_SHELF_BLOCk = registerBlock("luci_fungus_shelf_block",
          new LuciFungusShelfBlock(AbstractBlock.Settings.copy(Blocks.MUSHROOM_STEM)
                  .nonOpaque()));

  public static final Block CHOMPER_BLOCK = registerBlock("chomper_block",
          new ChomperBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));

  public static final Block CHRYSALIS_BLOCK = registerBlock("chrysalis_block",
          new ChrysalisBlock(AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK)
                  .sounds(BlockSoundGroup.HONEY)));


  // Foliage
  public static final Block LUCILLE_TULIP = registerBlock("lucille_tulip",
          new FlowerBlock(StatusEffects.SATURATION,4, AbstractBlock.Settings.copy(Blocks.WHITE_TULIP)));

  public static final Block POTTED_LUCILLE_TULIP = registerBlockWithoutBlockItem("potted_lucille_tulip",
          new FlowerPotBlock(LUCILLE_TULIP, AbstractBlock.Settings.copy(Blocks.POTTED_WHITE_TULIP)));

  public static final Block LUCI_LEAF_PILE = registerBlock("luci_leaf_pile",
          new LuciLeafPileBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)));

  public static final Block CLOVER = registerBlock("clover_block",
          new CloverBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)
                  .noCollision()));

  public static final Block TALL_CLOVER = registerBlock("tall_clover_block",
          new CloverBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)
                  .noCollision()));

  public static final Block FLAURELLE = registerBlock("flaurelle",
          new FlowerBlock(StatusEffects.SATURATION,4, AbstractBlock.Settings.copy(Blocks.WHITE_TULIP)));

  public static final Block POTTED_FLAURELLE = registerBlockWithoutBlockItem("potted_flaurelle",
          new FlowerPotBlock(LUCILLE_TULIP, AbstractBlock.Settings.copy(Blocks.POTTED_WHITE_TULIP)));

  public static final Block LUCI_PETAL = registerBlock("luci_petals",
  new LuciPetals(AbstractBlock.Settings.copy(Blocks.PINK_PETALS)
                  .nonOpaque()
                   .noCollision()));

  public static final Block BLOSSOMING_LUCI_LEAVES = registerBlock("blossoming_luci_leaves",
          new BlossomingLuciLeavesBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)
                  .nonOpaque()
                  .mapColor(MapColor.EMERALD_GREEN)));

  public static final Block LUCI_LEAVES = registerBlock("luci_leaves",
          new LuciLeavesBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)
                  .nonOpaque()
                  .mapColor(MapColor.EMERALD_GREEN)));


  // Mushrooms
  public static final Block GREEN_MUSHROOM_LAMP = registerBlock("green_mushroom_lamp",
          new GreenMushroomLampBlock(AbstractBlock.Settings.create()
                  .mapColor(MapColor.DIAMOND_BLUE)
                  .sounds(BlockSoundGroup.FUNGUS)
                  .luminance(createGreenMushroomLightFromClickedBlockstate(7))));

  public static final Block BLUE_MUSHROOM_LAMP = registerBlock("blue_mushroom_lamp",
          new BlueMushroomLampBlock(AbstractBlock.Settings.create()
                  .mapColor(MapColor.DIAMOND_BLUE)
                  .sounds(BlockSoundGroup.FUNGUS)
                  .luminance(createBlueMushroomLightFromClickedBlockstate(7))));

  public static final Block LUCI_MUSHROOM = registerBlock("luci_mushroom_block",
          new LuciMushroomBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                  .sounds(BlockSoundGroup.FUNGUS)
                  .nonOpaque()
                  .pistonBehavior(PistonBehavior.DESTROY)
                  .noCollision()));


  // Wood Blocks
  public static final BlockSetType LUCI = new BlockSetType("luci");
  public static final WoodType LUCI_TYPE = new WoodType("luci", LUCI);

  public static final Block LUCI_LOG = registerBlock("luci_log",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, AbstractBlock.Settings.copy(Blocks.CHERRY_LOG)));

  public static final Block HOLLOW_LUCI_LOG = registerBlock("hollow_luci_log",
          new HollowLuciLogBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LOG)
                  .nonOpaque()));

  public static final Block LUCI_WOOD = registerBlock("luci_wood",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)));

  public static final Block STRIPPED_LUCI_LOG = registerBlock("stripped_luci_log",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, AbstractBlock.Settings.copy(Blocks.STRIPPED_CHERRY_LOG)));

  public static final Block STRIPPED_LUCI_WOOD = registerBlock("stripped_luci_wood",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, AbstractBlock.Settings.copy(Blocks.STRIPPED_CHERRY_WOOD)));

  public static final Block LUCI_SAPLING = registerBlock("luci_sapling",
          new SaplingBlock(ModSaplingGenerators.LUCI, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

  public static final Block BLOSSOMING_LUCI_SAPLING = registerBlock("blossoming_luci_sapling",
          new SaplingBlock(ModSaplingGenerators.BLOSSOMING_LUCI, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

  public static final Block LUCI_PLANKS = registerBlock("luci_planks",
          new Block(AbstractBlock.Settings.create()
                  .mapColor(MapColor.GREEN)
                  .instrument(NoteBlockInstrument.BASS)
                  .strength(2.0F, 3.0F)
                  .sounds(BlockSoundGroup.CHERRY_WOOD)
                  .burnable()));


  public static final Block LUCI_STAIRS = registerBlock("luci_stairs",
          new StairsBlock(ModBlocks.LUCI_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.CHERRY_STAIRS)));

  public static final Block LUCI_SLABS = registerBlock("luci_slabs",
          new SlabBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_SLAB)
                  .mapColor(MapColor.GREEN)));

  public static final Block LUCI_BUTTON = registerBlock("luci_button",
          new ButtonBlock(LUCI, 10, AbstractBlock.Settings.copy(Blocks.CHERRY_BUTTON)));

  public static final Block LUCI_FENCE = registerBlock("luci_fence",
          new FenceBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE)));

  public static final Block LUCI_FENCE_GATE = registerBlock("luci_fence_gate",
          new FenceGateBlock(LUCI_TYPE, AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE_GATE)));

  public static final Block LUCI_WALL = registerBlock("luci_wall",
          new WallBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));

  public static final Block LUCI_DOOR = registerBlock("luci_door",
          new DoorBlock(LUCI, AbstractBlock.Settings.copy(Blocks.CHERRY_DOOR)));

  public static final Block LUCI_TRAPDOOR = registerBlock("luci_trapdoor",
          new TrapdoorBlock(LUCI, AbstractBlock.Settings.copy(Blocks.CHERRY_TRAPDOOR)));

  public static final Block LUCI_PRESSURE_PLATE = registerBlock("luci_pressure_plate",
          new PressurePlateBlock(LUCI, AbstractBlock.Settings.copy(Blocks.CHERRY_PRESSURE_PLATE)));



  // Signs

  public static final TerraformSignBlock LUCI_SIGN = registerSignBlock("luci_sign", new TerraformSignBlock(
          id("entity/signs/luci"),
          AbstractBlock.Settings
                  .copy(Blocks.OAK_SIGN)
                  .mapColor(MapColor.TERRACOTTA_GRAY)));

  public static final TerraformWallSignBlock LUCI_WALL_SIGN = registerWallSignBlock("luci_wall_sign",
          new TerraformWallSignBlock(id("entity/signs/luci"),
                  AbstractBlock.Settings
                          .copy(Blocks.OAK_WALL_SIGN)
                          .dropsLike(LUCI_SIGN)
                          .mapColor(MapColor.TERRACOTTA_GRAY)));

  public static final TerraformHangingSignBlock LUCI_HANGING_SIGN = registerHangingSignBlock(
          "luci_hanging_sign", new TerraformHangingSignBlock(
                  id("entity/signs/hanging/luci"),
                  id("textures/gui/hanging_signs/luci"),
                  AbstractBlock.Settings
                          .copy(Blocks.OAK_HANGING_SIGN)
                          .mapColor(MapColor.TERRACOTTA_GRAY)));

  public static final TerraformWallHangingSignBlock LUCI_WALL_HANGING_SIGN = registerWallHangingSignBlock(
          "luci_wall_hanging_sign", new TerraformWallHangingSignBlock(
                  id("entity/signs/hanging/luci"),
                  id("textures/gui/hanging_signs/luci"),
                  AbstractBlock.Settings
                          .copy(Blocks.OAK_WALL_HANGING_SIGN)
                          .dropsLike(LUCI_HANGING_SIGN)
                          .mapColor(MapColor.TERRACOTTA_GRAY)));

  // Ore Blocks
  public static final Block NEPHRITE_ORE = registerBlock("nephrite_ore",
          new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

  public static final Block DEEPSLATE_NEPHRITE_ORE = registerBlock("deepslate_nephrite_ore",
          new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)));

  public static final Block FROSTITE_ORE = registerBlock("frostite_ore",
          new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

  public static final Block DEEPSLATE_FROSTITE_ORE = registerBlock("deepslate_frostite_ore",
          new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)));


  // Helper Methods

  private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, name, block);
  }

  private static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, Identifier.of(EllesMobsNPlenty.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
  }
  public static void registerModBlocks() {
    EllesMobsNPlenty.LOGGER.info("Registering Mod Blocks for " + EllesMobsNPlenty.MOD_ID);
  }

  public static Block registerBlockWithoutBlockItem(String name, Block block) {
    return Registry.register(Registries.BLOCK, Identifier.of(EllesMobsNPlenty.MOD_ID, name), block);
  }

  public static ToIntFunction<BlockState> createGreenMushroomLightFromClickedBlockstate(int clickedLevel) {
    return state -> state.get(GreenMushroomLampBlock.CLICKED) ? clickedLevel : 0;
  }
  public static ToIntFunction<BlockState> createBlueMushroomLightFromClickedBlockstate(int clickedLevel) {
    return state -> state.get(BlueMushroomLampBlock.CLICKED) ? clickedLevel : 0;
  }

  private static TerraformSignBlock registerSignBlock(String name, TerraformSignBlock block) {
    return Registry.register(Registries.BLOCK, Identifier.of(EllesMobsNPlenty.MOD_ID, name), block);
  }

  private static TerraformWallSignBlock registerWallSignBlock(String name, TerraformWallSignBlock block) {
    return Registry.register(Registries.BLOCK, Identifier.of(EllesMobsNPlenty.MOD_ID, name), block);
  }

  private static TerraformHangingSignBlock registerHangingSignBlock(String name, TerraformHangingSignBlock block) {
    return Registry.register(Registries.BLOCK, Identifier.of(EllesMobsNPlenty.MOD_ID, name), block);
  }

  private static TerraformWallHangingSignBlock registerWallHangingSignBlock(String name,
                                                                            TerraformWallHangingSignBlock block) {
    return Registry.register(Registries.BLOCK, Identifier.of(EllesMobsNPlenty.MOD_ID, name), block);
  }

  private static Identifier id(String path) {
    return Identifier.of(EllesMobsNPlenty.MOD_ID, path);
  }
}
