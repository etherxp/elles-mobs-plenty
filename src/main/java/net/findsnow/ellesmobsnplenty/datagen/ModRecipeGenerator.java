package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
  public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  public void generate(RecipeExporter exporter) {

    // BLOCKS
    ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LUCI_PLANKS, 4)
            .input(ModBlocks.LUCI_LOG)
            .criterion(hasItem(ModBlocks.LUCI_LOG), conditionsFromItem(ModBlocks.LUCI_LOG))
            .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.LUCI_PLANKS) + "_from_log"));
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
                    .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.CHOMPER_BLOCK)));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CRAFTING_TABLE, 1)
            .pattern("NN ")
            .pattern("NN ")
            .input('N', ModBlocks.LUCI_PLANKS)
            .criterion(hasItem(ModBlocks.LUCI_PLANKS), conditionsFromItem(ModBlocks.LUCI_PLANKS))
            .offerTo(exporter, Identifier.of(getRecipeName(Blocks.CRAFTING_TABLE) + "_from_lucero_planks"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LUCI_DOOR, 3)
            .pattern("LL ")
            .pattern("LL ")
            .pattern("LL ")
            .input('L', ModBlocks.LUCI_PLANKS)
            .criterion(hasItem(ModBlocks.LUCI_PLANKS), conditionsFromItem(ModBlocks.LUCI_PLANKS))
            .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.LUCI_DOOR) + "_from_lucero_planks"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LUCI_WOOD, 4)
            .pattern("LL ")
            .pattern("LL ")
            .input('L', ModBlocks.LUCI_LOG)
            .criterion(hasItem(ModBlocks.LUCI_LOG), conditionsFromItem(ModBlocks.LUCI_LOG))
            .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.LUCI_WOOD) + "_from_log"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STRIPPED_LUCI_WOOD, 4)
            .pattern("LL ")
            .pattern("LL ")
            .input('L', ModBlocks.STRIPPED_LUCI_LOG)
            .criterion(hasItem(ModBlocks.STRIPPED_LUCI_LOG), conditionsFromItem(ModBlocks.STRIPPED_LUCI_LOG))
            .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.STRIPPED_LUCI_WOOD) + "_from_log"));

    // BLOCKS -> INGOTS
    offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.NEPHRITE, RecipeCategory.MISC, ModBlocks.NEPHRITE_BLOCK);

    ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NEPHRITE_NUGGET, 9)
                    .input(ModItems.NEPHRITE)
                    .criterion(hasItem(ModItems.NEPHRITE), conditionsFromItem(ModItems.NEPHRITE))
                    .offerTo(exporter, Identifier.of(getRecipeName(ModItems.NEPHRITE) + "_to_nuggets"));
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NEPHRITE)
            .pattern("NNN")
            .pattern("NNN")
            .pattern("NNN")
            .input('N', ModItems.NEPHRITE_NUGGET)
            .criterion(hasItem(ModItems.NEPHRITE_NUGGET), conditionsFromItem(ModItems.NEPHRITE_NUGGET))
            .offerTo(exporter, Identifier.of(getRecipeName(ModItems.NEPHRITE) + "_from_nugget"));

    // SMELTING
    offerSmelting(exporter, List.of(ModItems.RAW_NEPHRITE,
            ModBlocks.NEPHRITE_ORE, ModBlocks.DEEPSLATE_NEPHRITE_ORE), RecipeCategory.MISC,
            ModItems.NEPHRITE, 0.25f, 200, "nephrite");
    offerBlasting(exporter, List.of(ModItems.RAW_NEPHRITE,
                    ModBlocks.NEPHRITE_ORE, ModBlocks.DEEPSLATE_NEPHRITE_ORE), RecipeCategory.MISC,
            ModItems.NEPHRITE, 0.25f, 100, "nephrite");
  }
}
