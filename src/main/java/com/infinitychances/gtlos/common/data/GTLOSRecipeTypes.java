package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;


import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class GTLOSRecipeTypes {
	public static void init() {}

	public static final String SPACE = "space";
	public static final GTRecipeType PELLET_DECOMPOSITIONING = register("pellet_decompositioning", SPACE)
			.setMaxIOSize(1, 0, 0,1)
			.setEUIO(IO.IN)
			.setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
			.setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
			.setSound(GTSoundEntries.CENTRIFUGE);
}
