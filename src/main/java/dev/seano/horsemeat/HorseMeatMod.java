package dev.seano.horsemeat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class HorseMeatMod implements ModInitializer {
    public static final String MOD_ID = "horsemeat";
//    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item RAW_HORSE_MEAT = new Item(new FabricItemSettings().food(FoodComponents.BEEF));
    public static final Item COOKED_HORSE_MEAT = new Item(new FabricItemSettings().food(FoodComponents.COOKED_BEEF));

    public static final Identifier HORSE_LOOT_TABLE = EntityType.HORSE.getLootTableId();

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, id("raw_horse_meat"), RAW_HORSE_MEAT);
        Registry.register(Registries.ITEM, id("cooked_horse_meat"), COOKED_HORSE_MEAT);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.COOKED_BEEF, RAW_HORSE_MEAT);
            content.addAfter(RAW_HORSE_MEAT, COOKED_HORSE_MEAT);
        });

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin()) {
//                Add RAW_HORSE_MEAT to HORSE loot table
                if (HORSE_LOOT_TABLE.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(RAW_HORSE_MEAT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))));
                    tableBuilder.pool(poolBuilder);
                }

//                Add RAW_HORSE_MEAT to VILLAGE_BUTCHER_CHEST loot table
                if (LootTables.VILLAGE_BUTCHER_CHEST.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(RAW_HORSE_MEAT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))).weight(6));
                    tableBuilder.pool(poolBuilder);
                }
            }
        }));

//        Add RAW_HORSE_MEAT to BUTCHER trades
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 2, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(COOKED_HORSE_MEAT, 4), 16, 5, 0.05f));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, factories -> {
            factories.add((entity, random) -> new TradeOffer(new ItemStack(RAW_HORSE_MEAT, 7), new ItemStack(Items.EMERALD, 1), 16, 20, 0.05f));
        });
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}