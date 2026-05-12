package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKey;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.api.data.chemical.material.info.GTLOSMaterialFlags;

public class GTLOSMaterialMods {
	public static void changeTerbium() {
		GTMaterials.Terbium.setProperty(PropertyKey.INGOT, new IngotProperty());
		//GTMaterials.Terbium.setProperty(PropertyKey.BLAST, new BlastProperty.Builder().temp());
	}

	public static void addRubidium() {
		GTMaterials.Rubidium.setProperty(PropertyKey.INGOT, new IngotProperty());
		var temp = new FluidProperty();
		temp.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder().block().temperature(313).state(FluidState.LIQUID));
		GTMaterials.Rubidium.setProperty(PropertyKey.FLUID, temp);
		GTMaterials.Rubidium.addFlags(MaterialFlags.GENERATE_PLATE);
	}

	private static void radiumChanges() {
		var temp = new FluidProperty();
		temp.getStorage().enqueueRegistration(FluidStorageKeys.LIQUID, new FluidBuilder().block().temperature(973).state(FluidState.LIQUID));
		GTMaterials.Radium.setProperty(PropertyKey.FLUID, temp);
		GTMaterials.Radium.addFlags(GTLOSMaterialFlags.GENERATE_VIAL);
	}

	private static void basicVials() {
		GTMaterials.Thorium.addFlags(GTLOSMaterialFlags.GENERATE_VIAL);
	}

	public static void init() {
		changeTerbium();
		addRubidium();
		radiumChanges();
		basicVials();
	}
}
