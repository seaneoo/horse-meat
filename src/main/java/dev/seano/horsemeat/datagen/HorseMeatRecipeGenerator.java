package dev.seano.horsemeat.datagen;

import dev.seano.horsemeat.HorseMeatMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.RecipeSerializer;

import java.util.function.Consumer;

public class HorseMeatRecipeGenerator extends FabricRecipeProvider {
    public HorseMeatRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateSmeltingRecipes(exporter);
    }

    private void generateSmeltingRecipes(Consumer<RecipeJsonProvider> exporter) {
        final float EXPERIENCE = 0.35f; // How much experience is gained
        final int COOKING_TIME = 200; // Num. of ticks to "cook" (200 ticks is 10 seconds)

        offerFoodCookingRecipe(exporter, "furnace", RecipeSerializer.SMELTING, COOKING_TIME, HorseMeatMod.RAW_HORSE_MEAT, HorseMeatMod.COOKED_HORSE_MEAT, EXPERIENCE);
        offerFoodCookingRecipe(exporter, "smoker", RecipeSerializer.SMOKING, COOKING_TIME / 2, HorseMeatMod.RAW_HORSE_MEAT, HorseMeatMod.COOKED_HORSE_MEAT, EXPERIENCE);
        offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING, COOKING_TIME / 2, HorseMeatMod.RAW_HORSE_MEAT, HorseMeatMod.COOKED_HORSE_MEAT, EXPERIENCE);
    }
}