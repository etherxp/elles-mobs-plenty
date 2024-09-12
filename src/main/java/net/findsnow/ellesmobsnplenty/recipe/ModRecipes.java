package net.findsnow.ellesmobsnplenty.recipe;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(EllesMobsNPlenty.MOD_ID, ChomperRecipe.Serializer.ID),
                ChomperRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(EllesMobsNPlenty.MOD_ID, ChomperRecipe.Type.ID),
                ChomperRecipe.Type.INSTANCE);

    }
}
