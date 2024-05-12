package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
  public ModRecipeGenerator(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generate(Consumer<RecipeJsonProvider> exporter) {

    // BLOCKS
    ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LUCERO_PLANKS, 4)
            .input(ModBlocks.LUCERO_LOG)
            .criterion(hasItem(ModBlocks.LUCERO_LOG), conditionsFromItem(ModBlocks.LUCERO_LOG))
            .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LUCERO_PLANKS) + "_from_log"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHOMPER_BLOCK, 1)
                    .pattern("III")
                    .pattern("ICI")
                    .pattern("NPN")
                    .input('I', Items.IRON_INGOT)
                    .input('C', Blocks.CRAFTING_TABLE)
                    .input('N', ModItems.NEPHRITE)
                    .input('P', Blocks.PISTON)
                    .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                    .criterion(hasItem(Blocks.CRAFTING_TABLE), conditionsFromItem(Blocks.CRAFTING_TABLE))
                    .criterion(hasItem(ModItems.NEPHRITE), conditionsFromItem(ModItems.NEPHRITE))
                    .criterion(hasItem(Blocks.PISTON), conditionsFromItem(Blocks.PISTON))
                    .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CHOMPER_BLOCK)));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CRAFTING_TABLE, 1)
            .pattern("NN ")
            .pattern("NN ")
            .input('N', ModBlocks.LUCERO_PLANKS)
            .criterion(hasItem(ModBlocks.LUCERO_PLANKS), conditionsFromItem(ModBlocks.LUCERO_PLANKS))
            .offerTo(exporter, new Identifier(getRecipeName(Blocks.CRAFTING_TABLE) + "_from_lucero_planks"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LUCERO_DOOR, 3)
            .pattern("LL ")
            .pattern("LL ")
            .pattern("LL ")
            .input('L', ModBlocks.LUCERO_PLANKS)
            .criterion(hasItem(ModBlocks.LUCERO_PLANKS), conditionsFromItem(ModBlocks.LUCERO_PLANKS))
            .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LUCERO_DOOR) + "_from_lucero_planks"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LUCERO_WOOD, 4)
            .pattern("LL ")
            .pattern("LL ")
            .input('L', ModBlocks.LUCERO_LOG)
            .criterion(hasItem(ModBlocks.LUCERO_LOG), conditionsFromItem(ModBlocks.LUCERO_LOG))
            .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LUCERO_WOOD) + "_from_log"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STRIPPED_LUCERO_WOOD, 4)
            .pattern("LL ")
            .pattern("LL ")
            .input('L', ModBlocks.STRIPPED_LUCERO_LOG)
            .criterion(hasItem(ModBlocks.STRIPPED_LUCERO_LOG), conditionsFromItem(ModBlocks.STRIPPED_LUCERO_LOG))
            .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STRIPPED_LUCERO_WOOD) + "_from_log"));

    // BLOCKS -> INGOTS
    offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.NEPHRITE, RecipeCategory.MISC, ModBlocks.NEPHRITE_BLOCK);

    ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NEPHRITE_NUGGET, 9)
                    .input(ModItems.NEPHRITE)
                    .criterion(hasItem(ModItems.NEPHRITE), conditionsFromItem(ModItems.NEPHRITE))
                    .offerTo(exporter, new Identifier(getRecipeName(ModItems.NEPHRITE) + "_to_nuggets"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NEPHRITE)
            .pattern("NNN")
            .pattern("NNN")
            .pattern("NNN")
            .input('N', ModItems.NEPHRITE_NUGGET)
            .criterion(hasItem(ModItems.NEPHRITE_NUGGET), conditionsFromItem(ModItems.NEPHRITE_NUGGET))
            .offerTo(exporter, new Identifier(getRecipeName(ModItems.NEPHRITE) + "_from_nugget"));

    // SMELTING
    offerSmelting(exporter, List.of(ModItems.RAW_NEPHRITE,
            ModBlocks.NEPHRITE_ORE, ModBlocks.DEEPSLATE_NEPHRITE_ORE), RecipeCategory.MISC,
            ModItems.NEPHRITE, 0.25f, 200, "nephrite");
    offerBlasting(exporter, List.of(ModItems.RAW_NEPHRITE,
                    ModBlocks.NEPHRITE_ORE, ModBlocks.DEEPSLATE_NEPHRITE_ORE), RecipeCategory.MISC,
            ModItems.NEPHRITE, 0.25f, 100, "nephrite");
  }
}
