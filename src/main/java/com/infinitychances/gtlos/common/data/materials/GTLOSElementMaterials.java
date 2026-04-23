package com.infinitychances.gtlos.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.common.data.GTElements;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.GTLOSCreativeModeTab;
import com.infinitychances.gtlos.common.data.GTLOSElements;

import static com.infinitychances.gtlos.common.data.GTLOSMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GTLOSElementMaterials {

	public static void register() {


		//LATE GAME
		Illonium = new Material.Builder(GTLOS.id("illonium"))
				.liquid(new FluidBuilder().temperature(288))
				.ingot()
				.color(0x75b842)
				.appendFlags(GTMaterials.EXT2_METAL, GENERATE_FINE_WIRE, GENERATE_GEAR, GENERATE_SMALL_GEAR)
				.element(GTLOSElements.Il)
				.cableProperties(V[OpV], 32,0, true)
				.iconSet(SHINY)
				.blast(b -> b.temp(10000, BlastProperty.GasTier.HIGHEST).blastStats(VA[UEV], 50).vacuumStats(VA[ZPM], 240))
				.buildAndRegister();

		EnrichedIllonium = new Material.Builder(GTLOS.id("enriched_illonium"))
				.liquid(new FluidBuilder().temperature(310))
				.color(0x81c54c)
				.element(GTLOSElements.Il1)
				.buildAndRegister();

		Spacium = new Material.Builder(GTLOS.id("spacium"))
				.liquid(new FluidBuilder().temperature(3))
				.ingot()
				.element(GTElements.Sp)
				.iconSet(ROUGH)
				.color(0x24273b)
				.buildAndRegister();

	}
}
