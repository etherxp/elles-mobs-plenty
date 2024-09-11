package net.findsnow.ellesmobsnplenty;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.entity.ModBoats;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.*;
import net.findsnow.ellesmobsnplenty.entity.render.renderer.*;
import net.findsnow.ellesmobsnplenty.particle.*;
import net.findsnow.ellesmobsnplenty.screen.ChomperBlockScreen;
import net.findsnow.ellesmobsnplenty.screen.ModScreenHandlers;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.world.biome.FoliageColors;

public class EllesMobsNPlentyClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    // Transparent Stuff
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_FUNGUS_SHELF_BLOCk, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_SAPLING, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_MUSHROOM_LAMP, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_MUSHROOM_LAMP, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JAR_BLOCK, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOSSOMING_LUCI_SAPLING, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_DOOR, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAURELLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_FLAURELLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOSSOMING_LUCI_VINE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_PETAL, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_FUNGUS, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_LEAF_PILE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLOVER, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_CLOVER, RenderLayer.getCutout());

    // Particles
    ParticleFactoryRegistry.getInstance().register(ModParticles.FALLING_LEAVES_PARTICLE, FallingLeavesParticle.Factory::new);
    ParticleFactoryRegistry.getInstance().register(ModParticles.LUCI_MUSHROOM_PARTICLE, LuciMushroomBlockParticle.Factory::new);
    ParticleFactoryRegistry.getInstance().register(ModParticles.BLOSSOMING_FALLING_LEAVES, BlossomingFallingLeavesParticle.Factory::new);

    // Mobs
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRAB, CrabModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TURTLE, TurtleModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.TURTLE, TurtleRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BUTTERFLY, ButterflyModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.BUTTERFLY, ButterflyRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CATERPILLAR, CaterpillarModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.CATERPILLAR, CaterpillarRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHARK, SharkModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.SHARK, SharkRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RABBIT, RabbitModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.RABBIT, RabbitRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHRIMP, ShrimpModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.SHRIMP, ShrimpRenderer::new);

    // Wood
    TerraformBoatClientHelper.registerModelLayers(ModBoats.LUCI_BOAT_ID, false);

    // Handlers
    HandledScreens.register(ModScreenHandlers.CHOMPER_SCREEN_HANDLER, ChomperBlockScreen::new);
    }
  }
