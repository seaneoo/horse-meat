package dev.seano.horsemeat;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class HorseMeatItems {

	public static final FoodComponent RAW_HORSE_MEAT_FOOD = new FoodComponent.Builder().hunger(3)
			.saturationModifier(0.3f).meat().build();
	public static final FoodComponent COOKED_HORSE_MEAT_FOOD = new FoodComponent.Builder().hunger(8)
			.saturationModifier(0.8f).meat().build();
	public static final FoodComponent HORSE_BURGER_FOOD = new FoodComponent.Builder().hunger(10)
			.saturationModifier(0.8f).build();

	public static final Item RAW_HORSE_MEAT = new Item(new FabricItemSettings().food(RAW_HORSE_MEAT_FOOD));
	public static final Item COOKED_HORSE_MEAT = new Item(new FabricItemSettings().food(COOKED_HORSE_MEAT_FOOD));
	public static final Item RAW_LLAMA_MEAT = new Item(new FabricItemSettings().food(RAW_HORSE_MEAT_FOOD));
	public static final Item COOKED_LLAMA_MEAT = new Item(new FabricItemSettings().food(COOKED_HORSE_MEAT_FOOD));
	public static final Item HORSE_BURGER = new Item(new FabricItemSettings().food(HORSE_BURGER_FOOD));

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder().icon(RAW_HORSE_MEAT::getDefaultStack)
			.displayName(Text.translatable("itemGroup.horsemeat.group")).entries((displayContext, entries) -> {
				entries.add(RAW_HORSE_MEAT);
				entries.add(COOKED_HORSE_MEAT);
				entries.add(RAW_LLAMA_MEAT);
				entries.add(COOKED_LLAMA_MEAT);
				entries.add(HORSE_BURGER);
			}).build();

	public static void registerItems() {
		HorseMeatMod.LOGGER.info("Registering items");

		Registry.register(Registries.ITEM, HorseMeatMod.id("raw_horse_meat"), RAW_HORSE_MEAT);
		Registry.register(Registries.ITEM, HorseMeatMod.id("cooked_horse_meat"), COOKED_HORSE_MEAT);
		Registry.register(Registries.ITEM, HorseMeatMod.id("raw_llama_meat"), RAW_LLAMA_MEAT);
		Registry.register(Registries.ITEM, HorseMeatMod.id("cooked_llama_meat"), COOKED_LLAMA_MEAT);
		Registry.register(Registries.ITEM, HorseMeatMod.id("horse_burger"), HORSE_BURGER);
		Registry.register(Registries.ITEM_GROUP, HorseMeatMod.id("group"), ITEM_GROUP);
	}
}
