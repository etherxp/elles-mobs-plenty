package net.findsnow.ellesmobsnplenty.world.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.block.custom.LuciFungusShelfBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Iterator;
import java.util.List;

public class ModFungusTreeDecorator extends TreeDecorator {
    public static final MapCodec<ModFungusTreeDecorator> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                            Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((treeDecorator) -> treeDecorator.probability),
                            Codec.intRange(0, 15).fieldOf("treeHeight").forGetter(p -> p.treeHeight))
                    .apply(instance, ModFungusTreeDecorator::new));
    private final float probability;
    private final int treeHeight;


    public ModFungusTreeDecorator(float probability, int treeHeight) {
        this.probability = probability;
        this.treeHeight = treeHeight;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorator.LUCI_FUNGUS_SHELF;
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
                if (random.nextFloat() <= 0.045F) {
                    Direction direction1 = direction.getOpposite();
                    BlockPos blockPos = pos.add(direction1.getOffsetX(), 0, direction1.getOffsetZ());
                    if (generator.isAir(blockPos)) {
                        generator.replace(blockPos, ModBlocks.LUCI_FUNGUS_SHELF_BLOCk.getDefaultState()
                                .with(LuciFungusShelfBlock.FACING, direction.getOpposite()));
                    }
                }
            }
        });
    }
}
