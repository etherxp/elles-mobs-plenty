package net.findsnow.ellesmobsnplenty.entity.render.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class TurtleAnimations {
        public static final Animation turtle_walk = Animation.Builder.create(2.5F).looping()
                .addBoneAnimation("waist", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(1.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("waist", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("shell", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(1.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("shell", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("front_leg", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-24.1487F, 20.7048F, -9.0072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0417F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-24.1487F, 20.7048F, -9.0072F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("front_leg", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.75F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -0.04F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("front_right", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-24.1487F, -20.7048F, 9.0072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-1.353F, -22.4944F, 0.5177F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("front_right", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.75F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -0.04F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.17F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.75F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_left", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(-24.1487F, -20.7048F, 9.0072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-1.353F, -22.4944F, 0.5177F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_left", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.75F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -0.04F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.17F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.75F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_right", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(-24.1487F, 20.7048F, -9.0072F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0417F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(-24.1487F, 20.7048F, -9.0072F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back_right", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.75F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.2917F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -0.04F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -0.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createRotationalVector(1.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(1.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createRotationalVector(1.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("tail", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.7917F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation turtle_idle = Animation.Builder.create(2.0F).looping()
                .addBoneAnimation("shell", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();
}
