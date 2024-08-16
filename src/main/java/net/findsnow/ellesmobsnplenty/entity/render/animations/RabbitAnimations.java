package net.findsnow.ellesmobsnplenty.entity.render.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class RabbitAnimations {
        public static final Animation rabbit_walk = Animation.Builder.create(0.5F).looping()
                .addBoneAnimation("waist", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 7.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("chest", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("front_left", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("front_left", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 2.77F, -0.61F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createTranslationalVector(0.0F, 2.5F, -1.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("front_right", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-67.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("front_right", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 2.75F, -0.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 2.5F, -1.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_left", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(132.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_left", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, -1.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_right", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(132.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_right", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, -1.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("nose", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

  public static final Animation rabbit_idle = Animation.Builder.create(2.0F).looping()
          .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-0.94F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .build();

  public static final Animation rabbit_laydown = Animation.Builder.create(1.0F)
          .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createRotationalVector(3.6932F, 0.6507F, -9.979F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(3.718F, -0.4891F, 7.4841F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -0.82F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_left", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.1667F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_left", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -0.75F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -2.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_right", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.8333F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_right", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -0.75F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -2.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.3333F, AnimationHelper.createRotationalVector(15.1513F, 4.0061F, -14.467F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5833F, AnimationHelper.createRotationalVector(25.0162F, 2.1188F, -4.5299F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(26.4952F, -3.297F, 6.8313F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, -0.94F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-11.0118F, -1.4405F, -7.3611F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createRotationalVector(-13.4F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(9.21F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.2588F, -0.2293F, 2.4895F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(2.27F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-11.0118F, -1.4405F, -7.3611F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createRotationalVector(-13.4F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(9.21F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.625F, AnimationHelper.createRotationalVector(5.2588F, -0.2293F, 2.4895F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(2.27F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("nose", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.25F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .build();

  public static final Animation rabbit_sleep = Animation.Builder.create(3.0F).looping()
          .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_left", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_left", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -2.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_right", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_right", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -2.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(3.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -2.25F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.5F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(3.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(3.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("nose", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.25F), Transformation.Interpolations.CUBIC),
                  new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .build();

  public static final Animation rabbit_stand = Animation.Builder.create(1.0F)
          .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-2.5024F, -0.109F, 9.7975F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -4.72F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("body", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_left", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0833F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_left", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -2.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, -0.5F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.42F, -0.22F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_right", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.2917F, AnimationHelper.createRotationalVector(90.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("front_right", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, -2.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, -0.5F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.42F, -0.22F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(27.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createRotationalVector(21.8385F, -1.864F, 4.6404F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(15.0092F, 0.4912F, -3.6359F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(19.5778F, 0.3928F, -2.3352F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createRotationalVector(28.4F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.7772F, -0.4895F, -9.9881F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(-3.3006F, -0.565F, -10.6101F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("left_ear", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.ROTATE,
                  new Keyframe(0.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.25F, AnimationHelper.createRotationalVector(28.4F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5F, AnimationHelper.createRotationalVector(-2.7959F, 0.3679F, 7.491F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.75F, AnimationHelper.createRotationalVector(-3.2949F, 0.5973F, 9.3565F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("right_ear", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .addBoneAnimation("nose", new Transformation(Transformation.Targets.TRANSLATE,
                  new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.25F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.25F), Transformation.Interpolations.CUBIC),
                  new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
          ))
          .build();
}
