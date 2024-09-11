package net.findsnow.ellesmobsnplenty.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.findsnow.ellesmobsnplenty.block.custom.ChomperBlock;
import net.findsnow.ellesmobsnplenty.recipe.ChomperRecipe;
import net.findsnow.ellesmobsnplenty.screen.ChomperBlockScreenHandler;
import net.findsnow.ellesmobsnplenty.sound.ModSounds;
import net.minecraft.block.Block;
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
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;


public class ChomperBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
  private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

  private boolean isSoundPlaying = false;
  private static final Integer INPUT_SLOT = 0;
  private static final Integer OUTPUT_SLOT = 1;
  private final RecipeManager.MatchGetter<RecipeInput, ChomperRecipe> matchGetter = RecipeManager.createCachedMatchGetter(ChomperRecipe.Type.INSTANCE);

  protected final PropertyDelegate propertyDelegate;
  private int progress = 0;
  private int maxProgress = 70;


  public ChomperBlockEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.CHOMPER_BLOCK_ENTITY, pos, state);
    this.propertyDelegate = new PropertyDelegate() {
      @Override
      public int get(int index) {
        return switch (index) {
          case 0 -> ChomperBlockEntity.this.progress;
          case 1 -> ChomperBlockEntity.this.maxProgress;
          default -> 0;
        };
      }

      @Override
      public void set(int index, int value) {
        switch (index) {
          case 0: ChomperBlockEntity.this.progress = value;
          case 1: ChomperBlockEntity.this.maxProgress = value;
        }
      }

      @Override
      public int size() {
        return 2;
      }
    };
  }

  @Override
  public Text getDisplayName() {
    return Text.literal("Chomper");
  }

  @Nullable
  @Override
  public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new ChomperBlockScreenHandler(syncId, playerInventory, this, propertyDelegate);
  }

  @Override
  public DefaultedList<ItemStack> getItems() {
    return this.inventory;
  }

  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.writeNbt(nbt, registryLookup);
    Inventories.writeNbt(nbt, this.inventory, registryLookup);
    nbt.putInt("chomper.progress", progress);
  }

  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    Inventories.readNbt(nbt, this.inventory, registryLookup);
    progress = nbt.getInt("chomper.progress");
  }

  public void tick(World world, BlockPos pos, BlockState state, ChomperBlockEntity blockEntity) {

    if(world.isClient()) {
      return;
    }

    boolean wasCrafting = blockEntity.isCrafting();
    boolean hasInput = !blockEntity.getStack(INPUT_SLOT).isEmpty();
    boolean isCraftingNow = hasInput && canInsertIntoOutput() && hasRecipe();

    if (isOutputSlotEmptyOrReceivable()) {
      if (this.hasRecipe()) {
        if (isCraftingNow) {
          increaseCraftingProgress();
          markDirty(world, pos, state);
          state = state.with(ChomperBlock.CHOMPING, true);
          world.setBlockState(pos, state, Block.NOTIFY_ALL);

          if (!wasCrafting) {
            isSoundPlaying = true;
          }

          if (isSoundPlaying) {
            if (world.getTime() % 10 == 0) {
              world.playSound(null, pos, ModSounds.CHOMPER_CHOMPING, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
          }

          if (hasCraftingFinished()) {
            craftItem();
            resetProgress();
            isSoundPlaying = false;
            if (world.getBlockState(pos).get(ChomperBlock.CHOMPING)) {
              world.setBlockState(pos, state.with(ChomperBlock.CHOMPING, false), Block.NOTIFY_ALL);
            }
          }

        } else {
          if (wasCrafting) {
            resetProgress();
            if (isSoundPlaying) {
              isSoundPlaying = false;
            }
            if (world.getBlockState(pos).get(ChomperBlock.CHOMPING)) {
              world.setBlockState(pos, state.with(ChomperBlock.CHOMPING, false), Block.NOTIFY_ALL);
            }
          }
        }
      }
    }
  }

  private void craftItem() {
    Optional<RecipeEntry<ChomperRecipe>> recipe = getcurrentRecipe();

    this.removeStack(INPUT_SLOT, 1);
    this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
            this.getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
  }

  private void resetProgress() {
    this.progress = 0;
  }

  private boolean hasCraftingFinished() {
    return this.progress >= this.maxProgress;
  }

  private void increaseCraftingProgress() {
    this.progress++;
  }

  private boolean hasRecipe() {
    Optional<RecipeEntry<ChomperRecipe>> recipe = getcurrentRecipe();

    return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
            && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
  }

  private boolean canInsertItemIntoOutputSlot(Item item) {
    return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
  }

  private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
    return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
  }

  private boolean isOutputSlotEmptyOrReceivable() {
    return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
  }

  private Optional<RecipeEntry<ChomperRecipe>> getcurrentRecipe() {
    SimpleInventory simpleInventory = new SimpleInventory(this.size());
    for (int i = 0; i < this.size(); i++) {
      simpleInventory.setStack(i, this.getStack(i));
    }
    return this.matchGetter.getFirstMatch(new SingleStackRecipeInput(this.inventory.getFirst()), this.getWorld());
  }

  private boolean isCrafting() {
    return this.progress > 0;
  }

  private boolean canInsertIntoOutput() {
    return this.getStack(OUTPUT_SLOT).isEmpty() ||
            this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
  }

  @Override
  public Object getScreenOpeningData(ServerPlayerEntity player) {
    return new ChomperBlockEntityData(this.pos);
  }
}
