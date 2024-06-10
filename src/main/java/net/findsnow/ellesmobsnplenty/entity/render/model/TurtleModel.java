package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.TurtleEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class TurtleModel<T extends TurtleEntity> extends SinglePartEntityModel<T> {
  private final ModelPart bone;
  private final ModelPart head;
  public TurtleModel(ModelPart root) {
    this.bone = root.getChild("bone");
    this.head = bone.getChild("body").getChild("head");
  }
  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 5.0F));

    ModelPartData body = bone.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, -4.5F));

    ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.25F, 3.25F));

    ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, 0.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.5F, -3.0F));

    ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(0, 10).cuboid(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

    ModelPartData left_front_leg = bone.addChild("left_front_leg", ModelPartBuilder.create().uv(7, 10).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.75F, -1.0F, -6.75F));

    ModelPartData right_front_leg = bone.addChild("right_front_leg", ModelPartBuilder.create().uv(14, 14).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.75F, -1.0F, -6.75F));

    ModelPartData right_back_leg = bone.addChild("right_back_leg", ModelPartBuilder.create().uv(8, 13).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.75F, -1.0F, -2.25F));

    ModelPartData left_back_leg = bone.addChild("left_back_leg", ModelPartBuilder.create().uv(14, 11).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.75F, -1.0F, -2.25F));
    return TexturedModelData.of(modelData, 32, 32);
  }
  @Override
  public void setAngles(TurtleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);
    this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

    this.animateMovement(ModAnimations.turtle_walk, limbSwing, limbSwingAmount, 8f, 100.0f);
    this.updateAnimation(entity.idleAnimationState, ModAnimations.turtle_idle, ageInTicks, 1f);
    this.updateAnimation(entity.hidingTransitionAnimationState, ModAnimations.turtle_hide, ageInTicks, 1f);
    this.updateAnimation(entity.hidingAnimationState, ModAnimations.turtle_hiding, ageInTicks, 1f);
    this.updateAnimation(entity.checkingAnimationState, ModAnimations.turtle_peek, ageInTicks, 1f);
    this.updateAnimation(entity.revealAnimationState, ModAnimations.turtle_reveal, ageInTicks, 1f);
  }

  private void setHeadAngles(TurtleEntity entity, float headYaw, float headPitch, float animationProgress) {
    headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
    headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);
      this.head.yaw = headYaw * ((float) Math.PI / 180);
      this.head.pitch = headPitch * ((float) Math.PI / 180);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
    bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }

  @Override
  public ModelPart getPart() {
    return bone;
  }
}
