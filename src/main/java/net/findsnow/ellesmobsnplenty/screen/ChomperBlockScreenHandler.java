package net.findsnow.ellesmobsnplenty.screen;

import net.findsnow.ellesmobsnplenty.block.entity.ChomperBlockEntity;
import net.findsnow.ellesmobsnplenty.block.entity.ChomperBlockEntityData;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;

public class ChomperBlockScreenHandler extends ScreenHandler {
  private final Inventory inventory;
  private final PropertyDelegate propertyDelegate;
  public final ChomperBlockEntity blockEntity;


  public ChomperBlockScreenHandler(int syncId, PlayerInventory inventory, ChomperBlockEntityData data) {
    this(syncId, inventory, inventory.player.getWorld().getBlockEntity(data.pos()), new ArrayPropertyDelegate(2));
  }

  public ChomperBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
    super(ModScreenHandlers.CHOMPER_SCREEN_HANDLER, syncId);
    checkSize(((Inventory) blockEntity), 2);
    this.inventory = (Inventory) blockEntity;
    this.propertyDelegate = propertyDelegate;
    this.blockEntity = (ChomperBlockEntity) blockEntity;

    addProperties(propertyDelegate);
    this.addSlot(new Slot(inventory, 0, 50, 33));
    this.addSlot(new Slot(inventory, 1, 110, 35));

    addPlayerHotbar(playerInventory);
    addPlayerInventory(playerInventory);
  }

  @Override
  public ItemStack quickMove(PlayerEntity player, int invSlot) {
    ItemStack newStack = ItemStack.EMPTY;
    Slot slot = this.slots.get(invSlot);
    if (slot != null && slot.hasStack()) {
      ItemStack originalStack = slot.getStack();
      newStack = originalStack.copy();
      if (invSlot < this.inventory.size()) {
        if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
        return ItemStack.EMPTY;
      }

      if (originalStack.isEmpty()) {
        slot.setStack(ItemStack.EMPTY);
      } else {
        slot.markDirty();
      }
    }

    return newStack;
  }

  public boolean isCrafting() {
    return propertyDelegate.get(0) > 0;
  }

  public int getScaledProgress() {
    int progress = this.propertyDelegate.get(0);
    int maxProgress = this.propertyDelegate.get(1);
    int progressArrowSize = 31;
    return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
  }

  @Override
  public boolean canUse(PlayerEntity player) {
    return this.inventory.canPlayerUse(player);
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
