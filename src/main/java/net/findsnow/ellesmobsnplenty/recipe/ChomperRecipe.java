package net.findsnow.ellesmobsnplenty.recipe;


import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class ChomperRecipe implements Recipe<SingleStackRecipeInput> {
  protected final CraftingRecipeCategory category;
  protected final String group;
  protected final Ingredient ingredient;
  protected final ItemStack result;

  public ChomperRecipe(String group, CraftingRecipeCategory category, Ingredient ingredient, ItemStack result) {
    this.category = category;
    this.group = group;
    this.ingredient = ingredient;
    this.result = result;
  }

  @Override
  public boolean matches(SingleStackRecipeInput input, World world) {
    if (world.isClient()) {
      return false;
    }
    return this.ingredient.test(input.item());
  }

  @Override
  public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
    return this.result.copy();
  }

  @Override
  public boolean fits(int width, int height) {
    return true;
  }

  @Override
  public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
    return result;
  }

  @Override
  public DefaultedList<Ingredient> getIngredients() {
    DefaultedList<Ingredient> defaultedList = DefaultedList.of();
    defaultedList.add(this.ingredient);
    return defaultedList;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return ModRecipes.CHOMPER_SERIALIZER;
  }

  @Override
  public RecipeType<?> getType() {
    return ModRecipes.CHOMPER;
  }

  @Override
  public String getGroup() {
    return this.group;
  }

  public CraftingRecipeCategory getCategory() {
    return this.category;
  }

  public interface RecipeFactory<T extends ChomperRecipe> {
    T create(String group, CraftingRecipeCategory category, Ingredient ingredient, ItemStack result);
  }
}
