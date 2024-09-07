package net.findsnow.ellesmobsnplenty.screen;

import net.findsnow.ellesmobsnplenty.block.entity.ChomperBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class ChomperBlockScreenHandler extends ScreenHandler {

  private final Inventory result = new CraftingResultInventory();
  final Inventory input = new SimpleInventory(2) {

    @Override
    public void markDirty() {
      super.markDirty();
      ChomperBlockScreenHandler.this.onContentChanged(this);
    }
  };

  private final ScreenHandlerContext context;

  protected ChomperBlockScreenHandler(int syncId, PlayerInventory playerInventory) {
    this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
  }

  public ChomperBlockScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
    super(ModScreenHandlers.CHOMPER_SCREEN_HANDLER, syncId);
    this.context = context;

    this.addSlot(new Slot(input, 0, 46, 48));
    this.addSlot(new Slot(input, 1, 114, 48));

    addPlayerInventory(playerInventory);
    addPlayerHotbar(playerInventory);
  }

  @Override
  public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
    return false;
  }

  @Override
  public ItemStack quickMove(PlayerEntity player, int slot) {
    ItemStack newStack = ItemStack.EMPTY;
    Slot slot2 = this.slots.get(slot);
    if (slot2 != null && slot2.hasStack()) {
      ItemStack originalStack = slot2.getStack();
      newStack = originalStack.copy();
      if (slot < this.input.size()) {
        if (!this.insertItem(originalStack, this.input.size(), this.slots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.insertItem(originalStack, 0, this.input.size(), false)) {
        return ItemStack.EMPTY;
      }
      if (originalStack.isEmpty()) {
        slot2.setStack(ItemStack.EMPTY);
      } else {
        slot2.markDirty();
      }
    }
    return newStack;
  }

  @Override
  public boolean canUse(PlayerEntity player) {
    return this.input.canPlayerUse(player);
  }

  @Override
  public void onClosed(PlayerEntity player) {
    super.onClosed(player);
    this.context.run(((world, blockPos) -> this.dropInventory(player, this.input)));
  }

  private void addPlayerInventory(PlayerInventory playerInventory) {
    for (int i = 0; i < 3; ++i) {
      for (int l = 0; l < 9; ++l) {
        this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
      }
    }
  }

  private void addPlayerHotbar(PlayerInventory playerInventory) {
    for (int i = 0; i < 9; ++i) {
      this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
    }
  }
}
