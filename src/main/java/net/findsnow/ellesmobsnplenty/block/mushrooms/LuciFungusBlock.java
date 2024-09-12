package net.findsnow.ellesmobsnplenty.block.mushrooms;

import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LuciFungusBlock extends FlowerBlock {
    public LuciFungusBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.LUCI_FUNGAL_BOCK) || floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND);
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
