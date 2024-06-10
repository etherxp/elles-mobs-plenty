package net.findsnow.ellesmobsnplenty.entity.ai.crab;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import java.util.EnumSet;
import java.util.Random;

public class WaveAtPlayerGoal extends Goal {
  private final CrabEntity crab;
  private PlayerEntity closestPlayer;
  private final float maxDistance;
  private final Random random;
  private int waveCooldown;

  public WaveAtPlayerGoal(CrabEntity crab, float maxDistance) {
    this.crab = crab;
    this.maxDistance = maxDistance;
    this.random = new Random();
    this.setControls(EnumSet.of(Control.LOOK));
    this.waveCooldown = random.nextInt(100);
  }

  @Override
  public boolean canStart() {
    this.closestPlayer = this.crab.getWorld().getClosestPlayer(this.crab, this.maxDistance);
    if (this.closestPlayer == null || this.waveCooldown > 0) {
      return false;
    }
    return this.crab.canSee(this.closestPlayer);
  }

  @Override
  public boolean shouldContinue() {
    return this.closestPlayer != null && this.closestPlayer.isAlive()
            && this.crab.squaredDistanceTo(this.closestPlayer) <= (this.maxDistance * this.maxDistance)
            && this.crab.canSee(this.closestPlayer);
  }

  @Override
  public void start() {
    super.start();
    this.crab.waveAnimationState.start(this.crab.age);
    this.waveCooldown = random.nextInt(100) + 100; // Set random cooldown for the next wave
  }

  @Override
  public void stop() {
    super.stop();
    this.closestPlayer = null;
  }
  public void tick() {
    if (this.waveCooldown > 0) {
      this.waveCooldown--;
    }
  }
}