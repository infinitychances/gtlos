package com.infinitychances.gtlos.data.recipe;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.common.data.GTLOSItems;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.VA;

public class PelletRecipes {
	public static void init(Consumer<FinishedRecipe> provider) {
		GTLOSRecipeTypes.PELLET_DECOMPOSITIONING.recipeBuilder("oxygen").duration(100)
				.inputItems(GTLOSItems.OXYGEN_PELLET)
				.outputFluids(GTMaterials.Oxygen.getFluid(1000))
				.save(provider);
	}
}
