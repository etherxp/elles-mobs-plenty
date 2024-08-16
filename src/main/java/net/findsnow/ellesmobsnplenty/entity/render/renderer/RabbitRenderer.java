package net.findsnow.ellesmobsnplenty.entity.render.renderer;

import com.google.common.collect.Maps;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.RabbitReplacementEntity;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.RabbitModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class RabbitRenderer extends MobEntityRenderer<RabbitReplacementEntity, RabbitModel<RabbitReplacementEntity>> {
  private static final Identifier TOAST = Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/toast.png");

  private static final Map<RabbitReplacementEntity.RabbitType, Identifier> LOCATION_BY_VARIANT =
          Util.make(Maps.newEnumMap(RabbitReplacementEntity.RabbitType.class), map -> {
            map.put(RabbitReplacementEntity.RabbitType.BROWN, Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/brown.png"));
            map.put(RabbitReplacementEntity.RabbitType.WHITE, Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/white.png"));
            map.put(RabbitReplacementEntity.RabbitType.BLACK, Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/black.png"));
            map.put(RabbitReplacementEntity.RabbitType.WHITE_SPLOTCHED, Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/white_splotched.png"));
            map.put(RabbitReplacementEntity.RabbitType.GOLD, Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/gold.png"));
            map.put(RabbitReplacementEntity.RabbitType.SALT, Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/salt.png"));
            map.put(RabbitReplacementEntity.RabbitType.EVIL, Identifier.of(EllesMobsNPlenty.MOD_ID, "textures/entity/rabbit/caerbannog.png"));
          });

  public RabbitRenderer(EntityRendererFactory.Context context) {
    super(context, new RabbitModel<>(context.getPart(ModModelLayers.RABBIT)), 0.4f);
  }

  @Override
  public void render(RabbitReplacementEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    if(livingEntity.isBaby()) {
      matrixStack.scale(0.5f, 0.5f, 0.5f);
    } else {
      matrixStack.scale(1.0f, 1.0f, 1.0f);
    }
    super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
  }

  @Override
  public Identifier getTexture(RabbitReplacementEntity entity) {
    String string = Formatting.strip(entity.getName().getString());
    if ("Toast".equals(string)) {
      return TOAST;
    } else {
      return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
  }
}