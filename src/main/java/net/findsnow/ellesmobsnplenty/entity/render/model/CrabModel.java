package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CrabModel<T extends CrabEntity> extends SinglePartEntityModel<T> {
  private final ModelPart crab;

	public CrabModel(ModelPart root) {
    this.crab = root.getChild("crab");
  }
  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData crab = modelPartData.addChild("crab", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

    ModelPartData body = crab.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

    ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.25F, 2.0F));

    ModelPartData torso = head.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -1.0F, 9.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -5.0F));

    ModelPartData eyes = head.addChild("eyes", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -5.0F));

    ModelPartData left_eye = eyes.addChild("left_eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData cube_r1 = left_eye.addChild("cube_r1", ModelPartBuilder.create().uv(4, 0).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

    ModelPartData right_eye = eyes.addChild("right_eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData cube_r2 = right_eye.addChild("cube_r2", ModelPartBuilder.create().uv(4, 3).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -3.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

    ModelPartData nosething = head.addChild("nosething", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -4.0837F, -4.1723F));

    ModelPartData cube_r3 = nosething.addChild("cube_r3", ModelPartBuilder.create().uv(0, 23).cuboid(-1.5F, -1.5F, -1.75F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.3837F, -0.5777F, -0.3927F, 0.0F, 0.0F));

    ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData right_legs = legs.addChild("right_legs", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, -2.5F, 1.5F));

    ModelPartData right_first = right_legs.addChild("right_first", ModelPartBuilder.create(), ModelTransform.pivot(0.1213F, 0.2071F, -1.0F));

    ModelPartData cube_r4 = right_first.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6109F, 1.1036F, 1.0F, 0.0F, 0.0F, -0.7854F));

    ModelPartData right_middle = right_legs.addChild("right_middle", ModelPartBuilder.create(), ModelTransform.pivot(0.1213F, 0.2071F, 1.0F));

    ModelPartData cube_r5 = right_middle.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6109F, 1.1036F, 0.5F, 0.0F, 0.0F, -0.7854F));

    ModelPartData right_last = right_legs.addChild("right_last", ModelPartBuilder.create(), ModelTransform.pivot(0.1213F, 0.2071F, 3.0F));

    ModelPartData cube_r6 = right_last.addChild("cube_r6", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6109F, 1.1036F, 0.0F, 0.0F, 0.0F, -0.7854F));

    ModelPartData left_legs = legs.addChild("left_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData left_first = left_legs.addChild("left_first", ModelPartBuilder.create(), ModelTransform.pivot(-3.4822F, -2.6893F, 0.5F));

    ModelPartData cube_r7 = left_first.addChild("cube_r7", ModelPartBuilder.create().uv(2, 0).cuboid(0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.25F, 1.5F, 1.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData left_middle = left_legs.addChild("left_middle", ModelPartBuilder.create(), ModelTransform.pivot(-3.6287F, -2.8358F, 2.5F));

    ModelPartData cube_r8 = left_middle.addChild("cube_r8", ModelPartBuilder.create().uv(2, 0).cuboid(0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.1036F, 1.6464F, 0.5F, 0.0F, 0.0F, 0.7854F));

    ModelPartData left_last = left_legs.addChild("left_last", ModelPartBuilder.create(), ModelTransform.pivot(-3.6287F, -2.8358F, 4.5F));

    ModelPartData cube_r9 = left_last.addChild("cube_r9", ModelPartBuilder.create().uv(2, 0).cuboid(0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.1036F, 1.6464F, 0.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData claws = body.addChild("claws", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData left_claw = claws.addChild("left_claw", ModelPartBuilder.create(), ModelTransform.of(8.25F, -3.0F, -0.5F, 3.0213F, 1.2147F, 3.0229F));

    ModelPartData left_lower = left_claw.addChild("left_lower", ModelPartBuilder.create(), ModelTransform.pivot(0.0004F, 0.95F, 0.0004F));

    ModelPartData cube_r10 = left_lower.addChild("cube_r10", ModelPartBuilder.create().uv(15, 16).cuboid(2.565F, 0.2459F, -10.2002F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.0828F, -0.2407F, -4.5902F, 0.0F, -1.5708F, 0.0F));

    ModelPartData left_upper = left_claw.addChild("left_upper", ModelPartBuilder.create(), ModelTransform.pivot(1.0004F, 0.85F, 0.0004F));

    ModelPartData cube_r11 = left_upper.addChild("cube_r11", ModelPartBuilder.create().uv(0, 13).cuboid(-2.0F, -3.0F, -7.0F, 4.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.1174F, 0.1052F, -0.0252F, 0.0F, -1.5708F, 0.0F));

    ModelPartData right_claw = claws.addChild("right_claw", ModelPartBuilder.create(), ModelTransform.of(-7.25F, -3.0F, -0.5F, 3.0213F, -1.2147F, -3.0229F));

    ModelPartData right_lower = right_claw.addChild("right_lower", ModelPartBuilder.create(), ModelTransform.pivot(-0.0004F, 0.95F, 0.0004F));

    ModelPartData cube_r12 = right_lower.addChild("cube_r12", ModelPartBuilder.create().uv(15, 16).mirrored().cuboid(-6.565F, 0.2459F, -10.2002F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0828F, -0.2407F, -4.5902F, 0.0F, 1.5708F, 0.0F));

    ModelPartData right_upper = right_claw.addChild("right_upper", ModelPartBuilder.create(), ModelTransform.pivot(-0.0004F, 0.85F, 0.0004F));

    ModelPartData cube_r13 = right_upper.addChild("cube_r13", ModelPartBuilder.create().uv(0, 13).mirrored().cuboid(-6.565F, -0.7541F, -10.2002F, 4.0F, 3.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0828F, -2.1407F, -4.5902F, 0.0F, 1.5708F, 0.0F));
    return TexturedModelData.of(modelData, 64, 64);
  }

  @Override
  public void setAngles(CrabEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);
    this.animateMovement(ModAnimations.crab_walk, limbSwing, limbSwingAmount, 3f, 3f);
    this.updateAnimation(entity.idleAnimationState, ModAnimations.crab_idle, ageInTicks, 1f);
    this.updateAnimation(entity.waveAnimationState, ModAnimations.crab_wave, ageInTicks, 1f);
    this.updateAnimation(entity.snipAnimationState, ModAnimations.crab_snip, ageInTicks, 1f);
    this.updateAnimation(entity.climbAnimationState, ModAnimations.crab_climb, ageInTicks, 1f);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
    crab.render(matrices, vertices, light, overlay, color);
  }

  @Override
  public ModelPart getPart() {
    return crab;
  }
}