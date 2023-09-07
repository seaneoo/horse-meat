package dev.seano.horsemeat;

import dev.seano.horsemeat.datagen.HorseMeatEnglishLanguageProvider;
import dev.seano.horsemeat.datagen.HorseMeatModelProvider;
import dev.seano.horsemeat.datagen.HorseMeatRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class HorseMeatModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(HorseMeatModelProvider::new);
		pack.addProvider(HorseMeatRecipeProvider::new);
		pack.addProvider(HorseMeatEnglishLanguageProvider::new);
	}
}
