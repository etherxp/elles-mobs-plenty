package net.findsnow.ellesmobsnplenty.recipe;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
  public static void registerRecipes() {
    Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(EllesMobsNPlenty.MOD_ID, "ancient_furnace"),
            AncientFurnaceRecipe.Serializer.INSTANCE);

    Registry.register(Registries.RECIPE_TYPE, new Identifier(EllesMobsNPlenty.MOD_ID, "ancient_furnace"),
            AncientFurnaceRecipe.Type.INSTANCE);
  }
}
