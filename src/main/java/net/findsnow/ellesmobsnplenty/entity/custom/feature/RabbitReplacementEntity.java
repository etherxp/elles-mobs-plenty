package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RabbitReplacementEntity extends AnimalEntity implements VariantHolder<RabbitReplacementEntity.RabbitType>, Tameable {

  // This class is super old
  // Lots of else-if statements flooded with that crap

  private static final TrackedData<Integer> RABBIT_TYPE =
          DataTracker.registerData(RabbitReplacementEntity.class, TrackedDataHandlerRegistry.INTEGER);
  private static final TrackedData<Integer> FINISH_DIG_TIME =
          DataTracker.registerData(RabbitReplacementEntity.class, TrackedDataHandlerRegistry.INTEGER);
  private static final Identifier KILLER_BUNNY = Identifier.of(EllesMobsNPlenty.MOD_ID, "killer_bunny");
  private static final Identifier KILLER_BUNNY_ATTACK_DAMAGE_MODIFIER_ID = Identifier.of(EllesMobsNPlenty.MOD_ID, "evil");

  public final AnimationState idleAnimationState = new AnimationState();
  public final AnimationState jumpingAnimationState = new AnimationState();
  public final AnimationState sniffingAnimationState = new AnimationState();
  private int idleAnimationTimeout = 0;
  private int sniffingAnimationTimeout = 0;
  private int jumpTicks;
  private int jumpDuration;


  private boolean rabbitFed;
  private boolean lastOnGround;
  private int ticksUntilJump;
  private boolean isSniffing;

  private int cooldownDuration = 2400; // Sniffing Cooldown 2 Minutes
  private int sniffingCooldown = 0;
  int moreCarrotTicks;

  public RabbitReplacementEntity(EntityType<? extends AnimalEntity> entityType, World world) {
    super(entityType, world);
    this.isSniffing = false;
    this.getNavigation().setCanSwim(true);
    this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    this.setPathfindingPenalty(PathNodeType.DAMAGE_CAUTIOUS, -1.0F);
    this.jumpControl = new RabbitReplacementEntity.RabbitJumpControl(this);
    this.moveControl = new RabbitReplacementEntity.RabbitMoveControl(this);
    this.setSpeed(0.0);
  }

  @Override
  protected void initDataTracker(DataTracker.Builder builder) {
    super.initDataTracker(builder);
    builder.add(RABBIT_TYPE, RabbitType.BROWN.id);
    builder.add(FINISH_DIG_TIME, 0);
  }

  @Override
  protected void initGoals() {
    this.goalSelector.add(1, new SwimGoal(this));
    this.goalSelector.add(1, new PowderSnowJumpGoal(this, this.getWorld()));
    this.goalSelector.add(1, new EscapeDangerGoal(this, 2.2));
    this.goalSelector.add(2, new AnimalMateGoal(this, 0.8));
    this.goalSelector.add(3, new TemptGoal(this, 1.0, stack -> stack.isIn(ItemTags.RABBIT_FOOD), false));
    this.goalSelector.add(4, new RabbitReplacementEntity.FleeGoal<>(this, PlayerEntity.class, 8.0F, 2.2, 2.2));
    this.goalSelector.add(4, new RabbitReplacementEntity.FleeGoal<>(this, WolfEntity.class, 10.0F, 2.2, 2.2));
    this.goalSelector.add(4, new RabbitReplacementEntity.FleeGoal<>(this, HostileEntity.class, 4.0F, 2.2, 2.2));
    this.goalSelector.add(5, new RabbitReplacementEntity.EatCarrotCropGoal(this));
    this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.6));
    this.goalSelector.add(11, new LookAtEntityGoal(this, PlayerEntity.class, 10.0F));
  }

  @Override
  public void onStartPathfinding() {
    super.onStartPathfinding();
    if (this.isOnFire() || this.isTouchingWater()) {
      this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }
  }

  @Override
  public void onFinishPathfinding() {
    this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
  }

  @Override
  public boolean isBreedingItem(ItemStack stack) {
    return stack.isIn(ItemTags.RABBIT_FOOD);
  }

  public boolean isFeedingItem(ItemStack stack) {
    return stack.isIn(ItemTags.FLOWERS);
  }

  public void rabbitWasFed(RabbitReplacementEntity entity, ItemStack itemStack) {
    if (entity.rabbitFed) {
      entity.setVariant(entity.getVariant());
      this.disableJump();
    }
  }

  @Override
  public float getStepHeight() {
    return 1f;
  }

  @Nullable
  @Override
  public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
    RabbitReplacementEntity rabbitReplacementEntity = ModEntities.RABBIT.create(world);
    if (rabbitReplacementEntity != null) {
      RabbitReplacementEntity.RabbitType rabbitType;
      rabbitType = getTypeFromPos(world, this.getBlockPos());
      label16:
      if (this.random.nextInt(20) != 0) {
        if (entity instanceof RabbitReplacementEntity rabbitReplacementEntity2 && this.random.nextBoolean()) {
          rabbitType = rabbitReplacementEntity2.getVariant();
          break label16;
        }

        rabbitType = this.getVariant();
      }

      rabbitReplacementEntity.setVariant(rabbitType);
    }

    return rabbitReplacementEntity;
  }

  private static RabbitReplacementEntity.RabbitType getTypeFromPos(WorldAccess world, BlockPos pos) {
    RegistryEntry<Biome> registryEntry = world.getBiome(pos);
    int i = world.getRandom().nextInt(100);
    if (registryEntry.isIn(BiomeTags.SPAWNS_WHITE_RABBITS)) {
      return i < 80 ? RabbitReplacementEntity.RabbitType.WHITE : RabbitReplacementEntity.RabbitType.WHITE_SPLOTCHED;
    } else if (registryEntry.isIn(BiomeTags.SPAWNS_GOLD_RABBITS)) {
      return RabbitReplacementEntity.RabbitType.GOLD;
    } else {
      return i < 50 ? RabbitReplacementEntity.RabbitType.BROWN : (i < 90 ? RabbitReplacementEntity.RabbitType.SALT : RabbitReplacementEntity.RabbitType.BLACK);
    }
  }


  public static boolean canSpawn(EntityType<RabbitReplacementEntity> entity, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
    return world.getBlockState(pos.down()).isIn(BlockTags.RABBITS_SPAWNABLE_ON) && isLightLevelValidForNaturalSpawn(world, pos);
  }

  @Override
  public void setVariant(RabbitReplacementEntity.RabbitType variant) {
    if (variant == RabbitReplacementEntity.RabbitType.EVIL) {
      this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(8.0);
      this.goalSelector.add(4, new MeleeAttackGoal(this, 1.4, true));
      this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
      this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
      this.targetSelector.add(2, new ActiveTargetGoal<>(this, WolfEntity.class, true));
      this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE)
              .updateModifier(new EntityAttributeModifier(KILLER_BUNNY_ATTACK_DAMAGE_MODIFIER_ID, 5.0, EntityAttributeModifier.Operation.ADD_VALUE));
      if (!this.hasCustomName()) {
        this.setCustomName(Text.translatable(Util.createTranslationKey("entity", KILLER_BUNNY)));
      }
    } else {
      this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(KILLER_BUNNY_ATTACK_DAMAGE_MODIFIER_ID);
    }

    this.dataTracker.set(RABBIT_TYPE, variant.id);
  }

  @Override
  public RabbitType getVariant() {
    return RabbitReplacementEntity.RabbitType.byId(this.dataTracker.get(RABBIT_TYPE));
  }

  @Override
  public ActionResult interactMob(PlayerEntity player, Hand hand) {
    ItemStack itemStack = player.getStackInHand(hand);
    if (isFeedingItem(itemStack)) {
      this.rabbitFed = true;
      itemStack.decrement(1);
      return ActionResult.SUCCESS;
    }
    return ActionResult.PASS;
  }

  // Tick Methods

  public void setupAnimationStates() {
    if (this.sniffingCooldown > 0) {
      --this.sniffingCooldown;
    }
    if (this.idleAnimationTimeout <= 0) {
      this.idleAnimationTimeout = this.random.nextInt(40) + 80;
      this.idleAnimationState.start(this.age);
    } else {
      --this.idleAnimationTimeout;
    }
    if (this.rabbitFed && this.sniffingCooldown <=0) {
      if (this.sniffingAnimationTimeout <= 0) {
        this.disableJump();

        this.sniffingAnimationTimeout = 100;
        this.sniffingAnimationState.start(this.age);
        this.isSniffing = true;
        this.sniffingCooldown = cooldownDuration;
      } else {
        --this.sniffingAnimationTimeout;
      }
        } else {
      if (!this.isSniffing) {
        this.enableJump();
        this.jump();
        this.sniffingAnimationState.stop();
      }
    }
    if (this.sniffingAnimationTimeout <= 0 && this.isSniffing) {
      this.isSniffing = false;
    }
  }


  @Override
  public void tick() {
    super.tick();
    if (this.getWorld().isClient) {
      this.setupAnimationStates();
    }
  }

  boolean wantsCarrots() {
    return this.moreCarrotTicks <= 0;
  }

  @Override
  public void handleStatus(byte status) {
    if (status == EntityStatuses.ADD_SPRINTING_PARTICLES_OR_RESET_SPAWNER_MINECART_SPAWN_DELAY) {
      this.spawnSprintingParticles();
      this.jumpDuration = 10;
      this.jumpTicks = 0;
    } else {
      super.handleStatus(status);
    }
  }

  @Override
  public Vec3d getLeashOffset() {
    return new Vec3d(0.0, 0.6F * this.getStandingEyeHeight(), this.getWidth() * 0.4F);
  }

  @Override
  protected float getJumpVelocity() {
    float f = 0.5F;
    if (this.horizontalCollision || this.moveControl.isMoving() && this.moveControl.getTargetY() > this.getY() + 0.7) {
      f = 0.7F;
    }

    Path path = this.navigation.getCurrentPath();
    if (path != null && !path.isFinished()) {
      Vec3d vec3d = path.getNodePosition(this);
      if (vec3d.y > this.getY() + 0.7) {
        f = 0.7F;
      }
    }

    if (this.moveControl.getSpeed() <= 0.6) {
      f = 0.4F;
    }

    return super.getJumpVelocity(f / 0.60F);
  }

  @Override
  public void jump() {
    super.jump();
    double d = this.moveControl.getSpeed();
    if (d > 0.0) {
      double e = this.getVelocity().horizontalLengthSquared();
      if (e < 0.01) {
        this.updateVelocity(0.1F, new Vec3d(0.0, 0.0, 1.0));
      }
    }

    if (!this.getWorld().isClient) {
      this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_SPRINTING_PARTICLES_OR_RESET_SPAWNER_MINECART_SPAWN_DELAY);
    }
  }

  public float getJumpProgress(float delta) {
    return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + delta) / (float)this.jumpDuration;
  }

  public void setSpeed(double speed) {
    this.getNavigation().setSpeed(speed);
    this.moveControl.moveTo(this.moveControl.getTargetX(), this.moveControl.getTargetY(), this.moveControl.getTargetZ(), speed);
  }

  @Override
  public void setJumping(boolean jumping) {
    super.setJumping(jumping);
    if (jumping) {
      this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 0.8F);
    }
  }

  protected SoundEvent getJumpSound() {
    return SoundEvents.ENTITY_RABBIT_JUMP;
  }

  @Override
  protected SoundEvent getAmbientSound() {
    return SoundEvents.ENTITY_RABBIT_AMBIENT;
  }

  @Override
  protected SoundEvent getHurtSound(DamageSource source) {
    return SoundEvents.ENTITY_RABBIT_HURT;
  }

  @Override
  protected SoundEvent getDeathSound() {
    return SoundEvents.ENTITY_RABBIT_DEATH;
  }

  @Override
  public void playAttackSound() {
    if (this.getVariant() == RabbitReplacementEntity.RabbitType.EVIL) {
      this.playSound(SoundEvents.ENTITY_RABBIT_ATTACK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
    }
  }

  @Override
  public SoundCategory getSoundCategory() {
    return this.getVariant() == RabbitReplacementEntity.RabbitType.EVIL ? SoundCategory.HOSTILE : SoundCategory.NEUTRAL;
  }

  public void startJump() {
    if (!this.isSniffing) {
      this.enableJump();
      this.setJumping(true);
      this.jumpDuration = 10;
    } else {
      this.disableJump();
      this.setJumping(false);
      this.jumpDuration = 0;
    }
    this.jumpTicks = 0;
  }

  @Override
  public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
    RabbitReplacementEntity.RabbitType rabbitType = getTypeFromPos(world, this.getBlockPos());
    if (entityData instanceof RabbitReplacementEntity.RabbitData) {
      rabbitType = ((RabbitData) entityData).type;
    } else {
      entityData = new RabbitReplacementEntity.RabbitData(rabbitType);
    }
    this.setVariant(rabbitType);
    return super.initialize(world, difficulty, spawnReason, entityData);
  }


  // Default Rabbit stuff

  @Override
  public void mobTick() {
    if (this.ticksUntilJump > 0) {
      --this.ticksUntilJump;
    }
    if (this.horizontalCollision) {
      this.setJumping(true);
    }
    if (this.moreCarrotTicks > 0) {
      this.moreCarrotTicks -= this.random.nextInt(3);
      if (this.moreCarrotTicks < 0) {
        this.moreCarrotTicks = 0;
      }
    }

    if (sniffingAnimationState.isRunning()) {

      this.ticksUntilJump = 800;
      this.sniffingCooldown = 140;
      this.isSniffing = true;
      this.navigation.stop();

      if (this.sniffingAnimationTimeout <= 0) {
        this.sniffingAnimationTimeout = 140;
      }
      this.sniffingAnimationTimeout--;
      if (this.sniffingAnimationTimeout <= 0) {
        this.isSniffing = false;
        this.sniffingCooldown = 2400;
      }
    }

    // Stop Rabbit Movement
    if (this.isSniffing) {
      this.jumpTicks = 500;
      this.ticksUntilJump = 800;
      this.getNavigation().stop();
      this.setAiDisabled(true);
      return;
    } else {
      this.setAiDisabled(false);
    }

    // This Continues Movement
    if (this.isOnGround()) {
      if (!this.lastOnGround) {
        this.setJumping(false);
        this.jumpingAnimationState.stop();
        this.scheduleJump();
      }
      if (this.getVariant() == RabbitReplacementEntity.RabbitType.EVIL && this.ticksUntilJump == 0) {
        LivingEntity livingEntity = this.getTarget();
        if (livingEntity != null && this.squaredDistanceTo(livingEntity) < 16.0) {
          this.lookTowards(livingEntity.getX(), livingEntity.getZ());
          this.moveControl.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), this.moveControl.getSpeed());
          this.startJump();
          this.lastOnGround = true;
        }
      }
      RabbitReplacementEntity.RabbitJumpControl rabbitJumpControl = (RabbitReplacementEntity.RabbitJumpControl) this.jumpControl;
      if (!rabbitJumpControl.isActive()) {
        if (this.moveControl.isMoving() && this.ticksUntilJump == 0) {
          Path path = this.navigation.getCurrentPath();
          Vec3d vec3d = new Vec3d(this.moveControl.getTargetX(), this.moveControl.getTargetY(), this.moveControl.getTargetZ());
          if (path != null && !path.isFinished()) {
            vec3d = path.getNodePosition(this);
          }
          this.lookTowards(vec3d.x, vec3d.z);
          this.startJump();
        }
      } else if (!rabbitJumpControl.canJump()) {
        this.enableJump();
      }
    }
    if (!this.sniffingAnimationState.isRunning() && sniffingAnimationTimeout > 0) {
      --sniffingAnimationTimeout;
    }
    this.lastOnGround = this.isOnGround();
  }

  @Override
  public boolean shouldSpawnSprintingParticles() {
    return false;
  }

  @Override
  public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
    return false;
  }

  private void lookTowards(double x, double z) {
    this.setYaw((float)(MathHelper.atan2(z - this.getZ(), x - this.getX()) * 180.0F / (float)Math.PI) - 90.0F);
  }

  private void enableJump() {
    ((RabbitReplacementEntity.RabbitJumpControl)this.jumpControl).setCanJump(true);
  }

  private void disableJump() {
    ((RabbitReplacementEntity.RabbitJumpControl)this.jumpControl).setCanJump(false);
  }

  private void doScheduleJump() {
    if (this.moveControl.getSpeed() < 2.2) {
      this.ticksUntilJump = 10;
    } else {
      this.ticksUntilJump = 1;
    }
  }

  private void scheduleJump() {
    this.doScheduleJump();
    this.disableJump();
  }

  @Override
  public void tickMovement() {
    super.tickMovement();
    if (this.jumpTicks != this.jumpDuration) {
      ++this.jumpTicks;
    } else if (this.jumpDuration != 0) {
      this.jumpTicks = 0;
      this.jumpDuration = 0;
      this.setJumping(false);
      this.jumpingAnimationState.stop();
    }
  }

  public static DefaultAttributeContainer.Builder createRabbitAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5F)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0);
  }

  @Override
  public void writeCustomDataToNbt(NbtCompound nbt) {
    super.writeCustomDataToNbt(nbt);
    nbt.putInt("RabbitType", this.getVariant().id);
    nbt.putInt("MoreCarrotTicks", this.moreCarrotTicks);
  }

  @Override
  public void readCustomDataFromNbt(NbtCompound nbt) {
    super.readCustomDataFromNbt(nbt);
    this.setVariant(RabbitReplacementEntity.RabbitType.byId(nbt.getInt("RabbitType")));
    this.moreCarrotTicks = nbt.getInt("MoreCarrotTicks");
  }

  @Nullable
  @Override
  public UUID getOwnerUuid() {
    return null;
  }


  // Rabbit Goal


  static class EatCarrotCropGoal extends MoveToTargetPosGoal {
    private final RabbitReplacementEntity rabbit;
    private boolean wantsCarrots;
    private boolean hasTarget;

    public EatCarrotCropGoal(RabbitReplacementEntity rabbit) {
      super(rabbit, 0.7F, 16);
      this.rabbit = rabbit;
    }

    @Override
    public boolean canStart() {
      if (this.cooldown <= 0) {
        if (!this.rabbit.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
          return false;
        }

        this.hasTarget = false;
        this.wantsCarrots = this.rabbit.wantsCarrots();
      }

      return super.canStart();
    }

    @Override
    public boolean shouldContinue() {
      return this.hasTarget && super.shouldContinue();
    }

    @Override
    public void tick() {
      super.tick();
      this.rabbit
              .getLookControl()
              .lookAt(
                      (double)this.targetPos.getX() + 0.5,
                      (double)(this.targetPos.getY() + 1),
                      (double)this.targetPos.getZ() + 0.5,
                      10.0F,
                      (float)this.rabbit.getMaxLookPitchChange()
              );
      if (this.hasReached()) {
        World world = this.rabbit.getWorld();
        BlockPos blockPos = this.targetPos.up();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        if (this.hasTarget && block instanceof CarrotsBlock) {
          int i = blockState.get(CarrotsBlock.AGE);
          if (i == 0) {
            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
            world.breakBlock(blockPos, true, this.rabbit);
          } else {
            world.setBlockState(blockPos, blockState.with(CarrotsBlock.AGE, Integer.valueOf(i - 1)), Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(this.rabbit));
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, blockPos, Block.getRawIdFromState(blockState));
          }

          this.rabbit.moreCarrotTicks = 40;
        }

        this.hasTarget = false;
        this.cooldown = 10;
      }
    }

    @Override
    protected boolean isTargetPos(WorldView world, BlockPos pos) {
      BlockState blockState = world.getBlockState(pos);
      if (blockState.isOf(Blocks.FARMLAND) && this.wantsCarrots && !this.hasTarget) {
        blockState = world.getBlockState(pos.up());
        if (blockState.getBlock() instanceof CarrotsBlock && ((CarrotsBlock)blockState.getBlock()).isMature(blockState)) {
          this.hasTarget = true;
          return true;
        }
      }

      return false;
    }
  }

  static class EscapeDangerGoal extends net.minecraft.entity.ai.goal.EscapeDangerGoal {
    private final RabbitReplacementEntity rabbit;

    public EscapeDangerGoal(RabbitReplacementEntity rabbit, double speed) {
      super(rabbit, speed);
      this.rabbit = rabbit;
    }

    @Override
    public void tick() {
      super.tick();
      this.rabbit.setSpeed(this.speed);
    }
  }

  static class FleeGoal<T extends LivingEntity> extends FleeEntityGoal<T> {
    private final RabbitReplacementEntity rabbit;

    public FleeGoal(RabbitReplacementEntity rabbit, Class<T> fleeFromType, float distance, double slowSpeed, double fastSpeed) {
      super(rabbit, fleeFromType, distance, slowSpeed, fastSpeed);
      this.rabbit = rabbit;
    }

    @Override
    public boolean canStart() {
      return this.rabbit.getVariant() != RabbitReplacementEntity.RabbitType.EVIL && super.canStart();
    }
  }

  // Other Rabbit Classes - Enums

  public static class RabbitData extends PassiveEntity.PassiveData {
    public final RabbitReplacementEntity.RabbitType type;

    public RabbitData(RabbitReplacementEntity.RabbitType type) {
      super(1.0F);
      this.type = type;
    }
  }

  public static class RabbitJumpControl extends JumpControl {
    private final RabbitReplacementEntity rabbit;
    private boolean canJump;

    public RabbitJumpControl(RabbitReplacementEntity rabbit) {
      super(rabbit);
      this.rabbit = rabbit;
    }

    public boolean isActive() {
      return this.active;
    }

    public boolean canJump() {
      return this.canJump;
    }

    public void setCanJump(boolean canJump) {
      this.canJump = canJump;
    }

    @Override
    public void tick() {
      if (this.active) {
        this.rabbit.startJump();
        this.active = false;
      }
    }
  }

  static class RabbitMoveControl extends MoveControl {
    private final RabbitReplacementEntity rabbit;
    private double rabbitSpeed;

    public RabbitMoveControl(RabbitReplacementEntity owner) {
      super(owner);
      this.rabbit = owner;
    }

    @Override
    public void tick() {
      if (this.rabbit.isOnGround() && !this.rabbit.jumping && !((RabbitReplacementEntity.RabbitJumpControl)this.rabbit.jumpControl).isActive()) {
        this.rabbit.setSpeed(0.0);
      } else if (this.isMoving()) {
        this.rabbit.setSpeed(this.rabbitSpeed);
      }

      super.tick();
    }

    @Override
    public void moveTo(double x, double y, double z, double speed) {
      if (this.rabbit.isTouchingWater()) {
        speed = 1.5;
      }

      super.moveTo(x, y, z, speed);
      if (speed > 0.0) {
        this.rabbitSpeed = speed;
      }
    }
  }

  public static enum RabbitType implements StringIdentifiable {
    BROWN(0, "brown"),
    WHITE(1, "white"),
    BLACK(2, "black"),
    WHITE_SPLOTCHED(3, "white_splotched"),
    GOLD(4, "gold"),
    SALT(5, "salt"),
    EVIL(99, "evil");

    private static final IntFunction<RabbitReplacementEntity.RabbitType> BY_ID =
            ValueLists.createIdToValueFunction(RabbitReplacementEntity.RabbitType::getId, values(), BROWN);
    public static final Codec<RabbitReplacementEntity.RabbitType> CODEC =
            StringIdentifiable.createCodec(RabbitReplacementEntity.RabbitType::values);
    final int id;
    private final String name;

    private RabbitType(final int id, final String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public String asString() {
      return this.name;
    }

    public int getId() {
      return this.id;
    }

    public static RabbitReplacementEntity.RabbitType byId(int id) {
      return BY_ID.apply(id);
    }
  }
}