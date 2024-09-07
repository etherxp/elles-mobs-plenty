package net.findsnow.ellesmobsnplenty.entity.render.renderer;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.SharkEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.ShrimpEntity;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.SharkModel;
import net.findsnow.ellesmobsnplenty.entity.render.model.ShrimpModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ShrimpRenderer extends MobEntityRenderer<ShrimpEntity, ShrimpModel<ShrimpEntity>> {
  private static final Identifier TEXTURE = Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/shrimp/shrimp_texture.png");


  public ShrimpRenderer(EntityRendererFactory.Context ctx) {
    super(ctx, new ShrimpModel<>(ctx.getPart(ModModelLayers.SHRIMP)), 0.8f);
  }

  @Override
  public Identifier getTexture(ShrimpEntity entity) {
    return TEXTURE;
  }

  @Override
  public void render(ShrimpEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    if (livingEntity.isBaby()) {
      matrixStack.scale(0.5f, 0.5f, 0.5f);
    } else {
      matrixStack.scale(1.0f, 1.0f, 1.0f);
    }
    super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
  }
}
