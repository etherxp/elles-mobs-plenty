package net.findsnow.ellesmobsnplenty.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ChomperBlock extends Block {
  public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
  public static final BooleanProperty OPEN = BooleanProperty.of("open");

  public ChomperBlock(Settings settings) {
    super(settings);
    this.setDefaultState(this.getDefaultState().with(OPEN, false));
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    if (!world.isClient() && hand == Hand.MAIN_HAND) {
      world.setBlockState(pos, state.cycle(OPEN));
    }
    return ActionResult.SUCCESS;
  }

  @Nullable
  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING, OPEN);
  }

  @Override
  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return this.getDefaultState().with(FACING, rotation.rotate(state.get(FACING)));
  }
}
