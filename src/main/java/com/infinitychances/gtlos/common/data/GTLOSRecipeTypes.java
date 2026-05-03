package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.infinitychances.gtlos.GTLOS;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

@SuppressWarnings("deprecation")
public class GTLOSRecipeTypes {
	public static void init() {}

	public static final String SPACE = "space";
	public static final GTRecipeType PELLET_DECOMPOSITIONING = register("pellet_decompositioning", SPACE)
			.setMaxIOSize(1, 0, 0,1)
			.setEUIO(IO.IN)
			.setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
			.setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressTexture.FillDirection.LEFT_TO_RIGHT);
	public static final GTRecipeType MERCURY_GENERATING = register("mercury_generating", GTRecipeTypes.GENERATOR)
			.setMaxIOSize(1,0,0,0)
			.setEUIO(IO.OUT)
			.setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY_2)
			.setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
			.setSound(GTSoundEntries.BOILER);


	public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
		GTRecipeType recipeType = new GTRecipeType(GTLOS.id(name), group, proxyRecipes);
		GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
		GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
		GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
		return recipeType;
	}
}
