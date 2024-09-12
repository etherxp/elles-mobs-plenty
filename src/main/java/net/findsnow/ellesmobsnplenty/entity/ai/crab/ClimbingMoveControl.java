package net.findsnow.ellesmobsnplenty.entity.ai.crab;

import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

public class ClimbingMoveControl extends MoveControl {
    private static final float MIN_ANGLE_DIFFERENCE = 10.0f;
    private static final float MAX_ANGLE_DIFFERENCE = 60.0f;
    private final int pitchChange;
    private final int yawChange;
    private final float speedOnWall;
    private final float speedOnLand;
    private final boolean climbing;

    public ClimbingMoveControl(MobEntity entity, int pitchChange, int yawChange, float speedOnWall, float speedOnLand, boolean climbing) {
        super(entity);
        this.pitchChange = pitchChange;
        this.yawChange = yawChange;
        this.speedOnWall = speedOnWall;
        this.speedOnLand = speedOnLand;
        this.climbing = climbing;
    }

    @Override
    public void tick() {
        if (this.climbing && this.entity.isClimbing()) {
            double climbVelocity = MathHelper.lerp(0.1, this.entity.getVelocity().y, 0.05);
            this.entity.setVelocity(this.entity.getVelocity().add(0.0, climbVelocity, 0.0));
        }

        if (this.state != MoveControl.State.MOVE_TO || this.entity.getNavigation().isIdle()) {
            this.entity.setMovementSpeed(0.0f);
            this.entity.setSidewaysSpeed(0.0f);
            this.entity.setUpwardSpeed(0.0f);
            this.entity.setForwardSpeed(0.0f);
            return;
        }

        double d = this.targetX - this.entity.getX();
        double e = this.targetY - this.entity.getY();
        double f = this.targetZ - this.entity.getZ();
        double distanceSquared = d * d + e * e + f * f;

        if (distanceSquared < 2.5E-7) {
            this.entity.setForwardSpeed(0.0f);
            return;
        }

        float targetYaw = (float) (MathHelper.atan2(f, d) * (180.0 / Math.PI)) - 90.0f;
        this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), targetYaw, this.yawChange));
        this.entity.bodyYaw = this.entity.getYaw();
        this.entity.headYaw = this.entity.getYaw();

        float movementSpeed = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));

        if (this.entity.isTouchingWater()) {
            this.entity.setMovementSpeed(movementSpeed * this.speedOnWall);

            double horizontalDistance = Math.sqrt(d * d + f * f);
            if (Math.abs(e) > 1.0E-5 || Math.abs(horizontalDistance) > 1.0E-5) {
                float targetPitch = -((float) (MathHelper.atan2(e, horizontalDistance) * (180.0 / Math.PI)));
                targetPitch = MathHelper.clamp(this.wrapDegrees(targetPitch, this.entity.getPitch(), this.pitchChange), -this.pitchChange, this.pitchChange);
                this.entity.setPitch(targetPitch);
            }

            float pitchCosine = MathHelper.cos(this.entity.getPitch() * ((float) Math.PI / 180));
            float pitchSine = MathHelper.sin(this.entity.getPitch() * ((float) Math.PI / 180));
            this.entity.forwardSpeed = pitchCosine * movementSpeed;
            this.entity.upwardSpeed = -pitchSine * movementSpeed;
        } else {
            float yawDifference = Math.abs(MathHelper.wrapDegrees(this.entity.getYaw() - targetYaw));
            float speedModifier = getSpeedModifier(yawDifference);
            this.entity.setMovementSpeed(movementSpeed * this.speedOnLand * speedModifier);
        }
    }

    private static float getSpeedModifier(float yawDifference) {
        return 1.0f - MathHelper.clamp((yawDifference - MIN_ANGLE_DIFFERENCE) / MAX_ANGLE_DIFFERENCE, 0.0f, 1.0f);
    }
}
