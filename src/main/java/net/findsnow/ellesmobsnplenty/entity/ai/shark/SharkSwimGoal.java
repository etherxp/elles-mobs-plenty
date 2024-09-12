package net.findsnow.ellesmobsnplenty.entity.ai.shark;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.SharkEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

public class SharkSwimGoal extends Goal {
    private final SharkEntity shark;
    private final World world;
    private int swimTick;

    public SharkSwimGoal(SharkEntity shark) {
        this.shark = shark;
        this.world = shark.getWorld();
    }


    @Override
    public boolean canStart() {
        return false;
    }
}
