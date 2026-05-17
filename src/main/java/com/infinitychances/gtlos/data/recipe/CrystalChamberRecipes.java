package com.infinitychances.gtlos.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.GTLOSRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.infinitychances.gtlos.common.util.Math.secondsToTicks;

public class CrystalChamberRecipes {
	public static void init(Consumer<FinishedRecipe> provider) {
		GTLOSRecipeTypes.CRYSTAL_GROWTH.recipeBuilder(GTLOS.id("amethyst_growing"))
				.inputItems(Items.AMETHYST_SHARD)
				.outputItems(new ItemStack(Items.AMETHYST_SHARD, 32))
				.EUt(GTValues.VA[GTValues.HV])
				.duration(secondsToTicks(16))
				.save(provider);
	}
}
