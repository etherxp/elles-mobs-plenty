package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GroveEntity extends HostileEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState movingAnimationState = new AnimationState();
    public final AnimationState inhalingAnimationState = new AnimationState();
    public final AnimationState shootingAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int longJumpingParticleAddCount = 0;
    private int ticksUntilWhirlSound = 0;



    protected GroveEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.DANGER_TRAPDOOR, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 1.0F);
        this.experiencePoints = 10;
    }

    public static DefaultAttributeContainer.Builder createGroveAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.63F)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0);
    }

    private void stopAnimations() {
        this.inhalingAnimationState.stop();
        this.shootingAnimationState.stop();
        this.movingAnimationState.stop();
        this.idleAnimationState.stop();
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        if (this.getWorld().isClient() && POSE.equals(data)) {
            this.stopAnimations();
            EntityPose entityPose = this.getPose();
            switch (entityPose) {
                case SHOOTING:
                    this.shootingAnimationState.startIfNotRunning(this.age);
                    break;
                case INHALING:
                    this.inhalingAnimationState.startIfNotRunning(this.age);
                    break;
                case SLIDING:
                    this.movingAnimationState.startIfNotRunning(this.age);
            }
        }
        super.onTrackedDataSet(data);
    }

    @Override
    public void tick() {
        EntityPose entityPose = this.getPose();
        switch (entityPose) {
            case SHOOTING:
            case INHALING:
            case STANDING:
                this.resetLongJumpingParticlesAddCount().addBlockParticles(1 + this.getRandom().nextInt(1));
                break;
            case SLIDING:
                this.addBlockParticles(20);
                break;
        }
        if (entityPose != EntityPose.SLIDING && this.movingAnimationState.isRunning()) {
            idleAnimationState.start(this.age);
            this.movingAnimationState.stop();
        }
        super.tick();
    }

    public GroveEntity resetLongJumpingParticlesAddCount() {
        this.longJumpingParticleAddCount = 0;
        return this;
    }

    public void addLongJumpingParticles() {
        if (++this.longJumpingParticleAddCount <= 5) {
            BlockState blockState = !this.getBlockStateAtPos().isAir() ? this.getBlockStateAtPos() : this.getSteppingBlockState();
            Vec3d vec3d = this.getVelocity();
            Vec3d vec3d2 = this.getPos().add(vec3d).add(0.0, 0.1F, 0.0);

            for(int i = 0; i < 3; ++i) {
                this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), vec3d2.x, vec3d2.y, vec3d2.z, 0.0, 0.0, 0.0);
            }
        }
    }

    public void addBlockParticles(int count) {
        if (!this.hasVehicle()) {
            Vec3d vec3d = this.getBoundingBox().getCenter();
            Vec3d vec3d2 = new Vec3d(vec3d.x, this.getPos().y, vec3d.z);
            BlockState blockState = !this.getBlockStateAtPos().isAir() ? this.getBlockStateAtPos() : this.getSteppingBlockState();
            if (blockState.getRenderType() != BlockRenderType.INVISIBLE) {
                for(int i = 0; i < count; ++i) {
                    this.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), vec3d2.x, vec3d2.y, vec3d2.z, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    @Override
    public boolean canTarget(EntityType<?> type) {
        return type == EntityType.PLAYER || type == EntityType.IRON_GOLEM;
    }

    @Override
    public int getMaxHeadRotation() {
        return 30;
    }

    @Override
    public int getMaxLookYawChange() {
        return 25;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource damageSource) {
        return damageSource.getAttacker() instanceof GroveEntity || super.isInvulnerableTo(damageSource);
    }

    @Override
    public double getSwimHeight() {
        return this.getStandingEyeHeight();
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        if (fallDistance > 3.0F) {
            this.playSound(SoundEvents.ENTITY_BREEZE_LAND, 1.0f, 1.0f);
        }
        return super.handleFallDamage(fallDistance, damageMultiplier, damageSource);
    }

    @Override
    protected MoveEffect getMoveEffect() {
        return MoveEffect.EVENTS;
    }

    @Nullable
    @Override
    public LivingEntity getTarget() {
        return this.getTargetInBrain();
    }

    @Override
    public Brain<?> getBrain() {
        return super.getBrain();
    }

    public Optional<LivingEntity> getHurtBy() {
        return this.getBrain()
                .getOptionalRegisteredMemory(MemoryModuleType.HURT_BY)
                .map(DamageSource::getAttacker)
                .filter(attacker -> attacker instanceof LivingEntity)
                .map(livingAttacker -> (LivingEntity)livingAttacker);
    }
}
