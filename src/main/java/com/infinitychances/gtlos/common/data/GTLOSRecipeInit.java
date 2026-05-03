package com.infinitychances.gtlos.common.data;

import com.infinitychances.gtlos.data.recipe.PelletRecipes;
import com.klikli_dev.theurgy.registry.ItemRegistry;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;

public class GTLOSRecipeInit {
	public static void init(Consumer<FinishedRecipe> provider) {
		PelletRecipes.init(provider);
		doMercuryGen(provider);
	}

	public static void doMercuryGen(Consumer<FinishedRecipe> provider) {
		GTLOSRecipeTypes.MERCURY_GENERATING.recipeBuilder("shard").duration(200)
				.inputItems(ItemRegistry.MERCURY_SHARD.get())
				.EUt(-V[LV]).save(provider);

		GTLOSRecipeTypes.MERCURY_GENERATING.recipeBuilder("crystal").duration(200)
				.inputItems(ItemRegistry.MERCURY_CRYSTAL.get())
				.EUt(-V[LV]*4).save(provider);
	}
}
