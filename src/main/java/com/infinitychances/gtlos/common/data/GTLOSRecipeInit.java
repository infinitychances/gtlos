package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.infinitychances.gtlos.api.PollutionroomTypes;
import com.infinitychances.gtlos.data.recipe.CrystalChamberRecipes;
import com.infinitychances.gtlos.data.recipe.DecayChainRecipes;
import com.infinitychances.gtlos.data.recipe.PelletRecipes;
import com.klikli_dev.theurgy.registry.ItemRegistry;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;

public class GTLOSRecipeInit {
	public static void init(Consumer<FinishedRecipe> provider) {
		PelletRecipes.init(provider);
		DecayChainRecipes.init(provider);
		CrystalChamberRecipes.init(provider);
		doMercuryGen(provider);
	}

	public static void doMercuryGen(Consumer<FinishedRecipe> provider) {
		GTLOSRecipeTypes.MERCURY_GENERATING.recipeBuilder("shard").duration(200)
				.inputItems(ItemRegistry.MERCURY_SHARD.get())
				.EUt(-V[LV]).save(provider);

		GTLOSRecipeTypes.MERCURY_GENERATING.recipeBuilder("crystal").duration(200)
				.inputItems(ItemRegistry.MERCURY_CRYSTAL.get())
				.EUt(-V[LV]*4).save(provider);

		/*GTRecipeTypes.ASSEMBLY_LINE_RECIPES.recipeBuilder("t")
				.inputItems(new MaterialEntry(TagPrefix.ingot, GTMaterials.Aluminium))
				.inputItems(GTLOSItems.OXYGEN_PELLET)
				.inputFluids(GTMaterials.SolderingAlloy.getFluid(144))
				.outputItems(new MaterialEntry(TagPrefix.plate, GTMaterials.Aluminium))
				.stationResearch((b) -> b.researchStack(GTLOSItems.OXYGEN_PELLET.asStack()).dataStack(GTItems.TOOL_DATA_MODULE.asStack()).CWUt(32).EUt(8, 4)).duration(100).EUt(128, 2).save(provider);*/
	}
}
