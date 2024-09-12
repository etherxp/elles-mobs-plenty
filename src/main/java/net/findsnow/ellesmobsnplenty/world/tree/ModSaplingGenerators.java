package net.findsnow.ellesmobsnplenty.world.tree;

import net.findsnow.ellesmobsnplenty.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator LUCI =
            new SaplingGenerator("luci", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.LUCERO_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
    public static final SaplingGenerator BLOSSOMING_LUCI =
            new SaplingGenerator("blossoming_luci", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.BLOSSOMING_LUCI_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
