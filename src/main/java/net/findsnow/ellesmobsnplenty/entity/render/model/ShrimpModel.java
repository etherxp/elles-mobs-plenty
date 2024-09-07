package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.SharkEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.ShrimpEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.SharkAnimations;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ShrimpAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ShrimpModel <T extends ShrimpEntity> extends SinglePartEntityModel<T> {
  private final ModelPart shrimp;
  private final ModelPart head;
  private final ModelPart waist;
  private final ModelPart tail;
  private final ModelPart body;


  public ShrimpModel(ModelPart root) {
    this.shrimp = root.getChild("shrimp");
    this.body = shrimp.getChild("body");
    this.head = shrimp.getChild("body").getChild("head");
    this.waist = shrimp.getChild("body").getChild("waist");
    this.tail = shrimp.getChild("body").getChild("waist").getChild("tail");
  }




  @Override
  public ModelPart getPart() {
    return shrimp;
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData shrimp = modelPartData.addChild("shrimp", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 22.0F, -1.0F));

    ModelPartData body = shrimp.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, -3.0F));

    ModelPartData face = head.addChild("face", ModelPartBuilder.create().uv(13, 17).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
            .uv(25, 10).cuboid(0.75F, -4.5F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
            .uv(15, 0).cuboid(-2.75F, -4.5F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.5F, 0.0F));

    ModelPartData whiskers = head.addChild("whiskers", ModelPartBuilder.create().uv(21, 0).cuboid(1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F))
            .uv(0, 21).cuboid(-2.0F, -4.0F, -1.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.5F, -4.0F));

    ModelPartData waist = body.addChild("waist", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, -3.0F));

    ModelPartData shell = waist.addChild("shell", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.5F, -3.0F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

    ModelPartData legs = shell.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 2.5F, 1.0F));

    ModelPartData back_left = legs.addChild("back_left", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 0.0F, 1.0F));

    ModelPartData cube_r1 = back_left.addChild("cube_r1", ModelPartBuilder.create().uv(24, 25).cuboid(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

    ModelPartData back_right = legs.addChild("back_right", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 0.0F, 1.0F));

    ModelPartData cube_r2 = back_right.addChild("cube_r2", ModelPartBuilder.create().uv(24, 25).cuboid(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

    ModelPartData middle_left = legs.addChild("middle_left", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 0.0F, -1.0F));

    ModelPartData cube_r3 = middle_left.addChild("cube_r3", ModelPartBuilder.create().uv(24, 25).cuboid(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

    ModelPartData middle_right = legs.addChild("middle_right", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 0.0F, -1.0F));

    ModelPartData cube_r4 = middle_right.addChild("cube_r4", ModelPartBuilder.create().uv(24, 25).cuboid(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

    ModelPartData front_left = legs.addChild("front_left", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 0.0F, -3.0F));

    ModelPartData cube_r5 = front_left.addChild("cube_r5", ModelPartBuilder.create().uv(24, 25).cuboid(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

    ModelPartData front_right = legs.addChild("front_right", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 0.0F, -3.0F));

    ModelPartData cube_r6 = front_right.addChild("cube_r6", ModelPartBuilder.create().uv(24, 25).cuboid(-2.0F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

    ModelPartData tail = waist.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 6.0F));

    ModelPartData tail_fin = tail.addChild("tail_fin", ModelPartBuilder.create().uv(11, 11).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.5F, 4.0F));

    ModelPartData tail_back = tail.addChild("tail_back", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F))
            .uv(13, 25).cuboid(-1.0F, 1.5F, 3.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
    return TexturedModelData.of(modelData, 64, 64);
  }

  @Override
  public void setAngles(ShrimpEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);

    if (entity.isInsideWaterOrBubbleColumn()) {
      this.setBodyAngles(headYaw, headPitch, animationProgress);
      this.animateMovement(ShrimpAnimations.shrimp_swim, limbAngle, limbDistance, 5f, 7f);
      this.updateAnimation(entity.idleAnimationState, ShrimpAnimations.shrimp_idle_underwater, animationProgress, 1f);
    } else {
      this.updateAnimation(entity.idleAnimationState,  ShrimpAnimations.shrimp_idle_underwater, animationProgress, 1f);
      this.animateMovement(ShrimpAnimations.shrimp_swim, limbAngle, limbDistance, 3f, 4f);
    }
  }

  private void setBodyAngles(float headYaw, float headPitch, float animationProgress) {
    headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
    headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
    this.body.yaw = headYaw * (float) (Math.PI / 180.0);
    this.body.pitch = headPitch * (float) (Math.PI / 180.0);
    this.waist.yaw = headYaw * (float) (Math.PI / 180.0);
    this.waist.pitch = headPitch * (float) (Math.PI / 180.0);
    this.tail.yaw = headYaw * (float) (Math.PI / 180.0);
    this.tail.pitch = headYaw * (float) (Math.PI / 180.0);
    this.head.yaw = headYaw * (float) (Math.PI / 180.0);
    this.head.pitch = headPitch * (float) (Math.PI / 180.0);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
    shrimp.render(matrices, vertices, light, overlay, color);
  }
}
