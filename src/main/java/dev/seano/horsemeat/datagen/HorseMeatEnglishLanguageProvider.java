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
	}
}
