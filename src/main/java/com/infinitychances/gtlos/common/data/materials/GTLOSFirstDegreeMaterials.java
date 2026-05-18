package com.infinitychances.gtlos.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.GTLOS;

import static com.infinitychances.gtlos.common.data.GTLOSMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GTLOSFirstDegreeMaterials {
	public static void register() {
		ChargedCertusQuartz = new Material.Builder(GTLOS.id("charged_certus_quartz"))
				.gem()
				.color(0x8EDFDB)
				.iconSet(CERTUS)
				.flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
				.components(GTMaterials.CertusQuartz, 1, PositivelyCharged, 1)
				//.formula("(SiO2)+", true)
				.register();
	}
}
