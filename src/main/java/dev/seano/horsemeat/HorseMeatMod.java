package dev.seano.horsemeat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HorseMeatMod implements ModInitializer {
    public static final String MOD_ID = "horsemeat";
//    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item RAW_HORSE_MEAT = new Item(new FabricItemSettings().food(FoodComponents.BEEF));
    public static final Item COOKED_HORSE_MEAT = new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF));

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, id("raw_horse_meat"), RAW_HORSE_MEAT);
        Registry.register(Registries.ITEM, id("cooked_horse_meat"), COOKED_HORSE_MEAT);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.COOKED_BEEF, RAW_HORSE_MEAT);
            content.addAfter(RAW_HORSE_MEAT, COOKED_HORSE_MEAT);
        });
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}