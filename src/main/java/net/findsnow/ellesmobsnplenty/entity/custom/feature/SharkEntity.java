package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.AmphibiousPathNodeMaker;
import net.minecraft.entity.ai.pathing.AmphibiousSwimNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SharkEntity extends WaterCreatureEntity implements Angerable {
  public final AnimationState swimAnimationState = new AnimationState();
  private int swimAnimationTimeout = 0;
  public final AnimationState idleAnimationState = new AnimationState();
  private int idleAnimationTimeout = 0;

  public SharkEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
    super(entityType, world);
    this.moveControl = new AquaticMoveControl(this, 75, 6, 0.04f, 0.1f, true);
    this.lookControl = new YawAdjustingLookControl(this, 9);
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new MoveIntoWaterGoal(this));
    this.goalSelector.add(1, new SwimAroundGoal(this, 3.0, 10));
    this.goalSelector.add(2, new RevengeGoal(this));
    this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
  }

  public static DefaultAttributeContainer.Builder createSharkAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.2F);
  }

  @Override
  protected EntityNavigation createNavigation(World world) {
    return new AmphibiousSwimNavigation(this, world);
  }

  @Override
  public boolean canBeLeashed() {
    return true;
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
  public void tick() {
    super.tick();
    if (this.getWorld().isClient()) {
      this.setupAnimationStates();
    }
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
  public int getAngerTime() {
    return 0;
  }

  @Override
  public void setAngerTime(int angerTime) {

  }

  @Nullable
  @Override
  public UUID getAngryAt() {
    return null;
  }

  @Override
  public void setAngryAt(@Nullable UUID angryAt) {

  }

  @Override
  public void chooseRandomAngerTime() {

  }

  @Override
  protected void playSwimSound() {
    this.playSound(SoundEvents.ENTITY_DOLPHIN_SWIM);
  }

  @Override
  protected float getSoundVolume() {
    return 0.4F;
  }
}
