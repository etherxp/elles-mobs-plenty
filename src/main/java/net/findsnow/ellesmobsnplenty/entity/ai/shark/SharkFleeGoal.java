package net.findsnow.ellesmobsnplenty.entity.ai.shark;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.SharkEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FleeEntityGoal;

public class SharkFleeGoal <T extends LivingEntity> extends FleeEntityGoal<T> {
  private final SharkEntity shark;


  public SharkFleeGoal(SharkEntity shark, Class<T> classToFleeFrom, float fleeDistance, double fleeSlowSpeed, double fleeFastSpeed) {
    super(shark, classToFleeFrom, fleeDistance, fleeSlowSpeed, fleeFastSpeed);
    this.shark = shark;
  }

  @Override
  public boolean canStart() {
    return super.canStart();
  }
}
