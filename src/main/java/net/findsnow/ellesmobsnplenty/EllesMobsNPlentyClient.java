package net.findsnow.ellesmobsnplenty;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.minecraft.client.render.RenderLayer;

public class EllesMobsNPlentyClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCERO_SAPLING, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCERO_DOOR, RenderLayer.getCutout());
  }
}
