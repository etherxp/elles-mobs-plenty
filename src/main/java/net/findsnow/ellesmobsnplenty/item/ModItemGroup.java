package net.findsnow.ellesmobsnplenty.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
  public static final ItemGroup ELLES_MOBS_N_PLENTY = Registry.register(Registries.ITEM_GROUP,
          new Identifier(EllesMobsNPlenty.MOD_ID, "elles_mobs_n_plenty"),
          FabricItemGroup.builder().displayName(Text.translatable("itemGroup.elles_mobs_n_plenty_group"))
                  .icon(() -> new ItemStack(ModItems.NEPHRITE)).entries((displayContext, entries) -> {
                    // Items
                    entries.add(ModItems.NEPHRITE);
                    entries.add(ModItems.RAW_NEPHRITE);
                    entries.add(ModItems.NEPHRITE_NUGGET);
                    entries.add(ModItems.NEPHRITE_PICKAXE);
                    entries.add(ModItems.NEPHRITE_AXE);
                    entries.add(ModItems.NEPHRITE_SHOVEL);
                    entries.add(ModItems.NEPHRITE_HOE);
                    entries.add(ModItems.NEPHRITE_SWORD);
                    entries.add(ModItems.NIGHT_TIME_MUSIC_DISC);


                    // Blocks
                    entries.add(ModBlocks.NEPHRITE_BLOCK);
                    entries.add(ModBlocks.RAW_NEPHRITE_BLOCK);
                    entries.add(ModBlocks.NEPHRITE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
                    entries.add(ModBlocks.GREEN_MUSHROOM_LAMP);
                    entries.add(ModBlocks.BLUE_MUSHROOM_LAMP);
                    entries.add(ModBlocks.CHOMPER_BLOCK);

                    // Luci Wood
                    entries.add(ModBlocks.LUCI_PLANKS);
                    entries.add(ModBlocks.LUCI_STAIRS);
                    entries.add(ModBlocks.LUCI_SLABS);
                    entries.add(ModBlocks.LUCI_BUTTON);
                    entries.add(ModBlocks.LUCI_PRESSURE_PLATE);
                    entries.add(ModBlocks.LUCI_FENCE);
                    entries.add(ModBlocks.LUCI_FENCE_GATE);
                    entries.add(ModBlocks.LUCI_WALL);
                    entries.add(ModBlocks.LUCI_DOOR);
                    entries.add(ModBlocks.LUCI_TRAPDOOR);
                    entries.add(ModBlocks.LUCI_LOG);
                    entries.add(ModBlocks.HOLLOW_LUCI_LOG);
                    entries.add(ModBlocks.STRIPPED_LUCI_LOG);
                    entries.add(ModBlocks.LUCI_LEAVES);
                    entries.add(ModBlocks.BLOSSOMING_LUCI_LEAVES);
                    entries.add(ModBlocks.STRIPPED_LUCI_WOOD);
                    entries.add(ModBlocks.LUCI_WOOD);
                    entries.add(ModBlocks.LUCI_SAPLING);
                  }).build());

  public static void registerItemGroups() {
    // I don't know what this does

  }
}
