package dev.seano.horsemeat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HorseMeatMod implements ModInitializer {
    public static final String MOD_ID = "horsemeat";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        HorseMeatItems.registerItems();
        modifyLootTables();
        modifyTrades();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    private void modifyLootTables() {
        final Identifier HORSE_LOOT_TABLE = EntityType.HORSE.getLootTableId();

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin()) {
                // Add RAW_HORSE_MEAT to HORSE loot table
                if (HORSE_LOOT_TABLE.equals(id)) {
                    LOGGER.info(String.format("Modifying loot table %s", HORSE_LOOT_TABLE));

                    LootFunction.Builder functionbuilder = SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3));
                    LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(HorseMeatItems.RAW_HORSE_MEAT).apply(functionbuilder));
                    tableBuilder.pool(poolBuilder);
                }
                // Add RAW_HORSE_MEAT to VILLAGE_BUTCHER_CHEST loot table
                if (LootTables.VILLAGE_BUTCHER_CHEST.equals(id)) {
                    LOGGER.info(String.format("Modifying loot table %s", LootTables.VILLAGE_BUTCHER_CHEST));

                    LootFunction.Builder functionBuilder = SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3));
                    LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(HorseMeatItems.RAW_HORSE_MEAT).apply(functionBuilder).weight(6));
                    tableBuilder.pool(poolBuilder);
                }
            }
        }));
    }

    private void modifyTrades() {
        LOGGER.info(String.format("Modifying %s trades", VillagerProfession.BUTCHER.toString()));

        final int MAX_USES = 16; // The max num. of times the trade can be performed
        final float PRICE_MULTI = 0.05f; // How the cost of the trade fluctuates

        // Add COOKED_HORSE_MEAT to BUTCHER trades
        // Add COOKED_HORSE_MEAT to BUTCHER trades
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 2, factories -> factories.add((entity, random) -> new TradeOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(HorseMeatItems.COOKED_HORSE_MEAT, 4), MAX_USES, 5, PRICE_MULTI)));
        // Add RAW_HORSE_MEAT to BUTCHER trades
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, factories -> factories.add((entity, random) -> new TradeOffer(new ItemStack(HorseMeatItems.RAW_HORSE_MEAT, 7), new ItemStack(Items.EMERALD, 1), MAX_USES, 20, PRICE_MULTI)));
    }
}