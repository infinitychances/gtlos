package com.infinitychances.gtlos.api.data.tag;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.infinitychances.gtlos.api.data.chemical.material.info.GTLOSMaterialFlags;
import com.infinitychances.gtlos.api.data.chemical.material.info.GTLOSMaterialIconTypes;

public class GTLOSTagPrefixes {
	public static void init() {

	}

	public static final TagPrefix vial = new TagPrefix("vial")
			.idPattern("%s_vial")
			.defaultTagPath("vials/%s")
			.unformattedTagPath("vial")
			.langValue("%s Vial")
			.generateItem(true)
			.generationCondition(mat -> mat.hasFlag(GTLOSMaterialFlags.GENERATE_VIAL))
			.materialIconType(GTLOSMaterialIconTypes.vial);
}
