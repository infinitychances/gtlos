package com.infinitychances.gtlos.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.api.data.tag.GTLOSTagPrefixes;
import com.infinitychances.gtlos.common.data.GTLOSMaterials;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;
import static com.infinitychances.gtlos.common.util.Math.*;

public class DecayChainRecipes {
	public static void makeItemChain(Consumer<FinishedRecipe> provider, MaterialEntry prev, MaterialEntry current, int duration, long eu) {
		GTLOSRecipeTypes.DECAY_CHAIN.recipeBuilder(prev.material().getResourceLocation().getPath() + "_to_" + current.material().getResourceLocation().getPath())
				.inputItems(prev)
				.outputItems(current)
				.EUt(eu)
				.duration(duration)
				.save(provider);
	}

	public static void init(Consumer<FinishedRecipe> provider) {
		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Thorium228),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTMaterials.Radium),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);
	}
}
