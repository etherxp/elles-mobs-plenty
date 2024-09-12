package net.findsnow.ellesmobsnplenty.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.findsnow.ellesmobsnplenty.world.tree.ModFoliagePlacerTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class BlossomingLuciFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<BlossomingLuciFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillFoliagePlacerFields(instance)
                    .and(IntProvider.createValidatingCodec(0, 12).fieldOf("height").forGetter((placer) -> placer.height))
                    .apply(instance, BlossomingLuciFoliagePlacer::new));

    private final IntProvider height;


    public BlossomingLuciFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height) {
        super(radius, offset);
        this.height = height;

    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.BLOSSOMING_LUCI_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random,
                            TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        BlockPos startPos = treeNode.getCenter().up(offset);
        for (int y = 0; y < foliageHeight; y++) {
            int currentRadius = radius - y / 2;
            this.generateSquare(world, placer, random, config, startPos.up(y), currentRadius, y, treeNode.isGiantTrunk());
        }
    }

    @Override
    protected void generateSquare(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos centerPos, int radius, int y, boolean giantTrunk) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                if (!this.isInvalidForLeaves(random, dx, y, dz, radius, giantTrunk)) {
                    BlockPos foliagePos = centerPos.add(dx, 0, dz);
                    if (TreeFeature.canReplace(world, foliagePos)) {
                        placer.placeBlock(foliagePos, config.foliageProvider.get(random, foliagePos));
                    }
                }
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height.get(random);
    }


    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
