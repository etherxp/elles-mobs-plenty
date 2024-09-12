package net.findsnow.ellesmobsnplenty.world.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class BlossomingLuciVineTreeDecorator extends TreeDecorator {
    public static final MapCodec<BlossomingLuciVineTreeDecorator> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                            Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((treeDecorator) -> treeDecorator.probability),
                            BlockStateProvider.TYPE_CODEC.fieldOf("block_provider").forGetter((treeDecorator) -> treeDecorator.blockProvider),
                            Codec.intRange(0, 10).fieldOf("number").forGetter((treeDecorator) -> treeDecorator.number))
                    .apply(instance, BlossomingLuciVineTreeDecorator::new));

    protected final BlockStateProvider blockProvider;
    private final float probability;
    protected int number;

    public BlossomingLuciVineTreeDecorator(float probability, BlockStateProvider blockProvider, int number) {
        this.probability = probability;
        this.blockProvider = blockProvider;
        this.number = number;
    }

    private static void placeVines(BlockPos pos, BlockStateProvider block, Generator generator, int number) {
        Random random = generator.getRandom();
        for (int i = 0; i < number; i++) {
            if (generator.isAir(pos)) {
                generator.replace(pos, block.get(random, pos));
                pos = pos.down();
            }
        }
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return ModTreeDecorator.BLOSSOMING_LUCI_VINES;
    }

    @Override
    public void generate(Generator generator) {
        Random randomSource = generator.getRandom();
        generator.getLeavesPositions().forEach((blockPos) -> {
            if (randomSource.nextFloat() < this.probability) {
                BlockPos blockPos2 = blockPos.down();
                if (generator.isAir(blockPos2)) {
                    placeVines(blockPos2, blockProvider, generator, this.number);
                }
            }
        });
    }
}