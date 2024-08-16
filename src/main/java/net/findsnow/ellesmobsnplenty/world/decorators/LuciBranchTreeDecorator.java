package net.findsnow.ellesmobsnplenty.world.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.block.custom.LuciFungusShelfBlock;
import net.findsnow.ellesmobsnplenty.block.custom.LuciLogBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Iterator;
import java.util.List;

public class LuciBranchTreeDecorator extends TreeDecorator {
  public static final MapCodec<LuciBranchTreeDecorator> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
          instance.group(
                          Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((treeDecorator) -> treeDecorator.probability),
                          Codec.intRange(0, 15).fieldOf("treeHeight").forGetter(p -> p.treeHeight))
                  .apply(instance, LuciBranchTreeDecorator::new));
  private final float probability;
  private final int treeHeight;


  public LuciBranchTreeDecorator(float probability, int treeHeight) {
    this.probability = probability;
    this.treeHeight = treeHeight;
  }

  @Override
  protected TreeDecoratorType<?> getType() {
    return ModTreeDecorator.LUCI_BRANCH;
  }

  @Override
  public void generate(Generator generator) {
    Random random = generator.getRandom();
    if (!(random.nextFloat() >= this.probability));
    List<BlockPos> list = generator.getLogPositions();
    int i = list.get(0).getY();
    list.stream().filter((pos -> pos.getY() - i <= treeHeight)).forEach(pos -> {
      Iterator var3 = Direction.Type.HORIZONTAL.iterator();
      while(var3.hasNext()) {
        Direction direction = (Direction) var3.next();
        if (random.nextFloat() <= 0.05F) {
          Direction direction1 = direction.getOpposite();
          BlockPos blockPos = pos.add(direction1.getOffsetX(), 4, direction1.getOffsetZ());
          if (generator.isAir(blockPos)) {
            generator.replace(blockPos, ModBlocks.LUCI_LOG.getDefaultState()
                    .with(LuciLogBlock.AXIS, direction.getAxis()));
          }
        }
      }
    });
  }
}
