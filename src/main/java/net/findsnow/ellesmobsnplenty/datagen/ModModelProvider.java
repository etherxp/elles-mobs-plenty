package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.findsnow.ellesmobsnplenty.block.ChomperBlock;
import net.findsnow.ellesmobsnplenty.block.HollowLuciLogBlock;
import net.findsnow.ellesmobsnplenty.block.LuciLeavesBlock;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.block.mushrooms.BlueMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.GreenMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    // Blocks
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NEPHRITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_NEPHRITE_BLOCK);
    blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUCILLE_TULIP, ModBlocks.POTTED_LUCILLE_TULIP, BlockStateModelGenerator.TintType.NOT_TINTED);

    // Custom Blocks
    registerChomper(blockStateModelGenerator);
    registerGreenMushroomLamp(blockStateModelGenerator);
    registerBlueMushroomLamp(blockStateModelGenerator);

    // Ores
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NEPHRITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FROSTITE_ORE);

    // Lucero Wood
    BlockStateModelGenerator.BlockTexturePool luceroTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LUCI_PLANKS);
    luceroTexturePool.stairs(ModBlocks.LUCI_STAIRS);
    luceroTexturePool.slab(ModBlocks.LUCI_SLABS);
    luceroTexturePool.button(ModBlocks.LUCI_BUTTON);
    luceroTexturePool.pressurePlate(ModBlocks.LUCI_PRESSURE_PLATE);
    luceroTexturePool.fence(ModBlocks.LUCI_FENCE);
    luceroTexturePool.fenceGate(ModBlocks.LUCI_FENCE_GATE);
    luceroTexturePool.wall(ModBlocks.LUCI_WALL);

    blockStateModelGenerator.registerDoor(ModBlocks.LUCI_DOOR);
    blockStateModelGenerator.registerTrapdoor(ModBlocks.LUCI_TRAPDOOR);
    luceroTexturePool.family(BlockFamilies.register(ModBlocks.LUCI_PLANKS).sign(ModBlocks.LUCI_SIGN, ModBlocks.LUCI_WALL_SIGN).build());
    blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_LUCI_LOG, ModBlocks.LUCI_HANGING_SIGN, ModBlocks.LUCI_WALL_HANGING_SIGN);

    blockStateModelGenerator.registerLog(ModBlocks.LUCI_LOG).log(ModBlocks.LUCI_LOG).wood(ModBlocks.LUCI_WOOD);
    blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_LUCI_LOG).log(ModBlocks.STRIPPED_LUCI_LOG).wood(ModBlocks.STRIPPED_LUCI_WOOD);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUCI_LEAVES);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOSSOMING_LUCI_LEAVES);

    blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.LUCI_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
  }

  // Custom Registers
  private void registerChomper(BlockStateModelGenerator blockStateModelGenerator) {
    Identifier identifier = ModelIds.getBlockModelId(ModBlocks.CHOMPER_BLOCK);
    Identifier identifier2 = ModelIds.getBlockSubModelId(ModBlocks.CHOMPER_BLOCK, "_open");
    blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHOMPER_BLOCK)
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
            .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChomperBlock.OPEN, identifier2, identifier)));
  }

  private void registerGreenMushroomLamp(BlockStateModelGenerator blockStateModelGenerator) {
    Identifier identifier = ModelIds.getBlockModelId(ModBlocks.GREEN_MUSHROOM_LAMP);
    Identifier identifier2 = ModelIds.getBlockSubModelId(ModBlocks.GREEN_MUSHROOM_LAMP, "_lit");
    blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GREEN_MUSHROOM_LAMP)
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
            .coordinate(BlockStateModelGenerator.createBooleanModelMap(GreenMushroomLampBlock.CLICKED, identifier2, identifier)));
  }

  private void registerBlueMushroomLamp(BlockStateModelGenerator blockStateModelGenerator) {
    Identifier identifier = ModelIds.getBlockModelId(ModBlocks.BLUE_MUSHROOM_LAMP);
    Identifier identifier2 = ModelIds.getBlockSubModelId(ModBlocks.BLUE_MUSHROOM_LAMP, "_lit");
    blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_MUSHROOM_LAMP)
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
            .coordinate(BlockStateModelGenerator.createBooleanModelMap(BlueMushroomLampBlock.CLICKED, identifier2, identifier)));
  }


  // Item Models
  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.FROSTITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_NEPHRITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NIGHT_TIME_MUSIC_DISC, Models.GENERATED);

    itemModelGenerator.register(ModItems.NEPHRITE_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_SWORD, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_HOE, Models.HANDHELD);

    itemModelGenerator.register(ModItems.NEPHRITE_HELMET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_CHESTPLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_LEGGINGS, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_BOOTS, Models.GENERATED);

    itemModelGenerator.register(ModBlocks.LUCI_SAPLING.asItem(), Models.GENERATED);

  }
}