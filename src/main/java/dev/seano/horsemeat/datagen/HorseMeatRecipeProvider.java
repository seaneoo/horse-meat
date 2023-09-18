package dev.seano.horsemeat.datagen;

import dev.seano.horsemeat.HorseMeatItems;

import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class HorseMeatRecipeProvider extends FabricRecipeProvider {
	public HorseMeatRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(RecipeExporter exporter) {
		generateSmeltingRecipes(exporter);
		generateCraftingRecipes(exporter);
	}

	private void generateSmeltingRecipes(RecipeExporter exporter) {
		final float EXPERIENCE = 0.35f; // How much experience is gained
		final int COOKING_TIME = 200; // Num. of ticks to "cook" (200 ticks is 10 seconds)

		// Add furnace/smoker/campfire recipes for horse meat
		offerFoodCookingRecipe(exporter, "furnace", RecipeSerializer.SMELTING, COOKING_TIME,
				HorseMeatItems.RAW_HORSE_MEAT, HorseMeatItems.COOKED_HORSE_MEAT, EXPERIENCE);
		offerFoodCookingRecipe(exporter, "smoker", RecipeSerializer.SMOKING, COOKING_TIME / 2,
				HorseMeatItems.RAW_HORSE_MEAT, HorseMeatItems.COOKED_HORSE_MEAT, EXPERIENCE);
		offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, COOKING_TIME / 2,
				HorseMeatItems.RAW_HORSE_MEAT, HorseMeatItems.COOKED_HORSE_MEAT, EXPERIENCE);

		// Add furnace/smoker/campfire recipes for llama meat
		offerFoodCookingRecipe(exporter, "furnace", RecipeSerializer.SMELTING, COOKING_TIME,
				HorseMeatItems.RAW_LLAMA_MEAT, HorseMeatItems.COOKED_LLAMA_MEAT, EXPERIENCE);
		offerFoodCookingRecipe(exporter, "smoker", RecipeSerializer.SMOKING, COOKING_TIME / 2,
				HorseMeatItems.RAW_LLAMA_MEAT, HorseMeatItems.COOKED_LLAMA_MEAT, EXPERIENCE);
		offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, COOKING_TIME / 2,
				HorseMeatItems.RAW_LLAMA_MEAT, HorseMeatItems.COOKED_LLAMA_MEAT, EXPERIENCE);
	}

	private void generateCraftingRecipes(RecipeExporter exporter) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HorseMeatItems.HORSE_BURGER)
				.input(HorseMeatItems.COOKED_HORSE_MEAT).input(Items.BREAD)
				.criterion(hasItem(HorseMeatItems.COOKED_HORSE_MEAT),
						conditionsFromItem(HorseMeatItems.COOKED_HORSE_MEAT))
				.criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD)).offerTo(exporter);
	}
}
