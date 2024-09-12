package net.findsnow.ellesmobsnplenty.entity.ai.shark;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.SharkEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class SharkAttackGoal extends MeleeAttackGoal {
    private final SharkEntity sharkEntity;
    private int attackDelay = 10;
    private int ticksUntilAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public SharkAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        sharkEntity = ((SharkEntity) mob);
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilAttack = Math.max(this.ticksUntilAttack - 1, 0);
        }
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilAttack = 20;
    }

    @Override
    public void stop() {
        sharkEntity.setAttacking(false);
        super.stop();
    }
}
