package dev.seano.horsemeat.datagen;

import dev.seano.horsemeat.HorseMeatItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Items;

public class HorseMeatModelProvider extends FabricModelProvider {
	public HorseMeatModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(HorseMeatItems.RAW_HORSE_MEAT, Items.BEEF, Models.GENERATED);
		itemModelGenerator.register(HorseMeatItems.COOKED_HORSE_MEAT, Items.COOKED_BEEF, Models.GENERATED);
		itemModelGenerator.register(HorseMeatItems.RAW_LLAMA_MEAT, Items.BEEF, Models.GENERATED);
		itemModelGenerator.register(HorseMeatItems.COOKED_LLAMA_MEAT, Items.COOKED_BEEF, Models.GENERATED);
		itemModelGenerator.register(HorseMeatItems.HORSE_BURGER, Models.GENERATED);
	}
}
