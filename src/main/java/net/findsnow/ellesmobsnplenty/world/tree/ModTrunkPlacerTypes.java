package net.findsnow.ellesmobsnplenty.world.tree;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.mixin.TrunkPlacerTypeInvoker;
import net.findsnow.ellesmobsnplenty.world.tree.custom.HollowLuciTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {

    public static final TrunkPlacerType<?> HOLLOW_LUCI_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("hollow_luci_trunk_placer",
            HollowLuciTrunkPlacer.CODEC);



    public static void register() {
        EllesMobsNPlenty.LOGGER.info("Registering trunk placers for " + EllesMobsNPlenty.MOD_ID);
    }
}
