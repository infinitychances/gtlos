package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.materials.GTLOSElementMaterials;
import com.infinitychances.gtlos.common.data.materials.GTLOSFluids;
import com.infinitychances.gtlos.common.data.materials.GTLOSSecondDegreeMaterials;

public class GTLOSMaterials {
	public static void init() {
		GTLOS.REGISTRATE.creativeModeTab(() -> GTLOSCreativeModeTab.MAIN);
		GTLOSElementMaterials.register();
		GTLOSFluids.register();
		GTLOSSecondDegreeMaterials.register();
	}

	//Chemicals/Fluids
	public static Material BioSolder;
	public static Material Polypropylene;
	public static Material PropyleneGas;


	//Element Materials
	public static Material Thorium228;
	public static Material Illonium;
	public static Material EnrichedIllonium;
	public static Material UnstableIllonium;
	public static Material Spacium;

	//Second Degree Materials
	public static Material Fluix;
}
