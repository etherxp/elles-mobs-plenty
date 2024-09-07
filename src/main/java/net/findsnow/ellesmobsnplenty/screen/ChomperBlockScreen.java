package net.findsnow.ellesmobsnplenty.screen;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ChomperBlockScreen extends HandledScreen<ChomperBlockScreenHandler> {
  private static final Identifier ERROR_TEXTURE = Identifier.ofVanilla("container/grindstone/error");
  private static final Identifier TEXTURE = Identifier.of(EllesMobsNPlenty.MOD_ID,"textures/gui/chomper.png");


  public ChomperBlockScreen(ChomperBlockScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }


  @Override
  protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
    int i = (this.width - this.backgroundWidth) / 2;
    int j = (this.height - this.backgroundHeight) / 2;
    context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
  }

  @Override
  public void render(DrawContext context, int mouseX, int mouseY, float delta) {
    renderBackground(context, mouseX, mouseY, delta);
    super.render(context, mouseX, mouseY, delta);
    this.drawMouseoverTooltip(context, mouseX, mouseY);
  }
}
