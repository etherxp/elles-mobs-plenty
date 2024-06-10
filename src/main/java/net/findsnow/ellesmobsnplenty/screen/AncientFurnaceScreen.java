package net.findsnow.ellesmobsnplenty.screen;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.AbstractFurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AncientFurnaceScreen extends AbstractFurnaceScreen<AncientFurnaceScreenHandler> {
  private static final Identifier TEXTURE = new Identifier(EllesMobsNPlenty.MOD_ID, "textures/gui/ancient_furnace.png");


  public AncientFurnaceScreen(AncientFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, new AncientFurnaceRecipeBookComponent(), inventory, title, TEXTURE);
  }
}
