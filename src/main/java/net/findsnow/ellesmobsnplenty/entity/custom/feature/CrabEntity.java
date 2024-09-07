package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import com.mojang.serialization.Dynamic;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.entity.ai.crab.ClimbingMoveControl;
import net.findsnow.ellesmobsnplenty.entity.ai.crab.WaveAtPlayerGoal;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.control.YawAdjustingLookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SpiderNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.AxolotlBrain;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CrabEntity extends AnimalEntity implements Bucketable {

  private static final TrackedData<Boolean> FROM_BUCKET =
          DataTracker.registerData(CrabEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

  public final AnimationState waveAnimationState = new AnimationState();
  public final AnimationState idleAnimationState = new AnimationState();
  public final AnimationState snipAnimationState = new AnimationState();
  public final AnimationState climbAnimationState = new AnimationState();
  private int idleAnimationTimeout = 0;
  private int waveAnimationTimeout = 0;
  private int snipAnimationTimeout = 0;
  private int climbAnimationTimeout = 0;

  public CrabEntity(EntityType<? extends AnimalEntity> entityType, World world) {
    super(entityType, world);
    this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    this.setPathfindingPenalty(PathNodeType.WATER_BORDER, -2.0F);
  }

  @Override
  protected void initDataTracker(DataTracker.Builder builder) {
    super.initDataTracker(builder);
    builder.add(FROM_BUCKET, false);
  }

  @Override
  public boolean isBreedingItem(ItemStack stack) {
    return false;
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new SwimGoal(this));
    this.goalSelector.add(1, new EscapeDangerGoal(this, 0.6F));
    this.goalSelector.add(2, new WaveAtPlayerGoal(this, 1));
    this.goalSelector.add(3, new FollowParentGoal(this, 0.5F));
    this.goalSelector.add(4, new WanderAroundGoal(this, 0.5F));
    this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F));
    this.goalSelector.add(6, new TemptGoal(this, 1.1, Ingredient.ofItems(Items.KELP), false));
    this.goalSelector.add(7, new LookAroundGoal(this));
    this.goalSelector.add(8, new AnimalMateGoal(this, 0.5F));
  }

  public static DefaultAttributeContainer.Builder createCrabAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5F);
  }

  private void setupAnimationStates() {
    if (this.idleAnimationTimeout <= 0) {
      this.idleAnimationTimeout = this.random.nextInt(40) + 80;
      this.idleAnimationState.start(this.age);
    } else {
      --this.idleAnimationTimeout;
    }
    if (this.isWaving() && waveAnimationTimeout <= 0) {
      waveAnimationTimeout = 1600;
      waveAnimationState.start(this.age);
    } else {
      --this.waveAnimationTimeout;
    }
    if (!this.isWaving()) {
      waveAnimationState.stop();
    }

    if (this.isClimbing()) {
      if (climbAnimationTimeout <=0) {
        climbAnimationTimeout = this.random.nextInt(40) + 80;
        this.climbAnimationState.start(this.age);
      }
    } else {
      --this.climbAnimationTimeout;
    }
    if (!this.isClimbing()) {
      climbAnimationState.stop();
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

  @Override
  public void travel(Vec3d movementInput) {
    if (this.isTouchingWater() || this.isInLava()) {
      this.updateVelocity(0.02f, movementInput);
      this.move(MovementType.SELF, this.getVelocity());
      this.setVelocity(this.getVelocity().multiply(0.3));
    } else {
      if (this.isOnGround()) {
        this.setVelocity(this.getVelocity().multiply(0.3));
        Vec3d sidewaysWalk = new Vec3d(movementInput.z, movementInput.y, -movementInput.x);
        this.updateVelocity(this.getMovementSpeed(), sidewaysWalk);
      }
      super.travel(movementInput);
    }
  }


  @Override
  public void tick() {
    super.tick();

    if (this.getWorld().isClient()) {
      setupAnimationStates();
    }
  }

  @Override
  public boolean isClimbing() {
    return this.horizontalCollision;
  }

  public boolean isWaving() {
    return false;
  }

  @Override
  public boolean canImmediatelyDespawn(double distanceSquared) {
    return !this.isFromBucket() && !this.hasCustomName();
  }

  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    return Bucketable.tryBucket(player, hand, this).orElse(super.interactMob(player, hand));
  }

  @Override
  protected SoundEvent getHurtSound(DamageSource source) {
    return SoundEvents.ENTITY_TURTLE_EGG_CRACK;
  }

  @Override
  protected void playStepSound(BlockPos pos, BlockState state) {
    this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
  }

  @Override
  protected SoundEvent getDeathSound() {
    return SoundEvents.ENTITY_TURTLE_DEATH;
  }


  @Nullable
  @Override
  public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
    return ModEntities.CRAB.create(world);
  }

  @Override
  public boolean isFromBucket() {
    return this.dataTracker.get(FROM_BUCKET);
  }

  @Override
  public void setFromBucket(boolean fromBucket) {
    this.dataTracker.set(FROM_BUCKET, fromBucket);
  }

  @Override
  public void copyDataToStack(ItemStack stack) {
    Bucketable.copyDataToStack(this, stack);
    NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, stack, nbt -> {
      nbt.putInt("Age", this.getBreedingAge());
    });
  }

  @Override
  public void copyDataFromNbt(NbtCompound nbt) {
    Bucketable.copyDataFromNbt(this, nbt);
    if (nbt.contains("Age")) {
      this.setBreedingAge(nbt.getInt("Age"));
    }
  }


  @Override
  public void writeCustomDataToNbt(NbtCompound nbt) {
    super.writeCustomDataToNbt(nbt);
    nbt.putBoolean("FromBucket", this.isFromBucket());
  }

  @Override
  public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);
    this.setFromBucket(nbt.getBoolean("FromBucket"));
  }

  @Override
  public ItemStack getBucketItem() {
    return new ItemStack(ModItems.CRAB_BUCKET);
  }

  @Override
  public SoundEvent getBucketFillSound() {
    return SoundEvents.ITEM_BUCKET_FILL_TADPOLE;
  }
}

