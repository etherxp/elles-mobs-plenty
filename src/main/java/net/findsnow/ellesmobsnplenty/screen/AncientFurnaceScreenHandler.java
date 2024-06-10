package net.findsnow.ellesmobsnplenty.screen;

import net.findsnow.ellesmobsnplenty.block.entity.AncientFurnaceBlockEntity;
import net.findsnow.ellesmobsnplenty.recipe.AncientFurnaceRecipe;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;

public class AncientFurnaceScreenHandler extends AbstractFurnaceScreenHandler {
  public AncientFurnaceScreenHandler(int syncId, PlayerInventory playerInventory) {
    super(ModScreenHandlers.ANCIENT_FURNACE_SCREEN_HANDLER, AncientFurnaceRecipe.Type.INSTANCE, RecipeBookCategory.FURNACE, syncId, playerInventory);
  }
  public AncientFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, AncientFurnaceBlockEntity blockEntity, PropertyDelegate propertyDelegate) {
    super(ModScreenHandlers.ANCIENT_FURNACE_SCREEN_HANDLER, AncientFurnaceRecipe.Type.INSTANCE, RecipeBookCategory.FURNACE, syncId, playerInventory, blockEntity, propertyDelegate);
  }
}
