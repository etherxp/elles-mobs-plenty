package net.findsnow.ellesmobsnplenty.block.entity;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record ChomperBlockEntityData(BlockPos pos) {
  public static final PacketCodec<RegistryByteBuf, ChomperBlockEntityData> PACKET_CODEC =
          PacketCodec.tuple(BlockPos.PACKET_CODEC, ChomperBlockEntityData::pos, ChomperBlockEntityData::new);
}
