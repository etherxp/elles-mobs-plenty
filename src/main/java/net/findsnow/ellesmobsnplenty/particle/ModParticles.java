package net.findsnow.ellesmobsnplenty.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType FALLING_LEAVES_PARTICLE =
            registerParticle("falling_leaves_particle", FabricParticleTypes.simple());
    public static final SimpleParticleType BLOSSOMING_FALLING_LEAVES =
            registerParticle("blossoming_falling_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType LUCI_MUSHROOM_PARTICLE =
            registerParticle("luci_mushroom_particle", FabricParticleTypes.simple());

    public static final SimpleParticleType FIREFLY =
            registerParticle("firefly", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(EllesMobsNPlenty.MOD_ID, name), particleType);
    }

    public static void RegisterParticles() {
        EllesMobsNPlenty.LOGGER.info("Registering particles for " + EllesMobsNPlenty.MOD_ID);
    }
}
