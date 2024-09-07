package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.AmphibiousSwimNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class ShrimpEntity extends WaterCreatureEntity {

  public final AnimationState idleAnimationState = new AnimationState();
  private int idleAnimationTimeout = 0;


  public ShrimpEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
    super(entityType, world);
    this.moveControl = new AquaticMoveControl(this, 25, 5, 0.02f, 0.1f, true);
    this.lookControl = new YawAdjustingLookControl(this, 5);
  }

  public static DefaultAttributeContainer.Builder createShrimpAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0F)
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 3);
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new MoveIntoWaterGoal(this));
    this.goalSelector.add(1, new SwimAroundGoal(this, 2.0, 10));
    this.goalSelector.add(2, new LookAroundGoal(this)); // Changed priority to 2
    this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
    this.goalSelector.add(4, new FleeEntityGoal<>(this, SharkEntity.class, 9.0F, 1.0F, 1.0F)); // Changed priority to 4
  }

  @Override
  public void tick() {
    super.tick();
    if (this.getWorld().isClient()) {
      this.setupAnimationStates();
    }
  }

  @Override
  protected EntityNavigation createNavigation(World world) {
    return new SwimNavigation(this, world);
  }

  private void setupAnimationStates() {
    if (this.idleAnimationTimeout <= 0) {
      this.idleAnimationTimeout = this.random.nextInt(40) + 80;
      this.idleAnimationState.start(this.age);
    } else {
      --this.idleAnimationTimeout;
    }
  }

  @Override
  public int getMaxLookYawChange() {
    return 1;
  }

  @Override
  public int getMaxHeadRotation() {
    return 1;
  }

  @Override
  public boolean isPushedByFluids() {
    return false;
  }

  @Override
  protected SoundEvent getSwimSound() {
    return SoundEvents.ENTITY_TURTLE_SWIM;
  }

  @Override
  public float getHeadYaw() {
    return super.getHeadYaw();
  }

  @Override
  protected void tickWaterBreathingAir(int air) {
    if (this.isAlive() && !this.isInsideWaterOrBubbleColumn()) {
      this.setAir(-1);
      if (this.getAir() == -20) {
        this.setAir(0);
        this.damage(this.getDamageSources().drown(), 2.0F);
      }
    } else {
      this.setAir(20 * 60 * 4);
    }
  }

  @Override
  protected void playSwimSound() {
    this.playSound(SoundEvents.ENTITY_TURTLE_SWIM);
  }

  @Nullable
  @Override
  protected SoundEvent getHurtSound(DamageSource source) {
    return SoundEvents.ENTITY_COD_HURT;
  }

  @Override
  protected float getSoundVolume() {
    return 0.4F;
  }
}
