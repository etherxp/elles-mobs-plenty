package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.SharkEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SharkModel <T extends SharkEntity> extends SinglePartEntityModel<T> {
  private final ModelPart shark;
  private final ModelPart head;
  private final ModelPart chest;
  private final ModelPart torso;
  private final ModelPart leftFin;
  private final ModelPart rightFin;
  private final ModelPart back;

  public SharkModel(ModelPart root) {
    this.shark = root.getChild("shark");
    this.head = shark.getChild("body").getChild("head");
    this.chest = shark.getChild("body");
    this.torso = shark.getChild("body").getChild("torso").getChild("chest");
    this.leftFin = shark.getChild("body").getChild("torso").getChild("torso_fins").getChild("left_fin");
    this.rightFin = shark.getChild("body").getChild("torso").getChild("torso_fins").getChild("right_fin");
    this.back = shark.getChild("body").getChild("torso").getChild("back");
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData shark = modelPartData.addChild("shark", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 32.0F, 0.0F));

    ModelPartData body = shark.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-0.75F, -14.0F, -9.75F));

    ModelPartData upper_head = head.addChild("upper_head", ModelPartBuilder.create().uv(43, 17).cuboid(-4.9355F, -7.0F, -14.0294F, 10.0F, 6.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, -0.25F));

    ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(39, 0).cuboid(-4.9355F, 0.0F, -12.0294F, 10.0F, 4.0F, 12.0F, new Dilation(0.0F))
            .uv(0, 58).cuboid(-3.9355F, -4.0F, -11.0294F, 8.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, -0.25F));

    ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -12.0F, -9.0F));

    ModelPartData chest = torso.addChild("chest", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -7.0F, -10.0F, 10.0F, 12.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.6855F, 1.0F, 8.9706F));

    ModelPartData torso_fins = torso.addChild("torso_fins", ModelPartBuilder.create(), ModelTransform.pivot(-0.6855F, 3.0F, 6.9706F));

    ModelPartData left_fin = torso_fins.addChild("left_fin", ModelPartBuilder.create().uv(47, 38).cuboid(-13.0F, -2.0F, -4.0F, 13.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -1.75F, -1.0F, 0.0F, 0.0F, -1.5708F));

    ModelPartData right_fin = torso_fins.addChild("right_fin", ModelPartBuilder.create().uv(47, 49).cuboid(-0.0376F, -2.1219F, -3.8523F, 13.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(4.7876F, -1.8781F, -1.1477F, 0.0F, 0.0F, 1.5708F));

    ModelPartData back_fin = torso_fins.addChild("back_fin", ModelPartBuilder.create().uv(58, 60).cuboid(-1.0F, -6.5F, -3.5F, 2.0F, 13.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.5F, 2.5F));

    ModelPartData back = torso.addChild("back", ModelPartBuilder.create(), ModelTransform.pivot(-0.6855F, 0.0F, 17.2206F));

    ModelPartData back_body = back.addChild("back_body", ModelPartBuilder.create().uv(0, 31).cuboid(-3.0F, -5.0F, 0.0F, 6.0F, 9.0F, 17.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, -0.25F));

    ModelPartData back_fins = back.addChild("back_fins", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 11.75F));

    ModelPartData upper_back_fin = back_fins.addChild("upper_back_fin", ModelPartBuilder.create().uv(37, 60).cuboid(-1.0F, -9.5F, -3.0F, 2.0F, 19.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, 4.0F));
    return TexturedModelData.of(modelData, 128, 128);
  }


  @Override
  public void setAngles(SharkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);
    this.setHeadAngles(netHeadYaw, headPitch, ageInTicks);

    this.animateMovement(ModAnimations.shark_swim, limbSwing, limbSwingAmount, 4f, 5f);
    this.updateAnimation(entity.idleAnimationState, ModAnimations.shark_idle, ageInTicks, 1f);
  }

  private void setHeadAngles(float headYaw, float headPitch, float animationProgress) {
    headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
    headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
    this.shark.yaw = headYaw * (float) (Math.PI / 180.0);
    this.shark.pitch = headPitch * (float) (Math.PI / 180.0);
    this.back.yaw = headYaw * (float) (Math.PI / 180.0) / 3;
    this.back.pitch = headPitch * (float) (Math.PI / 180.0) / 3;
    this.head.yaw = headYaw * (float) (Math.PI / 180.0);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
    shark.render(matrices, vertices, light, overlay, color);
  }

  @Override
  public ModelPart getPart() {
    return shark;
  }
}
