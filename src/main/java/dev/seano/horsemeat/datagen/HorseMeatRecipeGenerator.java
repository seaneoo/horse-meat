package dev.seano.horsemeat.datagen;

import dev.seano.horsemeat.HorseMeatItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class HorseMeatRecipeGenerator extends FabricRecipeProvider {
    public HorseMeatRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateSmeltingRecipes(exporter);
        generateCraftingRecipes(exporter);
    }

    private void generateSmeltingRecipes(Consumer<RecipeJsonProvider> exporter) {
        final float EXPERIENCE = 0.35f; // How much experience is gained
        final int COOKING_TIME = 200; // Num. of ticks to "cook" (200 ticks is 10 seconds)

        offerFoodCookingRecipe(exporter, "furnace", RecipeSerializer.SMELTING, COOKING_TIME, HorseMeatItems.RAW_HORSE_MEAT, HorseMeatItems.COOKED_HORSE_MEAT, EXPERIENCE);
        offerFoodCookingRecipe(exporter, "smoker", RecipeSerializer.SMOKING, COOKING_TIME / 2, HorseMeatItems.RAW_HORSE_MEAT, HorseMeatItems.COOKED_HORSE_MEAT, EXPERIENCE);
        offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, COOKING_TIME / 2, HorseMeatItems.RAW_HORSE_MEAT, HorseMeatItems.COOKED_HORSE_MEAT, EXPERIENCE);
    }

    private void generateCraftingRecipes(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HorseMeatItems.HORSE_BURGER).input(HorseMeatItems.COOKED_HORSE_MEAT).input(Items.BREAD).criterion(hasItem(HorseMeatItems.COOKED_HORSE_MEAT), conditionsFromItem(HorseMeatItems.COOKED_HORSE_MEAT)).criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD)).offerTo(exporter);
    }
}