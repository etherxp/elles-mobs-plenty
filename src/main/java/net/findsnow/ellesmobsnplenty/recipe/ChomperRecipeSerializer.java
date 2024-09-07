package net.findsnow.ellesmobsnplenty.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.collection.DefaultedList;

public class ChomperRecipeSerializer implements RecipeSerializer<ChomperRecipe> {

  private final ChomperRecipe.RecipeFactory<ChomperRecipe> recipeFactory;
  private final MapCodec<ChomperRecipe> codec;
  private final PacketCodec<RegistryByteBuf, ChomperRecipe> packetCodec;

  public ChomperRecipeSerializer(ChomperRecipe.RecipeFactory<ChomperRecipe> recipeFactory) {
    this.recipeFactory = recipeFactory;
    this.codec = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
                    CraftingRecipeCategory.CODEC.fieldOf("category").orElse(CraftingRecipeCategory.MISC).forGetter(recipe -> recipe.category),
                    Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                    ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
            ).apply(instance, recipeFactory::create)
    );
    this.packetCodec = PacketCodec.ofStatic(this::write, this::read);
  }

  @Override
  public MapCodec<ChomperRecipe> codec() {
    return this.codec;
  }

  @Override
  public PacketCodec<RegistryByteBuf, ChomperRecipe> packetCodec() {
    return this.packetCodec;
  }

  private ChomperRecipe read(RegistryByteBuf buf)
  {
    String group = buf.readString();
    CraftingRecipeCategory recipeCategory = buf.readEnumConstant(CraftingRecipeCategory.class);
    Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
    ItemStack itemStack = ItemStack.PACKET_CODEC.decode(buf);
    return this.recipeFactory.create(group, recipeCategory, ingredient, itemStack);
  }

  private void write(RegistryByteBuf buf, ChomperRecipe recipe)
  {
    buf.writeString(recipe.group);
    buf.writeEnumConstant(recipe.getCategory());
    Ingredient.PACKET_CODEC.encode(buf, recipe.ingredient);
    ItemStack.PACKET_CODEC.encode(buf, recipe.result);
  }

  public ChomperRecipe create(String group, CraftingRecipeCategory craftingRecipeCategory, Ingredient ingredient, ItemStack result) {
    return this.recipeFactory.create(group, craftingRecipeCategory, ingredient, result);
  }
}
