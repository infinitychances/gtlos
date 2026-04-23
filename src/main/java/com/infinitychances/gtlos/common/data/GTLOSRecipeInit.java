package com.infinitychances.gtlos.common.data;

import com.infinitychances.gtlos.data.recipe.PelletRecipes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class GTLOSRecipeInit {
	public static void init(Consumer<FinishedRecipe> provider) {
		PelletRecipes.init(provider);
	}
}
