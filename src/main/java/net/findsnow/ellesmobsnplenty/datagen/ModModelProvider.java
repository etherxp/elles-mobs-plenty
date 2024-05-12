package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.findsnow.ellesmobsnplenty.block.ChomperBlock;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.block.mushrooms.BlueMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.GreenMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
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

    // Custom Blocks
    registerChomper(blockStateModelGenerator);
    registerGreenMushroomLamp(blockStateModelGenerator);
    registerBlueMushroomLamp(blockStateModelGenerator);

    // Ores
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NEPHRITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_NEPHRITE_ORE);

    // Lucero Wood
    BlockStateModelGenerator.BlockTexturePool luceroTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LUCERO_PLANKS);
    luceroTexturePool.stairs(ModBlocks.LUCERO_STAIRS);
    luceroTexturePool.slab(ModBlocks.LUCERO_SLABS);
    luceroTexturePool.button(ModBlocks.LUCERO_BUTTON);
    luceroTexturePool.pressurePlate(ModBlocks.LUCERO_PRESSURE_PLATE);
    luceroTexturePool.fence(ModBlocks.LUCERO_FENCE);
    luceroTexturePool.fenceGate(ModBlocks.LUCERO_FENCE_GATE);
    luceroTexturePool.wall(ModBlocks.LUCERO_WALL);

    blockStateModelGenerator.registerDoor(ModBlocks.LUCERO_DOOR);
    blockStateModelGenerator.registerTrapdoor(ModBlocks.LUCERO_TRAPDOOR);

    blockStateModelGenerator.registerLog(ModBlocks.LUCERO_LOG).log(ModBlocks.LUCERO_LOG).wood(ModBlocks.LUCERO_WOOD);
    blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_LUCERO_LOG).log(ModBlocks.STRIPPED_LUCERO_LOG).wood(ModBlocks.STRIPPED_LUCERO_WOOD);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUCERO_LEAVES);

    blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.LUCERO_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
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
    itemModelGenerator.register(ModItems.NEPHRITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_NEPHRITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NIGHT_TIME_MUSIC_DISC, Models.GENERATED);

    itemModelGenerator.register(ModBlocks.LUCERO_SAPLING.asItem(), Models.GENERATED);
  }
}