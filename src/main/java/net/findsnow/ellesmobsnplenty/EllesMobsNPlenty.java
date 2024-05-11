package net.findsnow.ellesmobsnplenty;

import net.fabricmc.api.ModInitializer;

import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItemGroup;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.findsnow.ellesmobsnplenty.sound.ModSounds;
import net.findsnow.ellesmobsnplenty.util.ModRegistries;
import net.findsnow.ellesmobsnplenty.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EllesMobsNPlenty implements ModInitializer {
	public static final String MOD_ID = "ellesmobsnplenty";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.RegisterModStuff();
		ModWorldGeneration.generatorModWorldGeneration();
		ModParticles.RegisterParticles();
		ModSounds.registerSounds();
	}
}