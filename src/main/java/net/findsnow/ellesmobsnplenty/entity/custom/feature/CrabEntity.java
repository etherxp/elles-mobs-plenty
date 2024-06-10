package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.entity.ai.crab.WaveAtPlayerGoal;
import net.findsnow.ellesmobsnplenty.entity.variant.CrabVariant;
import net.findsnow.ellesmobsnplenty.util.ModBiomeTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrabEntity extends AnimalEntity {
  public static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
          DataTracker.registerData(CrabEntity.class, TrackedDataHandlerRegistry.INTEGER);
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
    this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 0.0F);
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(0, new SwimGoal(this));
    this.goalSelector.add(1, new EscapeDangerGoal(this, 1));
    this.goalSelector.add(2, new WaveAtPlayerGoal(this, 1));
    this.goalSelector.add(3, new FollowParentGoal(this, 1.0));
    this.goalSelector.add(4, new WanderAroundGoal(this, 0.7));
    this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F));
    this.goalSelector.add(6, new TemptGoal(this, 1.1, Ingredient.ofItems(Items.KELP), false));
    this.goalSelector.add(7, new LookAroundGoal(this));
    this.goalSelector.add(8, new AnimalMateGoal(this, 1.0));
  }

  public static DefaultAttributeContainer.Builder createCrabAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 7)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
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
    if (this.snipAnimationTimeout <= 0) {
      if (this.random.nextFloat() < 0.2) {
        this.snipAnimationTimeout = this.random.nextInt(40) + 80;
        this.snipAnimationState.start(this.age);
      }
    } else {
      --this.snipAnimationTimeout;
    }
    if (this.snipAnimationTimeout <=0) {
      snipAnimationState.stop();
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
        this.resetBodyRotation();
      } else if (this.horizontalCollision) {
        Vec3d climbMovement = new Vec3d(movementInput.z, 0, -movementInput.x);
        this.updateVelocity(this.getMovementSpeed(), climbMovement);
        this.setVelocity(this.getVelocity().add(0.0, 0.2, 0.0));
        if (movementInput.y > 0) {
          this.setVelocity(this.getVelocity().add(0.0, this.getMovementSpeed() * 0.15, 0.0));
        }
      } else {
        this.resetBodyRotation();
      }
    }
    super.travel(movementInput);
  }


  private void resetBodyRotation() {
    this.setPitch(0.0F);
  }

  @Override
  public void tick() {
    super.tick();
    if (this.getWorld().isClient()) {
      this.setupAnimationStates();
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
  protected SoundEvent getHurtSound(DamageSource source) {
    return SoundEvents.ENTITY_TURTLE_EGG_CRACK;
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
  protected void initDataTracker() {
    super.initDataTracker();
    this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
  }

  // Variants

  public CrabVariant getVariant() {
    return CrabVariant.byId(this.getTypeVariant() & 255);
  }

  private int getTypeVariant () {
    return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
  }

  private void setVariant(CrabVariant variant) {
    this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
  }

 // @Override
 /// public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
   //                            @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
   // RegistryEntry<Biome> registryEntry = world.getBiome(this.getBlockPos());
    //if (registryEntry.isIn(ModBiomeTags.SPAWNS_RED_CRAB)) {
     // this.setVariant(CrabVariant.DEFAULT);
    //} else if (registryEntry.isIn(ModBiomeTags.SPAWNS_BLUE_CRAB)) {
     // this.setVariant(CrabVariant.BLUE);
    //} else if (registryEntry.isIn(ModBiomeTags.SPAWNS_GREEN_CRAB)) {
    //  this.setVariant(CrabVariant.GREEN);
   // }
    //return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
  //}

  @Override
  public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);
    this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
  }

  @Override
  public void writeCustomDataToNbt(NbtCompound nbt) {
    super.writeCustomDataToNbt(nbt);
    nbt.putInt("Variant", this.getTypeVariant());
  }
}
