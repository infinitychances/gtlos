package com.infinitychances.gtlos.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.infinitychances.gtlos.GTLOS;
import com.infinitychances.gtlos.common.data.materials.GTLOSElementMaterials;
import com.infinitychances.gtlos.common.data.materials.GTLOSFirstDegreeMaterials;
import com.infinitychances.gtlos.common.data.materials.GTLOSFluids;
import com.infinitychances.gtlos.common.data.materials.GTLOSSecondDegreeMaterials;

public class GTLOSMaterials {
	public static void init() {
		GTLOS.REGISTRATE.creativeModeTab(() -> GTLOSCreativeModeTab.MAIN);
		GTLOSElementMaterials.register();
		GTLOSFirstDegreeMaterials.register();
		GTLOSSecondDegreeMaterials.register();
		GTLOSFluids.register();
	}

	//Chemicals/Fluids
	public static Material BioSolder;
	public static Material Polypropylene;
	public static Material PropyleneGas;


	//Element Materials
	public static Material Illonium;
	public static Material EnrichedIllonium;
	public static Material UnstableIllonium;
	public static Material Spacium;

	//First Degree Materials
	public static Material ChargedCertusQuartz;

	//Second Degree Materials
	public static Material Fluix;

	//Thorium Series
	public static Material Thorium228;

	//Uranium Series
	public static Material Thorium234;
	public static Material Protactinium234;
	public static Material Uranium234;
	public static Material Radium226;
	public static Material Radon222;
	public static Material Polonium218;
	public static Material Lead214;
	public static Material Bismuth214;
	public static Material Polonium214;
	public static Material Lead210;
	public static Material Bismuth210;
	public static Material Polonium210;
	public static Material Lead206;
	public static Material Astatine218;
	public static Material Thallium210;
	public static Material Mercury206;
	public static Material Thallium206;
}
