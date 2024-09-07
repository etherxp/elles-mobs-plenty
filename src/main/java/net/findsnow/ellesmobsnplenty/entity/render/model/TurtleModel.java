package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.TurtleEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.findsnow.ellesmobsnplenty.entity.render.animations.TurtleAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class TurtleModel<T extends TurtleEntity> extends SinglePartEntityModel<T> {
  private final ModelPart turtle;
  private final ModelPart head;

  public TurtleModel(ModelPart root) {
    this.turtle = root.getChild("turtle");
    this.head = turtle.getChild("body").getChild("waist").getChild("head");
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData turtle = modelPartData.addChild("turtle", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

    ModelPartData body = turtle.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData waist = body.addChild("waist", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData shell = waist.addChild("shell", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.75F, -4.0F, 6.0F, 4.0F, 8.0F, new Dilation(0.0F))
            .uv(0, 13).cuboid(-3.0F, -1.75F, -4.0F, 6.0F, 3.0F, 8.0F, new Dilation(0.3F)), ModelTransform.pivot(0.0F, -3.25F, 0.0F));

    ModelPartData legs = waist.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData front_legs = legs.addChild("front_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData front_leg = front_legs.addChild("front_leg", ModelPartBuilder.create().uv(9, 25).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -2.75F, -3.75F));

    ModelPartData front_right = front_legs.addChild("front_right", ModelPartBuilder.create().uv(0, 25).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -2.75F, -3.75F));

    ModelPartData back_legs = legs.addChild("back_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData back_left = back_legs.addChild("back_left", ModelPartBuilder.create().uv(9, 25).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -2.75F, 3.75F));

    ModelPartData back_right = back_legs.addChild("back_right", ModelPartBuilder.create().uv(0, 25).cuboid(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -2.75F, 3.75F));

    ModelPartData head = waist.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.869F, -4.0927F));

    ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(21, 0).cuboid(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.1F))
            .uv(21, 13).cuboid(-1.0F, -1.0F, -4.25F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.369F, 1.0927F, -0.1745F, 0.0F, 0.0F));

    ModelPartData tail = waist.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.676F, 4.3858F));

    ModelPartData cube_r2 = tail.addChild("cube_r2", ModelPartBuilder.create().uv(18, 25).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.176F, -0.3858F, -0.3927F, 0.0F, 0.0F));
    return TexturedModelData.of(modelData, 64, 64);
  }

  @Override
  public void setAngles(TurtleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);
    this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

    this.animateMovement(TurtleAnimations.turtle_walk, limbSwing, limbSwingAmount, 8f, 100.0f);
    this.updateAnimation(entity.idleAnimationState, TurtleAnimations.turtle_idle, ageInTicks, 1f);
  }

  private void setHeadAngles(TurtleEntity entity, float headYaw, float headPitch, float animationProgress) {
    headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
    headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);
      this.head.yaw = headYaw * ((float) Math.PI / 180);
      this.head.pitch = headPitch * ((float) Math.PI / 180);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
    turtle.render(matrices, vertices, light, overlay, color);
  }

  @Override
  public ModelPart getPart() {
    return turtle;
  }
}
