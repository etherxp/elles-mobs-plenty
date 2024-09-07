package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.RabbitReplacementEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.findsnow.ellesmobsnplenty.entity.render.animations.RabbitAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.util.math.MathHelper;

public class RabbitModel <T extends RabbitReplacementEntity> extends SinglePartEntityModel<T> {
  private final ModelPart bunny;
  private final ModelPart head;
  private final ModelPart leftFrontLeg;
  private final ModelPart rightFrontLeg;
  private final ModelPart leftBackLeg;
  private final ModelPart rightBackLeg;
  private final ModelPart rightEar;
  private final ModelPart leftEar;
  private final ModelPart nose;
  private final ModelPart tail;
  private float jumpProgress;


  public RabbitModel(ModelPart root) {
    this.bunny = root.getChild("bunny");
    this.head = bunny.getChild("waist").getChild("head");
    this.tail = bunny.getChild("waist").getChild("body").getChild("tail");
    this.leftFrontLeg = bunny.getChild("waist").getChild("legs").getChild("front_left");
    this.rightFrontLeg = bunny.getChild("waist").getChild("legs").getChild("front_right");
    this.leftBackLeg = bunny.getChild("waist").getChild("legs").getChild("back_left");
    this.rightBackLeg = bunny.getChild("waist").getChild("legs").getChild("back_right");
    this.rightEar = bunny.getChild("waist").getChild("head").getChild("ears").getChild("right_ear");
    this.leftEar = bunny.getChild("waist").getChild("head").getChild("ears").getChild("left_ear");
    this.nose = bunny.getChild("waist").getChild("head").getChild("nose");
  }
  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData bunny = modelPartData.addChild("bunny", ModelPartBuilder.create(), ModelTransform.pivot(-4.5F, 24.0F, -1.0F));

    ModelPartData waist = bunny.addChild("waist", ModelPartBuilder.create(), ModelTransform.pivot(4.5F, 0.0F, 1.0F));

    ModelPartData body = waist.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.0F, 4.0F));

    ModelPartData chest = body.addChild("chest", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -8.0F, 6.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

    ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(14, 13).cuboid(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

    ModelPartData legs = waist.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData front_left = legs.addChild("front_left", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.5F, -2.0F, -2.5F));

    ModelPartData front_right = legs.addChild("front_right", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -2.0F, -2.5F));

    ModelPartData back_left = legs.addChild("back_left", ModelPartBuilder.create().uv(14, 17).cuboid(-1.5F, -1.0F, -3.5F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -1.0F, 4.0F));

    ModelPartData back_right = legs.addChild("back_right", ModelPartBuilder.create().uv(14, 17).cuboid(-1.5F, -1.0F, -3.5F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -1.0F, 4.0F));

    ModelPartData head = waist.addChild("head", ModelPartBuilder.create().uv(0, 13).cuboid(-2.5F, -2.5F, -3.75F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.5F, -2.25F));

    ModelPartData ears = head.addChild("ears", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.5F, 3.25F));

    ModelPartData left_ear = ears.addChild("left_ear", ModelPartBuilder.create().uv(20, 0).mirrored().cuboid(-1.0F, -4.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.5F, -10.0F, -3.5F));

    ModelPartData right_ear = ears.addChild("right_ear", ModelPartBuilder.create().uv(20, 0).cuboid(-1.0F, -4.0F, -0.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -10.0F, -3.5F));

    ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(0, 4).cuboid(-1.5F, -1.0F, -0.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -4.25F));
    return TexturedModelData.of(modelData, 32, 32);
  }

  @Override
  public void setAngles(RabbitReplacementEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);
    this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

    float k = ageInTicks - (float)entity.age;
    this.head.pitch = headPitch * (float) (Math.PI / 180.0);
    this.head.yaw = netHeadYaw * (float) (Math.PI / 180.0);
    this.jumpProgress = MathHelper.sin(entity.getJumpProgress(k) * (float) Math.PI);
    this.leftBackLeg.pitch = this.jumpProgress * 70.0F * (float) (Math.PI / 180.0);
    this.rightBackLeg.pitch = this.jumpProgress * 70.0F * (float) (Math.PI / 180.0);
    this.leftFrontLeg.pitch = (this.jumpProgress * -30.0F - 11.0F) * (float) (Math.PI / 180.0);
    this.rightFrontLeg.pitch = (this.jumpProgress * -40.0F - 11.0F) * (float) (Math.PI / 180.0);

    this.updateAnimation(entity.idleAnimationState, RabbitAnimations.rabbit_idle, ageInTicks, 1f);
    this.updateAnimation(entity.sniffingAnimationState, RabbitAnimations.rabbit_sniff, ageInTicks, 1f);
  }

  private void setHeadAngles(RabbitReplacementEntity entity, float headYaw, float headPitch, float animationProgress) {
    headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
    headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);
    this.head.yaw = headYaw * ((float) Math.PI / 180);
    this.head.pitch = headPitch * ((float) Math.PI / 180);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
    bunny.render(matrices, vertices, light, overlay, color);
  }

  public void animateModel(T rabbitEntity, float f, float g, float h) {
    super.animateModel(rabbitEntity, f, g, h);
    this.jumpProgress = MathHelper.sin(rabbitEntity.getJumpProgress(h) * (float) Math.PI);
  }

  @Override
  public ModelPart getPart() {
    return bunny;
  }

  private static RabbitModel.Pose getPose(RabbitReplacementEntity rabbitReplacementEntity) {
    if (rabbitReplacementEntity.sniffingAnimationState.isRunning()) {
      return Pose.SNIFFING;
    }

    return RabbitModel.Pose.STANDING;
  }

  @Environment(value= EnvType.CLIENT)
  public static enum Pose {
    JUMPING,
    STANDING,
    SITTING,
    PARTY,
    SNIFFING;
  }
}
