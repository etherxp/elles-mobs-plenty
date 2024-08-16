package net.findsnow.ellesmobsnplenty.block.mushrooms;

import com.mojang.serialization.MapCodec;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LuciMushroomBlock extends PlantBlock {
  public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
  private static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 16, 14, 16);

  public LuciMushroomBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected MapCodec<? extends PlantBlock> getCodec() {
    return null;
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }

  @Override
  protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                           PlayerEntity player, Hand hand, BlockHitResult hit) {
    Item item = stack.getItem();
    if (stack.isOf(ModItems.JAR)) {
      if (!world.isClient) {
        stack.decrement(1);
        ItemStack firebugJarStack = new ItemStack(ModBlocks.JAR_BLOCK);
        player.giveItemStack(firebugJarStack);
        world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.BLOCKS);
        world.playSound(null, pos, SoundEvents.ENTITY_BEE_HURT, SoundCategory.BLOCKS, 0.3f, -1f);
      }
      return ItemActionResult.SUCCESS;
    }
    return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
  }

  @Nullable
  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    Random random = ctx.getWorld().getRandom();
    BlockRotation rotation = BlockRotation.values()[random.nextInt(4)];

    return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).rotate(rotation);
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return this.getDefaultState().with(FACING, rotation.rotate(state.get(FACING)));
  }

  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    if (isNight(world)) {
      FireflyParticle(world, pos, random);
    }
  }


  public void FireflyParticle(World world, BlockPos pos, Random random) {
    int i = pos.getX();
    int j = pos.getY() + 2;
    int k = pos.getZ();
    double d = (double)i + random.nextDouble();
    double e = (double)j + random.nextDouble();
    double f = (double)k + random.nextDouble();
    world.addParticle(ModParticles.LUCI_MUSHROOM_PARTICLE, d, e, f, 0.0, 0.0, 0.0);
  }


  private boolean isNight(World world) {
    long timeOfDay = world.getTimeOfDay() % 24000;
    return timeOfDay >= 13000 && timeOfDay <= 23000;
  }
}
