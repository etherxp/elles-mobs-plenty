package net.findsnow.ellesmobsnplenty.datagen.recipe;

import net.findsnow.ellesmobsnplenty.recipe.ChomperRecipe;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChomperRecipeJsonBuilder implements CraftingRecipeJsonBuilder {

  private final RecipeCategory category;
  private final CraftingRecipeCategory craftingRecipeCategory;
  private final Item output;
  private final Ingredient input;
  private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap();
  @Nullable
  private String group;
  private final ChomperRecipe.RecipeFactory<?> recipeFactory;

  public ChomperRecipeJsonBuilder(RecipeCategory category, CraftingRecipeCategory craftingRecipeCategory, Item output, Ingredient input, ChomperRecipe.RecipeFactory<?> recipeFactory) {
    this.category = category;
    this.craftingRecipeCategory = craftingRecipeCategory;
    this.output = output;
    this.input = input;
    this.recipeFactory = recipeFactory;
  }

  @Override
  public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
    return null;
  }

  @Override
  public CraftingRecipeJsonBuilder group(@Nullable String group) {
    return null;
  }

  @Override
  public Item getOutputItem() {
    return output;
  }

  @Override
  public void offerTo(RecipeExporter exporter, Identifier recipeId) {

  }
}
