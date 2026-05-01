package com.infinitychances.gtlos.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.infinitychances.gtlos.GTLOS;
import net.minecraft.world.item.Items;

import static com.infinitychances.gtlos.common.data.GTLOSMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;

public class GTLOSSecondDegreeMaterials {

	public static void register() {
		Fluix = new Material.Builder(GTLOS.id("fluix")).gem().color(0x9D66BD).secondaryColor(0x7D35A3).iconSet(CERTUS)
				.flags(GENERATE_PLATE, NO_SMELTING, CRYSTALLIZABLE, DISABLE_DECOMPOSITION)
				.components(GTMaterials.CertusQuartz, 1, GTMaterials.Redstone, 1, GTMaterials.Quartzite, 1).buildAndRegister();
	}
}
