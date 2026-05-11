package com.infinitychances.gtlos.api.data.chemical.material.info;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class GTLOSMaterialFlags {
	public static final MaterialFlag GENERATE_VIAL = new MaterialFlag.Builder("generate_vial").requireProps(PropertyKey.FLUID).build();
}
