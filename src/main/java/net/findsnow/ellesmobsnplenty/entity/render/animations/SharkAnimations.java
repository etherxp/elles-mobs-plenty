package net.findsnow.ellesmobsnplenty.entity.render.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class SharkAnimations {
        public static final Animation shark_attack = Animation.Builder.create(1.0F).looping()
                .addBoneAnimation("shark", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -8.8F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(2.3134F, 4.4339F, 27.5896F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("upper_head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("jaw", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2083F, AnimationHelper.createRotationalVector(55.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(50.85F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("torso", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -6.53F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(-1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, -25.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("back_fins", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation shark_swim = Animation.Builder.create(2.0F).looping()
                .addBoneAnimation("shark", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 23.44F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -23.44F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("back_fins", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 19.61F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation shark_crawl = Animation.Builder.create(2.0F).looping()
                .addBoneAnimation("shark", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 90.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 7.48F, 90.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -20.0F, 90.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 90.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.5F, -2.75F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -90.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -7.96F, -90.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 20.0F, -90.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -90.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.25F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("back_fins", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -0.39F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation shark_crawl_idle = Animation.Builder.create(2.0F).looping()
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 90.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.5F, -2.75F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -90.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.25F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("back_fins", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, -0.39F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 2.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation shark_idle = Animation.Builder.create(3.0F).looping()
                .addBoneAnimation("shark", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 22.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("left_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -22.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("right_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -1.0F), Transformation.Interpolations.LINEAR)
                ))
                .addBoneAnimation("back_fins", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 19.61F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 12.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .build();

        public static final Animation shark_swim_fast = Animation.Builder.create(1.5F).looping()
                .addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 0.25F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.75F, 0.0F, 0.25F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(-0.5F, 0.0F, 0.25F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("torso", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -5.0F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("back", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, -22.5F, 0.0F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 22.5F, 0.0F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("upper_back_fin", new Transformation(Transformation.Targets.ROTATE,
                        new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 7.5F), Transformation.Interpolations.CUBIC),
                        new Keyframe(0.75F, AnimationHelper.createRotationalVector(-0.6435F, -10.1682F, -7.3159F), Transformation.Interpolations.CUBIC),
                        new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 7.5F, 7.5F), Transformation.Interpolations.CUBIC)
                ))
                .addBoneAnimation("upper_back_fin", new Transformation(Transformation.Targets.TRANSLATE,
                        new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR),
                        new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
                ))
                .build();
}
