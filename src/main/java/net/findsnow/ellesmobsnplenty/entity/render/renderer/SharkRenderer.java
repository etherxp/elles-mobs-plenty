package net.findsnow.ellesmobsnplenty.entity.render.renderer;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.SharkEntity;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.CrabModel;
import net.findsnow.ellesmobsnplenty.entity.render.model.SharkModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SharkRenderer extends MobEntityRenderer<SharkEntity, SharkModel<SharkEntity>> {
  private static final Identifier TEXTURE = Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/shark/texturenew.png");


  public SharkRenderer(EntityRendererFactory.Context ctx) {
    super(ctx, new SharkModel<>(ctx.getPart(ModModelLayers.SHARK)), 0.8f);
  }

  @Override
  public Identifier getTexture(SharkEntity entity) {
    return TEXTURE;
  }

  @Override
  public void render(SharkEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    if(livingEntity.isBaby()) {
      matrixStack.scale(0.5f, 0.5f, 0.5f);
    } else {
      matrixStack.scale(1.0f, 1.0f, 1.0f);
    }
    super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
  }
}