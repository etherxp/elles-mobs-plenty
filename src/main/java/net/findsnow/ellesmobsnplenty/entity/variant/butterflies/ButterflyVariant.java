package net.findsnow.ellesmobsnplenty.entity.variant.butterflies;
import com.mojang.serialization.Codec;
import net.minecraft.entity.passive.HorseColor;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public enum ButterflyVariant implements StringIdentifiable {
    GREEN(0, "green"),
    BLUE(1, "blue"),
    ORANGE(2, "orange"),
    PURPLE(3, "purple"),
    RED(4, "red");

    public static final Codec<ButterflyVariant> CODEC = StringIdentifiable.createCodec(ButterflyVariant::values);
    private static final IntFunction<ButterflyVariant> BY_ID = ValueLists.createIdToValueFunction(ButterflyVariant::getId, values(),
            ValueLists.OutOfBoundsHandling.WRAP);
    private final int id;
    private final String name;

    ButterflyVariant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public static ButterflyVariant byId(int id) {
        return BY_ID.apply(id);
    }

    @Override
    public String asString() {
        return this.name;
    }
}
