package net.findsnow.ellesmobsnplenty.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;

public class AncientFurnaceRecipe extends AbstractCookingRecipe {
  public AncientFurnaceRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
    super(Type.INSTANCE, id, group, category, input, output, experience, cookTime);
  }


  @Override
  public RecipeSerializer<?> getSerializer() {
    return Serializer.INSTANCE;
  }

  public static class Type implements RecipeType<AncientFurnaceRecipe> {
    public static final Type INSTANCE = new Type();
  }

  public static class Serializer {
    public static final RecipeSerializer<AncientFurnaceRecipe> INSTANCE = new CookingRecipeSerializer<>(AncientFurnaceRecipe::new, 50);
  }
}
