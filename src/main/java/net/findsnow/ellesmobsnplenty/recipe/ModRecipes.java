package net.findsnow.ellesmobsnplenty.recipe;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

  public static RecipeType<ChomperRecipe> CHOMPER =
          Registry.register(Registries.RECIPE_TYPE, Identifier.of(EllesMobsNPlenty.MOD_ID, "chomper"),
                  new RecipeType<ChomperRecipe>() {
                    public String toString() {
                      return "chomper";
                    }
                  });

  public static RecipeSerializer<ChomperRecipe> CHOMPER_SERIALIZER = Registry.register(
          Registries.RECIPE_SERIALIZER,
          Identifier.of(EllesMobsNPlenty.MOD_ID, "chomper"),
          new ChomperRecipeSerializer(ChomperRecipe::new)
  );

  public static void registerRecipes() {
    EllesMobsNPlenty.LOGGER.info("Registering Recipe Types");
  }
}
