package net.findsnow.ellesmobsnplenty.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

  public static final Item NEPHRITE = registerItem("nephrite",
          new Item(new FabricItemSettings()));
  public static final Item RAW_NEPHRITE = registerItem("raw_nephrite",
          new Item(new FabricItemSettings()));
  public static final Item NEPHRITE_NUGGET = registerItem("nephrite_nugget",
          new Item(new FabricItemSettings()));
  public static final Item NIGHT_TIME_MUSIC_DISC = registerItem("night_time_music_disc",
          new MusicDiscItem(9, ModSounds.NIGHT_TIME, new FabricItemSettings().maxCount(1), 156));


  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(EllesMobsNPlenty.MOD_ID, name), item);
  }

  private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    //ITEMS
    entries.add(NEPHRITE);
    entries.add(RAW_NEPHRITE);
    entries.add(NEPHRITE_NUGGET);

    //BLOCKS
    entries.add(ModBlocks.NEPHRITE_BLOCK);
    entries.add(ModBlocks.RAW_NEPHRITE_BLOCK);
    entries.add(ModBlocks.NEPHRITE_ORE);
    entries.add(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
    entries.add(ModBlocks.CHOMPER_BLOCK);
    entries.add(ModBlocks.LUCERO_PLANKS);
    entries.add(ModBlocks.LUCERO_STAIRS);
    entries.add(ModBlocks.LUCERO_WALL);
  }


  public static void registerModItems() {
    EllesMobsNPlenty.LOGGER.info("Registering mod items for " + EllesMobsNPlenty.MOD_ID);
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
  }



}
