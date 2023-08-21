package dev.seano.horsemeat;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class HorseMeatItems {

    public static final FoodComponent RAW_HORSE_MEAT_FOOD = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).meat().build();
    public static final FoodComponent COOKED_HORSE_MEAT_FOOD = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).meat().build();

    public static final Item RAW_HORSE_MEAT = new Item(new FabricItemSettings().food(RAW_HORSE_MEAT_FOOD));
    public static final Item COOKED_HORSE_MEAT = new Item(new FabricItemSettings().food(COOKED_HORSE_MEAT_FOOD));

    @SuppressWarnings("UnstableApiUsage")
    public static void registerItems() {
        HorseMeatMod.LOGGER.info("Registering items");

        Registry.register(Registries.ITEM, HorseMeatMod.id("raw_horse_meat"), RAW_HORSE_MEAT);
        Registry.register(Registries.ITEM, HorseMeatMod.id("cooked_horse_meat"), COOKED_HORSE_MEAT);

        // Add the items to the FOOD_AND_DRINK item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.COOKED_BEEF, RAW_HORSE_MEAT);
            content.addAfter(RAW_HORSE_MEAT, COOKED_HORSE_MEAT);
        });
    }
}
