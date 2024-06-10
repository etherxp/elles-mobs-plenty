package net.findsnow.ellesmobsnplenty.entity.render.renderer;

import com.google.common.collect.Maps;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.CrabModel;
import net.findsnow.ellesmobsnplenty.entity.variant.CrabVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class CrabRenderer extends MobEntityRenderer<CrabEntity, CrabModel<CrabEntity>> {
  private static final Map<CrabVariant, Identifier> LOCATION_BY_VARIANT =
          Util.make(Maps.newEnumMap(CrabVariant.class), map -> {
            map.put(CrabVariant.DEFAULT,
                    new Identifier(EllesMobsNPlenty.MOD_ID, "textures/entity/crab/crab_texture.png"));
            map.put(CrabVariant.GREEN,
                    new Identifier(EllesMobsNPlenty.MOD_ID, "textures/entity/crab/crab_texture_green.png"));
            map.put(CrabVariant.BLUE,
                    new Identifier(EllesMobsNPlenty.MOD_ID, "textures/entity/crab/crab_texture_blue.png"));
          });

  public CrabRenderer(EntityRendererFactory.Context ctx) {
    super(ctx, new CrabModel<>(ctx.getPart(ModModelLayers.CRAB)), 0.4f);
  }

  @Override
  public Identifier getTexture(CrabEntity entity) {
    return LOCATION_BY_VARIANT.get(entity.getVariant());
  }

  @Override
  public void render(CrabEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    if(livingEntity.isBaby()) {
      matrixStack.scale(0.5f, 0.5f, 0.5f);
    } else {
      matrixStack.scale(1.0f, 1.0f, 1.0f);
    }
    super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
  }
}
