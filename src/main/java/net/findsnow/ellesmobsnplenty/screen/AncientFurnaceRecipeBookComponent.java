package net.findsnow.ellesmobsnplenty.screen;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.client.gui.screen.recipebook.AbstractFurnaceRecipeBookScreen;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.Set;

public class AncientFurnaceRecipeBookComponent extends AbstractFurnaceRecipeBookScreen {
  @Override
  protected Set<Item> getAllowedFuels() {
    return Set.of(Items.COAL, Items.CHARCOAL);
  }
}
