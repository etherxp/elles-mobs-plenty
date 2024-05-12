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
                    entries.add(ModItems.NIGHT_TIME_MUSIC_DISC);


                    // Blocks
                    entries.add(ModBlocks.NEPHRITE_BLOCK);
                    entries.add(ModBlocks.RAW_NEPHRITE_BLOCK);
                    entries.add(ModBlocks.NEPHRITE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
                    entries.add(ModBlocks.GREEN_MUSHROOM_LAMP);
                    entries.add(ModBlocks.BLUE_MUSHROOM_LAMP);
                    entries.add(ModBlocks.CHOMPER_BLOCK);

                    // Lucero Wood
                    entries.add(ModBlocks.LUCERO_PLANKS);
                    entries.add(ModBlocks.LUCERO_STAIRS);
                    entries.add(ModBlocks.LUCERO_SLABS);
                    entries.add(ModBlocks.LUCERO_BUTTON);
                    entries.add(ModBlocks.LUCERO_PRESSURE_PLATE);
                    entries.add(ModBlocks.LUCERO_FENCE);
                    entries.add(ModBlocks.LUCERO_FENCE_GATE);
                    entries.add(ModBlocks.LUCERO_WALL);
                    entries.add(ModBlocks.LUCERO_DOOR);
                    entries.add(ModBlocks.LUCERO_TRAPDOOR);
                    entries.add(ModBlocks.LUCERO_LOG);
                    entries.add(ModBlocks.STRIPPED_LUCERO_LOG);
                    entries.add(ModBlocks.LUCERO_LEAVES);
                    entries.add(ModBlocks.STRIPPED_LUCERO_WOOD);
                    entries.add(ModBlocks.LUCERO_WOOD);
                    entries.add(ModBlocks.LUCERO_SAPLING);
                  }).build());

  public static void registerItemGroups() {
    // idk what this does

  }
}
