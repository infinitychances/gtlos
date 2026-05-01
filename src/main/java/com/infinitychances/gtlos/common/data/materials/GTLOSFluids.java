package com.infinitychances.gtlos.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.GTLOSCreativeModeTab;

import static com.infinitychances.gtlos.common.data.GTLOSMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;


public class GTLOSFluids {
	public static void register() {
		BioSolder = new Material.Builder(GTLOS.id("bio_solder"))
				.ingot(1)
				.liquid(new FluidBuilder().temperature(970))
				.color(0x227017).secondaryColor(0x197561/*0x13594a*/)
				.buildAndRegister();

	}
}
