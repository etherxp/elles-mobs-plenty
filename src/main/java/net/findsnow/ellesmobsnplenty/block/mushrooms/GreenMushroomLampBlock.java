package net.findsnow.ellesmobsnplenty.block.mushrooms;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GreenMushroomLampBlock extends Block {
  public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
  public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
  private static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 10, 12);

  public GreenMushroomLampBlock(Settings settings) {
    super(settings);
    this.setDefaultState(this.getDefaultState().with(CLICKED, false));
  }

  @Override
  public ActionResult onUse(BlockState state, World world, BlockPos pos,
                            PlayerEntity player, Hand hand, BlockHitResult hit) {
    if (!world.isClient() && hand == Hand.MAIN_HAND) {
      world.setBlockState(pos, state.cycle(CLICKED));
    }
    return ActionResult.SUCCESS;
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }

  @Nullable
  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
    builder.add(CLICKED);
  }
}
