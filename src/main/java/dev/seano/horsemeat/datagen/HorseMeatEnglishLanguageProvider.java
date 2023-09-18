package dev.seano.horsemeat.datagen;

import dev.seano.horsemeat.HorseMeatItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class HorseMeatEnglishLanguageProvider extends FabricLanguageProvider {
	public HorseMeatEnglishLanguageProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		translationBuilder.add(HorseMeatItems.RAW_HORSE_MEAT, "Raw Horse Meat");
		translationBuilder.add(HorseMeatItems.COOKED_HORSE_MEAT, "Cooked Horse Meat");
		translationBuilder.add(HorseMeatItems.RAW_LLAMA_MEAT, "Raw Llama Meat");
		translationBuilder.add(HorseMeatItems.COOKED_LLAMA_MEAT, "Cooked Llama Meat");
		translationBuilder.add(HorseMeatItems.HORSE_BURGER, "Horse Meat Burger");
		translationBuilder.add("itemGroup.horsemeat.group", "Horse Meat");
		translationBuilder.add("horsemeat.midnightconfig.category.horse", "Horse meat");
		translationBuilder.add("horsemeat.midnightconfig.category.llama", "Llama meat");
		translationBuilder.add("horsemeat.midnightconfig.horseButcherChests", "Butcher chests");
		translationBuilder.add("horsemeat.midnightconfig.horseButcherTrades", "Butcher trades");
		translationBuilder.add("horsemeat.midnightconfig.horseDrop", "Drop");
		translationBuilder.add("horsemeat.midnightconfig.llamaButcherChests", "Butcher chests");
		translationBuilder.add("horsemeat.midnightconfig.llamaButcherTrades", "Butcher trades");
		translationBuilder.add("horsemeat.midnightconfig.llamaDrop", "Drop");
	}
}
