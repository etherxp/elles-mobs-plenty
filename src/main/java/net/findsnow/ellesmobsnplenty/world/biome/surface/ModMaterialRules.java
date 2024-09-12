package net.findsnow.ellesmobsnplenty.world.biome.surface;

import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAboveWaterLevel = MaterialRules.water(0, 0); // Above water level
        MaterialRules.MaterialCondition isBelowWaterLevel = MaterialRules.water(0, -1); // Below water level

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAboveWaterLevel, GRASS_BLOCK), DIRT);
        MaterialRules.MaterialRule dirtSurface = MaterialRules.condition(isBelowWaterLevel, DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.LUCI_REGION_1),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface),

                // Ensure dirt is placed below water level
                MaterialRules.condition(isBelowWaterLevel, dirtSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
