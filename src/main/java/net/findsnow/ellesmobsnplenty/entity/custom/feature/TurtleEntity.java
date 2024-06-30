package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TurtleEntity extends AnimalEntity implements Tameable {
  public final AnimationState hidingTransitionAnimationState = new AnimationState();
  public final AnimationState hidingAnimationState = new AnimationState();
  public final AnimationState checkingAnimationState = new AnimationState();
  public final AnimationState revealAnimationState = new AnimationState();
  public final AnimationState idleAnimationState = new AnimationState();
  private final long currentStateTicks = 0L;
  private int idleAnimationTimeout = 0;
  private int hideAnimationTimeout = 0;
  private int checkingAnimationTimeout = 0;

  public TurtleEntity(EntityType<? extends AnimalEntity> entityType, World world) {
    super(entityType, world);
    this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
  }

  @Override
  public boolean isBreedingItem(ItemStack stack) {
    return false;
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new SwimGoal(this));
    this.goalSelector.add(1, new EscapeDangerGoal(this, 0.3));
    this.goalSelector.add(3, new FollowParentGoal(this, 0.3));
    this.goalSelector.add(4, new WanderAroundGoal(this, 0.3));
    this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F));
    this.goalSelector.add(6, new TemptGoal(this, 0.3, Ingredient.ofItems(Items.CARROT), false));
    this.goalSelector.add(7, new LookAroundGoal(this));
    this.goalSelector.add(8, new AnimalMateGoal(this, 0.3));
  }

  @Nullable
  @Override
  public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
    return null;
  }

  public static DefaultAttributeContainer.Builder createTurtleAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
  }

  @Override
  public void tick() {
    super.tick();
    if (this.getWorld().isClient()) {
      this.setupAnimationStates();
    }
  }

  private void setupAnimationStates() {
    boolean shouldHide = this.shouldHideFromPlayer();
    if (shouldHide) {
      if (!this.hidingAnimationState.isRunning()) {
        this.hidingAnimationState.start(this.age);
        this.getNavigation().stop();
        this.hideAnimationTimeout = this.random.nextInt(40) + 80; // Reset hide timeout
      }
      if (this.hideAnimationTimeout > 0) {
        this.hideAnimationTimeout--;
        if (this.hideAnimationTimeout == 0) {
          this.hidingAnimationState.stop();
          this.checkingAnimationState.start(this.age);
          this.checkingAnimationTimeout = this.random.nextInt(40) + 80; // Set checking timeout
        }
      }
    } else {
      if (this.hidingAnimationState.isRunning()) {
        this.hidingAnimationState.stop();
        this.revealAnimationState.start(this.age);
      }
      if (this.checkingAnimationState.isRunning()) {
        if (this.checkingAnimationTimeout > 0) {
          this.checkingAnimationTimeout--;
          if (this.checkingAnimationTimeout == 0) {
            this.checkingAnimationState.stop();
            this.idleAnimationState.start(this.age);
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
          }
        }
      } else {
        if (this.idleAnimationTimeout <= 0) {
          this.idleAnimationTimeout = this.random.nextInt(40) + 80;
          this.idleAnimationState.start(this.age);
        } else {
          this.idleAnimationTimeout--;
        }
      }
    }
  }

  protected void updateLimbs(float v) {
    float f;
    if (this.getPose() == EntityPose.STANDING) {
      f = Math.min(v * 6.0F, 1.0F);
    } else {
      f = 0.0F;
    }
    this.limbAnimator.updateLimbs(f, 0.2F);
  }

  public boolean shouldHideFromPlayer() {
    double detectionRange = 3.0D;
    PlayerEntity closestPlayer = this.getWorld().getClosestPlayer(this, detectionRange);
    return closestPlayer != null && closestPlayer.isSprinting();
  }

  public boolean shouldCheckForPlayers() {
    double detectionRange = 5.0D;
    return this.getWorld().getClosestPlayer(this, detectionRange) == null;
  }

  @Nullable
  @Override
  public UUID getOwnerUuid() {
    return null;
  }


}
