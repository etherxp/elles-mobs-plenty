package net.findsnow.ellesmobsnplenty.block.custom;

import com.mojang.serialization.MapCodec;
import net.findsnow.ellesmobsnplenty.block.entity.ChomperBlockEntity;
import net.findsnow.ellesmobsnplenty.block.entity.ModBlockEntities;
import net.findsnow.ellesmobsnplenty.screen.ChomperBlockScreenHandler;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EnchantingTableBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ChomperBlock extends BlockWithEntity {
  public static final MapCodec<ChomperBlock> CODEC = ChomperBlock.createCodec(ChomperBlock::new);
  public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
  private static final Text TITLE = Text.literal("Chomper");
  public static final BooleanProperty OPEN = BooleanProperty.of("open");

  public ChomperBlock(Settings settings) {
    super(settings);
    this.setDefaultState(this.getDefaultState().with(OPEN, false));
  }

  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return CODEC;
  }

  @Override
  protected BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }


  @Nullable
  @Override
  public BlockState getPlacementState(ItemPlacementContext ctx) {
    return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
  }

  @Override
  protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    return true;
  }


  @Override
  protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    if (world.isClient) {
      return ActionResult.SUCCESS;
    }
    player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
    return ActionResult.CONSUME;
  }

  @Nullable
  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    return validateTicker(type, ModBlockEntities.CHOMPER_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
  }

  @Override
  protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
    BlockEntity blockEntity = world.getBlockEntity(pos);
    if (blockEntity instanceof ChomperBlockEntity chomperBlockEntity) {
      Text text = chomperBlockEntity.getDisplayName();
      return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new ChomperBlockScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), text);
    } else {
      return null;
    }
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING, OPEN);
  }

  @Override
  public BlockState rotate(BlockState state, BlockRotation rotation) {
    return this.getDefaultState().with(FACING, rotation.rotate(state.get(FACING)));
  }

  @Override
  protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
    if (state.getBlock() != newState.getBlock()) {
      BlockEntity blockEntity = world.getBlockEntity(pos);
      if (blockEntity instanceof ChomperBlockEntity) {
        ItemScatterer.spawn(world, pos, (ChomperBlockEntity)blockEntity);
        world.updateComparators(pos, this);
      }
      super.onStateReplaced(state, world, pos, newState, moved);
    }
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new ChomperBlockEntity(pos, state);
  }
}
