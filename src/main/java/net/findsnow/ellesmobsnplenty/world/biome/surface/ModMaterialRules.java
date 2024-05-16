package net.findsnow.ellesmobsnplenty.world.biome.surface;

import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
  private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
  private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
  private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);


  public static MaterialRules.MaterialRule makeRules() {
    MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-3, 2);

    MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

    return MaterialRules.sequence(
            MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.LUCERO_BIOME),
                            MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK)),
                    MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE)),

            // Default to a grass and dirt surface
            MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
    );
  }
  private static MaterialRules.MaterialRule makeStateRule(Block block) {
    return MaterialRules.block(block.getDefaultState());
  }
}
