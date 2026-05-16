package com.infinitychances.gtlos.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.recipe.chance.logic.ChanceLogic;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.api.data.tag.GTLOSTagPrefixes;
import com.infinitychances.gtlos.common.data.GTLOSMaterials;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

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

	public static void makeItemChain(Consumer<FinishedRecipe> provider, MaterialEntry prev, MaterialEntry current, ItemStack side, int duration, long eu) {
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

		GTLOSRecipeTypes.DECAY_CHAIN.recipeBuilder("polonium-218_to_lead_and_astatine")
				.inputItems(new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Polonium218))
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead214, 9995, 0)
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Astatine218, 5, 0) //real is .02%
				.chancedItemOutputLogic(ChanceLogic.XOR)
				.EUt(GTValues.VA[GTValues.UEV])
				.duration(secondsToTicks(40))
				.save(provider);


		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead214),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Bismuth214),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Astatine218),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Bismuth214),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		GTLOSRecipeTypes.DECAY_CHAIN.recipeBuilder("bismuth-214_to_polonium_and_thallium")
				.inputItems(new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Bismuth214))
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Polonium214, 9995, 0)
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Thallium210, 5, 0) //real is .02%
				.chancedItemOutputLogic(ChanceLogic.XOR)
				.EUt(GTValues.VA[GTValues.UEV])
				.duration(secondsToTicks(40))
				.save(provider);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Thallium210),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead210),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Polonium214),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead210),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		GTLOSRecipeTypes.DECAY_CHAIN.recipeBuilder("lead-210_to_bismuth_and_mercury")
				.inputItems(new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead210))
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Bismuth210, 9998, 0)
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Mercury206, 2, 0) //Real <.01%
				.chancedItemOutputLogic(ChanceLogic.XOR)
				.EUt(GTValues.VA[GTValues.UEV])
				.duration(secondsToTicks(40))
				.save(provider);

		GTLOSRecipeTypes.DECAY_CHAIN.recipeBuilder("bismuth-210_to_polonium_and_thallium")
				.inputItems(new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Bismuth210))
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Polonium210, 9999, 0)
				.chancedOutput(GTLOSTagPrefixes.vial, GTLOSMaterials.Thallium206, 1, 0) //Real <.01%
				.chancedItemOutputLogic(ChanceLogic.XOR)
				.EUt(GTValues.VA[GTValues.UEV])
				.duration(secondsToTicks(40))
				.save(provider);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Mercury206),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Thallium206),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Polonium210),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead206),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);

		makeItemChain(provider,
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Thallium206),
				new MaterialEntry(GTLOSTagPrefixes.vial, GTLOSMaterials.Lead206),
				secondsToTicks(40), GTValues.VA[GTValues.UEV]);
	}
}
