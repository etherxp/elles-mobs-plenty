package net.findsnow.ellesmobsnplenty.block.mushrooms;

import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CherryLeavesBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
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
  protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    if (!world.isClient() && hand == Hand.MAIN_HAND) {
      boolean clicked = state.get(CLICKED);
      world.setBlockState(pos, state.with(CLICKED, !clicked));
      SoundEvent soundEvent = clicked ? SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON : SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_OFF;
      world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS);
    }
    return ItemActionResult.SUCCESS;
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