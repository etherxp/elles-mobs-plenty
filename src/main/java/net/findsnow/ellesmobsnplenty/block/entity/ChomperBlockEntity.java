package net.findsnow.ellesmobsnplenty.block.entity;


import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.findsnow.ellesmobsnplenty.recipe.ChomperRecipe;
import net.findsnow.ellesmobsnplenty.recipe.ChomperRecipeSerializer;
import net.findsnow.ellesmobsnplenty.recipe.ModRecipes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ChomperBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
  private final RecipeManager.MatchGetter<SingleStackRecipeInput, ChomperRecipe> matchGetter;
  private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
  private static final Integer INPUT_SLOT = 0;
  private static final Integer OUTPUT_SLOT = 1;

  public ChomperBlockEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.CHOMPER_BLOCK_ENTITY, pos, state);
    this.matchGetter = RecipeManager.createCachedMatchGetter(ModRecipes.CHOMPER);
  }

  @Override
  public Text getDisplayName() {
    return Text.literal("Chomper");
  }

  @Nullable
  @Override
  public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return null;
  }

  @Override
  public DefaultedList<ItemStack> getItems() {
    return this.inventory;
  }

  @Override
  public int size() {
    return 2;
  }

  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.writeNbt(nbt, registryLookup);
    Inventories.writeNbt(nbt, this.inventory, registryLookup);
  }

  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    Inventories.readNbt(nbt, this.inventory, registryLookup);
  }

  public void tick(World world, BlockPos pos, BlockState state) {
    if (!world.isClient) {
      ItemStack input = getStack(INPUT_SLOT);
      if (!input.isEmpty() && hasRecipe(this, world.getRegistryManager())) {
        craftItem(this, world.getRegistryManager());
      }
    }
  }

  private boolean hasRecipe(ChomperBlockEntity blockEntity, DynamicRegistryManager registryManager) {
    RecipeEntry<?> recipeEntry = blockEntity.matchGetter.getFirstMatch(new SingleStackRecipeInput(blockEntity.inventory.getFirst()), world).orElse(null);
    return recipeEntry != null &&
            canInsertAmountToOutput(recipeEntry.value().getResult(registryManager)) &&
            canInsertItemToOutput(recipeEntry.value().getResult(registryManager).getItem());
  }

  private void craftItem(ChomperBlockEntity blockEntity, DynamicRegistryManager registryManager) {
    RecipeEntry<?> recipeEntry = blockEntity.matchGetter
            .getFirstMatch(new SingleStackRecipeInput(blockEntity.inventory.getFirst()), world).orElse(null);
    if(recipeEntry != null)
    {
      this.removeStack(INPUT_SLOT, 1);

      this.setStack(OUTPUT_SLOT,
              new ItemStack(recipeEntry.value().getResult(registryManager).getItem(),
                      getStack(OUTPUT_SLOT).getCount() + recipeEntry.value().getResult(registryManager).getCount()));
    }
  }

  private boolean canInsertAmountToOutput(ItemStack result) {
    return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= this.getStack(OUTPUT_SLOT).getMaxCount();
  }

  private boolean canInsertItemToOutput(Item item) {
    return this.getStack(OUTPUT_SLOT).getItem() == item ||
            this.getStack(OUTPUT_SLOT).isEmpty();
  }
}
