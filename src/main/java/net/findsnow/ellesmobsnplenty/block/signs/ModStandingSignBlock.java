package net.findsnow.ellesmobsnplenty.block.signs;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.findsnow.ellesmobsnplenty.block.entity.ModSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModStandingSignBlock extends SignBlock {
  public ModStandingSignBlock(Settings settings, WoodType woodType) {
    super(settings, woodType);
  }

  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new ModSignBlockEntity(pos, state);
  }
}
