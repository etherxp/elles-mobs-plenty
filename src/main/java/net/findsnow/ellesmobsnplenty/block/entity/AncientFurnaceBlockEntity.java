package net.findsnow.ellesmobsnplenty.block.entity;

import net.findsnow.ellesmobsnplenty.recipe.AncientFurnaceRecipe;
import net.findsnow.ellesmobsnplenty.screen.AncientFurnaceScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class AncientFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
  private Map<Item, Integer> BURN_DURATION_MAP = Map.of(
          Items.COAL, 200,
          Items.CHARCOAL, 200);

  public AncientFurnaceBlockEntity(BlockPos pos, BlockState state) {
    super(ModBlockEntities.ANCIENT_FURNACE_BE, pos, state, AncientFurnaceRecipe.Type.INSTANCE);
  }

  @Override
  protected Text getContainerName() {
    return Text.translatable("block.ellesmobsnplenty.ancient_furnace");
  }

  @Override
  protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
    return new AncientFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
  }

  @Override
  protected int getFuelTime(ItemStack fuel) {
    return BURN_DURATION_MAP.getOrDefault(fuel.getItem(), 0);
  }

  @Override
  public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
    if (slot == 1) {
      return FurnaceBlockEntity.canUseAsFuel(stack);
    } else if (slot == 0) {
      return true;
    }
    return false;
  }

  @Override
  public boolean canExtract(int slot, ItemStack stack, Direction dir) {
    return slot == 2;
  }
}
