package net.findsnow.ellesmobsnplenty.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class ChomperRecipe implements Recipe<RecipeInput> {
  private final ItemStack output;
  private final Ingredient ingredient;

  public ChomperRecipe(Ingredient ingredient, ItemStack itemStack) {
    this.output = itemStack;
    this.ingredient = ingredient;
  }

  @Override
  public boolean matches(RecipeInput input, World world) {
    if(world.isClient()) {
      return false;
    }
    return ingredient.test(input.getStackInSlot(0));
  }

  @Override
  public ItemStack craft(RecipeInput input, RegistryWrapper.WrapperLookup lookup) {
    return this.output.copy();
  }

  @Override
  public boolean fits(int width, int height) {
    return true;
  }

  @Override
  public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
    return output;
  }

  @Override
  public RecipeSerializer<?> getSerializer() {
    return Serializer.INSTANCE;
  }

  @Override
  public RecipeType<?> getType() {
    return Type.INSTANCE;
  }

  public static class Type implements RecipeType<ChomperRecipe> {
    public static final Type INSTANCE = new Type();
    public static final String ID = "chomper_block";
  }

  public static class Serializer implements RecipeSerializer<ChomperRecipe> {
    public static final Serializer INSTANCE = new Serializer();
    public static final String ID = "chomper_block";

    public static final MapCodec<ChomperRecipe> CODEC = RecordCodecBuilder.mapCodec(in -> in.group(
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredients").forGetter(chomperRecipe -> chomperRecipe.ingredient),
            ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(r -> r.output)
    ).apply(in, ChomperRecipe::new));

    public static final PacketCodec<RegistryByteBuf, ChomperRecipe> PACKET_CODEC = PacketCodec.ofStatic(Serializer::write, Serializer::read);

    @Override
    public MapCodec<ChomperRecipe> codec() {
      return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, ChomperRecipe> packetCodec() {
      return PACKET_CODEC;
    }

    public static ChomperRecipe read(RegistryByteBuf buf) {

      Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);

      ItemStack output = ItemStack.PACKET_CODEC.decode(buf);

      return new ChomperRecipe(ingredient, output);
    }


    public static void write(RegistryByteBuf buf, ChomperRecipe recipe) {

      Ingredient.PACKET_CODEC.encode(buf, recipe.ingredient);

      ItemStack.PACKET_CODEC.encode(buf, recipe.output);
    }
  }
}
