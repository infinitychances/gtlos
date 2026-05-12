package com.infinitychances.gtlos.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.recipe.chance.logic.ChanceLogic;
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
		//Main thorium is 230
		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Thorium228),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTMaterials.Radium),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeUraniumSeries(provider);
	}

	private static void makeUraniumSeries(Consumer<FinishedRecipe> provider) {
		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTMaterials.Uranium238),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Thorium234),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Thorium234),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Protactinium234),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Protactinium234),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Uranium234),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Uranium234),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTMaterials.Thorium),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTMaterials.Thorium),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Radium226),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Radium226),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Radon222),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Radon222),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Polonium218),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		GTLOSRecipeTypes.DECAY_CHAIN.recipeBuilder("polonium-218_to_astatine_and_lead")
				.inputItems(new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Polonium218))
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead214, 2, 0)
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Astatine218, 9998, 0)
				.chancedItemOutputLogic(ChanceLogic.XOR)
				.EUt(GTValues.VA[GTValues.UEV])
				.duration(secondsToTicks(40))
				.save(provider);
	}
}
